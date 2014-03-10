/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * An immutable registry around a single element type.  Holds all of the
 * transforms and adaptations for that type and for any attributes on the type.
 * Child elements are retrieved through the root registry.
 *
 * 
 */
final class ElementMetadataRegistry {

  // The root Schema this element registry is part of.
  private final Schema schema;

  // A map of transform key to the transformed builder at that key.
  private final Map<TransformKey, ElementTransform> transforms;

  // A cache of derived metadata, so we only generate them once.
  private final ConcurrentMap<TransformKey, ElementMetadata<?, ?>> cache
      = new MapMaker().makeMap();

  /**
   * Constructs an element registry for the given builder.
   */
  ElementMetadataRegistry(Schema schema,
      ElementMetadataRegistryBuilder elementBuilder) {
    this.schema = schema;
    this.transforms = getTransforms(elementBuilder);
  }

  /**
   * Loops through the transforms on the given builder and any parent builders,
   * adding then to our immutable map of transforms.
   */
  private Map<TransformKey, ElementTransform> getTransforms(
      ElementMetadataRegistryBuilder elementBuilder) {
    Builder<TransformKey, ElementTransform> builder = ImmutableMap.builder();

    for (Map.Entry<TransformKey, ElementCreatorImpl> entry
        : elementBuilder.getCreators().entrySet()) {
      builder.put(entry.getKey(), entry.getValue().toTransform());
    }
    return builder.build();
  }

  /**
   * Binds the metadata when it is inside the given parent and operating
   * within the given context.
   */
  <D, E extends Element> ElementMetadata<D, E> bind(
      ElementKey<?, ?> parent, ElementKey<D, E> key, MetadataContext context) {
    TransformKey transformKey = TransformKey.forTransform(parent, key, context);

    @SuppressWarnings("unchecked")
    ElementMetadata<D, E> transformed =
        (ElementMetadata<D, E>) cache.get(transformKey);

    if (transformed == null) {
      ElementTransform transform = getTransform(transformKey, key);
      transformed = transform.toMetadata(schema, parent, key, context);
      @SuppressWarnings("unchecked")
      ElementMetadata<D, E> previous =
          (ElementMetadata<D, E>) cache.putIfAbsent(transformKey, transformed);
      if (previous != null) {
        transformed =  previous;
      }
    }

    return transformed;
  }

  /**
   * Provides direct access to the transform for other classes in this package,
   * to avoid circular dependencies causing infinite loops.  This allows
   * interested classes to access the metadata information for a key without
   * fully binding it.
   */
  ElementTransform getTransform(ElementKey<?, ?> parent,
      ElementKey<?, ?> key, MetadataContext context) {
    TransformKey transformKey = TransformKey.forTransform(parent, key, context);
    return getTransform(transformKey, key);
  }

  /**
   * Gets a composite transform from all transforms that match the given key.
   */
  private ElementTransform getTransform(TransformKey transformKey,
      ElementKey<?, ?> key) {
    List<ElementTransform> matched = Lists.newArrayList();
    for (Map.Entry<TransformKey, ElementTransform> entry
        : transforms.entrySet()) {
      if (entry.getKey().matches(transformKey)) {
        matched.add(entry.getValue());
      }
    }

    switch (matched.size()) {
      case 0: return ElementTransform.EMPTY;
      case 1: return matched.get(0);
      default: return ElementTransform.create(key, matched);
    }
  }
}

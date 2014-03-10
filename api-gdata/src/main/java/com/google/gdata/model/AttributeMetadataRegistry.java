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

import com.google.gdata.util.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * An immutable registry storing the information for a single attribute, based
 * on its ID.  All transforms around the attribute with this ID are stored in
 * a single registry.  The attribute registry is able to bind to a particular
 * {@link TransformKey} in order to reference a single metadata instance.
 * <p>
 * This registry exposes a single method, {@link #bind}, which can be used
 * to get the attribute metadata for a particular combination of parent key,
 * attribute key, and context.
 *
 * 
 */
final class AttributeMetadataRegistry {

  // The root Schema this attribute registry is part of.
  private final Schema schema;

  // A map of transforms by context for this attribute.
  private final Map<TransformKey, AttributeTransform> transforms;

  // A cache of derived metadata, so we only generate them once.
  private final ConcurrentMap<TransformKey, AttributeMetadata<?>> cache
      = new MapMaker().makeMap();

  /**
   * Creates a new attribute registry from the given builder.
   */
  AttributeMetadataRegistry(Schema schema,
      AttributeMetadataRegistryBuilder builder) {
    this.schema = schema;
    this.transforms = getTransforms(builder.getCreators());
  }

  /**
   * Creates an immutable, deep copy of the given map of attribute builders.
   * This makes the created attribute builders local to this registry, so we
   * can treat them as immutable even though they really aren't.
   */
  private Map<TransformKey, AttributeTransform> getTransforms(
      Map<TransformKey, AttributeCreatorImpl> map) {
    Builder<TransformKey, AttributeTransform> builder =
        ImmutableMap.builder();
    for (Map.Entry<TransformKey, AttributeCreatorImpl> entry
        : map.entrySet()) {
      builder.put(entry.getKey(), entry.getValue().toTransform());
    }
    return builder.build();
  }

  /**
   * Binds the attribute to the given parent and context.  Will return an
   * undeclared attribute metadata if no metadata for the given key exists.
   */
  <D> AttributeMetadata<D> bind(
      ElementKey<?, ?> parent, AttributeKey<D> key, MetadataContext context) {
    Preconditions.checkNotNull(parent, "parent");
    Preconditions.checkNotNull(key, "key");

    TransformKey transformKey =
        TransformKey.forTransform(parent, key, context);

    @SuppressWarnings("unchecked")
    AttributeMetadata<D> transformed =
        (AttributeMetadata<D>) cache.get(transformKey);

    if (transformed == null) {
      AttributeTransform transform = getTransform(transformKey, key);
      transformed = transform.toMetadata(schema, parent, key, context);
      @SuppressWarnings("unchecked")
      AttributeMetadata<D> previous =
          (AttributeMetadata<D>) cache.putIfAbsent(transformKey, transformed);
      if (previous != null) {
        transformed = previous;
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
  AttributeTransform getTransform(ElementKey<?, ?> parent,
      AttributeKey<?> key, MetadataContext context) {
    return getTransform(TransformKey.forTransform(parent, key, context), key);
  }

  /**
   * Gets a composite transform for the given transform key. Will return an
   * empty transform if no transform matched the given key.
   */
  private AttributeTransform getTransform(TransformKey transformKey,
      AttributeKey<?> key) {
    List<AttributeTransform> matched = Lists.newArrayList();
    for (Map.Entry<TransformKey, AttributeTransform> entry
        : transforms.entrySet()) {
      if (entry.getKey().matches(transformKey)) {
        matched.add(entry.getValue());
      }
    }

    // If there were no matches, we use an undeclared attribute, otherwise we
    // return either a single or composite transform.
    switch (matched.size()) {
      case 0: return AttributeTransform.EMPTY;
      case 1: return matched.get(0);
      default: return AttributeTransform.create(matched);
    }
  }
}

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
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * A mutable, thread-safe builder for the metadata for a particular element.
 * This can be used to construct the default metadata for an element as well
 * as add transforms and adaptations on that element.  The {@link #create}
 * method can be used to create the immutable {@link ElementMetadataRegistry}
 * from this builder.
 *
 * 
 */
final class ElementMetadataRegistryBuilder {

  // The root registry that created this element registry.
  private final MetadataRegistry root;

  // A map of creators for this element.
  private final Map<TransformKey, ElementCreatorImpl> creators
      = Maps.newTreeMap();

  /**
   * Creates a new element metadata registry builder as part of the given
   * metadata registry.
   */
  ElementMetadataRegistryBuilder(MetadataRegistry root) {
    this.root = root;
  }

  /**
   * Merges the values from an existing element registry builder.
   */
  void merge(ElementMetadataRegistryBuilder other) {
    for (Map.Entry<TransformKey, ElementCreatorImpl> entry
        : other.creators.entrySet()) {
      TransformKey key = entry.getKey();
      ElementCreatorImpl creator = creators.get(key);
      if (creator == null) {
        creator = new ElementCreatorImpl(root, key);
        creators.put(key, creator);
      }
      creator.merge(entry.getValue());
    }
  }

  /**
   * Create an immutable element metadata registry from this builder.
   */
  ElementMetadataRegistry create(Schema schema) {
    return new ElementMetadataRegistry(schema, this);
  }

  /**
   * Returns {@code true} if a metadata creator exists for the given combination
   * of parent, key, and context.
   */
  boolean isRegistered(ElementKey<?, ?> parent, ElementKey<?, ?> key,
      MetadataContext context) {
    Preconditions.checkNotNull(key, "key");
    TransformKey transformKey = TransformKey.forTransform(parent, key, context);
    return creators.containsKey(transformKey);
  }

  /**
   * Builds the metadata for this element within the given context when it is
   * placed inside the parent.
   */
  ElementCreatorImpl build(ElementKey<?, ?> parent,
      ElementKey<?, ?> key, MetadataContext context) {
    Preconditions.checkNotNull(key, "key");
    TransformKey transformKey = TransformKey.forTransform(parent, key, context);

    synchronized (root) {
      ElementCreatorImpl creator = creators.get(transformKey);
      if (creator == null) {
        creator = new ElementCreatorImpl(root, transformKey);
        creators.put(transformKey, creator);
        root.dirty();
      }
      return creator;
    }
  }

  /**
   * Returns an immutable copy of the creators in this builder.
   */
  Map<TransformKey, ElementCreatorImpl> getCreators() {
    return ImmutableMap.copyOf(creators);
  }
}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model.transforms.atom;

import com.google.gdata.client.Service;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataContext;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.atom.Entry;
import com.google.gdata.model.atom.Feed;
import com.google.gdata.model.gd.GdAttributes;
import com.google.gdata.util.Namespaces;

/**
 * Transforms for atom elements based on version information.
 *
 * 
 */
public class AtomVersionTransforms {

  private static final MetadataContext V1_CONTEXT =
      MetadataContext.forVersion(Service.Versions.V1);

  public static void addTransforms(MetadataRegistry registry) {
    addOssTransform(registry, Feed.TOTAL_RESULTS);
    addOssTransform(registry, Feed.START_INDEX);
    addOssTransform(registry, Feed.ITEMS_PER_PAGE);

    registry.build(Entry.KEY, GdAttributes.KIND, V1_CONTEXT).setVisible(false);
    registry.build(Feed.KEY, GdAttributes.KIND, V1_CONTEXT).setVisible(false);
  }

  @SuppressWarnings("deprecation")
  private static void addOssTransform(MetadataRegistry registry,
      ElementKey<?, ?> key) {
    registry.build(key, V1_CONTEXT).setName(
        new QName(Namespaces.openSearchNs, key.getId().getLocalName()));
  }
}

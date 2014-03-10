/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.maps;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;
import com.google.gdata.data.Link;

/**
 * Describes a feature feed.
 *
 * 
 */
@Kind.Term(FeatureEntry.KIND)
public class FeatureFeed extends BaseFeed<FeatureFeed, FeatureEntry> {

  /**
   * Default mutable constructor.
   */
  public FeatureFeed() {
    super(FeatureEntry.class);
    getCategories().add(FeatureEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public FeatureFeed(BaseFeed<?, ?> sourceFeed) {
    super(FeatureEntry.class, sourceFeed);
  }

  /**
   * Returns the link that provides the URI of the full feed (without any query
   * parameters).
   *
   * @return Link that provides the URI of the full feed (without any query
   *     parameters) or {@code null} for none.
   */
  public Link getAtomFeedLink() {
    return getLink(Link.Rel.FEED, Link.Type.ATOM);
  }

  @Override
  public String toString() {
    return "{FeatureFeed " + super.toString() + "}";
  }


  private boolean isKmlDefault = true;

  public void setKmlDefault(boolean isDefault) {
    isKmlDefault = isDefault;
  }

  /**
   * Override generateAtom() method to change the default namespace to kml.
   */
  @Override
  public void generateAtom(com.google.gdata.util.common.xml.XmlWriter w,
      com.google.gdata.data.ExtensionProfile extProfile)
      throws java.io.IOException {

    if (isKmlDefault) {
      w.setDefaultNamespace(DataConstants.KML_NAMESPACE);
    }
    super.generateAtom(w, extProfile);
  }
}

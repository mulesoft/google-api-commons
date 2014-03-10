/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.sites;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;

/**
 * A read-only feed from which a particular version of a document can be
 * fetched.
 *
 * 
 */
public class RevisionFeed extends BaseFeed<RevisionFeed, BaseContentEntry> {

  /**
   * Default mutable constructor.
   */
  public RevisionFeed() {
    super(ContentEntry.class);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public RevisionFeed(BaseFeed<?, ?> sourceFeed) {
    super(ContentEntry.class, sourceFeed);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(RevisionFeed.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(RevisionFeed.class, SitesLink.getDefaultDescription(true,
        true));
  }

  @Override
  public String toString() {
    return "{RevisionFeed " + super.toString() + "}";
  }

}


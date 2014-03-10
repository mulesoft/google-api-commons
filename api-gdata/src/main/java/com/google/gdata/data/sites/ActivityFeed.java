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
 * Describes an activity feed.
 *
 * 
 */
public class ActivityFeed extends BaseFeed<ActivityFeed, BaseActivityEntry> {

  /**
   * Default mutable constructor.
   */
  public ActivityFeed() {
    super(ActivityEntry.class);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public ActivityFeed(BaseFeed<?, ?> sourceFeed) {
    super(ActivityEntry.class, sourceFeed);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(ActivityFeed.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(ActivityFeed.class, SitesLink.getDefaultDescription(true,
        true));
  }

  @Override
  public String toString() {
    return "{ActivityFeed " + super.toString() + "}";
  }

}


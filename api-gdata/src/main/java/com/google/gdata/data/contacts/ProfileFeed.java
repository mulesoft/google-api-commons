/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.contacts;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;

/**
 * Describes a profile feed.
 *
 * 
 */
@Kind.Term(ProfileEntry.KIND)
public class ProfileFeed extends BaseFeed<ProfileFeed, ProfileEntry> {

  /**
   * Default mutable constructor.
   */
  public ProfileFeed() {
    super(ProfileEntry.class);
    getCategories().add(ProfileEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public ProfileFeed(BaseFeed<?, ?> sourceFeed) {
    super(ProfileEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{ProfileFeed " + super.toString() + "}";
  }

}


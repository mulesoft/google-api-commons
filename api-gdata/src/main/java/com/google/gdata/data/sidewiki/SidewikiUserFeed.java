/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.sidewiki;

import com.google.gdata.data.BaseFeed;

/**
 * Describes a feed of Sidewiki users.
 *
 * 
 */
public class SidewikiUserFeed extends BaseFeed<SidewikiUserFeed,
    SidewikiUserEntry> {

  /**
   * Default mutable constructor.
   */
  public SidewikiUserFeed() {
    super(SidewikiUserEntry.class);
    setKind("sidewiki#sidewikiUserFeed");
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public SidewikiUserFeed(BaseFeed<?, ?> sourceFeed) {
    super(SidewikiUserEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{SidewikiUserFeed " + super.toString() + "}";
  }

}


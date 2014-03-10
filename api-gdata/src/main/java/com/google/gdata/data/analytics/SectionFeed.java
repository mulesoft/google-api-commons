/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.analytics;

import com.google.gdata.data.BaseFeed;

/**
 * Feed element in SectionFeed.
 *
 * 
 */
public class SectionFeed extends BaseFeed<SectionFeed, SectionEntry> {

  /**
   * Default mutable constructor.
   */
  public SectionFeed() {
    super(SectionEntry.class);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public SectionFeed(BaseFeed<?, ?> sourceFeed) {
    super(SectionEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{SectionFeed " + super.toString() + "}";
  }

}


/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.finance;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;

/**
 * Describes a Finance position feed.
 *
 * 
 */
@Kind.Term(PositionEntry.KIND)
public class PositionFeed extends BaseFeed<PositionFeed, PositionEntry> {

  /**
   * Default mutable constructor.
   */
  public PositionFeed() {
    super(PositionEntry.class);
    getCategories().add(PositionEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public PositionFeed(BaseFeed<?, ?> sourceFeed) {
    super(PositionEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{PositionFeed " + super.toString() + "}";
  }

}


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
 * Describes a Finance portfolio feed.
 *
 * 
 */
@Kind.Term(PortfolioEntry.KIND)
public class PortfolioFeed extends BaseFeed<PortfolioFeed, PortfolioEntry> {

  /**
   * Default mutable constructor.
   */
  public PortfolioFeed() {
    super(PortfolioEntry.class);
    getCategories().add(PortfolioEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public PortfolioFeed(BaseFeed<?, ?> sourceFeed) {
    super(PortfolioEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{PortfolioFeed " + super.toString() + "}";
  }

}


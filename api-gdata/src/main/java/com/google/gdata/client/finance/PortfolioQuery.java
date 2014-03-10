/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.finance;

import com.google.gdata.client.Query;

import java.net.URL;

/**
 * Describes a query for the feed of all the user's portfolios.
 *
 * 
 */
public class PortfolioQuery extends Query {

  /** Flag to inline positions under the portfolio feed. */
  private Boolean inlinePositions = false;

  /** Flag indicating whether returns and performance stats should be included
   * in the portfolio and position feed entries. */
  private Boolean includeReturns = false;

  /**
   * Constructs a new query object that targets a feed.  The initial state of
   * the query contains no parameters, meaning all entries in the feed would be
   * returned if the query was executed immediately after construction.
   *
   * @param feedUrl the URL of the feed against which queries will be executed.
   */
  public PortfolioQuery(URL feedUrl) {
    super(feedUrl);
  }

  /**
   * Returns the flag to inline positions under the portfolio feed.
   *
   * @return flag to inline positions under the portfolio feed.
   */
  public Boolean getInlinePositions() {
    return inlinePositions;
  }

  /**
   * Sets the flag to inline positions under the portfolio feed.
   *
   * @param inlinePositions flag to inline positions under the portfolio feed or
   *     <code>null</code> to reset this parameter to default value
   *     <code>false</code>.
   */
  public void setInlinePositions(Boolean inlinePositions) {
    if (inlinePositions == null) {
      inlinePositions = false;
    }
    // check if setting to existing value
    if (!this.inlinePositions.equals(inlinePositions)) {
      // set to new value for customer parameter
      this.inlinePositions = inlinePositions;
      setStringCustomParameter("positions",
          !inlinePositions ? null : inlinePositions.toString());
    }
  }

  /**
   * Returns the flag indicating whether returns and performance stats should be
   * included in the portfolio and position feed entries.
   *
   * @return flag indicating whether returns and performance stats should be
   *     included in the portfolio and position feed entries.
   */
  public Boolean getIncludeReturns() {
    return includeReturns;
  }

  /**
   * Sets the flag indicating whether returns and performance stats should be
   * included in the portfolio and position feed entries.
   *
   * @param includeReturns flag indicating whether returns and performance stats
   *     should be included in the portfolio and position feed entries or
   *     <code>null</code> to reset this parameter to default value
   *     <code>false</code>.
   */
  public void setIncludeReturns(Boolean includeReturns) {
    if (includeReturns == null) {
      includeReturns = false;
    }
    // check if setting to existing value
    if (!this.includeReturns.equals(includeReturns)) {
      // set to new value for customer parameter
      this.includeReturns = includeReturns;
      setStringCustomParameter("returns",
          !includeReturns ? null : includeReturns.toString());
    }
  }

}


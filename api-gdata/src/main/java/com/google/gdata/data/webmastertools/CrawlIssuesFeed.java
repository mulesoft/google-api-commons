/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.webmastertools;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;

/**
 * Feed of crawl issues for a particular site.
 *
 * 
 */
@Kind.Term(CrawlIssueEntry.KIND)
public class CrawlIssuesFeed extends BaseFeed<CrawlIssuesFeed,
    CrawlIssueEntry> {

  /**
   * Default mutable constructor.
   */
  public CrawlIssuesFeed() {
    super(CrawlIssueEntry.class);
    getCategories().add(CrawlIssueEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public CrawlIssuesFeed(BaseFeed<?, ?> sourceFeed) {
    super(CrawlIssueEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{CrawlIssuesFeed " + super.toString() + "}";
  }

}


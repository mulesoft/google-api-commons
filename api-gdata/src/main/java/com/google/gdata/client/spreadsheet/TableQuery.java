/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.spreadsheet;

import com.google.gdata.client.Query;

import java.net.URL;

/**
 * Describes a query for the feed of table definitions.
 *
 * 
 */
public class TableQuery extends Query {

  /** Search terms for the title of a document. */
  private String titleQuery;

  /** Whether the title query should be taken as an exact string. */
  private Boolean titleExact;

  /**
   * Constructs a new query object that targets a feed.  The initial state of
   * the query contains no parameters, meaning all entries in the feed would be
   * returned if the query was executed immediately after construction.
   *
   * @param feedUrl the URL of the feed against which queries will be executed.
   */
  public TableQuery(URL feedUrl) {
    super(feedUrl);
  }

  /**
   * Returns the search terms for the title of a document.
   *
   * @return search terms for the title of a document or <code>null</code> to
   *     indicate that the parameter is not set.
   */
  public String getTitleQuery() {
    return titleQuery;
  }

  /**
   * Sets the search terms for the title of a document.
   *
   * @param titleQuery search terms for the title of a document or
   *     <code>null</code> to remove this parameter if set.
   */
  public void setTitleQuery(String titleQuery) {
    // check if setting to existing value
    if (this.titleQuery == null ? titleQuery != null :
        !this.titleQuery.equals(titleQuery)) {
      // set to new value for customer parameter
      this.titleQuery = titleQuery;
      setStringCustomParameter("title", titleQuery);
    }
  }

  /**
   * Returns the whether the title query should be taken as an exact string.
   *
   * @return whether the title query should be taken as an exact string or
   *     <code>null</code> to indicate that the parameter is not set.
   */
  public Boolean getTitleExact() {
    return titleExact;
  }

  /**
   * Sets the whether the title query should be taken as an exact string.
   *
   * @param titleExact whether the title query should be taken as an exact
   *     string or <code>null</code> to remove this parameter if set.
   */
  public void setTitleExact(Boolean titleExact) {
    // check if setting to existing value
    if (this.titleExact == null ? titleExact != null :
        !this.titleExact.equals(titleExact)) {
      // set to new value for customer parameter
      this.titleExact = titleExact;
      setStringCustomParameter("title-exact",
          titleExact == null ? null : titleExact.toString());
    }
  }

}

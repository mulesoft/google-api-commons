/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.sites;

import com.google.gdata.client.Query;

import java.net.URL;

/**
 * Describes a query for the feed containing descriptions of all activity within
 * a site.
 *
 * 
 */
public class ActivityQuery extends Query {

  /** Content of a the given kind(s). */
  private String kind;

  /**
   * Constructs a new query object that targets a feed.  The initial state of
   * the query contains no parameters, meaning all entries in the feed would be
   * returned if the query was executed immediately after construction.
   *
   * @param feedUrl the URL of the feed against which queries will be executed.
   */
  public ActivityQuery(URL feedUrl) {
    super(feedUrl);
  }

  /**
   * Returns the content of a the given kind(s).
   *
   * @return content of a the given kind(s) or <code>null</code> to indicate
   *     that the parameter is not set.
   */
  public String getKind() {
    return kind;
  }

  /**
   * Sets the content of a the given kind(s).
   *
   * @param kind content of a the given kind(s) or <code>null</code> to remove
   *     this parameter if set.
   */
  public void setKind(String kind) {
    // check if setting to existing value
    if (this.kind == null ? kind != null : !this.kind.equals(kind)) {
      // set to new value for customer parameter
      this.kind = kind;
      setStringCustomParameter("kind", kind);
    }
  }

}


/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.gtt;

import com.google.gdata.client.Query;

import java.net.URL;

/**
 * Describes a query for the feed of translation memories.
 *
 * 
 */
public class TranslationMemoryQuery extends Query {

  /** Scope. */
  private String scope;

  /**
   * Constructs a new query object that targets a feed.  The initial state of
   * the query contains no parameters, meaning all entries in the feed would be
   * returned if the query was executed immediately after construction.
   *
   * @param feedUrl the URL of the feed against which queries will be executed.
   */
  public TranslationMemoryQuery(URL feedUrl) {
    super(feedUrl);
  }

  /**
   * Returns the scope.
   *
   * @return scope or <code>null</code> to indicate that the parameter is not
   *     set.
   */
  public String getScope() {
    return scope;
  }

  /**
   * Sets the scope.
   *
   * @param scope scope or <code>null</code> to remove this parameter if set.
   */
  public void setScope(String scope) {
    // check if setting to existing value
    if (this.scope == null ? scope != null : !this.scope.equals(scope)) {
      // set to new value for customer parameter
      this.scope = scope;
      setStringCustomParameter("scope", scope);
    }
  }

}


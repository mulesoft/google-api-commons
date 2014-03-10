/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.projecthosting;

import com.google.gdata.client.Query;

import java.net.URL;

/**
 * Describes a query for the project listing feed.
 *
 * 
 */
public class ProjectsQuery extends Query {

  /** Label. */
  private String label;

  /** Ordering of results. */
  private String orderby;

  /**
   * Constructs a new query object that targets a feed.  The initial state of
   * the query contains no parameters, meaning all entries in the feed would be
   * returned if the query was executed immediately after construction.
   *
   * @param feedUrl the URL of the feed against which queries will be executed.
   */
  public ProjectsQuery(URL feedUrl) {
    super(feedUrl);
  }

  /**
   * Returns the label.
   *
   * @return label or <code>null</code> to indicate that the parameter is not
   *     set.
   */
  public String getLabel() {
    return label;
  }

  /**
   * Sets the label.
   *
   * @param label label or <code>null</code> to remove this parameter if set.
   */
  public void setLabel(String label) {
    // check if setting to existing value
    if (this.label == null ? label != null : !this.label.equals(label)) {
      // set to new value for customer parameter
      this.label = label;
      setStringCustomParameter("label", label);
    }
  }

  /**
   * Returns the ordering of results.
   *
   * @return ordering of results or <code>null</code> to indicate that the
   *     parameter is not set.
   */
  public String getOrderby() {
    return orderby;
  }

  /**
   * Sets the ordering of results.
   *
   * @param orderby ordering of results or <code>null</code> to remove this
   *     parameter if set.
   */
  public void setOrderby(String orderby) {
    // check if setting to existing value
    if (this.orderby == null ? orderby != null : !this.orderby.equals(orderby))
        {
      // set to new value for customer parameter
      this.orderby = orderby;
      setStringCustomParameter("orderby", orderby);
    }
  }

}


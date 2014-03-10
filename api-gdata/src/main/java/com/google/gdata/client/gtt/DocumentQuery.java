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
 * Describes a query for the feed of documents.
 *
 * 
 */
public class DocumentQuery extends Query {

  /** Onlydeleted. */
  private Boolean onlydeleted;

  /** Sharedwith. */
  private String sharedWithEmailId;

  /** Showdeleted. */
  private Boolean showdeleted;

  /**
   * Constructs a new query object that targets a feed.  The initial state of
   * the query contains no parameters, meaning all entries in the feed would be
   * returned if the query was executed immediately after construction.
   *
   * @param feedUrl the URL of the feed against which queries will be executed.
   */
  public DocumentQuery(URL feedUrl) {
    super(feedUrl);
  }

  /**
   * Returns the onlydeleted.
   *
   * @return onlydeleted or <code>null</code> to indicate that the parameter is
   *     not set.
   */
  public Boolean getOnlydeleted() {
    return onlydeleted;
  }

  /**
   * Sets the onlydeleted.
   *
   * @param onlydeleted onlydeleted or <code>null</code> to remove this
   *     parameter if set.
   */
  public void setOnlydeleted(Boolean onlydeleted) {
    // check if setting to existing value
    if (this.onlydeleted == null ? onlydeleted != null :
        !this.onlydeleted.equals(onlydeleted)) {
      // set to new value for customer parameter
      this.onlydeleted = onlydeleted;
      setStringCustomParameter("onlydeleted",
          onlydeleted == null ? null : onlydeleted.toString());
    }
  }

  /**
   * Returns the sharedwith.
   *
   * @return sharedwith or <code>null</code> to indicate that the parameter is
   *     not set.
   */
  public String getSharedWithEmailId() {
    return sharedWithEmailId;
  }

  /**
   * Sets the sharedwith.
   *
   * @param sharedWithEmailId sharedwith or <code>null</code> to remove this
   *     parameter if set.
   */
  public void setSharedWithEmailId(String sharedWithEmailId) {
    // check if setting to existing value
    if (this.sharedWithEmailId == null ? sharedWithEmailId != null :
        !this.sharedWithEmailId.equals(sharedWithEmailId)) {
      // set to new value for customer parameter
      this.sharedWithEmailId = sharedWithEmailId;
      setStringCustomParameter("sharedwith", sharedWithEmailId);
    }
  }

  /**
   * Returns the showdeleted.
   *
   * @return showdeleted or <code>null</code> to indicate that the parameter is
   *     not set.
   */
  public Boolean getShowdeleted() {
    return showdeleted;
  }

  /**
   * Sets the showdeleted.
   *
   * @param showdeleted showdeleted or <code>null</code> to remove this
   *     parameter if set.
   */
  public void setShowdeleted(Boolean showdeleted) {
    // check if setting to existing value
    if (this.showdeleted == null ? showdeleted != null :
        !this.showdeleted.equals(showdeleted)) {
      // set to new value for customer parameter
      this.showdeleted = showdeleted;
      setStringCustomParameter("showdeleted",
          showdeleted == null ? null : showdeleted.toString());
    }
  }

}


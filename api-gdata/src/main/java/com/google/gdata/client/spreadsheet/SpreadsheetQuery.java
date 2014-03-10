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


import com.google.gdata.client.DocumentQuery;

import java.net.URL;


/**
 * Simple class for cells-feed-specific queries.
 *
 * 
 */
public class SpreadsheetQuery extends DocumentQuery {

  /**
   * Constructs a query for querying spreadsheets that you have access to.
   * 
   * @param feedUrl the feed's URI
   */
  public SpreadsheetQuery(URL feedUrl) {
    super(feedUrl);
  }
}

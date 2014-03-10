/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.spreadsheet;

/**
 * Extends the base Link class with Google Spreadsheets extensions.
 *
 * 
 */
public class SpreadsheetLink {

  /** Link relation type. */
  public static final class Rel {

    /** Link for the feed of a worksheet's cells. */
    public static final String CELLS_FEED = Namespaces.gSpreadPrefix +
        "cellsfeed";

    /** Link for the Gviz resource of a worksheet. */
    public static final String GVIZ = Namespaces.GVIZ_PREFIX +
        "visualizationApi";

    /** Link for the feed of a worksheet's rows. */
    public static final String LIST_FEED = Namespaces.gSpreadPrefix +
        "listfeed";

    /** Link for the feed of a table's records. */
    public static final String RECORDS_FEED = Namespaces.gSpreadPrefix +
        "recordsfeed";

    /** Link for the feed of a spreadsheet's worksheets. */
    public static final String WORKSHEETS_FEED = Namespaces.gSpreadPrefix +
        "worksheetsfeed";

  }

  /** Private constructor to ensure class is not instantiated. */
  private SpreadsheetLink() {}

}

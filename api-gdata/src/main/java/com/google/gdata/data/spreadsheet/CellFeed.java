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

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.data.batch.BatchUtils;

/**
 * The feed for spreadsheet cells of Google Spreadsheets.
 *
 * 
 */
@Kind.Term(CellEntry.KIND)
public class CellFeed
    extends BaseFeed<CellFeed, CellEntry> {

  /** Constructs a blank cells feed. */
  public CellFeed() {
    super(CellEntry.class);
    getCategories().add(CellEntry.CATEGORY);
  }

  /** Constructs a cells feed from an existing feed. */
  public CellFeed(BaseFeed sourceFeed) {
    super(CellEntry.class, sourceFeed);
    getCategories().add(CellEntry.CATEGORY);
  }

  /** Declares relevant extensions into the extension profile. */
  public void declareExtensions(ExtensionProfile extProfile) {
    extProfile.declare(CellFeed.class, RowCount.getDefaultDescription());
    extProfile.declare(CellFeed.class, ColCount.getDefaultDescription());
    super.declareExtensions(extProfile);
    BatchUtils.declareExtensions(extProfile);
  }

  /**
   * Gets the total number of rows in the spreadsheet.
   * 
   * This refers to the hard bound on rows.  It is possible that your
   * spreadsheet has many, many empty rows, all of which are counted in
   * this count.
   * 
   * Column positions 1 to getRowCount() are valid.
   */
  public int getRowCount() {
    return getExtension(RowCount.class).getCount();
  }

  /**
   * Gets the total number of columns.
   * 
   * This refers to the hard bound on columns.  It is possible that your
   * spreadsheet has many empty columns, all of which are counted in
   * this count.
   * 
   * Column positions 1 to getColCount() are valid.
   */
  public int getColCount() {
    return getExtension(ColCount.class).getCount();
  }
}

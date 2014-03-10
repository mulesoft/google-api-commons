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

/**
 * The feed for getting a list of Spreadsheets within a sheet.
 *
 * 
 */
@Kind.Term(SpreadsheetEntry.KIND)
public class SpreadsheetFeed
    extends BaseFeed<SpreadsheetFeed, SpreadsheetEntry> {

  /** Constructs an empty feed. */
  public SpreadsheetFeed() {
    super(SpreadsheetEntry.class);
    getCategories().add(SpreadsheetEntry.CATEGORY);
  }

  public SpreadsheetFeed(BaseFeed sourceFeed) {
    super(SpreadsheetEntry.class, sourceFeed);
    getCategories().add(SpreadsheetEntry.CATEGORY);
  }

  /** Declares feed-level extensions into the extension profile. */
  public void declareExtensions(ExtensionProfile extProfile) {
    // No feed-level extensions.
    super.declareExtensions(extProfile);
  }
}

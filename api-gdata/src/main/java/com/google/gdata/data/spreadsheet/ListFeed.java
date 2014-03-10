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
 * The feed for treating a spreadsheet as a collection of list items.
 *
 * 
 */
@Kind.Term(ListEntry.KIND)
public class ListFeed
    extends BaseFeed<ListFeed, ListEntry> {

  /** Constructs an empty feed. */
  public ListFeed() {
    super(ListEntry.class);
    getCategories().add(ListEntry.CATEGORY);
  }

  /** Constructs a feed using state from an existing one. */
  public ListFeed(BaseFeed sourceFeed) {
    super(ListEntry.class, sourceFeed);
    getCategories().add(ListEntry.CATEGORY);
  }

  /** Declares extensions used by Rows feeds into the extension profile. */
  public void declareExtensions(ExtensionProfile extProfile) {
    // No feed-level extensions.
    super.declareExtensions(extProfile);
  }
}

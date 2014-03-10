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
import com.google.gdata.data.Kind;

/**
 * Describes a feed of a table's records.
 *
 * 
 */
@Kind.Term(RecordEntry.KIND)
public class RecordFeed extends BaseFeed<RecordFeed, RecordEntry> {

  /**
   * Default mutable constructor.
   */
  public RecordFeed() {
    super(RecordEntry.class);
    getCategories().add(RecordEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public RecordFeed(BaseFeed<?, ?> sourceFeed) {
    super(RecordEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{RecordFeed " + super.toString() + "}";
  }

}

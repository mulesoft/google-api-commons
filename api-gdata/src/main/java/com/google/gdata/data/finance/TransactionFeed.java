/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.finance;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;

/**
 * Describes a Finance transaction feed.
 *
 * 
 */
@Kind.Term(TransactionEntry.KIND)
public class TransactionFeed extends BaseFeed<TransactionFeed,
    TransactionEntry> {

  /**
   * Default mutable constructor.
   */
  public TransactionFeed() {
    super(TransactionEntry.class);
    getCategories().add(TransactionEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public TransactionFeed(BaseFeed<?, ?> sourceFeed) {
    super(TransactionEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{TransactionFeed " + super.toString() + "}";
  }

}


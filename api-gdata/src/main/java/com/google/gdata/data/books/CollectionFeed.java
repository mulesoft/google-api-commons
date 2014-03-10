/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.books;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;

/**
 * Describes a Book Search collection feed.
 *
 * 
 */
@Kind.Term(CollectionEntry.KIND)
public class CollectionFeed extends BaseFeed<CollectionFeed, CollectionEntry> {

  /**
   * Default mutable constructor.
   */
  public CollectionFeed() {
    super(CollectionEntry.class);
    getCategories().add(CollectionEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public CollectionFeed(BaseFeed<?, ?> sourceFeed) {
    super(CollectionEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{CollectionFeed " + super.toString() + "}";
  }

}

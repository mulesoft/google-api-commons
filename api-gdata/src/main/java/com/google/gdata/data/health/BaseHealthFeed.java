/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.health;

import com.google.gdata.data.BaseFeed;

/**
 * Describes a health feed.
 *
 * @param <F> concrete feed type
 * @param <E> concrete entry type
 * 
 */
public abstract class BaseHealthFeed<F extends BaseHealthFeed,
    E extends BaseHealthEntry> extends BaseFeed<F, E> {

  /**
   * Default mutable constructor.
   *
   * @param entryClass entry class
   */
  public BaseHealthFeed(Class<E> entryClass) {
    super(entryClass);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param entryClass entry class
   * @param sourceFeed source feed
   */
  public BaseHealthFeed(Class<E> entryClass, BaseFeed<?, ?> sourceFeed) {
    super(entryClass, sourceFeed);
  }

  @Override
  public String toString() {
    return "{BaseHealthFeed " + super.toString() + "}";
  }

}

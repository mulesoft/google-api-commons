/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.gtt;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.media.MediaFeed;

/**
 * Describes a translation memory feed.
 *
 * 
 */
public class TranslationMemoryFeed extends MediaFeed<TranslationMemoryFeed,
    TranslationMemoryEntry> {

  /**
   * Default mutable constructor.
   */
  public TranslationMemoryFeed() {
    super(TranslationMemoryEntry.class);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public TranslationMemoryFeed(BaseFeed<?, ?> sourceFeed) {
    super(TranslationMemoryEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{TranslationMemoryFeed " + super.toString() + "}";
  }

}


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
 * Describes a document feed.
 *
 * 
 */
public class DocumentFeed extends MediaFeed<DocumentFeed, DocumentEntry> {

  /**
   * Default mutable constructor.
   */
  public DocumentFeed() {
    super(DocumentEntry.class);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public DocumentFeed(BaseFeed<?, ?> sourceFeed) {
    super(DocumentEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{DocumentFeed " + super.toString() + "}";
  }

}


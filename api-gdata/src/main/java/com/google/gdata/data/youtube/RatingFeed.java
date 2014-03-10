/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.youtube;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;

/**
 * Object representatino for the rating feed.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_RATING)
public class RatingFeed
    extends BaseFeed<RatingFeed, RatingEntry>{

  public RatingFeed() {
    super(RatingEntry.class);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_RATING);
  }

  public RatingFeed(BaseFeed base) {
    super(RatingEntry.class, base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_RATING);
  }
}

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

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.data.extensions.Rating;

/**
 * An entry in the rating feed.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_RATING)
public class RatingEntry extends BaseEntry<RatingEntry> {

  public RatingEntry() {
    EntryUtils.setKind(this, YouTubeNamespace.KIND_RATING);
  }

  public RatingEntry(BaseEntry<?> base) {
    super(base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_RATING);
  }

  /** Gets the gd:rating tag. */
  public Rating getRating() {
    return getExtension(Rating.class);
  }

  /** Sets the gd:rating tag. */
  public void setRating(Rating rating) {
    if (rating == null) {
      removeExtension(Rating.class);
    } else {
      setExtension(rating);
    }
  }
  
  /** Gets the yt:rating tag. */
  public YtRating getYtRating() {
    return getExtension(YtRating.class);
  }
  
  /** Sets the yt:rating tag. */
  public void setYtRating(YtRating rating) {
    if (rating == null) {
      removeExtension(YtRating.class);
    } else {
      setExtension(rating);
    }
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    extProfile.declare(RatingEntry.class, Rating.getDefaultDescription(false));
    extProfile.declare(RatingEntry.class, YtRating.class);
    extProfile.declareArbitraryXmlExtension(RatingEntry.class);
  }
  
}

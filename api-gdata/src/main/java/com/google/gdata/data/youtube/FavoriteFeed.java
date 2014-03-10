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
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;

/**
 * A YouTube favorite feed.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_FAVORITE)
public class FavoriteFeed extends BaseFeed<FavoriteFeed, FavoriteEntry> {
  /**
   * Creates an empty favorite feed.
   */
  public FavoriteFeed() {
    super(FavoriteEntry.class);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_FAVORITE);
  }
  
  /**
   * Creates a copy of the given feed.
   * 
   * @param base feed to copy.
   */
  public FavoriteFeed(BaseFeed<?, ?> base) {
    super(FavoriteEntry.class, base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_FAVORITE);
  }
  
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
  }
}

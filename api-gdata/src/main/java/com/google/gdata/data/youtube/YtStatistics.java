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

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.util.ParseException;

/**
 * A tag containing statistics about the entry it's in.
 *
 * 
 */
@ExtensionDescription.Default (
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "statistics"
)
public class YtStatistics extends AbstractExtension {
  private long viewCount;
  private long favoriteCount;


  /** Gets view count, 0 by default. */
  public long getViewCount() {
    return viewCount;
  }

  /** Sets view count. */
  public void setViewCount(long viewCount) {
    this.viewCount = viewCount;
  }

  /** Gets favorite count, 0 by default. */
  public long getFavoriteCount() {
    return favoriteCount;
  }

  /** Sets favorite count. */
  public void setFavoriteCount(long favoriteCount) {
    this.favoriteCount = favoriteCount;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    if (viewCount > 0) {
      generator.put("viewCount", viewCount);
    }
    if (favoriteCount > 0) {
      generator.put("favoriteCount", favoriteCount);
    }
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper)
      throws ParseException {
    viewCount = helper.consumeLong("viewCount", false, 0L);
    favoriteCount = helper.consumeLong("favoriteCount", false, 0L);
  }
}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.maps;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;
import com.google.gdata.data.Link;
import com.google.gdata.data.media.MediaFeed;

/**
 * Describes a map feed.
 *
 * 
 */
@Kind.Term(MapEntry.KIND)
public class MapFeed extends MediaFeed<MapFeed, MapEntry> {

  /**
   * Default mutable constructor.
   */
  public MapFeed() {
    super(MapEntry.class);
    getCategories().add(MapEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public MapFeed(BaseFeed<?, ?> sourceFeed) {
    super(MapEntry.class, sourceFeed);
  }

  /**
   * Returns the link that provides the URI of the full feed (without any query
   * parameters).
   *
   * @return Link that provides the URI of the full feed (without any query
   *     parameters) or {@code null} for none.
   */
  public Link getAtomFeedLink() {
    return getLink(Link.Rel.FEED, Link.Type.ATOM);
  }

  @Override
  public String toString() {
    return "{MapFeed " + super.toString() + "}";
  }

}


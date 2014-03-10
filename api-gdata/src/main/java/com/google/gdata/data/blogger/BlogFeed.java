/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.blogger;

import com.google.gdata.data.BaseFeed;

/**
 * Describes a feed of a user's blogs.
 *
 * 
 */
public class BlogFeed extends BaseFeed<BlogFeed, BlogEntry> {

  /**
   * Default mutable constructor.
   */
  public BlogFeed() {
    super(BlogEntry.class);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public BlogFeed(BaseFeed<?, ?> sourceFeed) {
    super(BlogEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{BlogFeed " + super.toString() + "}";
  }

}

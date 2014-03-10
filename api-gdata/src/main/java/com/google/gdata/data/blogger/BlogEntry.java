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

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Link;

/**
 * Describes a blog entry in the feed of a user's blogs.
 *
 * 
 */
public class BlogEntry extends BaseEntry<BlogEntry> {

  /**
   * Default mutable constructor.
   */
  public BlogEntry() {
    super();
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public BlogEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  /**
   * Returns the link that provides the URI that can be used to post new entries
   * to the feed.
   *
   * @return Link that provides the URI that can be used to post new entries to
   *     the feed or {@code null} for none.
   */
  public Link getEntryPostLink() {
    return getLink(Link.Rel.ENTRY_POST, Link.Type.ATOM);
  }

  /**
   * Returns the link that provides the URI of the full feed (without any query
   * parameters).
   *
   * @return Link that provides the URI of the full feed (without any query
   *     parameters) or {@code null} for none.
   */
  public Link getFeedLink() {
    return getLink(Link.Rel.FEED, Link.Type.ATOM);
  }

  /**
   * Returns the link that provides the URI of the web content.
   *
   * @return Link that provides the URI of the web content or {@code null} for
   *     none.
   */
  public Link getRepliesLink() {
    return getLink(BloggerLink.Rel.REPLIES, Link.Type.ATOM);
  }

  @Override
  public String toString() {
    return "{BlogEntry " + super.toString() + "}";
  }

}

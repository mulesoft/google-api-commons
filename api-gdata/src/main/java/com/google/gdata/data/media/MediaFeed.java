/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.media;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.Service;
import com.google.gdata.client.media.MediaService;
import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Link;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.URL;

/**
 * The MediaFeed class extends {@link BaseFeed} to add media-related
 * operations for feeds that contain media content.
 *
 * @param <F> the feed class associated with the bound subtype.
 * @param <E> the entry class associated with the bound subtype.
 * 
 */
public abstract class MediaFeed<F extends BaseFeed, E extends BaseEntry>
    extends BaseFeed<F, E> {

  protected MediaFeed(Class<? extends E> entryClass) {
    super(entryClass);
  }

  protected MediaFeed(Class<? extends E> entryClass,
      BaseFeed<?, ?> sourceFeed) {
    super(entryClass, sourceFeed);
  }

  @Override
  public void setService(Service v) {

    if (!(v instanceof MediaService)) {
      throw new IllegalArgumentException("Service does not support media");
    }
    super.setService(v);
  }

  /**
   * Inserts a new media resource into the feed, if the feed is currently
   * associated with a Service.
   *
   * @return the inserted media Entry returned by the Service.
   *
   * @throws ServiceException
   *           If there is no associated GData service or the service is
   *           unable to perform the insertion.
   *
   * @throws UnsupportedOperationException
   *           If insert is not supported for the target feed.
   *
   * @throws IOException
   *           If there is an error communicating with the GData service.
   */
  public E insert(MediaSource media) throws ServiceException, IOException {
    return insert(media, entryClass);
  }

  /**
   * Inserts a new media resource into the feed, if the feed is currently
   * associated with a Service.  This method is meant for subclasses to
   * use when they support heterogeneous feeds.
   *
   * @return the inserted media Entry returned by the Service.
   *
   * @throws ServiceException
   *           If there is no associated GData service or the service is
   *           unable to perform the insertion.
   *
   * @throws UnsupportedOperationException
   *           If insert is not supported for the target feed.
   *
   * @throws IOException
   *           If there is an error communicating with the GData service.
   */
  protected <T extends E> T insert(MediaSource media, Class<T> mediaEntryClass)
      throws ServiceException, IOException {
    if (feedState.service == null) {
      throw new ServiceException(
          CoreErrorDomain.ERR.entryNotAssociated);
    }
    Link postLink = getEntryPostLink();
    if (postLink == null) {
      throw new UnsupportedOperationException("Media cannot be inserted");
    }
    URL postUrl = new URL(postLink.getHref());
    return ((MediaService) feedState.service).insert(postUrl, mediaEntryClass,
        media);
  }
}

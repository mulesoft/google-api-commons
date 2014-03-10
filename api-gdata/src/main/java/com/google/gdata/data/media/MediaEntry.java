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
import com.google.gdata.data.Content;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Link;
import com.google.gdata.data.MediaContent;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.ServiceException;

import org.xml.sax.Attributes;

import java.io.IOException;
import java.net.URL;

/**
 * The MediaEntry class is an abstract base class for GData services
 * that support media content.
 *
 * @param <E> the entry class for the bound subtype.
 * 
 */
public abstract class MediaEntry<E extends BaseEntry<E>> extends BaseEntry<E> 
    implements IMediaEntry {

  /**
   * Constructs a new BaseEntry instance.
   */
  protected MediaEntry() {
    super();
  }

  /**
   * Copy constructor that initializes a new BaseEntry instance to have
   * identical contents to another instance, using a shared reference to
   * the same entry state.
   * {@link com.google.gdata.data.Kind.Adaptor} subclasses
   * of {@code BaseEntry} can use this constructor to create adaptor
   * instances of an entry that share state with the original.
   */
  protected MediaEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void setService(Service v) {

    if (!(v instanceof MediaService)) {
      throw new IllegalArgumentException("Service does not support media");
    }
    super.setService(v);
  }

  public void setMediaSource(MediaSource mediaSource) {
    MediaContent content;
    if (state.content == null) {
      content = new MediaContent();
      state.content = content;
    } else if (state.content instanceof MediaContent) {
      content = (MediaContent) state.content;
    } else {
      throw new IllegalArgumentException("Cannot set media source on entry "
          + "with existing non-MediaContent: " + state.content);
    }
    content.setMediaSource(mediaSource);
    content.setMimeType(new ContentType(mediaSource.getContentType()));
  }

  public MediaSource getMediaSource() {
    if (state.content instanceof MediaContent) {
      MediaContent mediaContent = (MediaContent) state.content;
      if (mediaContent != null) {
        return mediaContent.getMediaSource();
      }
    }
    return null;
  }

  /** Retrieves the media resource edit link. */
  @Override
  @SuppressWarnings("deprecation")
  public Link getMediaEditLink() {
    Link mediaLink = getLink(Link.Rel.MEDIA_EDIT, null);
    if (mediaLink == null) {
      // Temporary back compat support for old incorrect media link value.
      // to the new value.
      mediaLink = getLink(Link.Rel.MEDIA_EDIT_BACKCOMPAT, null);
    }
    return mediaLink;
  }

  /**
   * Updates the media content associated with this entry by sending the
   * data contained in the {@link MediaSource} of the entry to the associated
   * GData service.  Can optionally update the entry content at the same time.
   *
   * @param  updateEntry  set to {code boolean} true if the current entry
   *           content should be updated with the media.
   *
   * @return the updated entry returned by the Service.
   *
   * @throws ServiceException
   *           If there is no associated GData service or the service is
   *           unable to perform the update.
   *
   * @throws com.google.gdata.util.InvalidEntryException
   *           If the entry does not contain {@code MediaContent} or
   *           there is no {@link MediaSource} associated with the content.
   *
   * @throws UnsupportedOperationException
   *           If update is not supported for the target entry.
   *
   * @throws IOException
   *           If there is an error communicating with the GData service.
   */
  @SuppressWarnings({"unchecked"})
  public E updateMedia(boolean updateEntry)
      throws IOException, ServiceException {

    MediaSource media = getMediaSource();
    if (media == null) {
      throw new NullPointerException("Must supply media source");
    }

    if (state.service == null) {
      throw new ServiceException(
          CoreErrorDomain.ERR.entryNotAssociated);
    }
    Link mediaLink = getMediaEditLink();
    if (mediaLink == null) {
      throw new UnsupportedOperationException("Media cannot be updated");
    }
    URL mediaUrl = new URL(mediaLink.getHref());

    MediaService service = (MediaService) state.service;
    if (!updateEntry) {
      return (E) service.updateMedia(mediaUrl, getClass(), media);
    }
    return (E) service.updateMedia(mediaUrl, this);
  }

  // Override content handler lookup to provide media handling.
  @Override
  protected Content.ChildHandlerInfo getContentHandlerInfo(
      ExtensionProfile extProfile, Attributes attrs)
      throws ParseException, IOException {
    // Use the extended child handler that supports out-of-line media content.
    return MediaContent.getChildHandler(extProfile, attrs);
  }
}

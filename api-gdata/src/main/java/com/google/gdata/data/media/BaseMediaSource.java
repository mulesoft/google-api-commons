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

import com.google.gdata.data.DateTime;


/**
 * The BaseMediaSource class provides an abstract base class
 * implementation of the {@link MediaSource} interface.
 *
 * 
 * @see MediaSource
 */
abstract public class BaseMediaSource implements MediaSource {

  protected final String mediaType;           // required
  protected long contentLength = -1;          // default: unknown
  protected DateTime lastModified;            // default: unknown
  protected String name;                      // default: none
  protected String etag;                      // default: unknown

  /**
   * Constructs a new BaseMediaSource of the specified content type.
   */
  protected BaseMediaSource(String mediaType) {
    this.mediaType = mediaType;
  }

  public String getContentType() { return mediaType; }

  public void setName(String name) { this.name = name; }
  public String getName() { return name; }

  public void setLastModified(DateTime lastModified) {
    this.lastModified = lastModified;
  }
  public DateTime getLastModified() { return lastModified; }

  public void setContentLength(long contentLength) {
    this.contentLength = contentLength;
  }
  public long getContentLength() { return contentLength; }

  public void setEtag(String etag) {
    this.etag = etag;
  }
  public String getEtag() { return etag; }
}

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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The MediaByteArraySource class provides a basic implementation of the
 * {@link MediaSource} interface that reads media data from an in-memory
 * byte array.  The content length of the media source defaults to the size
 * of the byte array and the time of modification to the current time.
 *
 * 
 * @see MediaSource
 */
public class MediaByteArraySource extends BaseMediaSource {

  private byte [] mediaBytes;

  /**
   * Constructs a new MediaBteyArraySource using the specified byte data
   * and content type.
   */
  public MediaByteArraySource(byte [] mediaBytes, String mediaType) {
    super(mediaType);

    this.mediaBytes = mediaBytes;
    this.contentLength = mediaBytes.length;
    this.lastModified = DateTime.now();
  }

  public InputStream getInputStream() {
    return new ByteArrayInputStream(mediaBytes);
  }

  public OutputStream getOutputStream() {
    throw new UnsupportedOperationException("Cannot write to MediaSource");
  }
}

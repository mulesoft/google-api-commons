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

import java.io.InputStream;
import java.io.OutputStream;

import javax.mail.internet.SharedInputStream;

/**
 * The MediaStreamSource class provides a basic implementation of the
 * {@link MediaSource} interface that reads media data from an existing
 * {@link InputStream}.
 *
 * 
 * @see MediaSource
 */
public class MediaStreamSource extends BaseMediaSource {

  private InputStream mediaStream;
  private long sharedMediaStreamStart;

  public MediaStreamSource(InputStream mediaStream,
                            String mediaType,
                            DateTime lastModified,
                            long contentLength) {

    super(mediaType);
    this.mediaStream = mediaStream;
    this.lastModified = lastModified;
    this.contentLength = contentLength;

    if (mediaStream instanceof SharedInputStream) {
      sharedMediaStreamStart = ((SharedInputStream)mediaStream).getPosition();
    }
  }

  public MediaStreamSource(InputStream mediaStream,
                            String mediaType) {
    this(mediaStream, mediaType, null, -1);
  }

  public InputStream getInputStream() {

    // If the underlying stream implements SharedInputStream, then get
    // a new stream so the stream source can be read multiple times.
    InputStream returnStream = (mediaStream instanceof SharedInputStream)
        ? ((SharedInputStream)mediaStream).newStream(sharedMediaStreamStart, -1)
        : mediaStream;

    return returnStream;
  }

  public OutputStream getOutputStream() {
    throw new UnsupportedOperationException(
        "Cannot write to MediaStreamSource");
  }
}

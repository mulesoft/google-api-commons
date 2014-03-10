/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.appsforyourdomain.migration;

import com.google.gdata.data.DateTime;
import com.google.gdata.data.media.MediaSource;
import com.google.gdata.util.ContentType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * {@link MediaSource} that wraps an RFC822 message in UTF8 format.
 * 
 * 
 */
public class Rfc822MediaSource implements MediaSource {

  private final String rfc822Msg;

  /**
   * Constructs a new {@code Rfc822MediaSource} from the RFC822 message in UTF-8
   * format.
   * 
   * @param rfc822Msg the text of the RFC822 message
   */
  public Rfc822MediaSource(String rfc822Msg) {
    if (rfc822Msg == null || "".equals(rfc822Msg)) {
      throw new IllegalArgumentException("Empty or null message");
    }
    this.rfc822Msg = rfc822Msg;
  }

  public long getContentLength() {
    return rfc822Msg.length();
  }

  public String getEtag() {
    return null;
  }

  public DateTime getLastModified() {
    return null;
  }

  public String getContentType() {
    return ContentType.MESSAGE_RFC822.toString();
  }

  public InputStream getInputStream() {
    return new ByteArrayInputStream(rfc822Msg.getBytes());
  }

  public String getName() {
    return "rfc822";
  }

  public OutputStream getOutputStream() {
    throw new UnsupportedOperationException();
  }

}

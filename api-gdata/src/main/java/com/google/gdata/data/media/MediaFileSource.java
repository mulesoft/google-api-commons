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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The MediaFileSource class provides a basic implementation of the
 * {@link MediaSource} interface that reads media data from a {@link File}.
 * The content length will be initialized to the file length, the last 
 * modified time to the file modification time, and the name of the source
 * will be the name (last path element) of the file.
 *
 * 
 * @see MediaSource
 */
public class MediaFileSource extends BaseMediaSource {

  private File mediaFile;

  public MediaFileSource(File mediaFile, String mediaType) {
    super(mediaType);
    
    this.mediaFile = mediaFile;
    this.contentLength = mediaFile.length();
    this.lastModified = new DateTime(mediaFile.lastModified());
    this.name = mediaFile.getName();
  }

  public InputStream getInputStream() throws IOException {
    return new FileInputStream(mediaFile);
  }

  public OutputStream getOutputStream() {
    throw new UnsupportedOperationException("Cannot write to MediaFileSource");
  }
  
  public File getMediaFile() {
    return mediaFile;
  }
}

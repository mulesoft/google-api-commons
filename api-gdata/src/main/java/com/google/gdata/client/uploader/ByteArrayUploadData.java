/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.uploader;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * An implementation of {@link UploadData} that provides data from a {@code byte[]}.
 * 
 * 
 */
public class ByteArrayUploadData implements UploadData {
  private final byte[] buffer;
  private final ByteArrayInputStream stream;
  
  public ByteArrayUploadData(byte[] buffer) {
    this.buffer = buffer;
    stream = new ByteArrayInputStream(buffer);
  }
  
  public long length() {
    return buffer.length;
  }

  public void read(byte[] destination) throws IOException {
    stream.read(destination);
  }
  
  public void setPosition(long position) {
    stream.reset();
    stream.skip(position);
  }
  
  public int read(byte[] chunk, int i, int length) {
    return stream.read(chunk, i, length);
  }
}

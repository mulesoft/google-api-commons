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

import java.io.IOException;

/**
 * A seekable, read-only buffer of data to be upload uploading. 
 * 
 * 
 */
public interface UploadData {
  /**
   * Returns the total number of bytes of data in the buffer.
   */
  public long length();
  
  /**
   * Reads up to {@code destination.length} bytes from the current position into
   * the destination buffer.
   *
   * @throws IOException if the data could not be read.
   */
  public void read(byte[] destination) throws IOException;

  /**
   * Reads up to {@code length} bytes into the {@code chunk} buffer.
   * 
   * @param i the start offset in the destination buffer.
   * @throws IOException if the data could not be read.
   */
  public int read(byte[] chunk, int i, int length) throws IOException;
  
  /**
   * Sets the offset from the start of the the source data from which the next
   * {@code read} will begin.
   *
   * @throws IOException if position is negative or past the end of the data.
   */
  public void setPosition(long position) throws IOException;
}

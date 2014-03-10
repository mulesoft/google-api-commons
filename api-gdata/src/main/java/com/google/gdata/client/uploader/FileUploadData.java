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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * An implementation of {@link UploadData} that provides data from a {@code File}.
 * 
 * 
 */
public class FileUploadData implements UploadData {

  private final File file;
  private FileInputStream stream;

  public FileUploadData(File file) throws IOException {
    if (file == null) {
      throw new IOException();
    }
    this.file = file;
    if (!file.exists() || !file.canRead()) {
      throw new IOException();
    }
    stream = new FileInputStream(file);
    
  }

  public long length() {
    return file.length();
  }
  
  public void read(byte[] destination) throws IOException {
    stream.read(destination);
  }
  
  public void setPosition(long position) throws IOException {
    stream = new FileInputStream(file);
    stream.skip(position);
  }
  
  public int read(byte[] chunk, int i, int length) throws IOException {
    return stream.read(chunk, i, length);
  }    

  /**
   * Gets the filename.
   *
   * @return the local file name
   */
  public String getFileName() {
    return file.getName();
  }
}

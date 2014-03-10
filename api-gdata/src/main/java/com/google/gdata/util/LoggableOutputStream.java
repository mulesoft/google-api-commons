/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.gdata.util;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

/**
 *
 * Logs content of the data sent to the stream if log level is
 * set to FINEST.
 *
 * 
 *
 */
public class LoggableOutputStream extends FilterOutputStream {
  private ByteArrayOutputStream bos = new ByteArrayOutputStream();

  private Logger logger;

  public LoggableOutputStream(Logger logger, OutputStream stream) {
    super(stream);
    this.logger = logger;
  }

  @Override
  public void write(int b) throws IOException {
    // Write to the original stream
    super.write(b);
    // Write also to log
    bos.write(b);
  }

  @Override
  public void close() throws IOException {
    super.close();
    logger.finest(bos.toString()); //convert using the default charset
  }

  @Override
  public void flush() throws IOException {
    super.flush();
    logger.finest(bos.toString());
    bos = new ByteArrayOutputStream();
  }
}

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

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 *
 * Logs content of the data sent to the stream if log level is
 * set to FINEST.
 *
 * 
 */

public class LoggableInputStream extends FilterInputStream {
  private final StringWriter sw = new StringWriter();
  private final Logger logger;
  private boolean closed = false;

  public LoggableInputStream(Logger logger, InputStream stream) {
    super(stream);
    this.logger = logger;
  }

  @Override
  public void close() throws IOException {
    // circumvent double close
    if (!closed){
      logger.finest(sw.toString());
      closed = true;
    }
    super.close();
  }

  @Override
  public int read() throws IOException {
    int readInt = super.read();
    sw.write(readInt);
    return readInt;
  }

  @Override
  public int read(byte[] b, int off, int len) throws IOException {
    int read = super.read(b, off, len);
    if (read > 0) {
      String s = new String(b, off, read);
      sw.write(s);
    }
    return read;
  }

  @Override
  public int read(byte[] b) throws IOException {
    int read = super.read(b);
    if (read > 0) {
      String s = new String(b, 0, read);
      sw.write(s);
    }
    return read;
  }
}

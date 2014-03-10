/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.util.common.io;

import com.google.gdata.util.common.base.Preconditions;

import java.io.Reader;
import java.io.IOException;
import java.util.Iterator;

/**
 * A {@link Reader} that will concatenates multiple readers
 *
 * 
 */
class MultiReader extends Reader {
  private final Iterator<? extends InputSupplier<? extends Reader>> it;
  private Reader current;

  MultiReader(Iterator<? extends InputSupplier<? extends Reader>> readers)
      throws IOException {
    this.it = readers;
    advance();
  }

  /**
   * Closes the current reader and opens the next one, if any.
   */
  private void advance() throws IOException {
    close();
    if (it.hasNext()) {
      current = it.next().getInput();
    }
  }

  @Override public int read(char cbuf[], int off, int len) throws IOException {
    if (current == null) {
      return -1;
    }
    int result = current.read(cbuf, off, len);
    if (result == -1) {
      advance();
      return read(cbuf, off, len);
    }
    return result;
  }

  @Override public long skip(long n) throws IOException {
    Preconditions.checkArgument(n >= 0, "n is negative");
    if (n > 0) {
      while (current != null) {
        long result = current.skip(n);
        if (result > 0) {
          return result;
        }
        advance();
      }
    }
    return 0;
  }

  @Override public boolean ready() throws IOException {
    return (current != null) && current.ready();
  }

  @Override public void close() throws IOException {
    if (current != null) {
      try {
        current.close();
      } finally {
        current = null;
      }
    }
  }
}

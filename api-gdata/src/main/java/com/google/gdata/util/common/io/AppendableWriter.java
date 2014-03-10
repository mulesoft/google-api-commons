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

import java.io.Closeable;
import java.io.Flushable;
import java.io.Writer;
import java.io.IOException;

/**
 * Writer that places all output on an {@link Appendable} target. If the target
 * is {@link Flushable} or {@link Closeable}, flush()es and close()s will also
 * be delegated to the target.
 *
 * 
 * 
 */
class AppendableWriter extends Writer {
  private final Appendable target;
  private boolean closed;

  /**
   * Creates a new writer that appends everything it writes to {@code target}.
   *
   * @param target target to which to append output
   */
  AppendableWriter(Appendable target) {
    this.target = target;
  }

  /*
   * Abstract methods from Writer
   */

  @Override public void write(char cbuf[], int off, int len)
      throws IOException {
    checkNotClosed();
    // It turns out that creating a new String is usually as fast, or faster
    // than wrapping cbuf in a light-weight CharSequence. See benchmark code
    // in comments of http://cl/9327627 and results at
    // https://spreadsheets.google.com/a/google.com/ccc?key=pABoWmCP48mrC_J8v4xh1ZA
    target.append(new String(cbuf, off, len));
  }

  @Override public void flush() throws IOException {
    checkNotClosed();
    if (target instanceof Flushable) {
      ((Flushable) target).flush();
    }
  }

  @Override public void close() throws IOException {
    this.closed = true;
    if (target instanceof Closeable) {
      ((Closeable) target).close();
    }
  }

  /*
   * Override a few functions for performance reasons to avoid creating
   * unnecessary strings.
   */

  @Override public void write(int c) throws IOException {
    checkNotClosed();
    target.append((char) c);
  }

  @Override public void write(String str) throws IOException {
    checkNotClosed();
    target.append(str);
  }

  @Override public void write(String str, int off, int len) throws IOException {
    checkNotClosed();
    // tricky: append takes start, end pair...
    target.append(str, off, off + len);
  }

  @Override public Writer append(char c) throws IOException {
    checkNotClosed();
    target.append(c);
    return this;
  }

  @Override public Writer append(CharSequence charSeq) throws IOException {
    checkNotClosed();
    target.append(charSeq);
    return this;
  }

  @Override public Writer append(CharSequence charSeq, int start, int end)
      throws IOException {
    checkNotClosed();
    target.append(charSeq, start, end);
    return this;
  }

  private void checkNotClosed() throws IOException {
    if (closed) {
      throw new IOException("Cannot write to a closed writer.");
    }
  }
}

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
import com.google.common.collect.Lists;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Queue;

/**
 * A class for reading lines of text. Provides the same functionality
 * as {@link java.io.BufferedReader#readLine()} but for all {@link Readable}
 * objects, not just instances of {@link Reader}.
 *
 * 
 */
public final class LineReader {
  private final Readable readable;
  private final Reader reader;
  private final char[] buf = new char[0x1000]; // 4K
  private final CharBuffer cbuf = CharBuffer.wrap(buf);

  private final Queue<String> lines = Lists.newLinkedList();
  private final LineBuffer lineBuf = new LineBuffer() {
    @Override protected void handleLine(String line, String end) {
      lines.add(line);
    }
  };

  /**
   * Creates a new instance that will read lines from the given
   * {@code Readable} object.
   */
  public LineReader(Readable readable) {
    Preconditions.checkNotNull(readable);
    this.readable = readable;
    this.reader = (readable instanceof Reader) ? (Reader) readable : null;
  }

  /**
   * Reads a line of text. A line is considered to be terminated by any
   * one of a line feed ({@code '\n'}), a carriage return
   * ({@code '\r'}), or a carriage return followed immediately by a linefeed
   * ({@code "\r\n"}).
   *
   * @return a {@code String} containing the contents of the line, not
   *     including any line-termination characters, or {@code null} if the
   *     end of the stream has been reached.
   * @throws IOException if an I/O error occurs
   */
  public String readLine() throws IOException {
    while (lines.peek() == null) {
      cbuf.clear();
      // The default implementation of Reader#read(CharBuffer) allocates a
      // temporary char[], so we call Reader#read(char[], int, int) instead.
      int read = (reader != null)
          ? reader.read(buf, 0, buf.length)
          : readable.read(cbuf);
      if (read == -1) {
        lineBuf.finish();
        break;
      }
      lineBuf.add(buf, 0, read);
    }
    return lines.poll();
  }
}

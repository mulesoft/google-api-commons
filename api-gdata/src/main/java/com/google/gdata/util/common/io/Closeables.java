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

import com.google.gdata.util.common.base.Nullable;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility methods for working with {@link Closeable} objects.
 *
 * 
 */
public final class Closeables {
  private static final Logger logger
      = Logger.getLogger(Closeables.class.getName());

  private Closeables() {}

  /**
   * Closes a {@link Closeable}, with control over whether an
   * {@code IOException} may be thrown. This is primarily useful in a
   * finally block, where a thrown exception needs to be logged but not
   * propagated (otherwise the original exception will be lost).
   *
   * <p>If {@code swallowIOException} is true then we never throw
   * {@code IOException} but merely log it.
   *
   * <p>Example:
   *
   * <p><pre>public void useStreamNicely() throws IOException {
   * SomeStream stream = new SomeStream("foo");
   * boolean threw = true;
   * try {
   *   // Some code which does something with the Stream. May throw a
   *   // Throwable.
   *   threw = false; // No throwable thrown.
   * } finally {
   *   // Close the stream.
   *   // If an exception occurs, only rethrow it if (threw==false).
   *   Closeables.close(stream, threw);
   * }
   * </pre>
   *
   * @param closeable the {@code Closeable} object to be closed, or null,
   *     in which case this method does nothing
   * @param swallowIOException if true, don't propagate IO exceptions
   *     thrown by the {@code close} methods
   * @throws IOException if {@code swallowIOException} is false and
   *     {@code close} throws an {@code IOException}.
   */
  public static void close(Closeable closeable,
      boolean swallowIOException) throws IOException {
    if (closeable == null) {
      return;
    }
    try {
      closeable.close();
    } catch (IOException e) {
      if (swallowIOException) {
        logger.log(Level.WARNING,
            "IOException thrown while closing Closeable.", e);
      } else {
        throw e;
      }
    }
  }

  /**
   * Equivalent to calling {@code close(closeable, true)}, but with no
   * IOException in the signature.
   * @param closeable the {@code Closeable} object to be closed, or null, in
   *      which case this method does nothing
   */
  public static void closeQuietly(Closeable closeable) {
    try {
      close(closeable, true);
    } catch (IOException e) {
      logger.log(Level.SEVERE, "IOException should not have been thrown.", e);
    }
  }
}

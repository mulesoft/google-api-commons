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

import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility methods for working with {@link Flushable} objects.
 *
 * 
 */
public final class Flushables {
  private static final Logger logger
      = Logger.getLogger(Flushables.class.getName());

  private Flushables() {}

  /**
   * Flush a {@link Flushable}, with control over whether an
   * {@code IOException} may be thrown.
   *
   * <p>If {@code swallowIOException} is true, then we don't rethrow
   * {@code IOException}, but merely log it.
   *
   * @param flushable the {@code Flushable} object to be flushed.
   * @param swallowIOException if true, don't propagate IO exceptions
   *     thrown by the {@code flush} method
   * @throws IOException if {@code swallowIOException} is false and
   *     {@link Flushable#flush} throws an {@code IOException}.
   * @see Closeables#close
   */
  public static void flush(Flushable flushable, boolean swallowIOException)
      throws IOException {
    try {
      flushable.flush();
    } catch (IOException e) {
      logger.log(Level.WARNING,
          "IOException thrown while flushing Flushable.", e);
      if (!swallowIOException) {
        throw e;
      }
    }
  }

  /**
   * Equivalent to calling {@code flush(flushable, true)}, but with no
   * {@code IOException} in the signature.
   *
   * @param flushable the {@code Flushable} object to be flushed.
   */
  public static void flushQuietly(Flushable flushable) {
    try {
      flush(flushable, true);
    } catch (IOException e) {
      logger.log(Level.SEVERE, "IOException should not have been thrown.", e);
    }
  }
}

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

import java.io.IOException;

/**
 * A callback to be used with the streaming {@code readLines} methods.
 *
 * <p>{@link #processLine} will be called for each line that is read, and
 * should return {@code false} when you want to stop processing.
 *
 * 
 * @param <T> the type of the result of processing the lines seen
 * @see Characters#readLines(InputSupplier, LineProcessor)
 * @see Files#readLines(java.io.File, java.nio.charset.Charset, LineProcessor)
 * @see Resources#readLines(java.net.URL, java.nio.charset.Charset, LineProcessor)
 */
public interface LineProcessor<T> {

  /**
   * This method will be called once for each line.
   *
   * @return true if we want to continue processing, false if we want to stop 
   */
  boolean processLine(String line) throws IOException;

  /**
   * @return the result of processing all of the lines seen
   */
  T getResult();
}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.wireformats;

import com.google.gdata.util.io.base.UnicodeReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * Utility functions shared across parser implementations.
 */
public abstract class ParserUtils {

  /**
   * This class is not meant to be instantiated.
   */
  private ParserUtils() {}

  /**
   * Returns a reader based upon the character set (encoding).
   * Use the special UnicodeReader class for Unicode encodings, to work
   * around a JDK bug related to Unicode byte order markings.
   * 
   * @param input content to parse 
   * @param cs character set (encoding) used by content
   * @return reader
   * @throws IOException if specified encoding cannot be used 
   */
  public static Reader getInputReader(InputStream input, Charset cs)
      throws IOException {
    if (cs.name().toLowerCase().startsWith("utf-")) {
      return new UnicodeReader(input, cs.name());
    }
    return new InputStreamReader(input, cs);
  }

}

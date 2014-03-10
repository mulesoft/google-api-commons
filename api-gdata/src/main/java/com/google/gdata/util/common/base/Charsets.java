/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.util.common.base;

import java.nio.charset.Charset;

/**
 * Provides references to the six standard character encodings supported by all
 * Java platform implementations.
 *
 * @see Charset
 * 
 */
public final class Charsets {
  private Charsets() {}

  /**
   * US-ASCII: seven-bit ASCII, a.k.a. ISO646-US, a.k.a the Basic Latin block of
   * the Unicode character set.
   */
  public static final Charset US_ASCII = Charset.forName("US-ASCII");

  /**
   * ISO-8859-1. ISO Latin Alphabet No. 1, a.k.a. ISO-LATIN-1.
   */
  public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

  /**
   * UTF-8: eight-bit UCS Transformation Format.
   */
  public static final Charset UTF_8 = Charset.forName("UTF-8");

  /**
   * UTF-16BE: sixteen-bit UCS Transformation Format, big-endian byte order.
   */
  public static final Charset UTF_16BE = Charset.forName("UTF-16BE");

  /**
   * UTF-16LE: sixteen-bit UCS Transformation Format, little-endian byte order.
   */
  public static final Charset UTF_16LE = Charset.forName("UTF-16LE");

  /**
   * UTF-16: sixteen-bit UCS Transformation Format, byte order identified by an
   * optional byte-order mark.
   */
  public static final Charset UTF_16 = Charset.forName("UTF-16");

  /*
   * Please do not add new Charset references to this class, unless those
   * character encodings are part of the set required to be supported by all
   * Java platform implementations! Any Charsets initialized here may cause
   * unexpected delays when this class is loaded. See the Charset Javadocs for
   * the list of built-in character encodings.
   */
}

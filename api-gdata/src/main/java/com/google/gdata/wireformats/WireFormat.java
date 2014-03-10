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

import com.google.gdata.data.XmlEventSource;
import com.google.gdata.wireformats.input.InputProperties;
import com.google.gdata.wireformats.output.OutputProperties;

import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * Top-level information about a wire format. All wire formats have an
 * associated generator and parser, plus a method to validate content
 * model metadata to ensure it's compatible with the wire format.
 */
public abstract class WireFormat {

  /**
   * XML wire format.
   */
  public static final XmlWireFormat XML = new XmlWireFormat();

  /**
   * List of all supported wire formats.
   */
  public static final List<WireFormat> ALL =

      Arrays.asList(new WireFormat [] {XML});


  /**
   * Logical name for the wire format.
   */
  protected final String name;

  /**
   * Constructs a new wire format with the specific logical name.
   * @param name wire format name.
   */
  protected WireFormat(String name) {
    this.name = name;
  }

  /**
   * Returns the wire format name.
   * @return logical name of wire format.
   */
  public String getName() {
    return name;
  }

  /**
   * Create a wire format generator.
   *
   * @param outProps the output properties to use for output
   * @param w writer where output is sent to
   * @param cs character set used to encode output
   * @param prettyPrint {@code true} if output should be in prettyprint format
   * @return wire format generator
   */
  public abstract WireFormatGenerator createGenerator(OutputProperties outProps,
      Writer w, Charset cs, boolean prettyPrint);

  /**
   * Create a wire format parser.
   *
   * @param inProps the input properties to use when parsing
   * @param r reader where input is retrieved from
   * @param cs character set used to encode output
   * @return wire format parser
   */
  public abstract WireFormatParser createParser(InputProperties inProps,
      Reader r, Charset cs);

  /**
   * Create a wire format parser for a given xml event source.  By default this
   * throws {@link UnsupportedOperationException}, subclasses can implement this
   * if they choose to.
   */
  public WireFormatParser createParser(InputProperties inProps,
      XmlEventSource source) {
    throw new UnsupportedOperationException(
        "Wire format does not support xml event sources.");
  }
}

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

/**
 * JSON wire format properties.
 */
public class XmlWireFormat extends WireFormat {

  public XmlWireFormat() {
    super("xml");
  }

  @Override
  public WireFormatGenerator createGenerator(OutputProperties outProps,
      Writer w, Charset cs, boolean prettyPrint) {
    return new XmlGenerator(outProps, w, cs, prettyPrint);
  }

  @Override
  public WireFormatParser createParser(InputProperties inProps,
      Reader r, Charset cs) {
    return new XmlParser(inProps, r, cs);
  }

  @Override
  public WireFormatParser createParser(InputProperties inProps,
      XmlEventSource source) {
    return new XmlParser(inProps, source);
  }
}

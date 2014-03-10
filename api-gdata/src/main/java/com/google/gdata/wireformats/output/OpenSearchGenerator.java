/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.wireformats.output;

import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.data.OpenSearchDescriptionDocument;
import com.google.gdata.wireformats.AltFormat;

import java.io.IOException;

/**
 * Generates the output for an OpenSearch description document
 *
 * 
 */
public class OpenSearchGenerator
    extends XmlGenerator<OpenSearchDescriptionDocument> {

  public AltFormat getAltFormat() {
    return AltFormat.OPENSEARCH;
  }

  public Class<OpenSearchDescriptionDocument> getSourceType() {
    return OpenSearchDescriptionDocument.class;
  }

  /**
   * Writes the metadata based upon the specified feed.
   * encoding.
   */
  @Override
  public void generateXml(XmlWriter xw, OutputProperties outProps, 
      OpenSearchDescriptionDocument source)
      throws IOException {

    source.generate(xw);
  }
}

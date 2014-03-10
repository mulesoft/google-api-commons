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
import com.google.gdata.data.introspection.IServiceDocument;
import com.google.gdata.data.introspection.ServiceDocument;
import com.google.gdata.wireformats.AltFormat;

import java.io.IOException;

/**
 * Generates the metadata for an Atom Service (introspection) document.
 *
 * 
 */
public class AtomServiceGenerator extends XmlGenerator<IServiceDocument> {
 
  public AltFormat getAltFormat() {
    return AltFormat.ATOM_SERVICE;
  }

  public Class<IServiceDocument> getSourceType() {
    return IServiceDocument.class;
  }

  /**
   * Writes the Service document for the target feed.
   */
  @Override
  public void generateXml(XmlWriter xw, OutputProperties outProps, 
      IServiceDocument source) throws IOException {

    if (source instanceof ServiceDocument) {
      ((ServiceDocument) source).generate(xw, outProps.getExtensionProfile());
    } else if (source != null) {
      // This case is to handle case that may return Atom content but might
      // also return no data (like DELETE)
      throw new IllegalStateException("Unexpected source type: " + 
          source.getClass());
    }
  }
}

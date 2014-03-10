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

import com.google.gdata.data.introspection.IServiceDocument;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.WireFormat;

/**
 * A dual-mode generator for atom-service.
 *
 * 
 */
public class AtomServiceDualGenerator
    extends DualModeGenerator<IServiceDocument> {

  public AtomServiceDualGenerator() {
    super(new AtomServiceGenerator());
  }

  public AltFormat getAltFormat() {
    return AltFormat.ATOM_SERVICE;
  }

  public Class<IServiceDocument> getSourceType() {
    return IServiceDocument.class;
  }

  @Override
  public WireFormat getWireFormat() {
    return WireFormat.XML;
  }
}

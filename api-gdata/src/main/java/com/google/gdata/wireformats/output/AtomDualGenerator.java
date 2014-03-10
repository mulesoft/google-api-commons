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

import com.google.gdata.data.IAtom;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.WireFormat;

/**
 * A dual-mode generator for atom.
 *
 * 
 */
public class AtomDualGenerator extends DualModeGenerator<IAtom> {

  private AltFormat altFormat = AltFormat.ATOM;

  public AtomDualGenerator() {
    super(new AtomGenerator());
  }

  public AtomDualGenerator(AltFormat altFormat) {
    super(new AtomGenerator());
    this.altFormat = altFormat;
  }

  public Class<IAtom> getSourceType() {
    return IAtom.class;
  }

  public AltFormat getAltFormat() {
    return altFormat;
  }

  @Override
  public WireFormat getWireFormat() {
    return WireFormat.XML;
  }
}

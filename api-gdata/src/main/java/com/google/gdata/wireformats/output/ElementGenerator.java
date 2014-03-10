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

import com.google.gdata.model.Element;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.WireFormat;

/**
 * The ElementGenerator class implements a simple {WireFormatOutputGenerator}
 * that can generate documents from any GDOM {@link Element} representation.
 * 
 * @param <E> the element type expected as input to the generator
 * 
 * 
 */
public class ElementGenerator<E extends Element> 
    extends WireFormatOutputGenerator<E> {
  
  public static <E extends Element> ElementGenerator<E> of(AltFormat altFormat, 
      Class<E> inputType) {
    return new ElementGenerator<E>(altFormat, inputType);
  }
  
  private final AltFormat altFormat;
  private final Class<E> inputType;
  
  private ElementGenerator(AltFormat altFormat, Class<E> inputType) {
    this.altFormat = altFormat;
    this.inputType = inputType;
  }

  @Override
  public WireFormat getWireFormat() {
    return altFormat.getWireFormat();
  }

  public AltFormat getAltFormat() {
    return altFormat;
  }

  public Class<E> getSourceType() {
    return inputType;
  }
}

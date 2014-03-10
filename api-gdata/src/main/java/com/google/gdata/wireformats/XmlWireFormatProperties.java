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

import com.google.gdata.wireformats.XmlGenerator.ElementGenerator;

/**
 * The XmlWireFormatProperties class represents the collection of properties
 * that can be optionally configured to customize XML parsing and generation.
 */
public class XmlWireFormatProperties {
  
  // Element generator used to customize XML output for an element
  private ElementGenerator elementGenerator;
  
  /**
   * Sets the {@link ElementGenerator} that should be used emit the XML
   * for an element.   A value of {@code null} indicates that the
   * default XML generation algorithm should be used.
   * 
   * @param elementGenerator the element generator.
   * @returns the target properties instance (to allow chaining)
   */
  public XmlWireFormatProperties setElementGenerator(
      ElementGenerator elementGenerator) {
    this.elementGenerator = elementGenerator;
    return this;
  }
  
  /**
   * Returns the {@link ElementGenerator} that should be used emit the XML for
   * an element. A value of {@code null} indicates that the default XML
   * generation algorithm should be used.
   * 
   * @returns elementGenerator the element generator.
   */
  public ElementGenerator getElementGenerator() {
    return elementGenerator;
  }
}

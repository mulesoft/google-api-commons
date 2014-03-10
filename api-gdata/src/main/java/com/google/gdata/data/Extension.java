/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data;

import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;

import org.xml.sax.Attributes;

import java.io.IOException;


/**
 * Interface for GData extension data types. It is designed to be hosted
 * within {@link ExtensionPoint}.
 *
 * 
 * 
 */
public interface Extension {


  /**
   * Generates an XML representation for the extension.
   *
   * @param w XML writer
   * @param extProfile extension profile
   */
  void generate(XmlWriter w, ExtensionProfile extProfile) throws IOException;


  /**
   * Gets an XML element handler for the extension.
   *
   * @param extProfile extension profile
   * @param namespace  extension namespace
   * @param localName tag name, without the namespace prefix
   * @param attrs tag attributes
   * @return an element handler
   * @throws ParseException when an unexpected tag or badly-formatted
   *   XML is detected
   */
  XmlParser.ElementHandler getHandler(ExtensionProfile extProfile,
                                      String namespace,
                                      String localName,
                                      Attributes attrs)
      throws ParseException, IOException;
}

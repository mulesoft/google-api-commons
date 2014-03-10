/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.util;

import com.google.gdata.data.XmlEventSource;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An xml parser that can also handle parsing events from an
 * {@link XmlEventSource}.
 */
public class EventSourceParser extends XmlParser {

  private static final Logger LOGGER =
      Logger.getLogger(EventSourceParser.class.getName());

  public EventSourceParser(ElementHandler rootHandler, String rootNamespace,
      String rootElementName) {
    this.rootHandler = rootHandler;
    this.rootNamespace = rootNamespace;
    this.rootElementName = rootElementName;
  }
  
  public void parse(XmlEventSource source) throws ParseException, IOException {
    try {
      source.parse(this);
    } catch (SAXException e) {
      Exception rootException = e.getException();
      if (rootException instanceof ParseException) {
        throwParseException((ParseException)rootException);
      } else if (rootException instanceof IOException) {
        LogUtils.logException(LOGGER, Level.WARNING, null, e);
        throw (IOException)rootException;
      } else {
        LogUtils.logException(LOGGER, Level.FINE, null, e);
        throw new ParseException(e);
      }
    }
  }
}
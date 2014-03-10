/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.wireformats.input;

import com.google.gdata.data.ParseSource;
import com.google.gdata.data.XmlEventSource;
import com.google.gdata.util.ServiceException;
import com.google.gdata.wireformats.AltFormat;

import java.io.IOException;
import java.io.Reader;

/**
 * The XmlInputParser class is an abstract base class supporting the creation
 * of new {@link InputParser} implementations that parse XML content.  Concrete
 * class will need to implement the both the
 * {@link #parse(Reader, InputProperties, Class)} and
 * {@link #parse(XmlEventSource, InputProperties, Class)} methods to handle
 * parsing from the two possible source types.
 */
public abstract class XmlInputParser<T> extends CharacterParser<T> {

  /**
   * Creates a new XmlInputParser instance for the provided representation and
   * result type.
   * 
   * @param altFormat parsed representation.
   * @param resultClass parser output result type.
   */
  public XmlInputParser(AltFormat altFormat, Class<T> resultClass) {
    super(altFormat, resultClass);
  }

  public <R extends T> R parse(ParseSource parseSource, InputProperties inProps,
      Class<R> targetClass) throws IOException, ServiceException {
    XmlEventSource eventSource = parseSource.getEventSource();
    if (eventSource == null) {
      return super.parse(parseSource, inProps, targetClass);
    }
    return parse(eventSource, inProps, targetClass);
  }
  
  /**
   * The parse method should be implemented by subclasses and should parse
   * input data from the provided {@link XmlEventSource} instance.
   * 
   * @param <R> result type
   * @param eventSource event source.
   * @param inProps input properties.
   * @param targetClass result type.
   * @return instance of result type.
   * @throws IOException error reading data from event source.
   * @throws ServiceException parsing error.
   */
  abstract protected <R extends T> R parse(XmlEventSource eventSource, 
      InputProperties inProps, Class<R> targetClass) 
      throws IOException, ServiceException;
}

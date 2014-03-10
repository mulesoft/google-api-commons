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

import java.io.InputStream;
import java.io.Reader;
import com.google.gdata.util.XmlParser;

/**
 * The ParseSource class represents a data input source that can be used to
 * read parseable GData content.
 */
public class ParseSource {

  // Exactly one of these will be non-null, given the contructor model.
  private final Reader reader;
  private final InputStream inputStream;
  private final XmlEventSource eventSource;

  /**
   * Constructs a new GData input source using data from a {@link Reader}.
   */
  public ParseSource(Reader reader) {
    this.reader = reader;
    this.inputStream = null;
    this.eventSource = null;
  }

  /**
   * Constructs a new GData input source using data from an {@link InputStream}.
   */
  public ParseSource(InputStream inputStream) {
    this.inputStream = inputStream;
    this.reader = null;
    this.eventSource = null;
  }

  /**
   * Constructs a new GData input source using data from an {@link XmlParser}.
   */
  public ParseSource(XmlEventSource eventSource) {
    this.eventSource = eventSource;
    this.reader = null;
    this.inputStream = null;
  }

  /**
   * Returns the {@link Reader} associated with the input source or
   * {@code null} if associated with a different source type.
   */
  final public Reader getReader() {
    return reader;
  }

  /**
   * Returns the {@link Reader} associated with the input source or
   * {@code null} if associated with a different source type.
   */
  final public InputStream getInputStream() {
    return inputStream;
  }

  /**
   * Returns the {@link Reader} associated with the input source or
   * {@code null} if associated with a different source type.
   */
  final public XmlEventSource getEventSource() {
    return eventSource;
  }
}

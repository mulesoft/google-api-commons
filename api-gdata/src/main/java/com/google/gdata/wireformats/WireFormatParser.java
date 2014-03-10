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

import com.google.gdata.model.Element;
import com.google.gdata.util.ParseException;

import java.io.IOException;

/**
 * A parser that translates wire format content into
 * a in-memory representation.
 */
public interface WireFormatParser {

  /**
   * Parse content from a source provided to the parser at
   * construction time.
   *
   * @param element root of parsed element tree
   * @return root of parsed element tree
   * @throws IOException if content cannot be accessed
   * @throws ParseException if content cannot be parsed invalid
   * @throws ContentCreationException if content cannot be created 
   * @throws ContentValidationException if content fails metadata validation
   */
  public Element parse(Element element)
      throws IOException, ParseException, ContentCreationException,
             ContentValidationException;

}

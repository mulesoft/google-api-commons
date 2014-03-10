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

import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.data.ParseSource;
import com.google.gdata.data.introspection.IServiceDocument;
import com.google.gdata.data.introspection.ServiceDocument;
import com.google.gdata.model.Element;
import com.google.gdata.util.ServiceException;
import com.google.gdata.wireformats.AltFormat;

import java.io.IOException;

/**
 * The AtomServiceDualParser class is an {@link InputParser} implementation
 * that is capable of parsing service documents into either the old or new
 * data model.
 * 
 * 
 */
public class AtomServiceDualParser 
    implements InputParser<IServiceDocument> {

  /**
   * Parser to use for old data model results
   */
  private final InputParser<ServiceDocument> dataParser = 
      new AtomServiceDataParser();

  /**
   * Parser to use for new data model results
   */
  private final InputParser<IServiceDocument> elementParser =
    ElementParser.of(AltFormat.ATOM_SERVICE, IServiceDocument.class);

  public AltFormat getAltFormat() {
    return AltFormat.ATOM_SERVICE;
  }

  public Class<IServiceDocument> getResultType() {
    return IServiceDocument.class;
  }

  public <R extends IServiceDocument> R parse(ParseSource parseSource,
      InputProperties inProps, Class<R> resultClass) throws IOException,
      ServiceException {
    Preconditions.checkNotNull(parseSource, "parseSource");
    Preconditions.checkNotNull(inProps, "inProps");
    Preconditions.checkNotNull("resultClass", resultClass);

    // Use the new data model parser for Element subtypes, otherwise the old one
    R result;
    if (Element.class.isAssignableFrom(resultClass)) {
      result = elementParser.parse(parseSource, inProps, resultClass);
    }
    if (ServiceDocument.class.isAssignableFrom(resultClass)) {
      @SuppressWarnings("unchecked")
      InputParser<R> castParser = (InputParser<R>) dataParser;
      result = castParser.parse(parseSource, inProps, resultClass);
    } else {
      throw new IllegalArgumentException("Invalid result type:" + resultClass);
    }
    return result;
  }
}

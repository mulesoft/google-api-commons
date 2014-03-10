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
import com.google.gdata.data.XmlEventSource;
import com.google.gdata.data.introspection.ServiceDocument;
import com.google.gdata.util.ServiceException;
import com.google.gdata.wireformats.AltFormat;

import java.io.IOException;
import java.io.Reader;

/**
 * The AtomServiceDataParser class provides an {@link InputParser}
 * implementation for Atom Service Documents.
 *
 * 
 */
public class AtomServiceDataParser extends XmlInputParser<ServiceDocument> {

  /**
   * Constructs a new AtomServiceDataParser.
   */
  public AtomServiceDataParser() {
    super(AltFormat.ATOM_SERVICE, ServiceDocument.class);
  }

  @Override
  protected <R extends ServiceDocument> R parse(XmlEventSource eventSource, 
      InputProperties inProps, Class<R> resultClass) {
    throw new IllegalStateException(
        "Parsing from XmlEventSource not supported");
  }

  @Override
  public <R extends ServiceDocument> R  parse(Reader inputReader, 
      InputProperties inProps, Class<R> resultClass) 
      throws IOException, ServiceException {
    Preconditions.checkNotNull(inProps.getExtensionProfile(),
    "No extension profile");

    R serviceDoc = createResult(resultClass);
    serviceDoc.parse(inProps.getExtensionProfile(), inputReader);
    return serviceDoc;
  }
}

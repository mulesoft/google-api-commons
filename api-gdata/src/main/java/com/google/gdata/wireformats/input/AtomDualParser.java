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
import com.google.gdata.data.IAtom;
import com.google.gdata.data.ParseSource;
import com.google.gdata.model.Element;
import com.google.gdata.util.ServiceException;
import com.google.gdata.wireformats.AltFormat;

import java.io.IOException;

/**
 * The AtomDualModeParser class provides an {@link InputParser} implementation
 * that is capable of parsing into classes that use the old or new data
 * model.  The actual parsing is done by delegating to an instance of the
 * {@link AtomDataParser} or {@link ElementParser} class.
 * 
 * 
 */
public class AtomDualParser implements InputParser<IAtom> {

  /**
   * Parser to use for old data model results
   */
  private final InputParser<IAtom> dataParser = new AtomDataParser();

  /**
   * Parser to use for new data model results
   */
  private final InputParser<IAtom> elementParser =
      ElementParser.of(AltFormat.ATOM, IAtom.class);

  public AltFormat getAltFormat() {
    return AltFormat.ATOM;
  }

  public Class<IAtom> getResultType() {
    return IAtom.class;
  }

  public <R extends IAtom> R parse(ParseSource parseSource,
      InputProperties inProps, Class<R> resultClass) throws IOException,
      ServiceException {
    Preconditions.checkNotNull(parseSource, "parseSource");
    Preconditions.checkNotNull(inProps, "inProps");
    Preconditions.checkNotNull("resultClass", resultClass);

    // Use the new data model parser for Element subtypes, otherwise the old one
    if (Element.class.isAssignableFrom(resultClass)) {
      return elementParser.parse(parseSource, inProps, resultClass);
    }
    return dataParser.parse(parseSource, inProps, resultClass);
  }
}

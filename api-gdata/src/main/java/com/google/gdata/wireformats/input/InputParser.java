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
import com.google.gdata.util.ServiceException;
import com.google.gdata.wireformats.AltFormat;

import java.io.IOException;

/**
 * Wire format interface implemented by helper classes that parse data from an
 * InputStream and return an object representation of a particular type.
 *
 * 
 *
 * @param <T> base type of result objects returned by the parser.
 */
public interface InputParser<T> {

  /**
   * Returns the alternate representation format that is expected as input to
   * the parser.
   */
  public AltFormat getAltFormat();

  /**
   * Returns the target type that is populated by the parser from the input
   * stream.
   */
  public Class<? extends T> getResultType();

  /**
   * Parses data in the supported representation format from the input stream
   * based upon the provided input properties into the provided target object.
   * 
   * @param parseSource providing the source of the data
   * @param inProps properties describing the input data
   * @param resultClass specific type of result expected from the parse
   */
  public <R extends T> R parse(ParseSource parseSource, InputProperties inProps,
      Class<R> resultClass) throws IOException, ServiceException;
}

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
import com.google.gdata.model.Element;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.ServiceException;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.ContentCreationException;
import com.google.gdata.wireformats.ContentValidationException;
import com.google.gdata.wireformats.WireFormat;
import com.google.gdata.wireformats.WireFormatParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

/**
 * The ElementParser class is a generic {@link InputParser} implementation for
 * {@link Element} data model types.
 *
 * 
 */
public class ElementParser<T> extends CharacterParser<T> {

  /**
   * Provides a factory method to create a new {@link ElementParser} that
   * handles a particular representation to produce a particular type of
   * result.
   *
   * @param <T> base type of parse result objects
   * @param altFormat alternate representation parsed
   * @param resultType type of result object produced
   * @return an element parser with the desired configuration
   * @throws IllegalArgumentException if the representation does not have an
   *         associated wire format that can be used to parse the content.
   */
  public static <T> ElementParser<T> of(AltFormat altFormat,
      Class<T> resultType) {
    Preconditions.checkArgument(altFormat.getWireFormat() != null,
          "No wire format defined for " + altFormat);
    return new ElementParser<T>(altFormat, resultType);
  }

  /**
   * Constructs a new ElementParser instance for parsing content in a a
   * particular representation to produce results of a specified type.
   *
   * @param altFormat parsed alternate representation
   * @param resultType expected result type
   * @throws IllegalArgumentException if the representation does not have an
   *         associated wire format that can be used to parse the content.
   */
  protected ElementParser(AltFormat altFormat, Class<T> resultType) {
    super(altFormat, resultType);
  }

  @Override
  public <R extends T> R parse(Reader inputReader, InputProperties inProps,
      Class<R> resultClass) throws IOException, ServiceException {

    Preconditions.checkNotNull(inProps.getRootMetadata(),
        "No element metadata");

    R result = createResult(resultClass);
    if (result instanceof Element) {
      Element element = (Element) result;
      WireFormat format = altFormat.getWireFormat();
      try {
        WireFormatParser parser = format.createParser(
            inProps, inputReader, Charset.forName(getCharset(inProps)));
        result = resultClass.cast(parser.parse(element));
      } catch (IllegalCharsetNameException ice) {
        throw new ParseException("Invalid charset:" + getCharset(inProps), ice);
      } catch (UnsupportedCharsetException uce) {
        throw new ParseException("Invalid charset:" + getCharset(inProps), uce);
      } catch (ContentCreationException e) {
        throw new ParseException("Unable to create element to parse into.", e);
      } catch (ContentValidationException e) {
        throw new ParseException("Error trying to parse element.", e);
      }
    } else {
      throw new ContentCreationException(
          "Result class is not an Element type: " + resultClass);
    }
    return result;
  }
}

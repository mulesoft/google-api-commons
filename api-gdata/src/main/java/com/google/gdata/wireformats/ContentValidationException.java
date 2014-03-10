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
import com.google.gdata.model.ValidationContext;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.ErrorContent;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * The ContentValidationException indicates that an instance
 * document does not conform to the content model.
 */
public class ContentValidationException extends ServiceException {

  protected ValidationContext vc;

  public ContentValidationException(String message, ValidationContext vc) {
    super(message);
    this.vc = vc;
    setResponse(ContentType.TEXT_PLAIN, vc.toString());
  }

  public ValidationContext getContext() {
    return vc;
  }

  /**
   * Converts a ContentValidationException to a parse exception, with a
   * separate exception for each parser error that was encountered.
   */
  public ParseException toParseException() {
    ParseException result = null;
    Map<Element, List<ErrorContent>> errors = vc.getErrors();
    for (Map.Entry<Element, List<ErrorContent>> entry : errors.entrySet()) {
      Element element = entry.getKey();
      String location = element.getElementKey().getId().toString();
      List<ErrorContent> codes = entry.getValue();
      for (ErrorContent errorCode : codes) {
        ParseException pe = new ParseException(errorCode);
        pe.setLocation(location);
        if (result == null) {
          result = pe;
        } else {
          result.addSibling(pe);
        }
      }
    }

    return result;
  }
}

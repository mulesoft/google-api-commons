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

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;

/**
 * Parser for the {@code atomPerson} type.
 *
 * 
 */
public class Rfc3339Handler extends XmlParser.ElementHandler {

  /** Date/time value being parsed. */
  private DateTime dateTime;
  /** @return   the timestamp */
  public DateTime getDateTime() { return dateTime; }

  /**
   * Processes this element; overrides inherited method.
   */
  @Override
  public void processEndElement() throws ParseException {
    try {
      dateTime = DateTime.parseDateTime(value);
    } catch (NumberFormatException e) {
      throw new ParseException(
          CoreErrorDomain.ERR.invalidDatetime.withInternalReason(
              "Invalid date/time format: '" + value + "'."));
    }
  }
}

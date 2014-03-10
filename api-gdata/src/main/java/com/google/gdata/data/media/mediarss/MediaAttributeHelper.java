/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.media.mediarss;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.util.ParseException;

/**
 * Helps accessing media tag attributes.
 *
 * 
 */
public class MediaAttributeHelper {

  /** Gets the value of a NPT attribute and remove it from the list. */
  public static NormalPlayTime consumeNormalPlayTime(AttributeHelper attrHelper,
      String name)
      throws ParseException {
    String value = attrHelper.consume(name, false);
    if (value == null) {
      return null;
    }

    try {
      return NormalPlayTime.parse(value);
    } catch (java.text.ParseException e) {
      throw new ParseException(
          CoreErrorDomain.ERR.invalidTimeOffset.withInternalReason(
              "Invalid time offset value for attribute '" + name + "'"),
          e);
    }
  }
}

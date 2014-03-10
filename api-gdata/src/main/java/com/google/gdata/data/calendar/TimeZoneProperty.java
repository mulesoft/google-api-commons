/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.calendar;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * GData schema extension describing timezone property of a calendar
 *
 * 
 */
public class TimeZoneProperty extends ValueConstruct {

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(TimeZoneProperty.class,
        Namespaces.gCalNs, "timezone");
  }

  public TimeZoneProperty() {
    this(null);
  }

  public TimeZoneProperty(String value) {
    super(Namespaces.gCalNs, "timezone", "value", value);
  }
}

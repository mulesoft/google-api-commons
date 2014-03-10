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
 * GData schema extension describing color property of a calendar
 *
 * 
 */
public class ColorProperty extends ValueConstruct {

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(ColorProperty.class,
        Namespaces.gCalNs, "color");
  }

  public ColorProperty() {
    this(null);
  }

  public ColorProperty(String value) {
    super(Namespaces.gCalNs, "color", "value", value);
  }
}

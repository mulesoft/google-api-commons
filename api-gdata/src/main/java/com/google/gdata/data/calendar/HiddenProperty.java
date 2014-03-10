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
 * GData schema extension describing hidden property of a calendar
 *
 * 
 */
public class HiddenProperty extends ValueConstruct {

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(HiddenProperty.class,
        Namespaces.gCalNs, "hidden");
  }

  public HiddenProperty() {
    this(null);
  }

  public HiddenProperty(String value) {
    super(Namespaces.gCalNs, "hidden", "value", value);
  }

  public static final HiddenProperty TRUE =
      new HiddenProperty("true");

  public static final HiddenProperty FALSE =
      new HiddenProperty("false");
}

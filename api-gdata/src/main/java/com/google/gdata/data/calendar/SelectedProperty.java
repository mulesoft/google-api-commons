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
 * GData schema extension describing selected property of a calendar
 *
 * 
 */
public class SelectedProperty extends ValueConstruct {

  public static final SelectedProperty TRUE =
      new SelectedProperty("true");

  public static final SelectedProperty FALSE =
      new SelectedProperty("false");

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(SelectedProperty.class,
        Namespaces.gCalNs, "selected");
  }

  public SelectedProperty() {
    this(null);
  }

  public SelectedProperty(String value) {
    super(Namespaces.gCalNs, "selected", "value", value);
  }
}

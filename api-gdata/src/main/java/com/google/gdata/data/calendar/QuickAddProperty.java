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
 * GData schema extension describing whether gd:content is for quickadd
 * processing
 *
 * 
 */
public class QuickAddProperty extends ValueConstruct {

  public static final QuickAddProperty TRUE =
      new QuickAddProperty("true");

  public static final QuickAddProperty FALSE =
      new QuickAddProperty("false");

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(QuickAddProperty.class,
        Namespaces.gCalNs, "quickadd");
  }

  public QuickAddProperty() {
    this(null);
  }

  public QuickAddProperty(String value) {
    super(Namespaces.gCalNs, "quickadd", "value", value);
  }
}

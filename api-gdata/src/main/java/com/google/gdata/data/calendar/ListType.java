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
 * GData schema extension describing calendarlist type property of a calendar
 *
 * 
 */
public class ListType extends ValueConstruct {

  public static final ListType FAVORITE =
      new ListType("favorite");

  public static final ListType ACCESSED =
      new ListType("accessed");

  public static final ListType OWNED =
      new ListType("owned");

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(ListType.class,
        Namespaces.gCalNs, "listtype");
  }

  public ListType() {
    this(null);
  }

  public ListType(String value) {
    super(Namespaces.gCalNs, "listttype", "value", value);
  }
}

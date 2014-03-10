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

/**
 * Defines a value for the realm attribute that is used only in the calendar
 * API.
 *
 * 
 */
public class CalendarExtendedProperty {

  /** Limit on who may see and modify this extended property. */
  public static final class Realm {

    /** Indicates that this extended property can be accessed or modified
     * through the current calendar. */
    public static final String CALENDAR = Namespaces.gCalPrefix + "calendar";

  }

  /** Private constructor to ensure class is not instantiated. */
  private CalendarExtendedProperty() {}

}

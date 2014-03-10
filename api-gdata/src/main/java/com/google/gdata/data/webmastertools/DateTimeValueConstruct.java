/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.webmastertools;

import com.google.gdata.data.DateTime;
import com.google.gdata.data.ValueConstruct;

/**
 * GData schema extension describing a node with a {@code DateTime} value. The
 * class is abstract, derive from this class and define default constructor
 * which hardcodes the node name.
 *
 * 
 */
public abstract class DateTimeValueConstruct extends ValueConstruct {

  /** Variable to cache the date/time value. */
  private DateTime dateTimeValue;

  /** Constructs {@link ValueConstruct} to represent DateTime value. */
  public DateTimeValueConstruct(String nodeName) {
    super(Namespaces.WT_NAMESPACE, nodeName, null);
    this.dateTimeValue = null;
  }

  /**
   * Compares {@link DateTimeValueConstruct} objects based on the date/time
   * value that they hold.
   */
  @Override
  public boolean equals(Object rhs) {
    if (!super.equals(rhs)) {
      return false;
    }

    DateTimeValueConstruct r = (DateTimeValueConstruct) rhs;
    if (dateTimeValue == null) {
      return r.dateTimeValue == null;
    }

    return dateTimeValue.equals(r.dateTimeValue);
  }

  /**
   * Returns hash code that is based on the date/time value that the object
   * holds.
   */
  @Override
  public int hashCode() {
    if (dateTimeValue == null) {
      return 0;
    }

    return dateTimeValue.hashCode();
  }

  /**
   * Override {@link ValueConstruct#setValue(String)} to validate that
   * supplied value is valid date.
   *
   * @throws NullPointerException if argument is null.
   * @throws IllegalArgumentException if argument is not a valid date.
   */
  @Override
  public void setValue(String value) {
    if (value == null) {
      throw new NullPointerException("value must not be null");
    }

    try {
      DateTime parsedValue = DateTime.parseDateTime(value);
      setDateTime(parsedValue);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid date", e);
    }
  }

  /**
   * Set date/time value.
   * 
   * @throws NullPointerException if argument is null.
   */
  public void setDateTime(DateTime value) {
    if (value == null) {
      throw new NullPointerException("value must not be null");
    }
    dateTimeValue = value;
    super.setValue(value.toString());
  }

  /** Get date/time value. */
  public DateTime getDateTime() {
    return dateTimeValue;
  }
}

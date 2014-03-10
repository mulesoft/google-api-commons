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

import com.google.gdata.data.ValueConstruct;

/**
 * GData schema extension describing a node with an integer value. The class is
 * abstract, derive from this class and define default constructor which
 * hardcodes the node name.
 *
 * 
 */
public abstract class IntValueConstruct extends ValueConstruct {

  /** Variable to cache the integer value. */
  private int intValue;
  
  /** Constructs {@link ValueConstruct} to represent integer value. */
  public IntValueConstruct(String nodeName) {
    super(Namespaces.WT_NAMESPACE, nodeName, null);
    setIntValue(0);
  }

  /**
   * Compares {@link IntValueConstruct} objects based on the integer value
   * that they hold.
   */  
  @Override
  public boolean equals(Object rhs) {
    if (!super.equals(rhs)) {
      return false;
    }

    IntValueConstruct r = (IntValueConstruct) rhs;
    return intValue == r.intValue;
  }

  /** 
   * Returns hash code which is the integer value that the object holds.
   */  
  @Override
  public int hashCode() {
    return intValue;
  }

  /**
   * Override {@link ValueConstruct#setValue(String)} to validate that
   * supplied value is integer.
   *
   * @throws NullPointerException if argument is null.
   * @throws IllegalArgumentException if argument is not a valid integer.
   */
  @Override
  public void setValue(String value) {
    if (value == null) {
      throw new NullPointerException("value can not be null");
    }

    try {
      Integer i = Integer.parseInt(value);
      setIntValue(i);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /** Set {@link Integer} value. */
  public void setIntValue(int value) {
    intValue = value;
    super.setValue(String.valueOf(value));
  }

  /** Get {@link Integer} value. */
  public int getIntValue() {
    return intValue;
  }
}

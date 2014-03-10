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
 * GData schema extension describing a node with a boolean value. The class is
 * abstract, derive from this class and define default constructor which
 * hardcodes the node name.
 *
 * 
 */
public abstract class BoolValueConstruct extends ValueConstruct {

  /** Variable to cache the boolean value. */
  private boolean boolValue;

  /**
   * Constructs {@link ValueConstruct} to represent boolean value.
   */
  public BoolValueConstruct(String nodeName) {
    super(Namespaces.WT_NAMESPACE, nodeName, null);
    setBooleanValue(false);
  }

  /**
   * Compares {@link BoolValueConstruct} objects based on the boolean value
   * that they hold.
   */
  @Override
  public boolean equals(Object rhs) {
    if (!super.equals(rhs)) {
      return false;
    }

    BoolValueConstruct r = (BoolValueConstruct) rhs;
    return boolValue == r.boolValue;
  }

  /** 
   * Returns hash code which is based on the boolean string representation.
   */
  @Override
  public int hashCode() {
    return getValue().hashCode();
  }

  /**
   * Override {@link ValueConstruct#setValue(String)} to validate that
   * supplied value is xsd:boolean which is a standard way to represent boolean
   * in XML. xsd:boolean treats "true" and "1" as true and "false" and "0" as
   * false.
   * 
   * @throws NullPointerException if the value is null.
   * @throws IllegalArgumentException if value is not valid xsd:boolean value.
   */
  @Override
  public void setValue(String value) {
    if (value == null) {
      throw new NullPointerException("value can not be null");
    }

    if ("true".equals(value) || "1".equals(value)) {
      setBooleanValue(true);
    } else if ("false".equals(value) || "0".equals(value)) {
      setBooleanValue(false);
    } else {
      throw new IllegalArgumentException("Invalid boolean value: " + value);
    }
  }

  /** Set boolean value. */
  public void setBooleanValue(boolean value) {
    boolValue = value;
    super.setValue(String.valueOf(value));
  }

  /** Get boolean value. */
  public boolean getBooleanValue() {
    return boolValue;
  }
}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.api.gbase.client;

/**
 * A number with a unit.
 *
 * @param <T> concrete type for the value, either Integer or Float
 */
public class NumberUnit<T extends Number>  {
  private final T value;
  private final String unit;

  /** Creates a new value with a unit. */
  public NumberUnit(T value, String unit) {
    this.value = value;
    this.unit = unit;
  }

  /** Gets the value. */
  public T getValue() {
    return value;
  }

  /** Gets the unit. */
  public String getUnit() {
    return unit;
  }

  /**
   * Gets the standard string representation for such
   * an object: <code>value " " unit</code>
   */
  @Override
  public String toString() {
    return value + " " + unit;
  }

  @Override
  public int hashCode() {
    return 47 * value.hashCode() + unit.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof NumberUnit)) {
      return false;
    }

    NumberUnit<? extends Number> other = (NumberUnit<? extends Number>)o;
    return value.equals(other.value) && unit.equals(other.unit);
  }
}

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

import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.util.ParseException;

/**
 * Describes how many times calendar was cleaned via Manage Calendars.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.gCalAlias,
    nsUri = Namespaces.gCal,
    localName = TimesCleanedProperty.XML_NAME)
public class TimesCleanedProperty extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "timesCleaned";

  /** XML "value" attribute name */
  private static final String VALUE = "value";

  /** Number of times calendar was cleaned */
  private Integer value = null;

  /**
   * Default mutable constructor.
   */
  public TimesCleanedProperty() {
    super();
  }

  /**
   * Immutable constructor.
   *
   * @param value number of times calendar was cleaned.
   */
  public TimesCleanedProperty(Integer value) {
    super();
    setValue(value);
    setImmutable(true);
  }

  /**
   * Returns the number of times calendar was cleaned.
   *
   * @return number of times calendar was cleaned
   */
  public Integer getValue() {
    return value;
  }

  /**
   * Sets the number of times calendar was cleaned.
   *
   * @param value number of times calendar was cleaned or <code>null</code> to
   *     reset
   */
  public void setValue(Integer value) {
    throwExceptionIfImmutable();
    this.value = value;
  }

  /**
   * Returns whether it has the number of times calendar was cleaned.
   *
   * @return whether it has the number of times calendar was cleaned
   */
  public boolean hasValue() {
    return getValue() != null;
  }

  @Override
  protected void validate() {
    if (value == null) {
      throwExceptionForMissingAttribute(VALUE);
    } else if (value < 0) {
      throw new IllegalStateException("value attribute must be non-negative: " +
          value);
    }
  }

  /**
   * Returns the extension description, specifying whether it is required, and
   * whether it is repeatable.
   *
   * @param required   whether it is required
   * @param repeatable whether it is repeatable
   * @return extension description
   */
  public static ExtensionDescription getDefaultDescription(boolean required,
      boolean repeatable) {
    ExtensionDescription desc =
        ExtensionDescription.getDefaultDescription(TimesCleanedProperty.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    generator.put(VALUE, value);
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper) throws ParseException
      {
    value = helper.consumeInteger(VALUE, true);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    TimesCleanedProperty other = (TimesCleanedProperty) obj;
    return eq(value, other.value);
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (value != null) {
      result = 37 * result + value.hashCode();
    }
    return result;
  }

  @Override
  public String toString() {
    return "{TimesCleanedProperty value=" + value + "}";
  }

}

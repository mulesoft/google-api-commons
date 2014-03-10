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
 * Describes whether to send ACL notifications to grantees.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.gCalAlias,
    nsUri = Namespaces.gCal,
    localName = SendAclNotificationsProperty.XML_NAME)
public class SendAclNotificationsProperty extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "sendAclNotifications";

  /** XML "value" attribute name */
  private static final String VALUE = "value";

  /** Whether to send ACL notifications to grantees */
  private Boolean value = null;

  /**
   * Default mutable constructor.
   */
  public SendAclNotificationsProperty() {
    super();
  }

  /**
   * Immutable constructor.
   *
   * @param value whether to send ACL notifications to grantees.
   */
  public SendAclNotificationsProperty(Boolean value) {
    super();
    setValue(value);
    setImmutable(true);
  }

  /**
   * Returns the whether to send ACL notifications to grantees.
   *
   * @return whether to send ACL notifications to grantees
   */
  public Boolean getValue() {
    return value;
  }

  /**
   * Sets the whether to send ACL notifications to grantees.
   *
   * @param value whether to send ACL notifications to grantees or
   *     <code>null</code> to reset
   */
  public void setValue(Boolean value) {
    throwExceptionIfImmutable();
    this.value = value;
  }

  /**
   * Returns whether it has the whether to send ACL notifications to grantees.
   *
   * @return whether it has the whether to send ACL notifications to grantees
   */
  public boolean hasValue() {
    return getValue() != null;
  }

  @Override
  protected void validate() {
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
        ExtensionDescription.getDefaultDescription(
        SendAclNotificationsProperty.class);
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
    value = helper.consumeBoolean(VALUE, false);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    SendAclNotificationsProperty other = (SendAclNotificationsProperty) obj;
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
    return "{SendAclNotificationsProperty value=" + value + "}";
  }

}

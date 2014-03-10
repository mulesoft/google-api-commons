/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.contacts;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * Contact's birth date.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = ContactsNamespace.GCONTACT_ALIAS,
    nsUri = ContactsNamespace.GCONTACT,
    localName = Birthday.XML_NAME)
public class Birthday extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "birthday";

  /** XML "when" attribute name */
  private static final String WHEN = "when";

  /**
   * Default mutable constructor.
   */
  public Birthday() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param when immutable birth date or <code>null</code> for a mutable birth
   *     date
   */
  public Birthday(String when) {
    super(ContactsNamespace.GCONTACT_NS, XML_NAME, WHEN, when);
  }

  /**
   * Returns the birth date.
   *
   * @return birth date
   */
  public String getWhen() {
    return getValue();
  }

  /**
   * Sets the birth date.
   *
   * @param when birth date or <code>null</code> to reset
   */
  public void setWhen(String when) {
    setValue(when);
  }

  /**
   * Returns whether it has the birth date.
   *
   * @return whether it has the birth date
   */
  public boolean hasWhen() {
    return hasValue();
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
        ExtensionDescription.getDefaultDescription(Birthday.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{Birthday when=" + getValue() + "}";
  }

}


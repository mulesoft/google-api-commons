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
 * Element that if present marks that a group is a system one.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = ContactsNamespace.GCONTACT_ALIAS,
    nsUri = ContactsNamespace.GCONTACT,
    localName = SystemGroup.XML_NAME)
public class SystemGroup extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "systemGroup";

  /** XML "id" attribute name */
  private static final String ID = "id";

  /**
   * Default mutable constructor.
   */
  public SystemGroup() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param id immutable identifier for distinguishing various system groups or
   *     <code>null</code> for a mutable identifier for distinguishing various
   *     system groups
   */
  public SystemGroup(String id) {
    super(ContactsNamespace.GCONTACT_NS, XML_NAME, ID, id);
  }

  /**
   * Returns the identifier for distinguishing various system groups.
   *
   * @return identifier for distinguishing various system groups
   */
  public String getId() {
    return getValue();
  }

  /**
   * Sets the identifier for distinguishing various system groups.
   *
   * @param id identifier for distinguishing various system groups or
   *     <code>null</code> to reset
   */
  public void setId(String id) {
    setValue(id);
  }

  /**
   * Returns whether it has the identifier for distinguishing various system
   * groups.
   *
   * @return whether it has the identifier for distinguishing various system
   *     groups
   */
  public boolean hasId() {
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
        ExtensionDescription.getDefaultDescription(SystemGroup.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{SystemGroup id=" + getValue() + "}";
  }

}


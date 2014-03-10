/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * Describes a worksheet where the table lives.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.gSpreadAlias,
    nsUri = Namespaces.gSpread,
    localName = Worksheet.XML_NAME)
public class Worksheet extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "worksheet";

  /** XML "name" attribute name */
  private static final String NAME = "name";

  /**
   * Default mutable constructor.
   */
  public Worksheet() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param name immutable worksheet name or <code>null</code> for a mutable
   *     worksheet name
   */
  public Worksheet(String name) {
    super(Namespaces.gSpreadNs, XML_NAME, NAME, name);
  }

  /**
   * Returns the worksheet name.
   *
   * @return worksheet name
   */
  public String getName() {
    return getValue();
  }

  /**
   * Sets the worksheet name.
   *
   * @param name worksheet name or <code>null</code> to reset
   */
  public void setName(String name) {
    setValue(name);
  }

  /**
   * Returns whether it has the worksheet name.
   *
   * @return whether it has the worksheet name
   */
  public boolean hasName() {
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
        ExtensionDescription.getDefaultDescription(Worksheet.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{Worksheet name=" + getValue() + "}";
  }

}

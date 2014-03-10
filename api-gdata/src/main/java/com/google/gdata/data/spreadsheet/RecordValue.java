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
 * Describes a value in a column of the record entry.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.gSpreadCustomAlias,
    nsUri = Namespaces.gSpreadCustom,
    localName = RecordValue.XML_NAME)
public class RecordValue extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "*";

  /**
   * Default mutable constructor.
   */
  public RecordValue() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable displayed value of the cell or <code>null</code> for
   *     a mutable displayed value of the cell
   */
  public RecordValue(String value) {
    super(Namespaces.gSpreadCustomNs, XML_NAME, null, value);
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
        ExtensionDescription.getDefaultDescription(RecordValue.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{RecordValue value=" + getValue() + "}";
  }

}

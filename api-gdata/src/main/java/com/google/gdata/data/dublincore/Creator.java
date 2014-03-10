/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.dublincore;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * Entity primarily responsible for making the resource.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = DublincoreNamespace.DC_ALIAS,
    nsUri = DublincoreNamespace.DC,
    localName = Creator.XML_NAME)
public class Creator extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "creator";

  /**
   * Default mutable constructor.
   */
  public Creator() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable value or <code>null</code> for a mutable value
   */
  public Creator(String value) {
    super(DublincoreNamespace.DC_NS, XML_NAME, null, value);
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
        ExtensionDescription.getDefaultDescription(Creator.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{Creator value=" + getValue() + "}";
  }

}

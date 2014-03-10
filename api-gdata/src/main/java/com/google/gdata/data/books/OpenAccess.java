/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.books;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * Describes an open access.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = BooksNamespace.GBS_ALIAS,
    nsUri = BooksNamespace.GBS,
    localName = OpenAccess.XML_NAME)
public class OpenAccess extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "openAccess";

  /** XML "value" attribute name */
  private static final String VALUE = "value";

  /** Programmatic value that describes whether the volume is in Open Access. */
  public static final class Value {

    /** Open access disabled. */
    public static final String DISABLED = BooksNamespace.GBS_PREFIX +
        "disabled";

    /** Open access enabled. */
    public static final String ENABLED = BooksNamespace.GBS_PREFIX + "enabled";

  }

  /**
   * Default mutable constructor.
   */
  public OpenAccess() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable programmatic value that describes whether the volume
   *     is in Open Access or <code>null</code> for a mutable programmatic value
   *     that describes whether the volume is in Open Access
   */
  public OpenAccess(String value) {
    super(BooksNamespace.GBS_NS, XML_NAME, VALUE, value);
    setRequired(false);
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
        ExtensionDescription.getDefaultDescription(OpenAccess.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{OpenAccess value=" + getValue() + "}";
  }

}

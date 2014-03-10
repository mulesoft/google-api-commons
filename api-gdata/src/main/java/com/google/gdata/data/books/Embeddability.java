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
 * Describes an embeddability.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = BooksNamespace.GBS_ALIAS,
    nsUri = BooksNamespace.GBS,
    localName = Embeddability.XML_NAME)
public class Embeddability extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "embeddability";

  /** XML "value" attribute name */
  private static final String VALUE = "value";

  /** Programmatic value that describes the embeddability of a volume in Google
   * Book Search. */
  public static final class Value {

    /** Volume preview can be embedded. */
    public static final String EMBEDDABLE = BooksNamespace.GBS_PREFIX +
        "embeddable";

    /** Volume preview can not be embedded. */
    public static final String NOT_EMBEDDABLE = BooksNamespace.GBS_PREFIX +
        "not_embeddable";

  }

  /**
   * Default mutable constructor.
   */
  public Embeddability() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable programmatic value that describes the embeddability
   *     of a volume in Google Book Search or <code>null</code> for a mutable
   *     programmatic value that describes the embeddability of a volume in
   *     Google Book Search
   */
  public Embeddability(String value) {
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
        ExtensionDescription.getDefaultDescription(Embeddability.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{Embeddability value=" + getValue() + "}";
  }

}

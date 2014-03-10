/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.sidewiki;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * The thumbnail for a user portrait or the web page a Sidewiki entry is about.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = SidewikiNamespace.SIDEWIKI_ALIAS,
    nsUri = SidewikiNamespace.SIDEWIKI,
    localName = SidewikiThumbnail.XML_NAME)
public class SidewikiThumbnail extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "thumbnail";

  /**
   * Default mutable constructor.
   */
  public SidewikiThumbnail() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable thumbnail url or <code>null</code> for a mutable
   *     thumbnail url
   */
  public SidewikiThumbnail(String value) {
    super(SidewikiNamespace.SIDEWIKI_NS, XML_NAME, null, value);
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
        ExtensionDescription.getDefaultDescription(SidewikiThumbnail.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{SidewikiThumbnail value=" + getValue() + "}";
  }

}


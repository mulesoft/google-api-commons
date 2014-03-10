/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.photos;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * Photo image source.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.PHEED_ALIAS,
    nsUri = Namespaces.PHEED,
    localName = PheedImageUrl.XML_NAME)
public class PheedImageUrl extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "imgsrc";

  /**
   * Default mutable constructor.
   */
  public PheedImageUrl() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable image url or <code>null</code> for a mutable image
   *     url
   */
  public PheedImageUrl(String value) {
    super(Namespaces.PHEED_NS, XML_NAME, null, value);
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
        ExtensionDescription.getDefaultDescription(PheedImageUrl.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{PheedImageUrl value=" + getValue() + "}";
  }

}

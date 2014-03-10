/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.sites;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * An element indicating the name of a site as used in urls.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = SitesNamespace.SITES_ALIAS,
    nsUri = SitesNamespace.SITES,
    localName = SiteName.XML_NAME)
public class SiteName extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "siteName";

  /**
   * Default mutable constructor.
   */
  public SiteName() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable value or <code>null</code> for a mutable value
   */
  public SiteName(String value) {
    super(SitesNamespace.SITES_NS, XML_NAME, null, value);
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
        ExtensionDescription.getDefaultDescription(SiteName.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{SiteName value=" + getValue() + "}";
  }

}


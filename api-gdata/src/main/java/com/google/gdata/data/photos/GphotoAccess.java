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
 * Access level for an album, either public or unlisted.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.PHOTOS_ALIAS,
    nsUri = Namespaces.PHOTOS,
    localName = GphotoAccess.XML_NAME)
public class GphotoAccess extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "access";

  /** Access level. */
  public static final class Value {

    /** Unlisted album access. */
    public static final String PRIVATE = "private";

    /** Protected album access. */
    public static final String PROTECTED = "protected";

    /** Public album access. */
    public static final String PUBLIC = "public";

  }

  /**
   * Default mutable constructor.
   */
  public GphotoAccess() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable access level or <code>null</code> for a mutable
   *     access level
   */
  public GphotoAccess(String value) {
    super(Namespaces.PHOTOS_NAMESPACE, XML_NAME, null, value);
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
        ExtensionDescription.getDefaultDescription(GphotoAccess.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{GphotoAccess value=" + getValue() + "}";
  }

}

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
 * Canonical name of the album this entity is in.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.PHOTOS_ALIAS,
    nsUri = Namespaces.PHOTOS,
    localName = GphotoAlbumCanonicalTitle.XML_NAME)
public class GphotoAlbumCanonicalTitle extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "albumctitle";

  /**
   * Default mutable constructor.
   */
  public GphotoAlbumCanonicalTitle() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable canonical name of the album or <code>null</code> for
   *     a mutable canonical name of the album
   */
  public GphotoAlbumCanonicalTitle(String value) {
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
        ExtensionDescription.getDefaultDescription(
        GphotoAlbumCanonicalTitle.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{GphotoAlbumCanonicalTitle value=" + getValue() + "}";
  }

}

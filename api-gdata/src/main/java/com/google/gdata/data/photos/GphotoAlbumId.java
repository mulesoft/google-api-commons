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
 * The album ID that the entity is contained in.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.PHOTOS_ALIAS,
    nsUri = Namespaces.PHOTOS,
    localName = GphotoAlbumId.XML_NAME)
public class GphotoAlbumId extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "albumid";

  /**
   * Default mutable constructor.
   */
  public GphotoAlbumId() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable albumId or <code>null</code> for a mutable albumId
   */
  public GphotoAlbumId(String value) {
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
        ExtensionDescription.getDefaultDescription(GphotoAlbumId.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{GphotoAlbumId value=" + getValue() + "}";
  }


  public static GphotoAlbumId from(Long id) {
    return new GphotoAlbumId(id == null ? null : Long.toString(id));
  }
}

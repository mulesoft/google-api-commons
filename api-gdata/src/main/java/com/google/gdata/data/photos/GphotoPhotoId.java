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
 * The photo ID that the entity is contained in.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.PHOTOS_ALIAS,
    nsUri = Namespaces.PHOTOS,
    localName = GphotoPhotoId.XML_NAME)
public class GphotoPhotoId extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "photoid";

  /**
   * Default mutable constructor.
   */
  public GphotoPhotoId() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable photoId or <code>null</code> for a mutable photoId
   */
  public GphotoPhotoId(String value) {
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
        ExtensionDescription.getDefaultDescription(GphotoPhotoId.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{GphotoPhotoId value=" + getValue() + "}";
  }


  public static GphotoPhotoId from(Long id) {
    return new GphotoPhotoId(id == null ? null : Long.toString(id));
  }
}

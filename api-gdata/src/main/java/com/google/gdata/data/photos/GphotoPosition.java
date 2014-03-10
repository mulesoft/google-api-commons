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

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.util.ParseException;

/**
 * The position of a photo in its album.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.PHOTOS_ALIAS,
    nsUri = Namespaces.PHOTOS,
    localName = GphotoPosition.XML_NAME)
public class GphotoPosition extends AbstractExtension {

  /** XML element name */
  static final String XML_NAME = "position";

  /** Position in album */
  private Float value = null;

  /**
   * Default mutable constructor.
   */
  public GphotoPosition() {
    super();
  }

  /**
   * Immutable constructor.
   *
   * @param value position in album.
   */
  public GphotoPosition(Float value) {
    super();
    setValue(value);
    setImmutable(true);
  }

  /**
   * Returns the position in album.
   *
   * @return position in album
   */
  public Float getValue() {
    return value;
  }

  /**
   * Sets the position in album.
   *
   * @param value position in album or <code>null</code> to reset
   */
  public void setValue(Float value) {
    throwExceptionIfImmutable();
    this.value = value;
  }

  /**
   * Returns whether it has the position in album.
   *
   * @return whether it has the position in album
   */
  public boolean hasValue() {
    return getValue() != null;
  }

  @Override
  protected void validate() {
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
        ExtensionDescription.getDefaultDescription(GphotoPosition.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    generator.setContent(value.toString());
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper) throws ParseException
      {
    value = helper.consumeFloat(null, false);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    GphotoPosition other = (GphotoPosition) obj;
    return eq(value, other.value);
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (value != null) {
      result = 37 * result + value.hashCode();
    }
    return result;
  }

  @Override
  public String toString() {
    return "{GphotoPosition value=" + value + "}";
  }

}

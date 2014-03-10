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
 * The number of bytes used by the album.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.PHOTOS_ALIAS,
    nsUri = Namespaces.PHOTOS,
    localName = GphotoBytesUsed.XML_NAME)
public class GphotoBytesUsed extends AbstractExtension {

  /** XML element name */
  static final String XML_NAME = "bytesUsed";

  /** Number of bytes used */
  private Long value = null;

  /**
   * Default mutable constructor.
   */
  public GphotoBytesUsed() {
    super();
  }

  /**
   * Immutable constructor.
   *
   * @param value number of bytes used.
   */
  public GphotoBytesUsed(Long value) {
    super();
    setValue(value);
    setImmutable(true);
  }

  /**
   * Returns the number of bytes used.
   *
   * @return number of bytes used
   */
  public Long getValue() {
    return value;
  }

  /**
   * Sets the number of bytes used.
   *
   * @param value number of bytes used or <code>null</code> to reset
   */
  public void setValue(Long value) {
    throwExceptionIfImmutable();
    this.value = value;
  }

  /**
   * Returns whether it has the number of bytes used.
   *
   * @return whether it has the number of bytes used
   */
  public boolean hasValue() {
    return getValue() != null;
  }

  @Override
  protected void validate() {
    if (value != null && value < 0) {
      throw new IllegalStateException("Text content must be non-negative: " +
          value);
    }
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
        ExtensionDescription.getDefaultDescription(GphotoBytesUsed.class);
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
    value = helper.consumeLong(null, false);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    GphotoBytesUsed other = (GphotoBytesUsed) obj;
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
    return "{GphotoBytesUsed value=" + value + "}";
  }

}

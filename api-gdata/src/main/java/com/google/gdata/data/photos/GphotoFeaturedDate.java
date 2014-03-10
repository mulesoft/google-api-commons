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

import java.util.Date;

/**
 * Datetime in unix timestamp format for when the photo was featured.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.PHOTOS_ALIAS,
    nsUri = Namespaces.PHOTOS,
    localName = GphotoFeaturedDate.XML_NAME)
public class GphotoFeaturedDate extends AbstractExtension {

  /** XML element name */
  static final String XML_NAME = "featuredDate";

  /** Featured date */
  private Long value = null;

  /**
   * Default mutable constructor.
   */
  public GphotoFeaturedDate() {
    super();
  }

  /**
   * Immutable constructor.
   *
   * @param value featured date.
   */
  public GphotoFeaturedDate(Long value) {
    super();
    setValue(value);
    setImmutable(true);
  }

  /**
   * Returns the featured date.
   *
   * @return featured date
   */
  public Long getValue() {
    return value;
  }

  /**
   * Sets the featured date.
   *
   * @param value featured date or <code>null</code> to reset
   */
  public void setValue(Long value) {
    throwExceptionIfImmutable();
    this.value = value;
  }

  /**
   * Returns whether it has the featured date.
   *
   * @return whether it has the featured date
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
        ExtensionDescription.getDefaultDescription(GphotoFeaturedDate.class);
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
    GphotoFeaturedDate other = (GphotoFeaturedDate) obj;
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
    return "{GphotoFeaturedDate value=" + value + "}";
  }


  public GphotoFeaturedDate(Date value) {
    this(value == null ? null : value.getTime());
  }
}

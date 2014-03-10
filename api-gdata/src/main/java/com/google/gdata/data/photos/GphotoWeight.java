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
 * The number of items this tag appears on.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.PHOTOS_ALIAS,
    nsUri = Namespaces.PHOTOS,
    localName = GphotoWeight.XML_NAME)
public class GphotoWeight extends AbstractExtension {

  /** XML element name */
  static final String XML_NAME = "weight";

  /** Tag weight */
  private Integer value = null;

  /**
   * Default mutable constructor.
   */
  public GphotoWeight() {
    super();
  }

  /**
   * Immutable constructor.
   *
   * @param value tag weight.
   */
  public GphotoWeight(Integer value) {
    super();
    setValue(value);
    setImmutable(true);
  }

  /**
   * Returns the tag weight.
   *
   * @return tag weight
   */
  public Integer getValue() {
    return value;
  }

  /**
   * Sets the tag weight.
   *
   * @param value tag weight or <code>null</code> to reset
   */
  public void setValue(Integer value) {
    throwExceptionIfImmutable();
    this.value = value;
  }

  /**
   * Returns whether it has the tag weight.
   *
   * @return whether it has the tag weight
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
        ExtensionDescription.getDefaultDescription(GphotoWeight.class);
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
    value = helper.consumeInteger(null, false);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    GphotoWeight other = (GphotoWeight) obj;
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
    return "{GphotoWeight value=" + value + "}";
  }

}

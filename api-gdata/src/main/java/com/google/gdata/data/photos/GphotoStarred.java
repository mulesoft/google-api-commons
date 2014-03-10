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
 * If viewer starred the photo and total number of stars.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.PHOTOS_ALIAS,
    nsUri = Namespaces.PHOTOS,
    localName = GphotoStarred.XML_NAME)
public class GphotoStarred extends AbstractExtension {

  /** XML element name */
  static final String XML_NAME = "starred";

  /** XML "total" attribute name */
  private static final String TOTAL = "total";

  /** Number of stars */
  private Integer total = null;

  /** Viewer starred photo */
  private Boolean value = null;

  /**
   * Default mutable constructor.
   */
  public GphotoStarred() {
    super();
  }

  /**
   * Immutable constructor.
   *
   * @param total number of stars.
   * @param value viewer starred photo.
   */
  public GphotoStarred(Integer total, Boolean value) {
    super();
    setTotal(total);
    setValue(value);
    setImmutable(true);
  }

  /**
   * Returns the number of stars.
   *
   * @return number of stars
   */
  public Integer getTotal() {
    return total;
  }

  /**
   * Sets the number of stars.
   *
   * @param total number of stars or <code>null</code> to reset
   */
  public void setTotal(Integer total) {
    throwExceptionIfImmutable();
    this.total = total;
  }

  /**
   * Returns whether it has the number of stars.
   *
   * @return whether it has the number of stars
   */
  public boolean hasTotal() {
    return getTotal() != null;
  }

  /**
   * Returns the viewer starred photo.
   *
   * @return viewer starred photo
   */
  public Boolean getValue() {
    return value;
  }

  /**
   * Sets the viewer starred photo.
   *
   * @param value viewer starred photo or <code>null</code> to reset
   */
  public void setValue(Boolean value) {
    throwExceptionIfImmutable();
    this.value = value;
  }

  /**
   * Returns whether it has the viewer starred photo.
   *
   * @return whether it has the viewer starred photo
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
        ExtensionDescription.getDefaultDescription(GphotoStarred.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    generator.put(TOTAL, total);
    generator.setContent(value.toString());
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper) throws ParseException
      {
    total = helper.consumeInteger(TOTAL, false);
    value = helper.consumeBoolean(null, false);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    GphotoStarred other = (GphotoStarred) obj;
    return eq(total, other.total)
        && eq(value, other.value);
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (total != null) {
      result = 37 * result + total.hashCode();
    }
    if (value != null) {
      result = 37 * result + value.hashCode();
    }
    return result;
  }

  @Override
  public String toString() {
    return "{GphotoStarred total=" + total + " value=" + value + "}";
  }

}

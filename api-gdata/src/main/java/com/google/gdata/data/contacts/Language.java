/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.contacts;

import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.util.ParseException;

/**
 * Contact's language field.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = ContactsNamespace.GCONTACT_ALIAS,
    nsUri = ContactsNamespace.GCONTACT,
    localName = Language.XML_NAME)
public class Language extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "language";

  /** XML "code" attribute name */
  private static final String CODE = "code";

  /** XML "label" attribute name */
  private static final String LABEL = "label";

  /** Code */
  private String code = null;

  /** Label */
  private String label = null;

  /**
   * Default mutable constructor.
   */
  public Language() {
    super();
  }

  /**
   * Immutable constructor.
   *
   * @param code code.
   * @param label label.
   */
  public Language(String code, String label) {
    super();
    setCode(code);
    setLabel(label);
    setImmutable(true);
  }

  /**
   * Returns the code.
   *
   * @return code
   */
  public String getCode() {
    return code;
  }

  /**
   * Sets the code.
   *
   * @param code code or <code>null</code> to reset
   */
  public void setCode(String code) {
    throwExceptionIfImmutable();
    this.code = code;
  }

  /**
   * Returns whether it has the code.
   *
   * @return whether it has the code
   */
  public boolean hasCode() {
    return getCode() != null;
  }

  /**
   * Returns the label.
   *
   * @return label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Sets the label.
   *
   * @param label label or <code>null</code> to reset
   */
  public void setLabel(String label) {
    throwExceptionIfImmutable();
    this.label = label;
  }

  /**
   * Returns whether it has the label.
   *
   * @return whether it has the label
   */
  public boolean hasLabel() {
    return getLabel() != null;
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
        ExtensionDescription.getDefaultDescription(Language.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    generator.put(CODE, code);
    generator.put(LABEL, label);
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper) throws ParseException
      {
    code = helper.consume(CODE, false);
    label = helper.consume(LABEL, false);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    Language other = (Language) obj;
    return eq(code, other.code)
        && eq(label, other.label);
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (code != null) {
      result = 37 * result + code.hashCode();
    }
    if (label != null) {
      result = 37 * result + label.hashCode();
    }
    return result;
  }

  @Override
  public String toString() {
    return "{Language code=" + code + " label=" + label + "}";
  }

}


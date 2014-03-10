/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

/**
 * Person's family name.
 *
 * 
 */
public class FamilyName extends Element {

  /**
   * The key for this element.
   */
  public static final ElementKey<String,
      FamilyName> KEY = ElementKey.of(new QName(Namespaces.gNs, "familyName"),
      String.class, FamilyName.class);

  /**
   * Pronunciation help.
   */
  public static final AttributeKey<String> YOMI = AttributeKey.of(new
      QName(null, "yomi"), String.class);

  /**
   * Registers the metadata for this element.
   */
  public static void registerMetadata(MetadataRegistry registry) {
    if (registry.isRegistered(KEY)) {
      return;
    }

    // The builder for this element
    ElementCreator builder = registry.build(KEY);

    // Local properties
    builder.addAttribute(YOMI);
  }

  /**
   * Constructs an instance using the default key.
   */
  public FamilyName() {
    super(KEY);
  }

  /**
   * Subclass constructor, allows subclasses to supply their own element key.
   */
  protected FamilyName(ElementKey<String, ? extends FamilyName> key) {
    super(key);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link Element} instance. Will use the given {@link ElementKey} as the key
   * for the element. This constructor is used when adapting from one element
   * key to another. You cannot call this constructor directly, instead use
   * {@link Element#createElement(ElementKey, Element)}.
   *
   * @param key The key to use for this element.
   * @param source source element
   */
  protected FamilyName(ElementKey<String, ? extends FamilyName> key,
      Element source) {
    super(key, source);
  }

  /**
   * Constructs a new instance with the given value.
   *
   * @param value value.
   */
  public FamilyName(String value) {
    this();
    setValue(value);
  }

  @Override
  public FamilyName lock() {
    return (FamilyName) super.lock();
  }

  /**
   * Returns the value.
   *
   * @return value
   */
  public String getValue() {
    return super.getTextValue(KEY);
  }

  /**
   * Sets the value.
   *
   * @param value value or {@code null} to reset
   * @return this to enable chaining setters
   */
  public FamilyName setValue(String value) {
    super.setTextValue(value);
    return this;
  }

  /**
   * Returns whether it has the value.
   *
   * @return whether it has the value
   */
  public boolean hasValue() {
    return super.hasTextValue();
  }

  /**
   * Returns the pronunciation help.
   *
   * @return pronunciation help
   */
  public String getYomi() {
    return super.getAttributeValue(YOMI);
  }

  /**
   * Sets the pronunciation help.
   *
   * @param yomi pronunciation help or {@code null} to reset
   * @return this to enable chaining setters
   */
  public FamilyName setYomi(String yomi) {
    super.setAttributeValue(YOMI, yomi);
    return this;
  }

  /**
   * Returns whether it has the pronunciation help.
   *
   * @return whether it has the pronunciation help
   */
  public boolean hasYomi() {
    return super.hasAttribute(YOMI);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    FamilyName other = (FamilyName) obj;
    return eq(getValue(), other.getValue())
        && eq(getYomi(), other.getYomi());
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (getValue() != null) {
      result = 37 * result + getValue().hashCode();
    }
    if (getYomi() != null) {
      result = 37 * result + getYomi().hashCode();
    }
    return result;
  }
}



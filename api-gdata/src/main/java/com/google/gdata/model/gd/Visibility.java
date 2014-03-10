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
 * Describes the base set of values for event visibility.  Similar to CLASS in
 * RFC 2445.
 *
 * 
 */
public class Visibility extends Element {

  /** Value. */
  public static final class Value {

    /** Allow some readers to see the event. */
    public static final String CONFIDENTIAL = Namespaces.gPrefix +
        "event.confidential";

    /** Inherit the behavior from the preferences of the owner of the calendar
     * on which the event appears. */
    public static final String DEFAULT = Namespaces.gPrefix + "event.default";

    /** Allow fewest readers to see the event. */
    public static final String PRIVATE = Namespaces.gPrefix + "event.private";

    /** Allow most readers to see the event. */
    public static final String PUBLIC = Namespaces.gPrefix + "event.public";

    /** Array containing all available values. */
    private static final String[] ALL_VALUES = {
      CONFIDENTIAL,
      DEFAULT,
      PRIVATE,
      PUBLIC};

    /** Returns an array of all values defined in this class. */
    public static String[] values() {
      return ALL_VALUES;
    }

    private Value() {}
  }

  /**
   * The key for this element.
   */
  public static final ElementKey<Void,
      Visibility> KEY = ElementKey.of(new QName(Namespaces.gNs, "visibility"),
      Void.class, Visibility.class);

  /**
   * Value.
   */
  public static final AttributeKey<String> VALUE = AttributeKey.of(new
      QName(null, "value"), String.class);

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
    builder.addAttribute(VALUE).setRequired(true);
  }

  /**
   * Constructs an instance using the default key.
   */
  public Visibility() {
    super(KEY);
  }

  /**
   * Subclass constructor, allows subclasses to supply their own element key.
   */
  protected Visibility(ElementKey<?, ? extends Visibility> key) {
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
  protected Visibility(ElementKey<?, ? extends Visibility> key,
      Element source) {
    super(key, source);
  }

  @Override
  public Visibility lock() {
    return (Visibility) super.lock();
  }

  /**
   * Returns the value.
   *
   * @return value
   */
  public String getValue() {
    return super.getAttributeValue(VALUE);
  }

  /**
   * Sets the value.
   *
   * @param value value or {@code null} to reset
   * @return this to enable chaining setters
   */
  public Visibility setValue(String value) {
    super.setAttributeValue(VALUE, value);
    return this;
  }

  /**
   * Returns whether it has the value.
   *
   * @return whether it has the value
   */
  public boolean hasValue() {
    return super.hasAttribute(VALUE);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    Visibility other = (Visibility) obj;
    return eq(getValue(), other.getValue());
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (getValue() != null) {
      result = 37 * result + getValue().hashCode();
    }
    return result;
  }
}



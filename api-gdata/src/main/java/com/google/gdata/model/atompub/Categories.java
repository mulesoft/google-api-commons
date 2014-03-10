/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model.atompub;

import com.google.common.collect.Maps;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.atom.Category;
import com.google.gdata.util.Namespaces;

import java.util.List;
import java.util.Map;

/**
 * Value of the app:categories tag.
 *
 * 
 */
public class Categories extends Element {

  /** Indicates whether the list of categories is a fixed or an open set. */
  public enum Fixed {

    /** Is not fixed. */
    NO,

    /** Is fixed. */
    YES;

    /**
     * Returns the string representation of this instance, suitable for use in
     * output. This is a lowercase version of the name.
     */
    @Override
    public String toString() {
      return name().toLowerCase();
    }

    private static final Map<String, Fixed> VALUE_MAP = Maps.newHashMap();
    static {
      for (Fixed value : Fixed.values()) {
        VALUE_MAP.put(value.toString(), value);
      }
    }

    /**
     * Convert from a string representation of Fixed to an instance. Unlike
     * {@code valueOf(String)} this method will return null if an enum for the
     * given value does not exist.
     *
     * @param value the string representation to look up.
     * @return an instance if one matched the given string, or {@code null} if
     *     none was found.
     */
    public static Fixed fromString(String value) {
      return VALUE_MAP.get(value);
    }
  }

  /**
   * The key for this element.
   */
  public static final ElementKey<Void,
      Categories> KEY = ElementKey.of(new QName(Namespaces.atomPubStandardNs,
      "categories"), Void.class, Categories.class);

  /**
   * Indicates whether the list of categories is a fixed or an open set.
   */
  public static final AttributeKey<Fixed> FIXED = AttributeKey.of(new
      QName(null, "fixed"), Fixed.class);

  /**
   * An IRI reference to a Category Document.
   */
  public static final AttributeKey<String> HREF = AttributeKey.of(new
      QName(null, "href"), String.class);

  /**
   * Default scheme of the contained category elements.
   */
  public static final AttributeKey<String> SCHEME = AttributeKey.of(new
      QName(null, "scheme"), String.class);

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
    builder.addAttribute(FIXED);
    builder.addAttribute(HREF);
    builder.addAttribute(SCHEME);
    builder.addElement(Category.KEY).setCardinality(
        ElementMetadata.Cardinality.MULTIPLE);
  }

  /**
   * Constructs an instance using the default key.
   */
  public Categories() {
    super(KEY);
  }

  /**
   * Subclass constructor, allows subclasses to supply their own element key.
   */
  protected Categories(ElementKey<?, ? extends Categories> key) {
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
  protected Categories(ElementKey<?, ? extends Categories> key,
      Element source) {
    super(key, source);
  }

  @Override
  public Categories lock() {
    return (Categories) super.lock();
  }

  /**
   * Returns the categories.
   *
   * @return categories
   */
  public List<Category> getCategories() {
    return super.getElements(Category.KEY);
  }

  /**
   * Adds a new category.
   *
   * @param category category
   */
  public Categories addCategory(Category category) {
    super.addElement(Category.KEY, category);
    return this;
  }

  /**
   * Removes an existing category.
   *
   * @param category category
   * @return true if the category was removed
   */
  public boolean removeCategory(Category category) {
    return super.removeElement(category);
  }

  /**
   * Removes all existing category instances.
   */
  public void clearCategories() {
    super.removeElement(Category.KEY);
  }

  /**
   * Returns whether it has the categories.
   *
   * @return whether it has the categories
   */
  public boolean hasCategories() {
    return super.hasElement(Category.KEY);
  }

  /**
   * Returns the indicates whether the list of categories is a fixed or an open
   * set.
   *
   * @return indicates whether the list of categories is a fixed or an open set
   */
  public Fixed getFixed() {
    return super.getAttributeValue(FIXED);
  }

  /**
   * Sets the indicates whether the list of categories is a fixed or an open
   * set.
   *
   * @param fixed indicates whether the list of categories is a fixed or an open
   *     set or {@code null} to reset
   * @return this to enable chaining setters
   */
  public Categories setFixed(Fixed fixed) {
    super.setAttributeValue(FIXED, fixed);
    return this;
  }

  /**
   * Returns whether it has the indicates whether the list of categories is a
   * fixed or an open set.
   *
   * @return whether it has the indicates whether the list of categories is a
   *     fixed or an open set
   */
  public boolean hasFixed() {
    return super.hasAttribute(FIXED);
  }

  /**
   * Returns the an IRI reference to a Category Document.
   *
   * @return an IRI reference to a Category Document
   */
  public String getHref() {
    return super.getAttributeValue(HREF);
  }

  /**
   * Sets the an IRI reference to a Category Document.
   *
   * @param href an IRI reference to a Category Document or {@code null} to
   *     reset
   * @return this to enable chaining setters
   */
  public Categories setHref(String href) {
    super.setAttributeValue(HREF, href);
    return this;
  }

  /**
   * Returns whether it has the an IRI reference to a Category Document.
   *
   * @return whether it has the an IRI reference to a Category Document
   */
  public boolean hasHref() {
    return super.hasAttribute(HREF);
  }

  /**
   * Returns the default scheme of the contained category elements.
   *
   * @return default scheme of the contained category elements
   */
  public String getScheme() {
    return super.getAttributeValue(SCHEME);
  }

  /**
   * Sets the default scheme of the contained category elements.
   *
   * @param scheme default scheme of the contained category elements or {@code
   *     null} to reset
   * @return this to enable chaining setters
   */
  public Categories setScheme(String scheme) {
    super.setAttributeValue(SCHEME, scheme);
    return this;
  }

  /**
   * Returns whether it has the default scheme of the contained category
   * elements.
   *
   * @return whether it has the default scheme of the contained category
   *     elements
   */
  public boolean hasScheme() {
    return super.hasAttribute(SCHEME);
  }

}



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
 * Describes an exception to a recurring event.
 *
 * 
 */
public class RecurrenceException extends Element {

  /**
   * The key for this element.
   */
  public static final ElementKey<Void,
      RecurrenceException> KEY = ElementKey.of(new QName(Namespaces.gNs,
      "recurrenceException"), Void.class, RecurrenceException.class);

  /**
   * Whether the exception is specialized.
   */
  public static final AttributeKey<Boolean> SPECIALIZED = AttributeKey.of(new
      QName(null, "specialized"), Boolean.class);

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
    builder.addAttribute(SPECIALIZED).setRequired(true);
    builder.addElement(RecurrenceExceptionEntryLink.KEY).setRequired(true);
  }

  /**
   * Constructs an instance using the default key.
   */
  public RecurrenceException() {
    super(KEY);
  }

  /**
   * Subclass constructor, allows subclasses to supply their own element key.
   */
  protected RecurrenceException(ElementKey<?,
      ? extends RecurrenceException> key) {
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
  protected RecurrenceException(ElementKey<?,
      ? extends RecurrenceException> key, Element source) {
    super(key, source);
  }

  @Override
  public RecurrenceException lock() {
    return (RecurrenceException) super.lock();
  }

  /**
   * Returns the nested entry providing the details about the exception.
   *
   * @return nested entry providing the details about the exception
   */
  public RecurrenceExceptionEntryLink getEntryLink() {
    return super.getElement(RecurrenceExceptionEntryLink.KEY);
  }

  /**
   * Sets the nested entry providing the details about the exception.
   *
   * @param entryLink nested entry providing the details about the exception or
   *     {@code null} to reset
   * @return this to enable chaining setters
   */
  public RecurrenceException setEntryLink(RecurrenceExceptionEntryLink
      entryLink) {
    super.setElement(RecurrenceExceptionEntryLink.KEY, entryLink);
    return this;
  }

  /**
   * Returns whether it has the nested entry providing the details about the
   * exception.
   *
   * @return whether it has the nested entry providing the details about the
   *     exception
   */
  public boolean hasEntryLink() {
    return super.hasElement(RecurrenceExceptionEntryLink.KEY);
  }

  /**
   * Returns the whether the exception is specialized.
   *
   * @return whether the exception is specialized
   */
  public Boolean getSpecialized() {
    return super.getAttributeValue(SPECIALIZED);
  }

  /**
   * Sets the whether the exception is specialized.
   *
   * @param specialized whether the exception is specialized or {@code null} to
   *     reset
   * @return this to enable chaining setters
   */
  public RecurrenceException setSpecialized(Boolean specialized) {
    super.setAttributeValue(SPECIALIZED, specialized);
    return this;
  }

  /**
   * Returns whether it has the whether the exception is specialized.
   *
   * @return whether it has the whether the exception is specialized
   */
  public boolean hasSpecialized() {
    return super.hasAttribute(SPECIALIZED);
  }

}



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

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;

/**
 * Describes an entry link used by a recurrence exception.
 *
 * 
 */
public class RecurrenceExceptionEntryLink extends EntryLink {

  /**
   * The key for this element.
   */
  @SuppressWarnings("hiding")
  public static final ElementKey<Void,
      RecurrenceExceptionEntryLink> KEY = ElementKey.of(EntryLink.KEY.getId(),
      Void.class, RecurrenceExceptionEntryLink.class);

  /**
   * Registers the metadata for this element.
   */
  public static void registerMetadata(MetadataRegistry registry) {
    if (registry.isRegistered(KEY)) {
      return;
    }

    // Register superclass metadata.
    EntryLink.registerMetadata(registry);

    // The builder for this element
    ElementCreator builder = registry.build(KEY);

    // Overridden elements
    builder.replaceElement(RecurrenceExceptionEntry.KEY);
  }

  /**
   * Constructs an instance using the default key.
   */
  public RecurrenceExceptionEntryLink() {
    super(KEY);
  }

  /**
   * Subclass constructor, allows subclasses to supply their own element key.
   */
  protected RecurrenceExceptionEntryLink(ElementKey<?,
      ? extends RecurrenceExceptionEntryLink> key) {
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
  protected RecurrenceExceptionEntryLink(ElementKey<?,
      ? extends RecurrenceExceptionEntryLink> key, Element source) {
    super(key, source);
  }

  @Override
  public RecurrenceExceptionEntryLink lock() {
    return (RecurrenceExceptionEntryLink) super.lock();
  }

  /**
   * Returns the nested entry.
   *
   * @return nested entry
   */
  @Override
  public RecurrenceExceptionEntry getEntry() {
    return super.getElement(RecurrenceExceptionEntry.KEY);
  }

  /**
   * Sets the nested entry.
   *
   * @param entry nested entry or {@code null} to reset
   * @return this to enable chaining setters
   */
  public RecurrenceExceptionEntryLink setEntry(RecurrenceExceptionEntry entry) {
    super.setElement(RecurrenceExceptionEntry.KEY, entry);
    return this;
  }

  /**
   * Returns whether it has the nested entry.
   *
   * @return whether it has the nested entry
   */
  public boolean hasEntry() {
    return super.hasElement(RecurrenceExceptionEntry.KEY);
  }

}



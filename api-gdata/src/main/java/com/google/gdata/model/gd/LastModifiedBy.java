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
import com.google.gdata.model.QName;
import com.google.gdata.model.atom.Person;
import com.google.gdata.util.Namespaces;

/**
 * The user who last modified the object.
 *
 * 
 */
public class LastModifiedBy extends Person {

  /**
   * The key for this element.
   */
  @SuppressWarnings("hiding")
  public static final ElementKey<Void,
      LastModifiedBy> KEY = ElementKey.of(new QName(Namespaces.gNs,
      "lastModifiedBy"), Void.class, LastModifiedBy.class);

  /**
   * Registers the metadata for this element.
   */
  public static void registerMetadata(MetadataRegistry registry) {
    if (registry.isRegistered(KEY)) {
      return;
    }

    // Register superclass metadata.
    Person.registerMetadata(registry);

    // The builder for this element
    ElementCreator builder = registry.build(KEY);
  }

  /**
   * Constructs an instance using the default key.
   */
  public LastModifiedBy() {
    super(KEY);
  }

  /**
   * Subclass constructor, allows subclasses to supply their own element key.
   */
  protected LastModifiedBy(ElementKey<?, ? extends LastModifiedBy> key) {
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
  protected LastModifiedBy(ElementKey<?, ? extends LastModifiedBy> key,
      Element source) {
    super(key, source);
  }

  @Override
  public LastModifiedBy lock() {
    return (LastModifiedBy) super.lock();
  }

}



/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model.atom;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

import java.net.URI;

/**
 * Contributor element, modifies {@link Person} to add contributor QName.
 *
 * 
 */
public class Contributor extends Person {

  /**
   * The key for this element.
   */
  @SuppressWarnings("hiding")
  public static final ElementKey<Void, Contributor> KEY = ElementKey.of(
      new QName(Namespaces.atomNs, "contributor"), Contributor.class);

  /**
   * Registers the metadata for this element.
   */
  public static void registerMetadata(MetadataRegistry registry) {
    if (registry.isRegistered(KEY)) {
      return;
    }

    // Register superclass metadata.
    Person.registerMetadata(registry);

    registry.build(KEY);
  }

  /**
   * Constructs a new Contributor instance. Default metadata is associated with
   * this instance.
   */
  public Contributor() {
    super(KEY);
  }

  /**
   * Constructs a new Contributor instance with the given metadata.
   */
  protected Contributor(ElementKey<?, ?> key) {
    super(key);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link Element} instance. Will use the given {@link ElementKey} as the
   * key for the element.
   *
   * @param key the element key to use for this element.
   * @param source source element
   */
  protected Contributor(ElementKey<?, ? extends Contributor> key,
      Element source) {
    super(key, source);
  }

  /**
   * Constructs a new Contributor instance with the given name.
   */
  public Contributor(String name) {
    super(KEY, name);
  }

  /**
   * Constructs a new Contributor instance with the given name, uri, and email.
   */
  public Contributor(String name, URI uri, String email) {
    super(KEY, name, uri, email);
  }
}

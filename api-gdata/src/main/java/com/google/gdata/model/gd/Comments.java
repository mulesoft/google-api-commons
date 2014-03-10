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
import com.google.gdata.util.Namespaces;

/**
 * Describes a container of a feed link for comment entries.
 *
 * 
 */
public class Comments extends Element {

  /**
   * The key for this element.
   */
  public static final ElementKey<Void,
      Comments> KEY = ElementKey.of(new QName(Namespaces.gNs, "comments"),
      Void.class, Comments.class);

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
    builder.addElement(FeedLink.KEY).setRequired(true);
  }

  /**
   * Constructs an instance using the default key.
   */
  public Comments() {
    super(KEY);
  }

  /**
   * Subclass constructor, allows subclasses to supply their own element key.
   */
  protected Comments(ElementKey<?, ? extends Comments> key) {
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
  protected Comments(ElementKey<?, ? extends Comments> key, Element source) {
    super(key, source);
  }

  @Override
  public Comments lock() {
    return (Comments) super.lock();
  }

  /**
   * Returns the nested feed link.
   *
   * @return nested feed link
   */
  public FeedLink getFeedLink() {
    return super.getElement(FeedLink.KEY);
  }

  /**
   * Sets the nested feed link.
   *
   * @param feedLink nested feed link or {@code null} to reset
   * @return this to enable chaining setters
   */
  public Comments setFeedLink(FeedLink feedLink) {
    super.setElement(FeedLink.KEY, feedLink);
    return this;
  }

  /**
   * Returns whether it has the nested feed link.
   *
   * @return whether it has the nested feed link
   */
  public boolean hasFeedLink() {
    return super.hasElement(FeedLink.KEY);
  }

}



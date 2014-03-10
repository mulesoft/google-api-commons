/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model.batch;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

/**
 * Identifies an entry inside of a batch feed.
 *
 * 
 */
public class BatchId extends Element {

  /**
   * The key for this element.
   */
  public static final ElementKey<String, BatchId> KEY = ElementKey.of(
      new QName(Namespaces.batchNs, "id"), String.class, BatchId.class);

  /**
   * Registers the metadata for this element.
   */
  public static void registerMetadata(MetadataRegistry registry) {
    if (registry.isRegistered(KEY)) {
      return;
    }

    registry.build(KEY);
  }

  /**
   * Convenience method for getting a batchId from
   * an element if it's there.
   *
   * @param element element to get id from.
   * @return the id or {@code null} if it's not defined.
   */
  public static String getIdFrom(Element element) {
    BatchId tag = element.getElement(KEY);
    return tag == null ? null : tag.getId();
  }

  /**
   * Default mutable constructor.
   */
  public BatchId() {
    super(KEY);
  }

  /**
   * Constructs a new instance with the given value.
   *
   * @param id value.
   */
  public BatchId(String id) {
    this();
    setId(id);
  }

  /**
   * Returns the value.
   *
   * @return value
   */
  public String getId() {
    return (String) super.getTextValue();
  }

  /**
   * Sets the value.
   *
   * @param id value or <code>null</code> to reset
   */
  public BatchId setId(String id) {
    super.setTextValue(id);
    return this;
  }

  /**
   * Returns whether it has the value.
   *
   * @return whether it has the value
   */
  public boolean hasId() {
    return super.hasTextValue();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    BatchId other = (BatchId) obj;
    return eq(getId(), other.getId());
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (getId() != null) {
      result = 37 * result + getId().hashCode();
    }
    return result;
  }

  @Override
  public String toString() {
    return "{BatchId id=" + getTextValue() + "}";
  }
}

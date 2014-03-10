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

import com.google.gdata.data.batch.BatchOperationType;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

/**
 * Describes the batch operation to apply.
 *
 * 
 */
public class BatchOperation extends Element {

  /**
   * The key for this element.
   */
  public static final ElementKey<Void, BatchOperation> KEY = ElementKey.of(
      new QName(Namespaces.batchNs, "operation"), BatchOperation.class);

  /**
   * The operation type.
   */
  public static final AttributeKey<BatchOperationType> TYPE = AttributeKey.of(
      new QName("type"), BatchOperationType.class);

  /**
   * Registers the metadata for this element.
   */
  public static void registerMetadata(MetadataRegistry registry) {
    if (registry.isRegistered(KEY)) {
      return;
    }

    ElementCreator builder = registry.build(KEY);
    builder.addAttribute(TYPE).setRequired(true);
  }

  /**
   * Default mutable constructor.
   */
  public BatchOperation() {
    super(KEY);
  }

  /**
   * Constructs a new instance with the given operation type.
   *
   * @param type operation type.
   */
  public BatchOperation(BatchOperationType type) {
    this();
    setType(type);
  }

  /**
   * Returns the operation type.
   *
   * @return operation type
   */
  public BatchOperationType getType() {
    return getAttributeValue(TYPE);
  }

  /**
   * Sets the operation type.
   *
   * @param type operation type or <code>null</code> to reset
   */
  public BatchOperation setType(BatchOperationType type) {
    setAttributeValue(TYPE, type);
    return this;
  }

  /**
   * Returns whether it has the operation type.
   *
   * @return whether it has the operation type
   */
  public boolean hasType() {
    return getType() != null;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    BatchOperation other = (BatchOperation) obj;
    return eq(getType(), other.getType());
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (getType() != null) {
      result = 37 * result + getType().hashCode();
    }
    return result;
  }

  @Override
  public String toString() {
    return "{BatchOperation type=" + getAttributeValue(TYPE) + "}";
  }
}

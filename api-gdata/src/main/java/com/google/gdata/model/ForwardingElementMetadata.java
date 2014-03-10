/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model;

import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.ParseException;
import com.google.gdata.wireformats.ContentCreationException;

import java.util.Collection;

/**
 * The ForwardingElementMetadata abstract class provides a simple delegating
 * ElementMetadata implementation.  It can be subclassed to create transient
 * element metadata instances that override or modify selected behaviors without
 * requiring the creation of a new registered metadata type.
 *
 * 
 */
public abstract class ForwardingElementMetadata<D, E extends Element>
    implements ElementMetadata<D, E> {

  /**
   * Returns the delegate element metadata instance that is the delegation
   * target for this forwarding instance.
   */
  abstract protected ElementMetadata<D, E> delegate();

  public ElementKey<?, ?> adapt(String kind) {
    return delegate().adapt(kind);
  }

  public ElementMetadata<D, E> bind(MetadataContext context) {
    return delegate().bind(context);
  }

  public <K> AttributeMetadata<K> bindAttribute(AttributeKey<K> key) {
    return delegate().bindAttribute(key);
  }

  public <K, L extends Element> ElementMetadata<K, L> bindElement(
      ElementKey<K, L> key) {
    return delegate().bindElement(key);
  }

  public E createElement() throws ContentCreationException {
    return delegate().createElement();
  }

  public AttributeKey<?> findAttribute(QName id) {
    return delegate().findAttribute(id);
  }

  public ElementKey<?, ?> findElement(QName id) {
    return delegate().findElement(id);
  }

  public Collection<AttributeKey<?>> getAttributes() {
    return delegate().getAttributes();
  }

  public Cardinality getCardinality() {
    return delegate().getCardinality();
  }

  public Collection<ElementKey<?, ?>> getElements() {
    return delegate().getElements();
  }

  public ElementKey<D, E> getKey() {
    return delegate().getKey();
  }

  public Object getProperties() {
    return delegate().getProperties();
  }

  public ElementValidator getValidator() {
    return delegate().getValidator();
  }

  public boolean isContentRequired() {
    return delegate().isContentRequired();
  }

  public boolean isDeclared(AttributeKey<?> key) {
    return delegate().isDeclared(key);
  }

  public boolean isDeclared(ElementKey<?, ?> element) {
    return delegate().isDeclared(element);
  }

  public boolean isReferenced() {
    return delegate().isReferenced();
  }

  public boolean isSelected(Element e) {
    return delegate().isSelected(e);
  }
  
  public boolean isFlattened() {
    return delegate().isFlattened();
  }

  public void validate(ValidationContext vc, Element e) {
    delegate().validate(vc, e);
  }

  public Object generateValue(Element element, ElementMetadata<?, ?> metadata) {
    return delegate().generateValue(element, metadata);
  }

  public MetadataContext getContext() {
    return delegate().getContext();
  }

  public QName getName() {
    return delegate().getName();
  }

  public ElementKey<?, ?> getParent() {
    return delegate().getParent();
  }
  
  public Schema getSchema() {
    return delegate().getSchema();
  }

  public boolean isRequired() {
    return delegate().isRequired();
  }

  public boolean isVisible() {
    return delegate().isVisible();
  }

  public void parseValue(Element element, ElementMetadata<?, ?> metadata,
      Object value) throws ParseException {
    delegate().parseValue(element, metadata, value);
  }

  public MultipleVirtualElement getMultipleVirtualElement() {
    return delegate().getMultipleVirtualElement();
  }

  public SingleVirtualElement getSingleVirtualElement() {
    return delegate().getSingleVirtualElement();
  }

  public XmlNamespace getDefaultNamespace() {
    return delegate().getDefaultNamespace();
  }

  public Collection<XmlNamespace> getReferencedNamespaces() {
    return delegate().getReferencedNamespaces();
  } 
}

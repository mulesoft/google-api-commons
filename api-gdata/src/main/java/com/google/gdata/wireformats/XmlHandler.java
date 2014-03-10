/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.wireformats;

import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.QName;
import com.google.gdata.model.ValidationContext;
import com.google.gdata.util.ParseException;

import org.xml.sax.Attributes;

import java.io.IOException;
import java.util.List;

/**
 * XML handler that translates XML content from a wire format into
 * an in-memory representation.
 */
public class XmlHandler extends XmlParser.ElementHandler {

  /**
   * Validation context, used to accumulate metadata validation
   * errors discovered during parsing.
   */
  protected final ValidationContext vc;

  /**
   * Parent element, if non-null the element will be added to the parent after
   * it has been fully parsed.
   */
  protected final Element parentElement;

  /** Metadata for this element. */
  protected final ElementMetadata<?, ?> metadata;

  /**
   * Element being parsed.
   */
  protected final Element element;

  /**
   * Construct an xml parser that will add the element to its parent after
   * parsing is completed.
   */
  public XmlHandler(ValidationContext vc, Element parent,
      Element element, ElementMetadata<?, ?> metadata) {
    this.vc = vc;
    this.parentElement = parent;
    this.element = element;
    this.metadata = metadata;
  }

  /**
   * @return element that was parsed
   */
  public Element getElement() {
    return element;
  }

  @Override
  public void processAttribute(QName qn, String value)
      throws ParseException {

    if (element.hasAttribute(qn)) {
      throw new ParseException(
          CoreErrorDomain.ERR.duplicateAttributeValue.withInternalReason(
              "Duplicate value for attribute " + qn));
    }
    AttributeKey<?> attKey = (metadata == null) ? null
        : metadata.findAttribute(qn);
    if (attKey != null) {
      element.setAttributeValue(attKey, ObjectConverter.getValue(value, attKey.getDatatype()));
    } else {
      element.setAttributeValue(qn, value);
    }
  }

  /**
   * Default child handler for xml.  This will parse into a {@link Element} if
   * the element has not been declared, otherwise it will parse into the type
   * defined by the metadata.
   *
   * @throws ParseException if a non-repeating element is repeated, or if the
   *     element type requested cannot be created.
   * @throws IOException from overriding code.  Not thrown by the default
   *     implementation.
   */
  @Override
  public XmlHandler getChildHandler(QName qName, Attributes attrs,
      List<XmlNamespace> namespaces)
      throws ParseException, IOException {

    ElementMetadata<?, ?> childMeta = findMetadata(qName);
    Element childElement = createChildElement(qName, childMeta);

    // "SET" cardinality elements cannot be added to the parent element until
    // fully initialized, otherwise we'll have duplicates.  So we track the
    // parent element and add to it after the element has been processed.
    Element parent;
    if (childMeta != null && childMeta.getCardinality() == Cardinality.SET) {
      parent = element;
    } else {
      element.addElement(childElement);
      parent = null;
    }
    return createHandler(qName, parent, childElement, childMeta);
  }

  /**
   * Hook to allow subclasses to change the type of handler being returned.
   */
  protected XmlHandler createHandler(QName qName, Element parent,
      Element child, ElementMetadata<?, ?> metadata) {
    return new XmlHandler(vc, parent, child, metadata);
  }

  /**
   * Returns the appropriate metadata to use for the given qualified name.
   */
  protected ElementMetadata<?, ?> findMetadata(QName qName) {

    if (metadata == null) {
      return null;
    }

    ElementKey<?, ?> childKey = metadata.findElement(qName);
    if (childKey == null) {
      return null;
    }

    ElementMetadata<?, ?> childMeta = metadata.bindElement(childKey);

    return childMeta;
  }

  /**
   * Create a child element for the given name and metadata.
   */
  protected Element createChildElement(QName qName,
      ElementMetadata<?, ?> metadata) throws ParseException {

    if (metadata == null) {
      return new Element(qName);
    }

    try {
      return metadata.createElement();
    } catch (ContentCreationException e) {
      // to ElementHandler interface?
      throw new ParseException(e);
    }
  }

  @Override
  public void processEndElement() throws ParseException {

    if (value != null) {
      value = value.trim();
      if (!value.equals("")) {
        ElementKey<?, ?> elementKey = element.getElementKey();
        element.setTextValue(
            ObjectConverter.getValue(value, elementKey.getDatatype()));
      }
    }

    if (parentElement != null) {
      parentElement.addElement(element);
    }
  }
}

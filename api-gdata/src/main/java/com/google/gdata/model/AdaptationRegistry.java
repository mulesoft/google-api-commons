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

import java.util.Map;

/**
 * An immutable registry of adaptation information for a particular piece
 * of metadata.  Supports getting an adaptation and querying for attributes or
 * elements that match a particular name.
 *
 * <p>An adaptation is a customization of a base type to a variant of that type
 * based on a particular key, represented using a string.  For example, Content
 * elements can be adapted to particular Content variants based on the mime
 * type of the Content.  This is also used for adapting Entry elements to a
 * particular Entry subtype.  See
 * {@link ElementCreator#adapt(String, ElementKey)} for more on
 * adaptations and their uses.
 *
 * <p>This registry is provided primarily to handle lookup of element and
 * attribute names during parsing. If an adaptation defines an attribute or
 * child element that the base class does not, the metadata for the adaptation
 * will be used for that attribute or element, rather than parsing it as
 * undeclared data. If multiple adaptations define the same attribute or child
 * element in incompatible ways, undeclared metadata will be used and the
 * correct metadata will be applied during resolution.
 *
 * 
 */
class AdaptationRegistry {

  /**
   * Map from adaptation keys to the metadata for that adaptation.
   */
  private final Map<String, ElementKey<?, ?>> adaptations;

  /**
   * The union of attributes for this element and any adaptors.
   */
  private final Map<QName, AttributeKey<?>> attributes;

  /**
   * The union of elements for this element and any adaptors.
   */
  private final Map<QName, ElementKey<?, ?>> elements;

  /**
   * Constructs a new adaptation registry.
   */
  AdaptationRegistry(Map<String, ElementKey<?, ?>> adaptations,
      Map<QName, AttributeKey<?>> attributes,
      Map<QName, ElementKey<?, ?>> elements) {
    this.adaptations = adaptations;
    this.attributes = attributes;
    this.elements = elements;
  }

  /**
   * Returns the adaptation for a particular kind.
   */
  ElementKey<?, ?> getAdaptation(String kind) {
    return adaptations.get(kind);
  }

  /**
   * Finds the first matching parent/attribute pair with the given id.
   */
  AttributeKey<?> findAttribute(QName id) {
    return attributes.get(id);
  }

  /**
   * Finds the first matching parent/child pair with the given id.
   */
  ElementKey<?, ?> findElement(QName id) {
    return elements.get(id);
  }
}

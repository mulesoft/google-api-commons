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

import com.google.gdata.client.CoreErrorDomain;

/**
 * Default {@link ElementValidator} implementation that validates an
 * {@link Element} based upon constraints expressed in its
 * {@link ElementMetadata}.
 *
 * 
 */
public class MetadataValidator implements ElementValidator {

  public void validate(ValidationContext vc, Element e,
      ElementMetadata<?, ?> metadata) {

    ElementKey<?, ?> key = metadata.getKey();

    // Check text node content.
    if (e.hasTextValue()) {
      if (key.getDatatype() == Void.class) {
        vc.addError(e,
            CoreErrorDomain.ERR.invalidTextContent.withInternalReason(
                "Element " + key.getId() + " must not contain text content."));
      }

    } else if (key.getDatatype() != Void.class
        && metadata.isContentRequired()) {
      vc.addError(e, CoreErrorDomain.ERR.missingTextContent.withInternalReason(
          "Element " + key.getId() + " must contain a text content value."));
    }

    // Check that all required attributes are present.
    for (AttributeKey<?> attributeKey : metadata.getAttributes()) {
      AttributeMetadata<?> attMeta = metadata.bindAttribute(attributeKey);
      if (attMeta.isRequired() &&  e.getAttributeValue(attributeKey) == null) {
        vc.addError(e, CoreErrorDomain.ERR.missingAttribute.withInternalReason(
            "Element must contain value for attribute "
            + attributeKey.getId()));
      }
    }

    // Check that all required child elements are present.
    for (ElementKey<?, ?> childKey : metadata.getElements()) {
      ElementMetadata<?, ?> childMeta = metadata.bindElement(childKey);
      if (childMeta.isRequired() && !e.hasElement(childKey)) {
        vc.addError(e,
            CoreErrorDomain.ERR.missingExtensionElement.withInternalReason(
                "Element must contain a child named " + childKey.getId()));
      }
    }
  }
}

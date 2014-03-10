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

import com.google.gdata.util.ParseException;
import com.google.gdata.wireformats.ObjectConverter;

/**
 * Immutable implementation of the attribute metadata.  Delegates to the
 * registry for binding to an alternate context, so this class can be extremely
 * simple and fast.
 *
 * 
 */
final class AttributeMetadataImpl<D> extends MetadataImpl<D>
    implements AttributeMetadata<D> {

  // The key for the attribute this metadata represents.
  private final AttributeKey<D> attKey;

  /**
   * Construct a new immutable attribute metadata for the given declared
   * data.
   */
  AttributeMetadataImpl(Schema schema,
      AttributeTransform transform, ElementKey<?, ?> parent,
      AttributeKey<D> key, MetadataContext context) {
    super(schema, transform, parent, key, context);

    this.attKey = key;
  }

  /**
   * Binds this attribute metadata to a different context.  Reuses the current
   * parent and attribute keys and just has the schema bind to a different
   * context.
   */
  public AttributeMetadata<D> bind(MetadataContext context) {
    return schema.bind(parent, attKey, context);
  }

  @Override
  public AttributeKey<D> getKey() {
    return attKey;
  }

  @Override
  public Object generateValue(Element element, ElementMetadata<?, ?> metadata) {
    Object result = super.generateValue(element, metadata);
    if (result == null) {
      result = element.getAttributeValue(attKey);
    }
    return result;
  }

  @Override
  public void parseValue(Element element, ElementMetadata<?, ?> metadata,
      Object value) throws ParseException {
    if (!super.parse(element, metadata, value)) {
      element.setAttributeValue(attKey,
          ObjectConverter.getValue(value, attKey.getDatatype()));
    }
  }
}

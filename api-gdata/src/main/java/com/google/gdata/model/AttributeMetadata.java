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

/**
 * Metadata describing an attribute.  Attribute metadata includes the id, name,
 * and datatype of an attribute, as well whether that metadata is required,
 * declared, or visible.  New attribute instances can only be created as part
 * of an element, see {@link ElementCreator#addAttribute(AttributeKey)}.
 *
 * <p>See the {@link Metadata} interface for the properties shared between
 * attribute metadata and {@link ElementMetadata}.
 *
 * 
 */
public interface AttributeMetadata<D> extends Metadata<D> {

  /**
   * Returns the attribute key for this attribute metadata.
   */
  AttributeKey<D> getKey();

  /**
   * Binds this attribute metadata to the given context.
   */
  AttributeMetadata<D> bind(MetadataContext context);
}

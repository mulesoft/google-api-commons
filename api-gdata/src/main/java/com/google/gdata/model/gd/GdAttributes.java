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

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.QName;

/**
 * The GdAttributes class contains common mix-in attributes that are defined
 * in the GD namespace but used to decorate elements in other namespaces.
 *
 * 
 */
public class GdAttributes {
  
  /**
   * The gd:etag attribute is placed on resources to return the entity tag
   * associated with the resource that can be used for conditional retrieval
   * and conditional update (if strong).
   *
   * See RFC 2616, Section 3.11.
   */
  public static final AttributeKey<String> ETAG = AttributeKey.of(
      new QName(Namespaces.gNs, "etag"));
  
  /**
   * The gd:kind attribute is placed on resources to indicate the GData
   * kind of the resource.   The attribute value contains the URI that
   * identifies the kind and, by association, and expected extension model
   * for the resource.
   */
  public static final AttributeKey<String> KIND = AttributeKey.of(
      new QName(Namespaces.gNs, "kind"));
  
  /**
   * The gd:fields attributes is placed on resources to indicate that the
   * resource representation is a partial representation of the full resource.
   * The attribute value will contain the GData selection that describes the
   * fields that are present in the resource.
   */
  public static final AttributeKey<String> FIELDS = AttributeKey.of(
      new QName(Namespaces.gNs, "fields"));
}

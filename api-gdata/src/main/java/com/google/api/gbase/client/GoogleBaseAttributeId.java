/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.api.gbase.client;

/**
 * The definition (name and type) of a Google Base attribute.
 */
public class GoogleBaseAttributeId {
  private final String name;
  private final GoogleBaseAttributeType type;

  /**
   * Creates a public attribute id.
   *
   * @param name attribute name
   * @param type attribute type, can be null if it is not known
   */
  public GoogleBaseAttributeId(String name, GoogleBaseAttributeType type) {
    if (name == null) {
      throw new NullPointerException("attribute 'name' is required");
    }
    this.name = name;
    this.type = type;
  }

  /**
   * Gets the attribute name.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the attribute type, or null if it is not known.
   */
  public GoogleBaseAttributeType getType() {
    return type;
  }
  
  @Override
  public String toString() {
    if (type == null) {
      return name;
    } else {
      return name + "(" + type + ")";
    }
  }
  
  @Override
  public int hashCode() {
    int retval = 19 + name.hashCode();
    if (type != null) { 
      retval = retval * 37 + type.hashCode();
    }
    return retval;
  }
  
  @Override
  public boolean equals(Object o) {
    if (!(o instanceof GoogleBaseAttributeId)) {
      return false;
    }
    
    GoogleBaseAttributeId other = (GoogleBaseAttributeId)o;
    if (!name.equals(other.name)) {
      return false;
    }
    
    if (type == null) {
      return other.type == null;
    } else {
      return type.equals(other.type);
    }
  }
}

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

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.Collections;

/**
 * Group type holds multiple sub-attributes.
 * Sub-attributes can be any type except GROUP and its derived types 
 * (e.g. TAX and SHIPPING). 
 * 
 * 
 */
public class Group {
  
  private Multimap<String, GoogleBaseAttribute> subAttributes;
  
  public Group(Collection<GoogleBaseAttribute> subAttributes) {
    this.subAttributes = HashMultimap.<String, GoogleBaseAttribute>create();
    for (GoogleBaseAttribute attr : subAttributes) {
      this.subAttributes.put(attr.getName(), attr);
    }
  }
  
  /**
   * Gets one sub-attribute with the name name, if there are any.
   * @param name 
   * @return one of the sub-attributes with the specified name.
   */
  public GoogleBaseAttribute getSubAttribute(String name) {
    if (subAttributes.containsKey(name)) {
      Collection<GoogleBaseAttribute> attrs = subAttributes.get(name);
      if (!attrs.isEmpty()) {
        return subAttributes.get(name).iterator().next();
      }
    }
    return null;
  }
  
  /**
   * Gets all sub-attributes corresponding to the name.  
   * 
   * @param name name
   * @return A collection of GoogleBaseAttribute corresponds to the name
   */
  public Collection<? extends GoogleBaseAttribute> getSubAttributes(String name) {
    if (subAttributes.containsKey(name)) {
      return subAttributes.get(name);
    } else {
      return Collections.<GoogleBaseAttribute>emptySet();
    }
  }
  
  /**
   * Gets all sub-attributes of the group.
   */
  public Multimap<String, GoogleBaseAttribute> getAllSubAttributes() {
    return HashMultimap.<String, GoogleBaseAttribute>create(subAttributes);
  }
  
  public int subAttributesSize() {
    return subAttributes.size();
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("[");
    for (String key : subAttributes.keySet()) {
      Collection<GoogleBaseAttribute> attrs = subAttributes.get(key);
      for (GoogleBaseAttribute attr : attrs) {
        builder.append(key).append("(").append(attr.getType()).append("): ")
            .append(attr.getValueAsString()).append(", ");
      }
    }
    builder.delete(builder.length() - 2, builder.length() - 1); // delete the last comma.
    builder.append("]");
    return builder.toString();
  }
}

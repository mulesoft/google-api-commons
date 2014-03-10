/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.webmastertools;

import com.google.gdata.data.EnumConstruct;
import java.util.HashSet;

/**
 * GData schema extension describing a node with a domain preference.
 * The domain preference is a value in {@code preferwww, prefernowww, none}. 
 * This class is abstract, subclasses must define a default constructor 
 * which has the node name hardcoded. See {@link EnumConstruct}.
 *
 * 
 */
public abstract class DomainPreferenceConstruct extends EnumConstruct {
  
  /**
   * Constructs {@link EnumConstruct} to represent the preference setting.
   */
  public DomainPreferenceConstruct(String nodeName) {
    super(Namespaces.WT_NAMESPACE, nodeName, null, getValues());
    setPreference(DomainPreference.getDefault());
  }

  /**
   * Creates the set of accepted values {@code none, preferwww, prefernowww}.
   * 
   * @return A HashSet with the preferred values.
   */
  private static HashSet<String> getValues() {
    HashSet<String> values = new HashSet<String>();
    for (DomainPreference preference : DomainPreference.values()) {
      values.add(preference.toString());
    }
    return values;
  }
  
  /**
   * Compares {@link DomainPreferenceConstruct} objects based on the 
   * domain preference that they they hold.
   */
  @Override
  public boolean equals(Object rhs) {
    if (!super.equals(rhs)) {
      return false;
    }

    return getValue().equals(((DomainPreferenceConstruct) rhs).getValue());
  }

  /** 
   * Returns a hash code which is based on the preference string.
   */
  @Override
  public int hashCode() {
    return getValue().hashCode();
  }

  /**
   * Override {@link EnumConstruct#setValue(String)} to validate that
   * the supplied value is a one of the accepted domain preferences.
   * See {@link DomainPreference}.
   * 
   * @throws NullPointerException if the value is null.
   * @throws IllegalArgumentException if value is not a valid domain 
   * preference {@code none, preferwww, prefernowww}.
   */
  @Override
  public void setValue(String value) 
      throws NullPointerException, IllegalArgumentException{
    if (value == null) {
      throw new NullPointerException("value cannot be null");
    }
    
    if (!values.contains(value)) {
      throw new IllegalArgumentException(
          "The argument is not a valid preference");
    }
    
    super.setValue(value);
  }

  public void setPreference(DomainPreference value) {
    super.setValue(value.toString());
  }

  public DomainPreference getPreference() {
    return DomainPreference.fromString(getValue());
  } 
}

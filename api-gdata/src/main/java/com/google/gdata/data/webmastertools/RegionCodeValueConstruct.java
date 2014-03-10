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

import com.google.gdata.data.ValueConstruct;

/**
 * GData schema extension describing a node with a region code value. 
 * This class is abstract, derive from this class and define a default 
 * constructor which has the node name hardcoded, see
 * http://www.unicode.org/cldr/data/diff/supplemental/territory_containment_un_m_49.html
 * for a list of valid region codes.
 *
 * 
 */
public abstract class RegionCodeValueConstruct extends ValueConstruct {

  /**
   * Default value for the region code is US
   */
  public static final String DEFAULT_REGION_CODE = "ZZ";
  
  /**
   * Constructs {@link ValueConstruct} to represent the region code value.
   */
  public RegionCodeValueConstruct(String nodeName) {
    super(Namespaces.WT_NAMESPACE, nodeName, null);
    setValue(DEFAULT_REGION_CODE);
  }

  /**
   * Compares {@link RegionCodeValueConstruct} objects based on the region code
   * value that they hold.
   */
  @Override
  public boolean equals(Object rhs) {
    if (!super.equals(rhs)) {
      return false;
    }

    return getValue().equals(((RegionCodeValueConstruct) rhs).getValue());
  }

  /** 
   * Returns hash code which is based on the Region Code string representation.
   */
  @Override
  public int hashCode() {
    return getValue().hashCode();
  }

  /**
   * Override {@link ValueConstruct#setValue(String)} to validate that
   * the region code is not null.
   * 
   * @throws NullPointerException if the value is null.
   */
  @Override
  public void setValue(String value) 
      throws NullPointerException, IllegalArgumentException{
    if (value == null) {
      throw new NullPointerException("value cannot be null");
    }
    
    super.setValue(value);
  }
}

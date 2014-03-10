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
 * Adjustment information for one attribute ({@link GoogleBaseAttribute}). It
 * maps to {@code gm:adjusted_name} and {@code gm:adjusted_value} Xml elements.
 */
public class Adjustments {
  
  /** The adjusted name. */
  private String name;
  
  /** The adjusted value. */
  private String value;
  
  /** 
   * Gets the adjusted name, or {@code null} if the {@code adjusted_name} 
   * element is not specified. 
   */
  public String getName() {
    return name;
  }
  
  /** 
   * Gets the adjusted value in string format, or {@code null} if the 
   * {@code adjusted_value} element is not specified. 
   */
  public String getValue() {
    return value;
  }

  /**
   * Returns {@code true} if no adjusted attribute is specified, {@code false}
   * otherwise. 
   */
  public boolean isEmpty() {
    return name == null && value == null;
  }

  /**
   * Sets the ajdusted name.
   */
  void setName(String name) {
    this.name = name;
  }
  
  /**
   * Sets the adjusted value.
   */
  void setValue(String value) {
    this.value = value;
  }
}

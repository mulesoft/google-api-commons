/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data;

/**
 * Shared text construct interface.
 * 
 * 
 */
public interface ITextConstruct {

  /**
   * Defines the possible text construct types: TEXT, HTML, and XHTML.
   */
  public static class Type {
    public static final int TEXT = 1;
    public static final int HTML = 2;
    public static final int XHTML = 3;
  }
  
  /**
   * Returns this text construct's type (text, HTML, or XHTML).
   * 
   * @return an integer value of 1 to represent TEXT, 2 to represent HTML,
   * or 3 to represent XHTML.
   */
  public int getType();

  /** Returns a plain-text representation of this text construct. */
  public String getPlainText();
}

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
 * Shared interface for content.
 * 
 * 
 */
public interface IContent {
  
  /** 
   * Defines the possible content types. 
   */
  public static class Type {
    public static final int TEXT = 1;
    public static final int HTML = 2;
    public static final int XHTML = 3;
    public static final int OTHER_TEXT = 4;     // inlined text
    public static final int OTHER_XML = 5;      // inlined xml
    public static final int OTHER_BINARY = 6;   // inlined base64 binary
    public static final int MEDIA = 7;          // external media
  }

  /**
   * Returns this content's type.  See {@link Type} for a list of
   * return values.  
   * 
   * @return the type of content.
   */
  public int getType();
  
  /**
   * Returns the human language that this content is written in.
   * 
   * @return the language of the content if available, or null if not.
   */
  public String getLang();
}

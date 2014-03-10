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
 * Shared Category interface.
 * 
 * 
 */
public interface ICategory {

  /** 
   * Returns the category scheme or {@code null} if the category does not have
   * a scheme.
   * 
   * @return category scheme or {@code null}.
   */
  public String getScheme();

  /** 
   * Returns the category label or {@code null} if there is no label value.
   * 
   * @return category label (or @code null}.
   */
  public String getLabel();
  
  /** 
   * Returns the category term.
   * 
   * @return category term value.
   */
  public String getTerm();
}

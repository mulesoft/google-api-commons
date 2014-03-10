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
 * The Reference interface is implemented by data model types that contain a
 * reference to addressable content.
 */
public interface Reference {
  
  /**
   * Returns the value of the resource reference.
   */
  public String getHref();
  
  /**
   * Sets the value of the resource reference.
   * @param href the resource href.
   */
  public void setHref(String href);
}

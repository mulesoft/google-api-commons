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
 * Shared generator interface.
 * 
 * 
 */
public interface IGenerator {

  /**
   * Returns the version attribute of the generator.
   */
  public String getVersion();

  /**
   * Returns the version uri of the generator.
   */
  public String getHref();

  /**
   * Returns the name of the generator.
   */
  public String getName();
}

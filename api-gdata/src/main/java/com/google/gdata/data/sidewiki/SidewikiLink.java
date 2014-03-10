/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.sidewiki;

/**
 * Extends the base Link class with Sidewiki extensions.
 *
 * 
 */
public class SidewikiLink {

  /** Link relation type. */
  public static final class Rel {

    /** Http://www google com/sidewiki/original Sidewiki Link class. */
    public static final String ORIGINAL_URL =
        "http://www.google.com/sidewiki/original";

  }

  /** Private constructor to ensure class is not instantiated. */
  private SidewikiLink() {}

}


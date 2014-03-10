/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.maps;

/**
 * Extends the base Link class with Maps extensions.
 *
 * 
 */
public class MapsLink {

  /** Link relation type. */
  public static final class Rel {

    /** View Maps Link class. */
    public static final String VIEW = MapsNamespace.MAPS_PREFIX + "view";

  }

  /** Private constructor to ensure class is not instantiated. */
  private MapsLink() {}

}


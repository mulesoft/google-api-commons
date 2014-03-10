/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.health;

/**
 * Extends the base Link class with Health extensions.
 *
 * 
 */
public class HealthLink {

  /** Link relation type. */
  public static final class Rel {

    /** Complete url of an entry, indicating the smallest feed containing the
     * entry. */
    public static final String HTTP_SCHEMAS_GOOGLE_COM_HEALTH_DATA_COMPLETE =
        "http://schemas.google.com/health/data#complete";

  }

  /** Private constructor to ensure class is not instantiated. */
  private HealthLink() {}

}

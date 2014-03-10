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

import com.google.gdata.util.Namespaces;

/**
 * Describes a health category.
 *
 * 
 */
public class HealthCategory {

  /** Scheme (domain). */
  public static final class Scheme {

    /** Http://schemas google com/health/ccr health category. */
    public static final String CCR_SCHEME =
        "http://schemas.google.com/health/ccr";

    /** Http://schemas google com/health/item health category. */
    public static final String ITEM_SCHEME =
        "http://schemas.google.com/health/item";

    /** Kind health category. */
    public static final String KIND = Namespaces.gPrefix + "kind";

  }

  /** Private constructor to ensure class is not instantiated. */
  private HealthCategory() {}

}

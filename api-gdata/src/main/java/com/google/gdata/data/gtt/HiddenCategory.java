/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.gtt;

import com.google.gdata.util.Namespaces;

/**
 * Describes a hidden category.
 *
 * 
 */
public class HiddenCategory {

  /** Human-readable label. */
  public static final class Label {

    /** Hidden label. */
    public static final String HIDDEN = "hidden";

  }

  /** Scheme (domain). */
  public static final class Scheme {

    /** Label scheme. */
    public static final String LABELS = Namespaces.gPrefix + "labels";

  }

  /** Term. */
  public static final class Term {

    /** Hidden term. */
    public static final String HIDDEN = Namespaces.gPrefix + "hidden";

  }

  /** Private constructor to ensure class is not instantiated. */
  private HiddenCategory() {}

}


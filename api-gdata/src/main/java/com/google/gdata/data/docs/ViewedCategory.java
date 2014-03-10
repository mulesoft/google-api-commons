/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.docs;

import com.google.gdata.util.Namespaces;

/**
 * Describes a viewed category.
 *
 * 
 */
public class ViewedCategory {

  /** Human-readable label. */
  public static final class Label {

    /** Viewed label. */
    public static final String VIEWED = "viewed";

  }

  /** Scheme (domain). */
  public static final class Scheme {

    /** Labels scheme. */
    public static final String LABELS = Namespaces.gPrefix + "labels";

  }

  /** Term. */
  public static final class Term {

    /** Viewed term. */
    public static final String VIEWED = Namespaces.gPrefix + "viewed";

  }

  /** Private constructor to ensure class is not instantiated. */
  private ViewedCategory() {}

}


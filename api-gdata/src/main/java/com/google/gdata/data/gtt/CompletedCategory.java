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

/**
 * Describes a completed category.
 *
 * 
 */
public class CompletedCategory {

  /** Human-readable label. */
  public static final class Label {

    /** Completed label. */
    public static final String COMPLETED = "completed";

  }

  /** Scheme (domain). */
  public static final class Scheme {

    /** Translation state of the document. */
    public static final String TRANSLATIONSTATE = GttNamespace.GTT_PREFIX +
        "translationState";

  }

  /** Term. */
  public static final class Term {

    /** Completed term. */
    public static final String COMPLETED = GttNamespace.GTT_PREFIX +
        "completed";

  }

  /** Private constructor to ensure class is not instantiated. */
  private CompletedCategory() {}

}


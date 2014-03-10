/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.sites;

import com.google.gdata.util.Namespaces;

/**
 * Describes a template category.
 *
 * 
 */
public class TemplateCategory {

  /** Human-readable label. */
  public static final class Label {

    /** Template template category. */
    public static final String TEMPLATE = "template";

  }

  /** Scheme (domain). */
  public static final class Scheme {

    /** Labels template category. */
    public static final String LABELS = Namespaces.gPrefix + "labels";

  }

  /** Term. */
  public static final class Term {

    /** Template template category. */
    public static final String TEMPLATE = Namespaces.gPrefix + "template";

  }

  /** Private constructor to ensure class is not instantiated. */
  private TemplateCategory() {}

}


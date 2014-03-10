/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.analytics;

/**
 * Extends the base Link class with GWO extensions.
 *
 * 
 */
public class GwoLink {

  /** Link relation type. */
  public static final class Rel {

    /** Experiment configuration URL. */
    public static final String CONFIGURATION_URL = AnalyticsNamespace.GWO_PREFIX
        + "configurationUrl";

    /** Experiment goal URL. */
    public static final String GOAL_URL = AnalyticsNamespace.GWO_PREFIX +
        "goalUrl";

    /** A/b page variation URL. */
    public static final String PAGE_VARIATION_URL =
        AnalyticsNamespace.GWO_PREFIX + "abPageVariationUrl";

    /** Experiment combination preview URL. */
    public static final String PREVIEW_URL = AnalyticsNamespace.GWO_PREFIX +
        "previewUrl";

    /** Experiment report URL. */
    public static final String REPORT_URL = AnalyticsNamespace.GWO_PREFIX +
        "reportUrl";

    /** Experiment test URL. */
    public static final String TEST_URL = AnalyticsNamespace.GWO_PREFIX +
        "testUrl";

  }

  /** Private constructor to ensure class is not instantiated. */
  private GwoLink() {}

}


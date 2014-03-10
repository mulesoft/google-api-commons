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

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Namespace definitions related to Google Analytics Data Export API.
 *
 * 
 */
public class AnalyticsNamespace {

  private AnalyticsNamespace() {}

  /** Google Analytics (DXP) namespace */
  public static final String DXP = "http://schemas.google.com/analytics/2009";

  /** Google Analytics (DXP) namespace prefix */
  public static final String DXP_PREFIX = DXP + "#";

  /** Google Analytics (DXP) namespace alias */
  public static final String DXP_ALIAS = "dxp";

  /** XML writer namespace for Google Analytics (DXP) */
  public static final XmlNamespace DXP_NS = new XmlNamespace(DXP_ALIAS, DXP);

  /** Analytics-specific data (GA) namespace */
  public static final String GA = "http://schemas.google.com/ga/2009";

  /** Analytics-specific data (GA) namespace prefix */
  public static final String GA_PREFIX = GA + "#";

  /** Analytics-specific data (GA) namespace alias */
  public static final String GA_ALIAS = "ga";

  /** XML writer namespace for Analytics-specific data (GA) */
  public static final XmlNamespace GA_NS = new XmlNamespace(GA_ALIAS, GA);

  /** Gwo (GWO) namespace */
  public static final String GWO =
      "http://schemas.google.com/analytics/websiteoptimizer/2009";

  /** Gwo (GWO) namespace prefix */
  public static final String GWO_PREFIX = GWO + "#";

  /** Gwo (GWO) namespace alias */
  public static final String GWO_ALIAS = "gwo";

  /** XML writer namespace for Gwo (GWO) */
  public static final XmlNamespace GWO_NS = new XmlNamespace(GWO_ALIAS, GWO);

}


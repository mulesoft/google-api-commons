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

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Namespace definitions related to Google Sidewiki Data API.
 *
 * 
 */
public class SidewikiNamespace {

  private SidewikiNamespace() {}

  /** Google Sidewiki (SIDEWIKI) namespace */
  public static final String SIDEWIKI =
      "http://schemas.google.com/sidewiki/2009";

  /** Google Sidewiki (SIDEWIKI) namespace prefix */
  public static final String SIDEWIKI_PREFIX = SIDEWIKI + "#";

  /** Google Sidewiki (SIDEWIKI) namespace alias */
  public static final String SIDEWIKI_ALIAS = "sidewiki";

  /** XML writer namespace for Google Sidewiki (SIDEWIKI) */
  public static final XmlNamespace SIDEWIKI_NS = new
      XmlNamespace(SIDEWIKI_ALIAS, SIDEWIKI);

}


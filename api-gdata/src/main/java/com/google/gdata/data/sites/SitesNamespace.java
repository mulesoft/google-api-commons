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

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Namespace definitions related to Google Sites Data API.
 *
 * 
 */
public class SitesNamespace {

  private SitesNamespace() {}

  /** Google Sites (SITES) namespace */
  public static final String SITES = "http://schemas.google.com/sites/2008";

  /** Google Sites (SITES) namespace prefix */
  public static final String SITES_PREFIX = SITES + "#";

  /** Google Sites (SITES) namespace alias */
  public static final String SITES_ALIAS = "sites";

  /** XML writer namespace for Google Sites (SITES) */
  public static final XmlNamespace SITES_NS = new XmlNamespace(SITES_ALIAS,
      SITES);

}


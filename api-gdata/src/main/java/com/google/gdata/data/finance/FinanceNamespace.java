/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.finance;

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Namespace definitions related to Google Finance Portfolio Data API.
 *
 * 
 */
public class FinanceNamespace {

  private FinanceNamespace() {}

  /** Google Finance (GF) namespace */
  public static final String GF = "http://schemas.google.com/finance/2007";

  /** Google Finance (GF) namespace prefix */
  public static final String GF_PREFIX = GF + "#";

  /** Google Finance (GF) namespace alias */
  public static final String GF_ALIAS = "gf";

  /** XML writer namespace for Google Finance (GF) */
  public static final XmlNamespace GF_NS = new XmlNamespace(GF_ALIAS, GF);

}


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

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Namespace definitions related to Google Translator Toolkit API.
 *
 * 
 */
public class GttNamespace {

  private GttNamespace() {}

  /** Google Translator Toolkit (GTT) namespace */
  public static final String GTT = "http://schemas.google.com/gtt/2009/11";

  /** Google Translator Toolkit (GTT) namespace prefix */
  public static final String GTT_PREFIX = GTT + "#";

  /** Google Translator Toolkit (GTT) namespace alias */
  public static final String GTT_ALIAS = "gtt";

  /** XML writer namespace for Google Translator Toolkit (GTT) */
  public static final XmlNamespace GTT_NS = new XmlNamespace(GTT_ALIAS, GTT);

}


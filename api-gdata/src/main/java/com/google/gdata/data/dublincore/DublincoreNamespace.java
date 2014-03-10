/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.dublincore;

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * GData namespace definitions related to Dublin Core Metadata Initiative.
 *
 * 
 */
public class DublincoreNamespace {

  private DublincoreNamespace() {}

  /** Dublin Core Metadata Initiative, http://dublincore.org (DC) namespace */
  public static final String DC = "http://purl.org/dc/terms";

  /** Dublin Core Metadata Initiative, http://dublincore.org (DC) namespace
   * prefix */
  public static final String DC_PREFIX = DC + "#";

  /** Dublin Core Metadata Initiative, http://dublincore.org (DC) namespace
   * alias */
  public static final String DC_ALIAS = "dc";

  /** XML writer namespace for Dublin Core Metadata Initiative,
   * http://dublincore.org (DC) */
  public static final XmlNamespace DC_NS = new XmlNamespace(DC_ALIAS, DC);

}

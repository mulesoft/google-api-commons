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

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Namespace definitions related to Google Documents List Data API.
 *
 * 
 */
public class DocsNamespace {

  private DocsNamespace() {}

  /** Google Documents List (DOCS) namespace */
  public static final String DOCS = "http://schemas.google.com/docs/2007";

  /** Google Documents List (DOCS) namespace prefix */
  public static final String DOCS_PREFIX = DOCS + "#";

  /** Google Documents List (DOCS) namespace alias */
  public static final String DOCS_ALIAS = "docs";

  /** XML writer namespace for Google Documents List (DOCS) */
  public static final XmlNamespace DOCS_NS = new XmlNamespace(DOCS_ALIAS, DOCS);

}


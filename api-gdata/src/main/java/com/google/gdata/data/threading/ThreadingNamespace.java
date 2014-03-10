/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.threading;

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * GData namespace definitions related to Threading.
 *
 * 
 */
public class ThreadingNamespace {

  private ThreadingNamespace() {}

  /** Atom threading extensions (THR) namespace */
  public static final String THR = "http://purl.org/syndication/thread/1.0";

  /** Atom threading extensions (THR) namespace prefix */
  public static final String THR_PREFIX = THR + "#";

  /** Atom threading extensions (THR) namespace alias */
  public static final String THR_ALIAS = "thr";

  /** XML writer namespace for Atom threading extensions (THR) */
  public static final XmlNamespace THR_NS = new XmlNamespace(THR_ALIAS, THR);

}

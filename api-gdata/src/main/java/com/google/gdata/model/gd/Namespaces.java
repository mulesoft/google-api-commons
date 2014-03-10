/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model.gd;

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * GData namespace definitions related to Google.
 *
 * 
 */
public class Namespaces {

  private Namespaces() {}

  /** Google data (GD) namespace */
  public static final String g = "http://schemas.google.com/g/2005";

  /** Google data (GD) namespace prefix */
  public static final String gPrefix = g + "#";

  /** Google data (GD) namespace alias */
  public static final String gAlias = "gd";

  /** XML writer namespace for Google data (GD) */
  public static final XmlNamespace gNs = new XmlNamespace(gAlias, g);

}

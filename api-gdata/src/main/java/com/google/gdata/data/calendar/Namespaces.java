/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.calendar;

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * GData namespace definitions related to Google Calendar.
 *
 * 
 */
public class Namespaces {

  private Namespaces() {}

  /** Google Calendar (GCAL) namespace */
  public static final String gCal = "http://schemas.google.com/gCal/2005";

  /** Google Calendar (GCAL) namespace prefix */
  public static final String gCalPrefix = gCal + "#";

  /** Google Calendar (GCAL) namespace alias */
  public static final String gCalAlias = "gCal";

  /** XML writer namespace for Google Calendar (GCAL) */
  public static final XmlNamespace gCalNs = new XmlNamespace(gCalAlias, gCal);

}

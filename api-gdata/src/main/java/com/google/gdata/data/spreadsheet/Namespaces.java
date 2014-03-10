/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.spreadsheet;

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * GData namespace definitions related to Google Spreadsheets.
 *
 * 
 */
public class Namespaces {

  private Namespaces() {}

  /** Google Spreadsheets (GS) namespace */
  public static final String gSpread =
      "http://schemas.google.com/spreadsheets/2006";

  /** Google Spreadsheets (GS) namespace prefix */
  public static final String gSpreadPrefix = gSpread + "#";

  /** Google Spreadsheets (GS) namespace alias */
  public static final String gSpreadAlias = "gs";

  /** XML writer namespace for Google Spreadsheets (GS) */
  public static final XmlNamespace gSpreadNs = new XmlNamespace(gSpreadAlias,
      gSpread);

  /** Google Spreadsheets custom tag (GSX) namespace */
  public static final String gSpreadCustom =
      "http://schemas.google.com/spreadsheets/2006/extended";

  /** Google Spreadsheets custom tag (GSX) namespace prefix */
  public static final String gSpreadCustomPrefix = gSpreadCustom + "#";

  /** Google Spreadsheets custom tag (GSX) namespace alias */
  public static final String gSpreadCustomAlias = "gsx";

  /** XML writer namespace for Google Spreadsheets custom tag (GSX) */
  public static final XmlNamespace gSpreadCustomNs = new
      XmlNamespace(gSpreadCustomAlias, gSpreadCustom);

  /** Gviz data source for the worksheet (GVIZ) namespace */
  public static final String GVIZ =
      "http://schemas.google.com/visualization/2008";

  /** Gviz data source for the worksheet (GVIZ) namespace prefix */
  public static final String GVIZ_PREFIX = GVIZ + "#";


  /** Link "rel" for tables feed. */
  public static final String TABLES_LINK_REL =
      gSpreadPrefix + "tablesfeed";

  /** Link "rel" for worksheets feed. */
  public static final String WORKSHEETS_LINK_REL =
      gSpreadPrefix + "worksheetsfeed";

  /** Link "rel" for list feeds. */
  public static final String LIST_LINK_REL =
      gSpreadPrefix + "listfeed";

  /** Link "rel" for cells feeds. */
  public static final String CELLS_LINK_REL =
      gSpreadPrefix + "cellsfeed";

  /** Link "rel" for a url that is a source for a particular cell. */
  public static final String SOURCE_LINK_REL =
      gSpreadPrefix + "source";

 /** Link "rel" for GViz. */
  public static final String GVIZ_LINK_REL =
      GVIZ_PREFIX + "visualizationApi";
}

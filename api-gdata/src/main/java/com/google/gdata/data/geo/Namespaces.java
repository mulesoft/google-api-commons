/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.geo;

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Geo namespaces for the various schemas available to geo-information.
 *
 * 
 */
public class Namespaces {

  /**
   * Namespace for W3C's proposal for specifying geo-information. Please see the
   * W3C document <a
   * href="http://www.w3.org/2003/01/geo">http://www.w3.org/2003/01/geo</a>
   * for more information.
   */
  public static final String W3C_GEO
      = "http://www.w3.org/2003/01/geo/wgs84_pos#";
  public static final String W3C_GEO_ALIAS = "geo";

  public static final XmlNamespace W3C_GEO_NAMESPACE
      = new XmlNamespace(W3C_GEO_ALIAS, W3C_GEO);

  /**
   * Namespace for the Geo RSS proposal for encoding geo information.  Please
   * see <a href="http://www.georss.org/">http://www.georss.org/</a>
   * for more information.
   */
  public static final String GEO_RSS = "http://www.georss.org/georss";
  public static final String GEO_RSS_ALIAS = "georss";

  public static final XmlNamespace GEO_RSS_NAMESPACE
      = new XmlNamespace(GEO_RSS_ALIAS, GEO_RSS);

  /**
   * Namespace for the GML Geography markup language.  Please see the document
   * <a href="http://georss.org/gml.html">http://georss.org/gml.html</a> for
   * more information on the georss-supported version of GML.
   */
  public static final String GML = "http://www.opengis.net/gml";
  public static final String GML_ALIAS = "gml";

  public static final XmlNamespace GML_NAMESPACE
      = new XmlNamespace(GML_ALIAS, GML);

  private Namespaces() {}
}

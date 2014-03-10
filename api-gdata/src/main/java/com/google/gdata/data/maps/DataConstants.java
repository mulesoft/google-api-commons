/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.maps;

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Constants for the Maps Data API
 * 
 */
public interface DataConstants {
  public static final String KML_PREFIX = "kml";
  public static final String KML_URL = "http://www.opengis.net/kml/2.2";
  /**
   * Defines the KML namespace, which is the primary format for
   * FeatureEntry content.
   */
  public static final  XmlNamespace KML_NAMESPACE =
      new XmlNamespace(KML_PREFIX, KML_URL);
}

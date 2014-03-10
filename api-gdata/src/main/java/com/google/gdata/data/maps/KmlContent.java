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

/**
 * KML feature data.
 *
 * 
 */
public class KmlContent {

  /** Type of text construct (typically 'text', 'html' or 'xhtml'). */
  public static final class Type {

    /** Application/vnd google-earth kml+xml kml content. */
    public static final String APPLICATION_VND_GOOGLE_EARTH_KML_XML =
        "application/vnd.google-earth.kml+xml";

  }

  /** Private constructor to ensure class is not instantiated. */
  private KmlContent() {}

}


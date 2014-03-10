/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.photos;

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Namespace definitions related to Picasa Web Albums Data API.
 *
 * 
 */
public class Namespaces {

  private Namespaces() {}

  /** Exif namespace (EXIF) namespace */
  public static final String EXIF =
      "http://schemas.google.com/photos/exif/2007";

  /** Exif namespace (EXIF) namespace prefix */
  public static final String EXIF_PREFIX = EXIF + "#";

  /** Exif namespace (EXIF) namespace alias */
  public static final String EXIF_ALIAS = "exif";

  /** XML writer namespace for Exif namespace (EXIF) */
  public static final XmlNamespace EXIF_NAMESPACE = new XmlNamespace(EXIF_ALIAS,
      EXIF);

  /** Google Photos namespace (GPHOTO) namespace */
  public static final String PHOTOS = "http://schemas.google.com/photos/2007";

  /** Google Photos namespace (GPHOTO) namespace prefix */
  public static final String PHOTOS_PREFIX = PHOTOS + "#";

  /** Google Photos namespace (GPHOTO) namespace alias */
  public static final String PHOTOS_ALIAS = "gphoto";

  /** XML writer namespace for Google Photos namespace (GPHOTO) */
  public static final XmlNamespace PHOTOS_NAMESPACE = new
      XmlNamespace(PHOTOS_ALIAS, PHOTOS);

  /** Pheed namespace (PHEED) namespace */
  public static final String PHEED = "http://www.pheed.com/pheed/";

  /** Pheed namespace (PHEED) namespace prefix */
  public static final String PHEED_PREFIX = PHEED + "#";

  /** Pheed namespace (PHEED) namespace alias */
  public static final String PHEED_ALIAS = "pheed";

  /** XML writer namespace for Pheed namespace (PHEED) */
  public static final XmlNamespace PHEED_NS = new XmlNamespace(PHEED_ALIAS,
      PHEED);


  /** KML namespace (KML) namespace */
  public static final String KML = "http://earth.google.com/kml/2.1";

  /** KML namespace (KML) namespace prefix */
  public static final String KML_PREFIX = KML + "#";

  /** KML namespace (KML) namespace alias */
  public static final String KML_ALIAS = "kml";

  /** XML writer namespace for KML namespace (KML) */
  public static final XmlNamespace KML_NS = new XmlNamespace(KML_ALIAS, KML);


  public static final String SLIDESHOW_REL = PHOTOS_PREFIX + "slideshow";

  public static final String REPORT_REL = PHOTOS_PREFIX + "report";
}

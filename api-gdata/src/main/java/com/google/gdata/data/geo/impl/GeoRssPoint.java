/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.geo.impl;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.geo.Namespaces;
import com.google.gdata.data.geo.Point;

/**
 * Extension for a Geo RSS georss:point element. It contains the getter/setter
 * methods for specifying the longitude and latitude of a geo-coordinate. Please
 * see the Geo RSS Simple document at <a
 * href="http://www.georss.org/simple.html">simple georss</a> for more
 * information.
 *
 * 
 */
public final class GeoRssPoint extends PointConstruct {

  static final String NAME = "point";

  /**
   * Constructs an empty georss:point element.
   */
  public GeoRssPoint() {
    super(Namespaces.GEO_RSS_NAMESPACE, NAME);
  }

  /**
   * Constructs a georss:point element with the given latitude and longitude.
   */
  public GeoRssPoint(Double lat, Double lon) {
    super(Namespaces.GEO_RSS_NAMESPACE, NAME, lat, lon);
  }

  /**
   * Constructs a georss:point element by copying it from the given point.
   * If the given point is null an empty point will be created.
   */
  public GeoRssPoint(Point copyFrom) {
    super(Namespaces.GEO_RSS_NAMESPACE, NAME, copyFrom);
  }

  /**
   * Returns the suggested extension description with configurable
   * repeatability.
   */
  public static ExtensionDescription getDefaultDescription(boolean repeatable) {
    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(GeoRssPoint.class);
    desc.setNamespace(Namespaces.GEO_RSS_NAMESPACE);
    desc.setLocalName(NAME);
    desc.setRepeatable(repeatable);
    return desc;
  }

  /**
   * Returns the suggested extension description and is repeatable.
   */
  public static ExtensionDescription getDefaultDescription() {
    return getDefaultDescription(true);
  }
}

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
 * A GML Coordinate which is just a space-separated pair of lat/lon.
 * &lt;gml:pos&gt;45.256 -71.92&lt;/gml:pos&gt;
 *
 * 
 */
public class GmlPos extends PointConstruct {

  static final String NAME = "pos";

  /**
   * Constructs an empty gml:pos element.
   */
  public GmlPos() {
    super(Namespaces.GML_NAMESPACE, NAME);
  }

  /**
   * Constructs a gml:pos element with the given latitude and longitude.
   */
  public GmlPos(Double lat, Double lon) {
    super(Namespaces.GML_NAMESPACE, NAME, lat, lon);
  }

  /**
   * Constructs a gml:pos element by copying the lat/long values out of the
   * supplied point.  If the point is null then an empy gml:pos will be created.
   */
  public GmlPos(Point copyFrom) {
    super(Namespaces.GML_NAMESPACE, NAME, copyFrom);
  }

  /**
   * Returns the suggested extension description with configurable
   * repeatability.
   */
  public static ExtensionDescription getDefaultDescription(boolean repeatable) {
    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(GmlPos.class);
    desc.setNamespace(Namespaces.GML_NAMESPACE);
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

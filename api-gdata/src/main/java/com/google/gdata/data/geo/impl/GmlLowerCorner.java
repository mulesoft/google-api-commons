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
 * Point that represents the lower corner of a gml:Envelope.
 *
 * 
 */
public class GmlLowerCorner extends PointConstruct {

  static final String NAME = "lowerCorner";

  /**
   * Constructs an empty gml:lowerCorner element.
   */
  public GmlLowerCorner() {
    super(Namespaces.GML_NAMESPACE, NAME);
  }

  /**
   * Constructs a gml:lowerCorner element with the given lat and lon.
   */
  public GmlLowerCorner(Double lat, Double lon) {
    super(Namespaces.GML_NAMESPACE, NAME, lat, lon);
  }

  /**
   * Constructs a gml:lowerCorner element by copying the data from the
   * given point.  If the given point is null an empy corner will be created.
   */
  public GmlLowerCorner(Point copyFrom) {
    super(Namespaces.GML_NAMESPACE, NAME, copyFrom);
  }

  /**
   * Returns the suggested extension description with configurable
   * repeatability.
   */
  public static ExtensionDescription getDefaultDescription(
      boolean repeatable) {
    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(GmlLowerCorner.class);
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

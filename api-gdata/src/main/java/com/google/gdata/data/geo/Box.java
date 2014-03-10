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

import com.google.gdata.data.Extension;

/**
 * Interface for specifying a box that describes a rectangular geographic
 * location.  This is a bounding box described by two {@link Point} objects,
 * the lower left coordinate and the upper right coordinate.
 *
 * 
 */
public interface Box extends Extension {

  /**
   * @return the point that represents the lower-left coordinate of the box.
   */
  public Point getLowerLeft();

  /**
   * @return the point that represents the upper-right coordinate of the box.
   */
  public Point getUpperRight();

  /**
   * Sets the coordinates of this box.  Both lowerLeft and upperRight must be
   * non-null or both must be null.  Implementations will throw an
   * IllegalArgumentException if one is null and the other non-null.
   *
   * @param lowerLeft the lower left coordinate.  The latitude of this point
   *        must be below the latitude of the upper right coordinate.
   * @param upperRight the upper right coordinate.  The latitude of this point
   *        must be above the latitude of the lower left coordinate.
   * @throws IllegalArgumentException if only one of the points is non-null, or
   *         if an invalid pair of points is given.
   */
  public void setGeoLocation(Point lowerLeft, Point upperRight);
}

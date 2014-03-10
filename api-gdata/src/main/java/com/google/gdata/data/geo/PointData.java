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

/**
 * Data interface for all geo-tagged extension points.  This allows various
 * entries and feeds to easily include a Point extension without dealing with
 * the underlying implementation of the Point.
 *
 * 
 */
public interface PointData {

  /**
   * Sets the geo-location of the entity based on the lat and long coordinates
   * passed in.  This will create a new Point object if none exists, otherwise
   * it will copy the new coordinates into the existing object.
   *
   * @param lat The latitude coordinate, between -90 and 90 degrees.
   * @param lon The longitude coordinate, between -180 and 180 degrees.
   * @throws IllegalArgumentException if the latitude and longitude coordinates
   *        are invalid.
   */
  public void setGeoLocation(Double lat, Double lon)
      throws IllegalArgumentException;

  /**
   * Sets the geo-location of the entity based on the Point extension.  This
   * will use the passed in extension as the geo location if none already
   * exists, otherwise it will copy the given point's data into the existing
   * point object.
   *
   * @param point A point containing the latitude and longitude coordinates.
   */
  public void setGeoLocation(Point point);

  /**
   * Gets the geo-location of the entity.
   * 
   * @return a Point that contains the geo-coordinates (latitude and longitude).
   */
  public Point getGeoLocation();
  
  /**
   * Clears the point data and removes the extension point.
   */
  public void clearPoint();
}

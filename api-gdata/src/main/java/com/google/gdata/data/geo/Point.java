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
 * Interface for specifying a point that describes some geographic location.
 * Each point should have a latitude and longitude coordinate
 *
 * 
 */
public interface Point extends Extension {

  /**
   * @return the value of latitude coordinate of this Point.
   */
  public Double getLatitude();

  /**
   * @return the value of the longitude coordinate of this Point.
   */
  public Double getLongitude();

  /**
   * Sets the latitude and longitude coordinates of this Point. Either both lat
   * and lon must be non-null, or both must be null. Implementations will throw
   * an IllegalArgumentException if only one is null and one is not. They will
   * also throw an IllegalArgumentException if either of the lat values is
   * outside the valid range.
   *
   * @param lat The latitude in degrees, from -90 to 90.
   * @param lon The longitude in degrees, from -180 to 180.
   * @throws IllegalArgumentException if either lat or lon values are invalid,
   *         or if one of them is null and the other non-null.
   */
  public void setGeoLocation(Double lat, Double lon);
}

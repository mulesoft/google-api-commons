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
 * Data interface for all geo-tagged extension points that represent a bounding
 * box around a geographical area.  This allows various feeds and entries to
 * easily include a Box extension without dealing with the underlying Box
 * implementation.
 *
 * 
 */
public interface BoxData {

  /**
   * Sets the bounding box based on two {@link Point} objects.  If there is an
   * existing Box on this object, the new points will be copied into the
   * existing box rather than creating a new box.
   *
   * @param lowerLeft the lower left coordinate of the box.
   * @param upperRight the upper right coordinate of the box.
   */
  public void setGeoBoundingBox(Point lowerLeft, Point upperRight);

  /**
   * Sets the bounding box for this entity based on a {@link Box} extension.  If
   * there is an existing Box on this object, the new box will have its points
   * copied into the existing box rather than using the passed-in box.
   *
   * @param boundingBox the box that bounds this entity.
   */
  public void setGeoBoundingBox(Box boundingBox);

  /**
   * Gets the bounding box of this entity.
   *
   * @return a Box that contains the boundary for the content of this entity.
   */
  public Box getGeoBoundingBox();
  
  /**
   * Clears the bounding box and removes the extension point.
   */
  public void clearGeoBoundingBox();
}

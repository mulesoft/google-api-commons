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

/**
 * Data interface for all of the photos data items.  This is the base interface
 * for the methods that all photos items should support.
 *
 * This interface contains the setters and getters for the system id of an
 * element, which is the permanent id on the server.
 *
 * 
 */
public interface GphotoData extends Extensible {

  /**
   * Gets the gphoto:id of the data object.  The gphoto:id is the
   * photos-specific system id of the object, provided by the server at object
   * creation time.
   * 
   * @return the Gphoto id.
   */
  public String getGphotoId();

  /**
   * Sets the id of this feed or entry.  This field is normally read-only, but
   * can be used on the client to perform a copy operation when creating a new
   * object based on an existing object.
   * 
   * @param id the long version of the id of this feed or entry.
   */
  public void setGphotoId(Long id);

  /**
   * Sets the id of this feed or entry.  This field is normally read-only, but
   * can be used on the client to perform a copy operation when creating a new
   * object based on an existing object.
   *
   * @param id the string version of the id of this feed or entry.
   */
  public void setGphotoId(String id);
}

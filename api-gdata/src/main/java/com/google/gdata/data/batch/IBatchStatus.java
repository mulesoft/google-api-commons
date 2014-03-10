/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.batch;

import com.google.gdata.util.ContentType;

/**
 * Shared BatchStatus interface between old and new data models.
 * 
 * 
 */
public interface IBatchStatus {

  /**
   * Returns the status code associated with this batch status element.
   * 
   * @return the status code.
   */
  int getCode();
  
  /**
   * Returns the content of the batch status element.
   * 
   * @return the content of the element.
   */
  String getContent();
  
  /**
   * Returns the content type associated with this status element.
   * 
   * @return the content type of the element.
   */
  ContentType getContentType();
  
  /**
   * Returns the reason for the batch status.
   * 
   * @return the reason for the status.
   */
  String getReason();
}

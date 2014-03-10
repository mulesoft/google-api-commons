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
 * Shared BatchInterrupted interface between old and new data models.
 * 
 * 
 */
public interface IBatchInterrupted {

  /**
   * Returns the content of the interrupted element.
   * 
   * @return the content of the element.
   */
  String getContent();
  
  /**
   * Returns the content type of the interrupted element.
   * 
   * @return the content type.
   */
  ContentType getContentType();
  
  /**
   * Returns the number of entries which had errors.
   * 
   * @return the number of entries which failed.
   */
  int getErrorCount();
  
  /**
   * Returns the reason this batch was interrupted.
   * 
   * @return the reason for the interruption.
   */
  String getReason();
  
  /**
   * Returns the number of entries which were parsed but not processed.
   * 
   * @return the number of skipped entries.
   */
  int getSkippedCount();
  
  /**
   * Returns the number of entries which processed successfully.
   * 
   * @return number of successfully processed entries.
   */
  int getSuccessCount();
  
  /**
   * Returns the number of entries which were parsed.
   * 
   * @return total number of parsed entries.
   */
  int getTotalCount();
}

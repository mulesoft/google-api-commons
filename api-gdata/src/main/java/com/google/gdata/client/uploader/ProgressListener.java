/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.uploader;

/**
 * An interface for receiving progress notifications for uploads.
 *
 * 
 */
public interface ProgressListener {

  /**
   * Called to notify that progress has been changed. This method is called
   * periodically (a configurable number of milliseconds depending on its use),
   * and always immediately when the upload completes. Progress notifications
   * are not made while an upload has not been started, is paused, or after it
   * completes.
   *
   * @param uploaderWithProgress reference to the uploader instance whose
   *        progress has changed.
   */
  public void progressChanged(ResumableHttpFileUploader uploaderWithProgress);
}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.util;

/**
 * The ResumableUploadException should be thrown by a client when
 * a resumable upload io operation failed while uploading media.
 *
 * 
 */
public class ResumableUploadException extends ServiceException {

  public ResumableUploadException(String message) {
    super(message);
  }

}

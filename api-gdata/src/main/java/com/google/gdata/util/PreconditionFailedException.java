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

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * The PreconditionFailedException should be thrown by a service provider
 * when an attempt is made to access content using a date-conditional
 * GET and the resource has not been modified since the provided date.
 *
 * 
 */
public class PreconditionFailedException extends ServiceException {

  public PreconditionFailedException() {
    super("Precondition Failed");
    initResponseCode();
  }

  public PreconditionFailedException(String message) {
    super(message);
    initResponseCode();
  }

  public PreconditionFailedException(String message, Throwable cause) {
    super(message, cause);
    initResponseCode();
  }

  public PreconditionFailedException(HttpURLConnection httpConn)
      throws IOException{
    super(httpConn);
    initResponseCode();
  }

  public PreconditionFailedException(ErrorDomain.ErrorCode errorCode) {
    super(errorCode);
    initResponseCode();
  }

  public PreconditionFailedException(ErrorDomain.ErrorCode errorCode,
      Throwable cause) {
    super(errorCode, cause);
    initResponseCode();
  }

  private void initResponseCode() {
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_PRECON_FAILED);
  }
}

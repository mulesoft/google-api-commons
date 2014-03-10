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
 * The NotImplementedException should be thrown by a service provider
 * when an attempt is made to send a request that is not supported by the
 * target service.
 *
 * 
 */
public class NotImplementedException extends ServiceException {

  public NotImplementedException(String message) {
    super(message);
    initResponseCode();
  }

  public NotImplementedException(String message, Throwable cause) {
    super(message, cause);
    initResponseCode();
  }

  public NotImplementedException(Throwable cause) {
    super(cause);
    initResponseCode();
  }

  public NotImplementedException(HttpURLConnection httpConn)
      throws IOException{
    super(httpConn);
    initResponseCode();
  }

  public NotImplementedException(ErrorDomain.ErrorCode errorCode) {
    super(errorCode);
    initResponseCode();
  }

  public NotImplementedException(ErrorDomain.ErrorCode errorCode,
      Throwable cause) {
    super(errorCode);
    initResponseCode();
  }

  private void initResponseCode() {
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_NOT_IMPLEMENTED);
  }
}

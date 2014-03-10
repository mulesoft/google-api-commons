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
 * The ServiceForbiddenException should be thrown by a service provider
 * when an attempt is made to perform an operation upon a resource (feed
 * or entry) that is not supported.
 *
 * 
 */
public class ServiceForbiddenException extends ServiceException {

  public ServiceForbiddenException(String message) {
    super(message);
    initResponseCode();
  }

  public ServiceForbiddenException(String message, Throwable cause) {
    super(message, cause);
    initResponseCode();
  }

  public ServiceForbiddenException(Throwable cause) {
    super(cause);
    initResponseCode();
  }

  public ServiceForbiddenException(HttpURLConnection httpConn)
      throws IOException{
    super(httpConn);
    initResponseCode();
  }

  public ServiceForbiddenException(ErrorDomain.ErrorCode errorCode) {
    super(errorCode);
    initResponseCode();
  }

  public ServiceForbiddenException(ErrorDomain.ErrorCode errorCode,
      Throwable cause) {
    super(errorCode, cause);
    initResponseCode();
  }

  private void initResponseCode() {
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_FORBIDDEN);
  }
}

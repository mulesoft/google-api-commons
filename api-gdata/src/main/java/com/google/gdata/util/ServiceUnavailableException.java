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
 * Thrown when an exception occurs that is temporary; i.e., the user should
 * try again.  This includes failing backends, rate limiting, and so on.
 * Set the retryTime in seconds to tell the client when to retry.
 * <p>
 *
 * 
 */
public class ServiceUnavailableException extends ServiceException {

  private int retryTime = -1;

  public ServiceUnavailableException(String message) {
    super(message);
    initResponseCode();
  }

  public ServiceUnavailableException(String message, Throwable cause) {
    super(message, cause);
    initResponseCode();
  }

  public ServiceUnavailableException(Throwable cause) {
    super(cause.getMessage(), cause);
    initResponseCode();
  }

  public ServiceUnavailableException(HttpURLConnection httpConn)
      throws IOException {
    super(httpConn);
    initResponseCode();
  }

  public ServiceUnavailableException(ErrorDomain.ErrorCode errorCode) {
    super(errorCode);
    initResponseCode();
  }

  public ServiceUnavailableException(ErrorDomain.ErrorCode errorCode,
      Throwable cause) {
    super(errorCode, cause);
    initResponseCode();
  }

  private void initResponseCode() {
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_UNAVAILABLE);
  }

  public int getRetryTime() {
    return retryTime;
  }

  public void setRetryTime(int retryTime) {
    this.retryTime = retryTime;
  }

}

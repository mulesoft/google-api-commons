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
 * The UnsupportedMediaTypeException will be thrown by a GData service
 * when a GData request body contains a media type that is not supported
 * by the service.
 *
 * 
 */
public class UnsupportedMediaTypeException extends ServiceException {

  public UnsupportedMediaTypeException(String message) {
    super(message);
    initResponseCode();
  }

  public UnsupportedMediaTypeException(String message, Throwable cause) {
    super(message, cause);
    initResponseCode();
  }

  public UnsupportedMediaTypeException(Throwable cause) {
    super(cause);
    initResponseCode();
  }

  public UnsupportedMediaTypeException(HttpURLConnection httpConn)
      throws IOException{
    super(httpConn);
    initResponseCode();
  }

  public UnsupportedMediaTypeException(ErrorDomain.ErrorCode errorCode) {
    super(errorCode);
    initResponseCode();
  }

  public UnsupportedMediaTypeException(ErrorDomain.ErrorCode errorCode,
      Throwable cause) {
    super(errorCode, cause);
    initResponseCode();
  }

  private void initResponseCode() {
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_UNSUPPORTED_TYPE);
  }
}

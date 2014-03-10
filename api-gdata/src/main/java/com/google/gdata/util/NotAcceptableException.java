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

import java.net.HttpURLConnection;
import java.io.IOException;

/**
 * Thrown by a service provider when the resource identified by the request is
 * only capable of generating response entities which have content
 * characteristics not acceptable according to the accept headers sent in the
 * request.
 *
 * 
 */
public class NotAcceptableException extends ServiceException {

  public NotAcceptableException() {
    super("Not Acceptable");
    initResponseCode();
  }

  public NotAcceptableException(String message) {
    super(message);
    initResponseCode();
  }

  public NotAcceptableException(HttpURLConnection httpConn)
      throws IOException {
    super(httpConn);
    initResponseCode();
  }

  public NotAcceptableException(ErrorDomain.ErrorCode errorCode) {
    super(errorCode);
    initResponseCode();
  }

  public NotAcceptableException(ErrorDomain.ErrorCode errorCode,
      Throwable cause) {
    super(errorCode, cause);
    initResponseCode();
  }

  private void initResponseCode() {
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_NOT_ACCEPTABLE);
  }
}

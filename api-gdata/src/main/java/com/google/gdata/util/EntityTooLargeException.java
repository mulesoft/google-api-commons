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
 * The EntityTooLargeException should be thrown by a service provider
 * when its refusing to process a request because request entity is larger
 * than service provider is willing to process.
 *
 * 
 */
public class EntityTooLargeException extends ServiceException {

  public EntityTooLargeException(String message) {
    super(message);
    initResponseCode();
  }

  public EntityTooLargeException(String message, Throwable cause) {
    super(message, cause);
    initResponseCode();
  }

  public EntityTooLargeException(Throwable cause) {
    super(cause);
    initResponseCode();
  }

  public EntityTooLargeException(HttpURLConnection httpConn)
      throws IOException {
    super(httpConn);
    initResponseCode();
  }

  public EntityTooLargeException(ErrorContent errorCode) {
    super(errorCode);
    initResponseCode();
  }

  public EntityTooLargeException(ErrorContent errorCode, Throwable cause) {
    super(errorCode, cause);
    initResponseCode();
  }


  private void initResponseCode() {
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_ENTITY_TOO_LARGE);
  }
}

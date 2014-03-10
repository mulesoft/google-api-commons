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
 * Thrown when the format of a ServiceRequest is invalid.  Possible causes
 * are XML that is not well formed, or the presence of extension elements
 * that are not expected for the target feed.
 * <p>
 *
 * 
 */
public class InvalidEntryException extends ServiceException {

  public InvalidEntryException(String message) {
    super(message);
    initResponseCode();
  }

  public InvalidEntryException(String message, Throwable cause) {
    super(message, cause);
    initResponseCode();
  }

  public InvalidEntryException(Throwable cause) {
    super(cause.getMessage(), cause);
    initResponseCode();
  }

  public InvalidEntryException(HttpURLConnection httpConn) throws IOException {
    super(httpConn);
    initResponseCode();
  }

  public InvalidEntryException(ErrorContent errorCode) {
    super(errorCode);
    initResponseCode();
  }

  public InvalidEntryException(ErrorContent errorCode, Throwable cause) {
    super(errorCode, cause);
    initResponseCode();
  }

  private void initResponseCode() {
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_BAD_REQUEST);
  }
}

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

/**
 * The ParseException indicates a failure parsing GData request content.
 *
 * 
 */
public class ParseException extends ServiceException {

  public ParseException(String message) {
    super(message);
    initResponseCode();
  }

  public ParseException(String message,
                        Throwable cause) {
    super(message, cause);
    initResponseCode();
  }

  public ParseException(Throwable cause) {
    super(cause);
    initResponseCode();
  }

  public ParseException(ErrorContent errorCode) {
    super(errorCode);
    initResponseCode();
  }

  public ParseException(ErrorContent errorCode, Throwable cause) {
    super(errorCode, cause);
    initResponseCode();
  }

  private void initResponseCode() {
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_BAD_REQUEST);
  }
}

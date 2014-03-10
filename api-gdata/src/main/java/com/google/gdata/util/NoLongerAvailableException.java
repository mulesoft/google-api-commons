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
 * Thrown by a service provider when the resource identified by the request is
 * no longer available at the server and no forwarding address is known.
 * This condition is expected to be considered permanent.
 * Clients with link editing capabilities SHOULD delete references to the
 * Request-URI after user approval.
 * <p>
 *
 * 
 */
public class NoLongerAvailableException extends ServiceException {

  public NoLongerAvailableException() {
    super("No longer available");
    initResponseCode();
  }

  public NoLongerAvailableException(String message) {
    super(message);
    initResponseCode();
  }

  public NoLongerAvailableException(String message, Throwable cause) {
    super(message, cause);
    initResponseCode();
  }

  public NoLongerAvailableException(HttpURLConnection httpConn)
      throws IOException {
    super(httpConn);
    initResponseCode();
  }

  public NoLongerAvailableException(ErrorDomain.ErrorCode errorCode) {
    super(errorCode);
    initResponseCode();
  }

  public NoLongerAvailableException(ErrorDomain.ErrorCode errorCode,
      Throwable cause) {
    super(errorCode, cause);
    initResponseCode();
  }


  private void initResponseCode() {
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_GONE);
  }
}

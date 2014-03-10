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

import com.google.gdata.client.CoreErrorDomain;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Exception that indicates a user is requesting too frequently.
 * For storage-limit errors, see {@link QuotaExceededException}.
 *
 * 
 */
public class RateLimitExceededException extends ServiceException {

  public RateLimitExceededException() {
    this(CoreErrorDomain.ERR.rateLimitExceeded);
  }

  public RateLimitExceededException(String message) {
    this(CoreErrorDomain.ERR.rateLimitExceeded.withExtendedHelp(message));
  }

  public RateLimitExceededException(String message, Throwable cause) {
    this(CoreErrorDomain.ERR.rateLimitExceeded.withExtendedHelp(message),
        cause);
  }

  public RateLimitExceededException(HttpURLConnection httpConn) 
      throws IOException {
    super(httpConn);
    initResponseCode();
  }

  public RateLimitExceededException(Throwable cause) {
    this(CoreErrorDomain.ERR.rateLimitExceeded, cause);
  }

  public RateLimitExceededException(ErrorContent errorCode) {
    super(errorCode);
    initResponseCode();
  }

  public RateLimitExceededException(ErrorContent errorCode, Throwable cause) {
    super(errorCode, cause);
    initResponseCode();
  }

  private void initResponseCode() {
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_FORBIDDEN);
  }
}

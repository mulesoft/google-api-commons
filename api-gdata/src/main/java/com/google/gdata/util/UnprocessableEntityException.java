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

import com.google.gdata.client.GDataProtocol;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * The UnprocessableEntityException is thrown by a service provider when it
 * receives a request that it understands but where processing the request will
 * leave resources in an inconsistent state.   For example, a PATCH request
 * that removes required fields could not be processed without making the target
 * resource invalid.
 *
 * 
 */
public class UnprocessableEntityException extends ServiceException {

  /**
   * @param message
   */
  public UnprocessableEntityException(String message) {
    super(message);
    initResponseCode();
  }

  /**
   * @param message
   * @param cause
   */
  public UnprocessableEntityException(String message, Throwable cause) {
    super(message, cause);
    initResponseCode();
  }

  /**
   * @param cause
   */
  public UnprocessableEntityException(Throwable cause) {
    super(cause);
    initResponseCode();
  }

  /**
   * @param httpConn
   * @throws IOException
   */
  public UnprocessableEntityException(HttpURLConnection httpConn)
      throws IOException {
    super(httpConn);
    initResponseCode();
  }

  /**
   * @param errorCode
   */
  public UnprocessableEntityException(ErrorContent errorCode) {
    super(errorCode);
    initResponseCode();
  }

  /**
   * @param errorCode
   * @param cause
   */
  public UnprocessableEntityException(ErrorContent errorCode, Throwable cause) {
    super(errorCode, cause);
    initResponseCode();
  }

  private void initResponseCode() {
    setHttpErrorCodeOverride(GDataProtocol.Error.UNPROCESSABLE_ENTITY);
  }
}

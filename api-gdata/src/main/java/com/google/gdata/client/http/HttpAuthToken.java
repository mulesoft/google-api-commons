/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.http;

import com.google.gdata.client.AuthTokenFactory.AuthToken;

import java.net.URL;

/**
 * The HttpAuthToken interface represents a token used to authenticate
 * an HTTP request.  It encapsulates the functionality to create
 * the "Authorization" header to be appended to a HTTP request.
 */
public interface HttpAuthToken extends AuthToken {

  /**
   * Returns an authorization header to be used for a HTTP request
   * for the respective authentication token.
   *
   * @param requestUrl the URL being requested
   * @param requestMethod the HTTP method of the request
   * @return the "Authorization" header to be used for the request
   */
  public String getAuthorizationHeader(URL requestUrl,
                                       String requestMethod);
}

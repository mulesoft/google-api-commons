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

import com.google.gdata.client.authn.oauthproxy.OAuthProxyResponse;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Represents an error thrown by the OAuth Proxy in an App Engine environment.
 * Provides getters/setters for OAuth Proxy-specific parameters.
 *
 * 
 */
public class OAuthProxyException extends ServiceException {

  private final OAuthProxyResponse response;

  /**
   * Creates a new {@link OAuthProxyException}, and populates the OAuth Proxy
   * specific parameters from the {@link HttpURLConnection}.
   *
   * @param httpConn The http response.
   * @throws IOException
   */
  public OAuthProxyException(HttpURLConnection httpConn) throws IOException {
    super(httpConn);
    response = super.getOAuthProxyResponse();
  }

  /** Gets the value of the "x_oauth_state" header from the http response. */
  public String getState() {
    return response.getState();
  }

  /**
   * Gets the value of the "x_oauth_approval_url" header from the http
   * response.
   */
  public String getApprovalUrl() {
    return response.getApprovalUrl();
  }

  /** Gets the value of the "x_oauth_error" header from the http response. */
  public String getError() {
    return response.getError();
  }

  /**
   * Gets the value of the "x_oauth_error_text" header from the http
   * response.
   */
  public String getErrorText() {
    return response.getErrorText();
  }
}

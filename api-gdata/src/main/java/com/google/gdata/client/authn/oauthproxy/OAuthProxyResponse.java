/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.authn.oauthproxy;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Stores the variables related to an OAuth Proxy response.
 *
 * 
 */
public class OAuthProxyResponse extends HashMap<String, String> {

  public OAuthProxyResponse() {
    super();
  }

  /**
   * Creates an {@link OAuthProxyResponse} object from a map of http headers,
   * such as one obtained from {@link HttpURLConnection#getHeaderFields()}.
   *
   * @param headers A map of http headers.
   */
  public OAuthProxyResponse(Map<String, List<String>> headers) {
    List<String> responseHeaders = Lists.newArrayList(
        OAuthProxyProtocol.Header.X_OAUTH_APPROVAL_URL,
        OAuthProxyProtocol.Header.X_OAUTH_ERROR,
        OAuthProxyProtocol.Header.X_OAUTH_ERROR_TEXT,
        OAuthProxyProtocol.Header.X_OAUTH_STATE);
    for (Entry<String, List<String>> entry : headers.entrySet()) {
      if (responseHeaders.contains(entry.getKey())) {
        put(entry.getKey(), entry.getValue().get(0));
      }
    }
  }

  /**
   * Retrieves the approval url.  If this url is present in a request, the
   * consumer should redirect the user to this url to reauthorize.
   */
  public String getApprovalUrl() {
    return get(OAuthProxyProtocol.Header.X_OAUTH_APPROVAL_URL);
  }

  /** Sets the approval url. */
  public void setApprovalUrl(String value) {
    put(OAuthProxyProtocol.Header.X_OAUTH_APPROVAL_URL, value);
  }

  /** Retrieves the OAuth error. */
  public String getError() {
    return get(OAuthProxyProtocol.Header.X_OAUTH_ERROR);
  }

  /** Sets the OAuth error. */
  public void setError(String value) {
    put(OAuthProxyProtocol.Header.X_OAUTH_ERROR, value);
  }

  /** Retrieves the OAuth error text. */
  public String getErrorText() {
    return get(OAuthProxyProtocol.Header.X_OAUTH_ERROR_TEXT);
  }

  /** Sets the OAuth error text. */
  public void setErrorText(String value) {
    put(OAuthProxyProtocol.Header.X_OAUTH_ERROR_TEXT, value);
  }

  /** Retrieves the OAuth state. */
  public String getState() {
    return get(OAuthProxyProtocol.Header.X_OAUTH_STATE);
  }

  /** Sets the OAuth state. */
  public void setState(String value) {
    put(OAuthProxyProtocol.Header.X_OAUTH_STATE, value);
  }
}

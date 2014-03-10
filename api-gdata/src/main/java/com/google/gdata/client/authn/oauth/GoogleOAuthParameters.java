/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.authn.oauth;

/**
 * Defines the parameters necessary for making OAuth requests against Google.
 * Currently the only parameter is "scope", which indicates the resources the
 * user can access.
 *
 * 
 */
public class GoogleOAuthParameters extends OAuthParameters {

  public static final String SCOPE_KEY = "scope";

  /**
   * Return the request scope.  The scope is a URI defined by each Google
   * service that indicates which resources the user has permissions to access.
   * It is used when retrieving the unauthorized request token.  Multiple scopes
   * are separated with a space.  This parameter is required for OAuth requests
   * against Google.
   */
  public String getScope() {
    return get(SCOPE_KEY, baseParameters);
  }

  /**
   * Sets the request scope.  See {@link #getScope()} to learn more about this
   * parameter.
   */
  public void setScope(String scope) {
    put(SCOPE_KEY, scope, baseParameters);
  }

  /**
   * Checks to see if the scope exists.  See {@link #getScope()} to learn more
   * about this parameter.
   *
   * @return true if the scope exists, false otherwise
   */
  public boolean checkScopeExists() {
    return checkExists(SCOPE_KEY, baseParameters);
  }

  /**
   * Checks to see if the scope exists.  Throws an exception if it does not.
   * See {@link #getScope()} to learn more about this parameter.
   *
   * @throws OAuthException if the scope does not exist
   */
  public void assertScopeExists() throws OAuthException {
    assertExists(SCOPE_KEY, baseParameters);
  }

  /**
   * Since the scope parameter may be different for each OAuth request, it is
   * cleared between requests, and must be manually set before each request.
   */
  @Override
  public void reset() {
    super.reset();
    remove(SCOPE_KEY, baseParameters);
  }
}

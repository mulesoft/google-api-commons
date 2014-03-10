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
 * Extends the {@link OAuthHelper} class with details specific to making
 * OAuth requests with Google.
 *
 * 
 */
public class GoogleOAuthHelper extends OAuthHelper {

  /**
   * Google's OAuth endpoints
   */
  private static String requestTokenUrl =
      "https://www.google.com/accounts/OAuthGetRequestToken";
  private static String userAuthorizationUrl =
      "https://www.google.com/accounts/OAuthAuthorizeToken";
  private static String accessTokenUrl =
    "https://www.google.com/accounts/OAuthGetAccessToken";
  private static String revokeTokenUrl =
    "https://www.google.com/accounts/AuthSubRevokeToken";

  /**
   * Creates a new GoogleOAuthHelper, which is an {@link OAuthHelper} with
   * specific urls.
   *
   * @param signer the {@link OAuthSigner} to use when signing the request
   */
  public GoogleOAuthHelper(OAuthSigner signer) {
    super(requestTokenUrl, userAuthorizationUrl, accessTokenUrl, revokeTokenUrl,
        signer);
  }

  /**
   * Creates a new GoogleOAuthHelper, which is an {@link OAuthHelper} with
   * specific urls.
   *
   * @param signer the {@link OAuthSigner} to use when signing the request
   * @param httpClient the {@link OAuthHttpClient} to use when making http
   *        requests
   */
  GoogleOAuthHelper(OAuthSigner signer, OAuthHttpClient httpClient) {
    super(requestTokenUrl, userAuthorizationUrl, accessTokenUrl, revokeTokenUrl,
        signer, httpClient);
  }
}

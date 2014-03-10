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
 * Interface for signing OAuth requests.
 *
 * 
 */
public interface OAuthSigner {

  /**
   * Signs the input string using the appropriate signature method.
   *
   * @param baseString the string to sign
   * @param oauthParameters the parameters related to the OAuth request or
   *        <code>null</code>
   * @return the signed string
   * @throws OAuthException if signing the request fails
   */
  String getSignature(String baseString, OAuthParameters oauthParameters)
      throws OAuthException;

  /**
   * Gets the signature method for this specific implementation.
   *
   * @return the signature method used to sign the base string
   */
  String getSignatureMethod();
}

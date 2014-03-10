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
 * Generic exception to capture all OAuth related issues.
 *
 * 
 */
public class OAuthException extends Exception {

  public OAuthException() {
    super();
  }

  public OAuthException(String message) {
    super(message);
  }

  public OAuthException(Throwable cause) {
    super(cause);
  }

  public OAuthException(String message, Throwable cause) {
    super(message, cause);
  }
}

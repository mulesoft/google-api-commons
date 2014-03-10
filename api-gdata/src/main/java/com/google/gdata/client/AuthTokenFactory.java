/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client;

import com.google.gdata.client.GoogleService.SessionExpiredException;
import com.google.gdata.util.AuthenticationException;

/**
 * An interface to a factory that creates authentication tokens.
 * 
 * 
 */
public interface AuthTokenFactory {

  /**
   * A marker interface for authentication tokens. Auth tokens are
   * protocol-specific (e.g. HTTP auth tokens) so there are no common
   * methods.
   */
  public static interface AuthToken {
  }
  
  /**
   * A listener interface that's used to inform interested
   * parties that an authentication token has changed. Listeners
   * can for example clear out user data (e.g. cookies).
   */
  public interface TokenListener {
    public void tokenChanged(AuthToken newToken);
  }

  /**
   * Get an authentication token.
   * 
   * @return Authentication token.
   */
  public AuthToken getAuthToken();

  /**
   * Handles a session expired exception.
   */
  public void handleSessionExpiredException(
      SessionExpiredException sessionExpired)
      throws SessionExpiredException, AuthenticationException;
}

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

import com.google.gdata.client.http.GoogleGDataRequest.GoogleCookie;

import java.util.Set;

/**
 * An interface to a cookie manager. Cookie handling can be disabled
 * or enabled.
 *
 * 
 */
public interface CookieManager {

  /**
   * Enables or disables cookie handling.
   */
  public void setCookiesEnabled(boolean cookiesEnabled);

  /**
   * Returns  {@code true} if the GoogleService is handling cookies.
   */
  public boolean cookiesEnabled();

  /**
   * Clears all cookies.
   */
  public void clearCookies();

  /**
   * Adds a new GoogleCookie instance to the cache.
   */
  public void addCookie(GoogleCookie cookie);

  /**
   * Returns the set of associated cookies returned by previous requests.
   */
  public Set<GoogleCookie> getCookies();

}

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

import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.Multiset;
import com.google.gdata.client.http.GoogleGDataRequest.GoogleCookie;

import java.util.Iterator;
import java.util.Set;

/**
 * A simple cookie manager implementation.
 *
 * 
 */
public class SimpleCookieManager implements CookieManager {

  /**
   * Storage for a set of cookies.
   */
  protected Multiset<GoogleCookie> cookies = ConcurrentHashMultiset.create();

  /**
   * Indicates whether cookie handling is enabled.
   */
  protected boolean cookiesEnabled = true;

  public void setCookiesEnabled(boolean cookiesEnabled) {
    this.cookiesEnabled = cookiesEnabled;
    if (!this.cookiesEnabled) {
      clearCookies();
    }
  }

  public boolean cookiesEnabled() {
    return cookiesEnabled;
  }

  public void clearCookies() {
    cookies.clear();
  }

  public void addCookie(GoogleCookie cookie) {
    assert cookiesEnabled;

    // Remove any previous value of this cookie, since expiration and
    // and cookie value are not part of the hashCode/equals algorithm
    // for GoogleCookie.  This ensures that we always replace with the
    // most recently received cookie state.
    cookies.remove(cookie);
    cookies.add(cookie);
  }

  public Set<GoogleCookie> getCookies() {

    // Lazy flushing of expired cookies
    Iterator<GoogleCookie> cookieIter = cookies.iterator();
    while (cookieIter.hasNext()) {
      GoogleCookie cookie = cookieIter.next();
      if (cookie.hasExpired()) {
        cookieIter.remove();
      }
    }
    return cookies.elementSet();
  }
}

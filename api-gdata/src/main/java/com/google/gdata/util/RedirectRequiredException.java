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

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;

/**
 * Exception thrown when a redirect is required to satisfy a request.
 *
 * 
 */
public class RedirectRequiredException extends ServiceException {

  /**
   * Name of HTTP header containing redirect target location.
   */
  private static final String LOCATION = "Location";

  /**
   * Initialize the redirect required exception.
   *
   * @param sc the status code of the redirect - one of
   * {@link java.net.HttpURLConnection#HTTP_MOVED_PERM} or
   * {@link java.net.HttpURLConnection#HTTP_MOVED_TEMP}.
   * @param location the redirect location
   */
  public RedirectRequiredException(int sc, String location) {
    super("Redirect Required");
    setHttpErrorCodeOverride(sc);
    getHttpHeaders().put(LOCATION, Collections.singletonList(location));
  }

  public RedirectRequiredException(HttpURLConnection httpConn)
      throws IOException{
    super(httpConn);
    setHttpErrorCodeOverride(httpConn.getResponseCode());
    // Location header is saved in super constructor.
  }

  public String getRedirectLocation() {
    List<String> location = getHttpHeader(LOCATION);
    if (location != null && location.size() > 0) {
      return location.get(0);
    }
    return null;
  }
}

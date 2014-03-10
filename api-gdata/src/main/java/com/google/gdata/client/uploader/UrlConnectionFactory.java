/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.uploader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Factory for creating HTTP connections.
 *
 * 
 */
interface UrlConnectionFactory {

  /**
   * Default URL connection factory.
   */
  public static final UrlConnectionFactory DEFAULT =
      new UrlConnectionFactory() {
    public HttpURLConnection create(URL url) throws IOException {
      return (HttpURLConnection) url.openConnection();
    }
  };

  /**
   * Creates an HTTP connection to <code>url</code>.
   *
   * @param url denoting the location to connect to
   * @return an HTTP connection to <code>url</code>
   */
  public HttpURLConnection create(URL url) throws IOException;
}

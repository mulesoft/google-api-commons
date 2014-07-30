/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/**
 * Opens HTTP connection using {@link URL#openConnection()}.
 */
public class JdkHttpUrlConnectionSource implements HttpUrlConnectionSource { 

  /** Pre-built instance. */
  public static final JdkHttpUrlConnectionSource INSTANCE = 
      new JdkHttpUrlConnectionSource();

  public HttpURLConnection openConnection(URL url, Proxy proxy) throws IOException {
    if (!url.getProtocol().startsWith("http")) {
      throw new IllegalArgumentException("Not an HTTP url: " + url);
    }
      return proxy == null ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection(proxy);
  }
}

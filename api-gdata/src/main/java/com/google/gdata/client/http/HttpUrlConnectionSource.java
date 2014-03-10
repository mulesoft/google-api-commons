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
import java.net.URL;

/**
 * An object that creates new {@link HttpURLConnection}s.
 */
public interface HttpUrlConnectionSource { 

  /**
   * Creates a new {@link HttpURLConnection} for {@code url}.
   *
   * @param url url to connect to
   * @throws IllegalArgumentException if url is not an HTTP url
   */
  HttpURLConnection openConnection(URL url) throws IOException;
}

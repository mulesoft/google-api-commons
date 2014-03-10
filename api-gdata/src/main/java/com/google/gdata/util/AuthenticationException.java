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
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mule.modules.google.oauth.invalidation.OAuthTokenExpiredException;

/**
 * The AuthenticationException class is used to represent a GData service
 * failure due to authentication.
 *
 * 
 */
public class AuthenticationException extends ServiceException {

  private static final long serialVersionUID = -6345720441624559711L;
  private String authHeader;
  private String scheme;
  private Map<String,String> parameters = new HashMap<String,String>();

  /**
   * Constructs a new AuthenticationException instance based upon
   * the contents of a WWW-Authenticate header as described by
   * RFC2617.
   */
  public AuthenticationException(String message, String authHeader) {
    super(message);
    initFromAuthHeader(authHeader);
  }


  /**
   * Creates a new AuthenticationException without any authentication
   * header information. The WWW-Authenticate header will have
   * to be set separately to build a valid HTTP 401 error response.
   */
  public AuthenticationException(String message) {
    super(message);
  }


  /**
   * Constructs a new AuthenticationException using header and error
   * stream information from an HTTP connection.
   */
  public AuthenticationException(HttpURLConnection httpConn) 
      throws IOException {
    super(httpConn);
    initFromAuthHeader(httpConn.getHeaderField("WWW-Authenticate"));
  }

  // Used to extract scheme info from the WWW-Authenticate header.
  private static final Pattern SCHEME_PATTERN =
    Pattern.compile("([^\\s$]*)\\s*(.*)?");

  
  private static String TOKEN = 
    "[\\p{ASCII}&&[^\\p{Cntrl} \t;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+";

  // Used to extract auth params from the WWW-Authenticate header.
  private static final Pattern PARAM_PATTERN =
    Pattern.compile(
        "(" + TOKEN + ")" +       // param name  (G1)
        "\\s*=\\s*" +
        "(?:" +
          "\"([^\"]*)\"" +        // value as quoted string (G2)
          "|" +
          "(" + TOKEN + ")?" +    // value as token (G3)
        ")");

  /**
   * Initializes internal state from the contents of a WWW-Authenticate
   * header.
   */
  private void initFromAuthHeader(String authHeader) {
    this.authHeader = authHeader;
    if (authHeader == null)
      throw new OAuthTokenExpiredException("No authentication header information");

    Matcher authMatcher = SCHEME_PATTERN.matcher(authHeader);
    if (!authMatcher.matches()) {
      throw new IllegalStateException("Unable to parse auth header: " +
                                      authHeader);
    }
    scheme = authMatcher.group(1);    
    if (authMatcher.groupCount() > 1) {
      Matcher paramMatcher = PARAM_PATTERN.matcher(authMatcher.group(2));
      while (paramMatcher.find()) {
        String value = paramMatcher.group(2);
        if (value == null) {
          value = paramMatcher.group(3);
        }
        parameters.put(paramMatcher.group(1), value);
      }
    }
  }

  public String getScheme() {
    return scheme;
  }

  public String getRealm() {
    return parameters.get("realm");
  }

  public Map<String,String> getParameters() {
    return Collections.unmodifiableMap(parameters);
  }


  public String getAuthHeader() {
    return authHeader;
  }
}

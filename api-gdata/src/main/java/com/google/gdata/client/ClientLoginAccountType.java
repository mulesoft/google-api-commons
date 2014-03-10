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

/**
 * The valid values for the "accountType" parameter in ClientLogin.
 *
 * 
 *
 */
public enum ClientLoginAccountType {
  // Authenticate as a Google account only.
  GOOGLE("GOOGLE"),
  // Authenticate as a hosted account only.
  HOSTED("HOSTED"),
  // Authenticate first as a hosted account; if attempt fails, authenticate as a
  // Google account.  Use HOSTED_OR_GOOGLE if you're not sure which type of
  // account needs authentication. If the user information matches both a hosted
  // and a Google account, only the hosted account is authenticated.
  HOSTED_OR_GOOGLE("HOSTED_OR_GOOGLE");

  private final String accountTypeValue;

  ClientLoginAccountType(String accountTypeValue) {
    this.accountTypeValue = accountTypeValue;
  }

  /** Returns the value of the accountType. */
  public String getValue() {
    return accountTypeValue;
  }
}

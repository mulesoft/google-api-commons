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

import com.google.gdata.util.common.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Signs strings using HMAC-SHA1.
 *
 * 
 */
public class OAuthHmacSha1Signer implements OAuthSigner {

  public String getSignature(String baseString, OAuthParameters oauthParameters)
      throws OAuthException {
    try {
      if (oauthParameters == null) {
        throw new OAuthException("OAuth parameters cannot be null");
      }
      String keyString = getKey(oauthParameters);
      SecretKey key = new SecretKeySpec(keyString.getBytes("UTF-8"), "HmacSHA1");
      Mac mac = Mac.getInstance("HmacSHA1");
      mac.init(key);
      return Base64.encode(mac.doFinal(baseString.getBytes("UTF-8")));
    } catch (UnsupportedEncodingException e) {
      throw new OAuthException(e);
    } catch (NoSuchAlgorithmException e) {
      throw new OAuthException(e);
    } catch (InvalidKeyException e) {
      throw new OAuthException(e);
    }
  }

  private String getKey(OAuthParameters oauthParameters) {
    return (new StringBuilder())
        .append(OAuthUtil.encode(oauthParameters.getOAuthConsumerSecret()))
        .append("&")
        .append(OAuthUtil.encode(oauthParameters.getOAuthTokenSecret()))
        .toString();
  }

  public String getSignatureMethod() {
    return "HMAC-SHA1";
  }

}

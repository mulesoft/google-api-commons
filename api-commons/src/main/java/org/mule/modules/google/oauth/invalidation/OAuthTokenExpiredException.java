/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.oauth.invalidation;


/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public class OAuthTokenExpiredException extends RuntimeException {

	private static final long serialVersionUID = 2088778737502664177L;

	public OAuthTokenExpiredException(String message) {
		super(message);
	}
	
	public OAuthTokenExpiredException(String message, Throwable cause) {
		super(message, cause);
	}
}

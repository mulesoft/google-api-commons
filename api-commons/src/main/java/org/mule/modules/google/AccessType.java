/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google;

/**
 * Indicates if your application needs to access a Google API when the user is not present at the browser
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public enum AccessType {

	/**
	 * Use this if you want the user to be present at the browser
	 */
	online,
	
	/**
	 * If your application needs to refresh access tokens when the user is not present at the browser, then use offline. 
	 * This will result in your application obtaining a refresh token the first time your application exchanges an authorization code for a user.
	 */
	offline
	
}

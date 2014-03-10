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
 * This policy represents which id we want to use to represent each google account.
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public enum IdentifierPolicy {

	/**
	 * This option means that we want the google profile id. That means, the user's
	 * primary key in google's DB. This is a long number represented as a string
	 */
	PROFILE {
		
		public String getId(AbstractGoogleOAuthConnector connector) {
			return GoogleUserIdExtractor.getUserId(connector);
		};
		
	},
	
	/**
	 * This option means you want to use the account's email address
	 */
	EMAIL {
		
		public String getId(AbstractGoogleOAuthConnector connector) {
			return GoogleUserIdExtractor.getUserEmail(connector);
		};
	};
	
	
	public abstract String getId(AbstractGoogleOAuthConnector connector);
	
}

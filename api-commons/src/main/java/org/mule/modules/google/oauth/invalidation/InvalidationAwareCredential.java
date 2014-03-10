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

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpStatusCodes;

/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public class InvalidationAwareCredential extends Credential {

	public InvalidationAwareCredential(AccessMethod method) {
		super(method);
	}
	
	@Override
	public boolean handleResponse(HttpRequest request, HttpResponse response, boolean supportsRetry) {
		if (response.getStatusCode() == HttpStatusCodes.STATUS_CODE_UNAUTHORIZED) {
			throw new OAuthTokenExpiredException(String.format("Service returned %d", HttpStatusCodes.STATUS_CODE_UNAUTHORIZED));
		}
		
		return false;
	}
}

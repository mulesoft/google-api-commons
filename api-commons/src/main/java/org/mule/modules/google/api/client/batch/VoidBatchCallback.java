/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.api.client.batch;

import java.io.IOException;

import com.google.api.client.googleapis.GoogleHeaders;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;

/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public class VoidBatchCallback extends JsonBatchCallback<Void> {
	
	@Override
	public void onFailure(GoogleJsonError e, GoogleHeaders responseHeaders) throws IOException {}
	
	@Override
	public void onSuccess(Void t, GoogleHeaders responseHeaders) {}

}

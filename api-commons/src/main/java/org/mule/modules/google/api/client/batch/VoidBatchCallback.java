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

import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.HttpHeaders;

/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public class VoidBatchCallback extends JsonBatchCallback<Void> {

    @Override
    public void onFailure(GoogleJsonError e, HttpHeaders responseHeaders) throws IOException {

    }

    @Override
    public void onSuccess(Void aVoid, HttpHeaders responseHeaders) throws IOException {

    }
}

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

import java.util.ArrayList;
import java.util.List;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonError.ErrorInfo;


/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public class BatchResponse<T> {

	private List<T> successful = new ArrayList<T>();
	private List<ErrorInfo> errors = new ArrayList<ErrorInfo>();
	
	public BatchResponse<T> addSuccessful(T succesful) {
		this.successful.add(succesful);
		return this;
	}
	
	public BatchResponse<T> addError(GoogleJsonError error) {
		this.errors.addAll(error.getErrors());
		return this;
	}

	public List<T> getSuccessful() {
		return successful;
	}
	
	public List<ErrorInfo> getErrors() {
		return errors;
	}
	
}

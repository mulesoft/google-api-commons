/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.api.domain;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.batch.BatchStatus;
import com.google.gdata.data.batch.BatchUtils;

/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public class BatchResult {

	private String id;
	private BatchStatus status;
	private BaseEntry<?> entry;
	
	public BatchResult(){}
	
	public BatchResult(BaseEntry<?> entry) {
		this.id = BatchUtils.getBatchId(entry);
		this.status = BatchUtils.getBatchStatus(entry);
		this.entry = entry;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BatchStatus getStatus() {
		return status;
	}
	public void setStatus(BatchStatus status) {
		this.status = status;
	}

	public BaseEntry<?> getEntry() {
		return entry;
	}

	public void setEntry(BaseEntry<?> entry) {
		this.entry = entry;
	}
	
}

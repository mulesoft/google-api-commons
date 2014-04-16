/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.api.pagination;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.mule.api.MuleException;
import org.mule.modules.google.AbstractGoogleOAuthConnector;
import org.mule.streaming.ProviderAwarePagingDelegate;

public abstract class TokenBasedPagingDelegate<T> extends ProviderAwarePagingDelegate<T, AbstractGoogleOAuthConnector> {
	
	private String pageToken = null;
	private boolean firstExecution = true;

	@Override
	public void close() throws MuleException {
		this.pageToken = null;
	}
	
	@Override
	public List<T> getPage(AbstractGoogleOAuthConnector connector) {
		if (!this.firstExecution && this.pageToken == null) {
			return Collections.emptyList();
		}
		try {
			this.firstExecution = false;
			return this.doGetPage(connector);
		} catch (IOException e ) {
			throw new RuntimeException(e);
		}
	}
	
	protected abstract List<T> doGetPage(AbstractGoogleOAuthConnector connector) throws IOException;
	
	@Override
	public int getTotalResults(AbstractGoogleOAuthConnector connector) {
		return -1;
	}

	protected String getPageToken() {
		return pageToken;
	}

	protected void setPageToken(String pageToken) {
		this.pageToken = pageToken;
	}
}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.mule.modules.google.AbstractGoogleOAuthConnector;
import org.mule.modules.google.api.pagination.TokenBasedPagingDelegate;

public class TokenBasedPagingDelegateTestCases {

	@Test
	public void testTwoPages() {
        TokenBasedPagingDelegate<String> delegate = new TokenBasedPagingDelegate<String>() {
			
			@Override
			protected List<String> doGetPage(AbstractGoogleOAuthConnector connector) throws IOException {
				if (this.getPageToken() != null) {
					this.setPageToken(null);
				} else {
					this.setPageToken("a token");
				}
				
				return Arrays.asList("one", "two");
			}
			
		};
		
		Assert.assertEquals(2, delegate.getPage(new AbstractGoogleOAuthConnector() {
            @Override
            public String getAccessToken() {
                return null;
            }
            @Override
            public Object getClient() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        }).size());
		Assert.assertEquals(2, delegate.getPage(new AbstractGoogleOAuthConnector() {
            @Override
            public String getAccessToken() {
                return null;
            }
            @Override
            public Object getClient() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        }).size());
		Assert.assertEquals(0, delegate.getPage(new AbstractGoogleOAuthConnector() {
            @Override
            public String getAccessToken() {
                return null;
            }
            @Override
            public Object getClient() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        }).size());
	}
}

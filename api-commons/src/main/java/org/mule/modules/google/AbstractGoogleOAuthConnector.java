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

import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.context.MuleContextAware;
import org.mule.api.transformer.Transformer;


/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public abstract class AbstractGoogleOAuthConnector implements MuleContextAware {
	
	protected static final String USER_PROFILE_SCOPE = "https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email";
	
    private String userId;
    private MuleContext muleContext;
    
	public abstract String getAccessToken();
	
	protected void registerTransformer(Transformer t) {
		synchronized (this.muleContext) {
			try {
				if (this.muleContext.getRegistry().lookupObject(t.getClass()) == null) {
					this.muleContext.getRegistry().registerTransformer(t);
				}
			} catch (MuleException e) {
				throw new RuntimeException("Exception found while trying to register transformer", e);
			}
		}
	}

	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	protected MuleContext getMuleContext() {
		return muleContext;
	}
	
	@Override
	public void setMuleContext(MuleContext muleContext) {
		this.muleContext = muleContext;
	}
	
}

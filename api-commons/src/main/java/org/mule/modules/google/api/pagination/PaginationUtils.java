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

import org.apache.commons.lang.StringUtils;
import org.mule.api.MuleMessage;
import org.mule.api.transport.PropertyScope;

/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public class PaginationUtils {

	/**
	 * Sets the pageToken as an outboundp property on the message under the given property name.
	 * If pageToken is blank or null, then the property is removed.
	 * 
	 * @param propertyName the name of the property on which the page token is going to be stored
	 * @param pageToken the page token
	 * @param message the current mule message
	 */
	public static void savePageToken(String propertyName, String pageToken, MuleMessage message) {
		if (StringUtils.isBlank(pageToken)) {
			message.removeProperty(propertyName, PropertyScope.INVOCATION);
    	} else {
    		message.setInvocationProperty(propertyName, pageToken);
    	}
	}
	
}

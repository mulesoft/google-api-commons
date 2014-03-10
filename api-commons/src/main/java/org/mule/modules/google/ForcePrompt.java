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
 * Force prompt is a parameter for OAuth authentication which lets you
 * configure whether you want to force application authorization each time the 
 * OAuth dance is performed (the force option) or if you want that authorization to happen only
 * once (the auto option)
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public enum ForcePrompt {

	auto,
	force
}

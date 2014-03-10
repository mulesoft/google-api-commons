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

import java.util.Calendar;
import java.util.TimeZone;

import junit.framework.TestCase;

import org.mule.modules.google.api.datetime.DateTimeConstants;
import org.mule.modules.google.api.datetime.DateTimeUtils;

import com.google.api.client.util.DateTime;

/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public class DateTimeUtilsTestCase extends TestCase {
	
	public void testParse() {
		String timezone = TimeZone.getDefault().getDisplayName();
		DateTime dt = DateTimeUtils.parseDateTime("2012-01-01T00:00:00Z", DateTimeConstants.RFC3339, timezone);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getDefault());
		calendar.set(Calendar.YEAR, 2012);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.AM_PM, Calendar.AM);

		assertEquals(dt.getValue(), calendar.getTimeInMillis());
	}
	
	
}

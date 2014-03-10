/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.api.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.google.gdata.data.DateTime;

/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 * 
 */
public abstract class DateTimeUtils {

	public static final String RFC3339 = "yyyy-MM-dd'T'HH:mm:ss'Z'";

	public static DateTime parseDateTime(String date, String pattern,
			String timezone) {
		if (date != null) {
			TimeZone tz = null;
			if (timezone != null) {
				tz = TimeZone.getTimeZone(timezone);
			}
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			try {
				Date javaDate = format.parse(date);
				return tz != null ? new DateTime(javaDate, tz) : new DateTime(
						javaDate);
			} catch (ParseException e) {
				throw new IllegalArgumentException(String.format(
						"Can't parse date %s", date), e);
			}
		}

		return null;
	}
}

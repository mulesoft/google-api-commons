/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.api.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.google.api.client.util.DateTime;

/**
 * Utility class for handling date times
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public abstract class DateTimeUtils {
	
	public static final String RFC3339 = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	
	public static DateTime parseDateTime(String date, String pattern, String timezone) {
    	if (date != null) {
    		TimeZone tz = TimeZone.getTimeZone(timezone);
    		SimpleDateFormat format = new SimpleDateFormat(pattern);
    		try {
    			return new DateTime(format.parse(date), tz);
    		} catch (ParseException e) {
    			throw new IllegalArgumentException(String.format("Can't parse date %s", date), e);
    		}
    	}
    	return null;
    }
	
	public static Date parseDate(String date, String format) {
	    DateFormat df = new SimpleDateFormat(format);
	    try {
	    	return df.parse(date);  
	    } catch (ParseException e) {
	    	throw new IllegalArgumentException(String.format("Could not parse date %s with format %s", date, format));
	    }
	}


}

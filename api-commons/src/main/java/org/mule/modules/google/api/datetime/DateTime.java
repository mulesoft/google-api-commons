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

import java.util.Date;
import java.util.TimeZone;

/**
 * This class wraps an instance of {@link com.google.api.client.util.DateTime}
 * adding setter methods that allow to modify the state of the underlaying date time.
 * This setters are needed for compatibility with Mule's Data Mapper.
 * 
 * Notice that this turns this class mutable in opposition to the underlying one which is unmutable.
 * Mutating this class implies that the underlying instance will be re assigned so be careful when handling the
 * wrapped!!
 * 
 * @author mariano.gonzalez@mulesoft.com
 * 
 */
public final class DateTime {

	private com.google.api.client.util.DateTime wrapped;

	public DateTime(Date date, TimeZone zone) {
		this.wrapped = new com.google.api.client.util.DateTime(date, zone);
	}

	public DateTime(long value) {
		this.setValue(value);
	}

	public DateTime(com.google.api.client.util.DateTime value) {
		this.wrapped = value != null ? value : new com.google.api.client.util.DateTime(new Date(), TimeZone.getTimeZone("UTC"));
	}
	
	public DateTime(Date value) {
		this.wrapped = new com.google.api.client.util.DateTime(value, TimeZone.getTimeZone("UTC"));
	}

	public DateTime(long value, Integer tzShift) {
		this.wrapped = new com.google.api.client.util.DateTime(value, tzShift);
	}

	public DateTime(boolean dateOnly, long value, Integer tzShift) {
		this.wrapped = new com.google.api.client.util.DateTime(dateOnly, value, tzShift);
	}
	
	public DateTime() {
		this.wrapped = new com.google.api.client.util.DateTime(new Date(), TimeZone.getTimeZone("UTC"));
	}
	
	public void setValue(long value) {
		Integer tzs = this.getTimeZoneShift();
		this.setValue(value, tzs != null ? tzs : 0);
	}
	
	public void setValue(long value, int tzShift) {
		this.wrapped = new com.google.api.client.util.DateTime(value, tzShift);
	}

	public long getValue() {
		return wrapped.getValue();
	}

	public Integer getTimeZoneShift() {
		return this.wrapped.getTimeZoneShift();
	}
	
	public void setTimeZoneShift(Integer tzShift) {
		this.wrapped = new com.google.api.client.util.DateTime(this.getValue(), tzShift); 
	}

	public boolean equals(Object o) {
		return wrapped.equals(o);
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public boolean isDateOnly() {
		return wrapped.isDateOnly();
	}

	public String toStringRfc3339() {
		return wrapped.toStringRfc3339();
	}

	public String toString() {
		return wrapped.toString();
	}
	
	public com.google.api.client.util.DateTime getWrapped() {
		return wrapped;
	}

}

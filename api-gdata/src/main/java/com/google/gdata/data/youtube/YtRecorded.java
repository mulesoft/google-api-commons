/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.youtube;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.util.ParseException;

/**
 * Object representation of the tag yt:recorded.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "recorded")
public class YtRecorded extends AbstractExtension { 
  private DateTime date;

  public YtRecorded() {
  }

  public YtRecorded(DateTime date) {
    setDate(date);
  }

  /**
   * Sets the date.
   *
   * @param date a {@link DateTime} that contains only a date. See
   *   {@link DateTime#setDateOnly}.
   */
  public void setDate(DateTime date) {
    if (date != null && !date.isDateOnly()) {
      throw new IllegalStateException(
          "Object should be only a date, not a date and a time");
    }
    this.date = date;
  }

  /**
   * Gets the date.
   *
   * @return a date or {@code null}.
   */
  public DateTime getDate() {
    return date;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);
    if (date != null) {
      generator.setContent(date.toString());
    }
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper) 
      throws ParseException {
    super.consumeAttributes(helper);

    try {
      date = DateTime.parseDate(helper.consumeContent(true));
    } catch (NumberFormatException e) {
      throw new ParseException("Invalid date. Expected format: YYYY-MM-DD");
    }
  }
}

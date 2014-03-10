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
 * Video upload time tag inside "media:group": "yt:uploaded".
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "uploaded")
public class YtUploaded extends AbstractExtension {
  private DateTime dateTime;
  
  public YtUploaded() {
  }

  public YtUploaded(DateTime dateTime) {
    this.dateTime = dateTime;
  }
  
  /**
   * Returns the currently set uploaded date time or null if none set.
   */
  public DateTime getDateTime() {
    return dateTime;
  }
  
  /**
   * Changes the uploaded date time.
   */
  public void setDateTime(DateTime dateTime) {
    this.dateTime = dateTime;
  }
  
  @Override
  protected void consumeAttributes(AttributeHelper helper) throws ParseException {
    super.consumeAttributes(helper);

    try {
      dateTime = DateTime.parseDateTime(helper.consumeContent(true));
    } catch (NumberFormatException e) {
      throw new ParseException("Invalid date time format.");
    }
  }
  
  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);
    if (dateTime != null) {
      generator.setContent(dateTime.toString());
    }
  }
}

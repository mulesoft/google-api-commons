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
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.util.ParseException;

/**
 * Duration class.
 *
 * This completes the duration field in
 * {@link com.google.gdata.data.media.mediarss.MediaContent} and is
 * useful when there is no MediaContent.
 *
 * This tag should go inside MediaGroup, next to {@code media:player}
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "duration"
)
public class YtDuration extends AbstractExtension {
  private long seconds;

  /** Creates an empty duration tag. */
  public YtDuration() {

  }

  /** Creates and initializes a duration tag. */
  public YtDuration(long seconds) {
    this.seconds = seconds;
  }

  /** Gets duration in seconds. */
  public long getSeconds() {
    return seconds;
  }

  /** Sets duration in seconds. */
  public void setSeconds(long seconds) {
    this.seconds = seconds;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    generator.put("seconds", seconds);
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper)
      throws ParseException {
    seconds = helper.consumeLong("seconds", true);
  }
}

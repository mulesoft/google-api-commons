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
 * VideoId class.
 *
 * This sets the yt:videoid in the MediaGroup.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "videoid"
)
public class YtVideoId extends AbstractExtension {
  private String videoId;

  /** Creates an empty video ID tag. */
  public YtVideoId() {

  }

  /** Creates and initializes a video ID tag. */
  public YtVideoId(String videoId) {
    this.videoId = videoId;
  }

  /** Gets video ID. */
  public String getVideoId() {
    return videoId;
  }

  /** Sets video ID. */
  public void setVideoId(String id) {
    this.videoId = id;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);
    generator.setContent(videoId);
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper)
      throws ParseException {
    super.consumeAttributes(helper);
    videoId = helper.consumeContent(true);
  }
}

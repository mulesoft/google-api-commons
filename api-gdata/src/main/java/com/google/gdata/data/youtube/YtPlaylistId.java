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
 * yt:playlistid tag found in the subscription entry.
 * 
 * 
 *
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "playlistId")
public class YtPlaylistId  extends AbstractExtension {
  private String playlistId;
  /** 
   * Creates an empty tag. 
   */
  public YtPlaylistId() {
  }

  /**
   * Creates a tag and initializes its content.
   *
   * @param playlistId id of the playlist
   */
  public YtPlaylistId(String playlistId) {
    this.playlistId = playlistId;
  }
  
  public String getPlaylistId() {
    return playlistId;
  }
  
  public void setPlaylistId(String playlistId) {
    this.playlistId = playlistId;
  }
  
  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);
    generator.setContent(playlistId);
  }
  
  @Override
  protected void consumeAttributes(AttributeHelper helper)
      throws ParseException {
    super.consumeAttributes(helper);
    playlistId = helper.consumeContent(true);
  }
}

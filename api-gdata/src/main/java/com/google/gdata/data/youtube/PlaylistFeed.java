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

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.data.batch.BatchUtils;

/**
 * A YouTube playlist feed.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_PLAYLIST)
public class PlaylistFeed extends BaseFeed<PlaylistFeed, PlaylistEntry> {

  /**
   * Nonstandard categories that might be found in this feed.
   */
  public static final String[] CATEGORIES = {
    YouTubeNamespace.TAG_SCHEME
  };

  public PlaylistFeed() {
    super(PlaylistEntry.class);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_PLAYLIST);
  }

  public PlaylistFeed(BaseFeed<?, ?> base) {
    super(PlaylistEntry.class, base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_PLAYLIST);
  }
  
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    extProfile.declareFeedExtension(YtPrivate.class);
    extProfile.declareFeedExtension(YouTubeMediaGroup.class);
    extProfile.declare(PlaylistFeed.class, YtPlaylistId.class);
    new YouTubeMediaGroup().declareExtensions(extProfile);
    BatchUtils.declareExtensions(extProfile);
  }
  
  /**
   * Get the id of the playlist.
   * @return the playlist id
   */
  public String getPlaylistId() {
    YtPlaylistId playlistId = getExtension(YtPlaylistId.class);
    return playlistId == null ? null : playlistId.getPlaylistId();
  }  
  
  /**
   * Set the id of the playlist. 
   * @param playlistId the id of the playlist
   */
  public void setPlaylistId(String playlistId) {
    if (playlistId != null) {
      addExtension(new YtPlaylistId(playlistId));
    } else {
      removeExtension(YtPlaylistId.class);
    }
  }

  /** Gets the private field of the feed. */
  public boolean isPrivate() {
    return getExtension(YtPrivate.class) != null;
  }

  /** Sets the private field of the feed. */
  public void setPrivate(boolean value) {
    if (value) {
      setExtension(new YtPrivate());
    } else {
      removeExtension(YtPrivate.class);
    }
  }

  public YouTubeMediaGroup getMediaGroup() {
    return getExtension(YouTubeMediaGroup.class);
  }

  public YouTubeMediaGroup getOrCreateMediaGroup() {
    YouTubeMediaGroup group = getMediaGroup();
    if (group == null) {
      group = new YouTubeMediaGroup();
      setExtension(group);
    }
    return group;
  }
}

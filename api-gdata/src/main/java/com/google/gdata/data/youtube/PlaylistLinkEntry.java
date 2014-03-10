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

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;

/**
 * Entries that appear on the user playlist feed.
 *
 * This entry does not contain a playlist, but a link to a playlist. See
 * {@link PlaylistFeed} and {@link PlaylistEntry} for the playlist feed
 * objects.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_PLAYLIST_LINK)
public class PlaylistLinkEntry extends FeedLinkEntry<PlaylistLinkEntry>{

  /**
   * Nonstandard categories that might be found in this entry.
   */
  public static final String[] CATEGORIES = {
    YouTubeNamespace.TAG_SCHEME
  };

  public PlaylistLinkEntry() {
    EntryUtils.setKind(this, YouTubeNamespace.KIND_PLAYLIST_LINK);
  }

  public PlaylistLinkEntry(BaseEntry<?> base) {
    super(base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_PLAYLIST_LINK);
  }

  /** Sets the private flag. */
  public void setPrivate(boolean value) {
    if (value) {
      setExtension(new YtPrivate());
    } else {
      removeExtension(YtPrivate.class);
    }
  }

  /** Gets the value of the private flag. */
  public boolean isPrivate() {
    return getExtension(YtPrivate.class) != null;
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
  
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    extProfile.declare(PlaylistLinkEntry.class, YtPlaylistId.class);
  }
}

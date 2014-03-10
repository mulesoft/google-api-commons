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
 * A YouTube playlist entry.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_PLAYLIST)
public class PlaylistEntry extends VideoEntry {
  /** Creates an empty playlist entry. */
  public PlaylistEntry() {
    super();
    EntryUtils.setKind(this, YouTubeNamespace.KIND_PLAYLIST);
  }

  /** Creates a copy of another entry. */
  public PlaylistEntry(BaseEntry<?> original) {
    super(original);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_PLAYLIST);
  }

  /**
   * Declares extensions that can appear in this entry.
   *
   * The namespaces should be declared by the feeds themselves
   * if they want them to appear in the top element of the feed.
   *
   * @param extProfile profile to register extensions to
   */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    
    extProfile.declare(PlaylistEntry.class, YtPosition.class);
    // yt:description only in version 1
    extProfile.declare(PlaylistEntry.class, YtDescription.class);
    extProfile.declareArbitraryXmlExtension(PlaylistEntry.class);
  }

  /** 
   * Gets the 0-based position of this entry in the playlist.
   *
   * @return the position or null if not found
   */
  public Integer getPosition() {
    YtPosition position = getExtension(YtPosition.class);
    return position == null ? null : position.getPosition();
  }

  /**
   * Sets the 0-based position of this entry in the playlist.
   *
   * @param position the new position
   */
  public void setPosition(Integer position) {
    if (position == null) {
      removeExtension(YtPosition.class);
    } else {
      setExtension(new YtPosition(position));
    }
  }

  /** 
   * Gets the playlist description. 
   *
   * @deprecated Valid only in version 1. Replaced version 2.0 with
   *             atom:summary.
   */
  @Deprecated
  public String getDescription() {
    YtDescription description = getExtension(YtDescription.class);
    return description == null ? null : description.getContent();
  }

  /** 
   * Sets the playlist description. 
   *
   * @deprecated Valid only in version 1. Replaced version 2.0 with
   *             atom:summary.
   */
  @Deprecated
  public void setDescription(String description) {
    if (description == null) {
      removeExtension(YtDescription.class);
    } else {
      setExtension(new YtDescription(description));
    }
  }
}

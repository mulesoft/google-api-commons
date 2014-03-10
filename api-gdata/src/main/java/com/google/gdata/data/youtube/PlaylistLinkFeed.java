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

import com.google.gdata.data.Kind;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.batch.BatchUtils;

/**
 * A feed that contains playlist link entries.
 *
 * This feed does not represent a playlist, but a collection of links to
 * playlist feeds. See {@link PlaylistFeed} and {@link PlaylistEntry} for
 * the playlist feed.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_PLAYLIST_LINK)
public class PlaylistLinkFeed
    extends BaseFeed<PlaylistLinkFeed, PlaylistLinkEntry> {

  public PlaylistLinkFeed() {
    super(PlaylistLinkEntry.class);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_PLAYLIST_LINK);
  }

  public PlaylistLinkFeed(BaseFeed<?, ?> base) {
    super(PlaylistLinkEntry.class, base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_PLAYLIST_LINK);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    BatchUtils.declareExtensions(extProfile);
  }
}

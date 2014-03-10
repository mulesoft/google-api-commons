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
 * A YouTube shared video entry.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_VIDEO_MESSAGE)
public class VideoMessageEntry extends VideoEntry {

  /** Creates an empty inbox entry. */
  public VideoMessageEntry() {
    super();
    EntryUtils.setKind(this, YouTubeNamespace.KIND_VIDEO_MESSAGE);
  }

  /** Creates a copy of another entry. */
  public VideoMessageEntry(BaseEntry<?> original) {
    super(original);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_VIDEO_MESSAGE);
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

    // yt:description only in version 1
    extProfile.declare(VideoMessageEntry.class, YtDescription.class);
    extProfile.declareArbitraryXmlExtension(PlaylistEntry.class);
  }

  /** 
   * Gets the message sent together with the video. 
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
   * Sets the message sent together with the video. 
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

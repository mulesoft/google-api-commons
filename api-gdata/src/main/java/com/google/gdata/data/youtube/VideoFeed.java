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
import com.google.gdata.data.Link;
import com.google.gdata.data.media.MediaFeed;
import com.google.gdata.data.batch.BatchUtils;

/**
 * Video feed returned by the feed providers.
 * 
 * 
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_VIDEO)
public class VideoFeed extends MediaFeed<VideoFeed, VideoEntry> {

  public VideoFeed() {
    super(VideoEntry.class);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_VIDEO);
  }

  public VideoFeed(BaseFeed<?, ?> base) {
    super(VideoEntry.class, base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_VIDEO);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    BatchUtils.declareExtensions(extProfile);
  }

  /**
   * Gets a link to the "Get Upload Token" action.
   *
   * @return a link with rel {@link YouTubeNamespace#GET_UPLOAD_TOKEN_REL} 
   *   or {@code null}.
   */
  public Link getGetUploadTokenActionLink() {
    for (Link link : getLinks()) {
      if (YouTubeNamespace.GET_UPLOAD_TOKEN_REL.equals(link.getRel())) {
        return link;
      }
    }
    return null;
  }
}

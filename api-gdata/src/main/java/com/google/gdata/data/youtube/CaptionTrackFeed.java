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
 * A feed of {@link CaptionTrackEntry}
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_CAPTION_TRACK)
public class CaptionTrackFeed
    extends BaseFeed<CaptionTrackFeed, CaptionTrackEntry>{

  public CaptionTrackFeed() {
    super(CaptionTrackEntry.class);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_CAPTION_TRACK);
  }

  public CaptionTrackFeed(BaseFeed<?, ?> base) {
    super(CaptionTrackEntry.class, base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_CAPTION_TRACK);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    BatchUtils.declareExtensions(extProfile);
  }
}

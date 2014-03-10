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
 * Feed containing channels. 
 * 
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_CHANNEL)
public class ChannelFeed  extends BaseFeed<ChannelFeed, ChannelEntry>{
  
  public ChannelFeed() {
    super(ChannelEntry.class);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_CHANNEL);
  }

  public ChannelFeed(BaseFeed<?, ?> base) {
    super(ChannelEntry.class, base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_CHANNEL);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    BatchUtils.declareExtensions(extProfile);
  }}

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
import com.google.gdata.data.batch.BatchUtils;

/**
 * A feed that contains a list of {@link FriendEntry}.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_FRIEND)
public class FriendFeed
    extends BaseFeed<FriendFeed, FriendEntry> {

  public FriendFeed() {
    super(FriendEntry.class);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_FRIEND);
  }

  public FriendFeed(BaseFeed<?, ?> base) {
    super(FriendEntry.class, base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_FRIEND);
  }

  /** Returns a link to the profile of this user. */
  public Link getUserProfileLink() {
    return getLink(Link.Rel.RELATED, Link.Type.ATOM);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    BatchUtils.declareExtensions(extProfile);
  }
}

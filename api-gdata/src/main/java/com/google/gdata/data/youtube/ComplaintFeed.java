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
import com.google.gdata.data.Kind;

/**
 * A feed that contains a list of {@link ComplaintEntry}.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_COMPLAINT)
public class ComplaintFeed
    extends BaseFeed<ComplaintFeed, ComplaintEntry> {

  public ComplaintFeed() {
    super(ComplaintEntry.class);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_COMPLAINT);
  }

  public ComplaintFeed(BaseFeed<?, ?> base) {
    super(ComplaintEntry.class, base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_COMPLAINT);
  }
}

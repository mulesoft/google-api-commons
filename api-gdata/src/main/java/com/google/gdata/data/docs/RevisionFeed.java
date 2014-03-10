/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.docs;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;

/**
 * A feed for accessing different revisions of a doclist document.
 *
 * 
 */
@Kind.Term(RevisionEntry.KIND)
public class RevisionFeed
    extends BaseFeed<RevisionFeed, RevisionEntry> {

  /**
   * Contructs an empty feed.
   */
  public RevisionFeed() {
    super(RevisionEntry.class);
    getCategories().add(RevisionEntry.CATEGORY);
  }
}

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
 * Describes an Archive feed.
 *
 * 
 */
@Kind.Term(ArchiveEntry.KIND)
public class ArchiveFeed extends BaseFeed<ArchiveFeed, ArchiveEntry> {

  /**
   * Default mutable constructor.
   */
  public ArchiveFeed() {
    super(ArchiveEntry.class);
    getCategories().add(ArchiveEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public ArchiveFeed(BaseFeed<?, ?> sourceFeed) {
    super(ArchiveEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{ArchiveFeed " + super.toString() + "}";
  }

}


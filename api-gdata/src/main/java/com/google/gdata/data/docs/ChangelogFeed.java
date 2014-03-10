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
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;

/**
 * Describes a feed for retrieving a list of changed documents.
 *
 * 
 */
@Kind.Term(ChangelogEntry.KIND)
public class ChangelogFeed extends BaseFeed<ChangelogFeed, ChangelogEntry> {

  /**
   * Default mutable constructor.
   */
  public ChangelogFeed() {
    super(ChangelogEntry.class);
    getCategories().add(ChangelogEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public ChangelogFeed(BaseFeed<?, ?> sourceFeed) {
    super(ChangelogEntry.class, sourceFeed);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(ChangelogFeed.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(ChangelogFeed.class,
        LargestChangestamp.getDefaultDescription(true, false));
  }

  /**
   * Returns the largest changestamp.
   *
   * @return largest changestamp
   */
  public LargestChangestamp getLargestChangestamp() {
    return getExtension(LargestChangestamp.class);
  }

  /**
   * Sets the largest changestamp.
   *
   * @param largestChangestamp largest changestamp or <code>null</code> to reset
   */
  public void setLargestChangestamp(LargestChangestamp largestChangestamp) {
    if (largestChangestamp == null) {
      removeExtension(LargestChangestamp.class);
    } else {
      setExtension(largestChangestamp);
    }
  }

  /**
   * Returns whether it has the largest changestamp.
   *
   * @return whether it has the largest changestamp
   */
  public boolean hasLargestChangestamp() {
    return hasExtension(LargestChangestamp.class);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{ChangelogFeed " + super.toString() + "}";
  }

}


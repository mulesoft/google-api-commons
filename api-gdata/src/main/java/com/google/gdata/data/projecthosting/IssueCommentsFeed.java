/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.projecthosting;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;

/**
 * Describes an issue comments feed.
 *
 * 
 */
public class IssueCommentsFeed extends BaseFeed<IssueCommentsFeed,
    IssueCommentsEntry> {

  /**
   * Default mutable constructor.
   */
  public IssueCommentsFeed() {
    super(IssueCommentsEntry.class);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public IssueCommentsFeed(BaseFeed<?, ?> sourceFeed) {
    super(IssueCommentsEntry.class, sourceFeed);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(IssueCommentsFeed.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(IssueCommentsFeed.class,
        IssuesLink.getDefaultDescription(true, true));
  }

  @Override
  public String toString() {
    return "{IssueCommentsFeed " + super.toString() + "}";
  }

}

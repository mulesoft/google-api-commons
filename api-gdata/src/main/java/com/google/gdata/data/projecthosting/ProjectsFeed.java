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
import com.google.gdata.data.Link;

/**
 * Google Code Projects Feed.
 *
 * 
 */
public class ProjectsFeed extends BaseFeed<ProjectsFeed, ProjectSummaryEntry> {

  /**
   * Default mutable constructor.
   */
  public ProjectsFeed() {
    super(ProjectSummaryEntry.class);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public ProjectsFeed(BaseFeed<?, ?> sourceFeed) {
    super(ProjectSummaryEntry.class, sourceFeed);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(ProjectsFeed.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(ProjectsFeed.class,
        IssuesLink.getDefaultDescription(true, true));
  }

  /**
   * Returns the link that provides the URI of the full feed (without any query
   * parameters).
   *
   * @return Link that provides the URI of the full feed (without any query
   *     parameters) or {@code null} for none.
   */
  public Link getFeedLink() {
    return getLink(Link.Rel.FEED, Link.Type.ATOM);
  }

  @Override
  public String toString() {
    return "{ProjectsFeed " + super.toString() + "}";
  }

}


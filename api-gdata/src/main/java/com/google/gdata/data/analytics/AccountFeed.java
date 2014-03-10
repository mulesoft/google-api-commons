/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.analytics;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;

import java.util.List;

/**
 * Feed element in account feed.
 *
 * 
 */
public class AccountFeed extends BaseFeed<AccountFeed, AccountEntry> {

  /**
   * Default mutable constructor.
   */
  public AccountFeed() {
    super(AccountEntry.class);
    setKind("analytics#accounts");
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public AccountFeed(BaseFeed<?, ?> sourceFeed) {
    super(AccountEntry.class, sourceFeed);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(AccountFeed.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(AccountFeed.class, Segment.getDefaultDescription(false,
        true));
    new Segment().declareExtensions(extProfile);
  }

  /**
   * Returns the segments.
   *
   * @return segments
   */
  public List<Segment> getSegments() {
    return getRepeatingExtension(Segment.class);
  }

  /**
   * Adds a new segment.
   *
   * @param segment segment
   */
  public void addSegment(Segment segment) {
    getSegments().add(segment);
  }

  /**
   * Returns whether it has the segments.
   *
   * @return whether it has the segments
   */
  public boolean hasSegments() {
    return hasRepeatingExtension(Segment.class);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{AccountFeed " + super.toString() + "}";
  }

}


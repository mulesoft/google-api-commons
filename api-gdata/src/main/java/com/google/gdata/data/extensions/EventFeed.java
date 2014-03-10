/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.extensions;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;

/**
 * The EventFeed class customizes the generic event feed class to define
 * a feed of events.
 */
@Kind.Term(EventEntry.EVENT_KIND)
public class EventFeed extends BaseEventFeed<EventFeed, EventEntry> {

  /**
   * Constructs a new {@code EventFeed} instance that is parameterized to
   * contain {@code EventEntry} instances.
   */
  public EventFeed() {
    super(EventEntry.class);
  }

  /**
   * Constructs a new {@code EventFeed} instance that is initialized using
   * data from another BaseFeed instance.
   */
  public EventFeed(BaseFeed<?, ?> sourceFeed) {
    super(EventEntry.class, sourceFeed);
  }
}

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
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;

/**
 * The Message class customizes the generic BaseEntry class to define
 * a feed of Message entries.
 *
 * 
 * 
 */
@Kind.Term(MessageEntry.MESSAGE_KIND)
public class MessageFeed extends BaseFeed<MessageFeed, MessageEntry> {

  /**
   * Constructs a new {@code MessageFeed} instance that is parameterized to
   * contain {@code MessageEntry} instances.
   */
  public MessageFeed() {
    super(MessageEntry.class);
    getCategories().add(MessageEntry.MESSAGE_CATEGORY);
  }

  /**
   * Constructs a new {@code MessageFeed} instance that is initialized using
   * data from another BaseFeed instance.
   */
  public MessageFeed(BaseFeed<?, ?> sourceFeed) {
    super(MessageEntry.class, sourceFeed);
    getCategories().add(MessageEntry.MESSAGE_CATEGORY);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);

    // Add any feed-level extension declarations here.
  }

  // Any feed-level extension accessor APIs would go here
}

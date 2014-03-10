/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.webmastertools;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Category;

/**
 * The MessagesFeed class extends the BaseFeed class to define
 * a feed of messages. This are the messages from the Webmaster Tools
 * Notification Console that are directed to the webmaster.
 *
 * 
 */
public class MessagesFeed extends BaseFeed<MessagesFeed, MessageEntry> {

  /**
   * Creates a {@code MessagesFeed} feed that contains {@code MessageEntry}
   * entries.
   */
  public MessagesFeed() {
    super(MessageEntry.class);
    this.getCategories().add(CATEGORY);
  }

  /**
   * Kind category used to label feed.
   */
  private static final Category CATEGORY
      = Namespaces.createCategory(Namespaces.KIND_MESSAGES_FEED);

  /**
   * Declares extensions. The only extension that we add to the feed is
   * the Webmaster Tools namespace. See {@link MessageEntry} for the other
   * custom extensions at the entry level.
   */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    extProfile.declareAdditionalNamespace(Namespaces.WT_NAMESPACE);
  }
}

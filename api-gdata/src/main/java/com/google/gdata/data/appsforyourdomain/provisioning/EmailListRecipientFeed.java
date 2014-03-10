/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.appsforyourdomain.provisioning;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;

/**
 * 
 */
@Kind.Term(EmailListRecipientEntry.EMAILLIST_RECIPIENT_KIND)
public class EmailListRecipientFeed
    extends BaseFeed<EmailListRecipientFeed, EmailListRecipientEntry> {

  /**
   * Constructs a new {@code EmailListRecipientFeed} instance that is
   * parameterized to contain {@code EmailListRecipientEntry} instances.
   */
  public EmailListRecipientFeed() {
    super(EmailListRecipientEntry.class);
    getCategories().add(EmailListRecipientEntry.EMAILLIST_RECIPIENT_CATEGORY);
  }

  /**
   * Constructs a new {@code EmailListRecipientFeed} instance that is
   * initialized using data from another BaseFeed instance.
   */
  public EmailListRecipientFeed(BaseFeed sourceFeed) {
    super(EmailListRecipientEntry.class, sourceFeed);
    getCategories().add(EmailListRecipientEntry.EMAILLIST_RECIPIENT_CATEGORY);
  }

  @Override
  public void declareExtensions(ExtensionProfile extensionProfile) {
    super.declareExtensions(extensionProfile);
  }
}

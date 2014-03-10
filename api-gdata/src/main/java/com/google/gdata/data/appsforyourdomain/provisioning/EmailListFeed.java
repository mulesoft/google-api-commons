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
 * 
 */
@Kind.Term(EmailListEntry.EMAIL_LIST_KIND)
public class EmailListFeed extends BaseFeed<EmailListFeed, EmailListEntry> {

  /**
   * Constructs a new {@code EmailListFeed} instance that is parameterized to
   * contain {@code EmailListEntry} instances.
   */
  public EmailListFeed() {
    super(EmailListEntry.class);
    getCategories().add(EmailListEntry.EMAIL_LIST_CATEGORY);
  }

  /**
   * Constructs a new {@code EmailListFeed} instance that is initialized using
   * data from another BaseFeed instance.
   */
  public EmailListFeed(BaseFeed<?, ?> sourceFeed) {
    super(EmailListEntry.class, sourceFeed);
    getCategories().add(EmailListEntry.EMAIL_LIST_CATEGORY);
  }

  @Override
  public void declareExtensions(ExtensionProfile extensionProfile) {
    super.declareExtensions(extensionProfile);
  }
}

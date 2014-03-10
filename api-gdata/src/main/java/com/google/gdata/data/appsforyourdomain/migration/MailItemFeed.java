/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.gdata.data.appsforyourdomain.migration;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;

/**
 * The MailItemFeed class customizes the generic BaseEntry class to define
 * a feed of MailItem entries.
 *
 * 
 */
@Kind.Term(MailItemEntry.MAILITEM_KIND)
public class MailItemFeed extends BaseFeed<MailItemFeed, MailItemEntry> {

  /**
   * Constructs a new {@code MailItemFeed} instance that is parameterized to
   * contain {@code MailItemEntry} instances.
   */
  public MailItemFeed() { 
    super(MailItemEntry.class);
    getCategories().add(MailItemEntry.MAILITEM_CATEGORY);
  }
  
  /**
   * Constructs a new {@code MailItem} instance that is initialized using
   * data from another BaseFeed instance.
   */
  public MailItemFeed(BaseFeed<?, ?> sourceFeed) {
    super(MailItemEntry.class, sourceFeed);
    getCategories().add(MailItemEntry.MAILITEM_CATEGORY);
  }   
  
  /** Declares feed-level extensions into the extension profile. */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    // No feed-level extensions.
    super.declareExtensions(extProfile);
  }   
}
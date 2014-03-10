/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.contacts;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;

/**
 * Describes a contact feed.
 *
 * 
 */
@Kind.Term(ContactEntry.KIND)
public class ContactFeed extends BaseFeed<ContactFeed, ContactEntry> {

  /**
   * Default mutable constructor.
   */
  public ContactFeed() {
    super(ContactEntry.class);
    getCategories().add(ContactEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public ContactFeed(BaseFeed<?, ?> sourceFeed) {
    super(ContactEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{ContactFeed " + super.toString() + "}";
  }

}


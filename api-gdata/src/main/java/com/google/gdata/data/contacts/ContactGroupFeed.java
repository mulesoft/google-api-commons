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
 * Describes a contact group feed.
 *
 * 
 */
@Kind.Term(ContactGroupEntry.KIND)
public class ContactGroupFeed extends BaseFeed<ContactGroupFeed,
    ContactGroupEntry> {

  /**
   * Default mutable constructor.
   */
  public ContactGroupFeed() {
    super(ContactGroupEntry.class);
    getCategories().add(ContactGroupEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public ContactGroupFeed(BaseFeed<?, ?> sourceFeed) {
    super(ContactGroupEntry.class, sourceFeed);
  }

  @Override
  public String toString() {
    return "{ContactGroupFeed " + super.toString() + "}";
  }

}


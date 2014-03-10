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
 * The Contact class customizes the generic BaseEntry class to define
 * a feed of Contact entries.
 *
 * @deprecated Please use {@link com.google.gdata.data.contacts.ContactFeed}
 *     instead.
 * 
 */
@Kind.Term(ContactEntry.CONTACT_KIND)
@Deprecated
public class ContactFeed extends BaseFeed<ContactFeed, ContactEntry> {

  /**
   * Constructs a new {@code ContactFeed} instance that is parameterized to
   * contain {@code ContactEntry} instances.
   */
  public ContactFeed() {
    super(ContactEntry.class);
    getCategories().add(ContactEntry.CONTACT_CATEGORY);
  }

  /**
   * Constructs a new {@code ContactFeed} instance that is initialized using
   * data from another BaseFeed instance.
   */
  public ContactFeed(BaseFeed<?, ?> sourceFeed) {
    super(ContactEntry.class, sourceFeed);
    getCategories().add(ContactEntry.CONTACT_CATEGORY);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {

    // Add any feed-level extension declarations here.

    super.declareExtensions(extProfile);
  }

  // Any feed-level extension accessor APIs would go here
}

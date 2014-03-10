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

/**
 * Extends the base Link class with contact extensions.
 *
 * 
 */
public class ContactLink {

  /** Link relation type. */
  public static final class Rel {

    /** Link that provides the contact photo. */
    public static final String CONTACT_PHOTO =
        "http://schemas.google.com/contacts/2008/rel#photo";

    /** Link to edit contact photo. */
    public static final String EDIT_CONTACT_PHOTO =
        "http://schemas.google.com/contacts/2008/rel#edit-photo";

  }

  /** MIME type of link target. */
  public static final class Type {

    /** Image/* Contact Link class. */
    public static final String IMAGE = "image/*";

  }

  /** Private constructor to ensure class is not instantiated. */
  private ContactLink() {}

}


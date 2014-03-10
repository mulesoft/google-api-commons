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

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Namespace definitions related to Google Contacts Data API.
 *
 * 
 */
public class ContactsNamespace {

  private ContactsNamespace() {}

  /** Google Contacts (GCONTACT) namespace */
  public static final String GCONTACT =
      "http://schemas.google.com/contact/2008";

  /** Google Contacts (GCONTACT) namespace prefix */
  public static final String GCONTACT_PREFIX = GCONTACT + "#";

  /** Google Contacts (GCONTACT) namespace alias */
  public static final String GCONTACT_ALIAS = "gContact";

  /** XML writer namespace for Google Contacts (GCONTACT) */
  public static final XmlNamespace GCONTACT_NS = new
      XmlNamespace(GCONTACT_ALIAS, GCONTACT);

}


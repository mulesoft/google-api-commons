/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.appsforyourdomain;

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Google Apps for Your Domain namespace.
 * 
 */
public class Namespaces {

  /** Google Apps for Your Domain namespace */
  public static final String APPS = "http://schemas.google.com/apps/2006";
  public static final String APPS_PREFIX = APPS + "#";

  /** Describes the meaning of FeedLinks in the UserEntry */
  public static final String USER_NICKNAME_REL
      = APPS_PREFIX + "user.nicknames";
  public static final String USER_EMAILLIST_REL
      = APPS_PREFIX + "user.emailLists"; 

  /** Describes the meaning of FeedLinks in the EmailListEntry */
  public static final String EMAILLIST_RECIPIENT_REL
      = APPS_PREFIX + "emailList.recipients";

  /** Describes the meaning of Who extensions in the EmailListRecipientEntry */
  public static final String EMAILLISTRECIPIENT_WHO_REL
      = APPS_PREFIX + "emailList.recipient";
 
  /** Google data XML writer namespace. */
  public static final XmlNamespace APPS_NAMESPACE
      = new XmlNamespace("apps", APPS);
  
  /** Google data rel's for migration API */
  public static final String OWNER_REL = APPS + "/rel/owner";
  public static final String DESTINATION_REL = APPS + "/rel/destinationAccount";
  public static final String MIGRATION_REL = APPS + "/rel/migration";
  public static final String TRANSFER_REL = MIGRATION_REL + "/transfer";
  public static final String DELIVERY_TIME_REL = APPS + "/rel/deliveryTime";

  private Namespaces() {
  }

}

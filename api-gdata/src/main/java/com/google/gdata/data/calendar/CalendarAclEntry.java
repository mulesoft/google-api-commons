/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

// manual changes (dimas):
// 1. extends BaseAclEntry<CalendarAclEntry> -> extends AclEntry (+/- imports)
// 2. thus removing public CalendarAclEntry(BaseEntry<?> sourceEntry) { super }

package com.google.gdata.data.calendar;

import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.acl.AclEntry;

/**
 * Describes an entry in a feed of a Calendar access control list (ACL).
 *
 * 
 */
public class CalendarAclEntry extends AclEntry {

  /**
   * Default mutable constructor.
   */
  public CalendarAclEntry() {
    super();
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(CalendarAclEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(CalendarAclEntry.class,
        SendAclNotificationsProperty.class);
  }

  /**
   * Returns the send acl notifications property.
   *
   * @return send acl notifications property
   */
  public SendAclNotificationsProperty getSendAclNotifications() {
    return getExtension(SendAclNotificationsProperty.class);
  }

  /**
   * Sets the send acl notifications property.
   *
   * @param sendAclNotifications send acl notifications property or
   *     <code>null</code> to reset
   */
  public void setSendAclNotifications(SendAclNotificationsProperty
      sendAclNotifications) {
    if (sendAclNotifications == null) {
      removeExtension(SendAclNotificationsProperty.class);
    } else {
      setExtension(sendAclNotifications);
    }
  }

  /**
   * Returns whether it has the send acl notifications property.
   *
   * @return whether it has the send acl notifications property
   */
  public boolean hasSendAclNotifications() {
    return hasExtension(SendAclNotificationsProperty.class);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{CalendarAclEntry " + super.toString() + "}";
  }

}

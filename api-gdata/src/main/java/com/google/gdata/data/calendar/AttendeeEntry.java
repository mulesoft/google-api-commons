/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.calendar;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.ExtensionProfile;

/**
 * This is used to represent an entry in an attendee feed.
 *
 * 
 */
public class AttendeeEntry extends BaseEntry<AttendeeEntry> {

  public AttendeeEntry() {
    super();
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    // When inviting/removing attendees we can control whether to send
    // them notifications or not.  We re-purpose
    // SendEventNotificationsProperty for this task.
    extProfile.declare(CalendarEventEntry.class,
        SendEventNotificationsProperty.getDefaultDescription());
  }

  /**
   * Whether to send event notifications or not. Default is to not send
   * notifications to the attendee involved.
   */
  public boolean getSendEventNotifications() {
    SendEventNotificationsProperty send = getExtension(
        SendEventNotificationsProperty.class);
    return send != null && Boolean.parseBoolean(send.getValue());
  }

  /**
   * Sets whether event notifications are to be sent to attendee or
   * not.
   */
  public void setSendEventNotifications(boolean send) {
    setExtension(send ? SendEventNotificationsProperty.TRUE
        : SendEventNotificationsProperty.FALSE);
  }
}

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

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * GData schema extension describing whether to send event notifications
 * to other participants of the event or not.
 *
 * 
 */
public class SendEventNotificationsProperty extends ValueConstruct {

  public static final SendEventNotificationsProperty TRUE =
      new SendEventNotificationsProperty(String.valueOf(true));

  public static final SendEventNotificationsProperty FALSE =
      new SendEventNotificationsProperty(String.valueOf(false));

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(SendEventNotificationsProperty.class,
        Namespaces.gCalNs, "sendEventNotifications");
  }

  public SendEventNotificationsProperty() {
    this(null);
  }

  public SendEventNotificationsProperty(String value) {
    super(Namespaces.gCalNs, "sendEventNotifications", "value", value);
  }
}

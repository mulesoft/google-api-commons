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
 * GData schema extension describing the UID in the ical export of the event.
 * The value can be an arbitrary string and is described in section 4.8.4.7
 * of RFC 2445. This value is different from the value of the event ID.
 * Currently a read-only entry.
 *
 * 
 */
public class IcalUIDProperty extends ValueConstruct {

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(IcalUIDProperty.class,
        Namespaces.gCalNs, "uid");
  }

  public IcalUIDProperty() {
    this(null);
  }

  public IcalUIDProperty(String value) {
    super(Namespaces.gCalNs, "uid", "value", value);
  }
}

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
 * GData schema extension describing whether this is a sync scenario where the
 * Ical UID and Sequence number are honored during inserts and updates.
 *
 * 
 */
public class SyncEventProperty extends ValueConstruct {

  public static final SyncEventProperty TRUE =
      new SyncEventProperty(String.valueOf(true));

  public static final SyncEventProperty FALSE =
      new SyncEventProperty(String.valueOf(false));

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(SyncEventProperty.class,
        Namespaces.gCalNs, "syncEvent");
  }

  public SyncEventProperty() {
    this(null);
  }

  public SyncEventProperty(String value) {
    super(Namespaces.gCalNs, "syncEvent", "value", value);
  }
}

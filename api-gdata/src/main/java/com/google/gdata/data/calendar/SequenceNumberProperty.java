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
 * GData schema extension describing sequence number of an event.
 * The sequence number is a non-negative integer and is described in
 * section 4.8.7.4 of RFC 2445.
 * Currently this is only a read-only entry.
 *
 * 
 */
public class SequenceNumberProperty extends ValueConstruct {

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(SequenceNumberProperty.class,
        Namespaces.gCalNs, "sequence");
  }

  public SequenceNumberProperty() {
    this(null);
  }

  public SequenceNumberProperty(String value) {
    super(Namespaces.gCalNs, "sequence", "value", value);
  }
}

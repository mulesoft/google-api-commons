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

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;

/**
 * For attendee feeds
 *
 * 
 */
public class AttendeeFeed extends BaseFeed<AttendeeFeed, AttendeeEntry> {

  public AttendeeFeed() { super(AttendeeEntry.class); }


  @Override
  public void declareExtensions(ExtensionProfile extProfile) {

    // Add any feed-level extension declarations here.

    super.declareExtensions(extProfile);
  }

  // Any feed-level extension accessor APIs would go here
}

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
 * GData schema extension describing how much a given user may do with a 
 * given event or calendar.
 * 
 * 
 */
public class AccessLevelProperty extends ValueConstruct {
  /**
   * The event is not visible.
   */
  public static final AccessLevelProperty NONE =
      new AccessLevelProperty("none");

  /**
   * The event details are readable.
   */
  public static final AccessLevelProperty READ =
      new AccessLevelProperty("read");

  /**
   * The event shows up as busy time only.
   */
  public static final AccessLevelProperty FREEBUSY =
      new AccessLevelProperty("freebusy");

  /**
   * Only applies to events. The participant can read and reply to
   * the event invitation.
   */
  public static final AccessLevelProperty RESPOND =
      new AccessLevelProperty("respond");

  /**
   * Only applies to events. OVERRIDE access indicates that an event
   * may be modified by way of a set of local overrides that will
   * not be propagated back to the organizer.
   */
  public static final AccessLevelProperty OVERRIDE =
      new AccessLevelProperty("override");

  /**
   * On a calendar, allows full owner access except an editor may not
   * change access control settings on the calendar.  On an event, the
   * user may edit the event.
   */
  public static final AccessLevelProperty EDITOR =
      new AccessLevelProperty("editor");

  /**
   * The user is the event organizer or the owner of the calendar.
   */
  public static final AccessLevelProperty OWNER =
      new AccessLevelProperty("owner");

  /**
   * The calendar server itself. Cannot be used by any user.
   */
  public static final AccessLevelProperty ROOT =
      new AccessLevelProperty("root");

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(AccessLevelProperty.class,
        Namespaces.gCalNs, "accesslevel");
  }

  public AccessLevelProperty() {
    this(null);
  }

  public AccessLevelProperty(String value) {
    super(Namespaces.gCalNs, "accesslevel", "value", value);
  }
}

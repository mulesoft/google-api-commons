/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.extensions;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.util.Namespaces;

import java.util.List;

/**
 * Extension class for manipulating entries of the Event kind.
 */
@Kind.Term(EventEntry.EVENT_KIND)
public class EventEntry extends BaseEventEntry<EventEntry> {

  /**
   * Kind term value for Event category labels.
   */
  public static final String EVENT_KIND = Namespaces.gPrefix + "event";

  /**
   * Kind category used to label feeds or entries that have Event extension
   * data.
   */
  public static final Category EVENT_CATEGORY =
      new Category(Namespaces.gKind, EVENT_KIND);

  /**
   * Constructs a new EventEntry with the appropriate kind category
   * to indicate that it is an event.
   */
  public EventEntry() {
    super();
  }

  /**
   * Constructs a new EventEntry instance by doing a shallow copy of data
   * from an existing BaseEntry instance.
   */
  public EventEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  /**
   * Initializes an ExtensionProfile based upon the extensions expected
   * by an EventEntry.
   */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    extProfile.declare(EventEntry.class, Who.getDefaultDescription());
  }

  /**
   * Returns the list of event participants.
   */
  public List<Who> getParticipants() {
    return getRepeatingExtension(Who.class);
  }

  /**
   * Adds a new event participant.
   */
  public void addParticipant(Who participant) {
    getParticipants().add(participant);
  }
}

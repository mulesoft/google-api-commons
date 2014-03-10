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
import com.google.gdata.data.extensions.Where;
import com.google.gdata.data.extensions.When;

import java.util.List;

/**
 * This represents a single calendar in a list of calendars.  Use
 * CalendarEventEntry to represent a single event from a calendar.
 *
 * 
 */
public class CalendarEntry extends BaseEntry<CalendarEntry> {

  /**
   * Constructs a new CalendarEntry instance
   */
  public CalendarEntry() {
    super();
  }


  /**
   * Constructs a new CalendarEntry instance by doing a shallow copy of data
   * from an existing BaseEntry instance.
   */
  public CalendarEntry(BaseEntry sourceEntry) {
    super(sourceEntry);
  }


  /**
   * Initializes an ExtensionProfile based upon the extensions expected
   * by an EventEntry.
   */
  public void declareExtensions(ExtensionProfile extProfile) {
    extProfile.declare(CalendarEntry.class,
      AccessLevelProperty.getDefaultDescription());
    extProfile.declare(CalendarEntry.class,
        ColorProperty.getDefaultDescription());
    extProfile.declare(CalendarEntry.class,
        HiddenProperty.getDefaultDescription());
    extProfile.declare(CalendarEntry.class,
      OverrideNameProperty.getDefaultDescription());
    extProfile.declare(CalendarEntry.class,
        SelectedProperty.getDefaultDescription());
    extProfile.declare(CalendarEntry.class,
        TimeZoneProperty.getDefaultDescription());
    extProfile.declare(CalendarEntry.class,
        TimesCleanedProperty.getDefaultDescription(false, false));
    extProfile.declare(CalendarEntry.class, When.getDefaultDescription());
    extProfile.declare(CalendarEntry.class, Where.getDefaultDescription());
  }


  /**
   * Returns the list of calendar locations
   */
  public List<Where> getLocations() {
    return getRepeatingExtension(Where.class);
  }


  /**
   * Adds a new calendar location.
   */
  public void addLocation(Where location) {
    getLocations().add(location);
  }

  /**
   * Returns the calendar accesslevel.
   */
  public AccessLevelProperty getAccessLevel() {
    return getExtension(AccessLevelProperty.class);
  }


  /**
   * Sets the calendar accesslevel.
   */
  public void setAccessLevel(AccessLevelProperty accesslevel) {
    setExtension(accesslevel);
  }

  /**
   * Returns the calendar color.
   */
  public ColorProperty getColor() {
    return getExtension(ColorProperty.class);
  }


  /**
   * Sets the calendar color.
   */
  public void setColor(ColorProperty color) {
    setExtension(color);
  }

  /**
   * Returns the calendar hidden property.
   */
  public HiddenProperty getHidden() {
    return getExtension(HiddenProperty.class);
  }


  /**
   * Sets the calendar hidden property.
   */
  public void setHidden(HiddenProperty hidden) {
    setExtension(hidden);
  }

  /**
   * Returns the override name property.
   */
  public OverrideNameProperty getOverrideName() {
    return getExtension(OverrideNameProperty.class);
  }


  /**
   * Sets the override name property.
   */
  public void setOverrideName(OverrideNameProperty name) {
    setExtension(name);
  }

  /**
   * Returns the calendar selected property.
   */
  public SelectedProperty getSelected() {
    return getExtension(SelectedProperty.class);
  }


  /**
   * Sets the calendar selected property.
   */
  public void setSelected(SelectedProperty selected) {
    setExtension(selected);
  }

  /**
   * Returns the calendar timeZone property.
   */
  public TimeZoneProperty getTimeZone() {
    return getExtension(TimeZoneProperty.class);
  }


  /**
   * Sets the calendar timeZone property.
   */
  public void setTimeZone(TimeZoneProperty timeZone) {
    setExtension(timeZone);
  }

  /**
   * Returns the calendar timesCleaned property.
   */
  public TimesCleanedProperty getTimesCleaned() {
    return getExtension(TimesCleanedProperty.class);
  }

  /**
   * Sets the calendar timesCleaned property.
   */
  public void setTimesCleaned(TimesCleanedProperty timesCleaned) {
    setExtension(timesCleaned);
  }
}

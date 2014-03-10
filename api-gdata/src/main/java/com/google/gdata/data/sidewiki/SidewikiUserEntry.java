/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.sidewiki;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.ExtensionProfile;

/**
 * Describes a Sidewiki user entry.
 *
 * 
 */
public class SidewikiUserEntry extends BaseEntry<SidewikiUserEntry> {

  /**
   * Default mutable constructor.
   */
  public SidewikiUserEntry() {
    super();
    setKind("sidewiki#sidewikiUserEntry");
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public SidewikiUserEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(SidewikiUserEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(SidewikiUserEntry.class,
        SidewikiAuthor.getDefaultDescription(false, true));
    new SidewikiAuthor().declareExtensions(extProfile);
  }

  @Override
  public String toString() {
    return "{SidewikiUserEntry " + super.toString() + "}";
  }

}


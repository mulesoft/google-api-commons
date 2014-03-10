/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.health;

import com.google.gdata.data.BaseEntry;

/**
 * Describes a health entry.
 *
 * @param <E> concrete entry type
 * 
 */
public abstract class BaseHealthEntry<E extends BaseHealthEntry> extends
    BaseEntry<E> {

  /**
   * Default mutable constructor.
   */
  public BaseHealthEntry() {
    super();
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public BaseHealthEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public String toString() {
    return "{BaseHealthEntry " + super.toString() + "}";
  }

}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.sites;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.Kind;
import com.google.gdata.util.Namespaces;

/**
 * An activity entry for content recovery.
 *
 * 
 */
@Kind.Term(RecoveryActivityEntry.KIND)
public class RecoveryActivityEntry extends
    BaseActivityEntry<RecoveryActivityEntry> {

  /**
   * Recovery recovery kind kind term value.
   */
  public static final String KIND = SitesNamespace.SITES_PREFIX + "recovery";

  /**
   * Recovery recovery kind kind category.
   */
  public static final Category CATEGORY = new Category(Namespaces.gKind, KIND,
      "recovery");

  /**
   * Default mutable constructor.
   */
  public RecoveryActivityEntry() {
    super();
    getCategories().add(CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public RecoveryActivityEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public String toString() {
    return "{RecoveryActivityEntry " + super.toString() + "}";
  }

}


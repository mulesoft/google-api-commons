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
 * An activity entry for content deletion.
 *
 * 
 */
@Kind.Term(DeletionActivityEntry.KIND)
public class DeletionActivityEntry extends
    BaseActivityEntry<DeletionActivityEntry> {

  /**
   * Deletion deletion kind kind term value.
   */
  public static final String KIND = SitesNamespace.SITES_PREFIX + "deletion";

  /**
   * Deletion deletion kind kind category.
   */
  public static final Category CATEGORY = new Category(Namespaces.gKind, KIND,
      "deletion");

  /**
   * Default mutable constructor.
   */
  public DeletionActivityEntry() {
    super();
    getCategories().add(CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public DeletionActivityEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public String toString() {
    return "{DeletionActivityEntry " + super.toString() + "}";
  }

}


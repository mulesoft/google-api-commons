/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.docs;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.Kind;
import com.google.gdata.util.Namespaces;

/**
 * Describes a Brix document entry.
 *
 * 
 */
@Kind.Term(BrixEntry.KIND)
public class BrixEntry extends BaseDocumentListEntry<BrixEntry> {

  /**
   * Brix kind term value.
   */
  public static final String KIND = DocsNamespace.DOCS_PREFIX + "brix";

  /**
   * Brix kind category.
   */
  public static final Category CATEGORY = new Category(Namespaces.gKind, KIND,
      "brix");

  /**
   * Default mutable constructor.
   */
  public BrixEntry() {
    super();
    getCategories().add(CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public BrixEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public String toString() {
    return "{BrixEntry " + super.toString() + "}";
  }

}


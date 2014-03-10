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

/**
 * An entry representing a single drawing within a
 * {@link DocumentListFeed}.
 *
 * 
 */
@Kind.Term(DrawingEntry.KIND)
public class DrawingEntry extends DocumentListEntry {

  /**
   * Label for category.
   */
  public static final String LABEL = "drawing";

  /**
   * Kind category term used to label the entries which are
   * of document type.
   */
  public static final String KIND = DocumentListFeed.DOCUMENT_NAMESPACE 
      + "#" + DrawingEntry.LABEL;

  /**
   * Category used to label entries that contain spreadsheet data.
   */
  public static final Category CATEGORY =
    new Category(com.google.gdata.util.Namespaces.gKind, KIND, LABEL);

  /**
   * Constructs a new uninitialized entry, to be populated by the
   * GData parsers.
   */
  public DrawingEntry() {
    super();
    getCategories().remove(DocumentListEntry.CATEGORY);
    getCategories().add(CATEGORY);
  }

  /**
   * Constructs a new entry by doing a shallow copy from another BaseEntry
   * instance.
   */
  public DrawingEntry(BaseEntry sourceEntry) {
    super(sourceEntry);
  }
}

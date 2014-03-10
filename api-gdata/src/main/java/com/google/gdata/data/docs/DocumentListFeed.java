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

import com.google.gdata.data.Kind;
import com.google.gdata.data.media.MediaFeed;

/**
 * A feed for managing lists of documents from the Google Docs &amp;
 * Spreadsheets.
 *
 * 
 */
@Kind.Term(DocumentListEntry.KIND)
public class DocumentListFeed
    extends MediaFeed<DocumentListFeed, DocumentListEntry> {

  public static final String DOCUMENT_NAMESPACE
      = "http://schemas.google.com/docs/2007";

  /**
   * Contructs an empty feed.
   */
  public DocumentListFeed() {
    super(DocumentListEntry.class);
    getCategories().add(DocumentListEntry.CATEGORY);
  }
}

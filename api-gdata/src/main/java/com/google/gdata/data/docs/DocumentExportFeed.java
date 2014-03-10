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

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Link;

/**
 * Describes a feed for a list of export requests.
 *
 * 
 */
public class DocumentExportFeed extends BaseFeed<DocumentExportFeed,
    DocumentExportEntry> {

  /**
   * Default mutable constructor.
   */
  public DocumentExportFeed() {
    super(DocumentExportEntry.class);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public DocumentExportFeed(BaseFeed<?, ?> sourceFeed) {
    super(DocumentExportEntry.class, sourceFeed);
  }

  /**
   * Returns the link for the zip file contains all exported documents.
   *
   * @return Link for the zip file contains all exported documents or {@code
   *     null} for none.
   */
  public Link getDocumentExportLink() {
    return getLink(DocumentListLink.Rel.EXPORT,
        DocumentListLink.Type.APPLICATION_ZIP);
  }

  @Override
  public String toString() {
    return "{DocumentExportFeed " + super.toString() + "}";
  }

}


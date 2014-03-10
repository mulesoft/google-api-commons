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
import com.google.gdata.data.Link;
import com.google.gdata.util.Namespaces;

/**
 * Describes a web attachment entry.
 *
 * 
 */
@Kind.Term(WebAttachmentEntry.KIND)
public class WebAttachmentEntry extends BaseContentEntry<WebAttachmentEntry> {

  /**
   * Webattachment web attachment kind kind term value.
   */
  public static final String KIND = SitesNamespace.SITES_PREFIX +
      "webattachment";

  /**
   * Webattachment web attachment kind kind category.
   */
  public static final Category CATEGORY = new Category(Namespaces.gKind, KIND,
      "webattachment");

  /**
   * Default mutable constructor.
   */
  public WebAttachmentEntry() {
    super();
    getCategories().add(CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public WebAttachmentEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  /**
   * Returns the parent sites link.
   *
   * @return Parent sites link or {@code null} for none.
   */
  public Link getParentLink() {
    return getLink(SitesLink.Rel.PARENT, Link.Type.ATOM);
  }

  @Override
  public String toString() {
    return "{WebAttachmentEntry " + super.toString() + "}";
  }

}


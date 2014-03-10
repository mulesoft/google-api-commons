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
 * Describes an announcement entry.
 *
 * 
 */
@Kind.Term(AnnouncementEntry.KIND)
public class AnnouncementEntry extends BasePageEntry<AnnouncementEntry> {

  /**
   * Announcement announcement kind kind term value.
   */
  public static final String KIND = SitesNamespace.SITES_PREFIX +
      "announcement";

  /**
   * Announcement announcement kind kind category.
   */
  public static final Category CATEGORY = new Category(Namespaces.gKind, KIND,
      "announcement");

  /**
   * Default mutable constructor.
   */
  public AnnouncementEntry() {
    super();
    getCategories().add(CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public AnnouncementEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  /**
   * Returns the attachments sites link.
   *
   * @return Attachments sites link or {@code null} for none.
   */
  public Link getAtomAttachmentsLink() {
    return getLink(SitesLink.Rel.ATTACHMENTS, Link.Type.ATOM);
  }

  /**
   * Returns the replies sites link.
   *
   * @return Replies sites link or {@code null} for none.
   */
  public Link getAtomRepliesLink() {
    return getLink(SitesLink.Rel.REPLIES, Link.Type.ATOM);
  }

  /**
   * Returns the attachments sites link.
   *
   * @return Attachments sites link or {@code null} for none.
   */
  public Link getHtmlAttachmentsLink() {
    return getLink(SitesLink.Rel.ATTACHMENTS, Link.Type.HTML);
  }

  /**
   * Returns the replies sites link.
   *
   * @return Replies sites link or {@code null} for none.
   */
  public Link getHtmlRepliesLink() {
    return getLink(SitesLink.Rel.REPLIES, Link.Type.HTML);
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
    return "{AnnouncementEntry " + super.toString() + "}";
  }

}


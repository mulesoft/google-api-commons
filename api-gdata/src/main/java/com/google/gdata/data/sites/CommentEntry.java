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
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.data.Link;
import com.google.gdata.data.threading.InReplyTo;
import com.google.gdata.util.Namespaces;

/**
 * Describes a comment entry.
 *
 * 
 */
@Kind.Term(CommentEntry.KIND)
public class CommentEntry extends BaseContentEntry<CommentEntry> {

  /**
   * Comment comment kind kind term value.
   */
  public static final String KIND = SitesNamespace.SITES_PREFIX + "comment";

  /**
   * Comment comment kind kind category.
   */
  public static final Category CATEGORY = new Category(Namespaces.gKind, KIND,
      "comment");

  /**
   * Default mutable constructor.
   */
  public CommentEntry() {
    super();
    getCategories().add(CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public CommentEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(CommentEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(CommentEntry.class, InReplyTo.getDefaultDescription(true,
        false));
  }

  /**
   * Returns the in reply to.
   *
   * @return in reply to
   */
  public InReplyTo getInReplyTo() {
    return getExtension(InReplyTo.class);
  }

  /**
   * Sets the in reply to.
   *
   * @param inReplyTo in reply to or <code>null</code> to reset
   */
  public void setInReplyTo(InReplyTo inReplyTo) {
    if (inReplyTo == null) {
      removeExtension(InReplyTo.class);
    } else {
      setExtension(inReplyTo);
    }
  }

  /**
   * Returns whether it has the in reply to.
   *
   * @return whether it has the in reply to
   */
  public boolean hasInReplyTo() {
    return hasExtension(InReplyTo.class);
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
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{CommentEntry " + super.toString() + "}";
  }

}


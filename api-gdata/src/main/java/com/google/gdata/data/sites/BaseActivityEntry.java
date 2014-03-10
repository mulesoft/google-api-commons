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
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Link;
import com.google.gdata.data.dublincore.Publisher;

/**
 * An entry representing a user action in a site.
 *
 * @param <E> concrete entry type
 * 
 */
public abstract class BaseActivityEntry<E extends BaseActivityEntry<E>> extends
    BaseEntry<E> {

  /**
   * Default mutable constructor.
   */
  public BaseActivityEntry() {
    super();
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public BaseActivityEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(BaseActivityEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(BaseActivityEntry.class,
        SitesLink.getDefaultDescription(false, true));
    extProfile.declare(BaseActivityEntry.class, Publisher.class);
  }

  /**
   * Returns the The authenticated user that performe the activity if different
   * than the author.
   *
   * @return The authenticated user that performe the activity if different than
   *     the author
   */
  public Publisher getPublisher() {
    return getExtension(Publisher.class);
  }

  /**
   * Sets the The authenticated user that performe the activity if different
   * than the author.
   *
   * @param publisher The authenticated user that performe the activity if
   *     different than the author or <code>null</code> to reset
   */
  public void setPublisher(Publisher publisher) {
    if (publisher == null) {
      removeExtension(Publisher.class);
    } else {
      setExtension(publisher);
    }
  }

  /**
   * Returns whether it has the The authenticated user that performe the
   * activity if different than the author.
   *
   * @return whether it has the The authenticated user that performe the
   *     activity if different than the author
   */
  public boolean hasPublisher() {
    return hasExtension(Publisher.class);
  }

  /**
   * Returns the current sites link.
   *
   * @return Current sites link or {@code null} for none.
   */
  public Link getCurrentLink() {
    return getLink(SitesLink.Rel.CURRENT, Link.Type.ATOM);
  }

  /**
   * Returns the revision sites link.
   *
   * @return Revision sites link or {@code null} for none.
   */
  public Link getRevisionLink() {
    return getLink(SitesLink.Rel.REVISION, Link.Type.ATOM);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{BaseActivityEntry " + super.toString() + "}";
  }

}


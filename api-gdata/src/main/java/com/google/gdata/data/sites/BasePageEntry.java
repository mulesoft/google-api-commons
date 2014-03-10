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

/**
 * An entry representing a page in the site. These entries have namesand
 * correspond to non-anonymous nodes in jotspot.
 *
 * @param <E> concrete entry type
 * 
 */
public abstract class BasePageEntry<E extends BasePageEntry<E>> extends
    BaseContentEntry<E> {

  /**
   * Default mutable constructor.
   */
  public BasePageEntry() {
    super();
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public BasePageEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(BasePageEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(BasePageEntry.class, PageName.class);
  }

  /**
   * Returns the page name.
   *
   * @return page name
   */
  public PageName getPageName() {
    return getExtension(PageName.class);
  }

  /**
   * Sets the page name.
   *
   * @param pageName page name or <code>null</code> to reset
   */
  public void setPageName(PageName pageName) {
    if (pageName == null) {
      removeExtension(PageName.class);
    } else {
      setExtension(pageName);
    }
  }

  /**
   * Returns whether it has the page name.
   *
   * @return whether it has the page name
   */
  public boolean hasPageName() {
    return hasExtension(PageName.class);
  }

  /**
   * Returns the template sites link.
   *
   * @return Template sites link or {@code null} for none.
   */
  public Link getTemplateLink() {
    return getLink(SitesLink.Rel.TEMPLATE, Link.Type.ATOM);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{BasePageEntry " + super.toString() + "}";
  }

}


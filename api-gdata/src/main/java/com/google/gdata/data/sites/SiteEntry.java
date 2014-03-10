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

import java.util.List;

/**
 * An entry representing a site.
 *
 * 
 */
public class SiteEntry extends BaseEntry<SiteEntry> {

  /**
   * Default mutable constructor.
   */
  public SiteEntry() {
    super();
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public SiteEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(SiteEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(SiteEntry.class, SitesLink.getDefaultDescription(true,
        true));
    extProfile.declare(SiteEntry.class, SiteName.class);
    extProfile.declare(SiteEntry.class, Theme.class);
  }

  /**
   * Returns the site name.
   *
   * @return site name
   */
  public SiteName getSiteName() {
    return getExtension(SiteName.class);
  }

  /**
   * Sets the site name.
   *
   * @param siteName site name or <code>null</code> to reset
   */
  public void setSiteName(SiteName siteName) {
    if (siteName == null) {
      removeExtension(SiteName.class);
    } else {
      setExtension(siteName);
    }
  }

  /**
   * Returns whether it has the site name.
   *
   * @return whether it has the site name
   */
  public boolean hasSiteName() {
    return hasExtension(SiteName.class);
  }

  /**
   * Returns the theme.
   *
   * @return theme
   */
  public Theme getTheme() {
    return getExtension(Theme.class);
  }

  /**
   * Sets the theme.
   *
   * @param theme theme or <code>null</code> to reset
   */
  public void setTheme(Theme theme) {
    if (theme == null) {
      removeExtension(Theme.class);
    } else {
      setExtension(theme);
    }
  }

  /**
   * Returns whether it has the theme.
   *
   * @return whether it has the theme
   */
  public boolean hasTheme() {
    return hasExtension(Theme.class);
  }

  /**
   * Returns the link that provides the URI that can be used to post new entries
   * to the feed.
   *
   * @return Link that provides the URI that can be used to post new entries to
   *     the feed or {@code null} for none.
   */
  public Link getEntryPostLink() {
    return getLink(Link.Rel.ENTRY_POST, Link.Type.ATOM);
  }

  /**
   * Returns the source sites link.
   *
   * @return Source sites link or {@code null} for none.
   */
  public Link getSourceLink() {
    return getLink(SitesLink.Rel.SOURCE, Link.Type.ATOM);
  }

  /**
   * Returns the webAddressMapping sites link.
   *
   * @return WebAddressMapping sites link.
   */
  public List<Link> getWebAddressMappingLinks() {
    return getLinks(SitesLink.Rel.WEBADDRESSMAPPING, Link.Type.HTML);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{SiteEntry " + super.toString() + "}";
  }

}


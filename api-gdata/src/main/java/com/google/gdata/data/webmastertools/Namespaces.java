/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.webmastertools;

import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.data.Category;

/**
 * Webmaster Tools XML namespace definitions. Defines constants that are used by
 * Webmaster Tools GData classes that do actual XML formatting.
 *
 * 
 */
public final class Namespaces {

  /** Namespace URI for Webmaster Tools GData extensions */
  public static final String WT
      = "http://schemas.google.com/webmasters/tools/2007";

  /** Namespace prefix for Webmaster Tools GData extensions */
  public static final String WT_ALIAS = "wt";

  /** Prefix for Webmaster Tools GData extensions */
  public static final String WT_PREFIX = WT + "#";

  /**
   * Webmaster tools GData namespace.
   */
  public static final XmlNamespace WT_NAMESPACE =
      new XmlNamespace(
          WT_ALIAS,
          WT);

  /**
   * Same as above, for compatibility with automatically generated feeds.
   */
  public static final XmlNamespace WT_NS = WT_NAMESPACE;

  /**
   * Category term linked to {@link SitesEntry}.
   */
  public static final String KIND_SITE_INFO
      = WT + "#site-info";

  /**
   * Category term linked to {@link SitesFeed}.
   */
  public static final String KIND_SITES_FEED
      = WT + "#sites-feed";

  /**
   * Category term linked to {@link SitemapsFeed}.
   */
  public static final String KIND_SITEMAPS_FEED
      = WT + "#sitemaps-feed";

  /**
   * Category term linked to {@link SitemapsEntry}. Represents regular sitemap.
   */
  public static final String KIND_SITEMAP_REGULAR
      = WT + "#sitemap-regular";

  /**
   * Category term linked to {@link SitemapsEntry}. Represents mobile sitemap.
   */
  public static final String KIND_SITEMAP_MOBILE
      = WT + "#sitemap-mobile";

  /**
   * Category term linked to {@link SitemapsEntry}. Represents news sitemap.
   */
  public static final String KIND_SITEMAP_NEWS
      = WT + "#sitemap-news";

  /**
   * Category term linked to {@link MessageEntry}.
   */
  public static final String KIND_MESSAGE
      = WT + "#message";

  /**
   * Category term linked to {@link MessagesFeed}.
   */
  public static final String KIND_MESSAGES_FEED
      = WT + "#messages-feed";

  /**
   * Helper method to create {@link Category} objects.
   *
   * @param kindTerm category term to use.
   * @return newly created {@link Category} object.
   */
  public static Category createCategory(String kindTerm) {
    return new Category(
        com.google.gdata.util.Namespaces.gKind,
        kindTerm);
  }
}

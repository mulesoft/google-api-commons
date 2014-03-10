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

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Category;

/**
 * The SitesFeed class customizes the generic BaseFeed class to define
 * a feed of web sites that Webmaster Tools user has.
 *
 * 
 */
public class SitesFeed extends BaseFeed<SitesFeed, SitesEntry> {

  /**
   * Constructs a new {@code SitesFeed} instance that is parameterized to
   * contain {@code SitesEntry} instances.
   */
  public SitesFeed() {
    super(SitesEntry.class);
    this.getCategories().add(CATEGORY);
  }

  /**
   * Kind category used to label feed.
   */
  private static final Category CATEGORY
      = Namespaces.createCategory(Namespaces.KIND_SITES_FEED);

  /**
   * Declares feed extensions. We only add Webmaster Tools namespace to the
   * feed, all the other extensions are defined on the feed entry level, see
   * {@link SitesEntry}. 
   */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    // Add any feed-level extension declarations here.
    super.declareExtensions(extProfile);
    extProfile.declareAdditionalNamespace(Namespaces.WT_NAMESPACE);
  }
}

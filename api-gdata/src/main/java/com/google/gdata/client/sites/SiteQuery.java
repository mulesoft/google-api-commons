/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.sites;

import com.google.gdata.client.Query;

import java.net.URL;

/**
 * Describes a query for the feed containing descriptions of a user's sites.
 *
 * 
 */
public class SiteQuery extends Query {

  /** Include all sites that can be viewed. */
  private String includeAllSites;

  /** Handle web address mappings. */
  private Boolean withMappings;

  /**
   * Constructs a new query object that targets a feed.  The initial state of
   * the query contains no parameters, meaning all entries in the feed would be
   * returned if the query was executed immediately after construction.
   *
   * @param feedUrl the URL of the feed against which queries will be executed.
   */
  public SiteQuery(URL feedUrl) {
    super(feedUrl);
  }

  /**
   * Returns the include all sites that can be viewed.
   *
   * @return include all sites that can be viewed or <code>null</code> to
   *     indicate that the parameter is not set.
   */
  public String getIncludeAllSites() {
    return includeAllSites;
  }

  /**
   * Sets the include all sites that can be viewed.
   *
   * @param includeAllSites include all sites that can be viewed or
   *     <code>null</code> to remove this parameter if set.
   */
  public void setIncludeAllSites(String includeAllSites) {
    // check if setting to existing value
    if (this.includeAllSites == null ? includeAllSites != null :
        !this.includeAllSites.equals(includeAllSites)) {
      // set to new value for customer parameter
      this.includeAllSites = includeAllSites;
      setStringCustomParameter("include-all-sites", includeAllSites);
    }
  }

  /**
   * Returns the handle web address mappings.
   *
   * @return handle web address mappings or <code>null</code> to indicate that
   *     the parameter is not set.
   */
  public Boolean getWithMappings() {
    return withMappings;
  }

  /**
   * Sets the handle web address mappings.
   *
   * @param withMappings handle web address mappings or <code>null</code> to
   *     remove this parameter if set.
   */
  public void setWithMappings(Boolean withMappings) {
    // check if setting to existing value
    if (this.withMappings == null ? withMappings != null :
        !this.withMappings.equals(withMappings)) {
      // set to new value for customer parameter
      this.withMappings = withMappings;
      setStringCustomParameter("with-mappings",
          withMappings == null ? null : withMappings.toString());
    }
  }

}


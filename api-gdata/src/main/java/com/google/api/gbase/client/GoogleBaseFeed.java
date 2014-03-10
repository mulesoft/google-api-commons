/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.api.gbase.client;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;

/**
 * An ATOM feed containing entries of type {@link GoogleBaseEntry}.
 *
 * Feeds are usually created by {@link GoogleBaseService#getFeed(java.net.URL)} 
 * or {@link GoogleBaseService#query(com.google.gdata.client.Query)}, but they
 * can be created and initialized independently as well. 
 * 
 */
public class GoogleBaseFeed extends BaseFeed<GoogleBaseFeed, GoogleBaseEntry> {

  private final GoogleBaseAttributesExtension googleBaseAttributesExtension;

  /**
   * Creates a new, empty feed.
   */
  public GoogleBaseFeed()
  {
    super(GoogleBaseEntry.class);
    googleBaseAttributesExtension = new GoogleBaseAttributesExtension();
    addExtension(googleBaseAttributesExtension);
  }

  /**
   * Accesses tags in the g: namespace.
   *
   * @return extension corresponding to tags in the g: namespace, never
   *   null but might be empty.
   */
  public GoogleBaseAttributesExtension getGoogleBaseAttributes() {
    return googleBaseAttributesExtension;
  }

  /**
   * Adds an entry. This is a convenience method equivalent to:
   * <code>getEntries().add()</code>.
   * 
   * @param entry
   */
  public void addEntry(GoogleBaseEntry entry) {
    getEntries().add(entry);
  }

  /** 
   * Declares the g: extension. 
   */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    // Declare arbitrary XML support for the feed instances, so any
    // extensions not explicitly declared in the profile will be captured.
    extProfile.declareArbitraryXmlExtension(GoogleBaseFeed.class);
    extProfile.declareFeedExtension(GoogleBaseAttributesExtension.DESCRIPTION);
    super.declareExtensions(extProfile);
  }
}

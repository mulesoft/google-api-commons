/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data;



/**
 * The Feed class customizes the BaseFeed class to represent the most
 * generic possible feed type.  One usage for this class is to enable the
 * parsing of feeds where the extension model is unknown at the start of
 * the parsing process.  Using in combination with {@link ExtensionProfile}
 * auto-extension, the feed can be parsed generically, and then the
 * {@link #getAdaptedFeed()} can be used to retrieve a more-specfic feed
 * type based upon the {@link Category} kind elements founds within the
 * parsed feed content.
 *
 * @see ExtensionProfile#setAutoExtending(boolean)
 *
 * 
 */
public class Feed extends BaseFeed<Feed, Entry> {

  /**
   * Constructs a new Feed instance that is parameterized to contain
   * Entry instances.
   */
  public Feed() { super(Entry.class); }


  @Override
  public void declareExtensions(ExtensionProfile extProfile) {

    // Declare arbitrary XML support for the feed instances, so any
    // extensions not explicitly declared in the profile will be captured.
    extProfile.declareArbitraryXmlExtension(BaseFeed.class);

    super.declareExtensions(extProfile);
  }
}

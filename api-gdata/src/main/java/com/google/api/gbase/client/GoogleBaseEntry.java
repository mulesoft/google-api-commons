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

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.extensions.FeedLink;

import java.util.List;

/**
 * An object corresponding to one entry in a Google Base Atom XML file.
 * This kind of entries supports tags in the g: namespace.
 *
 * GoogleBaseEntries are usually returned by
 * {@link com.google.api.gbase.client.GoogleBaseFeed#getEntries()},
 * {@link GoogleBaseService#getEntry(java.net.URL)}, but they can also
 * be created independently.
 *
 * Depending on the feed or URL you got the Entry from, it can contain:
 * <ul>
 *   <li>g: namespace tags ({@link #getGoogleBaseAttributes()}, if it
 *       is an item feed or a URL specifying an item.</li>
 *   <li>gm: namespace tags ({@link #getGoogleBaseMetadata()}, if it
 *       is a histogram or an item type.</li>
 *   <li>locale feeds will contain no g: or gm: namespaces whatsoever. 
 *       You'll find the locale name in the title of the entry.</li> 
 * </ul>
 * Items usually contain only g: tags (attributes) or only gm: tags
 * (metadata) depending on their types, never both.
 */
public class GoogleBaseEntry extends BaseEntry<GoogleBaseEntry> {

  private final MetadataEntryExtension metadata =
      new MetadataEntryExtension(this);
  private final GoogleBaseAttributesExtension googleBaseAttributesExtension;

  /**
   * Creates a new entry.
   */
  public GoogleBaseEntry() {
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
   * Accesses tags in the gm: namespace (attribute histogram and
   * item type descriptions).
   * 
   * The gm: tags are read-only. 
   * 
   * @return extension corresponding to tags in the gm: namespace, never
   *   null but might be empty 
   */
  public MetadataEntryExtension getGoogleBaseMetadata() {
    return metadata;
  }

  /**
   * Returns the {@link FeedLink} object pointing to the media feed,
   * or null if the media feed link is not provided (e.g. the entry
   * is obtained from the {@code /snippets} feed).
   * 
   * @return the feed link pointing to the media feed, or null if
   *   link is not provided
   */
  @SuppressWarnings("unchecked")
  public FeedLink<GoogleBaseMediaFeed> getMediaFeedLink() {
    List<FeedLink> extensions = getRepeatingExtension(FeedLink.class);
    for (FeedLink extension : extensions) {
      if ("media".equals(extension.getRel())) {
        return extension;
      } 
    }
    return null;
  }
  
  /**
   * Declares extensions for the g: and gm: namespaces to an extension profile.
   * 
   * @param extProfile extension profile where the extensions will be declared
   */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    // Declare arbitrary XML support for the feed instances, so any
    // extensions not explicitly declared in the profile will be captured.
    extProfile.declareArbitraryXmlExtension(GoogleBaseEntry.class);

    GoogleBaseNamespaces.declareAllExtensions(extProfile);
  }
}

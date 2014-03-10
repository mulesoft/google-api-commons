/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.media.mediarss;

import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.ExtensionDescription;

/**
 * GData definitions for the
 * <a href="http://search.yahoo.com/mrss">Yahoo media: namespace</a>.
 *
 * 
 */
public class MediaRssNamespace {
  /** Namespace URI */
  public static final String URI = "http://search.yahoo.com/mrss/";

  /** Standard namespace prefix. */
  public static final String PREFIX = "media";

  /** Namespace object. */
  public static final XmlNamespace NS = new XmlNamespace(PREFIX, URI);

  /**
   * Description of extensions that can be used inside feed,
   * extension and media:group tags.
   */
  private static final ExtensionDescription[] STANDARD_EXTENSIONS = {
      ExtensionDescription.getDefaultDescription(MediaRating.class),
      ExtensionDescription.getDefaultDescription(MediaTitle.class),
      ExtensionDescription.getDefaultDescription(MediaDescription.class),
      MediaKeywords.getDefaultDescription(),
      MediaThumbnail.getDefaultDescription(),
      ExtensionDescription.getDefaultDescription(MediaCategory.class),
      ExtensionDescription.getDefaultDescription(MediaHash.class),
      MediaPlayer.getDefaultDescription(),
      ExtensionDescription.getDefaultDescription(MediaCredit.class),
      ExtensionDescription.getDefaultDescription(MediaCopyright.class),
          ExtensionDescription.getDefaultDescription(MediaText.class),
      ExtensionDescription.getDefaultDescription(MediaRestriction.class),
  };

  /**
   * Extends given profile with Yahoo media RSS extensions.
   *
   * @param profile the profile to be extended
   */
  public static void declareAll(ExtensionProfile profile) {
    profile.declareAdditionalNamespace(NS);

    // Register some extensions that require special treatment
    profile.declare(BaseEntry.class, MediaGroup.getDefaultDescription());
    profile.declare(BaseEntry.class, MediaContent.getDefaultDescription(false));
    profile.declare(MediaGroup.class, MediaContent.getDefaultDescription(true));

    // Register all standard extension everywhere, including in the aggregators
    // declared above (MediaGroup and MediaContent)
    for (ExtensionDescription desc : STANDARD_EXTENSIONS) {
      profile.declare(BaseEntry.class, desc);
      profile.declare(BaseFeed.class, desc);
      profile.declare(MediaGroup.class, desc);
      profile.declare(MediaContent.class, desc);
    }
  }
}

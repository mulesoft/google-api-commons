/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.photos.pheed;

import com.google.gdata.data.ExtensionDescription;

/**
 * The photo:thumbnail element.
 *
 * @deprecated the pheed namespace is deprecated in favor of media rss.
 *
 * 
 */
@Deprecated
public class PheedThumbnail extends PheedConstruct {
  public PheedThumbnail() {
    this(null);
  }

  public PheedThumbnail(String thumbUrl) {
    super("thumbnail", thumbUrl);
  }

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(PheedThumbnail.class,
        com.google.gdata.data.photos.pheed.Namespaces.PHEED_NAMESPACE,
        "thumbnail");
  }
}

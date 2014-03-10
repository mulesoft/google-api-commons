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
 * Pheed version of the video url, for backwards compatibility. Once all of
 * the clients support the GphotoVideoUrl we can remove this.
 *
 * @deprecated the pheed namespace is deprecated in favor of media rss.
 *
 * 
 */
@Deprecated
public class PheedVideoUrl extends PheedConstruct {
  public PheedVideoUrl() {
    this(null);
  }

  public PheedVideoUrl(String videoUrl) {
    super("videosrc", videoUrl);
  }

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(PheedVideoUrl.class,
        com.google.gdata.data.photos.pheed.Namespaces.PHEED_NAMESPACE, "videosrc");
  }
}
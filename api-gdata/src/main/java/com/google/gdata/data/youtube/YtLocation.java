/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.youtube;

import com.google.gdata.data.ExtensionDescription;

/**
 * yt:location tag, found on the user detail page
 *
 * Example:
 *  {@code <yt:location>Mountain View, CA 94043, USA</yt:location>}
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "location")
public class YtLocation extends AbstractFreeTextExtension {

  /** Creates an empty tag. */
  public YtLocation() {
  }

  /**
   * Creates a tag and initializes its content.
   *
   * @param location content
   */
  public YtLocation(String location) {
    super(location);
  }

}
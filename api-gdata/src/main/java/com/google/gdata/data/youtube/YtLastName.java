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
 * yt:lastname tag, found on the user's detail page and on the 
 * contact feed.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "lastName")
public class YtLastName extends AbstractFreeTextExtension {

  /** Creates an empty tag. */
  public YtLastName() {
  }

  /**
   * Creates a tag and initializes its content.
   *
   * @param lastname content
   */
  public YtLastName(String lastname) {
    super(lastname);
  }
}

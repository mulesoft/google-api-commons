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
 * yt:aboutMe tag, found on the user detail page
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "aboutMe")
public class YtAboutMe extends AbstractFreeTextExtension {

  /** Creates an empty tag. */
  public YtAboutMe() {
  }

  /**
   * Creates a tag and initializes its content.
   *
   * @param aboutMe content
   */
  public YtAboutMe(String aboutMe) {
    super(aboutMe);
  }
}

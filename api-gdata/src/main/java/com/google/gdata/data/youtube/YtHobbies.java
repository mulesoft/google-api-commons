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
 * yt:hobbies tag, found on the user detail page
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "hobbies")
public class YtHobbies extends AbstractFreeTextExtension {

  /** Creates an empty tag. */
  public YtHobbies() {
  }

  /**
   * Creates a tag and initializes its content.
   *
   * @param hobbies content
   */
  public YtHobbies(String hobbies) {
    super(hobbies);
  }

}

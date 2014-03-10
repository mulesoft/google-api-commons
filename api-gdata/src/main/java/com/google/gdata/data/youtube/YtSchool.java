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
 * yt:school tag, found on the user detail page
 *
 * Example:
 *  {@code <yt:school>Mountain View, CA 94043, USA</yt:school>}
 *
 * 
*/
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "school")
public class YtSchool extends AbstractFreeTextExtension {

  /** Creates an empty tag. */
  public YtSchool() {
  }

  /**
   * Creates a tag and initializes its content.
   *
   * @param school content
   */
  public YtSchool(String school) {
    super(school);
  }

}

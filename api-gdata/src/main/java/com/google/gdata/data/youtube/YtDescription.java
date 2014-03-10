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
 * yt:description tag, found on the user detail page
 *
 * @deprecated This tag is only accepted in version 1 of the protocol.  The tag
 *             {@code atom:summary} usually replaces {@code yt:description} in
 *             version 2 and later. 
 *
 * 
 */
@Deprecated
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "description")
public class YtDescription extends AbstractFreeTextExtension {

  /** Creates an empty tag. */
  public YtDescription() {
  }

  /**
   * Creates a tag and initializes its content.
   *
   * @param description content
   */
  public YtDescription(String description) {
    super(description);
  }

}

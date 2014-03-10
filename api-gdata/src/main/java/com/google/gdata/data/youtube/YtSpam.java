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

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.ExtensionDescription;

/**
 * Object representation for the yt:spam tag.
 *
 * If this tag is present it indicates that the containing entry contains most
 * likely spam.
 * 
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "spam")
public class YtSpam extends AbstractExtension {

  /** Creates spam hint tag. */
  public YtSpam() {
  }
}

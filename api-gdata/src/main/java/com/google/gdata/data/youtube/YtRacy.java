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
import com.google.gdata.data.media.mediarss.MediaRating;

/**
 * Object representation for the yt:racy tag.
 * 
 * @deprecated in favor of {@link MediaRating} with
 *             {@link YouTubeNamespace#MEDIA_RATING_SCHEME}.
 * 
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "racy")
@Deprecated
public class YtRacy extends AbstractExtension {

}

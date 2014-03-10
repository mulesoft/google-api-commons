/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.api.gbase.client;

import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.media.MediaEntry;
import com.google.gdata.data.media.mediarss.MediaContent;

/**
 * Media entry representing a media attachment of a Google Base item. It is used
 * in conjuction with the {@link GoogleBaseMediaFeed} for managing the media
 * attachments (e.g. images) of an item.
 * <p>
 * An object of this type will include the following information:
 * <ul>
 *   <li> {@code atom:title} contains the caption of the media attachment.
 *   <li> {@code atom:content} points to the cached version of the attachment
 *   <li> {@code media:content} points to the safe cached version of the
 *   attachment and will include several links to generated, cached thumbnails
 *   <li> {@code atom:link} with the 'via' relation points to the URI from
 *   where the attachment was crawled by the cache system. If the attachment was
 *   directly uploaded by a user, this atom link will not be included in the
 *   entry.
 * </ul>
 */
public class GoogleBaseMediaEntry extends MediaEntry<GoogleBaseMediaEntry> {
  
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    extProfile.declare(GoogleBaseMediaEntry.class, MediaContent.class);    
  }
}

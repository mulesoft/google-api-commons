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

import com.google.gdata.data.media.MediaFeed;

/**
 * Media feed used for managing the media attachments for one Google Base Item.
 * Every item accessible via the {@code /items} feed contains a media feed in
 * the form of a {@link com.google.gdata.data.extensions.FeedLink} with relation
 * {@code media}.
 */
public class GoogleBaseMediaFeed extends MediaFeed<GoogleBaseMediaFeed, GoogleBaseMediaEntry> {

  public GoogleBaseMediaFeed() {
    super(GoogleBaseMediaEntry.class);
  }
  
}

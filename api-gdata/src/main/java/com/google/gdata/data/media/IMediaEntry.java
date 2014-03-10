/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.media;

import com.google.gdata.data.IEntry;

/**
 * The IMediaEntry interface defines a common base interface for GData media
 * entries that is shared between the old and new data models.
 */
public interface IMediaEntry extends IEntry {
  
  /**
   * Returns the {@link MediaSource} that contains the media data for the entry.
   */
  public MediaSource getMediaSource();
  
  /**
   * Sets the {@link MediaSource} that contains the media data for the entry.
   */
  public void setMediaSource(MediaSource source);
}

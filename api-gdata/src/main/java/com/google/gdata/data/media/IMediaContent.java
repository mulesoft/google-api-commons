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

import com.google.gdata.data.IOutOfLineContent;

/**
 * The IMediaContent interface defines the common interface for media content.
 * 
 * 
 */
public interface IMediaContent extends IOutOfLineContent {
  
  /** 
   * Returns the media source associated with the content or {@code null}. 
   */
  public MediaSource getMediaSource();

  /**
   * Sets the media source associated with the content (may be {@code null}
   * if no supplied content).
   */
  public void setMediaSource(MediaSource v);
}

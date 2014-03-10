/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.gdata.data;

import com.google.gdata.data.media.IMediaContent;
import com.google.gdata.data.media.MediaSource;
import com.google.gdata.util.ParseException;

import org.xml.sax.Attributes;

import java.io.IOException;


/**
 * The MediaContent class extends {@link OutOfLineContent} to add
 * {@link MediaSource} handling for the content.  This
 * class is used in contexts where a client or provider wants to provide
 * access to the actual media data via a MediaSource (instead of an href).
 *
 * 
 */
public class MediaContent extends OutOfLineContent implements IMediaContent {

  /**
   * MediaSource associated with the external content.
   */
  protected MediaSource mediaSource;

  /** Returns the media source associated with the content or {@code null}. */
  public MediaSource getMediaSource() { return mediaSource; }

  /**
   * Sets the media source associated with the content (may be {@code null}
   * if no supplied content.
   */
  public void setMediaSource(MediaSource v) { mediaSource = v; }

  public static ChildHandlerInfo getChildHandler(ExtensionProfile extProfile,
      Attributes attrs) throws ParseException, IOException {

    String src = attrs.getValue("", "src");
    if (src != null) {

      // Media content
      ChildHandlerInfo childHandlerInfo = new ChildHandlerInfo();

      MediaContent mc = new MediaContent();
      childHandlerInfo.handler = mc.new AtomHandler();
      childHandlerInfo.content = mc;
      return childHandlerInfo;

    } else {

      // Delegate all non-media content handling
      return Content.getChildHandler(extProfile, attrs);
    }
  }
}

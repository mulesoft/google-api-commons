/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.wireformats.output.media;

import com.google.gdata.data.media.MediaSource;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.output.OutputGenerator;
import com.google.gdata.wireformats.output.OutputProperties;

import java.io.IOException;
import java.io.OutputStream;

/**
 * The MediaGenerator class implements the {@link OutputGenerator} interface
 * for generating media data for a service that supports media content.  Support
 * for media multipart documents is provided by the 
 * {@link MediaMultipartGenerator} class.
 *
 * 
 */

public class MediaGenerator implements OutputGenerator<MediaSource> {

  public AltFormat getAltFormat() {
    return AltFormat.MEDIA;
  }

  public Class<MediaSource> getSourceType() {
    return MediaSource.class;
  }

  /**
   * Generates output for requests that target media resources.
   */
  public void generate(OutputStream contentStream,
                       OutputProperties request,
                       MediaSource source)
      throws IOException {

    MediaSource.Output.writeTo(source, contentStream);
  }
}

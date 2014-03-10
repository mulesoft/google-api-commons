/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.wireformats.input.media;

import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.data.ParseSource;
import com.google.gdata.data.media.MediaSource;
import com.google.gdata.data.media.MediaStreamSource;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.input.AbstractParser;
import com.google.gdata.wireformats.input.InputParser;
import com.google.gdata.wireformats.input.InputProperties;

import java.io.InputStream;

/**
 * The MediaParser class provides an {@link InputParser} implementation for
 * consuming media data and exposing it as an {@link MediaSource} result.
 *
 * 
 */
public class MediaParser extends AbstractParser<MediaSource> {

  public MediaParser() {
    super(AltFormat.MEDIA, MediaSource.class);
  }

  public <R extends MediaSource> R parse(ParseSource parseSource,
      InputProperties inProps, Class<R> resultClass) {
    
    // Ensure that the expected result type is MediaSource
    Preconditions.checkArgument(resultClass.isAssignableFrom(MediaSource.class),
        "Result class must be " + MediaSource.class.getName());
    
    InputStream inputStream = parseSource.getInputStream();
    Preconditions.checkNotNull(inputStream,
        "Parse source must be stream-based");   
    
    MediaStreamSource mediaSource = 
        new MediaStreamSource(inputStream, inProps.getContentType().toString());
   
    return resultClass.cast(mediaSource);
  }
}

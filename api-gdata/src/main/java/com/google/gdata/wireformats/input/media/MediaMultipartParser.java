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
import com.google.gdata.data.media.GDataContentHandler;
import com.google.gdata.data.media.MediaMultipart;
import com.google.gdata.util.InvalidEntryException;
import com.google.gdata.util.ServiceException;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.input.AbstractParser;
import com.google.gdata.wireformats.input.InputProperties;

import java.io.InputStream;

import javax.mail.MessagingException;

/**
 * The MediaMultipartParser is an
 * {@link com.google.gdata.wireformats.input.InputParser} implementation that
 * is capable parsing GData media multipart data streams to produce a
 * {@link MediaMultipart} instance.
 * 
 * 
 */
public class MediaMultipartParser extends AbstractParser<MediaMultipart> {
  
  public MediaMultipartParser() {
    super(AltFormat.MEDIA_MULTIPART, MediaMultipart.class);
  }
  
  /**
   * Creates the MediaMultipart instance that does the actual parsing into
   * multipart body parts.
   * 
   * @param parseSource source input stream
   * @param inputProperties input properties
   * @return resulting media multipart
   * @throws MessagingException
   */
  protected MediaMultipart createMultipart(ParseSource parseSource, 
      InputProperties inputProperties) throws MessagingException {
    return new MediaMultipart(inputProperties.getContentType().toString(),
        parseSource.getInputStream());          
  }

  public <R extends MediaMultipart> R parse(ParseSource parseSource,
      InputProperties inputProperties, Class<R> resultClass) 
      throws ServiceException {

    Preconditions.checkArgument(
        MediaMultipart.class.isAssignableFrom(resultClass),
        "Result class must extend " + MediaMultipart.class.getName());
    
    InputStream inputStream = parseSource.getInputStream();
    Preconditions.checkNotNull(inputStream,
        "Parse source must be stream-based");
    
    InputProperties prevProperties = null;
    try {
      prevProperties = 
        GDataContentHandler.setThreadInputProperties(inputProperties);

      MediaMultipart result = createMultipart(parseSource, inputProperties);
      return resultClass.cast(result);

    } catch (MessagingException me) {
      throw new InvalidEntryException(me.getMessage(), me);
    } finally {
      GDataContentHandler.setThreadInputProperties(prevProperties);
    }
  }
}

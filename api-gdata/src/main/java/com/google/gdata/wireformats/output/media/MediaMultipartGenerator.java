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

import com.google.gdata.data.media.GDataContentHandler;
import com.google.gdata.data.media.MediaMultipart;
import com.google.gdata.util.InvalidEntryException;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.output.OutputGenerator;
import com.google.gdata.wireformats.output.OutputProperties;

import java.io.IOException;
import java.io.OutputStream;

import javax.mail.MessagingException;

/**
 * The MediaMultipartGenerator class handles output generation for MIME 
 * multipart related documents containing Atom and media content as separate
 * parts.   Support for media-only output generation is provided by the
 * {@link MediaGenerator} class.
 * 
 * 
 */
public class MediaMultipartGenerator  
    implements OutputGenerator<MediaMultipart> {

  public AltFormat getAltFormat() {
    return AltFormat.MEDIA_MULTIPART;
  }

  public Class<MediaMultipart> getSourceType() {
    return MediaMultipart.class;
  }

  /**
   * Generates output for requests that target media resources.
   */
  public void generate(OutputStream contentStream, OutputProperties request, 
        MediaMultipart source) throws IOException {

    OutputProperties prevProperties = null;
    try {
      prevProperties =
          GDataContentHandler.setThreadOutputProperties(request);
      source.writeTo(contentStream);
    } catch (MessagingException me) {
      
      // Unwrap basic I/O errors 
      Throwable t = me.getCause();
      if (t instanceof IOException) {
        throw (IOException) t;
      }
      
      // Wrap others based upon an invalid input entry
      IOException ioe = new IOException("Invalid multipart content");
      ioe.initCause(new InvalidEntryException("Invalid media entry", me));
      throw ioe;
    } finally {
      GDataContentHandler.setThreadOutputProperties(prevProperties);
    }
  }
}

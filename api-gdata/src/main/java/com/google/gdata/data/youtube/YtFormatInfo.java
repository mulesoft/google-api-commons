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
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.util.ParseException;

/**
 * Object representation for the yt:rating tag.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "formatInfo")
public class YtFormatInfo extends AbstractExtension {
  
  private static final String FORMAT = "format";
  private static final String FRAME_RATE = "frameRate";
  private static final String TIME_OFFSET = "timeOffset";
  private static final String DROP_FRAME = "dropFrame";

  private String format;
  private String frameRate;
  private String timeOffset;
  private boolean dropFrame;

  
  /** Creates an empty tag. */
  public YtFormatInfo() {
    this.dropFrame = false;
  }

  /**
   * Creates a rating tag with the given attributes.
   * 
   * @param format caption file format name
   * @param frameRate frame rate of the video
   * @param timeOffset time offset to be applied to timestamps
   * @param dropFrame does the format use the dropFrame technique
   */
  public YtFormatInfo(String format, String frameRate, String timeOffset, 
      boolean dropFrame) {
    this.format = format;
    this.frameRate = frameRate;
    this.timeOffset = timeOffset;
    this.dropFrame = dropFrame;
 }

  
  /**
   * @return the format
   */
  public String getFormat() {
    return format;
  }
  
  /**
   * @param format the caption file format to set
   */
  public void setFormat(String format) {
    this.format = format;
  }
  
  
  /**
   * @return the frame rate
   */
  public String getFrameRate() {
    return frameRate;
  }
  
  /**
   * @param frameRate the frame rate to set
   */
  public void setFrameRate(String frameRate) {
    this.frameRate = frameRate;
  }
  
   
  /**
   * @return the time offset
   */
  public String getTimeOffset() {
    return timeOffset;
  }
  
  /**
   * @param timeOffset the time offset to set
   */
  public void setTimeOffset(String timeOffset) {
    this.timeOffset = timeOffset;
  }
  
   /**
   * @return whether dropFrame is used
   */
  public boolean getDropFrame() {
    return dropFrame;
  }
  
  /**
   * @param set whether dropFrame is used
   */
  public void setDropFrame(boolean dropFrame) {
    this.dropFrame = dropFrame;
  }


  @Override
  protected void consumeAttributes(AttributeHelper helper) throws ParseException {
    super.consumeAttributes(helper);
    format = helper.consume(FORMAT, false);
    frameRate = helper.consume(FRAME_RATE, false);
    timeOffset = helper.consume(TIME_OFFSET, false);
    dropFrame = helper.consumeBoolean(DROP_FRAME, false);
  }
  
  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);
    if (format != null) {
      generator.put(FORMAT, format);
    }
    
    if (frameRate != null) {
      generator.put(FRAME_RATE, frameRate);
    }
    
    if (timeOffset != null) {
      generator.put(TIME_OFFSET, timeOffset);
    }

    if (dropFrame) {
      generator.put(DROP_FRAME, dropFrame);
    }

  }
}

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
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.util.ParseException;

/**
 * Object representation for the yt:position tag.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "position")
public class YtPosition extends AbstractExtension {

  /** 0-based position */
  private int position;

  /** Creates an empty position tag. */
  public YtPosition() {
  }

  /**
   * Creates a tag and sets the position.
   *
   * @param position position
   */
  public YtPosition(int position) {
    this.position = position;
  }

  /** Sets the position (0-based). */
  public void setPosition(int position) {
    this.position = position;
  }

  /** Gets the position (0-based). */
  public int getPosition() {
    return position;
  }


  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);
    generator.setContent(Integer.toString(position + 1));
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper)
      throws ParseException {
    super.consumeAttributes(helper);
    int value;
    try {
      value = Integer.parseInt(helper.consumeContent(true));
    } catch (NumberFormatException e) {
      throw new ParseException("Position should be an integer");
    }
    if (value <= 0) {
      throw new ParseException("Position should be >= 1");
    }
    this.position = value - 1;
  }
}

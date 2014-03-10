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
 * Object representation for the yt:countHint tag.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "countHint")
public class YtCountHint extends AbstractExtension {

  private int countHint;

  /** Creates an empty countHint tag. */
  public YtCountHint() {
  }

  /**
   * Creates a tag and sets the countHint.
   *
   * @param countHint countHint
   */
  public YtCountHint(int countHint) {
    this.countHint = countHint;
  }

  /** Sets the countHint. */
  public void setValue(int countHint) {
    this.countHint = countHint;
  }

  /** Gets the countHint. */
  public int getValue() {
    return countHint;
  }


  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);
    generator.setContent(Integer.toString(countHint));
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper)
      throws ParseException {
    super.consumeAttributes(helper);
    try {
      countHint = Integer.parseInt(helper.consumeContent(true));
    } catch (NumberFormatException e) {
      throw new ParseException("CountHint should be an integer");
    }
  }
}

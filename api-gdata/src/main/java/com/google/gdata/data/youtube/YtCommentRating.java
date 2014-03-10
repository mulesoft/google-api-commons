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
 * Object representation for the yt:commentRating tag.
 *
 * As YouTube does only sum up the votes (-1, 1). Therefore,
 * gd:rating can not be used (min, max range would be required).
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "commentRating")
public class YtCommentRating extends AbstractExtension {

  private int total;

  /** Creates an empty rating tag. */
  public YtCommentRating() {
  }

  /**
   * Creates a tag and sets the rating.
   *
   * @param rating 
   */
  public YtCommentRating(int rating) {
    this.total = rating;
  }

  /** Sets the sum of all ratings (-1, 1). */
  public void setTotal(int total) {
    this.total = total;
  }

  /** Gets the sum of all ratings (-1, 1). */
  public int getTotal() {
    return total;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);
    generator.put("total", total);
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper)
      throws ParseException {
    total = helper.consumeInteger("total", false, 0);
  }
}

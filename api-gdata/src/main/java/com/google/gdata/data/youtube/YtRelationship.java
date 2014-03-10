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
 * Object representation for the yt:relationship tag
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "relationship")
public class YtRelationship extends AbstractExtension {

  /** Relationship value. */
  public static enum Status {
    SINGLE, TAKEN, OPEN;
  }

  private Status status;

  /** Creates an empty tag. */
  public YtRelationship() {
  }

  /** Creates a tag and initializes its content. */
  public YtRelationship(Status status) {
    this.status = status;
  }

  /**
   * Gets the relationship status.
   *
   * @return status or null
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Sets the relationship status.
   *
   * @param status status or null
   */
  public void setStatus(Status status) {
    this.status = status;
  }


  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);
    if (status != null) {
      generator.setContent(status.toString().toLowerCase());
    }
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper)
      throws ParseException {
    super.consumeAttributes(helper);
    try {
      status = Status.valueOf(helper.consumeContent(true).toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new ParseException("Invalid relationship value");
    }
  }
}

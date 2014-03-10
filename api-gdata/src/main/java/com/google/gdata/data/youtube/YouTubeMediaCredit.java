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

import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.media.mediarss.MediaCredit;
import com.google.gdata.data.media.mediarss.MediaRssNamespace;
import com.google.gdata.util.ParseException;

/**
 * Adds attributes to {@code media:credit}.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = MediaRssNamespace.PREFIX,
    nsUri = MediaRssNamespace.URI,
    localName = "credit",
    isRepeatable = true)
public class YouTubeMediaCredit extends MediaCredit {

  /** Partner type. */
  public enum Type {
    PARTNER;
  }

  private String typeString;

  /**
   * Returns the type as an enum.
   *
   * @return a type or {@code null} if no type was set or if the
   *         type is unknown
   */
  public Type getType() {
    if (typeString == null) {
      return null;
    }
    try {
      return Type.valueOf(typeString.toUpperCase());
    } catch (IllegalArgumentException unknownType) {
      return null;
    }
  }

  /**
   * Sets the type as an enum.
   */
  public void setType(Type type) {
    this.typeString = type == null ? null : type.toString().toLowerCase();
  }

  /**
   * Returns the type as a string.
   */
  public String getTypeString() {
    return typeString;
  }

  /**
   * Sets the type as a string.
   */
  public void setTypeString(String typeString) {
    this.typeString = typeString;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);

    if (typeString != null) {
      generator.put(YouTubeNamespace.PREFIX + ":type", typeString);
    }
  }

  @Override
  protected void consumeAttributes(AttributeHelper attrsHelper)
      throws ParseException {
    super.consumeAttributes(attrsHelper);

    typeString = attrsHelper.consume("type", false);
  }
}

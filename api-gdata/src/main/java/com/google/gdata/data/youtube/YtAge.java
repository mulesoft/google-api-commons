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
 * Object representation for the yt:age tag.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "age")
public class YtAge extends AbstractExtension {

  private int age;

  /** Creates an empty age tag. */
  public YtAge() {
  }

  /**
   * Creates a tag and sets the age.
   *
   * @param age age
   */
  public YtAge(int age) {
    this.age = age;
  }

  /** Sets the age. */
  public void setAge(int age) {
    this.age = age;
  }

  /** Gets the age. */
  public int getAge() {
    return age;
  }


  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);
    if (age > 0) {
      generator.setContent(Integer.toString(age));
    }
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper)
      throws ParseException {
    super.consumeAttributes(helper);
    try {
      age = Integer.parseInt(helper.consumeContent(true));
    } catch (NumberFormatException e) {
      throw new ParseException("Age should be an integer");
    }
  }
}

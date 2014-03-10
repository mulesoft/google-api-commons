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
import com.google.gdata.util.ParseException;

/**
 * An extension with a content and nothing else.
 *
 * 
 */
public abstract class AbstractFreeTextExtension extends AbstractExtension {
  private String content;

  /** Creates an empty tag. */
  protected AbstractFreeTextExtension() {
  }

  /**
   * Creates a tag and initializes its content.
   *
   * @param content
   */
  protected AbstractFreeTextExtension(String content) {
    this.content = content;
  }

  /** Gets the content string. */
  public String getContent() {
    return content;
  }

  /** Sets the content string. */
  public void setContent(String content) {
    this.content = content;
  }


  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);

    if (content != null) {
      generator.setContent(content);
    }
  }


  @Override
  protected void consumeAttributes(AttributeHelper helper)
      throws ParseException {
    super.consumeAttributes(helper);

    // Accept empty text
    content = helper.consumeContent(false);
    if (content == null) {
      content = "";
    }
  }
}

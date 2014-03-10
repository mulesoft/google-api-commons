/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.media.mediarss;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.util.ParseException;

/**
 * An element with text content, accessible using the 'content' property.
 *
 * 
 */
abstract class AbstractElementWithContent extends AbstractExtension {
  private String content;

  AbstractElementWithContent() {
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    generator.setContent(content);
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper)
      throws ParseException {
    content = helper.consumeContent(false);
  }
}

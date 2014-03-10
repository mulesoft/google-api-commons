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

import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.util.ParseException;

/**
 * An empty tag with a url, width and height attribute.
 *
 * 
 */
public abstract class AbstractMediaResource
    extends ExtensionPoint implements Extension {
  private String url;
  private int height;
  private int width;

  /** Prevents this class from being extended outside of this package. */
  AbstractMediaResource() {
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * Subclasses can overwrite this method to add extra attributes.
   * @param generator used to output attributes.
   */
  @Override
  protected void putAttributes(AttributeGenerator generator) {
    generator.put("url", url);
    if (height > 0) {
      generator.put("height", height);
    }
    if (width > 0) {
      generator.put("width", width);
    }
  }

  /**
   * Subclasses can overwrite this method to parse extra
   * attributes.
   *
   * @param attrsHelper
   */
  @Override
  protected void consumeAttributes(AttributeHelper attrsHelper)
      throws ParseException {
    url = attrsHelper.consume("url", false);
    height = attrsHelper.consumeInteger("height", false);
    width = attrsHelper.consumeInteger("width", false);
  }
}

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

import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.util.ParseException;

import java.util.List;

/**
 * Object representation for the yt:aspectRatio tag.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "aspectRatio")
public class YtAspectRatio extends AbstractExtension {

  public enum Value {
    WIDE_SCREEN("widescreen");
    
    private final String xmlName;
    
    private Value(String xmlName) {
      this.xmlName = xmlName;
    }
    
    public String getXmlName() {
      return xmlName;
    }
  }
  
  private Value value;
  
  public YtAspectRatio() {
    value = null;
  }

  /**
   * Creates a tag and sets the aspect ratio.
   *
   * @param value the aspect ratio
   */
  public YtAspectRatio(Value value) {
    this.value = value;
  }

  /** Sets the aspect ratio. */
  public void setValue(Value value) {
    this.value = value;
  }

  /** Gets the aspect ratio. */
  public Value getValue() {
    return value;
  }
  
  @Override
  protected void generateAttributes(List<Attribute> attrs, AttributeGenerator generator) {
    super.generateAttributes(attrs, generator);
    generator.setContent(value.getXmlName());
  }
  
  @Override
  protected void consumeAttributes(AttributeHelper helper) throws ParseException {
    super.consumeAttributes(helper);
    String content = helper.consumeContent(true);
    for (Value value : Value.values()) {
      if (value.xmlName.equals(content)) {
        this.value = value;
        break;
      }
    }
  }
  
  @Override
  protected void validate() throws IllegalStateException {
    super.validate();
    if (value == null) {
      throw new IllegalStateException("The value of yt:aspectRatio may not be null.");
    }
  }
}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data;

import com.google.gdata.util.common.xml.XmlWriter;

import java.io.IOException;

/**
 * Variant of {@link Content} for entries containing text.
 *
 * 
 */
public class TextContent extends Content implements ITextContent {

  
  /** Class constructor. */
  public TextContent() {}

  /** Class constructor specifying the content for this element to contain. */
  public TextContent(TextConstruct content) {
    this.content = content;
  }

  /** @return the type (TEXT) of this content */
  @Override
  public int getType() { return Content.Type.TEXT; }

  /** @return  the human language that this text is written in */
  @Override
  public String getLang() {
    if (content == null) {
      return null;
    }

    return content.getLang();
  }

  /** Content. */
  protected TextConstruct content;
  /** @return the text content */
  public TextConstruct getContent() { return content; }
  /** Specifies the text content. */
  public void setContent(TextConstruct v) { content = v; }

  /**
   * Generates XML in the Atom format.
   *
   * @param   w
   *            output writer
   * @param   extProfile
   *            Extension Profile for nested extensions
   *
   * @throws  IOException
   */
  @Override
  public void generateAtom(XmlWriter w, ExtensionProfile extProfile)
      throws IOException {
    if (content != null) {
      content.generateAtom(w, "content");
    }
  }

  /**
   * Generates XML in the RSS format.
   *
   * @param   w
   *            output writer
   * @param   extProfile
   *            Extension Profile for nested extensions
   *
   * @throws  IOException
   */
  @Override
  public void generateRss(XmlWriter w, ExtensionProfile extProfile)
      throws IOException {
    if (content != null) {
      content.generateRss(w, "description", TextConstruct.RssFormat.FULL_HTML);
    }
  }
}


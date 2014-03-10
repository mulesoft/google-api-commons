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

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.HtmlTextConstruct;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.TextConstruct;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;

import org.xml.sax.Attributes;

/**
 * A media element with a 'type' attribute and text content.
 *
 * 
 */
public abstract class AbstractTextElement extends AbstractExtension {
  private TextConstruct content;

  public boolean isEmpty() {
    return content.isEmpty();
  }

  public TextConstruct getContent() {
    return content;
  }

  public void setHtmlContent(String html) {
    this.content = new HtmlTextConstruct(html);
  }

  public void setPlainTextContent(String text) {
    this.content = new PlainTextConstruct(text);
  }

  public String getPlainTextContent() {
    if (content == null) {
      return null;
    }
    return content.getPlainText();
  }

  @Override
  public void putAttributes(AttributeGenerator generator) {
    if (content != null) {
      String type =
          content.getType() == TextConstruct.Type.TEXT ? "plain" : "html";
      generator.put("type", type);
      if (content != null) {
        if (content instanceof HtmlTextConstruct) {
          HtmlTextConstruct html = (HtmlTextConstruct) content;
          generator.setContent(html.getHtml());
        } else {
          generator.setContent(content.getPlainText());
        }
      }
    }
  }

  /**
   * The default implementation does nothing, subclasses can override to handle
   * attributes.
   * 
   * @throws ParseException from subclasses. 
   */
  @Override
  protected void consumeAttributes(AttributeHelper attrsHelper)
      throws ParseException {}

  @Override
  final public XmlParser.ElementHandler getHandler(ExtensionProfile extProfile,
      String namespace, String localName, Attributes attrs)
      throws ParseException {
    final AttributeHelper attrsHelper = new AttributeHelper(attrs);
    String type = attrsHelper.consume("type", false);
    consumeAttributes(attrsHelper);

    if (type == null || type.equals("plain")) {
      PlainTextConstruct ptc = new PlainTextConstruct();
      content = ptc;
      return ptc.new AtomHandler() {
        @Override
        public void processEndElement() throws ParseException {
          super.processEndElement();
          attrsHelper.assertAllConsumed();
        }
      };
    } else if (type.equals("html")) {
      HtmlTextConstruct htc = new HtmlTextConstruct();
      content = htc;
      return htc.new AtomHandler() {
        @Override
        public void processEndElement() throws ParseException {
          super.processEndElement();
          attrsHelper.assertAllConsumed();
        }
      };
    } else {
      throw new ParseException(CoreErrorDomain.ERR.unsupportedTextType);
    }
  }
}

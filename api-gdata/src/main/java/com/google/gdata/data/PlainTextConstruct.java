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
import com.google.gdata.client.Service;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Plain text variant of {@link TextConstruct}.
 *
 * 
 */
public class PlainTextConstruct extends TextConstruct {

  /** Class constructor. */
  public PlainTextConstruct() {}

  /**
   * Class constructor specifying the plain text content for this
   * text construct to contain.
   */
  public PlainTextConstruct(String text) {
    this.text = text;
  }

  /** 
   * Class constructor specifying the plain text content for this
   * text construct to contain, plus the human language that
   * the text is written in.
   */
  public PlainTextConstruct(String text, String lang) {
    this.text = text;
    this.lang = lang;
  }

  /** @return the type (TEXT) of this text construct */
  @Override
  public int getType() { return Type.TEXT; }
  
  @Override
  /** @return {@code true} if this text construct has no contents */
  public boolean isEmpty() { return getText() == null; }

  /** Plain text contents. */
  protected String text;
  /** @return the plain text contents of this text construct */
  public String getText() { return text; }
  /** Specifies the plain text contents of this text construct. */
  public void setText(String v) { text = v; }

  /**
   * @return a plain-text representation of this text construct or {@code null}
   *         if there is no text content.
   */
  @Override
  public String getPlainText() {
    return text != null ? new String(text) : null;
  }

  /**
   * Generates XML in the Atom format.
   *
   * @param   w
   *            output writer
   *
   * @param   elementName
   *            Atom element name
   *
   * @throws  IOException
   */
  @Override
  public void generateAtom(XmlWriter w,
                           String elementName) throws IOException {

    ArrayList<XmlWriter.Attribute> attrs =
      new ArrayList<XmlWriter.Attribute>();

    // For v2 and later, optimize out the text attribute since it is implied.
    if (Service.getVersion().isCompatible(Service.Versions.V1)) {
      attrs.add(new XmlWriter.Attribute("type", "text"));
    }

    if (lang != null) {
      attrs.add(new XmlWriter.Attribute("xml:lang", lang));
    }

    w.simpleElement(Namespaces.atomNs, elementName, attrs, text);
  }

  /**
   * Generates XML in the RSS format.
   *
   * @param   w
   *            output writer
   *
   * @param   elementName
   *            RSS element name
   *
   * @param   rssFormat
   *            the restrictions on what HTML tags are allowed
   *
   * @throws  IOException
   */
  @Override
  public void generateRss(XmlWriter w,
                          String elementName,
                          RssFormat rssFormat) throws IOException {

    w.simpleElement(Namespaces.rssNs, elementName, null, text);
  }

  /** Parses XML in the Atom format. */
  public class AtomHandler extends XmlParser.ElementHandler {

    /**
     * Processes attributes.
     *
     * @throws ParseException
     */
    @Override
    public void processAttribute(String namespace,
                                 String localName,
                                 String value)
        throws ParseException {

      if (!namespace.equals("") || !localName.equals("type")) {

        // Don't understand other attributes.
        super.processAttribute(namespace, localName, value);
      }
    }

    /**
     * Processes this element; overrides inherited method.
     * 
     * @throws ParseException from subclasses.
     */
    @Override
    public void processEndElement() throws ParseException {

      if (value == null) {
        value = "";
      }

      text = value;
      lang = xmlLang;
    }
  }
}

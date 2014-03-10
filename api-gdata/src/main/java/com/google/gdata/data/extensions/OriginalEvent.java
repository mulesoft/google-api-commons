/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.extensions;

import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;

import org.xml.sax.Attributes;

import java.io.IOException;
import java.util.ArrayList;

/**
 * GData schema extension describing a link to a recurring event.
 *
 * 
 */
public class OriginalEvent extends ExtensionPoint implements Extension {

  /** URL of the original recurring event entry. */
  protected String href;
  public String getHref() { return href; }
  public void setHref(String v) { href = v; }

  /** Event ID of the original recurring event entry. */
  protected String originalId;
  public String getOriginalId() { return originalId; }
  public void setOriginalId(String v) { originalId = v; }

  protected When originalStartTime;
  public When getOriginalStartTime() { return originalStartTime; }
  public void setOriginalStartTime(When v) { originalStartTime = v; }

  /** Returns the suggested extension description. */
  public static ExtensionDescription getDefaultDescription() {
    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(OriginalEvent.class);
    desc.setNamespace(Namespaces.gNs);
    desc.setLocalName("originalEvent");
    desc.setRepeatable(false);
    return desc;
  }

  @Override
  public void generate(XmlWriter w, ExtensionProfile extProfile)
      throws IOException {
    ArrayList<XmlWriter.Attribute> attrs = new ArrayList<XmlWriter.Attribute>();

    if (originalId != null) {
      attrs.add(new XmlWriter.Attribute("id", originalId));
    }

    if (href != null) {
      attrs.add(new XmlWriter.Attribute("href", href));
    }

    generateStartElement(w, Namespaces.gNs, "originalEvent", attrs, null);

    if (originalStartTime != null) {
      originalStartTime.generate(w, extProfile);
    }

    // Invoke ExtensionPoint.
    generateExtensions(w, extProfile);

    w.endElement(Namespaces.gNs, "originalEvent");
  }

  @Override
  public XmlParser.ElementHandler getHandler(ExtensionProfile extProfile,
                                             String namespace,
                                             String localName,
                                             Attributes attrs) {
    return new Handler(extProfile);
  }

  /** <g:originalEvent> parser. */
  private class Handler extends ExtensionPoint.ExtensionHandler {

    public Handler(ExtensionProfile extProfile) {
      super(extProfile, RecurrenceException.class);
    }

    @Override
    public void processAttribute(String namespace,
                                 String localName,
                                 String value) {
      if (namespace.equals("")) {
        if (localName.equals("id")) {
          originalId = value;
        } else if (localName.equals("href")) {
          href = value;
        }
      }
    }

    @Override
    public XmlParser.ElementHandler getChildHandler(String namespace,
                                                    String localName,
                                                    Attributes attrs)
        throws ParseException, IOException {
      if (namespace.equals(Namespaces.g)) {
        if (localName.equals("when")) {
          originalStartTime = new When();
          return originalStartTime.getHandler(extProfile, namespace, localName, attrs);
        }
      }

      return super.getChildHandler(namespace, localName, attrs);
    }

    @Override
    public void processEndElement() throws ParseException {

      if (originalId == null) {
        throw new ParseException(
            CoreErrorDomain.ERR.idRequired);
      }

      if (originalStartTime == null) {
        throw new ParseException(
            CoreErrorDomain.ERR.whenRequired);
      }

      super.processEndElement();
    }
  }
}

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
import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.ExtensionVisitor;
import com.google.gdata.data.ExtensionVisitor.StoppedException;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;

import org.xml.sax.Attributes;

import java.io.IOException;
import java.util.ArrayList;


/**
 * GData schema extension describing individual exceptions to a
 * recurring event. It contains a collection of {@code
 * <gd:entryLink>} elements containing the exceptions.
 *
 * 
 */
public class RecurrenceException extends ExtensionPoint implements Extension {

  protected boolean isSpecialized;
  public boolean getSpecialized() { return isSpecialized; }
  public void setSpecialized(boolean v) { isSpecialized = v; }

  /** Nested event entry. */
  protected EntryLink<?> entryLink;
  public EntryLink<?> getEntryLink() { return entryLink; }
  public void setEntryLink(EntryLink<?> v) { entryLink = v; }

  /** Returns the suggested extension description. */
  public static ExtensionDescription getDefaultDescription() {
    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(RecurrenceException.class);
    desc.setNamespace(Namespaces.gNs);
    desc.setLocalName("recurrenceException");
    desc.setRepeatable(true);
    return desc;
  }

  @Override
  protected void visitChildren(ExtensionVisitor ev) throws StoppedException {
    if (entryLink != null) {
      visitChild(ev, entryLink);
    }
    super.visitChildren(ev);
  }
  
  @Override
  public void generate(XmlWriter w, ExtensionProfile extProfile)
      throws IOException {

    ArrayList<XmlWriter.Attribute> attrs = new ArrayList<XmlWriter.Attribute>();

    attrs.add(new XmlWriter.Attribute("specialized", String.valueOf(isSpecialized)));

    generateStartElement(w, Namespaces.gNs, "recurrenceException", attrs, null);

    if (entryLink != null) {
      entryLink.generate(w, extProfile);
    }

    // Invoke ExtensionPoint.
    generateExtensions(w, extProfile);

    w.endElement(Namespaces.gNs, "recurrenceException");
  }

  @Override
  public XmlParser.ElementHandler getHandler(ExtensionProfile extProfile,
      String namespace, String localName, Attributes attrs) {
    return new Handler(extProfile);
  }

  /** <g:recurrenceException> parser. */
  private class Handler extends ExtensionPoint.ExtensionHandler {

    public Handler(ExtensionProfile extProfile) {
      super(extProfile, RecurrenceException.class);
    }

    @Override
    public void processAttribute(String namespace,
                                 String localName,
                                 String value)
        throws ParseException {
      if (namespace.equals("")) {
        if (localName.equals("specialized")) {
          if ("true".equals(value) || "1".equals(value)) {
            isSpecialized = true;
          } else if ("false".equals(value) || "0".equals(value)) {
            isSpecialized = false;
          } else {
            ParseException pe =
                new ParseException(CoreErrorDomain.ERR.invalidBooleanAttribute);
            pe.setInternalReason(
                "Invalid boolean value for attribute: 'specialized'");
            throw pe;
          }
        }
      }
    }

    @Override
    public XmlParser.ElementHandler getChildHandler(String namespace,
                                                    String localName,
                                                    Attributes attrs)
        throws ParseException, IOException {


      if (namespace.equals(Namespaces.g)) {
        if (localName.equals("entryLink")) {
          entryLink = new EntryLink<BaseEntry<?>>();
          return entryLink.getHandler(extProfile, namespace, localName, attrs);
        }
      }

      return super.getChildHandler(namespace, localName, attrs);
    }
  }
}

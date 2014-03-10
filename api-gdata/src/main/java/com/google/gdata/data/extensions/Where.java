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
 * GData schema extension describing a place (not necessarily a specific
 * geographical location).
 *
 * 
 */
public class Where extends ExtensionPoint implements Extension {

  /** Relation type. Describes the meaning of this location. */
  public static final class Rel {
    /** Place where the enclosing event occurs. */
    public static final String EVENT = null;
    /** Secondary location. */
    public static final String EVENT_ALTERNATE = Namespaces.gPrefix + "event.alternate";
    /** Nearby parking lot. */
    public static final String EVENT_PARKING = Namespaces.gPrefix + "event.parking";
  }

  /** Constructs an empty Where instance. */
  public Where() {}

  /** Constructs a new Where instance using the specified parameters. */
  public Where(String rel, String label, String valueString) {
    this.rel = rel;
    this.label = label;
    this.valueString = valueString;
  }

  /** Describes the meaning of this location. */
  protected String rel;
  public String getRel() { return rel; }
  public void setRel(String v) { rel = v; }

  /**
   * User-readable label that identifies this location in case multiple
   * locations may be present.
   */
  protected String label;
  public String getLabel() { return label; }
  public void setLabel(String v) { label = v; }

  /** Text description of the place. */
  protected String valueString;
  public String getValueString() { return valueString; }
  public void setValueString(String v) { valueString = v; }

  /** Nested person or venue (Contact) entry. */
  protected transient EntryLink<?> entryLink;
  public EntryLink<?> getEntryLink() { return entryLink; }
  public void setEntryLink(EntryLink<?> v) { entryLink = v; }

  /** Returns the suggested extension description. */
  public static ExtensionDescription getDefaultDescription() {
    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(Where.class);
    desc.setNamespace(Namespaces.gNs);
    desc.setLocalName("where");
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

    if (rel != null) {
      attrs.add(new XmlWriter.Attribute("rel", rel));
    }

    if (label != null) {
      attrs.add(new XmlWriter.Attribute("label", label));
    }

    if (valueString != null) {
      attrs.add(new XmlWriter.Attribute("valueString", valueString));
    }

    generateStartElement(w, Namespaces.gNs, "where", attrs, null);

    if (entryLink != null) {
      entryLink.generate(w, extProfile);
    }

    // Invoke ExtensionPoint.
    generateExtensions(w, extProfile);

    w.endElement(Namespaces.gNs, "where");
  }

  @Override
  public XmlParser.ElementHandler getHandler(ExtensionProfile extProfile,
      String namespace, String localName, Attributes attrs) {
    return new Handler(extProfile);
  }

  /** <g:where> parser. */
  private class Handler extends ExtensionPoint.ExtensionHandler {

    public Handler(ExtensionProfile extProfile) {
      super(extProfile, Where.class);
    }

    @Override
    public void processAttribute(String namespace,
                                 String localName,
                                 String value) {
      if (namespace.equals("")) {
        if (localName.equals("rel")) {
          rel = value;
        } else if (localName.equals("label")) {
          label = value;
        } else if (localName.equals("valueString")) {
          valueString = value;
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

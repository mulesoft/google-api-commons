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
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlBlob;
import com.google.gdata.util.XmlParser.ElementHandler;

import org.xml.sax.Attributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * GData schema extension describing an entity's auxiliary property.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.gAlias,
    nsUri = Namespaces.g,
    localName = ExtendedProperty.EXTENDED_PROPERTY)
public class ExtendedProperty extends ExtensionPoint {

  /** XML "extendedProperty" element name */
  static final String EXTENDED_PROPERTY = "extendedProperty";

  /** Limits on where the extended property applies. */
  public static final class Realm {

    /** Shared with all participants. */
    public static final String SHARED = Namespaces.gPrefix + "shared";

    // Applications may define other values for the realm attribute;
    // see Calendar for an example.
  }

  /**
   * Property name expressed as an URI (required). Extended property
   * URIs follow the {scheme}#{local-name} convention.
   * <p>
   * <i>eg:</i> <tt>http://schemas.google.com/g/2005#exif.focalLength</tt>
   */
  protected String name;

  public String getName() {
    return name;
  }

  public void setName(String n) {
    name = n;
  }

  /** Property value (required). */
  protected String val;

  public String getValue() {
    return val;
  }

  public void setValue(String v) {
    val = v;
  }

  public boolean hasValue() {
    return val != null;
  }

  /** Limits on where the extended property applies. */
  protected String realm;

  public String getRealm() {
    return realm;
  }

  public void setRealm(String r) {
    realm = r;
  }

  public boolean hasRealm() {
    return realm != null;
  }

  /** Convert to String for debugging */
  @Override
  public String toString() {
    return "<" + name + "=" + (hasValue() ? val : "")
                      + "|" + (hasRealm() ? realm : "") + ">";
  }

  /** Returns the suggested extension description. */
  public static ExtensionDescription getDefaultDescription() {
    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(ExtendedProperty.class);
    desc.setNamespace(Namespaces.gNs);
    desc.setLocalName(EXTENDED_PROPERTY);
    desc.setRepeatable(true);
    return desc;
  }

  @Override
  public void generate(XmlWriter w, ExtensionProfile extProfile)
      throws IOException {

    List<XmlWriter.Attribute> attrs = new ArrayList<XmlWriter.Attribute>();

    if (name != null) {
      attrs.add(new XmlWriter.Attribute("name", name));
    }

    if (val != null) {
      attrs.add(new XmlWriter.Attribute("value", val));
    }

    if (realm != null) {
      attrs.add(new XmlWriter.Attribute("realm", realm));
    }

    generateStartElement(w, Namespaces.gNs, EXTENDED_PROPERTY, attrs, null);

    // Invoke ExtensionPoint.
    generateExtensions(w, extProfile);

    w.endElement(Namespaces.gNs, EXTENDED_PROPERTY);
  }

  @Override
  public ElementHandler getHandler(ExtensionProfile extProfile,
                                   String namespace,
                                   String localName,
                                   Attributes attrs) {

    return new Handler(extProfile);
  }

  /**
   * Overrides arbitrary XML initialization - ExtendedProperty needs
   * mixed content as well.
   */
  @Override
  protected void initializeArbitraryXml(ExtensionProfile profile,
      Class<? extends ExtensionPoint> extPoint, ElementHandler handler) {

      handler.initializeXmlBlob(xmlBlob,
          /* mixedContent */ true,
          /* fullTextIndex */ false);
  }

  /** <g:extendedProperty> parser */
  private class Handler extends ExtensionPoint.ExtensionHandler {

    public Handler(ExtensionProfile extProfile) {

      super(extProfile, ExtendedProperty.class);
    }

    @Override
    public void processAttribute(String namespace,
                                 String localName,
                                 String value) {
      if (namespace.equals("")) {
        if (localName.equals("name")) {
          name = value;
        } else if (localName.equals("value")) {
          val = value;
        } else if (localName.equals("realm")) {
          realm = value;
        }
      }
    }

    @Override
    public void processEndElement() throws ParseException {

      if (name == null) {
        throw new ParseException(
            CoreErrorDomain.ERR.nameRequired);
      }

      XmlBlob xmlBlob = getXmlBlob();

      if (val != null && xmlBlob.getBlob() != null) {
        throw new ParseException(
            CoreErrorDomain.ERR.valueXmlMutuallyExclusive);
      }

      if (val == null && xmlBlob.getBlob() == null) {
        throw new ParseException(
            CoreErrorDomain.ERR.valueOrXmlRequired);
      }
    }
  }
}

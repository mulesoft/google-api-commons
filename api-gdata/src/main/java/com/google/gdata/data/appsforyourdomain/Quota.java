/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.appsforyourdomain;

import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;

import org.xml.sax.Attributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Google Apps for Your Domain schema extension describing a user's quota.
 *
 * Sample XML element.
 * <code>
 * &lt;apps:quota xmlns:apps="http://schemas.google.com/apps/2006" limit="2048"/&gt;
 * </code>
 *
 * 
 */
public class Quota extends ExtensionPoint implements Extension {

  /** Quota limit in megabytes */
  protected Integer limit;
  public Integer getLimit() { return limit; }
  public void setLimit(Integer v) { limit = v; }

  /** Returns the suggested extension description. */
  public static ExtensionDescription getDefaultDescription() {

    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(Quota.class);
    desc.setNamespace(Namespaces.APPS_NAMESPACE);
    desc.setLocalName("quota");
    desc.setRepeatable(false);
    return desc;
  }

  @Override
  public void generate(XmlWriter w, ExtensionProfile extProfile)
      throws IOException {

    List<XmlWriter.Attribute> attrs = new ArrayList<XmlWriter.Attribute>();
    if (limit != null) {
      attrs.add(new XmlWriter.Attribute("limit", limit.toString()));
    }
    generateStartElement(w, Namespaces.APPS_NAMESPACE, "quota", attrs, null);

    // Invoke ExtensionPoint.
    generateExtensions(w, extProfile);
    w.endElement(Namespaces.APPS_NAMESPACE, "quota");
  }

  @Override
  public XmlParser.ElementHandler getHandler(ExtensionProfile extProfile,
                                             String namespace,
                                             String localName,
                                             Attributes attrs) {
    return new Handler(extProfile);
  }


  /** <apps:quota> parser. */
  private class Handler extends ExtensionPoint.ExtensionHandler {

    public Handler(ExtensionProfile extProfile) {
      super(extProfile, Email.class);
    }

    @Override
    public void processAttribute(String namespace,
                                 String localName,
                                 String value)
        throws ParseException {

      if (namespace.equals("")) {
        if (localName.equals("limit")) {
          try {
            limit = Integer.valueOf(value);
          } catch (NumberFormatException e) {
            throw new ParseException("Invalid apps:quota/@limit.", e);
          }
        }
      }
    }

    @Override
    public void processEndElement() throws ParseException {

      if (limit == null) {
        throw new ParseException("apps:quota/@limit is required.");
      }
      super.processEndElement();
    }
  }
}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.calendar;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.extensions.Who;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;

import org.xml.sax.Attributes;

import java.io.IOException;

/**
 * Calendar extensions to the base-level Who processing for calendar
 * events.
 *
 * 
 */
public class EventWho extends Who {

  // ResourceProperty state is stored as an extension element on the base
  // class, so it will be output by the generateExtensions() call in
  // Who.generate().
 
  public ResourceProperty getResource() {
    return getExtension(ResourceProperty.class);
  }

  public void setResource(ResourceProperty resource) {
    setExtension(resource);
  }

  /** Returns a suggested extension description, which is repeatable. */
  public static ExtensionDescription getDefaultDescription() {
    return getDefaultDescription(true);
  }

  /**
   * Returns a suggested extension description,
   * which may be repeatable or not.
   */
  public static ExtensionDescription getDefaultDescription(boolean repeatable) {
    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(EventWho.class);
    desc.setNamespace(Namespaces.gNs);
    desc.setLocalName("who");
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public XmlParser.ElementHandler getHandler(ExtensionProfile extProfile,
                                             String namespace,
                                             String localName,
                                             Attributes attrs) {

    return new Handler(extProfile);
  }


  /** Extends <g:who> parser. */
  private class Handler extends Who.Handler {


    public Handler(ExtensionProfile extProfile) {

      super(extProfile, EventWho.class);
    }

    @Override
    public XmlParser.ElementHandler getChildHandler(String namespace,
                                                    String localName,
                                                    Attributes attrs)
        throws ParseException, IOException {


      if (namespace.equals(com.google.gdata.data.calendar.Namespaces.gCal)) {
        if (localName.equals("resource")) {
          ResourceProperty resource = new ResourceProperty();
          setResource(resource);
          return resource.getHandler(extProfile, namespace, localName, attrs);
        }
      }

      return super.getChildHandler(namespace, localName, attrs);
    }
  }
}

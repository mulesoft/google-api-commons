/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.api.gbase.client;

import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;

import org.xml.sax.Attributes;

import java.io.IOException;

/**
 * Object representation of the gm:disapproved tag.
 */
public class GmDisapproved implements Extension {

  /**
   * Creates a gm:disapproved tag.
   */
  public GmDisapproved() {

  }

  /** Returns a description for this extension. */
  public static ExtensionDescription getDefaultDescription() {
    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(GmDisapproved.class);
    desc.setNamespace(GoogleBaseNamespaces.GM);
    desc.setLocalName("disapproved");
    desc.setRepeatable(false);
    return desc;
  }

  /** Generates a gm:status tag if the status name is set. */
  public void generate(XmlWriter w, ExtensionProfile extProfile)
      throws IOException {
    w.simpleElement(GoogleBaseNamespaces.GM, "disapproved", null, null);
  }

  /** Reads a gm:disapproved tag. */
  public XmlParser.ElementHandler getHandler(ExtensionProfile extProfile,
      String namespace, String localName, Attributes attrs)
      throws ParseException, IOException {
    return new XmlParser.ElementHandler();
  }
}

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

import java.io.IOException;


/**
 * Google Apps for Your Domain schema extension describing the email service.
 * Note that this does not represent a particular email address, like the GData
 * extension Email.
 *
 * 
 */
public class Email extends ExtensionPoint implements Extension {

  public static final String EXTENSION_LOCAL_NAME = "email";

  /** Returns the suggested extension description. */
  public static ExtensionDescription getDefaultDescription() {
    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(Email.class);
    desc.setNamespace(Namespaces.APPS_NAMESPACE);
    desc.setLocalName(EXTENSION_LOCAL_NAME);
    desc.setRepeatable(false);
    return desc;
  }

  @Override


  public void generate(XmlWriter w, ExtensionProfile extensionProfile)
      throws IOException {
    generateStartElement(
        w, Namespaces.APPS_NAMESPACE, EXTENSION_LOCAL_NAME, null, null);

    // Invoke ExtensionPoint.
    generateExtensions(w, extensionProfile);

    w.endElement(Namespaces.APPS_NAMESPACE, EXTENSION_LOCAL_NAME);
  }

}


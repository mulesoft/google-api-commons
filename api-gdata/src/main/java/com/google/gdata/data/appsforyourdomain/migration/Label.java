/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.gdata.data.appsforyourdomain.migration;

import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.appsforyourdomain.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;

import org.xml.sax.Attributes;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Google Apps name space element: {@code <apps:label>}. Used to model the
 * labels that should be supplied after a migrated message is inserted into
 * GMail
 * 
 * 
 */
public class Label extends ExtensionPoint implements Extension {

  public static final String EXTENSION_LOCAL_NAME = "label";
  public static final String ATTRIBUTE_LABEL_NAME = "labelName";

  protected String labelName;

  /**
   * the extension description is shared by all instances of this class
   */
  private static ExtensionDescription EXTENSION_DESC = 
      new ExtensionDescription();
  static {    
    EXTENSION_DESC.setExtensionClass(Label.class);
    EXTENSION_DESC.setNamespace(Namespaces.APPS_NAMESPACE);
    EXTENSION_DESC.setLocalName(EXTENSION_LOCAL_NAME);
    EXTENSION_DESC.setRepeatable(true);
  }  

  
  public Label() {
    this(null);
  }
  
  public Label(String labelName) {
    this.labelName = labelName;
  }
    
  /**
   * @return the label name
   */
  public String getLabelName() {
    return this.labelName;
  }
   
  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((labelName == null) ? 0 : labelName.hashCode());
    return result;
  }

  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (!(obj instanceof Label)) return false;
    final Label other = (Label) obj;
    if (labelName == null) {
      if (other.labelName != null) return false;
    } else if (!labelName.equals(other.labelName)) return false;
    return true;
  }

  /**
   * @return Description of this extension
   */
  public static ExtensionDescription getDefaultDescription() {
    return EXTENSION_DESC;
  }

  @Override
  public void generate(XmlWriter w, ExtensionProfile extensionProfile)
    throws IOException {

    ArrayList<XmlWriter.Attribute> attributes =
      new ArrayList<XmlWriter.Attribute>();

    if (this.labelName != null) {
      attributes.add(
          new XmlWriter.Attribute(ATTRIBUTE_LABEL_NAME, this.labelName)
      );
    }
    
    generateStartElement(
        w, Namespaces.APPS_NAMESPACE, EXTENSION_LOCAL_NAME, attributes, null
    );

    // Invoke ExtensionPoint.
    generateExtensions(w, extensionProfile);

    w.endElement(Namespaces.APPS_NAMESPACE, EXTENSION_LOCAL_NAME);

  }

  @Override
  public ElementHandler getHandler(ExtensionProfile extProfile,
      String namespace, String localName, Attributes attrs) {
    return new Handler(extProfile);
  }

  /** <apps:Label> parser. */
  private class Handler extends ExtensionPoint.ExtensionHandler {

    public Handler(ExtensionProfile extProfile) {
      super(extProfile, Label.class);
    }

    @Override
    public void processAttribute(String namespace, String localName,
        String value) {

      if ("".equals(namespace)) {
        if (ATTRIBUTE_LABEL_NAME.equals(localName)) {
          labelName = value;
        }
      }
    }

    @Override
    public void processEndElement() throws ParseException {

      if (labelName == null) {
        throw new ParseException(
          Namespaces.APPS_NAMESPACE + ":" + EXTENSION_LOCAL_NAME
          + "/@" + ATTRIBUTE_LABEL_NAME + " is required."
        );
      }
      
      super.processEndElement();
    }
  }
}

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

import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Person;
import com.google.gdata.util.Namespaces;

import java.io.IOException;
import java.util.List;

/**
 * The user who last modified the object.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.gAlias,
    nsUri = Namespaces.g,
    localName = LastModifiedBy.XML_NAME)
public class LastModifiedBy extends Person {

  /** XML element name **/
  static final String XML_NAME = "lastModifiedBy";
  
  /**
   * Default mutable constructor.
   */
  public LastModifiedBy() {
    super();
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param person the user
   */
  public LastModifiedBy(Person person) {
    super(person.getName(), person.getUri(), person.getEmail());
  }

  @Override
  protected void generate(XmlWriter w, ExtensionProfile p, XmlNamespace namespace,
      String localName, List<Attribute> attrs, AttributeGenerator generator) throws IOException {
    generate(p, w, namespace, localName, attrs);
  }
}

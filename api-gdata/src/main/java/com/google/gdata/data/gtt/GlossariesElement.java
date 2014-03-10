/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.gtt;

import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Link;

import java.util.List;

/**
 * Describes a glossaries element.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = GttNamespace.GTT_ALIAS,
    nsUri = GttNamespace.GTT,
    localName = GlossariesElement.XML_NAME)
public class GlossariesElement extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "glossary";

  /**
   * Default mutable constructor.
   */
  public GlossariesElement() {
    super();
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(GlossariesElement.class)) {
      return;
    }
    extProfile.declare(GlossariesElement.class,
        new ExtensionDescription(Link.class, new XmlNamespace("atom",
        "http://www.w3.org/2005/Atom"), "link", true, true, false));
  }

  /**
   * Returns the glossary entry links.
   *
   * @return glossary entry links
   */
  public List<Link> getLinks() {
    return getRepeatingExtension(Link.class);
  }

  /**
   * Adds a new glossary entry link.
   *
   * @param link glossary entry link
   */
  public void addLink(Link link) {
    getLinks().add(link);
  }

  /**
   * Returns whether it has the glossary entry links.
   *
   * @return whether it has the glossary entry links
   */
  public boolean hasLinks() {
    return hasRepeatingExtension(Link.class);
  }

  @Override
  protected void validate() {
  }

  /**
   * Returns the extension description, specifying whether it is required, and
   * whether it is repeatable.
   *
   * @param required   whether it is required
   * @param repeatable whether it is repeatable
   * @return extension description
   */
  public static ExtensionDescription getDefaultDescription(boolean required,
      boolean repeatable) {
    ExtensionDescription desc =
        ExtensionDescription.getDefaultDescription(GlossariesElement.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{GlossariesElement}";
  }

}


/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.webmastertools;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * URL affected by the crawl issue.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.WT_ALIAS,
    nsUri = Namespaces.WT,
    localName = CrawlIssueUrl.XML_NAME)
public class CrawlIssueUrl extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "url";

  /**
   * Default mutable constructor.
   */
  public CrawlIssueUrl() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param url immutable value or <code>null</code> for a mutable value
   */
  public CrawlIssueUrl(String url) {
    super(Namespaces.WT_NS, XML_NAME, null, url);
    setRequired(false);
  }

  /**
   * Returns the value.
   *
   * @return value
   */
  public String getUrl() {
    return getValue();
  }

  /**
   * Sets the value.
   *
   * @param url value or <code>null</code> to reset
   */
  public void setUrl(String url) {
    setValue(url);
  }

  /**
   * Returns whether it has the value.
   *
   * @return whether it has the value
   */
  public boolean hasUrl() {
    return hasValue();
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
        ExtensionDescription.getDefaultDescription(CrawlIssueUrl.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{CrawlIssueUrl url=" + getValue() + "}";
  }

}


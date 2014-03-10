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
 * Detail of the crawl issue.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.WT_ALIAS,
    nsUri = Namespaces.WT,
    localName = CrawlIssueDetail.XML_NAME)
public class CrawlIssueDetail extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "detail";

  /**
   * Default mutable constructor.
   */
  public CrawlIssueDetail() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param detail immutable value or <code>null</code> for a mutable value
   */
  public CrawlIssueDetail(String detail) {
    super(Namespaces.WT_NS, XML_NAME, null, detail);
    setRequired(false);
  }

  /**
   * Returns the value.
   *
   * @return value
   */
  public String getDetail() {
    return getValue();
  }

  /**
   * Sets the value.
   *
   * @param detail value or <code>null</code> to reset
   */
  public void setDetail(String detail) {
    setValue(detail);
  }

  /**
   * Returns whether it has the value.
   *
   * @return whether it has the value
   */
  public boolean hasDetail() {
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
        ExtensionDescription.getDefaultDescription(CrawlIssueDetail.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{CrawlIssueDetail detail=" + getValue() + "}";
  }

}


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

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.util.ParseException;

/**
 * Detection date for the issue.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.WT_ALIAS,
    nsUri = Namespaces.WT,
    localName = CrawlIssueDateDetected.XML_NAME)
public class CrawlIssueDateDetected extends AbstractExtension {

  /** XML element name */
  static final String XML_NAME = "date-detected";

  /** Value */
  private DateTime dateDetected = null;

  /**
   * Default mutable constructor.
   */
  public CrawlIssueDateDetected() {
    super();
  }

  /**
   * Immutable constructor.
   *
   * @param dateDetected value.
   */
  public CrawlIssueDateDetected(DateTime dateDetected) {
    super();
    setDateDetected(dateDetected);
    setImmutable(true);
  }

  /**
   * Returns the value.
   *
   * @return value
   */
  public DateTime getDateDetected() {
    return dateDetected;
  }

  /**
   * Sets the value.
   *
   * @param dateDetected value or <code>null</code> to reset
   */
  public void setDateDetected(DateTime dateDetected) {
    throwExceptionIfImmutable();
    this.dateDetected = dateDetected;
  }

  /**
   * Returns whether it has the value.
   *
   * @return whether it has the value
   */
  public boolean hasDateDetected() {
    return getDateDetected() != null;
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
        ExtensionDescription.getDefaultDescription(
        CrawlIssueDateDetected.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    generator.setContent(dateDetected.toString());
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper) throws ParseException
      {
    dateDetected = helper.consumeDateTime(null, false);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    CrawlIssueDateDetected other = (CrawlIssueDateDetected) obj;
    return eq(dateDetected, other.dateDetected);
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (dateDetected != null) {
      result = 37 * result + dateDetected.hashCode();
    }
    return result;
  }

  @Override
  public String toString() {
    return "{CrawlIssueDateDetected dateDetected=" + dateDetected + "}";
  }

}


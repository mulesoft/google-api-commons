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
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.util.ParseException;

/**
 * Type of crawl of the crawl issue.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.WT_ALIAS,
    nsUri = Namespaces.WT,
    localName = CrawlIssueCrawlType.XML_NAME)
public class CrawlIssueCrawlType extends AbstractExtension {

  /** XML element name */
  static final String XML_NAME = "crawl-type";

  private static final AttributeHelper.EnumToAttributeValue<CrawlType>
      CRAWLTYPE_ENUM_TO_ATTRIBUTE_VALUE = new
      AttributeHelper.EnumToAttributeValue<CrawlType>() {
    public String getAttributeValue(CrawlType enumValue) {
      return enumValue.toValue();
    }
  };

  /** Value */
  private CrawlType crawlType = null;

  /** Value. */
  public enum CrawlType {

    /** The type of crawl is Mobile, CHTML. */
    MOBILE_CHTML_CRAWL("mobile-cHTML-crawl"),

    /** The type of crawl is Mobile, Operator. */
    MOBILE_OPERATOR_CRAWL("mobile-operator-crawl"),

    /** The type of crawl is Mobile, XHTML / WML. */
    MOBILE_XHTML_WML_CRAWL("mobile-XHTML-WML-crawl"),

    /** The type of crawl is News. */
    NEWS_CRAWL("news-crawl"),

    /** The type of crawl is Web. */
    WEB_CRAWL("web-crawl");

    private final String value;

    private CrawlType(String value) {
      this.value = value;
    }

    /**
     * Returns the value used in the XML.
     *
     * @return value used in the XML
     */
    public String toValue() {
      return value;
    }

  }

  /**
   * Default mutable constructor.
   */
  public CrawlIssueCrawlType() {
    super();
  }

  /**
   * Immutable constructor.
   *
   * @param crawlType value.
   */
  public CrawlIssueCrawlType(CrawlType crawlType) {
    super();
    setCrawlType(crawlType);
    setImmutable(true);
  }

  /**
   * Returns the value.
   *
   * @return value
   */
  public CrawlType getCrawlType() {
    return crawlType;
  }

  /**
   * Sets the value.
   *
   * @param crawlType value or <code>null</code> to reset
   */
  public void setCrawlType(CrawlType crawlType) {
    throwExceptionIfImmutable();
    this.crawlType = crawlType;
  }

  /**
   * Returns whether it has the value.
   *
   * @return whether it has the value
   */
  public boolean hasCrawlType() {
    return getCrawlType() != null;
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
        ExtensionDescription.getDefaultDescription(CrawlIssueCrawlType.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    generator.setContent(CRAWLTYPE_ENUM_TO_ATTRIBUTE_VALUE.getAttributeValue(
        crawlType));
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper) throws ParseException
      {
    crawlType = helper.consumeEnum(null, false, CrawlType.class, null,
        CRAWLTYPE_ENUM_TO_ATTRIBUTE_VALUE);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    CrawlIssueCrawlType other = (CrawlIssueCrawlType) obj;
    return eq(crawlType, other.crawlType);
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (crawlType != null) {
      result = 37 * result + crawlType.hashCode();
    }
    return result;
  }

  @Override
  public String toString() {
    return "{CrawlIssueCrawlType crawlType=" + crawlType + "}";
  }

}


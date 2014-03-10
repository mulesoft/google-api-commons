/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.media.mediarss;

import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.util.ParseException;

/**
 * {@code <media:category>}.
 *
 * See description on
 * <a href="http://search.yahoo.com/mrss">http://search.yahoo.com/mrss</a>.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = MediaRssNamespace.PREFIX,
    nsUri = MediaRssNamespace.URI,
    localName = "category",
    isRepeatable = true)
public class MediaCategory extends AbstractElementWithContent {

  /**
   * Default scheme as defined by the specification.
   *
   * This scheme is defined on : http://search.yahoo.com/mrss/category_schema
   */
  public static final String DEFAULT_SCHEME =
    "http://search.yahoo.com/mrss/category_schema";

  private String scheme;
  private String label;

  /** Creates an empty category tag. */
  public MediaCategory() {
  }

  /** Creates an initializes a category tag. */
  public MediaCategory(String scheme, String content) {
    this.scheme = scheme;
    setContent(content);
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getScheme() {
    return scheme;
  }

  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);
    generator.put("label", label);
    generator.put("scheme", scheme);
  }

  @Override
  protected void consumeAttributes(AttributeHelper attrsHelper)
      throws ParseException {
    super.consumeAttributes(attrsHelper);
    this.label = attrsHelper.consume("label", false);
    this.scheme = attrsHelper.consume("scheme", false);
  }
}

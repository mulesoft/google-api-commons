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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

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
    localName = "restriction",
    isRepeatable = true)
public class MediaRestriction extends AbstractElementWithContent {
  private MediaRestriction.Type type;
  private MediaRestriction.Relationship relationship;

  public MediaRestriction.Relationship getRelationship() {
    return relationship;
  }

  public void setRelationship(MediaRestriction.Relationship relationship) {
    this.relationship = relationship;
  }

  public MediaRestriction.Type getType() {
    return type;
  }

  public void setType(MediaRestriction.Type type) {
    this.type = type;
  }

  /**
   * Sets the content as a space-separated list of country codes.
   *
   * @param codes a list of country codes
   */
  public void setContentAsCountryCodeList(List<String> codes) {
    if (codes.isEmpty()) {
      setContent(null);
      return;
    }

    StringBuilder builder = new StringBuilder();
    boolean isFirst = true;
    for (String code : codes) {
      if (isFirst) {
        isFirst = false;
      } else {
        builder.append(' ');
      }
      builder.append(code);
    }
    setContent(builder.toString());
  }

  /**
   * Gets the content as a space-separated list of country codes.
   *
   * Check the type before calling this method.
   *
   * @return a list of strings
   */
  public List<String> getContentAsCountryCodeList() {
    if (getContent() == null) {
      return Collections.emptyList();
    }
    List<String> countries = new ArrayList<String>();
    StringTokenizer tok = new StringTokenizer(getContent(), " ");
    while(tok.hasMoreTokens()) {
      countries.add(tok.nextToken().trim());
    }
    return countries;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);
    generator.put("type", type,
        new AttributeHelper.LowerCaseEnumToAttributeValue<Type>());
    generator.put("relationship", relationship,
        new AttributeHelper.LowerCaseEnumToAttributeValue<Relationship>());
  }

  @Override
  protected void consumeAttributes(AttributeHelper attrsHelper) throws
      ParseException {
    super.consumeAttributes(attrsHelper);
    type = attrsHelper.consumeEnum("type", false, Type.class);
    relationship =
        attrsHelper.consumeEnum("relationship", false, Relationship.class);
  }

  /** Values for the type attribute. */
  public static enum Type {
    COUNTRY, URI;
  }

  /** Values for the relationship attribute. */
  public static enum Relationship {
    ALLOW, DENY
  }
}

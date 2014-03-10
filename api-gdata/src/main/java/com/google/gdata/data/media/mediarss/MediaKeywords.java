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

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.util.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Collection;

/**
 * {@code <media:keywords>}.
 *
 * See description on
 * <a href="http://search.yahoo.com/mrss">http://search.yahoo.com/mrss</a>.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = MediaRssNamespace.PREFIX,
    nsUri = MediaRssNamespace.URI,
    localName = "keywords"
)
public class MediaKeywords extends AbstractExtension {
  private final List<String> keywords = new ArrayList<String>();

  /** Describes the tag to an {@link com.google.gdata.data.ExtensionProfile}. */
  public static ExtensionDescription getDefaultDescription() {
    return ExtensionDescription.getDefaultDescription(MediaKeywords.class);
  }

  public List<String> getKeywords() {
    return keywords;
  }

  public void addKeyword(String keyword) {
    keywords.add(keyword);
  }

  public void addKeywords(Collection<String> keywords) {
    this.keywords.addAll(keywords);
  }

  public void clearKeywords() {
    keywords.clear();
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    StringBuffer content = new StringBuffer();
    boolean isFirst = true;
    for (String keyword: keywords) {
      if (isFirst) {
        isFirst = false;
      } else {
        content.append(", ");
      }
      content.append(keyword);
    }

    generator.setContent(content.toString());
  }

  @Override
  protected void consumeAttributes(AttributeHelper attrsHelper) 
      throws ParseException {
    String value = attrsHelper.consumeContent(false);
    keywords.clear();
    if (value != null) {
      StringTokenizer tokenizer = new StringTokenizer(value, ",");
      while(tokenizer.hasMoreTokens()) {
        String token = tokenizer.nextToken().trim();
        keywords.add(token);
      }
    }
  }
}

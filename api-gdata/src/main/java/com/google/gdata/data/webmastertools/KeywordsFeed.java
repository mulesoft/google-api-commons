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

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;

import java.util.List;

/**
 * Feed of keywords for a particular site.
 *
 * 
 */
@Kind.Term(KeywordEntry.KIND)
public class KeywordsFeed extends BaseFeed<KeywordsFeed, KeywordEntry> {

  /**
   * Default mutable constructor.
   */
  public KeywordsFeed() {
    super(KeywordEntry.class);
    getCategories().add(KeywordEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public KeywordsFeed(BaseFeed<?, ?> sourceFeed) {
    super(KeywordEntry.class, sourceFeed);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(KeywordsFeed.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(KeywordsFeed.class, Keyword.getDefaultDescription(true,
        true));
  }

  /**
   * Returns the keywords.
   *
   * @return keywords
   */
  public List<Keyword> getKeywords() {
    return getRepeatingExtension(Keyword.class);
  }

  /**
   * Adds a new keyword.
   *
   * @param keyword keyword
   */
  public void addKeyword(Keyword keyword) {
    getKeywords().add(keyword);
  }

  /**
   * Returns whether it has the keywords.
   *
   * @return whether it has the keywords
   */
  public boolean hasKeywords() {
    return hasRepeatingExtension(Keyword.class);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{KeywordsFeed " + super.toString() + "}";
  }

}


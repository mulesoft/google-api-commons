/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.codesearch;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;


/**
 * The CodeSearchFeed class customizes the generic BaseFeed class to define
 * a feed to search for code.
 *
 * 
 */
@Kind.Term(CodeSearchEntry.CODESEARCH_KIND)
public class CodeSearchFeed extends BaseFeed<CodeSearchFeed, CodeSearchEntry> {

  /**
   * Constructs a new {@code CodeSearchFeed} instance that is parameterized to
   * contain {@code CodeSearchEntry} instances.
   */
  public CodeSearchFeed() {
    super(CodeSearchEntry.class);
    getCategories().add(CodeSearchEntry.CODESEARCH_CATEGORY);
  }

  /**
   * Constructs a new {@code CodeSearchFeed} instance that is initialized using
   * data from another BaseFeed instance.
   */
  public CodeSearchFeed(BaseFeed sourceFeed) {
    super(CodeSearchEntry.class, sourceFeed);
    getCategories().add(CodeSearchEntry.CODESEARCH_CATEGORY);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {

    // Add any feed-level extension declarations here.

    super.declareExtensions(extProfile);
  }

  // Any feed-level extension accessor APIs would go here
}

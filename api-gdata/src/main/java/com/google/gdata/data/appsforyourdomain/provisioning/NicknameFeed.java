/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.appsforyourdomain.provisioning;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;

/**
 * 
 * 
 */
@Kind.Term(NicknameEntry.NICKNAME_KIND)
public class NicknameFeed extends BaseFeed<NicknameFeed, NicknameEntry> {

  /**
   * Constructs a new {@code NicknameFeed} instance that is parameterized to
   * contain {@code NicknameEntry} instances.
   */
  public NicknameFeed() {
    super(NicknameEntry.class);
    getCategories().add(NicknameEntry.NICKNAME_CATEGORY);
  }

  /**
   * Constructs a new {@code NicknameFeed} instance that is initialized using
   * data from another BaseFeed instance.
   */
  public NicknameFeed(BaseFeed sourceFeed) {
    super(NicknameEntry.class, sourceFeed);
    getCategories().add(NicknameEntry.NICKNAME_CATEGORY);
  }

  @Override
  public void declareExtensions(ExtensionProfile extensionProfile) {
    super.declareExtensions(extensionProfile);
  }
}

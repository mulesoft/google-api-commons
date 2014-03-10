/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.finance;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.extensions.FeedLink;

/**
 * Describes a position feed link.
 *
 * 
 */
public class PositionFeedLink extends FeedLink<TransactionFeed> {

  /**
   * Default mutable constructor.
   */
  public PositionFeedLink() {
    super(TransactionFeed.class);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(PositionFeedLink.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    ExtensionProfile feedLinkProfile = extProfile.getFeedLinkProfile();
    if (feedLinkProfile == null) {
      feedLinkProfile = new ExtensionProfile();
      extProfile.declareFeedLinkProfile(feedLinkProfile);
    }
    new TransactionFeed().declareExtensions(feedLinkProfile);
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
        ExtensionDescription.getDefaultDescription(PositionFeedLink.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{PositionFeedLink " + super.toString() + "}";
  }

}


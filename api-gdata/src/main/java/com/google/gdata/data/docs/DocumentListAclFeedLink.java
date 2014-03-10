/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.docs;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.acl.AclFeed;
import com.google.gdata.data.extensions.FeedLink;
import com.google.gdata.util.Namespaces;

/**
 * Represents a FeedLink referring to an AclFeed.  Currently used only
 * by DocumentListFeed, but contains no code specific to that use.
 * 
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.gAlias,
    nsUri = Namespaces.g,
    localName = "feedLink",
    isRepeatable = true)
public class DocumentListAclFeedLink extends FeedLink<AclFeed> {
  public DocumentListAclFeedLink() {
    super(AclFeed.class);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    ExtensionProfile ep = new ExtensionProfile();
    new AclFeed().declareExtensions(ep);
    extProfile.declareFeedLinkProfile(ep);
  }
}

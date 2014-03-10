/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.acl;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;

/**
 * Defines a feed of an access control list (ACL).
 *
 * 
 */
@Kind.Term(AclEntry.ACCESS_RULE_KIND)
public class AclFeed extends BaseFeed<AclFeed, AclEntry> {

  /**
   * Default constructor for an ACL feed.
   */
  public AclFeed() {
    super(AclEntry.class);
    getCategories().add(AclEntry.ACCESS_RULE_CATEGORY);
  }

}

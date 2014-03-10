/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.sites;

import com.google.gdata.data.acl.AclNamespace;

/**
 * Describes a sites ACL feed link.
 *
 * 
 */
public class SitesAclFeedLink {

  /** Feed relation type. */
  public static final class Rel {

    /** Acccess control list feed link. */
    public static final String ACCESS_CONTROL_LIST = AclNamespace.gAclPrefix +
        "accessControlList";

  }

  /** Private constructor to ensure class is not instantiated. */
  private SitesAclFeedLink() {}

}


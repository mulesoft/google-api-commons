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

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * GData namespace definitions related to Access Control Lists (ACL's).
 *
 * 
 */
public class AclNamespace {

  private AclNamespace() {}

  /** Google Access Control List namespace */
  public static final String gAcl = "http://schemas.google.com/acl/2007";

  /** Google Access Control List namespace prefix */
  public static final String gAclPrefix = gAcl + "#";

  /** Default Google Access Control List namespace alias */
  public static final String gAclAlias = "gAcl";

  /** XML writer namespace for Google ACL */
  public static final XmlNamespace gAclNs = new XmlNamespace(gAclAlias, gAcl);

  /**
   * Link provides the URI of the feed for the access control list for the
   * entry.
   */
  public static final String LINK_REL_ACCESS_CONTROL_LIST =
      gAclPrefix + "accessControlList";

  /**
   * Link provides the URI of the entry that is controlled by the access
   * control list feed.
   */
  public static final String LINK_REL_CONTROLLED_OBJECT =
      gAclPrefix + "controlledObject";

}

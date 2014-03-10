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

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.util.Namespaces;

import java.util.List;

/**
 * Defines an entry in a feed of an access control list (ACL).
 *
 * 
 */
@Kind.Term(AclEntry.ACCESS_RULE_KIND)
public class AclEntry extends BaseEntry<AclEntry> {

  /**
   * Kind term value for access rule category.
   */
  public static final String ACCESS_RULE_KIND =
      AclNamespace.gAclPrefix + "accessRule";

  /**
   * Kind category used to label feeds or entries that have Event extension
   * data.
   */
  public static final Category ACCESS_RULE_CATEGORY =
      new Category(Namespaces.gKind, ACCESS_RULE_KIND);

  /**
   * Default constructor for an ACL entry.
   */
  public AclEntry() {
    super();
    getCategories().add(ACCESS_RULE_CATEGORY);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    extProfile.declare(AclEntry.class, AclScope.class);
    extProfile.declare(AclEntry.class, AclRole.class);
    extProfile.declare(AclEntry.class, AclWithKey.class);
    new AclWithKey().declareExtensions(extProfile);
    extProfile.declare(AclEntry.class, AdditionalRole.getDefaultDescription(false, true));
  }

  public AclScope getScope() {
    return getExtension(AclScope.class);
  }

  public void setScope(AclScope scope) {
    setExtension(scope);
  }

  public AclRole getRole() {
    return getExtension(AclRole.class);
  }

  public void setRole(AclRole role) {
    setExtension(role);
  }

  public AclWithKey getWithKey() {
    return getExtension(AclWithKey.class);
  }

  public void setWithKey(AclWithKey withKey) {
    setExtension(withKey);
  }

  public List<AdditionalRole> getAdditionalRoles() {
    return getRepeatingExtension(AdditionalRole.class);
  }

  public void addAdditionalRole(AdditionalRole role) {
    addRepeatingExtension(role);
  }

  public void clearAdditionalRoles() {
    getAdditionalRoles().clear();
  }
}

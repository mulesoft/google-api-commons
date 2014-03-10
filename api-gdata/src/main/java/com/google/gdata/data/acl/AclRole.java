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

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * Describes the role of an entry in an access control list.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = AclNamespace.gAclAlias,
    nsUri = AclNamespace.gAcl,
    localName = AclRole.ROLE)
public class AclRole extends ValueConstruct {

  /**
   * predefined value "none" to indicate that a user has no rights
   */
  public static final AclRole NONE = new AclRole("none");

  /**
   * predefined value "peeker" to indicate that a user has the right to know of
   * the existance of the controlled object
   */
  public static final AclRole PEEKER = new AclRole("peeker");

  /**
   * predefined value "reader" to indicate that a user has the right to read the
   * controlled object
   */
  public static final AclRole READER = new AclRole("reader");

  /**
   * predefined value "none" to indicate that a user has the right to read and
   * modify the controlled object
   */
  public static final AclRole WRITER = new AclRole("writer");

  /**
   * predefined value "owner" to indicate that a user has the right to read,
   * modify and delete the controlled object
   */
  public static final AclRole OWNER = new AclRole("owner");

  /**
   * Predefined value 'commenter' to indicate that a user has the right to
   * comment on the controlled object.
   */
  public static final AclRole COMMENTER = new AclRole("commenter");

  /** XML "role" element name */
  static final String ROLE = "role";

  /** XML "value" attribute name */
  private static final String VALUE = "value";

  /**
   * Default constructor for a mutable role.
   */
  public AclRole() {
    this(null);
  }

  /**
   * Constructor for either a mutable or immutable role.
   *
   * @param value immutable value to use for this role or <code>null</code> for
   *              a mutable role.
   */
  public AclRole(String value) {
    super(AclNamespace.gAclNs, ROLE, VALUE, value);
  }
}

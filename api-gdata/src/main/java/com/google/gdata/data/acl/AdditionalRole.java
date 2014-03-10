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
 * Describes an additional role for an entry in an access control list.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = AclNamespace.gAclAlias,
    nsUri = AclNamespace.gAcl,
    localName = AdditionalRole.XML_NAME)
public class AdditionalRole extends ValueConstruct {

  /**
   * Predefined value 'appender' to indicate that a user has the right to add
   * to the controlled object.
   */
  public static final AdditionalRole APPENDER = new AdditionalRole("appender");

  /**
   * Predefined value 'commenter' to indicate that a user has the right to
   * comment on the controlled object.
   */
  public static final AdditionalRole COMMENTER = new AdditionalRole("commenter");

  /**
   * Predefined value 'executer' to indicate that a user has the right to
   * execute the controlled object.
   */
  public static final AdditionalRole EXECUTER = new AdditionalRole("executer");

  /** XML element name */
  static final String XML_NAME = "additionalRole";

  /** XML "value" attribute name */
  private static final String VALUE = "value";

  /**
   * Default mutable constructor.
   */
  public AdditionalRole() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable value or <code>null</code> for a mutable value
   */
  public AdditionalRole(String value) {
    super(AclNamespace.gAclNs, XML_NAME, VALUE, value);
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
        ExtensionDescription.getDefaultDescription(AdditionalRole.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }
}


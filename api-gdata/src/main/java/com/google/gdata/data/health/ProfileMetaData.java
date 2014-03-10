/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.health;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;

/**
 * Describes profile's meta data.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = HealthNamespace.H9M_ALIAS,
    nsUri = HealthNamespace.H9M,
    localName = ProfileMetaData.XML_NAME)
public class ProfileMetaData extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "ProfileMetaData";

  /**
   * Default mutable constructor.
   */
  public ProfileMetaData() {
    super();
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
        ExtensionDescription.getDefaultDescription(ProfileMetaData.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{ProfileMetaData}";
  }

}

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
 * Describes a ccr record.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = HealthNamespace.CCR_ALIAS,
    nsUri = HealthNamespace.CCR,
    localName = ContinuityOfCareRecord.XML_NAME)
public class ContinuityOfCareRecord extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "ContinuityOfCareRecord";

  /**
   * Default mutable constructor.
   */
  public ContinuityOfCareRecord() {
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
        ExtensionDescription.getDefaultDescription(
        ContinuityOfCareRecord.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{ContinuityOfCareRecord}";
  }

}

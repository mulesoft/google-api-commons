/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data;

import com.google.gdata.util.common.xml.XmlNamespace;

import java.util.Set;

/**
 * The EnumConstruct class defines a special type of {@link ValueConstruct}
 * where the attribute values are constrained to a discrete set of valid
 * values.
 */
public abstract class EnumConstruct extends ValueConstruct {

  /**
   * The set of valid values for the enum construct.
   */
  protected Set<String> values;

  /**
   * Constructs a new EnumConstruct instance associated with a particular
   * XML representation and set of expected values.
   */
  protected EnumConstruct(XmlNamespace namespace,
                          String tagName,
                          String attrName,
                          Set<String> values) {
    this(namespace, tagName, attrName, values, null);
  }

  /**
   * Constructs a new EnumConstruct instance associated with a particular
   * XML representation and set of expected values.  An an initial value
   * is provided and it is not {@code null}, the constructed instance will
   * be initialized to the value and will be immutable.
   */
  protected EnumConstruct(XmlNamespace namespace,
                          String tagName,
                          String attrName,
                          Set<String> values,
                          String initialValue) {
    // initialValue is *not* passed here by design, to ensure that we don't
    // try to set it before this.values has been initialized
    super(namespace, tagName, attrName);
    if (values == null) {
      throw new NullPointerException("Null values set");
    }
    this.values = values;
    if (initialValue != null) {
      setValue(initialValue);
      setImmutable(true);
    }
  }

  @Override
  public void setValue(String v) throws IllegalArgumentException {
    if (!values.contains(v)) {
      throw new IllegalArgumentException("Invalid " + localName + " value:" +v);
    }
    super.setValue(v);
  }
}

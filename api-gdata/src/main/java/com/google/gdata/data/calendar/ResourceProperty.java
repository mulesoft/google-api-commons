/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.calendar;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.util.ParseException;

/**
 * GData schema extension describing whether gd:who is a resource, such as a
 * conference room.
 *
 * 
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.gCalAlias,
    nsUri = Namespaces.gCal,
    localName = ResourceProperty.EXTENSION_LOCAL_NAME)
public class ResourceProperty extends AbstractExtension {

  static final String EXTENSION_LOCAL_NAME = "resource";
  private static final String ATTRIBUTE_ID = "id";
  private static final String ATTRIBUTE_VALUE = "value";

  public static final ResourceProperty TRUE = new ResourceProperty("true");
  public static final ResourceProperty FALSE = new ResourceProperty("false");

  public static ExtensionDescription getDefaultDescription() {
    return ExtensionDescription.getDefaultDescription(ResourceProperty.class);
  }

  public ResourceProperty() {
    this(null);
  }

  public ResourceProperty(String value) {
    this.value = value;
  }

  // property "id"
  protected String id;
  public String getId() {
    return this.id;
  }
  public void setId(String resId) {
    this.id = resId;
  }

  // property "value"
  protected String value;
  public String getValue() {
    return this.value;
  }
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    generator.put(ATTRIBUTE_ID, id);
    generator.put(ATTRIBUTE_VALUE, value);
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper)
      throws ParseException {
    id = helper.consume(ATTRIBUTE_ID, false);
    value = helper.consume(ATTRIBUTE_VALUE, false);
  }

  @Override
  protected void validate() {
    if (id == null && value == null) {
      throw new IllegalStateException("No attributes defined");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!sameClassAs(o)) {
      return false;
    }

    ResourceProperty prop = (ResourceProperty) o;

    return eq(value, prop.value) && eq(id, prop.id);
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (value != null) {
      result = 37 * result + value.hashCode();
    }
    if (id != null) {
      result = 37 * result + id.hashCode();
    }

    return result;
  }
}

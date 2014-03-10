/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.contacts;

import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.util.ParseException;

/**
 * Person status element.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = ContactsNamespace.GCONTACT_ALIAS,
    nsUri = ContactsNamespace.GCONTACT,
    localName = Status.XML_NAME)
public class Status extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "status";

  /** XML "indexed" attribute name */
  private static final String INDEXED = "indexed";

  /** Whether this person is in the global address list */
  private Boolean indexed = null;

  /**
   * Default mutable constructor.
   */
  public Status() {
    super();
  }

  /**
   * Immutable constructor.
   *
   * @param indexed whether this person is in the global address list.
   */
  public Status(Boolean indexed) {
    super();
    setIndexed(indexed);
    setImmutable(true);
  }

  /**
   * Returns the whether this person is in the global address list.
   *
   * @return whether this person is in the global address list
   */
  public Boolean getIndexed() {
    return indexed;
  }

  /**
   * Sets the whether this person is in the global address list.
   *
   * @param indexed whether this person is in the global address list or
   *     <code>null</code> to reset
   */
  public void setIndexed(Boolean indexed) {
    throwExceptionIfImmutable();
    this.indexed = indexed;
  }

  /**
   * Returns whether it has the whether this person is in the global address
   * list.
   *
   * @return whether it has the whether this person is in the global address
   *     list
   */
  public boolean hasIndexed() {
    return getIndexed() != null;
  }

  @Override
  protected void validate() {
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
        ExtensionDescription.getDefaultDescription(Status.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    generator.put(INDEXED, indexed);
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper) throws ParseException
      {
    indexed = helper.consumeBoolean(INDEXED, false);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    Status other = (Status) obj;
    return eq(indexed, other.indexed);
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (indexed != null) {
      result = 37 * result + indexed.hashCode();
    }
    return result;
  }

  @Override
  public String toString() {
    return "{Status indexed=" + indexed + "}";
  }

}


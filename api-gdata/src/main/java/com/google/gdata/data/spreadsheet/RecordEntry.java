/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;

import java.util.List;

/**
 * Describes a record entry in the feed of a table's records.
 *
 * 
 */
@Kind.Term(RecordEntry.KIND)
public class RecordEntry extends BaseEntry<RecordEntry> {

  /**
   * Record record category kind term value.
   */
  public static final String KIND = Namespaces.gSpreadPrefix + "record";

  /**
   * Record record category kind category.
   */
  public static final Category CATEGORY = new
      Category(com.google.gdata.util.Namespaces.gKind, KIND);

  /**
   * Default mutable constructor.
   */
  public RecordEntry() {
    super();
    getCategories().add(CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public RecordEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(RecordEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(RecordEntry.class, Field.getDefaultDescription(false,
        true));
  }

  /**
   * Returns the fields.
   *
   * @return fields
   */
  public List<Field> getFields() {
    return getRepeatingExtension(Field.class);
  }

  /**
   * Adds a new field.
   *
   * @param field field
   */
  public void addField(Field field) {
    getFields().add(field);
  }

  /**
   * Returns whether it has the fields.
   *
   * @return whether it has the fields
   */
  public boolean hasFields() {
    return hasRepeatingExtension(Field.class);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{RecordEntry " + super.toString() + "}";
  }

}

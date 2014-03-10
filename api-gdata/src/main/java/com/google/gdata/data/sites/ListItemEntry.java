/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.sites;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.data.Link;
import com.google.gdata.data.spreadsheet.Field;
import com.google.gdata.util.Namespaces;

import java.util.List;

/**
 * Describes a list item entry.
 *
 * 
 */
@Kind.Term(ListItemEntry.KIND)
public class ListItemEntry extends BaseContentEntry<ListItemEntry> {

  /**
   * Listitem list item kind kind term value.
   */
  public static final String KIND = SitesNamespace.SITES_PREFIX + "listitem";

  /**
   * Listitem list item kind kind category.
   */
  public static final Category CATEGORY = new Category(Namespaces.gKind, KIND,
      "listitem");

  /**
   * Default mutable constructor.
   */
  public ListItemEntry() {
    super();
    getCategories().add(CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public ListItemEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(ListItemEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(ListItemEntry.class, Field.getDefaultDescription(false,
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

  /**
   * Returns the parent sites link.
   *
   * @return Parent sites link or {@code null} for none.
   */
  public Link getParentLink() {
    return getLink(SitesLink.Rel.PARENT, Link.Type.ATOM);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{ListItemEntry " + super.toString() + "}";
  }

}


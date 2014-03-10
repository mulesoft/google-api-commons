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
import com.google.gdata.data.Content;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.data.TextConstruct;

/**
 * Atom Entry for one single row Google Spreadsheets in the list-based
 * access mode.
 *
 * 
 */
@Kind.Term(ListEntry.KIND)
public class ListEntry
    extends BaseEntry<ListEntry> {

  /**
   * Kind category term used to label the flexible-schema list entries.
   */
  public static final String KIND = Namespaces.gSpreadPrefix + "list";

  /**
   * Category used to label the flexible-schema list entries.
   */
  public static final Category CATEGORY =
    new Category(Namespaces.gSpread, KIND);

  /**
   * The aggregation of all gx:* elements.
   */
  private CustomElementCollection customElements;


  /**
   * Constructs an empty CellEntry to be populated by the XML parsing process.
   */
  public ListEntry() {
    getCategories().add(CATEGORY);
    init();
  }

  /**
   * Constructs a List Entry with the given information. 
   * 
   * @param id the permanent ID of this entry
   * @param versionId the version identifier of the snapshot
   */
  public ListEntry(String id, String versionId) {
    this();
    
    setId(id);
    setVersionId(versionId);
  }

  /**
   * Constructs from a copy.
   * 
   * @param sourceEntry source to copy from
   */
  public ListEntry(BaseEntry sourceEntry) {
    super(sourceEntry);
    getCategories().add(CATEGORY);
    if (this.getExtension(CustomElementCollection.class) == null) {
      init();
    }
  }

  /**
   * Common initialization code for new list entries.
   */
  private void init() {
    customElements = new CustomElementCollection();
    this.setExtension(customElements);
  }

  /**
   * Gets the collection of custom elements that contain all the special
   * gsx data items.  This is how you access your spreadsheet data.
   * 
   * @return a CustomElement object for getting all the internal data
   */
  public CustomElementCollection getCustomElements() {
    return customElements;
  }

  /**
   * Prevents setting the server-generated field.
   */
  @Override
  public void setTitle(TextConstruct v) {
    throw new UnsupportedOperationException(
        "Title is server-generated for Google Spreadsheets list access.");
  }

  /**
   * Prevents setting the server-generated field.
   */
  @Override
  public void setContent(Content c) {
    throw new UnsupportedOperationException(
        "Content is server-generated for Google Spreadsheets list access.");
  }

  /**
   * Prevents setting the server-generated field.
   */
  @Override
  public void setContent(TextConstruct c) {
    throw new UnsupportedOperationException(
        "Content is server-generated for Google Spreadsheets list access.");
  }
  
  /**
   * Prevents setting the server-generated field.
   */
  @Override
  public void setSummary(TextConstruct v) {
    throw new UnsupportedOperationException(
        "Summary is server-generated for Google Spreadsheets list access.");
  }


  /**
   * Lets the GData server populate this entry with the atom:title.
   */
  public void setAutomaticallyGeneratedTitle(TextConstruct v) {
    state.title = v;
  }

  /**
   * Lets the GData server populate this entry with the atom:content.
   */
  public void setAutomaticallyGeneratedContent(Content c) {
    state.content = c;
  }

  /**
   * Lets the GData server populate this entry with the atom:summary.
   */
  public void setAutomaticallyGeneratedSummary(TextConstruct v) {
    state.summary = v;
  }

  /**
   * Declares the extensions used by the XML parser in the given profile object.
   */
  public void declareExtensions(ExtensionProfile extProfile) {
    extProfile.declare(ListEntry.class,
        CustomElementCollection.getDefaultDescription());
  }
}

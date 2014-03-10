/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.photos;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.util.ParseException;

/**
 * Entry for tag kinds, contains tag metadata.
 *
 * 
 */
@Kind.Term(TagEntry.KIND)
public class TagEntry extends GphotoEntry<TagEntry> implements AtomData,
    TagData {

  /**
   * Tag kind term value.
   */
  public static final String KIND = Namespaces.PHOTOS_PREFIX + "tag";

  /**
   * Tag kind category.
   */
  public static final Category CATEGORY = new
      Category(com.google.gdata.util.Namespaces.gKind, KIND);

  /**
   * Default mutable constructor.
   */
  public TagEntry() {
    super();
    getCategories().add(CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public TagEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(TagEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(TagEntry.class, GphotoWeight.class);
  }

  /**
   * Returns the weight of the tag.
   *
   * @return weight of the tag
   */
  public GphotoWeight getWeightExt() {
    return getExtension(GphotoWeight.class);
  }

  /**
   * Sets the weight of the tag.
   *
   * @param weightExt weight of the tag or <code>null</code> to reset
   */
  public void setWeightExt(GphotoWeight weightExt) {
    if (weightExt == null) {
      removeExtension(GphotoWeight.class);
    } else {
      setExtension(weightExt);
    }
  }

  /**
   * Returns whether it has the weight of the tag.
   *
   * @return whether it has the weight of the tag
   */
  public boolean hasWeightExt() {
    return hasExtension(GphotoWeight.class);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{TagEntry " + super.toString() + "}";
  }


  /**
   * @throws ParseException for backwards compatibility
   */
  public Integer getWeight() throws ParseException {
    GphotoWeight ext = getWeightExt();
    return ext == null ? null : ext.getValue();
  }

  public void setWeight(Integer weight) {
    GphotoWeight ext = weight == null ? null : new GphotoWeight(weight);
    setWeightExt(ext);
  }
}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.analytics;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.ExtensionProfile;

/**
 * Entry element for variation feed.
 *
 * 
 */
public class VariationEntry extends BaseEntry<VariationEntry> {

  /**
   * Default mutable constructor.
   */
  public VariationEntry() {
    super();
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public VariationEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(VariationEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(VariationEntry.class, GwoExperimentId.class);
    extProfile.declare(VariationEntry.class, GwoSectionId.class);
    extProfile.declare(VariationEntry.class, GwoVariationId.class);
  }

  /**
   * Returns the experiment ID.
   *
   * @return experiment ID
   */
  public GwoExperimentId getExperimentId() {
    return getExtension(GwoExperimentId.class);
  }

  /**
   * Sets the experiment ID.
   *
   * @param experimentId experiment ID or <code>null</code> to reset
   */
  public void setExperimentId(GwoExperimentId experimentId) {
    if (experimentId == null) {
      removeExtension(GwoExperimentId.class);
    } else {
      setExtension(experimentId);
    }
  }

  /**
   * Returns whether it has the experiment ID.
   *
   * @return whether it has the experiment ID
   */
  public boolean hasExperimentId() {
    return hasExtension(GwoExperimentId.class);
  }

  /**
   * Returns the section ID.
   *
   * @return section ID
   */
  public GwoSectionId getSectionId() {
    return getExtension(GwoSectionId.class);
  }

  /**
   * Sets the section ID.
   *
   * @param sectionId section ID or <code>null</code> to reset
   */
  public void setSectionId(GwoSectionId sectionId) {
    if (sectionId == null) {
      removeExtension(GwoSectionId.class);
    } else {
      setExtension(sectionId);
    }
  }

  /**
   * Returns whether it has the section ID.
   *
   * @return whether it has the section ID
   */
  public boolean hasSectionId() {
    return hasExtension(GwoSectionId.class);
  }

  /**
   * Returns the variation ID.
   *
   * @return variation ID
   */
  public GwoVariationId getVariationId() {
    return getExtension(GwoVariationId.class);
  }

  /**
   * Sets the variation ID.
   *
   * @param variationId variation ID or <code>null</code> to reset
   */
  public void setVariationId(GwoVariationId variationId) {
    if (variationId == null) {
      removeExtension(GwoVariationId.class);
    } else {
      setExtension(variationId);
    }
  }

  /**
   * Returns whether it has the variation ID.
   *
   * @return whether it has the variation ID
   */
  public boolean hasVariationId() {
    return hasExtension(GwoVariationId.class);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{VariationEntry " + super.toString() + "}";
  }

}


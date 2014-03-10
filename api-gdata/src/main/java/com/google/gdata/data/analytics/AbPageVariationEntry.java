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
 * Entry element for abpagevariation feed.
 *
 * 
 */
public class AbPageVariationEntry extends BaseEntry<AbPageVariationEntry> {

  /**
   * Default mutable constructor.
   */
  public AbPageVariationEntry() {
    super();
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public AbPageVariationEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(AbPageVariationEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(AbPageVariationEntry.class, GwoAbPageVariationId.class);
    extProfile.declare(AbPageVariationEntry.class, GwoExperimentId.class);
  }

  /**
   * Returns the A/B experiment page variation ID.
   *
   * @return A/B experiment page variation ID
   */
  public GwoAbPageVariationId getAbPageVariationId() {
    return getExtension(GwoAbPageVariationId.class);
  }

  /**
   * Sets the A/B experiment page variation ID.
   *
   * @param abPageVariationId A/B experiment page variation ID or
   *     <code>null</code> to reset
   */
  public void setAbPageVariationId(GwoAbPageVariationId abPageVariationId) {
    if (abPageVariationId == null) {
      removeExtension(GwoAbPageVariationId.class);
    } else {
      setExtension(abPageVariationId);
    }
  }

  /**
   * Returns whether it has the A/B experiment page variation ID.
   *
   * @return whether it has the A/B experiment page variation ID
   */
  public boolean hasAbPageVariationId() {
    return hasExtension(GwoAbPageVariationId.class);
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

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{AbPageVariationEntry " + super.toString() + "}";
  }

}


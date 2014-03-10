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
 * Entry element for combination feed.
 *
 * 
 */
public class CombinationEntry extends BaseEntry<CombinationEntry> {

  /**
   * Default mutable constructor.
   */
  public CombinationEntry() {
    super();
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public CombinationEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(CombinationEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(CombinationEntry.class, GwoComboActive.class);
    extProfile.declare(CombinationEntry.class, GwoComboId.class);
    extProfile.declare(CombinationEntry.class, GwoComboString.class);
    extProfile.declare(CombinationEntry.class, GwoExperimentId.class);
  }

  /**
   * Returns the flag indicating if the combination is active.
   *
   * @return flag indicating if the combination is active
   */
  public GwoComboActive getComboActive() {
    return getExtension(GwoComboActive.class);
  }

  /**
   * Sets the flag indicating if the combination is active.
   *
   * @param comboActive flag indicating if the combination is active or
   *     <code>null</code> to reset
   */
  public void setComboActive(GwoComboActive comboActive) {
    if (comboActive == null) {
      removeExtension(GwoComboActive.class);
    } else {
      setExtension(comboActive);
    }
  }

  /**
   * Returns whether it has the flag indicating if the combination is active.
   *
   * @return whether it has the flag indicating if the combination is active
   */
  public boolean hasComboActive() {
    return hasExtension(GwoComboActive.class);
  }

  /**
   * Returns the combination ID.
   *
   * @return combination ID
   */
  public GwoComboId getComboId() {
    return getExtension(GwoComboId.class);
  }

  /**
   * Sets the combination ID.
   *
   * @param comboId combination ID or <code>null</code> to reset
   */
  public void setComboId(GwoComboId comboId) {
    if (comboId == null) {
      removeExtension(GwoComboId.class);
    } else {
      setExtension(comboId);
    }
  }

  /**
   * Returns whether it has the combination ID.
   *
   * @return whether it has the combination ID
   */
  public boolean hasComboId() {
    return hasExtension(GwoComboId.class);
  }

  /**
   * Returns the string that specifies a combination in an experiment.
   *
   * @return string that specifies a combination in an experiment
   */
  public GwoComboString getComboString() {
    return getExtension(GwoComboString.class);
  }

  /**
   * Sets the string that specifies a combination in an experiment.
   *
   * @param comboString string that specifies a combination in an experiment or
   *     <code>null</code> to reset
   */
  public void setComboString(GwoComboString comboString) {
    if (comboString == null) {
      removeExtension(GwoComboString.class);
    } else {
      setExtension(comboString);
    }
  }

  /**
   * Returns whether it has the string that specifies a combination in an
   * experiment.
   *
   * @return whether it has the string that specifies a combination in an
   *     experiment
   */
  public boolean hasComboString() {
    return hasExtension(GwoComboString.class);
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
    return "{CombinationEntry " + super.toString() + "}";
  }

}


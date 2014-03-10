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
 * Entry element for section feed.
 *
 * 
 */
public class SectionEntry extends BaseEntry<SectionEntry> {

  /**
   * Default mutable constructor.
   */
  public SectionEntry() {
    super();
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public SectionEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(SectionEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(SectionEntry.class, GwoExperimentId.class);
    extProfile.declare(SectionEntry.class, GwoNumVariations.class);
    extProfile.declare(SectionEntry.class, GwoSectionBeginScript.class);
    extProfile.declare(SectionEntry.class, GwoSectionEndScript.class);
    extProfile.declare(SectionEntry.class, GwoSectionId.class);
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
   * Returns the number of section variations.
   *
   * @return number of section variations
   */
  public GwoNumVariations getNumVariations() {
    return getExtension(GwoNumVariations.class);
  }

  /**
   * Sets the number of section variations.
   *
   * @param numVariations number of section variations or <code>null</code> to
   *     reset
   */
  public void setNumVariations(GwoNumVariations numVariations) {
    if (numVariations == null) {
      removeExtension(GwoNumVariations.class);
    } else {
      setExtension(numVariations);
    }
  }

  /**
   * Returns whether it has the number of section variations.
   *
   * @return whether it has the number of section variations
   */
  public boolean hasNumVariations() {
    return hasExtension(GwoNumVariations.class);
  }

  /**
   * Returns the script snippet to mark the beginning of a section.
   *
   * @return script snippet to mark the beginning of a section
   */
  public GwoSectionBeginScript getSectionBeginScript() {
    return getExtension(GwoSectionBeginScript.class);
  }

  /**
   * Sets the script snippet to mark the beginning of a section.
   *
   * @param sectionBeginScript script snippet to mark the beginning of a section
   *     or <code>null</code> to reset
   */
  public void setSectionBeginScript(GwoSectionBeginScript sectionBeginScript) {
    if (sectionBeginScript == null) {
      removeExtension(GwoSectionBeginScript.class);
    } else {
      setExtension(sectionBeginScript);
    }
  }

  /**
   * Returns whether it has the script snippet to mark the beginning of a
   * section.
   *
   * @return whether it has the script snippet to mark the beginning of a
   *     section
   */
  public boolean hasSectionBeginScript() {
    return hasExtension(GwoSectionBeginScript.class);
  }

  /**
   * Returns the script snippet to mark the end of a section.
   *
   * @return script snippet to mark the end of a section
   */
  public GwoSectionEndScript getSectionEndScript() {
    return getExtension(GwoSectionEndScript.class);
  }

  /**
   * Sets the script snippet to mark the end of a section.
   *
   * @param sectionEndScript script snippet to mark the end of a section or
   *     <code>null</code> to reset
   */
  public void setSectionEndScript(GwoSectionEndScript sectionEndScript) {
    if (sectionEndScript == null) {
      removeExtension(GwoSectionEndScript.class);
    } else {
      setExtension(sectionEndScript);
    }
  }

  /**
   * Returns whether it has the script snippet to mark the end of a section.
   *
   * @return whether it has the script snippet to mark the end of a section
   */
  public boolean hasSectionEndScript() {
    return hasExtension(GwoSectionEndScript.class);
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

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{SectionEntry " + super.toString() + "}";
  }

}


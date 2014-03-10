/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.docs;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;

/**
 * A rate limited or restricted feature.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = DocsNamespace.DOCS_ALIAS,
    nsUri = DocsNamespace.DOCS,
    localName = Feature.XML_NAME)
public class Feature extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "feature";

  /**
   * Default mutable constructor.
   */
  public Feature() {
    super();
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(Feature.class)) {
      return;
    }
    extProfile.declare(Feature.class, FeatureName.getDefaultDescription(true,
        false));
    extProfile.declare(Feature.class, FeatureRate.class);
  }

  /**
   * Returns the feature name.
   *
   * @return feature name
   */
  public FeatureName getFeatureName() {
    return getExtension(FeatureName.class);
  }

  /**
   * Sets the feature name.
   *
   * @param featureName feature name or <code>null</code> to reset
   */
  public void setFeatureName(FeatureName featureName) {
    if (featureName == null) {
      removeExtension(FeatureName.class);
    } else {
      setExtension(featureName);
    }
  }

  /**
   * Returns whether it has the feature name.
   *
   * @return whether it has the feature name
   */
  public boolean hasFeatureName() {
    return hasExtension(FeatureName.class);
  }

  /**
   * Returns the feature rate.
   *
   * @return feature rate
   */
  public FeatureRate getFeatureRate() {
    return getExtension(FeatureRate.class);
  }

  /**
   * Sets the feature rate.
   *
   * @param featureRate feature rate or <code>null</code> to reset
   */
  public void setFeatureRate(FeatureRate featureRate) {
    if (featureRate == null) {
      removeExtension(FeatureRate.class);
    } else {
      setExtension(featureRate);
    }
  }

  /**
   * Returns whether it has the feature rate.
   *
   * @return whether it has the feature rate
   */
  public boolean hasFeatureRate() {
    return hasExtension(FeatureRate.class);
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
        ExtensionDescription.getDefaultDescription(Feature.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{Feature}";
  }

}


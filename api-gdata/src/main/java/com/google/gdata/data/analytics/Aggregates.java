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

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;

import java.util.List;

/**
 * Describes an aggregates.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = AnalyticsNamespace.DXP_ALIAS,
    nsUri = AnalyticsNamespace.DXP,
    localName = Aggregates.XML_NAME)
public class Aggregates extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "aggregates";

  /**
   * Default mutable constructor.
   */
  public Aggregates() {
    super();
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(Aggregates.class)) {
      return;
    }
    extProfile.declare(Aggregates.class, Metric.getDefaultDescription(false,
        true));
  }

  /**
   * Returns the metrics.
   *
   * @return metrics
   */
  public List<Metric> getMetrics() {
    return getRepeatingExtension(Metric.class);
  }

  /**
   * Adds a new metric.
   *
   * @param metric metric
   */
  public void addMetric(Metric metric) {
    getMetrics().add(metric);
  }

  /**
   * Returns whether it has the metrics.
   *
   * @return whether it has the metrics
   */
  public boolean hasMetrics() {
    return hasRepeatingExtension(Metric.class);
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
        ExtensionDescription.getDefaultDescription(Aggregates.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{Aggregates}";
  }

}


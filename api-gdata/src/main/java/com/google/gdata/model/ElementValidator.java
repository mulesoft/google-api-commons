/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model;

/**
 * The ElementValidator interface defines the model for verifying that
 * element state is valid.
 */
public interface ElementValidator {

  /**
   * Validate the target element using the specified validation context.
   *
   * @param vc validation context.
   * @param e element to be validated.
   * @param metadata the metadata the element is being validated against.
   */
  public void validate(ValidationContext vc, Element e,
      ElementMetadata<?, ?> metadata);
}

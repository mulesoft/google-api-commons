/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.gdata.wireformats.input;

import com.google.gdata.wireformats.StreamProperties;

/**
 * The InputProperties interface represents properties of a input data being
 * parsed.
 *
 * @see InputParser
 */
public interface InputProperties extends StreamProperties {
  
  /**
   * Returns the expected root type that will be produced as a result of parsing
   * the content.   The parse result will be of this type or a subtype that
   * extends or implements the root type.
   */
  public Class<?> getRootType();
}

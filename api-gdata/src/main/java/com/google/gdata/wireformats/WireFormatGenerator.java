/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.wireformats;

import com.google.gdata.model.Element;

import java.io.IOException;

/**
 * A generator that translates an in-memory representation
 * into wire content.
 */
public interface WireFormatGenerator {

  /**
   * Generate wire content for tree rooted at {@code root}.
   *
   * @param root root of tree
   * @throws IOException if content generation failed
   * @throws ContentValidationException if content fails metadata validation
   */
  public void generate(Element root) throws IOException,
      ContentValidationException;
}

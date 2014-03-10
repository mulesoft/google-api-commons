/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.wireformats.output;

import com.google.gdata.model.Element;

import java.io.IOException;
import java.io.Writer;

/**
 * A bridge between old and new data models for output generators.
 * 
 * 
 * 
 * @param <T> expected source object type
 */
public abstract class DualModeGenerator<T> 
    extends WireFormatOutputGenerator<T> {

  private final CharacterGenerator<T> oldGen;
  
  protected DualModeGenerator(CharacterGenerator<T> oldGen) {
    this.oldGen = oldGen;
  }

  @Override
  public void generate(Writer contentWriter, OutputProperties outProps,
      T source) throws IOException {
    if (isNewModel(source)) {
      super.generate(contentWriter, outProps, source);
    } else {
      oldGen.generate(contentWriter, outProps, source);
    }
  }
  
  /**
   * Returns true if the response contains data in the new data model.
   */
  private boolean isNewModel(T source) {
    return source instanceof Element; 
  }
}

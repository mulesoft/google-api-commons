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

import com.google.gdata.wireformats.AltFormat;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Interface for generating GData output.
 * 
 * 
 * 
 * 
 * @param <S> source data type that will be used as the input to the generator
 */
public interface OutputGenerator<S> {
  
  /**
   * Returns the alternate representation format produced the generator.
   */
  public AltFormat getAltFormat();
  
  /**
   * Returns the {@link Class} that represents the expected source data type for
   * output generation.
   */
  public Class<S> getSourceType();
  
  /**
   * Generates content to the output stream based upon the provided
   * request/response.
   *
   * @param contentStream the target stream for content generation.
   * @param outProps output properties for the generated output
   * @param source source object for output generation
   */
  public void generate(OutputStream contentStream, OutputProperties outProps,
      S source) throws IOException;
}

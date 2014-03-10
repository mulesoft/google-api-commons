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

import com.google.gdata.wireformats.StreamPropertiesBuilder;

/**
 * The OutputPropertiesBuilder class is a builder class that aids in the
 * construction of new {@link OutputProperties} instances.
 * 
 * 
 */
public class OutputPropertiesBuilder 
    extends StreamPropertiesBuilder<OutputPropertiesBuilder> {

  /**
   * Constructs a new OutputPropertiesBuilder with no properties set.
   */
  public OutputPropertiesBuilder() {
  }

  /**
   * Constructs a new OutputPropertiesBuilder with properties set from an
   * existing {@link OutputProperties} instance.
   * 
   * @param source output properties instance to copy from
   */
  public OutputPropertiesBuilder(OutputProperties source) {
    super(source);
  }
  
  /**
   * Returns a new {@link OutputProperties} instance initialized with the
   * property values set on the builder.
   */
  public OutputProperties build() {
    return new OutputPropertiesImpl(this);
  }
  /**
   * The OutputPropertiesImpl class is a simple immutable value object that
   * implements the {@link OutputProperties} interface.
   */
  private static class OutputPropertiesImpl extends StreamPropertiesImpl 
      implements OutputProperties {
    
    /**
     * Constructs a new OutputPropertiesImpl instance with the property values
     * from a builder.
     * 
     * @param builder builder instnace
     */
    private OutputPropertiesImpl(OutputPropertiesBuilder builder) {
      super(builder);
    }
  }
}

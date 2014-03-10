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
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.wireformats.ContentValidationException;
import com.google.gdata.wireformats.WireFormat;
import com.google.gdata.wireformats.WireFormatGenerator;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 * An {@link OutputGenerator} using a {@link WireFormat} to serialize to the
 * output stream.
 *
 * @param <T> the expected object type handled by the generator
 *
 * 
 */
public abstract class WireFormatOutputGenerator<T>
    extends CharacterGenerator<T> {

  /**
   * Returns the wire format to use when generating this output.
   */
  public abstract WireFormat getWireFormat();

  /**
   * Generates content to the writer based upon the provided request/response.
   */
  @Override
  public void generate(Writer w, OutputProperties outProps, T source)
      throws IOException {

    // Only types that extends Element are supported by the wire format code
    if (source instanceof Element) {
      Element elem = (Element) source;
      try {
        ElementMetadata<?, ?> outputMetadata = outProps.getRootMetadata();
        if (outputMetadata == null) {
          throw new IllegalStateException("No metadata for " + 
              elem.getElementKey());
        }
        elem = elem.resolve(outputMetadata);
        
        // The outputMetadata in the properties could be for a base type that
        // is broader than the element passed in.  In this case, we want to
        // re-bind to the more specific metadata and use that in the output
        // properties passed to generate.
        if (!elem.getElementKey().equals(outputMetadata.getKey())) {
          outputMetadata = 
            outputMetadata.getSchema().bind(elem.getElementKey(),
                outputMetadata.getContext());
          if (outputMetadata == null) {
            throw new IllegalStateException("Unable to rebind from " +
                outProps.getRootMetadata().getKey() + " to " +
                elem.getElementKey());
          }
          outProps = 
            new OutputPropertiesBuilder(outProps)
                .setElementMetadata(outputMetadata)
                .build();            
        }
        
        WireFormat wireFormat = getWireFormat();
        String encoding = getCharsetEncoding(outProps);
        Charset cs = Charset.forName(encoding);
        WireFormatGenerator gen = wireFormat.createGenerator(
            outProps, w, cs, usePrettyPrint(outProps));
        
        gen.generate(elem);
      } catch (ContentValidationException e) {
        throw new IOException("Invalid content: " + e.getMessage());
      }
      w.flush();
    } else {
      throw new IllegalArgumentException("Output object was not an Element: " +
          source);
    }
  }
}


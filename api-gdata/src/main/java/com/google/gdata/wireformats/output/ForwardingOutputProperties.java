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

import com.google.gdata.wireformats.ForwardingStreamProperties;

/**
 * A {@link OutputProperties} implementation that forwards all
 * calls to another {@link OutputProperties}.
 *
 * <p>Subclass this and override the methods you want modified
 * to create a wrapper for {@link OutputProperties}.
 *
 * 
 */
public class ForwardingOutputProperties extends ForwardingStreamProperties
    implements OutputProperties {
  public ForwardingOutputProperties(OutputProperties delegate) {
    super(delegate);
  }
}

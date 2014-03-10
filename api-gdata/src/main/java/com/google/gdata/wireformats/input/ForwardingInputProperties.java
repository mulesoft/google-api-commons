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

import com.google.gdata.wireformats.ForwardingStreamProperties;

/**
 * A {@link InputProperties} implementation that forwards all
 * calls to another {@link InputProperties}.
 *
 * <p>Subclass this and override the methods you want modified
 * to create a wrapper for {@link InputProperties}.
 *
 * 
 */
public class ForwardingInputProperties extends ForwardingStreamProperties 
    implements InputProperties { 
  private final InputProperties delegate;

  public ForwardingInputProperties(InputProperties delegate) {
    super(delegate);
    this.delegate = delegate;
  }
  
  public Class<?> getRootType() {
    return delegate.getRootType();
  }
}

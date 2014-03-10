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

import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.util.ContentType;

import java.util.Collection;

/**
 * A {@link StreamProperties} implementation that forwards all
 * calls to another {@link StreamProperties}.
 *
 * <p>Subclass this and override the methods you want modified
 * to create a wrapper for {@link StreamProperties}.
 *
 * 
 */
public class ForwardingStreamProperties implements StreamProperties {
  private final StreamProperties delegate;

  public ForwardingStreamProperties(StreamProperties delegate) {
    Preconditions.checkNotNull(delegate, "delegate");

    this.delegate = delegate;
  }

  public ContentType getContentType() {
    return delegate.getContentType();
  }

  public Collection<String> getQueryParameterNames() {
    return delegate.getQueryParameterNames();
  }

  public String getQueryParameter(String name) {
    return delegate.getQueryParameter(name);
  }

  public ExtensionProfile getExtensionProfile() {
    return delegate.getExtensionProfile();
  }

  public AltRegistry getAltRegistry() {
    return delegate.getAltRegistry();
  }

  public ElementMetadata<?, ?> getRootMetadata() {
    return delegate.getRootMetadata();
  }
}

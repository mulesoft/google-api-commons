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

import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.MetadataContext;
import com.google.gdata.util.ContentType;

import java.util.Collection;

/**
 * The StreamProperties interface defines the common set of properties for
 * input or output data streams that are being used to consume/produce data.
 */
public interface StreamProperties {

  /**
   * Returns the MIME content type of data on the stream.
   *
   * @return data content type
   */
  public ContentType getContentType();

  /**
   * Returns a {@link Collection} that contains the name of all query parameters
   * found in the request.
   */
  public Collection<String> getQueryParameterNames();

  /**
   * Returns the value of a request query parameter by name or {@code null}
   * if not found.
   */
  public String getQueryParameter(String name);

  /**
   * Returns the {@link ExtensionProfile} associated with the stream.
   *
   * @return extension profile or {@code null} for requests that use the
   * data model classes in com.google.gdata.model.
   */
  public ExtensionProfile getExtensionProfile();

  /**
   * Returns the {@link AltRegistry} that contains the set of supported
   * representations and the parser/generator configuration for them.
   */
  public AltRegistry getAltRegistry();
  
  /**
   * Returns the {@link ElementMetadata} for the root object that is being
   * read from or written to the stream.  This metadata will already be
   * bound to the appropriate {@link MetadataContext} for the currently
   * executing request.
   */
  public ElementMetadata<?, ?> getRootMetadata();
}

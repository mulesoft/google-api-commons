/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data;

import com.google.gdata.util.ContentType;

/**
 * Shared interface for OutOfLineContent implementations.
 * 
 * 
 */
public interface IOutOfLineContent extends IContent {

  /** Returns the MIME content type. */
  public ContentType getMimeType();

  /** Returns the external URI. */
  public String getUri();

  /**
   * Returns the HTTP etag for the referenced content or {@code null} if
   * none.
   */
  public String getEtag();
}

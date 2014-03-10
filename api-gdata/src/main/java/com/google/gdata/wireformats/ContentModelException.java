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

import com.google.gdata.util.ServiceException;

/**
 * The ContentModelException indicates that a content model
 * is incompatible with request content being generated or
 * parsed.
 */
public class ContentModelException extends ServiceException {

  public ContentModelException(String message) {
    super(message);
  }

  public ContentModelException(String message, Throwable cause) {
    super(message, cause);
  }

  public ContentModelException(Throwable cause) {
    super(cause);
  }

}

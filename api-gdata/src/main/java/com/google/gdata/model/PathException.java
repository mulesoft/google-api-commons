/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model;

/**
 * The PathException class defines a specialized type of {link RuntimeException}
 * that is thrown as a result of various exception conditions for the
 * {@link Path} class.
 *
 * 
 */
public class PathException extends RuntimeException {

  public PathException(String message) {
    super(message);
  }

  public PathException(String message, Throwable cause) {
    super(message, cause);
  }

  public PathException(Throwable cause) {
    super(cause);
  }
}

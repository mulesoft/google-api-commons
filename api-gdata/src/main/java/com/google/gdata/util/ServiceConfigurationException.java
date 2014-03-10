/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.util;

/**
 * The ServiceConfigurationException should be thrown if a GData server
 * or client configuration is not valid.
 *
 * 
 */
public class ServiceConfigurationException extends ServiceException {

  public ServiceConfigurationException(String message) {
    super(message);
  }

  public ServiceConfigurationException(String message,
      Throwable cause) {
    super(message, cause);
  }

  public ServiceConfigurationException(Throwable cause) {
    super(cause);
  }

  public ServiceConfigurationException(ErrorDomain.ErrorCode errorCode) {
    super(errorCode);
  }

  public ServiceConfigurationException(ErrorDomain.ErrorCode errorCode,
      Throwable cause) {
    super(errorCode, cause);
  }

}

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

import com.google.gdata.util.ErrorContent;
import com.google.gdata.util.ServiceException;

/**
 * The ContentCreationException indicates that content cannot
 * be created. E.g. object instantiation via reflection fails.
 */
public class ContentCreationException extends ServiceException {

  public ContentCreationException(String message) {
    super(message);
  }

  public ContentCreationException(String message, Throwable cause) {
    super(message, cause);
  }

  public ContentCreationException(Throwable cause) {
    super(cause);
  }
  
  public ContentCreationException(ErrorContent errorCode) {
    super(errorCode);
  }

  public ContentCreationException(ErrorContent errorCode, Throwable cause) {
    super(errorCode, cause);
  }
}

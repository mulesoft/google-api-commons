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

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Utility functions for logging.
 *
 * 
 */
public final class LogUtils {

  public static void logException(Logger logger,
                                  Level level,
                                  String prefix,
                                  Throwable e) {
    String message = e.toString();
    if (prefix != null) {
      message = prefix + ": " + message;
    }

    logger.log(level, message, e);
  }
}

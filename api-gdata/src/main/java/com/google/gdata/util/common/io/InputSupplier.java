/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.util.common.io;

import java.io.IOException;

/**
 * An factory for readable streams of bytes or characters.
 *
 * 
 * @param <T> the type of object being supplied
 */
public interface InputSupplier<T> {
  T getInput() throws IOException;
}

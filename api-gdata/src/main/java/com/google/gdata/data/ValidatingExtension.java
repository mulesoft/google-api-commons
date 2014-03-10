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

import com.google.gdata.util.ParseException;




/**
 * Extends the base {@link Extension} interface to enable validation
 * of extension contents.
 *
 * 
 */
public interface ValidatingExtension extends Extension {

  /**
   * Enables an extension to perform final validation after all extension
   * elements of the parent ExtensionPoint have been processed.
   *
   * @param   parent
   *            parent ExtensionPoint
   *
   * @throws  ParseException
   */
  void validate(ExtensionPoint parent) throws ParseException;
}


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

/**
 * Shared interface for text content
 * 
 * 
 */
public interface ITextContent extends IContent {

  /**
   * Returns the {@link ITextConstruct} that contains the text content.
   */
  public ITextConstruct getContent();
}

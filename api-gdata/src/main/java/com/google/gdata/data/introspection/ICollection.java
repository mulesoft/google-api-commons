/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.introspection;

import com.google.gdata.data.ITextConstruct;
import com.google.gdata.data.Reference;

import java.util.List;

/**
 * Shared Collection interface.
 * 
 * 
 */
public interface ICollection extends Reference {
  
  /**
   * Returns the title of the collection.
   */
  ITextConstruct getTitle();
  
  /**
   * Returns a list of accept values.
   */
  List<String> getAcceptList();
}

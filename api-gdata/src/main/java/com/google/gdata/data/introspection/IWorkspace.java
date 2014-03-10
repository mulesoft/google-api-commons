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

import java.util.List;

/**
 * Shared workspace interface.
 * 
 * 
 */
public interface IWorkspace {

  /**
   * Returns the collections associated with this workspace.
   */
  List<? extends ICollection> getCollections();
  
  /**
   * Add a new collection to the list of collections associated with this
   * workspace.
   */
  ICollection addCollection(String collectionUri, String title,
      String... acceptedTypes);
}

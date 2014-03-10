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
 * Shared service document interface.
 * 
 * 
 */
public interface IServiceDocument {

  /**
   * Returns the workspaces associated with this service.
   */
  List<? extends IWorkspace> getWorkspaces();
  
  /**
   * Add a new workspace to the service document, returning the newly created
   * workspace to the caller.
   */
  IWorkspace addWorkspace(String title);
}

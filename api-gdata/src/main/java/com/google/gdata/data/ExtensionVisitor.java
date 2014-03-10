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
 * The ExtensionVisitor interface describes the implementation of a visitor
 * pattern for GData data model processing.
 * 
 * @see ExtensionPoint#visit(ExtensionVisitor, ExtensionPoint)
 */
public interface ExtensionVisitor {
  
  /**
   * The StoppedException is thrown by ExtensionVisitor instances to
   * immediately exit from extension tree processing.   The is a runtime
   * exception because the common case is that traversal will run to
   * completion and stopping is considered an abnormal termination.
   * <p>
   * Specific ExtensionVisitor implementations may define sub-types to signal
   * specific exit conditions, in which case code that uses this type of visitor
   * may want to catch a service the stop conditions if they are expected and
   * convey useful information.
   */
  public static class StoppedException extends RuntimeException {

    public StoppedException(String message, Throwable cause) {
      super(message, cause);
    }

    public StoppedException(String message) {
      super(message);
    }

    public StoppedException(Throwable cause) {
      super(cause);
    }  
  }

  /**
   * Called during ExtensionPoint tree traversal to allow the visitor instance
   * to process an extension in the tree.
   *
   * @param parent the parent of the visited extension.
   * @param extension the target extension being visited.
   * @return boolean value indicating whether child extensions (if any) should
   * be visited.
   * @throws StoppedException if the data model traversal should be stopped
   * immediately.  This may be the result of an unexpected error, or some
   * visitor implementations may extend this exception type to signal
   * specific exit conditions.
   */
  public boolean visit(ExtensionPoint parent, Extension extension)
      throws StoppedException ;

  /**
   * The visitComplete method is called when traversal for an ExtensionPoint
   * and all of its nested children has been completed.
   *
   * @param target the visited extension point
   * @throws StoppedException if the data model traversal should be stopped
   * immediately.  This may be the result of an unexpected error, or some
   * visitor implementations may extend this exception type to signal
   * specific exit conditions.
   */
  public void visitComplete(ExtensionPoint target) throws StoppedException;
}

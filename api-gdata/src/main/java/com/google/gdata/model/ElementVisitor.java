/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model;

/**
 * The ElementVisitor interface describes the implementation of a visitor
 * pattern for GData data model processing.
 *
 * @see Element#visit(ElementVisitor, ElementMetadata)
 */
public interface ElementVisitor {

  /**
   * The StoppedException is thrown by ElementVisitor instances to
   * immediately exit from element tree processing.   The is a runtime
   * exception because the common case is that traversal will run to
   * completion and stopping is considered an abnormal termination.
   * <p>
   * Specific ElementVisitor implementations may define sub-types to signal
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
   * Called during Element tree traversal to allow the visitor instance
   * to process an element in the tree.
   *
   * @param parent the parent of the target element
   * @param target the target element being visited
   * @param metadata the metadata for the target element
   * @return boolean value indicating whether child elements (if any) should
   * be visited.
   * @throws StoppedException if the data model traversal should be stopped
   * immediately.  This may be the result of an unexpected error, or some
   * visitor implementations may extend this exception type to signal
   * specific exit conditions.
   */
  public boolean visit(Element parent, Element target,
      ElementMetadata<?, ?> metadata) throws StoppedException;

  /**
   * The visitComplete method is called when traversal for an Element
   * and all of its nested children has been completed.
   *
   * @param parent the parent of the target element
   * @param target the visited element
   * @param metadata the metadata for the target element
   * @throws StoppedException if the data model traversal should be stopped
   * immediately.  This may be the result of an unexpected error, or some
   * visitor implementations may extend this exception type to signal
   * specific exit conditions.
   */
  public void visitComplete(Element parent, Element target,
      ElementMetadata<?, ?> metadata) throws StoppedException;
}

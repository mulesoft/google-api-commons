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

import com.google.gdata.model.ElementMetadata.MultipleVirtualElement;
import com.google.gdata.model.ElementMetadata.SingleVirtualElement;
import com.google.gdata.model.PathAdapter.ElementAdapter;

/**
 * An element that contains either a {@link SingleVirtualElement} or a {@link
 * MultipleVirtualElement}.
 *
 * <p>This class is useful when the two different virtual element interfaces
 * need to be treated as one field, since they're mutually exclusive.
 * 
 * <p>This class is also used to hold a path-based adapter, which sets both
 * the single and multiple elements to the same adapter, since we don't know
 * when building it if the path represents a single or multiple cardinality
 * element.
 *
 * 
 */
class VirtualElementHolder {
  private final SingleVirtualElement single;
  private final MultipleVirtualElement multiple;

  /**
   * Creates a holder for a single virtual element, returns {@code null} if the
   * virtual element is {@code null}.
   */
  static VirtualElementHolder of(SingleVirtualElement single) {
    if (single == null) {
      return null;
    }
    return new VirtualElementHolder(single, null);
  }

  /**
   * Creates a holder for a multiple virtual element, returns {@code null} if
   * the virtual element is {@code null}.
   */
  static VirtualElementHolder of(MultipleVirtualElement multiple) {
    if (multiple == null) {
      return null;
    }
    return new VirtualElementHolder(null, multiple);
  }
  
  /**
   * Creates a holder for a virtual element based on a path.  Because we don't
   * know if the path is to a single or multiple cardinality element until
   * runtime, we create a single adapter that can be either and rely on the
   * runtime checks in the metadata to make sure we use it correctly.
   */
  static VirtualElementHolder of(Path path) {
    if (path == null) {
      return null;
    }
    ElementAdapter adapter = PathAdapter.elementAdapter(path);
    return new VirtualElementHolder(adapter, adapter);
  }

  private VirtualElementHolder(SingleVirtualElement single, 
      MultipleVirtualElement multiple) {
    this.single = single;
    this.multiple = multiple;
  }

  /** Returns a {@link SingleVirtualElement} or {@code null}. */
  SingleVirtualElement getSingleVirtualElement() {
    return single;
  }

  /** Returns a {@link SingleVirtualElement} or {@code null}. */
  MultipleVirtualElement getMultipleVirtualElement() {
    return multiple;
  }
}

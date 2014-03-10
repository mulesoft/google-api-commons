/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model.atom;

import com.google.gdata.model.Element;
import com.google.gdata.model.gd.GdAttributes;
import com.google.gdata.util.Namespaces;

/**
 * The Kind class contains constants and static helper methods related to
 * GData kind processing 
 *
 * 
 */
class Kinds {
  
  /**
   * Returns the GData kind of a target entity by checking for the 
   * {@code gd:kind} attribute or a kind {@link Category} element.   If both
   * are present, the kind attribute value will have precedence and be returned.
   * 
   * @param source source feed or entry element to check
   * @return kind value or {@code null} if no kind information is found.
   */
  static String getElementKind(Element source) {
    String term = source.getAttributeValue(GdAttributes.KIND);
    if (term != null) {
      return term;
    }
    for (Category category : source.getElements(Category.KEY)) {
      if (Namespaces.gKind.equals(category.getScheme())) {
        return category.getTerm();
      }
    }
    return null;
  }
  
  // Not instantiable
  private Kinds() {}
}

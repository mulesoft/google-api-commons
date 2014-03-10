/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.gdata.data.extensions;

import com.google.gdata.util.Namespaces;
import com.google.gdata.data.Category;

/**
 * A utility aggregating gdata common data entry labels
 *
 * 
 */
public final class Labels {

  private Labels() {
    // utility class
  }

  /** Google data labeling namespace */
  private static final String gLabels = Namespaces.g + "/labels";

  private static Category newLabel(String termAndLabel) {
    return new Category(gLabels, gLabels + "#" + termAndLabel, termAndLabel);
  }

  /** Common category for a starred item */
  public static final Category STARRED = newLabel("starred");

  /** Common category for a trashed item */
  public static final Category TRASHED = newLabel("trashed");

  /** Common category for a published item */
  public static final Category PUBLISHED = newLabel("published");

  /** Common category for a private item */
  public static final Category PRIVATE = newLabel("private");

  /** Common category for an item owned by the current user */
  public static final Category MINE = newLabel("mine");

  /** Common category for an item shared with the domain */
  public static final Category SHARED_WITH_DOMAIN =
      newLabel("shared-with-domain");

  /** Common category for a hidden item */
  public static final Category HIDDEN = newLabel("hidden");
  
  /** Common category for a viewed item */
  public static final Category VIEWED = newLabel("viewed");
  
  /** Common category for an item with restricted downloading */
  public static final Category RESTRICTED_DOWNLOAD = newLabel("restricted-download");
}

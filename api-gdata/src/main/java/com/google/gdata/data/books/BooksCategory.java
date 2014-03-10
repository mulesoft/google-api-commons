/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.books;

import com.google.gdata.util.Namespaces;

/**
 * Describes a books category.
 *
 * 
 */
public class BooksCategory {

  /** Scheme (domain). */
  public static final class Scheme {

    /** Kind books category. */
    public static final String KIND = Namespaces.gPrefix + "kind";

    /** Http://schemas google com/books/2008/labels books category. */
    public static final String LABELS_SCHEME =
        "http://schemas.google.com/books/2008/labels";

  }

  /** Private constructor to ensure class is not instantiated. */
  private BooksCategory() {}

}

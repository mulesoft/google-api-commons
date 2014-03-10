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

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * GData namespace definitions related to Google Book Search.
 *
 * 
 */
public class BooksNamespace {

  private BooksNamespace() {}

  /** Google Book Search (GBS) namespace */
  public static final String GBS = "http://schemas.google.com/books/2008";

  /** Google Book Search (GBS) namespace prefix */
  public static final String GBS_PREFIX = GBS + "#";

  /** Google Book Search (GBS) namespace alias */
  public static final String GBS_ALIAS = "gbs";

  /** XML writer namespace for Google Book Search (GBS) */
  public static final XmlNamespace GBS_NS = new XmlNamespace(GBS_ALIAS, GBS);

}

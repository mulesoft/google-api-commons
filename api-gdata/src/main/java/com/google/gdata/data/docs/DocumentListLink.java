/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.docs;

/**
 * Describes a document list link.
 *
 * 
 */
public class DocumentListLink {

  /** Link relation type. */
  public static final class Rel {

    /** Link for the zip file contains all exported documents. */
    public static final String EXPORT = DocsNamespace.DOCS_PREFIX + "export";

    /** Link for the parent folder entry. */
    public static final String PARENT = DocsNamespace.DOCS_PREFIX + "parent";

    /** Link for the feed of a spreadsheet's tables. */
    public static final String TABLES_FEED =
        "http://schemas.google.com/spreadsheets/2006#tablesfeed";

    /** Link for the feed of a spreadsheet's worksheets. */
    public static final String WORKSHEETS_FEED =
        "http://schemas.google.com/spreadsheets/2006#worksheetsfeed";

  }

  /** MIME type of link target. */
  public static final class Type {

    /** Type for the zip file. */
    public static final String APPLICATION_ZIP = "application/zip";

  }

  /** Private constructor to ensure class is not instantiated. */
  private DocumentListLink() {}

}


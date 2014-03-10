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

/**
 * Extends the base Link class with Books extensions.
 *
 * 
 */
public class BooksLink {

  /** Link relation type. */
  public static final class Rel {

    /** Annotation link to submit review, rating, labels. */
    public static final String ANNOTATION =
        "http://schemas.google.com/books/2008/annotation";

    /** Epub download link. */
    public static final String EPUBDOWNLOAD =
        "http://schemas.google.com/books/2008/epubdownload";

    /** Link to a description page. */
    public static final String INFO =
        "http://schemas.google.com/books/2008/info";

    /** Link to a preview page. */
    public static final String PREVIEW =
        "http://schemas.google.com/books/2008/preview";

    /** Link that provides the URI of a thumbnail image. */
    public static final String THUMBNAIL =
        "http://schemas.google.com/books/2008/thumbnail";

  }

  /** MIME type of link target. */
  public static final class Type {

    /** Link type used for any image. */
    public static final String ANY_IMAGE = "image/x-unknown";

    /** Link type used for epub downloads. */
    public static final String EPUB = "application/epub";

    /** Link type used for JPEG images. */
    public static final String JPEG = "image/jpeg";

    /** Link type used for PNG images. */
    public static final String PNG = "image/png";

  }

  /** Private constructor to ensure class is not instantiated. */
  private BooksLink() {}

}

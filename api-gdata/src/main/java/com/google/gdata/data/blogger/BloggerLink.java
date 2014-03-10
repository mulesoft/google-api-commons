/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.blogger;

/**
 * Extends the base Link class with Blogger extensions.
 *
 * 
 */
public class BloggerLink {

  /** Link relation type. */
  public static final class Rel {

    /** Link that provides the URI of the web content. */
    public static final String REPLIES = "replies";

    /** Link to blog settings feed. */
    public static final String SETTINGS =
        "http://schemas.google.com/blogger/2008#settings";

    /** Link to blog templates feed. */
    public static final String TEMPLATE =
        "http://schemas.google.com/blogger/2008#template";

  }

  /** Private constructor to ensure class is not instantiated. */
  private BloggerLink() {}

}

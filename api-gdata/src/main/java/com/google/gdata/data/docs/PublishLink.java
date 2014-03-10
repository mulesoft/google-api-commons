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
 * Describes a publish link.
 *
 * 
 */
public class PublishLink {

  /** Link relation type. */
  public static final class Rel {

    /** Link for the publically viewable published document. */
    public static final String PUBLISH =
        "http://schemas.google.com/docs/2007#publish";

  }

  /** Private constructor to ensure class is not instantiated. */
  private PublishLink() {}

}


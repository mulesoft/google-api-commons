/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.appsforyourdomain.generic;

import com.google.gdata.data.BaseFeed;

/**
 * GData feed class that models a generic feed which simply contains a list of
 * generic entries, each have nothing more than a set of key-value pairs.
 * 
 * @see GenericEntry
 * 
 * 
 */
public class GenericFeed extends BaseFeed<GenericFeed, GenericEntry> {

  public GenericFeed() {
    super(GenericEntry.class);
  }
}

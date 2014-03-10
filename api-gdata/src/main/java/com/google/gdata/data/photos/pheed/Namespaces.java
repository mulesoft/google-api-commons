/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.photos.pheed;

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Namespaces for Pheed.  http://pheed.com/pheed
 *
 * @deprecated the pheed namespace is deprecated in favor of media rss.
 *
 * 
 */
@Deprecated
public class Namespaces {

  /** Pheed <a href="http://www.pheed.com/pheed/">pheed</a> namespace. */
  public static final XmlNamespace PHEED_NAMESPACE
      = new XmlNamespace("photo", "http://www.pheed.com/pheed/");
}

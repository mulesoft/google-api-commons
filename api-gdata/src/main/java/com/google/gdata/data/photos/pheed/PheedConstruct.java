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

import com.google.gdata.data.ValueConstruct;

/**
 * Parent class for photo:foo extensions.
 *
 * @deprecated the pheed construct is deprecated in favor of media rss.
 *
 * 
 */
@Deprecated
public abstract class PheedConstruct extends ValueConstruct {
  public PheedConstruct(String name) {
    this(name, null);
  }

  public PheedConstruct(String name, String value) {
    super(com.google.gdata.data.photos.pheed.Namespaces.PHEED_NAMESPACE, name,
        null, value);
    setRequired(false);
    
    // We support empty strings on the wire, which the default ValueConstruct
    // doesn't, so we override the default value to be empty.
    if (value == null) {
      setValue("");
    }
  }
}

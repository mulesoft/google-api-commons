/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.photos.impl;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;
import com.google.gdata.data.photos.Namespaces;

/**
 * An exif tag with a given name and value.  All exif tags are represented
 * as just a name and a string value.  This element is marked "repeatable"
 * because we allow arbitrary exif tags to be passed around.
 *
 * 
 */
public class ExifTag extends ValueConstruct {

  private final String name;

  /**
   * Construct an empty exif tag with the given name.  Used when parsing
   * the values from the client.
   */
  public ExifTag(String name) {
    this(name, null);
  }

  /**
   * Construct an exif tag of &lt;ns:name&gt;value&lt;/ns:name&gt;.
   */
  public ExifTag(String name, String value) {
    super(Namespaces.EXIF_NAMESPACE, name, null, value);
    this.name = name;
    setRequired(false);
  }

  /**
   * Get the name of this exif tag.
   */
  public String getName() {
    return name;
  }

  /**
   * Describe this tag.  Does not include the name because that is set
   * at runtime, rather than at compile time.
   */
  public static ExtensionDescription getDefaultDescription() {
    ExtensionDescription extDesc = new ExtensionDescription();
    extDesc.setRepeatable(true);
    extDesc.setExtensionClass(ExifTag.class);
    extDesc.setNamespace(Namespaces.EXIF_NAMESPACE);
    extDesc.setLocalName("*");
    return extDesc;
  }
}

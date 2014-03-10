/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.photos;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.TextConstruct;
import com.google.gdata.util.ParseException;

/**
 * Basic extension to include tag-specific data, this is the shared interface
 * for all tag objects in the Picasaweb GData api.  To view or set the actual
 * content of a tag clients should use {@link BaseEntry#getContent()} and
 * {@link BaseEntry#setContent(TextConstruct)}.
 *
 * 
 */
public interface TagData extends GphotoData {

  /** The unqualified kind for a tag. */
  public static final String KIND = "tag";

  /** The fully qualified kind term for tags. */
  public static final String TAG_KIND = Namespaces.PHOTOS_PREFIX + KIND;

  /** A category object for tags.  All tag objects will have this set. */
  public static final Category TAG_CATEGORY
      = new Category(com.google.gdata.util.Namespaces.gKind, TAG_KIND);

  /**
   * The weight of the tag is the number of times the tag appears in the
   * collection of tags currently being viewed.  This is a server-provided
   * context sensitive measure of how often the tag is used, and can be used
   * to implement tag-cloud like views.
   * 
   * @return the weight of the tag, or null if it doesn't have one.
   */
  public Integer getWeight() throws ParseException;

  /**
   * Set the weight of the tag.  Used by the server, this field is read only
   * on the client.
   */
  public void setWeight(Integer weight);
}

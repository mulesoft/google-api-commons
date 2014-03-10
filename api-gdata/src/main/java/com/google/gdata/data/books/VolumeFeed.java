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

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;
import com.google.gdata.data.Link;

/**
 * Describes a Book Search volume feed.
 *
 * 
 */
@Kind.Term(VolumeEntry.KIND)
public class VolumeFeed extends BaseFeed<VolumeFeed, VolumeEntry> {

  /**
   * Default mutable constructor.
   */
  public VolumeFeed() {
    super(VolumeEntry.class);
    getCategories().add(VolumeEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public VolumeFeed(BaseFeed<?, ?> sourceFeed) {
    super(VolumeEntry.class, sourceFeed);
  }

  /**
   * Returns the link that provides the URI of an alternate format of the
   * entry's or feed's contents.
   *
   * @return Link that provides the URI of an alternate format of the entry's or
   *     feed's contents or {@code null} for none.
   */
  public Link getAtomAlternateLink() {
    return getLink(Link.Rel.ALTERNATE, Link.Type.ATOM);
  }

  @Override
  public String toString() {
    return "{VolumeFeed " + super.toString() + "}";
  }

}

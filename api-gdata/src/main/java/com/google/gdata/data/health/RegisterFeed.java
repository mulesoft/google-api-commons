/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.health;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;
import com.google.gdata.data.Link;

/**
 * Describes a register feed.
 *
 * 
 */
@Kind.Term(RegisterEntry.KIND)
public class RegisterFeed extends BaseHealthFeed<RegisterFeed, RegisterEntry> {

  /**
   * Default mutable constructor.
   */
  public RegisterFeed() {
    super(RegisterEntry.class);
    getCategories().add(RegisterEntry.CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseFeed} instance.
   *
   * @param sourceFeed source feed
   */
  public RegisterFeed(BaseFeed<?, ?> sourceFeed) {
    super(RegisterEntry.class, sourceFeed);
  }

  /**
   * Returns the link that provides the URI that can be used to edit the entry.
   *
   * @return Link that provides the URI that can be used to edit the entry or
   *     {@code null} for none.
   */
  public Link getEditLink() {
    return getLink(Link.Rel.ENTRY_EDIT, Link.Type.ATOM);
  }

  @Override
  public String toString() {
    return "{RegisterFeed " + super.toString() + "}";
  }

}

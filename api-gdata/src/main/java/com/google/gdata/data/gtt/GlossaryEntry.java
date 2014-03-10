/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.gtt;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Link;
import com.google.gdata.data.acl.AclNamespace;
import com.google.gdata.data.media.MediaEntry;

/**
 * Describes a glossary entry.
 *
 * 
 */
public class GlossaryEntry extends MediaEntry<GlossaryEntry> {

  /**
   * Default mutable constructor.
   */
  public GlossaryEntry() {
    super();
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public GlossaryEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  /**
   * Returns the link that provides the URI of the feed for the access control
   * list for the entry.
   *
   * @return Link that provides the URI of the feed for the access control list
   *     for the entry or {@code null} for none.
   */
  public Link getAccessControlListLink() {
    return getLink(AclNamespace.LINK_REL_ACCESS_CONTROL_LIST, Link.Type.ATOM);
  }

  @Override
  public String toString() {
    return "{GlossaryEntry " + super.toString() + "}";
  }

}


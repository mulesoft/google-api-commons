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
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Link;
import com.google.gdata.data.acl.AclNamespace;
import com.google.gdata.data.media.MediaEntry;

/**
 * Describes a translation memory entry.
 *
 * 
 */
public class TranslationMemoryEntry extends MediaEntry<TranslationMemoryEntry> {

  /**
   * Default mutable constructor.
   */
  public TranslationMemoryEntry() {
    super();
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public TranslationMemoryEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(TranslationMemoryEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(TranslationMemoryEntry.class, ScopeEntry.class);
  }

  /**
   * Returns the scope entry.
   *
   * @return scope entry
   */
  public ScopeEntry getScope() {
    return getExtension(ScopeEntry.class);
  }

  /**
   * Sets the scope entry.
   *
   * @param scope scope entry or <code>null</code> to reset
   */
  public void setScope(ScopeEntry scope) {
    if (scope == null) {
      removeExtension(ScopeEntry.class);
    } else {
      setExtension(scope);
    }
  }

  /**
   * Returns whether it has the scope entry.
   *
   * @return whether it has the scope entry
   */
  public boolean hasScope() {
    return hasExtension(ScopeEntry.class);
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
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{TranslationMemoryEntry " + super.toString() + "}";
  }

}


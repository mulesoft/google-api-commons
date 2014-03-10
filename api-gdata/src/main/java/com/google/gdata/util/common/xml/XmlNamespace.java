/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.util.common.xml;

import com.google.gdata.util.common.base.Preconditions;

/**
 * Represents an XML namespace, including the associated namespace URI and an
 * optional alias prefix to use in XML output.
 * 
 * 
 */
public class XmlNamespace {

  final String alias;
  final String uri;

  /** 
   * Constructs a new namespace with the specified namespace URI and no defined
   * prefix alias. 
   */
  public XmlNamespace(String uri) {
    this(null, uri);
  }
  
  /** 
   * Constructs a new namespace with the specified prefix alias and namespace
   * URI. 
   */
  public XmlNamespace(String alias, String uri) {
    Preconditions.checkNotNull(uri, "Null namespace URI");
    this.alias = alias;
    this.uri = uri;
  }

  /**
   * Returns the prefix alias for the namespace or {@code null} if undefined.
   * @returns namespace alias.
   */
  public final String getAlias() { return alias; }

  /**
   * Returns the fully qualified URI for the namespace.
   * @returns namespace URI
   */
  public final String getUri() { return uri; }

  /**
   * Returns true if the target object is a Namespace instance that has a
   * matching namespace URI and prefix (if specified).
   */
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof XmlNamespace)) {
      return false;
    }
    XmlNamespace other = (XmlNamespace) obj;
    if (alias == null) {
      return (other.alias == null) && uri.equals(other.uri);
    } else {
      return alias.equals(other.alias) && uri.equals(other.uri);
    }
  }

  @Override
  public int hashCode() {
    if (alias == null) {
      return uri.hashCode();
    } else {
      return alias.hashCode() & uri.hashCode();
    }
  }
}

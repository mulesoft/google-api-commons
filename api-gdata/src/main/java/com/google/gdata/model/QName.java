/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model;

import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Qualified name of a data model element or attribute.  A qname instance is
 * immutable.
 */
public final class QName implements Comparable<QName> {
  
  /**
   * Special value for the QName namespace that will match any namespace.
   */
  public static final XmlNamespace ANY_NAMESPACE = new XmlNamespace("*", "*");
  
  /**
   * Special value for the QName local name that will match any local name.
   */
  public static final String ANY_LOCALNAME = "*";

  private final XmlNamespace namespace;
  private final String localName;

  public QName(String localName) {
    this(null, localName);
  }

  public QName(XmlNamespace namespace, String localName) {
    Preconditions.checkNotNull(localName, "localName");
    this.namespace = namespace;
    this.localName = localName;
  }

  public XmlNamespace getNs() { return namespace; }
  public String getLocalName() { return localName; }
  
  /**
   * Returns {@code true} if this qname has a namespace value that will match
   * any namespace.
   *
   * @see ANY_NAMESPACE
   */
  public boolean matchesAnyNamespace() {
    return ANY_NAMESPACE.equals(namespace);
  }

  /**
   * Returns {@code true} if this qname has a local name that will
   * match any local name.
   *
   * @see ANY_LOCALNAME
   */
  public boolean matchesAnyLocalName() {
    return ANY_LOCALNAME.equals(localName);
  }

  /**
   * Checks if this QName is a match for the other QName.  A QName is a match
   * if it is null and if 1) the local namespace is {@link ANY_NAMESPACE} or
   * the two namespaces are both null or have a matching uri and 2) the local
   * name is {@link ANY_LOCALNAME} or the two local names are equal.
   */
  public boolean matches(QName o) {
    if (o == null) {
      return false;
    }

    if (!matchesAnyNamespace()) {
      XmlNamespace otherNs = o.getNs();
      String idUri = (namespace == null) ? null : namespace.getUri();
      String otherUri = (otherNs == null) ? null : otherNs.getUri();

      // Check namespace uris.
      if (idUri == null) {
        if (otherUri != null) {
          return false;
        }
      } else if (!idUri.equals(otherUri)) {
        return false;
      }
    }

    // Check the local names.
    if (matchesAnyLocalName()) {
      return true;
    }
    return localName.equals(o.getLocalName());
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof QName)) {
      return false;
    }
    QName otherQName = (QName) other;
    if (this.getNs() == null && otherQName.getNs() == null) {
      return getLocalName().equals(otherQName.getLocalName());
    }
    if (this.getNs() != null && otherQName.getNs() != null) {
      return this.getNs().getUri().equals(otherQName.getNs().getUri())
             && getLocalName().equals(otherQName.getLocalName());
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (getNs() == null) {
      return getLocalName().hashCode();
    }
    return getNs().getUri().hashCode() * 13 + getLocalName().hashCode();
  }

  @Override
  public String toString() {
    if (getNs() == null || "".equals(getNs().getAlias())) {
      return getLocalName();
    }
    return getNs().getAlias() + ":" + getLocalName();
  }

  public int compareTo(QName o) {

    if (getNs() == null) {
      if (o.getNs() != null) {
        return -1;
      }
    } else {
      if (o.getNs() == null) {
        return 1;
      }
      int result = getNs().getUri().compareTo(o.getNs().getUri());
      if (result != 0) {
        if (ANY_NAMESPACE.equals(o.getNs())) {
          return -1;
        }
        return result;
      }
    }
    String localName = getLocalName();
    int compare = localName.compareTo(o.getLocalName());
    if (compare != 0 && ANY_LOCALNAME.equals(localName)) {
      return -1;
    }
    return compare;
  }
}

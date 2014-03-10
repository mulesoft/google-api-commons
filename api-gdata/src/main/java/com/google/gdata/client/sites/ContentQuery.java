/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.sites;

import com.google.gdata.client.Query;

import java.net.URL;

/**
 * Describes a query for the feed containing the current, editable site content.
 *
 * 
 */
public class ContentQuery extends Query {

  /** Content with the given ancestor. */
  private String ancestor;

  /** Include deleted entries. */
  private Boolean includeDeleted;

  /** Include draft entries. */
  private Boolean includeDrafts;

  /** Content of a the given kind(s). */
  private String kind;

  /** Content with the given parent. */
  private String parent;

  /** Content at the given site path. */
  private String path;

  /**
   * Constructs a new query object that targets a feed.  The initial state of
   * the query contains no parameters, meaning all entries in the feed would be
   * returned if the query was executed immediately after construction.
   *
   * @param feedUrl the URL of the feed against which queries will be executed.
   */
  public ContentQuery(URL feedUrl) {
    super(feedUrl);
  }

  /**
   * Returns the content with the given ancestor.
   *
   * @return content with the given ancestor or <code>null</code> to indicate
   *     that the parameter is not set.
   */
  public String getAncestor() {
    return ancestor;
  }

  /**
   * Sets the content with the given ancestor.
   *
   * @param ancestor content with the given ancestor or <code>null</code> to
   *     remove this parameter if set.
   */
  public void setAncestor(String ancestor) {
    // check if setting to existing value
    if (this.ancestor == null ? ancestor != null :
        !this.ancestor.equals(ancestor)) {
      // set to new value for customer parameter
      this.ancestor = ancestor;
      setStringCustomParameter("ancestor", ancestor);
    }
  }

  /**
   * Returns the include deleted entries.
   *
   * @return include deleted entries or <code>null</code> to indicate that the
   *     parameter is not set.
   */
  public Boolean getIncludeDeleted() {
    return includeDeleted;
  }

  /**
   * Sets the include deleted entries.
   *
   * @param includeDeleted include deleted entries or <code>null</code> to
   *     remove this parameter if set.
   */
  public void setIncludeDeleted(Boolean includeDeleted) {
    // check if setting to existing value
    if (this.includeDeleted == null ? includeDeleted != null :
        !this.includeDeleted.equals(includeDeleted)) {
      // set to new value for customer parameter
      this.includeDeleted = includeDeleted;
      setStringCustomParameter("include-deleted",
          includeDeleted == null ? null : includeDeleted.toString());
    }
  }

  /**
   * Returns the include draft entries.
   *
   * @return include draft entries or <code>null</code> to indicate that the
   *     parameter is not set.
   */
  public Boolean getIncludeDrafts() {
    return includeDrafts;
  }

  /**
   * Sets the include draft entries.
   *
   * @param includeDrafts include draft entries or <code>null</code> to remove
   *     this parameter if set.
   */
  public void setIncludeDrafts(Boolean includeDrafts) {
    // check if setting to existing value
    if (this.includeDrafts == null ? includeDrafts != null :
        !this.includeDrafts.equals(includeDrafts)) {
      // set to new value for customer parameter
      this.includeDrafts = includeDrafts;
      setStringCustomParameter("include-drafts",
          includeDrafts == null ? null : includeDrafts.toString());
    }
  }

  /**
   * Returns the content of a the given kind(s).
   *
   * @return content of a the given kind(s) or <code>null</code> to indicate
   *     that the parameter is not set.
   */
  public String getKind() {
    return kind;
  }

  /**
   * Sets the content of a the given kind(s).
   *
   * @param kind content of a the given kind(s) or <code>null</code> to remove
   *     this parameter if set.
   */
  public void setKind(String kind) {
    // check if setting to existing value
    if (this.kind == null ? kind != null : !this.kind.equals(kind)) {
      // set to new value for customer parameter
      this.kind = kind;
      setStringCustomParameter("kind", kind);
    }
  }

  /**
   * Returns the content with the given parent.
   *
   * @return content with the given parent or <code>null</code> to indicate that
   *     the parameter is not set.
   */
  public String getParent() {
    return parent;
  }

  /**
   * Sets the content with the given parent.
   *
   * @param parent content with the given parent or <code>null</code> to remove
   *     this parameter if set.
   */
  public void setParent(String parent) {
    // check if setting to existing value
    if (this.parent == null ? parent != null : !this.parent.equals(parent)) {
      // set to new value for customer parameter
      this.parent = parent;
      setStringCustomParameter("parent", parent);
    }
  }

  /**
   * Returns the content at the given site path.
   *
   * @return content at the given site path or <code>null</code> to indicate
   *     that the parameter is not set.
   */
  public String getPath() {
    return path;
  }

  /**
   * Sets the content at the given site path.
   *
   * @param path content at the given site path or <code>null</code> to remove
   *     this parameter if set.
   */
  public void setPath(String path) {
    // check if setting to existing value
    if (this.path == null ? path != null : !this.path.equals(path)) {
      // set to new value for customer parameter
      this.path = path;
      setStringCustomParameter("path", path);
    }
  }

}


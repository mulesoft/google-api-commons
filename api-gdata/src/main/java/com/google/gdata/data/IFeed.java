/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data;

import com.google.gdata.client.Query;

import java.util.List;

/**
 * Shared interface for model and data BaseFeed to implement.
 * 
 * 
 */
public interface IFeed extends IAtom {
  
  /**
   * Returns the value of the atom:logo element.
   */
  public String getLogo();
  
  /**
   * Sets the value of the logo field on this feed.
   */
  public void setLogo(String logo);
  
  /**
   * Returns the atom:subtitle element of this feed.
   */
  public ITextConstruct getSubtitle();
  
  /**
   * Returns the atom:generator element on this feed.
   */
  public IGenerator getGenerator();

  /**
   * Sets the atom:generator element on this feed.  This method will create the
   * appropriate type of element or extension based on the data model in use.
   */
  public IGenerator setGenerator(String version, String uri, String name);

  /**
   * Returns true if this feed accepts entries POSTed to it.
   */
  public boolean getCanPost();
  
  /**
   * Sets whether this feed accepts entries POSTed to it.
   */
  public void setCanPost(boolean canPost);

  /**
   * Gets the total number of results associated with this feed.  The value
   * may be larger than the number of contained entries for paged feeds.
   * A value of {@link Query#UNDEFINED} indicates the total size is undefined.
   */
  public int getTotalResults();

  /**
   * Sets the total number of results associated with this feed.  The value
   * may be larger than the number of contained entries for paged feeds.
   * A value of {@link Query#UNDEFINED} indicates the total size is undefined.
   */
  public void setTotalResults(int totalResults);

  /**
   * Gets the starting index of the contained entries for paged feeds.
   * A value of {@link Query#UNDEFINED} indicates the start index is undefined.
   */
  public int getStartIndex();
  
  /**
   * Sets the starting index of the contained entries for paged feeds.
   * A value of {@link Query#UNDEFINED} indicates the start index is undefined.
   */
  public void setStartIndex(int startIndex);
  
  /**
   * Gets the number of items that will be returned per page for paged feeds.
   * A value of {@link Query#UNDEFINED} indicates the page item count is
   * undefined.
   */
  public int getItemsPerPage();
  
  /**
   * Sets the number of items that will be returned per page for paged feeds.
   * A value of {@link Query#UNDEFINED} indicates the page item count is
   * undefined.
   */
  public void setItemsPerPage(int numResults);
  
  /**
   * Creates a new entry of the appropriate type for this feed.
   */
  public IEntry createEntry();
  
  /**
   * Returns a list of entries for this feed.  The actual type of this list will
   * depend on the data model used for the Feed.
   */
  public List<? extends IEntry> getEntries();

  /** Returns the entry post link for the feed. */
  public ILink getEntryPostLink();

  /**
   * Returns the link that provides the URI of next page in a paged feed.
   *
   * @return Link that provides the URI of next page in a paged feed or {@code
   *     null} for none.
   */
  public ILink getNextLink();

  /**
   * Returns the link that provides the URI of previous page in a paged feed.
   *
   * @return Link that provides the URI of previous page in a paged feed or
   *     {@code null} for none.
   */
  public ILink getPreviousLink();

  /**
   * Returns the link that provides the URI that can be used to batch operations
   * to query, insert, update and delete entries on this feed.
   *
   * @return Link that provides the URI that can be used to batch operations to
   *     query, insert, update and delete entries on this feed or {@code null}
   *     for none.
   */
  public ILink getFeedBatchLink();
}

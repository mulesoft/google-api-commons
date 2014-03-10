/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.batch;

import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.IFeed;
import com.google.gdata.data.batch.BatchInterrupted;
import com.google.gdata.data.batch.IBatchInterrupted;
import com.google.gdata.util.ServiceException;

/**
 * Exception thrown by the client when an entry with a
 * {@code <batch:interrupted>} tag has been detected.
 *
 * 
 */
public class BatchInterruptedException
    extends ServiceException {
  private final IFeed feed;
  private final IBatchInterrupted interrupted;

  /**
   * Creates a BatchInterrupted exception.
   *
   * @param feed
   * @param interrupted
   */
  public BatchInterruptedException(IFeed feed, IBatchInterrupted interrupted) {
    super("Batch Interrupted (some operations might have succeeded) : " +
        interrupted.getReason());
    this.feed = feed;
    this.interrupted = interrupted;
  }
  
  /**
   * Gets the {@code <batch:interrupted>} tag that describes
   * what went wrong.
   *
   * @return BatchInterrupted object
   * @deprecated Use {@link #getIBatchInterrupted()} instead.
   */
  @Deprecated
  public BatchInterrupted getBatchInterrupted() {
    Preconditions.checkState(interrupted == null
        || interrupted instanceof BatchInterrupted,
        "Use getIBatchInterrupted() instead");
    return (BatchInterrupted) interrupted;
  }
  
  /**
   * Gets the {@code <batch:interrupted>} tag that describes
   * what went wrong.
   *
   * @return BatchInterrupted object
   */
  public IBatchInterrupted getIBatchInterrupted() {
    return interrupted;
  }

  /**
   * Gets the interrupted feed, which might contain reports of successful
   * operations.
   *
   * The last entry on the feed is always the entry that contains the
   * {@link BatchInterrupted} object.
   *
   * @return the feed
   * @deprecated Use {@link #getIFeed()} instead.
   */
  @Deprecated
  public BaseFeed<?, ?> getFeed() {
    Preconditions.checkState(feed == null
        || feed instanceof BaseFeed,
        "Use getIFeed() instead");
    return (BaseFeed<?, ?>) feed;
  }
  
  public IFeed getIFeed() {
    return feed;
  }
}

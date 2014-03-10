/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.uploader;

/**
 * Policy class for determining how long to wait before retrying an HTTP
 * request.
 * 
 * 
 */
public interface BackoffPolicy {

  /**
   * Default backoff policy with a factor of 2, starting at 500ms and getting
   * capped at 64000ms.
   */
  public static BackoffPolicy DEFAULT = new BackoffPolicy() {
    
    /**
     * Default maximum amount of time to wait before making a retry (we back
     * off -- with a factor of 2 -- such that the requests are delayed by
     * the following number of seconds: .5, 1, 2, 4, 8, 16, 32, 64, 64, 64,
     * 64 ... etc.). The back off will increase by a factor of 2 until
     * backoffMs >= BACKOFF_DELAY_LIMIT_MS, at which point
     * backoffDelaySeconds will be assigned the limit.
     */
    private static final long BACKOFF_DELAY_LIMIT_MS = 64000L;
    
    /**
     * Initial backoff amount.
     */
    private static final long INITIAL_BACKOFF_MS = 500L;
    
    /**
     * Backoff factor
     */
    private static final long BACKOFF_FACTOR = 2;
    
    /**
     * Number milliseconds to wait before retrying an HTTP request.
     */
    private long backoffMs = INITIAL_BACKOFF_MS;
    
    public long getNextBackoffMs() {
      
      // Get the value to return
      long returnValueMs = backoffMs;
      
      // Update backoffMs for the next call.
      long nextBackoffMs = backoffMs * BACKOFF_FACTOR;
      backoffMs = (nextBackoffMs > BACKOFF_DELAY_LIMIT_MS)
          ? BACKOFF_DELAY_LIMIT_MS : nextBackoffMs;
      
      return returnValueMs;
    }
    
    public void reset() {
      backoffMs = INITIAL_BACKOFF_MS;
    }
  };
  
  /**
   * Value indicating that no more retries should be made, 
   * {@see #getNextBackoffMs()}.
   */
  public static final long STOP = -1L;
  
  /**
   * Gets the number of milliseconds to wait before retrying an HTTP request.
   * If {@link #STOP} is returned, no retries should be made.
   * 
   * This method should be used as follows:
   * <pre>
   *   long backoffTime = backoffPolicy.getNextBackoffMs();
   *   if (backoffTime = BackoffPolicy.STOP) {
   *     // Stop retrying.
   *   } else {
   *     // Retry after backoffTime.
   *   }
   * </pre>
   * 
   * @return the number of milliseconds to wait when backing off requests, or
   *     {@link #STOP} if no more retries should be made
   */
  public long getNextBackoffMs();
  
  /**
   * Resets the policy to begin from its initial state.
   */
  public void reset();
}

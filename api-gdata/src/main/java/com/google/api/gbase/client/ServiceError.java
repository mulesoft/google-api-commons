/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.api.gbase.client;

/**
 * One error found in the body of a 
 * {@link com.google.gdata.util.ServiceException}
 * or in the content of a
 * {@link com.google.gdata.data.batch.BatchStatus}.
 * 
 * @see com.google.api.gbase.client.ServiceErrors
 */
public class ServiceError {
  private final String type;
  private final String field;
  private final String reason;

  /** The {@value #DATA_TYPE} error type. */
  public static final String DATA_TYPE = "data";

  /** The {@value #REQUEST_TYPE} error type. */
  public static final String REQUEST_TYPE = "request";

  /**
   * Creates a new error.
   *
   * @param type error type, may be null, {@link #DATA_TYPE}
   *   or {@link #REQUEST_TYPE}
   * @param field error field, may be null
   * @param reason error message
   */
  public ServiceError(String type, String field, String reason) {
    this.type = type;
    this.field = field;
    this.reason = reason;
  }

  /**
   * Creates a new error with just an error message.
   *
   * @param reason error message
   */
  public ServiceError(String reason) {
    this(null, null, reason);
  }

  /**
   * Returns a convenient string representation.
   *
   * @return a string representation
   */
  @Override
  public String toString() {
    if (field == null) {
      return reason;
    } else {
      return field + ": " + reason;
    }
  }

  /**
   * Gets the error type.
   *
   * @return error type or null
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the error field.
   *
   * @return error field or null
   */
  public String getField() {
    return field;
  }

  /**
   * Gets the error message (plain text).
   *
   * @return error message
   */
  public String getReason() {
    return reason;
  }
}
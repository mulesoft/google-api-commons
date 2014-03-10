/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.webmastertools;

/**
 * CrawlRate is an enumerated type that indicates the desired crawl rate
 * to use for a concrete site. Not all rates may be allowed for a given site. 
 * 
 * 
*/
public enum CrawlRate {
  
  SLOWEST("slowest"),
  SLOWER("slower"),
  NORMAL("normal"),
  FASTER("faster"),
  FASTEST("fastest"),
  ;

  private String value;

  /**
   * Constructor. Associates a string with the enum value.
   * 
   * @param associatedString the string associated with the crawl rate value.
   */
  private CrawlRate(String associatedString) {
    value = associatedString;
  }

  /**
   * Returns the string representation of the CrawlRate.
   */
  @Override
  public String toString() {
    return value;
  }
  
  /**
   * Returns the default CrawlRate value.
   * 
   * @return default CrawlRate value.
   */
  public static CrawlRate getDefault() {
    return NORMAL;
  }
  
  /**
   * Parse a string and return a crawl rate.
   * 
   * @param value a string representing a crawl rate.
   * @return a CrawlRate if the parameter can be successfully parsed.
   * @throws IllegalArgumentException if the parameter is not a valid
   * CrawlRate string.
   */
  public static CrawlRate fromString(String value) 
      throws IllegalArgumentException {
    for (CrawlRate rate : values()) {
      if (rate.toString().equals(value)) {
        return rate;
      }
    }
    
    throw new IllegalArgumentException(
        "The parameter is not a valid CrawlRate string");
  }
}
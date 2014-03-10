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

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.Collections;

/**
 * Tax information
 *
 * 
 *
 */
public class Tax {
  /** Destination country, optional.*/
  private final String country;
  /** The region, optional and repeatable. */
  private final Collection<String> regions;  
  /** The tax rate in percentage, always set. */
  private final float rate;
  /** A boolean indicating whether the shipping is taxed. Optional. Default is false. */
  private final Boolean taxShip;

  /**
   * Creates a tax object.
   * 
   * @param country destination country (ISO 3312 2-letter code), can be null
   * @param regions A list of shipping regions within the destination country, can be null. 
   * @param rate the tax percentage rate. For example, for 6% tax rate, rate should be set to 6.
   * @param taxShip A boolean indicating whether the shipping is taxed, can be null.
   */
  public Tax(String country, Collection<String> regions, float rate, Boolean taxShip) {
    this.country = country;
    if (regions != null) {
      this.regions = ImmutableList.copyOf(regions);
    } else {
      this.regions = Collections.<String>emptySet();
    }
    this.rate = rate;
    this.taxShip = taxShip;
  }
  
  @Override
  public String toString() {
    return "Tax(country=" + country +", regions=" + regions + ", rate=" + rate 
        + ", taxShip= " + taxShip;
  }
  
  /** Gets the tax rate. */
  public float getRate() {
    return rate;
  }

  /**
   * Gets the destination country, or null.
   *
   * This should be a
   * <a
   * href="http://www.iso.org/iso/en/prods-services/iso3166ma/02iso-3166-code-lists/list-en1.html">
   * ISO 3312 2-letter code.</a>
   */
  public String getCountry() {
    return country;
  }

  /** Gets the regions. This method never returns null, but the returned list can be empty. */
  public Collection<String> getRegions() {
    return regions;
  }
  
  /** Gets the taxShip, or null. */
  public Boolean getTaxShip() {
    return taxShip;
  }
}

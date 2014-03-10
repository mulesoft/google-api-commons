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
 * Shipping information, defined using destination country, a region,
 * a price (in the item's currency), and a shipping service. 
 */
public class Shipping {
  /** Destination country, optional.*/
  private final String country;
  /** The regions, optional and repeatable. */
  private final Collection<String> regions;
  /** Shipping service, optional. */
  private final String service;
  /** Price, always set. */
  private final float price;
  /** Currency, not always set. */
  private final String currency;

  /**
   * Creates a shipping object.
   *
   * @param country destination country (ISO 3312 2-letter code), can be null.
   * @param service shipping method, can be null.
   * @param price price
   * @param currency price currency, can be null.
   */
  public Shipping(String country, String service, float price, String currency) {
    this(country, null, service, price, currency);
  }
  
  /**
   * Creates a shipping object.
   * 
   * @param country destination country (ISO 3312 2-letter code), can be null.
   * @param regions A list of shipping regions within the destination country. Can be null. 
   * @param service shipping method, can be null.
   * @param price price
   * @param currency price currency, can be null.
   */
  public Shipping(String country, Collection<String> regions, String service, float price, 
      String currency) {
    this.country = country;
    if (regions != null) {
      this.regions = ImmutableList.copyOf(regions);
    } else {
      this.regions = Collections.emptySet();
    }
    this.price = price;
    this.service = service;
    this.currency = currency;
  }

  @Override
  public String toString() {
    return "Shipping(country=" + country +", regions=" + regions + ", service=" + service 
    + ", price= " + price + ", currency=" + currency + ")";
  }

  /** Gets the price. */
  public float getPrice() {
    return price;
  }

  /** Gets the price currency, or null. */
  public String getCurrency() {
    return currency;
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
  
  /** Gets the shipping service, or null. */
  public String getService() {
    return service;
  }

}

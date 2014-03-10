/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.finance;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.util.Namespaces;

/**
 * Describes an entry in a feed of Finance positions.
 *
 * 
 */
@Kind.Term(PositionEntry.KIND)
public class PositionEntry extends BaseEntry<PositionEntry> {

  /**
   * Position kind term value.
   */
  public static final String KIND = FinanceNamespace.GF_PREFIX + "position";

  /**
   * Position kind category.
   */
  public static final Category CATEGORY = new Category(Namespaces.gKind, KIND);

  /**
   * Default mutable constructor.
   */
  public PositionEntry() {
    super();
    getCategories().add(CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public PositionEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(PositionEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(PositionEntry.class, PositionFeedLink.class);
    new PositionFeedLink().declareExtensions(extProfile);
    extProfile.declare(PositionEntry.class,
        PositionData.getDefaultDescription(true, false));
    new PositionData().declareExtensions(extProfile);
    extProfile.declare(PositionEntry.class, Symbol.getDefaultDescription(true,
        false));
  }

  /**
   * Returns the transaction feed for the position.
   *
   * @return transaction feed for the position
   */
  public PositionFeedLink getFeedLink() {
    return getExtension(PositionFeedLink.class);
  }

  /**
   * Sets the transaction feed for the position.
   *
   * @param feedLink transaction feed for the position or <code>null</code> to
   *     reset
   */
  public void setFeedLink(PositionFeedLink feedLink) {
    if (feedLink == null) {
      removeExtension(PositionFeedLink.class);
    } else {
      setExtension(feedLink);
    }
  }

  /**
   * Returns whether it has the transaction feed for the position.
   *
   * @return whether it has the transaction feed for the position
   */
  public boolean hasFeedLink() {
    return hasExtension(PositionFeedLink.class);
  }

  /**
   * Returns the data for the position.
   *
   * @return data for the position
   */
  public PositionData getPositionData() {
    return getExtension(PositionData.class);
  }

  /**
   * Sets the data for the position.
   *
   * @param positionData data for the position or <code>null</code> to reset
   */
  public void setPositionData(PositionData positionData) {
    if (positionData == null) {
      removeExtension(PositionData.class);
    } else {
      setExtension(positionData);
    }
  }

  /**
   * Returns whether it has the data for the position.
   *
   * @return whether it has the data for the position
   */
  public boolean hasPositionData() {
    return hasExtension(PositionData.class);
  }

  /**
   * Returns the stock symbol for the position.
   *
   * @return stock symbol for the position
   */
  public Symbol getSymbol() {
    return getExtension(Symbol.class);
  }

  /**
   * Sets the stock symbol for the position.
   *
   * @param symbol stock symbol for the position or <code>null</code> to reset
   */
  public void setSymbol(Symbol symbol) {
    if (symbol == null) {
      removeExtension(Symbol.class);
    } else {
      setExtension(symbol);
    }
  }

  /**
   * Returns whether it has the stock symbol for the position.
   *
   * @return whether it has the stock symbol for the position
   */
  public boolean hasSymbol() {
    return hasExtension(Symbol.class);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{PositionEntry " + super.toString() + "}";
  }

}


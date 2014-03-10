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
 * Describes an entry in a feed of Finance portfolios.
 *
 * 
 */
@Kind.Term(PortfolioEntry.KIND)
public class PortfolioEntry extends BaseEntry<PortfolioEntry> {

  /**
   * Portfolio kind term value.
   */
  public static final String KIND = FinanceNamespace.GF_PREFIX + "portfolio";

  /**
   * Portfolio kind category.
   */
  public static final Category CATEGORY = new Category(Namespaces.gKind, KIND);

  /**
   * Default mutable constructor.
   */
  public PortfolioEntry() {
    super();
    getCategories().add(CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public PortfolioEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(PortfolioEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(PortfolioEntry.class, PortfolioFeedLink.class);
    new PortfolioFeedLink().declareExtensions(extProfile);
    extProfile.declare(PortfolioEntry.class,
        PortfolioData.getDefaultDescription(true, false));
    new PortfolioData().declareExtensions(extProfile);
  }

  /**
   * Returns the position feed for the portfolio.
   *
   * @return position feed for the portfolio
   */
  public PortfolioFeedLink getFeedLink() {
    return getExtension(PortfolioFeedLink.class);
  }

  /**
   * Sets the position feed for the portfolio.
   *
   * @param feedLink position feed for the portfolio or <code>null</code> to
   *     reset
   */
  public void setFeedLink(PortfolioFeedLink feedLink) {
    if (feedLink == null) {
      removeExtension(PortfolioFeedLink.class);
    } else {
      setExtension(feedLink);
    }
  }

  /**
   * Returns whether it has the position feed for the portfolio.
   *
   * @return whether it has the position feed for the portfolio
   */
  public boolean hasFeedLink() {
    return hasExtension(PortfolioFeedLink.class);
  }

  /**
   * Returns the data for the portfolio.
   *
   * @return data for the portfolio
   */
  public PortfolioData getPortfolioData() {
    return getExtension(PortfolioData.class);
  }

  /**
   * Sets the data for the portfolio.
   *
   * @param portfolioData data for the portfolio or <code>null</code> to reset
   */
  public void setPortfolioData(PortfolioData portfolioData) {
    if (portfolioData == null) {
      removeExtension(PortfolioData.class);
    } else {
      setExtension(portfolioData);
    }
  }

  /**
   * Returns whether it has the data for the portfolio.
   *
   * @return whether it has the data for the portfolio
   */
  public boolean hasPortfolioData() {
    return hasExtension(PortfolioData.class);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{PortfolioEntry " + super.toString() + "}";
  }

}


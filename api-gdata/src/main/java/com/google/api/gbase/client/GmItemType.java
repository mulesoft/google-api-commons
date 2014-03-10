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

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.util.ParseException;

/**
 * Java representation for the gm:item_type tag found in the item type feed.
 */
@ExtensionDescription.Default(
    nsAlias = GoogleBaseNamespaces.GM_ALIAS,
    nsUri = GoogleBaseNamespaces.GM_URI,
    localName = "item_type")
public class GmItemType extends AbstractExtension {
  private String itemType;

  /**
   * Creates an unset item type object.
   */
  public GmItemType() {

  }

  /**
   * Creates and initializez an item type object.
   *
   * @param itemType itemType value
   */
  public GmItemType(String itemType) {
    this.itemType = itemType;
  }

  /** Gets the item type value. */
  public String getItemType() {
    return itemType;
  }

  /** Sets the item type value. */
  public void setItemType(String itemType) {
    this.itemType = itemType;
  }


  /**
   * Makes sure the item type is not null.
   *
   * {@inheritDoc}
   */
  @Override
  protected void validate() {
    super.validate();
    
    if (itemType == null) {
      throw new IllegalStateException("An item type should be set.");
    }
  }

  protected void putAttributes(AttributeGenerator generator) {
    generator.setContent(itemType);
  }

  protected void consumeAttributes(AttributeHelper helper)
      throws ParseException {
    this.itemType = helper.consumeContent(true);
  }
}
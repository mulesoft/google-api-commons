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

import com.google.api.gbase.client.GmAttributes.GmAttribute;
import com.google.gdata.data.BaseEntry;

import java.util.Collection;
import java.util.List;

/**
 * A description of an item type done by the gm: tags in a
 * google base entry.
 *
 * Make sure the current feed is an item type feed and then get the
 * ItemTypeDescription for the entry using:
 * {@link GoogleBaseEntry#getGoogleBaseMetadata()}.getItemTypeDescription()
 */
public class ItemTypeDescription {

  private final BaseEntry owner;

  /**
   * Creates an ItemTypeDescription.
   *
   * @param owner entry the description is in
   */
  ItemTypeDescription(BaseEntry owner) {
    this.owner = owner;
  }

  void setName(String name) {
    if (name == null) {
      owner.removeExtension(GmItemType.class);
    } else {
      owner.setExtension(new GmItemType(name));
    }
  }
  
  /**
   * Gets the item type name.
   */
  public String getName() {
    GmItemType tag = owner.getExtension(GmItemType.class);
    return tag == null ? null : tag.getItemType();
  }

  /**
   * Get the list of attribute ids defined for this item type.
   *
   * @return unmodifiable list of attribute ids
   * @deprecated use {@link #getAttributes()} instead
   */
  public List<? extends GoogleBaseAttributeId> getAttributeIds() {
    return getGmAttributesExtension().getAttributeIds();
  }
  
  /**
   * Get the list of attribute ids with extra information as defined for this 
   * item type.
   *
   * @return unmodifiable list of GmAttribute objects
   */
  public Collection<GmAttribute> getAttributes() {
    return getGmAttributesExtension().getAttributes();
  }

  /**
   * Returns the GmAttributes instance associated to the owner of the 
   * description. If the owner has no GmAttributes defined, a new instance
   * is created, assigned to the owner and returned.
   */
  private GmAttributes getGmAttributesExtension() {
    GmAttributes attributes = owner.getExtension(GmAttributes.class);
    if (attributes == null) {
      attributes = new GmAttributes();
      owner.setExtension(attributes);
    }
    return attributes;
  }
}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.youtube;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Category;
import com.google.gdata.data.extensions.FeedLink;
import com.google.gdata.util.Namespaces;

import java.util.Iterator;
import java.util.Set;

/**
 * Utility methods used in this package.
 *
 * 
 */
class EntryUtils {

  /**
   * Replaces the existing kind category with the new given value.
   * 
   * @param entry entry to change.
   * @param newKind the new kind to set.
   */
  static void setKind(BaseEntry<?> entry, String newKind) {
    removeKindCategory(entry.getCategories().iterator());
    addKindCategory(entry.getCategories(), newKind);
  }

  /**
   * Replaces the existing kind category with the new given value.
   */
  static void setKind(BaseFeed<?, ?> feed, String newKind) {
    removeKindCategory(feed.getCategories().iterator());
    addKindCategory(feed.getCategories(), newKind);
  }

  private static void removeKindCategory(Iterator<Category> iter) {
    while (iter.hasNext()) {
      Category category = iter.next();
      if (Namespaces.gKind.equals(category.getScheme())) {
        iter.remove();
      }
    }
  }

  private static void addKindCategory(Set<Category> categories, String kind) {
    categories.add(new Category(Namespaces.gKind, kind));
  }

  /**
   * Returns the first matching {@code gd:feedLink} or {@code null}.
   *
   * @param rel value of the {@code rel} attribute
   */
  static FeedLink<?> getFeedLink(BaseEntry<?> entry, String rel) {
    for (FeedLink<?> feedLink : entry.getRepeatingExtension(FeedLink.class)) {
      if (rel.equals(feedLink.getRel())) {
        return feedLink;
      }
    }
    return null;
  }

  /** This is a utility class. */
  private EntryUtils() {
    throw new IllegalStateException("");
  }
}

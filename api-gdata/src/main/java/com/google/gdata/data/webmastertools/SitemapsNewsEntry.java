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

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.data.ValueConstruct;

/**
 * This represents a single News sitemap entry in a list of sitemaps.
 * {@link SitemapsNewsEntry#setPublicationLabel} must be called to set the
 * News sitemap publication label.
 *
 * 
 */
@Kind.Term(Namespaces.KIND_SITEMAP_NEWS)
public class SitemapsNewsEntry extends SitemapsEntry<SitemapsNewsEntry> {

  private static final String NEWS_PUBLICATION_LABEL
      = "sitemap-news-publication-label";
  
  /**
   * Kind category used to label feed.
   */
  private static final Category CATEGORY
      = Namespaces.createCategory(Namespaces.KIND_SITEMAP_NEWS);  

  /**
   * Constructs a new SitemapsNewsEntry instance
   */
  public SitemapsNewsEntry() {
    super();
    this.getCategories().add(CATEGORY);
  }
  
  /**
   * Constructs a new entry by doing a copy from another BaseEntry instance.
   */
  public SitemapsNewsEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
    getCategories().add(CATEGORY);
  }  

  /**
   * Initializes an ExtensionProfile based upon the extensions expected
   * by a SitemapsNewsEntry.
   */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    extProfile.declare(
        SitemapsNewsEntry.class,
        ExtensionDescription.getDefaultDescription(PublicationLabel.class));
  }

  /**
   * Set publication label for News sitemap.
   */
  public void setPublicationLabel(String value) {
    PublicationLabel label = getExtension(PublicationLabel.class);
    if (label == null) {
      label = new PublicationLabel();
      setExtension(label);
    }

    label.setValue(value);
  }

  /**
   * Returns publication label for News sitemap.
   */
  public String getPublicationLabel() {
    PublicationLabel label = getExtension(PublicationLabel.class);
    if (label == null) {
      return null;
    }

    return label.getValue();
  }

  /**
   * We validate that publication label is set.
   */
  @Override
  protected void validate() throws IllegalStateException {
    super.validate();
    if (getPublicationLabel() == null) {
      throw new IllegalStateException(NEWS_PUBLICATION_LABEL + " is not set");
    }
  }

  /**
   * Represents <sitemap-news-publication-label> node, that is a publication
   * label for News sitemap.
   */
  @ExtensionDescription.Default(
      nsAlias = Namespaces.WT_ALIAS,
      nsUri = Namespaces.WT,
      localName = NEWS_PUBLICATION_LABEL)
  public static class PublicationLabel extends ValueConstruct {
    public PublicationLabel() {
      super(Namespaces.WT_NAMESPACE, NEWS_PUBLICATION_LABEL, null);
    }
  }
}

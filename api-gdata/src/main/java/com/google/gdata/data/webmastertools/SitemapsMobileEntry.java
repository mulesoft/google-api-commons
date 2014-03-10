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
 * This represents a single Mobile sitemap entry in a list of sitemaps.
 * {@link SitemapsMobileEntry#setMarkupLanguage} must be called to set the
 * markup language.
 *
 * 
 */
@Kind.Term(Namespaces.KIND_SITEMAP_MOBILE)
public class SitemapsMobileEntry extends SitemapsEntry<SitemapsMobileEntry> {

  private static final String MOBILE_MARKUP_LANG
      = "sitemap-mobile-markup-language";
  
  /**
   * Kind category used to label feed.
   */
  private static final Category CATEGORY
      = Namespaces.createCategory(Namespaces.KIND_SITEMAP_MOBILE);

  /**
   * Constructs a new SitemapsMobileEntry instance
   */
  public SitemapsMobileEntry() {
    super();
    this.getCategories().add(CATEGORY);
  }
  
  /**
   * Constructs a new entry by doing a copy from another BaseEntry instance.
   */
  public SitemapsMobileEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
    getCategories().add(CATEGORY);
  }  

  /**
   * Initializes an ExtensionProfile based upon the extensions expected
   * by a SitemapsMobileEntry.
   */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    extProfile.declare(
        SitemapsMobileEntry.class,
        ExtensionDescription.getDefaultDescription(MarkupLanguage.class));
  }

  /**
   * Set mark-up language for mobile sitemap.
   */
  public void setMarkupLanguage(String value) {
    MarkupLanguage lang = getExtension(MarkupLanguage.class);
    if (lang == null) {
      lang = new MarkupLanguage();
      setExtension(lang);
    }

    lang.setValue(value);
  }

  /**
   * Returns mark-up language for mobile sitemap.
   */
  public String getMarkupLanguage() {
    MarkupLanguage lang = getExtension(MarkupLanguage.class);
    if (lang == null)
      return null;

    return lang.getValue();
  }

  /**
   * We validate that markup language is set.
   */
  @Override
  protected void validate() throws IllegalStateException {
    super.validate();
    if (getMarkupLanguage() == null) {
      throw new IllegalStateException(MOBILE_MARKUP_LANG + " is not set");
    }
  }

  /**
   * Represents a single <sitemap-mobile-markup-language> node.
   */
  @ExtensionDescription.Default(
      nsAlias = Namespaces.WT_ALIAS,
      nsUri = Namespaces.WT,
      localName = MOBILE_MARKUP_LANG)
  public static class MarkupLanguage extends ValueConstruct {
    public MarkupLanguage() {
      super(Namespaces.WT_NAMESPACE, MOBILE_MARKUP_LANG, null);
    }
  }
}

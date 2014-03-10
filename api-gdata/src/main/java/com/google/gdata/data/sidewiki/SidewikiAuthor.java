/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.sidewiki;

import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Person;
import com.google.gdata.data.extensions.Rating;
import com.google.gdata.data.extensions.ResourceId;
import com.google.gdata.util.Namespaces;

/**
 * Sidewiki author.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = "atom",
    nsUri = Namespaces.atom,
    localName = SidewikiAuthor.XML_NAME)
public class SidewikiAuthor extends Person {

  /** XML element name */
  static final String XML_NAME = "author";

  /**
   * Default mutable constructor.
   */
  public SidewikiAuthor() {
    super();
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(SidewikiAuthor.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(SidewikiAuthor.class, SidewikiUserDescription.class);
    extProfile.declare(SidewikiAuthor.class, EntriesNumber.class);
    extProfile.declare(SidewikiAuthor.class,
        new ExtensionDescription(Rating.class, new XmlNamespace("gd",
        "http://schemas.google.com/g/2005"), "rating", false, false, false));
    extProfile.declare(SidewikiAuthor.class,
        ResourceId.getDefaultDescription(true, false));
    extProfile.declare(SidewikiAuthor.class, SidewikiThumbnail.class);
  }

  /**
   * Returns the Sidewiki author description.
   *
   * @return Sidewiki author description
   */
  public SidewikiUserDescription getDescription() {
    return getExtension(SidewikiUserDescription.class);
  }

  /**
   * Sets the Sidewiki author description.
   *
   * @param description Sidewiki author description or <code>null</code> to
   *     reset
   */
  public void setDescription(SidewikiUserDescription description) {
    if (description == null) {
      removeExtension(SidewikiUserDescription.class);
    } else {
      setExtension(description);
    }
  }

  /**
   * Returns whether it has the Sidewiki author description.
   *
   * @return whether it has the Sidewiki author description
   */
  public boolean hasDescription() {
    return hasExtension(SidewikiUserDescription.class);
  }

  /**
   * Returns the entries number.
   *
   * @return entries number
   */
  public EntriesNumber getNumEntries() {
    return getExtension(EntriesNumber.class);
  }

  /**
   * Sets the entries number.
   *
   * @param numEntries entries number or <code>null</code> to reset
   */
  public void setNumEntries(EntriesNumber numEntries) {
    if (numEntries == null) {
      removeExtension(EntriesNumber.class);
    } else {
      setExtension(numEntries);
    }
  }

  /**
   * Returns whether it has the entries number.
   *
   * @return whether it has the entries number
   */
  public boolean hasNumEntries() {
    return hasExtension(EntriesNumber.class);
  }

  /**
   * Returns the user rating given by the user issued the request.
   *
   * @return user rating given by the user issued the request
   */
  public Rating getRating() {
    return getExtension(Rating.class);
  }

  /**
   * Sets the user rating given by the user issued the request.
   *
   * @param rating user rating given by the user issued the request or
   *     <code>null</code> to reset
   */
  public void setRating(Rating rating) {
    if (rating == null) {
      removeExtension(Rating.class);
    } else {
      setExtension(rating);
    }
  }

  /**
   * Returns whether it has the user rating given by the user issued the
   * request.
   *
   * @return whether it has the user rating given by the user issued the request
   */
  public boolean hasRating() {
    return hasExtension(Rating.class);
  }

  /**
   * Returns the Sidewiki author id.
   *
   * @return Sidewiki author id
   */
  public ResourceId getResourceId() {
    return getExtension(ResourceId.class);
  }

  /**
   * Sets the Sidewiki author id.
   *
   * @param resourceId Sidewiki author id or <code>null</code> to reset
   */
  public void setResourceId(ResourceId resourceId) {
    if (resourceId == null) {
      removeExtension(ResourceId.class);
    } else {
      setExtension(resourceId);
    }
  }

  /**
   * Returns whether it has the Sidewiki author id.
   *
   * @return whether it has the Sidewiki author id
   */
  public boolean hasResourceId() {
    return hasExtension(ResourceId.class);
  }

  /**
   * Returns the user portrait thumbnail url.
   *
   * @return user portrait thumbnail url
   */
  public SidewikiThumbnail getThumbnail() {
    return getExtension(SidewikiThumbnail.class);
  }

  /**
   * Sets the user portrait thumbnail url.
   *
   * @param thumbnail user portrait thumbnail url or <code>null</code> to reset
   */
  public void setThumbnail(SidewikiThumbnail thumbnail) {
    if (thumbnail == null) {
      removeExtension(SidewikiThumbnail.class);
    } else {
      setExtension(thumbnail);
    }
  }

  /**
   * Returns whether it has the user portrait thumbnail url.
   *
   * @return whether it has the user portrait thumbnail url
   */
  public boolean hasThumbnail() {
    return hasExtension(SidewikiThumbnail.class);
  }

  @Override
  protected void validate() {
  }

  /**
   * Returns the extension description, specifying whether it is required, and
   * whether it is repeatable.
   *
   * @param required   whether it is required
   * @param repeatable whether it is repeatable
   * @return extension description
   */
  public static ExtensionDescription getDefaultDescription(boolean required,
      boolean repeatable) {
    ExtensionDescription desc =
        ExtensionDescription.getDefaultDescription(SidewikiAuthor.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{SidewikiAuthor " + super.toString() + "}";
  }

}


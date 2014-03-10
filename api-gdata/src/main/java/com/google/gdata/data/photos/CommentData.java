/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.photos;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.TextConstruct;

/**
 * Shared comment data object, this contains all setters/getters of fields that
 * are specific to a comment.  Currently comments must have both an albumid and
 * a photoid when created, as we don't yet allow comments on an album by itself.
 *
 * The actual content of the comment should be set using the
 * {@link BaseEntry#setContent(TextConstruct)} method.
 *
 * 
 */
public interface CommentData extends GphotoData {

  /** The unqualified kind for a comment. */
  public static final String KIND = "comment";

  /** The fully qualified kind term for comments. */
  public static final String COMMENT_KIND
      = Namespaces.PHOTOS_PREFIX + KIND;

  /** A category object for comments.  All comments will have this set. */
  public static final Category COMMENT_CATEGORY
      = new Category(com.google.gdata.util.Namespaces.gKind, COMMENT_KIND);

  /**
   * Gets the albumid of the album the comment is contained in.
   * 
   * @return the albumId of the album this comment is on.
   */
  public String getAlbumId();

  /**
   * Set the albumId of the album this comment is contained in.
   *
   * @param albumId the albumId of the comment.
   */
  public void setAlbumId(Long albumId);

  /**
   * Set the albumId by string for the album the comment is on.
   *
   * @param albumId the albumId of the comment.
   */
  public void setAlbumId(String albumId);

  /**
   * Gets the id of the photo this comment is about.
   * 
   * @return the photoId of the photo this comment is on.
   */
  public String getPhotoId();

  /**
   * Set the photoId for the photo this comment is on.
   *
   * @param photoId the photoId of the comment.
   */
  public void setPhotoId(Long photoId);

  /**
   * Set the photoId as a string for the photo this comment is on.
   *
   * @param photoId the photoId of the comment.
   */
  public void setPhotoId(String photoId);
}

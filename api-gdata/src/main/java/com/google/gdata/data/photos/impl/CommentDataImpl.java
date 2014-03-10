/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.photos.impl;

import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.photos.CommentData;
import com.google.gdata.data.photos.GphotoAlbumId;
import com.google.gdata.data.photos.GphotoPhotoId;

/**
 * Implementation class for album data objects.  This class takes an
 * {@link ExtensionPoint} and uses it to provide all of the methods that
 * {@link CommentData} specifies.  These methods are handled by using
 * extension classes to retrieve or set extensions of the appropriate type.
 *
 * 
 */
public class CommentDataImpl extends GphotoDataImpl implements CommentData {

  /**
   * Construct a new implementation of CommentGphotoData with the given
   * extension point as the backing storage of data.
   */
  public CommentDataImpl(ExtensionPoint extensionPoint) {
    super(extensionPoint);
  }

  /*
   * Declare the extensions that comment objects use.
   */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    declare(extProfile, GphotoAlbumId.getDefaultDescription(false, false));
    declare(extProfile, GphotoPhotoId.getDefaultDescription(false, false));
  }

  /**
   * @return the albumId of the album this comment is on.
   */
  public String getAlbumId() {
    return getSimpleValue(GphotoAlbumId.class);
  }

  /**
   * Set the albumId for the album this comment is on.
   *
   * @param albumId the albumId of the comment.
   */
  public void setAlbumId(Long albumId) {
    if (albumId != null) {
      setExtension(new GphotoAlbumId(albumId.toString()));
    } else {
      removeExtension(GphotoAlbumId.class);
    }
  }

  /**
   * Set the albumId for the album this comment is on.
   *
   * @param albumId the albumId of the comment.
   */
  public void setAlbumId(String albumId) {
    if (albumId != null) {
      setExtension(new GphotoAlbumId(albumId));
    } else {
      removeExtension(GphotoAlbumId.class);
    }
  }

  /**
   * @return the photoId of the photo this comment is on.
   */
  public String getPhotoId() {
    return getSimpleValue(GphotoPhotoId.class);
  }

  /**
   * Set the photoId for the photo this comment is on.
   *
   * @param photoId the photoId of the comment.
   */
  public void setPhotoId(Long photoId) {
    if (photoId != null) {
      setExtension(new GphotoPhotoId(photoId.toString()));
    } else {
      removeExtension(GphotoPhotoId.class);
    }
  }

  /**
   * Set the photoId for the photo this comment is on.
   *
   * @param photoId the photoId of the comment.
   */
  public void setPhotoId(String photoId) {
    if (photoId != null) {
      setExtension(new GphotoPhotoId(photoId));
    } else {
      removeExtension(GphotoPhotoId.class);
    }
  }
}

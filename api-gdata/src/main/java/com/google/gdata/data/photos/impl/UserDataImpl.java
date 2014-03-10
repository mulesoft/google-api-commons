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
import com.google.gdata.data.photos.GphotoMaxPhotos;
import com.google.gdata.data.photos.GphotoNickname;
import com.google.gdata.data.photos.GphotoQuotaLimit;
import com.google.gdata.data.photos.GphotoQuotaUsed;
import com.google.gdata.data.photos.GphotoThumbnail;
import com.google.gdata.data.photos.GphotoUsername;
import com.google.gdata.data.photos.UserData;

/**
 * Implementation class for user data objects.  This class takes an
 * {@link ExtensionPoint} and uses it to provide all of the methods that
 * {@link UserData} specifies.  These methods are handled by using
 * extension classes to retrieve or set extensions of the appropriate type.
 *
 * 
 */
public class UserDataImpl extends GphotoDataImpl implements UserData {

  /**
   * Construct a new implementation of UserGphotoData with the given
   * extension point as the backing storage for data.
   */
  public UserDataImpl(ExtensionPoint extensionPoint) {
    super(extensionPoint);
  }

  /*
   * Declare the extensions the user object uses.
   */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);

    declare(extProfile, GphotoUsername.getDefaultDescription(false, false));
    declare(extProfile, GphotoNickname.getDefaultDescription(false, false));
    declare(extProfile, GphotoThumbnail.getDefaultDescription(false, false));
    declare(extProfile, GphotoQuotaUsed.getDefaultDescription(false, false));
    declare(extProfile, GphotoQuotaLimit.getDefaultDescription(false, false));
    declare(extProfile, GphotoMaxPhotos.getDefaultDescription(false, false));
  }

  /**
   * @return the username of the user this item represents.
   */
  public String getUsername() {
    return getSimpleValue(GphotoUsername.class);
  }

  /**
   * Set the username for the user this item represents.
   *
   * @param username the username of the user.
   */
  public void setUsername(String username) {
    if (username != null) {
      setExtension(new GphotoUsername(username));
    } else {
      removeExtension(GphotoUsername.class);
    }
  }

  /**
   * @return the nickname of the user this item represents.
   */
  public String getNickname() {
    return getSimpleValue(GphotoNickname.class);
  }

  /**
   * Set the nickname of the user this item represents.
   *
   * @param nickname the nickname of the user.
   */
  public void setNickname(String nickname) {
    if (nickname != null) {
      setExtension(new GphotoNickname(nickname));
    } else {
      removeExtension(GphotoNickname.class);
    }
  }

  /**
   * @return the thumbnail for the user this item represents.
   */
  public String getThumbnail() {
    return getSimpleValue(GphotoThumbnail.class);
  }

  /**
   * Set the thumbnail for the user portrait.
   *
   * @param thumbnail the url to the user portrait image.
   */
  public void setThumbnail(String thumbnail) {
    if (thumbnail != null) {
      setExtension(new GphotoThumbnail(thumbnail));
    } else {
      removeExtension(GphotoThumbnail.class);
    }
  }

  /**
   * @return the quota used up for this user.
   */
  public Long getQuotaUsed() {
    GphotoQuotaUsed ext = getExtension(GphotoQuotaUsed.class);
    return ext == null ? null : ext.getValue();
  }

  /**
   * Set the used quota for the user.
   *
   * @param quota the quota usage in bytes for this user.
   */
  public void setQuotaUsed(Long quota) {
    if (quota != null) {
      setExtension(new GphotoQuotaUsed(quota));
    } else {
      removeExtension(GphotoQuotaUsed.class);
    }
  }

  /**
   * @return the quota limit for the user in bytes.
   */
  public Long getQuotaLimit() {
    GphotoQuotaLimit ext = getExtension(GphotoQuotaLimit.class);
    return ext == null ? null : ext.getValue();
  }

  /**
   * Set the quota limit for the user this item represents.
   *
   * @param quota the quota in bytes for the user.
   */
  public void setQuotaLimit(Long quota) {
    if (quota != null) {
      setExtension(new GphotoQuotaLimit(quota));
    } else {
      removeExtension(GphotoQuotaLimit.class);
    }
  }

  /**
   * @return the maximum number of photos the user can have in an album.
   */
  public Integer getMaxPhotos() {
    GphotoMaxPhotos ext = getExtension(GphotoMaxPhotos.class);
    return ext == null ? null : ext.getValue();
  }

  /**
   * Set the maximum number of photos the user is allowed.
   *
   * @param max the number of photos the user is allowed.
   */
  public void setMaxPhotos(Integer max) {
    if (max != null) {
      setExtension(new GphotoMaxPhotos(max));
    } else {
      removeExtension(GphotoMaxPhotos.class);
    }
  }
}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.projecthosting;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;

/**
 * Entry in the issue cc list.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = ProjectHostingNamespace.ISSUES_ALIAS,
    nsUri = ProjectHostingNamespace.ISSUES,
    localName = Cc.XML_NAME)
public class Cc extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "cc";

  /**
   * Default mutable constructor.
   */
  public Cc() {
    super();
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(Cc.class)) {
      return;
    }
    extProfile.declare(Cc.class, Uri.class);
    extProfile.declare(Cc.class, Username.getDefaultDescription(true, false));
  }

  /**
   * Returns the uri.
   *
   * @return uri
   */
  public Uri getUri() {
    return getExtension(Uri.class);
  }

  /**
   * Sets the uri.
   *
   * @param uri uri or <code>null</code> to reset
   */
  public void setUri(Uri uri) {
    if (uri == null) {
      removeExtension(Uri.class);
    } else {
      setExtension(uri);
    }
  }

  /**
   * Returns whether it has the uri.
   *
   * @return whether it has the uri
   */
  public boolean hasUri() {
    return hasExtension(Uri.class);
  }

  /**
   * Returns the username.
   *
   * @return username
   */
  public Username getUsername() {
    return getExtension(Username.class);
  }

  /**
   * Sets the username.
   *
   * @param username username or <code>null</code> to reset
   */
  public void setUsername(Username username) {
    if (username == null) {
      removeExtension(Username.class);
    } else {
      setExtension(username);
    }
  }

  /**
   * Returns whether it has the username.
   *
   * @return whether it has the username
   */
  public boolean hasUsername() {
    return hasExtension(Username.class);
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
        ExtensionDescription.getDefaultDescription(Cc.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{Cc}";
  }

}


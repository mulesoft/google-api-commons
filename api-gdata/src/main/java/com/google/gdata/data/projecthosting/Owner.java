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
 * Issue owner.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = ProjectHostingNamespace.ISSUES_ALIAS,
    nsUri = ProjectHostingNamespace.ISSUES,
    localName = Owner.XML_NAME)
public class Owner extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "owner";

  /**
   * Default mutable constructor.
   */
  public Owner() {
    super();
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(Owner.class)) {
      return;
    }
    extProfile.declare(Owner.class, Uri.class);
    extProfile.declare(Owner.class, Username.getDefaultDescription(true,
        false));
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
        ExtensionDescription.getDefaultDescription(Owner.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{Owner}";
  }

}


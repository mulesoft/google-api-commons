/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.appsforyourdomain.provisioning;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.data.appsforyourdomain.Email;
import com.google.gdata.data.appsforyourdomain.Login;
import com.google.gdata.data.appsforyourdomain.Name;
import com.google.gdata.data.appsforyourdomain.Quota;
import com.google.gdata.data.extensions.FeedLink;
import com.google.gdata.util.Namespaces;

/**
 * 
 * 
 */
@Kind.Term(UserEntry.USER_KIND)
public class UserEntry extends BaseEntry<UserEntry> {

  /**
   * Kind term value for User category labels.
   */
  public static final String USER_KIND
      = com.google.gdata.data.appsforyourdomain.Namespaces.APPS_PREFIX + "user";

  /**
   * Kind category used to label feeds or entries that have User
   * extension data.
   */
  public static final Category USER_CATEGORY =
      new Category(Namespaces.gKind, USER_KIND);

  /**
   * Constructs a new empty UserEntry with the appropriate kind category
   * to indicate that it is an user.
   */
  public UserEntry() {
    super();
    getCategories().add(USER_CATEGORY);
  }

  /**
   * Constructs a new UserEntry by doing a shallow copy of data from an
   * existing BaseEntry intance.
   */
  public UserEntry(BaseEntry sourceEntry) {
    super(sourceEntry);
    getCategories().add(USER_CATEGORY);
  }

  @Override
  public void declareExtensions(ExtensionProfile extensionProfile) {

    /*
     * We do not set Login and Name as required since the update operation
     * may not specify these.
     */
    extensionProfile.declare(UserEntry.class, Login.getDefaultDescription());
    extensionProfile.declare(UserEntry.class, Email.getDefaultDescription());
    extensionProfile.declare(UserEntry.class, Name.getDefaultDescription());
    extensionProfile.declare(UserEntry.class, Quota.getDefaultDescription());

    // FeedLink extension is not repeatable by default.
    ExtensionDescription desc = FeedLink.getDefaultDescription();
    desc.setRepeatable(true);
    extensionProfile.declare(UserEntry.class, desc);

    // Declare our "apps" namespace
    extensionProfile.declareAdditionalNamespace(
        com.google.gdata.data.appsforyourdomain.Namespaces.APPS_NAMESPACE);
  }

  public Login getLogin() {
    return getExtension(Login.class);
  }

  public Name getName() {
    return getExtension(Name.class);
  }

  public Quota getQuota() {
    return getExtension(Quota.class);
  }

  public Email getEmail() {
    return getExtension(Email.class);
  }

}

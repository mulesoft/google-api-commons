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
import com.google.gdata.data.appsforyourdomain.EmailList;
import com.google.gdata.data.extensions.FeedLink;
import com.google.gdata.util.Namespaces;

/**
 * 
 * 
 */
@Kind.Term(EmailListEntry.EMAIL_LIST_KIND)
public class EmailListEntry extends BaseEntry<EmailListEntry> {

  /**
   * Kind term value for EmailList category labels.
   */
  public static final String EMAIL_LIST_KIND
      = com.google.gdata.data.appsforyourdomain.Namespaces.APPS_PREFIX
      + "emailList";

  /**
   * Kind category used to label feeds or entries that have EmailList
   * extension data.
   */
  public static final Category EMAIL_LIST_CATEGORY =
      new Category(Namespaces.gKind, EMAIL_LIST_KIND);

  /**
   * Constructs a new empty EmailListEntry with the appropriate kind category
   * to indicate that it is an email list.
   */
  public EmailListEntry() {
    super();
    getCategories().add(EMAIL_LIST_CATEGORY);
  }

  /**
   * Constructs a new EmailListEntry by doing a shallow copy of data from an
   * existing BaseEntry intance.
   */
  public EmailListEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
    getCategories().add(EMAIL_LIST_CATEGORY);
  }

  /**
   * Declares an Extension.
   */
  @Override
  public void declareExtensions(ExtensionProfile extensionProfile) {

    // An EmailList extension is required for each entry
    ExtensionDescription desc = EmailList.getDefaultDescription();
    desc.setRequired(true);
    extensionProfile.declare(EmailListEntry.class, desc);

    // FeedLink extension is not repeatable by default.
    desc = FeedLink.getDefaultDescription();
    desc.setRepeatable(true);
    extensionProfile.declare(EmailListEntry.class, desc);

    // Declare our "apps" namespace
    extensionProfile.declareAdditionalNamespace(
        com.google.gdata.data.appsforyourdomain.Namespaces.APPS_NAMESPACE);
  }
  
  public EmailList getEmailList() {
    return getExtension(EmailList.class);
  }
}

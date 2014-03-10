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

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Link;

/**
 * Describes an issue comments entry.
 *
 * 
 */
public class IssueCommentsEntry extends BaseEntry<IssueCommentsEntry> {

  /**
   * Default mutable constructor.
   */
  public IssueCommentsEntry() {
    super();
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public IssueCommentsEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(IssueCommentsEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(IssueCommentsEntry.class,
        IssuesLink.getDefaultDescription(false, true));
    extProfile.declare(IssueCommentsEntry.class, SendEmail.class);
    extProfile.declare(IssueCommentsEntry.class, Updates.class);
    new Updates().declareExtensions(extProfile);
  }

  /**
   * Returns the send email.
   *
   * @return send email
   */
  public SendEmail getSendEmail() {
    return getExtension(SendEmail.class);
  }

  /**
   * Sets the send email.
   *
   * @param sendEmail send email or <code>null</code> to reset
   */
  public void setSendEmail(SendEmail sendEmail) {
    if (sendEmail == null) {
      removeExtension(SendEmail.class);
    } else {
      setExtension(sendEmail);
    }
  }

  /**
   * Returns whether it has the send email.
   *
   * @return whether it has the send email
   */
  public boolean hasSendEmail() {
    return hasExtension(SendEmail.class);
  }

  /**
   * Returns the updates list.
   *
   * @return updates list
   */
  public Updates getUpdates() {
    return getExtension(Updates.class);
  }

  /**
   * Sets the updates list.
   *
   * @param updates updates list or <code>null</code> to reset
   */
  public void setUpdates(Updates updates) {
    if (updates == null) {
      removeExtension(Updates.class);
    } else {
      setExtension(updates);
    }
  }

  /**
   * Returns whether it has the updates list.
   *
   * @return whether it has the updates list
   */
  public boolean hasUpdates() {
    return hasExtension(Updates.class);
  }

  /**
   * Returns the replies Project Hosting Link class.
   *
   * @return Replies Project Hosting Link class or {@code null} for none.
   */
  public Link getAtomRepliesLink() {
    return getLink(IssuesLink.Rel.REPLIES, Link.Type.ATOM);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{IssueCommentsEntry " + super.toString() + "}";
  }

}


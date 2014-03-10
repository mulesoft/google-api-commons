/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.gdata.data.appsforyourdomain.migration;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.data.extensions.Email;
import com.google.gdata.data.media.MediaEntry;
import com.google.gdata.util.Namespaces;

import java.util.List;

/**
 * Used by a MailItemFeedProvider to represent a single MailItemEntry in a list
 * of MailItems. MailItems are representations of email messages from a domain's
 * legacy systems destined for Google.
 * 
 * 
 */
@Kind.Term(MailItemEntry.MAILITEM_KIND)
public class MailItemEntry extends MediaEntry<MailItemEntry> {
  
  /**
   * Kind term value for MailItem category labels.
   */
  public static final String MAILITEM_KIND
      = com.google.gdata.data.appsforyourdomain.Namespaces.APPS_PREFIX
      + "mailItem";

  /**
   * Kind category used to label feeds or entries that have MailItem
   * extension data.
   */
  public static final Category MAILITEM_CATEGORY =
      new Category(Namespaces.gKind, MAILITEM_KIND);   
  
  /**
   * Constructs a new MailItemEntry instance
   */
  public MailItemEntry() {
    super();
    getCategories().add(MAILITEM_CATEGORY);
  }
  
  /**
   * Constructs a new MailItemEntry instance by doing a shallow copy of data
   * from an existing BaseEntry instance.
   * 
   * @param sourceEntry the BaseEntry object to copy from
   */
  public MailItemEntry(BaseEntry<MailItemEntry> sourceEntry) {
    super(sourceEntry);
    getCategories().add(MAILITEM_CATEGORY);
  }

  /**
   * Initializes an ExtensionProfile based upon the extensions expected
   * by a MailItemEntry.
   */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    
    super.declareExtensions(extProfile);
    extProfile.declare(MailItemEntry.class, Email.getDefaultDescription());
    extProfile.declare(MailItemEntry.class, Label.getDefaultDescription());
    extProfile.declare(MailItemEntry.class,
        MailItemProperty.getDefaultDescription());
    extProfile.declare(MailItemEntry.class, Rfc822Msg.getDefaultDescription());
  }
  
  /**
   * @return the rfc822 compliant encoding of the mail message
   */
  public Rfc822Msg getRfc822Msg() {
    return getExtension(Rfc822Msg.class);
  }  
  
  /**
   * Sets the rfc822Msg for this MailItem
   */
  public void setRfc822Msg(Rfc822Msg rfc822Msg) {
    setExtension(rfc822Msg);
  }
  
  /**
   * @return the mail settings (read status, starred status, etc.) of the mail
   * message
   */
  public List<MailItemProperty> getMailProperties() {
    return getRepeatingExtension(MailItemProperty.class);
  }
  
  /**
   * Sets mail settings (read status, starred status, etc.) for this message.
   */
  public void addMailProperty(MailItemProperty mailProperty) {
    addRepeatingExtension(mailProperty);
  }
    
  /**
   * @return a list of Labels to be applied to this message upon insertion in 
   *         GMail
   */
  public List<Label> getLabels() {
    return getRepeatingExtension(Label.class);
  }
  
  /**
   * Adds a label to this MailItem
   * 
   * @param label the label to add to the message when it is imported into GMail
   */
  public void addLabel(Label label) {
    addRepeatingExtension(label);
  }

  /**
   * This is relevant only for multi recipient feed. The single recipient
   * case will not contain the email address of recipient. 
   *
   * @return a list of recipients' email addresses for this mail item
   */
  public List<Email> getRecipients() {
    return getRepeatingExtension(Email.class);
  }

  /**
   * Adds a recipient email to the Mail Item.
   *
   * @param recipient the recipient email to be attached with the message
   */
  public void addRecipient(Email recipient) {
    addRepeatingExtension(recipient);
  }
}

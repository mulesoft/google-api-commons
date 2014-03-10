/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data;

/**
 * Shared interface for model and data BaseEntry to implement.
 *
 * 
 */
public interface IEntry extends IAtom {

  /**
   * Get a {@link DateTime} instance representing the last time this entry was
   * edited.  Represents the app:edited element.
   */
  public DateTime getEdited();

  /**
   * Set the last time this entry was edited using the app:edited element.
   */
  public void setEdited(DateTime edited);

  /**
   * Get a {@link DateTime} instance representing the time that this entry was
   * created.  Represents the atom:published element.
   */
  public DateTime getPublished();

  /**
   * Sets the date of publishing for this entry.  Used on the server to specify
   * when the entry was created.
   */
  public void setPublished(DateTime published);


  /**
   * Returns {@code true} if the entry can be modified by a client.
   */
  public boolean getCanEdit();

  /**
   * Sets whether the server allows this entry to be modified by the client.
   */
  public void setCanEdit(boolean canEdit);

  /**
   * Gets the content of this entry.  Represents the atom:content element.
   */
  public IContent getContent();

  /**
   * Returns the atom:summary element of this entry.
   */
  public ITextConstruct getSummary();

  /**
   * Gets the edit link, which is the link to PUT an updated version of the
   * entry to.  Will return null if no edit link is available.
   */
  public ILink getEditLink();

  /**
   * Gets the media-edit link, which is the link to PUT an updated version of
   * the media content to.  Will return null if the media-edit link does not
   * exist.
   */
  public ILink getMediaEditLink();

  /**
   * Gets the resumable-edit-media link, which is the link to PUT an updated
   * version of the media content to using Resumable Upload IO.  Will return
   * null if the media-edit link does not exist.
   */
  public ILink getResumableEditMediaLink();

  /**
   * Returns the set of selected fields for the entry if the entry contains a
   * partial representation or {@code null} if it is a full representation.
   */
  public String getSelectedFields();

  /**
   * Sets the current fields selection for this partial entry.  A
   * value of {@code null} indicates the entry is not a partial entry.
   */
  public void setSelectedFields(String fields);
}

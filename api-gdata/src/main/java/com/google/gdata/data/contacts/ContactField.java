/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.contacts;

/**
 * Describes an interface that is common to all Contact fields.
 *
 * 
 */
public interface ContactField {
  /**
   * Returns whether this field has a readonly attribute.
   *
   * @return whether it has a readonly attribute.
   */
  public boolean hasReadonly();

  /**
   * Returns the value of the read-only attribute.
   *
   * @return the value of the readonly attribute.
   */
  public Boolean getReadonly();

  /**
   * Returns whether this field is read-only.
   * This is different than getReadonly in that the former can return a null
   * value if the attribute doesn't exist, whereas this method will return false
   * in that case.
   * @return whether the field is read-only.
   */
  public boolean isReadonly();

  /**
   * Sets whether this field is read-only.
   *
   * @param readonly whether this field is read-only or <code>null</code> to
   *     reset
   */
  public void setReadonly(Boolean readonly);

  /**
   * Returns whether it has the source of the data in this field.
   *
   * @return whether it has the source of the data in this field
   */
  public boolean hasSource();

  /**
   * Returns the source of the data in this field, or null if there is no
   * source attribute.
   *
   * @return source of the data in this field
   */
  public String getSource();

  /**
   * Sets the source of the data in this field.
   *
   * @param source source of the data in this field or <code>null</code> to
   *     reset
   */
  public void setSource(String source);

  /**
   * Returns the profile email(s) to which this field causes a link, if any.
   *
   * @return profile email(s) to which this field causes a link.
   */
  public String getLinksto();

  /**
   * Sets the profile email(s) to which this field causes a link.
   *
   * @param linksto The profile email(s) to which this field causes a link or
   *     <code>null</code> to reset
   */
  public void setLinksto(String linksto);

  /**
   * Returns whether it has the profile email(s) to which this field causes a
   * link.
   *
   * @return whether it has the profile email(s) to which this field causes a
   *     link.
   */
  public boolean hasLinksto();
}

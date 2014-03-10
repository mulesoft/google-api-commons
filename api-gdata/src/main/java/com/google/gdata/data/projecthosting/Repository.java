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

import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.ParseException;

/**
 * Project repository information.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = ProjectHostingNamespace.PROJECTS_ALIAS,
    nsUri = ProjectHostingNamespace.PROJECTS,
    localName = Repository.XML_NAME)
public class Repository extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "repository";

  /** XML "type" attribute name */
  private static final String TYPE = "type";

  private static final AttributeHelper.EnumToAttributeValue<Type>
      TYPE_ENUM_TO_ATTRIBUTE_VALUE = new
      AttributeHelper.LowerCaseEnumToAttributeValue<Type>();

  /** Type */
  private Type type = null;

  /** Type. */
  public enum Type {

    /** Hg repository. */
    HG,

    /** Svn repository. */
    SVN

  }

  /**
   * Default mutable constructor.
   */
  public Repository() {
    super();
  }

  /**
   * Immutable constructor.
   *
   * @param type type.
   */
  public Repository(Type type) {
    super();
    setType(type);
    setImmutable(true);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(Repository.class)) {
      return;
    }
    extProfile.declare(Repository.class, RepositoryUrl.class);
  }

  /**
   * Returns the repository url.
   *
   * @return repository url
   */
  public RepositoryUrl getRepositoryUrl() {
    return getExtension(RepositoryUrl.class);
  }

  /**
   * Sets the repository url.
   *
   * @param repositoryUrl repository url or <code>null</code> to reset
   */
  public void setRepositoryUrl(RepositoryUrl repositoryUrl) {
    if (repositoryUrl == null) {
      removeExtension(RepositoryUrl.class);
    } else {
      setExtension(repositoryUrl);
    }
  }

  /**
   * Returns whether it has the repository url.
   *
   * @return whether it has the repository url
   */
  public boolean hasRepositoryUrl() {
    return hasExtension(RepositoryUrl.class);
  }

  /**
   * Returns the type.
   *
   * @return type
   */
  public Type getType() {
    return type;
  }

  /**
   * Sets the type.
   *
   * @param type type or <code>null</code> to reset
   */
  public void setType(Type type) {
    throwExceptionIfImmutable();
    this.type = type;
  }

  /**
   * Returns whether it has the type.
   *
   * @return whether it has the type
   */
  public boolean hasType() {
    return getType() != null;
  }

  @Override
  protected void validate() {
    if (type == null) {
      throwExceptionForMissingAttribute(TYPE);
    }
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
        ExtensionDescription.getDefaultDescription(Repository.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    generator.put(TYPE, type, TYPE_ENUM_TO_ATTRIBUTE_VALUE);
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper) throws ParseException
      {
    type = helper.consumeEnum(TYPE, true, Type.class, null,
        TYPE_ENUM_TO_ATTRIBUTE_VALUE);
  }

  @Override
  public String toString() {
    return "{Repository type=" + type + "}";
  }

}


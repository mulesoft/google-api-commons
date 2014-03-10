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
 * Issue blocked by this issue.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = ProjectHostingNamespace.ISSUES_ALIAS,
    nsUri = ProjectHostingNamespace.ISSUES,
    localName = Blocking.XML_NAME)
public class Blocking extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "blocking";

  /**
   * Default mutable constructor.
   */
  public Blocking() {
    super();
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(Blocking.class)) {
      return;
    }
    extProfile.declare(Blocking.class, Id.getDefaultDescription(true, false));
    extProfile.declare(Blocking.class, Project.class);
  }

  /**
   * Returns the id.
   *
   * @return id
   */
  public Id getId() {
    return getExtension(Id.class);
  }

  /**
   * Sets the id.
   *
   * @param id id or <code>null</code> to reset
   */
  public void setId(Id id) {
    if (id == null) {
      removeExtension(Id.class);
    } else {
      setExtension(id);
    }
  }

  /**
   * Returns whether it has the id.
   *
   * @return whether it has the id
   */
  public boolean hasId() {
    return hasExtension(Id.class);
  }

  /**
   * Returns the project.
   *
   * @return project
   */
  public Project getProject() {
    return getExtension(Project.class);
  }

  /**
   * Sets the project.
   *
   * @param project project or <code>null</code> to reset
   */
  public void setProject(Project project) {
    if (project == null) {
      removeExtension(Project.class);
    } else {
      setExtension(project);
    }
  }

  /**
   * Returns whether it has the project.
   *
   * @return whether it has the project
   */
  public boolean hasProject() {
    return hasExtension(Project.class);
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
        ExtensionDescription.getDefaultDescription(Blocking.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{Blocking}";
  }

}


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

import java.util.List;

/**
 * Google Code Project Summary Entry.
 *
 * 
 */
public class ProjectSummaryEntry extends BaseEntry<ProjectSummaryEntry> {

  /**
   * Default mutable constructor.
   */
  public ProjectSummaryEntry() {
    super();
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public ProjectSummaryEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(ProjectSummaryEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(ProjectSummaryEntry.class, Description.class);
    extProfile.declare(ProjectSummaryEntry.class,
        IssuesLink.getDefaultDescription(false, true));
    extProfile.declare(ProjectSummaryEntry.class,
        ProjectLabel.getDefaultDescription(false, true));
    extProfile.declare(ProjectSummaryEntry.class,
        Repository.getDefaultDescription(false, true));
    new Repository().declareExtensions(extProfile);
  }

  /**
   * Returns the description.
   *
   * @return description
   */
  public Description getDescription() {
    return getExtension(Description.class);
  }

  /**
   * Sets the description.
   *
   * @param description description or <code>null</code> to reset
   */
  public void setDescription(Description description) {
    if (description == null) {
      removeExtension(Description.class);
    } else {
      setExtension(description);
    }
  }

  /**
   * Returns whether it has the description.
   *
   * @return whether it has the description
   */
  public boolean hasDescription() {
    return hasExtension(Description.class);
  }

  /**
   * Returns the project labels.
   *
   * @return project labels
   */
  public List<ProjectLabel> getProjectLabels() {
    return getRepeatingExtension(ProjectLabel.class);
  }

  /**
   * Adds a new project label.
   *
   * @param projectLabel project label
   */
  public void addProjectLabel(ProjectLabel projectLabel) {
    getProjectLabels().add(projectLabel);
  }

  /**
   * Returns whether it has the project labels.
   *
   * @return whether it has the project labels
   */
  public boolean hasProjectLabels() {
    return hasRepeatingExtension(ProjectLabel.class);
  }

  /**
   * Returns the repositories.
   *
   * @return repositories
   */
  public List<Repository> getRepositories() {
    return getRepeatingExtension(Repository.class);
  }

  /**
   * Adds a new repository.
   *
   * @param repository repository
   */
  public void addRepository(Repository repository) {
    getRepositories().add(repository);
  }

  /**
   * Returns whether it has the repositories.
   *
   * @return whether it has the repositories
   */
  public boolean hasRepositories() {
    return hasRepeatingExtension(Repository.class);
  }

  /**
   * Returns the link that provides the URI of a related link to the entry.
   *
   * @return Link that provides the URI of a related link to the entry or {@code
   *     null} for none.
   */
  public Link getRelatedLink() {
    return getLink(Link.Rel.RELATED, Link.Type.ATOM);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{ProjectSummaryEntry " + super.toString() + "}";
  }

}


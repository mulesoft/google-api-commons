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

import com.google.gdata.util.common.xml.XmlNamespace;

/**
 * Namespace definitions related to Project Hosting GData API.
 *
 * 
 */
public class ProjectHostingNamespace {

  private ProjectHostingNamespace() {}

  /** ProjectHostingIssues (ISSUES) namespace */
  public static final String ISSUES =
      "http://schemas.google.com/projecthosting/issues/2009";

  /** ProjectHostingIssues (ISSUES) namespace prefix */
  public static final String ISSUES_PREFIX = ISSUES + "#";

  /** ProjectHostingIssues (ISSUES) namespace alias */
  public static final String ISSUES_ALIAS = "issues";

  /** XML writer namespace for ProjectHostingIssues (ISSUES) */
  public static final XmlNamespace ISSUES_NS = new XmlNamespace(ISSUES_ALIAS,
      ISSUES);

  /** ProjectHostingProjects (PROJECTS) namespace */
  public static final String PROJECTS =
      "http://schemas.google.com/projecthosting/projects/2010";

  /** ProjectHostingProjects (PROJECTS) namespace prefix */
  public static final String PROJECTS_PREFIX = PROJECTS + "#";

  /** ProjectHostingProjects (PROJECTS) namespace alias */
  public static final String PROJECTS_ALIAS = "projects";

  /** XML writer namespace for ProjectHostingProjects (PROJECTS) */
  public static final XmlNamespace PROJECTS_NS = new
      XmlNamespace(PROJECTS_ALIAS, PROJECTS);

}


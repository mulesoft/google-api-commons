/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.appsforyourdomain.adminsettings;

import com.google.gdata.client.appsforyourdomain.AppsPropertyService;
import com.google.gdata.data.appsforyourdomain.AppsForYourDomainException;
import com.google.gdata.data.appsforyourdomain.generic.GenericEntry;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.URL;

/**
 * Specialization of {@link AppsPropertyService} for managing domain verification
 * options of a domain.
 *
 * 
 *
 */
public class DomainVerificationService extends AppsPropertyService {

  protected String domainUrlBase = null;
  protected String verificationBaseUrl;

  /**
   * Parameterized constructor to setup a Service object which can be used to
   * initialize the service without obtaining a token. The user should
   * explicitly authorize the service by calling either {@code
   * setUserCredentials} or {@code setUserToken} when using this constructor.
   * 
   * @param domain Domain being configured
   * @param applicationName Application name consuming the API
   */
  public DomainVerificationService(String domain, String applicationName) {
    super(applicationName);
    domainUrlBase = AdminSettingsConstants.APPS_FEEDS_URL_BASE + domain + "/";
    verificationBaseUrl = domainUrlBase + "verification/";
  }

  /**
   * Parameterized constructor for service authentication.
   * 
   * @param adminEmail the email id of the administrator.
   * @param password the administrator password.
   * @param domain the domain name to be configured.
   * @param applicationName the calling client application name.for e.g.
   *        mycompany-java
   * @throws AuthenticationException if an authentication related error occurs.
   */
  public DomainVerificationService(String adminEmail, String password, String domain,
      String applicationName) throws AuthenticationException {
    this(domain, applicationName);
    setUserCredentials(adminEmail, password);
  }

  /**
   * 
   * @return GenericEntry a GenericEntry instance with CNAME verification
   *         status.
   * @throws AppsForYourDomainException if an Apps for your domain API error
   *         occurred.
   * @throws IOException if an error occurs while communicating with the GData
   *         service.
   * @throws ServiceException if the fetch request failed due to system error.
   */
  public GenericEntry retrieveCnameVerificationStatus() throws AppsForYourDomainException,
      IOException, ServiceException {
    return getEntry(new URL(verificationBaseUrl + "cname"), GenericEntry.class);
  }

  /**
   * 
   * @return GenericEntry a GenericEntry instance with CNAME verification
   *         status.
   * @throws AppsForYourDomainException if an Apps for your domain API error
   *         occurred.
   * @throws IOException if an error occurs while communicating with the GData
   *         service.
   * @throws ServiceException if the fetch request failed due to system error.
   */
  public GenericEntry retrieveMxVerificationStatus() throws AppsForYourDomainException,
      IOException, ServiceException {
    return getEntry(new URL(verificationBaseUrl + "mx"), GenericEntry.class);
  }


  /**
   * Sets the verified status as true for a previously retrieved MX or CNAME
   * verification status entry;
   * 
   * @param entry a previously retrieved GenericEntry instance to be updated
   *        with status as verified.
   * 
   * @return GenericEntry instance with updated settings.
   * @throws AppsForYourDomainException if an Apps for your domain API error
   *         occurred.
   * @throws IOException if an error occurs while communicating with the GData
   *         service.
   * @throws ServiceException if the fetch request failed due to system error.
   */
  public GenericEntry updateVerifiedStatus(GenericEntry entry, boolean status)
      throws AppsForYourDomainException, IOException, ServiceException {
    entry.removeProperty("verified");
    entry.addProperty("verified", String.valueOf(status));
    return entry.update();
  }
}


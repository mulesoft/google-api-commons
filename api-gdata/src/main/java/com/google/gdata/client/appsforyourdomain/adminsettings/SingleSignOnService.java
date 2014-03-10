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
 * Specialization of {@link AppsPropertyService} for managing SSO related
 * settings of a domain.
 * 
 * 
 */
public class SingleSignOnService extends AppsPropertyService {

  protected String ssoSettingsUrl;
  protected String ssoSigningKeyUrl;
  protected String domainUrlBase;

  /**
   * Parameterized constructor to setup a Service object which can be used to
   * initialize the service without obtaining a token. The user should
   * explicitly authorize the service by calling either {@code
   * setUserCredentials} or {@code setUserToken} when using this constructor.
   * 
   * @param domain Domain being configured
   * @param applicationName Application name consuming the API
   */
  public SingleSignOnService(String domain, String applicationName) {
    super(applicationName);
    domainUrlBase = AdminSettingsConstants.APPS_FEEDS_URL_BASE + domain + "/";
    ssoSettingsUrl = domainUrlBase + AdminSettingsConstants.APPS_SSO_GENERAL_URL_SUFFIX;
    ssoSigningKeyUrl = domainUrlBase + AdminSettingsConstants.APPS_SSO_SIGNING_URL_SUFFIX;
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
  public SingleSignOnService(String adminEmail, String password, String domain,
      String applicationName) throws AuthenticationException {
    this(domain, applicationName);
    setUserCredentials(adminEmail, password);
  }

  /**
   * Updates the SSO properties with the GenericEntry values.
   * 
   * @param entry a GenericEntry object with SSO properties
   * @return a GenericEntry with the updated properties
   * @throws IOException if an error occurs while communicating with the GData
   *         service.
   * @throws AppsForYourDomainException if an Apps for your domain API error
   *         occurred.
   * @throws ServiceException if the insert request failed due to system error.
   */
  public GenericEntry updateSSOSettings(GenericEntry entry) throws AppsForYourDomainException,
      IOException, ServiceException {
    return update(new URL(ssoSettingsUrl), entry);
  }

  /**
   * Updates the public key used for SSO.
   * 
   * @param base64EncodedKey
   * @return a GenericEntry object with the updated SSO signing key.
   * @throws IOException if an error occurs while communicating with the GData
   *         service.
   * @throws AppsForYourDomainException if an Apps for your domain API error
   *         occurred.
   * @throws ServiceException if the fetch request failed due to system error.
   */
  public GenericEntry updateSsoSigningKey(String base64EncodedKey) throws IOException,
      AppsForYourDomainException, ServiceException {
    GenericEntry entry = new GenericEntry();
    entry.addProperty(AdminSettingsConstants.KEY_PROPERTY, base64EncodedKey);
    return update(new URL(ssoSigningKeyUrl), entry);
  }

  /**
   * Retrieves the certificate uploaded to the domain for SSO.
   * 
   * @return A GenericEntry with one or more of the following properties
   *         depending on the key format: {exponent, yValue, format, modulus,
   *         algorithm}
   * @throws AppsForYourDomainException if an Apps for your domain API error
   *         occurred.
   * @throws IOException if an error occurs while communicating with the GData
   *         service.
   * @throws ServiceException if the fetch request failed due to system error.
   */
  public GenericEntry getSsoSigningKey() throws AppsForYourDomainException, IOException,
      ServiceException {
    return getEntry(new URL(ssoSigningKeyUrl), GenericEntry.class);
  }

  /**
   * Retrieves the SSO properties configured for the domain.
   * 
   * @return a GenericEntry object with all the SSO properties.
   * @throws AppsForYourDomainException if an Apps for your domain API error
   *         occurred.
   * @throws IOException if an error occurs while communicating with the GData
   *         service.
   * @throws ServiceException if the fetch request failed due to system error.
   */
  public GenericEntry getSsoSettings() throws AppsForYourDomainException, IOException,
      ServiceException {
    return getEntry(new URL(ssoSettingsUrl), GenericEntry.class);
  }

}

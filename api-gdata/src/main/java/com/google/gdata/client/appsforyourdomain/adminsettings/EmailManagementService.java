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
import com.google.gdata.data.appsforyourdomain.generic.GenericFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Specialization of {@link AppsPropertyService} for managing Email migration,
 * routing and outbound gateway settings of a domain.
 * 
 * 
 */
public class EmailManagementService extends AppsPropertyService {

  protected String domainUrlBase = null;
  protected String emailBaseUrl;

  /**
   * Parameterized constructor to setup a Service object which can be used to
   * initialize the service without obtaining a token. The user should
   * explicitly authorize the service by calling either {@code
   * setUserCredentials} or {@code setUserToken} when using this constructor.
   * 
   * @param domain Domain being configured
   * @param applicationName Application name consuming the API
   */
  public EmailManagementService(String domain, String applicationName) {
    super(applicationName);
    domainUrlBase = AdminSettingsConstants.APPS_FEEDS_URL_BASE + domain + "/";
    emailBaseUrl = domainUrlBase + "email/";
  }

  /**
   * Parameterized constructor for service authentication.
   * 
   * @param adminEmail the email id of the administrator.
   * @param password the administrator password.
   * @param domain the domain name to be configured.
   * @throws AuthenticationException if an authentication related error occurs.
   */
  public EmailManagementService(String adminEmail, String password, String domain,
      String applicationName) throws AuthenticationException {
    this(domain, applicationName);
    setUserCredentials(adminEmail, password);
  }

  /**
   * Retrieves the migration access settings
   * 
   * @return true, if user migration access is enabled.
   * @throws AppsForYourDomainException
   * @throws IOException
   * @throws ServiceException
   */
  public boolean isUserMigrationEnabled() throws AppsForYourDomainException, MalformedURLException,
      IOException, ServiceException {
    return getEntry(new URL(emailBaseUrl + "migration"), GenericEntry.class).getProperty(
        "enableUserMigration").equalsIgnoreCase("true");
  }

  /**
   * Grants email migration access to users.
   * 
   * @param enableUserMigration If true, user migration access is granted.
   * @throws AppsForYourDomainException if an Apps for your domain API error
   *         occurred.
   * @throws IOException if an error occurs while communicating with the GData
   *         service.
   * @throws ServiceException if the fetch request failed due to system error.
   */
  public void setUserMigrationAccess(boolean enableUserMigration)
      throws AppsForYourDomainException, IOException, ServiceException {
    GenericEntry entry = new GenericEntry();
    entry.addProperty("enableUserMigration", String.valueOf(enableUserMigration));
    update(new URL(emailBaseUrl + "migration"), entry);
  }


  /**
   * Retrieves the outbound gateway settings for the domain.
   * 
   * @return GenericEntry a updated GenericEntry instance with outbound gateway
   *         settings.
   * @throws AppsForYourDomainException if an Apps for your domain API error
   *         occurred.
   * @throws IOException if an error occurs while communicating with the GData
   *         service.
   * @throws ServiceException if the fetch request failed due to system error.
   */
  public GenericEntry retrieveOutboundGatewaySettings() throws AppsForYourDomainException,
      MalformedURLException, IOException, ServiceException {
    return getEntry(new URL(emailBaseUrl + "gateway"), GenericEntry.class);
  }

  /**
   * Updates the outbound gateway settings for the domain.
   * 
   * @param smartHost either the IP address or hostname of your SMTP server.
   *        Google Apps routes outgoing mail to this server.
   * @param smtpMode the default value is SMTP. Another value, SMTP_TLS, secures
   *        a TLS connection with TLS when delivering the message.
   * 
   * @return GenericEntry a updated GenericEntry instance with outbound gateway
   *         settings.
   * @throws AppsForYourDomainException if an Apps for your domain API error
   *         occurred.
   * @throws IOException if an error occurs while communicating with the GData
   *         service.
   * @throws ServiceException if the fetch request failed due to system error.
   */
  public GenericEntry updateOutboundGatewaySettings(String smartHost, String smtpMode)
      throws AppsForYourDomainException, IOException, ServiceException {
    GenericEntry entry = new GenericEntry();
    entry.addProperty("smartHost", smartHost);
    entry.addProperty("smtpMode", smtpMode);
    return update(new URL(emailBaseUrl + "gateway"), entry);
  }

  /**
   * Retrieves all configured email routing settings as a GenericFeed.
   * 
   * @return GenericFeed a GenericFeed with email routing settings.
   * 
   * @throws AppsForYourDomainException if an Apps for your domain API error
   *         occurred.
   * @throws IOException if an error occurs while communicating with the GData
   *         service.
   * @throws ServiceException if the fetch request failed due to system error.
   */
  public GenericFeed retrieveEmailRoutingSettings() throws AppsForYourDomainException, IOException,
      ServiceException {
    return getFeed(new URL(domainUrlBase + "emailrouting"), GenericFeed.class);
  }

}

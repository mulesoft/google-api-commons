/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.sidewiki;

import com.google.gdata.client.AuthTokenFactory;
import com.google.gdata.client.GoogleService;
import com.google.gdata.client.Service;
import com.google.gdata.data.sidewiki.SidewikiEntryFeed;
import com.google.gdata.data.sidewiki.SidewikiUserFeed;
import com.google.gdata.util.Version;
import com.google.gdata.util.VersionRegistry;

/**
 * Extends the basic {@link GoogleService} abstraction to define a service that
 * is preconfigured for access to the Google Sidewiki Data API.
 *
 * 
 */
public class SidewikiService extends GoogleService {

  /**
   * The abbreviated name of Google Sidewiki Data API recognized by Google.  The
   * service name is used when requesting an authentication token.
   */
  public static final String SIDEWIKI_SERVICE = "annotateweb";

  /**
   * The version ID of the service.
   */
  public static final String SIDEWIKI_SERVICE_VERSION = "GSidewiki-Java/" +
      SidewikiService.class.getPackage().getImplementationVersion();

  /** GData versions supported by the Google Sidewiki Data API. */
  public static final class Versions {

    /** Version 1. */
    public static final Version V1 = new Version(SidewikiService.class, "1.0",
        Service.Versions.V1);

    /** Version 2. */
    public static final Version V2 = new Version(SidewikiService.class, "2.0",
        Service.Versions.V2);

    /** Version {@code 2.1}. */
    public static final Version V2_1 = new Version(SidewikiService.class, "2.1",
        Service.Versions.V2);

    private Versions() {}
  }

  /**
   * Default GData version used by the Google Sidewiki Data API.
   */
  public static final Version DEFAULT_VERSION =
      Service.initServiceVersion(SidewikiService.class, Versions.V2);

  /**
   * Constructs an instance connecting to the Google Sidewiki Data API for an
   * application with the name {@code applicationName}.
   *
   * @param applicationName the name of the client application accessing the
   *     service. Application names should preferably have the format
   *     [company-id]-[app-name]-[app-version]. The name will be used by the
   *     Google servers to monitor the source of authentication.
   */
  public SidewikiService(String applicationName) {
    super(SIDEWIKI_SERVICE, applicationName);
    declareExtensions();
  }

  /**
   * Constructs an instance connecting to the Google Sidewiki Data API for an
   * application with the name {@code applicationName} and the given {@code
   * GDataRequestFactory} and {@code AuthTokenFactory}. Use this constructor to
   * override the default factories.
   *
   * @param applicationName the name of the client application accessing the
   *     service. Application names should preferably have the format
   *     [company-id]-[app-name]-[app-version]. The name will be used by the
   *     Google servers to monitor the source of authentication.
   * @param requestFactory the request factory that generates gdata request
   *     objects
   * @param authTokenFactory the factory that creates auth tokens
   */
  public SidewikiService(String applicationName,
      Service.GDataRequestFactory requestFactory,
      AuthTokenFactory authTokenFactory) {
    super(applicationName, requestFactory, authTokenFactory);
    declareExtensions();
  }

  /**
   * Constructs an instance connecting to the Google Sidewiki Data API with name
   * {@code serviceName} for an application with the name {@code
   * applicationName}.  The service will authenticate at the provided {@code
   * domainName}.
   *
   * @param applicationName the name of the client application accessing the
   *     service. Application names should preferably have the format
   *     [company-id]-[app-name]-[app-version]. The name will be used by the
   *     Google servers to monitor the source of authentication.
   * @param protocol        name of protocol to use for authentication
   *     ("http"/"https")
   * @param domainName      the name of the domain hosting the login handler
   */
  public SidewikiService(String applicationName, String protocol,
      String domainName) {
    super(SIDEWIKI_SERVICE, applicationName, protocol, domainName);
    declareExtensions();
  }

  @Override
  public String getServiceVersion() {
    return SIDEWIKI_SERVICE_VERSION + " " + super.getServiceVersion();
  }

  /**
   * Returns the current GData version used by the Google Sidewiki Data API.
   */
  public static Version getVersion() {
    return VersionRegistry.get().getVersion(SidewikiService.class);
  }

  /**
   * Declare the extensions of the feeds for the Google Sidewiki Data API.
   */
  private void declareExtensions() {
    new SidewikiEntryFeed().declareExtensions(extProfile);
    new SidewikiUserFeed().declareExtensions(extProfile);
  }

}


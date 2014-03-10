/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.gdata.client.health;

import com.google.gdata.client.GoogleService;
import com.google.gdata.data.health.ProfileFeed;
import com.google.gdata.data.health.RegisterFeed;

/**
 * The H9Service class extends the basic {@link GoogleService} abstraction
 * to define a service that is preconfigured for access to the Health data API.
 *
 * 
 */
public class H9Service extends GoogleService {

  /**
   * The abbreviated name of Health recognized by Google.  The service name is
   * used when requesting an authentication token.
   */
  public static final String H9_SERVICE = "weaver";

  /**
   * The version ID of the service.
   */
  public static final String H9_SERVICE_VERSION = "GHealth-Java/" +
      H9Service.class.getPackage().getImplementationVersion();

  /**
   * Constructs a H9Service instance connecting to the Health service for an
   * application with the name {@code applicationName}.
   *
   * @param applicationName the name of the client application accessing the
   *                        service. Application names should preferably have
   *                        the format [company-id]-[app-name]-[app-version].
   *                        The name will be used by the Google servers to
   *                        monitor the source of authentication.
   */
  public H9Service(String applicationName) {
    this(applicationName, "https", "www.google.com");
  }

  /**
   * Constructs a GoogleService instance connecting to the Health service with
   * name {@code serviceName} for an application with the name {@code
   * applicationName}.  The service will authenticate at the provided {@code
   * domainName}.
   *
   * @param applicationName the name of the client application accessing the
   *                        service. Application names should preferably have
   *                        the format [company-id]-[app-name]-[app-version].
   *                        The name will be used by the Google servers to
   *                        monitor the source of authentication.
   * @param protocol        name of protocol to use for authentication
   *                        ("http"/"https")
   * @param domainName      the name of the domain hosting the login handler
   */
  public H9Service(String applicationName, String protocol,
      String domainName) {
    super(H9_SERVICE, applicationName, protocol, domainName);

    // Declare the extensions of the feeds
    new ProfileFeed().declareExtensions(getExtensionProfile());
    new RegisterFeed().declareExtensions(getExtensionProfile());
  }

  public String getServiceVersion() {
    return H9_SERVICE_VERSION + " " + super.getServiceVersion();
  }

}

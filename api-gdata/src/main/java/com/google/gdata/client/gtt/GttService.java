/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.gtt;

import com.google.gdata.client.AuthTokenFactory;
import com.google.gdata.client.Service;
import com.google.gdata.client.media.MediaService;
import com.google.gdata.data.acl.AclFeed;
import com.google.gdata.data.gtt.DocumentFeed;
import com.google.gdata.data.gtt.GlossaryFeed;
import com.google.gdata.data.gtt.TranslationMemoryFeed;
import com.google.gdata.util.Version;
import com.google.gdata.util.VersionRegistry;

/**
 * Extends the basic {@link MediaService} abstraction to define a service that
 * is preconfigured for access to the Google Translator Toolkit API.
 *
 * 
 */
public class GttService extends MediaService {

  /**
   * The abbreviated name of Google Translator Toolkit API recognized by Google.
   * The service name is used when requesting an authentication token.
   */
  public static final String GTT_SERVICE = "gtrans";

  /**
   * The version ID of the service.
   */
  public static final String GTT_SERVICE_VERSION = "GGtt-Java/" +
      GttService.class.getPackage().getImplementationVersion();

  /** GData versions supported by the Google Translator Toolkit API. */
  public static final class Versions {

    /** Version 1.  This is the initial version of the API and is based on
     * Version 2 of the GData protocol. */
    public static final Version V1 = new Version(GttService.class, "1.0",
        Service.Versions.V2_1);

    private Versions() {}
  }

  /**
   * Default GData version used by the Google Translator Toolkit API.
   */
  public static final Version DEFAULT_VERSION =
      Service.initServiceVersion(GttService.class, Versions.V1);

  /**
   * Constructs an instance connecting to the Google Translator Toolkit API for
   * an application with the name {@code applicationName}.
   *
   * @param applicationName the name of the client application accessing the
   *     service. Application names should preferably have the format
   *     [company-id]-[app-name]-[app-version]. The name will be used by the
   *     Google servers to monitor the source of authentication.
   */
  public GttService(String applicationName) {
    super(GTT_SERVICE, applicationName);
    declareExtensions();
  }

  /**
   * Constructs an instance connecting to the Google Translator Toolkit API for
   * an application with the name {@code applicationName} and the given {@code
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
  public GttService(String applicationName,
      Service.GDataRequestFactory requestFactory,
      AuthTokenFactory authTokenFactory) {
    super(applicationName, requestFactory, authTokenFactory);
    declareExtensions();
  }

  /**
   * Constructs an instance connecting to the Google Translator Toolkit API with
   * name {@code serviceName} for an application with the name {@code
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
  public GttService(String applicationName, String protocol,
      String domainName) {
    super(GTT_SERVICE, applicationName, protocol, domainName);
    declareExtensions();
  }

  @Override
  public String getServiceVersion() {
    return GTT_SERVICE_VERSION + " " + super.getServiceVersion();
  }

  /**
   * Returns the current GData version used by the Google Translator Toolkit
   * API.
   */
  public static Version getVersion() {
    return VersionRegistry.get().getVersion(GttService.class);
  }

  /**
   * Declare the extensions of the feeds for the Google Translator Toolkit API.
   */
  private void declareExtensions() {
    new AclFeed().declareExtensions(extProfile);
    new DocumentFeed().declareExtensions(extProfile);
    new GlossaryFeed().declareExtensions(extProfile);
    new TranslationMemoryFeed().declareExtensions(extProfile);
  }

}


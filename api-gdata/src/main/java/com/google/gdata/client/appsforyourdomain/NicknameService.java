/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.appsforyourdomain;

import com.google.gdata.data.appsforyourdomain.provisioning.NicknameFeed;


/**
 * The NicknameService class extends the basic {@link AppsForYourDomainService}
 * abstraction to define a service that is preconfigured for access to the
 * Nickname Feed in the Google Apps for Your Domain GData API.
 */
public class NicknameService extends AppsForYourDomainService {

  /**
   * Constructs a NicknameService instance for an application with
   * the name {@code applicationName}.
   *
   * @param applicationName the name of the client application accessing the
   *                        service. Application names should preferably have
   *                        the format [company-id]-[app-name]-[app-version].
   *                        The name will be used by the Google servers to
   *                        monitor the source of authentication.
   */
  public NicknameService(String applicationName) {
    super(applicationName, HTTPS_PROTOCOL, DOMAIN_NAME);
    new NicknameFeed().declareExtensions(getExtensionProfile());
  }


}

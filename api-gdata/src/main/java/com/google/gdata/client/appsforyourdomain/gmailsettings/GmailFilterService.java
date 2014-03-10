/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.client.appsforyourdomain.gmailsettings;

import com.google.gdata.client.appsforyourdomain.AppsForYourDomainService;
import com.google.gdata.client.batch.BatchInterruptedException;
import com.google.gdata.data.appsforyourdomain.generic.GenericEntry;
import com.google.gdata.data.appsforyourdomain.generic.GenericFeed;
import com.google.gdata.data.batch.BatchOperationType;
import com.google.gdata.data.batch.BatchUtils;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The GmailFilterService class extends the basic {@link AppsForYourDomainService}
 * abstraction to define a service that is preconfigured for access to the
 * the Google Apps Gmail Settings API.
 * 
 * 
 */
public class GmailFilterService extends AppsForYourDomainService {
  
  /**
   * Domain for sending API requests. 
   */
  public static final String APPS_APIS_DOMAIN = "apps-apis.google.com";
  
  /**
   * URL prefix for accessing Gmail setting feeds. 
   */
  public static final String URL_PREFIX = "/a/feeds/2.0";

  /**
   * URL suffix for the single Gmail filter feed.
   */
  public static final String URL_SUFFIX = "/email/settings/filter"; 
  
  /**
   * URL suffix for the Gmail filter batch feed.
   */
  public static final String BATCH_URL_SUFFIX = "/email/settings/filter/batch"; 
  
  /**
   * Constructs a GmailFilterService instance for an application with
   * the name {@code applicationName}.
   *
   * @param applicationName the name of the client application accessing the
   *                        service. Application names should preferably have
   *                        the format [company-id]-[app-name]-[app-version].
   *                        The name will be used by the Google servers to
   *                        monitor the source of authentication.
   */
  public GmailFilterService(String applicationName) {
    super(applicationName, HTTPS_PROTOCOL, DOMAIN_NAME);
    
    BatchUtils.declareExtensions(getExtensionProfile());
    new GenericFeed().declareExtensions(getExtensionProfile());
  }
  
  /**
   * Inserts one Gmail filter entry. 
   * 
   * @param domain the domain into which the filter is being created.
   * @param entry an {@link GenericEntry} object containing all the properties 
   *        of a Gmail filter.
   * @return an entry with the result of the operation.
   * @throws IOException if an error occurs while communicating with the GData
   *         service.
   * @throws MalformedURLException if the batch feed URL cannot be constructed.
   * @throws ServiceException if the insert request failed due to system error.
   */  
  public GenericEntry insert(String domain, GenericEntry entry)
      throws IOException, MalformedURLException, ServiceException {
    URL singleUrl = new URL(HTTPS_PROTOCOL + "://" + APPS_APIS_DOMAIN
        + URL_PREFIX + "/" + domain + URL_SUFFIX);
    
    return insert(singleUrl, entry);
  }
  
  /**
   * Inserts one or more Gmail filter entries in a single batch operation.  Using
   * {@code batch} instead of repeated calls to {@code #insert} is helpful in
   * reducing HTTP overhead. 
   * 
   * @param domain the domain into which filters are being created.
   * @param feed a feed containing one or more {@link GenericEntry} objects
   *             containing all the properties of Gmail filters,
   *             each of which has been tagged with
   *             {@link BatchUtils#setBatchId(com.google.gdata.data.BaseEntry,
   *             String)}.  The batch operation type of each entry must be
   *             {@link BatchOperationType#INSERT}; however, there should be no
   *             need to call {@link BatchUtils#setBatchOperationType(
   *             com.google.gdata.data.BaseEntry, BatchOperationType)} on each
   *             entry, as this operation is already the default.
   * @return a feed with the result of each operation in a separate
   *         {@link GenericEntry} object.
   * @throws IOException if an error occurs while communicating with the GData
   *                     service.
   * @throws MalformedURLException if the batch feed URL cannot be constructed.
   * @throws ServiceException if the insert request failed due to system error.
   * @throws BatchInterruptedException if an irrecoverable error was detected
   *                                   by the server while parsing the request,
   *                                   like invalid XML data. Some operations
   *                                   might have succeeded when this exception
   *                                   is thrown. Check {@link
   *                                   BatchInterruptedException#getFeed()}.
   */ 
  public GenericFeed batch(String domain, GenericFeed feed)
      throws BatchInterruptedException, IOException, MalformedURLException, 
      ServiceException {
    
    URL batchUrl = new URL(HTTPS_PROTOCOL + "://" + APPS_APIS_DOMAIN
        + URL_PREFIX + "/" + domain + BATCH_URL_SUFFIX);
    
    return batch(batchUrl, feed);
  }
}

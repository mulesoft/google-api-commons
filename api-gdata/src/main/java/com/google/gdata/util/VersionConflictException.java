/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.util;

import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.IEntry;

import java.io.IOException;
import java.net.HttpURLConnection;


/**
 * The VersionConflictException should be thrown by a service provider
 * when an attempt is made to modify an entry based on a stale version ID.
 *
 * 
 */
public class VersionConflictException extends ServiceException {

  public VersionConflictException() {
    super("Version conflict");
    this.currentEntry = null;
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_CONFLICT);
  }

  public VersionConflictException(IEntry currentEntry) {
    super("Version conflict");
    this.currentEntry = currentEntry;
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_CONFLICT);
  }

  public VersionConflictException(IEntry currentEntry, Throwable cause) {
    super("Version conflict", cause);
    this.currentEntry = currentEntry;
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_CONFLICT);
  }

  public VersionConflictException(HttpURLConnection httpConn)
      throws IOException {
    super(httpConn);
  }

  public VersionConflictException(ErrorDomain.ErrorCode errorCode) {
    super(errorCode);
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_CONFLICT);
  }

  public VersionConflictException(ErrorDomain.ErrorCode errorCode,
      Throwable cause) {
    super(errorCode, cause);
    setHttpErrorCodeOverride(HttpURLConnection.HTTP_CONFLICT);
  }


  /**
   * If this exception is thrown from an update operation and the entry exists,
   * but has a new version ID, this field represents the current state of the
   * entry.
   */
  private IEntry currentEntry;
  public IEntry getCurrentEntry() { return currentEntry; }
  public void setCurrentEntry(IEntry entry) { currentEntry = entry; }


  /**
   * Generates XML.
   *
   * @param   extProfile
   *            Extension profile.
   *
   * @param   xw
   *            Output writer.
   *
   * @throws  IOException
   */
  public void generate(ExtensionProfile extProfile,
                       XmlWriter xw) throws IOException {
    GenerateUtil.generateAtom(xw, currentEntry, extProfile);
  }
}

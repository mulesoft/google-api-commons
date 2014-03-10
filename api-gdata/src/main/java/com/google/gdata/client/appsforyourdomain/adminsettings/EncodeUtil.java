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

import com.google.gdata.util.common.util.Base64;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utility class with helper methods
 * 
 * 
 * 
 */
public class EncodeUtil {

  /**
   * Private constructor to prevent instantiation.
   */
  private EncodeUtil() {
  }

  /**
   * Base64 encodes the given file from path.
   * 
   * @param filePath location of the file to be encoded.
   * @return string base64 encoded contents of the file
   */
  public static String encodeBinaryFile(String filePath) throws IOException {
    InputStream stream = null;
    String base64encodedValue = null;
    try {
      stream = new FileInputStream(filePath);
      byte[] bytes = new byte[stream.available()];
      stream.read(bytes);
      base64encodedValue = Base64.encode(bytes);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      stream.close();
    }
    return base64encodedValue;
  }
}


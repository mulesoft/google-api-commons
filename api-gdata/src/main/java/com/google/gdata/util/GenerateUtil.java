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
import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.IEntry;
import com.google.gdata.data.IFeed;

import java.io.IOException;

/**
 * Helper class with static generate methods to generate atom for old or new
 * data model as appropriate.
 * 
 * 
 */
public class GenerateUtil {

  /**
   * Generates the atom output for an entry using the given xml writer and
   * extension profile.
   */
  public static void generateAtom(XmlWriter writer,
      IEntry entry, ExtensionProfile extProfile) throws IOException {
    if (entry instanceof BaseEntry) {
      ((BaseEntry<?>) entry).generateAtom(writer, extProfile);
    } else {
    }
  }
  
  /**
   * Generates the atom output for a feed using the given xml writer and
   * extension profile.
   */
  public static void generateAtom(XmlWriter writer,
      IFeed feed, ExtensionProfile extProfile) throws IOException {
    if (feed instanceof BaseFeed) {
      ((BaseFeed<?, ?>) feed).generateAtom(writer, extProfile);
    } else {
    }
  }
}

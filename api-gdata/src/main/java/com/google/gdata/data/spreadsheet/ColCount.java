/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.spreadsheet;

import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;

import org.xml.sax.Attributes;

import java.io.IOException;


/**
 * GData schema extension describing a spreadsheet's column count.
 *
 * 
 */
public class ColCount implements Extension {

  /** The name of the XML tag. */
  public static final String TAG_NAME = "colCount";
  
  /** The count. */
  private int count = -1;
  
  /**
   * Initializes to blank for XML parsing.
   */
  public ColCount() {
  }
  
  /**
   * Initializes to a particular count.
   */
  public ColCount(int count) {
    this.count = count;
  }
  
  /**
   * Gets the total count.
   */
  public int getCount() {
    return count;
  }
  
  /**
   * Returns the suggested extension description.
   */
  public static ExtensionDescription getDefaultDescription() {
    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(ColCount.class);
    desc.setNamespace(Namespaces.gSpreadNs);
    desc.setLocalName(TAG_NAME);
    return desc;
  }
  
  /**
   * Writes this cell as XML, omitting any unspecified fields.
   */
  public void generate(XmlWriter w, ExtensionProfile extProfile)
      throws IOException {
    w.simpleElement(Namespaces.gSpreadNs, TAG_NAME, null,
        String.valueOf(count));
  }
  
  /**
   * Yields an XML handler for parsing a Cell element.
   */
  public XmlParser.ElementHandler getHandler(ExtensionProfile extProfile,
                                             String namespace,
                                             String localName,
                                             Attributes attrs)
      throws ParseException, IOException {
    return new XmlParser.ElementHandler() {
      public void processEndElement() throws ParseException {
        if (value != null) {
          try {
            count = Integer.parseInt(value);
          } catch (NumberFormatException nfe) {
            // count remains negative
          }
        }
        if (count <= 0) {
          throw new ParseException("The count must be specified.");
        }
      }
    };
  }
}

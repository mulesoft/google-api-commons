/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.batch;

import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.XmlParser;

import org.xml.sax.Attributes;

import java.io.IOException;

/**
 * Entry extension for {@code <batch:id>} tags.
 *
 * 
 */
public class BatchId implements Extension {

  private String id;

  /** Creates a BatchId object. */
  public BatchId(String id) {
    this.id = id;
  }
  
  /** Creates a BatchId object without ID. */
  public BatchId() {
  }
  
  /** Gets the id. */
  public String getId() {
    return id;
  }

  /** Sets the id. */
  public void setId(String id) {
    this.id = id;
  }

  /** Returns the suggested extension description. */
  public static ExtensionDescription getDefaultDescription() {
    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(BatchId.class);
    desc.setNamespace(Namespaces.batchNs);
    desc.setLocalName("id");
    desc.setRepeatable(false);
    return desc;
  }

  /**
   * Convenience method for getting a batchId from 
   * an entry if it's there.
   * 
   * @param entry
   * @return the id or null if it's not defined
   */
  public static String getIdFrom(BaseEntry<?> entry) {
    BatchId tag = entry.getExtension(BatchId.class);
    return tag == null ? null : tag.getId();
  }
  
  public void generate(XmlWriter w, ExtensionProfile extProfile)
      throws IOException {
    w.simpleElement(Namespaces.batchNs, "id", null, id);
  }

  public XmlParser.ElementHandler getHandler(ExtensionProfile extProfile,
                                             String namespace, String localName,
                                             Attributes attrs) {
    return new XmlParser.ElementHandler() {
      
      @Override
      public void processEndElement() {
        id = value;
      }
    };
  }
}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.wireformats.output;

import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.IAtom;
import com.google.gdata.data.IEntry;
import com.google.gdata.data.IFeed;
import com.google.gdata.util.Namespaces;
import com.google.gdata.wireformats.AltFormat;

import java.io.IOException;

/**
 * The AtomGenerator class is a concrete implementation of the OutputGenerator
 * interface that generates GData feeds and entries using the Atom XML Syntax.
 *
 * 
 */
public class AtomGenerator extends XmlGenerator<IAtom> {
 
  public AltFormat getAltFormat() {
    return AltFormat.ATOM;
  }

  public Class<IAtom> getSourceType() {
    return IAtom.class;
  }

  @Override
  public void generateXml(XmlWriter xw, OutputProperties outProps, IAtom source)
      throws IOException {

    xw.setDefaultNamespace(Namespaces.atomNs);
    ExtensionProfile extProfile = outProps.getExtensionProfile();
    if (source instanceof IFeed) {
      IFeed feed = (IFeed) source;
      if (feed instanceof BaseFeed) {
        ((BaseFeed<?, ?>) feed).generateAtom(xw, extProfile);
      } else {
        throw new IllegalArgumentException("Feed was not an instance of data.BaseFeed");
      }
    } else if (source instanceof IEntry) {
      IEntry entry = (IEntry) source;
      if (entry instanceof BaseEntry) {
        ((BaseEntry<?>) entry).generateAtom(xw, extProfile);
      } else {
        throw new IllegalArgumentException("Entry was not an instance of data.BaseEntry");
      }
    } else if (source != null) {
      // This case is to handle case that may return Atom content but might
      // also return no data (like DELETE)
      throw new IllegalStateException("Unexpected source type: " + source.getClass());
    }
  }
}

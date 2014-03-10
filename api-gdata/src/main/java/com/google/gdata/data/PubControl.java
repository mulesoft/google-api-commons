/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data;

import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;

import org.xml.sax.Attributes;

import java.io.IOException;

/**
 * Publication control tag app:control, which usually contains app:draft.
 *
 * The main reason for having this as a separate object is mostly so
 * that it can be used as an extension point. The draft flag is usually set
 * using {@link BaseEntry#setDraft(Boolean)}, which will create a PubControl
 * object when necessary.
 *
 * 
 */
public class PubControl extends ExtensionPoint {

  private Boolean draft;
  private XmlNamespace atomPubNs = Namespaces.getAtomPubNs();


  /** Creates an empty app:control tag. */
  public PubControl() {

  }

  /**
   * Checks the value of the app:draft tag.
   *
   * @return true if the entry is a draft (false by default as per the atom
   *   publishing protoc spec)
   */
  public boolean isDraft() {
    return draft != null && draft.booleanValue();
  }

  /**
   * Sets the value of the app:draft tag.
   * @param draft sets the draft status, null to unset
   */
  public void setDraft(Boolean draft) {
    this.draft = draft;
  }

  /** Generates the atom representation for this tag. */
  public void generateAtom(XmlWriter w, ExtensionProfile extProfile)
      throws IOException {
    w.startElement(Namespaces.getAtomPubNs(), "control", null, null);
    if (isDraft()) {
      w.simpleElement(Namespaces.getAtomPubNs(), "draft", null, "yes");
    }
    generateExtensions(w, extProfile);
    w.endElement();
  }

  /** {@code <app:control>} parser. */
  public class AtomHandler extends ExtensionHandler {

    public AtomHandler(ExtensionProfile profile) {
      super(profile, PubControl.class);
    }

    @Override
    public XmlParser.ElementHandler getChildHandler(String namespace,
        String localName, Attributes attrs)
        throws ParseException, IOException {
      if (namespace.equals(atomPubNs.getUri())) {
        if (localName.equals("draft")) {
          return new DraftHandler();
        }
      } else {
        return super.getChildHandler(namespace, localName, attrs);
      }
      return null;
    }
  }

  /** {@code <app:draft>} parser. */
  private class DraftHandler extends XmlParser.ElementHandler {
    @Override
    public void processEndElement() throws ParseException {
      if (draft != null) {
        throw new ParseException(
            CoreErrorDomain.ERR.duplicateDraft);
      }
      if (value.equals("yes")) {
        draft = true;
      } else if (value.equals("no")) {
        draft = false;
      } else {
        throw new ParseException(
            CoreErrorDomain.ERR.invalidDraft);
      }
    }
  }
}

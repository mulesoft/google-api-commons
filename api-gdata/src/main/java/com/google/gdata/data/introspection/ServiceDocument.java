/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.introspection;

import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.ExtensionVisitor;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;

import org.xml.sax.Attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * The ServiceDocument class defines the basic Java object model
 * representation and XML parsing/generation support for an
 * Atom Publishing Protocol introspection document
 *
 * 
 */
public class ServiceDocument extends ExtensionPoint
    implements IServiceDocument {

  // Locally cache the version-appropriate AtomPub namespace information.
  private XmlNamespace atomPubNs = Namespaces.getAtomPubNs();

  /** The list of workspaces associated with the service */
  List<Workspace> workspaces = new ArrayList<Workspace>();
  public List<Workspace> getWorkspaces() { return workspaces; }
  public void addWorkspace(Workspace workspace) {
    workspaces.add(workspace);
  }

  public Workspace addWorkspace(String title) {
    Workspace workspace = new Workspace(new PlainTextConstruct(title));
    workspaces.add(workspace);
    return workspace;
  }
  
  @Override
  protected void visitChildren(ExtensionVisitor ev)
      throws ExtensionVisitor.StoppedException {
    
    // Add nested workspaces to the visitor pattern
    for (Workspace workspace : workspaces) {
      this.visitChild(ev, workspace);
    }
    super.visitChildren(ev);
  } 

  /**
   * Generates XML.
   *
   * @param   w
   *            output writer
   *
   * @throws  IOException
   */
  @Override
  public void generate(XmlWriter w, ExtensionProfile extProfile) 
      throws IOException {

    w.startElement(atomPubNs, "service", null, null);

    w.startRepeatingElement();
    for (Workspace workspace : workspaces) {
      workspace.generate(w, extProfile);
    }
    w.endRepeatingElement();

    generateExtensions(w, extProfile);

    w.endElement(atomPubNs, "service");
  }


  /**
   * Parses XML from a Reader.
   *
   * @param   extProfile
   *            extension profile
   *
   * @param   reader
   *            XML reader
   *
   * @throws   IOException
   *
   * @throws   ParseException
   */
  public void parse(ExtensionProfile extProfile, Reader reader)
      throws IOException, ParseException {

    new XmlParser().parse(reader, new Handler(extProfile),
                          atomPubNs.getUri(), "service");
  }


  /**
   * Parses XML from an InputStream.
   *
   * @param   extProfile
   *            extension profile
   *
   * @param   inputStream
   *            XML input stream
   *
   * @throws   IOException
   *
   * @throws   ParseException
   */
  public void parse(ExtensionProfile extProfile, InputStream inputStream)
      throws IOException, ParseException {

    new XmlParser().parse(inputStream, new Handler(extProfile),
                          atomPubNs.getUri(), "service");
  }

  @Override
  public XmlParser.ElementHandler getHandler(ExtensionProfile p,
      String namespace, String localName, Attributes attrs) {
    return new Handler(p);
  }

  /**
   * XmlParser ElementHandler for {@code app:service}
   */
  public class Handler extends ExtensionPoint.ExtensionHandler {

    public Handler(ExtensionProfile extProfile) {
      super(extProfile, ServiceDocument.class);
    }

    @Override
    public XmlParser.ElementHandler getChildHandler(String namespace,
                                                    String localName,
                                                    Attributes attrs)
        throws ParseException, IOException {

      if (namespace.equals(atomPubNs.getUri())) {

        if (localName.equals("workspace")) {

          Workspace workspace = new Workspace();
          workspaces.add(workspace);
          return workspace.new Handler(extProfile, attrs);
        }
      } 
      return super.getChildHandler(namespace, localName, attrs);
    }
  }

  public void processEndElement() throws ParseException {
    if (workspaces.size() == 0) {
      throw new ParseException(
          CoreErrorDomain.ERR.workspaceRequired);
    }
  }
}

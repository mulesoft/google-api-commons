/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model.atompub;

import com.google.gdata.data.introspection.IServiceDocument;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.atom.TextContent;
import com.google.gdata.util.Namespaces;

import java.util.List;

/**
 * Container for service information.
 *
 * 
 */
public class ServiceDocument extends Element implements IServiceDocument {

  /**
   * The key for this element.
   */
  public static final ElementKey<Void,
      ServiceDocument> KEY = ElementKey.of(new
      QName(Namespaces.atomPubStandardNs, "service"), Void.class,
      ServiceDocument.class);

  /**
   * Registers the metadata for this element.
   */
  public static void registerMetadata(MetadataRegistry registry) {
    if (registry.isRegistered(KEY)) {
      return;
    }

    // The builder for this element
    ElementCreator builder = registry.build(KEY);

    // Local properties
    builder.addElement(Workspace.KEY).setCardinality(
        ElementMetadata.Cardinality.MULTIPLE).setRequired(true);
  }

  /**
   * Constructs an instance using the default key.
   */
  public ServiceDocument() {
    super(KEY);
  }

  /**
   * Subclass constructor, allows subclasses to supply their own element key.
   */
  protected ServiceDocument(ElementKey<?, ? extends ServiceDocument> key) {
    super(key);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link Element} instance. Will use the given {@link ElementKey} as the key
   * for the element. This constructor is used when adapting from one element
   * key to another. You cannot call this constructor directly, instead use
   * {@link Element#createElement(ElementKey, Element)}.
   *
   * @param key The key to use for this element.
   * @param source source element
   */
  protected ServiceDocument(ElementKey<?, ? extends ServiceDocument> key,
      Element source) {
    super(key, source);
  }

   @Override
   public ServiceDocument lock() {
     return (ServiceDocument) super.lock();
   }

  /**
   * Returns the workspaces.
   *
   * @return workspaces
   */
  public List<Workspace> getWorkspaces() {
    return super.getElements(Workspace.KEY);
  }

  /**
   * Adds a new workspace.
   *
   * @param workspace workspace
   */
  public ServiceDocument addWorkspace(Workspace workspace) {
    super.addElement(workspace);
    return this;
  }

  /**
   * Removes an existing workspace.
   *
   * @param workspace workspace
   * @return true if the workspace was removed
   */
  public boolean removeWorkspace(Workspace workspace) {
    return super.removeElement(workspace);
  }

  /**
   * Removes all existing workspace instances.
   */
  public void clearWorkspaces() {
    super.removeElement(Workspace.KEY);
  }

  /**
   * Returns whether it has the workspaces.
   *
   * @return whether it has the workspaces
   */
  public boolean hasWorkspaces() {
    return super.hasElement(Workspace.KEY);
  }



  public Workspace addWorkspace(String title) {
    Workspace workspace = new Workspace(TextContent.plainText(title));
    addWorkspace(workspace);
    return workspace;
  }
}

/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model.transforms.atompub;

import com.google.gdata.client.Service;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataContext;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.atom.Source;
import com.google.gdata.model.atompub.Accept;
import com.google.gdata.model.atompub.Categories;
import com.google.gdata.model.atompub.Collection;
import com.google.gdata.model.atompub.Draft;
import com.google.gdata.model.atompub.Edited;
import com.google.gdata.model.atompub.Control;
import com.google.gdata.model.atompub.ServiceDocument;
import com.google.gdata.model.atompub.Workspace;
import com.google.gdata.util.Namespaces;

/**
 * Transforms for atompub elements based on version information.
 * 
 * 
 */
public class AtompubVersionTransforms {

  private static final MetadataContext V1_CONTEXT =
      MetadataContext.forVersion(Service.Versions.V1);
  
  public static void addTransforms(MetadataRegistry registry) {
    addAtompubTransforms(registry,
        Accept.KEY,
        Categories.KEY,
        Collection.KEY,
        Draft.KEY,
        Edited.KEY,
        Control.KEY,
        ServiceDocument.KEY,
        Workspace.KEY);

    // Switch visibility of title attribute and element in V1.
    registry.build(Workspace.KEY, Workspace.TITLE, V1_CONTEXT)
        .setVisible(true);
    registry.build(Workspace.KEY, Source.TITLE, V1_CONTEXT)
        .setVisible(false);
    
    registry.build(Collection.KEY, Collection.TITLE, V1_CONTEXT)
        .setVisible(true);
    registry.build(Collection.KEY, Source.TITLE, V1_CONTEXT)
        .setVisible(false);
  }

  private static void addAtompubTransforms(MetadataRegistry registry,
      ElementKey<?, ?>... keys) {
    for (ElementKey<?, ?> key : keys) {
      addAtompubTransform(registry, key);
    }
  }
  
  private static void addAtompubTransform(MetadataRegistry registry,
      ElementKey<?, ?> key) {
    registry.build(key, V1_CONTEXT).setName(
        new QName(Namespaces.atomPubDraftNs, key.getId().getLocalName()));
  }
}

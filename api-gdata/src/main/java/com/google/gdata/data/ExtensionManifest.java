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

import com.google.gdata.util.common.base.Pair;
import com.google.gdata.util.common.xml.XmlNamespace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.List;

/**
 * The ExtensionManifest class is a helper class used to maintain a
 * relationship between an {@link ExtensionPoint} type set of expected
 * extensions with it, as described by a map of namespace URI/local name
 * pairs to {@link ExtensionDescription} instances.  ExtensionManifest
 * instances are created by the {@link ExtensionProfile} declaration
 * APIs and used during parsing by {@link ExtensionPoint} instances to
 * to find the description of extension elements found in the parse stream.
 *
 * 
 */
public class ExtensionManifest {

  /**
   * The ExtensionPoint type associated with this manifest.
   */
  final Class<? extends ExtensionPoint> extendedType;


  /** Maps (Namespace URI, local name) to corresponding extension data. */
  final Map<Pair<String, String>, ExtensionDescription> supportedExtensions =
    new HashMap<Pair<String, String>, ExtensionDescription>();

  /**
   * Specifies whether the extension point supports arbitrary XML
   * ({code xs:any}). If it does, it is available through
   * {@link ExtensionPoint#xmlBlob}.
   */
  boolean arbitraryXml = false;

  /**
   * Specifies whether the extension point supports mixed content.  Has no
   * effect if arbitraryXml is false. If it does, it is available through
   * {@link ExtensionPoint#xmlBlob}.
   */
  boolean mixedContent = false;

  /**
   * The list of manifests for subtypes of extendedType.  This is used
   * to propagate declarations down to subtypes.
   */
  final List<ExtensionManifest> subclassManifests =
      new ArrayList<ExtensionManifest>();

  /**
   * Constructs a new Manifest instance to manage the extension mappings
   * for a particular ExtensionPoint type.
   */
  ExtensionManifest(Class<? extends ExtensionPoint> extendedType) {
    this.extendedType = extendedType;
  }

  /**
   * Returns the Map from namespace/localname String pairs to supporting
   * Extension class and manifest information.
   */
  public Map<Pair<String, String>, ExtensionDescription>
      getSupportedExtensions() {

    return Collections.unmodifiableMap(supportedExtensions);
  }

  /**
   * Retrieves a collection of namespace declarations for all possible
   * extensions based on this manifest.
   */
  Collection<XmlNamespace> getNamespaceDecls() {

    Collection<XmlNamespace> nsDecls = new HashSet<XmlNamespace>();

    for (ExtensionDescription extDescription: supportedExtensions.values()) {
      nsDecls.add(extDescription.getNamespace());
    }

    return nsDecls;
  }
}

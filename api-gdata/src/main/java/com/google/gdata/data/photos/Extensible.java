/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.photos;

import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;

/**
 * Basic interface for all extendable objects.  This is just an interface for
 * a subset of the methods on ExtensionPoint.  Any class implementing this
 * interface will forward these methods on to the {@link ExtensionPoint} it is
 * using for storing the actual extension information.
 *
 * 
 */
public interface Extensible {

  /**
   * Declares the set of expected Extension types for an Extensible
   * within the target extension profile. Forwards to
   * {@link ExtensionPoint#declareExtensions(ExtensionProfile)}.
   *
   * @param extProfile
   *          the ExtensionProfile to initialize.
   */
  public void declareExtensions(ExtensionProfile extProfile);

  /**
   * Sets an extension object. If one exists of this type, it's replaced.
   * Forwards to {@link ExtensionPoint#setExtension(Extension)}.
   */
  public void setExtension(Extension extension);

  /**
   * Adds an extension object.  Forwards to
   * {@link ExtensionPoint#addExtension(Extension)}.
   */
  public void addExtension(Extension extension);

  /**
   * Adds a repeating extension object.  Forwards to
   * {@link ExtensionPoint#addRepeatingExtension(Extension)}.
   */
  public void addRepeatingExtension(Extension extension);
  
  /**
   * Removes an extension object. Forwards to
   * {@link ExtensionPoint#removeExtension(Extension)}.
   */
  public void removeExtension(Extension extension);

  /**
   * Removes an extension object based on its class. Forwards to
   * {@link ExtensionPoint#removeExtension(Class)}.
   */
  public void removeExtension(Class<? extends Extension> extensionClass);
  
  /**
   * Removes a repeating extension object.  Forwards to
   * {@link ExtensionPoint#removeRepeatingExtension(Extension)}.
   */
  public void removeRepeatingExtension(Extension ext);
}

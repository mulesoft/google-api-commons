/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model;

import com.google.gdata.model.Metadata.VirtualValue;

/**
 * Implementation of {@link AttributeCreator}.  See the superclass for the
 * implementation details, this class just delegates to the superclass and
 * changes the response types.
 *
 * 
 */
final class AttributeCreatorImpl extends MetadataCreatorImpl
    implements AttributeCreator {

  /**
   * Construct a new empty attribute metadata creator.
   */
  AttributeCreatorImpl(MetadataRegistry root, TransformKey transformKey) {
    super(root, transformKey);
  }

  /**
   * Convert the attribute creator into a transform.
   */
  AttributeTransform toTransform() {
    return AttributeTransform.create(this);
  }

  @Override
  public AttributeCreatorImpl setName(QName name) {
    return (AttributeCreatorImpl) super.setName(name);
  }

  @Override
  public AttributeCreatorImpl setRequired(boolean required) {
    return (AttributeCreatorImpl) super.setRequired(required);
  }

  @Override
  public AttributeCreatorImpl setVisible(boolean visible) {
    return (AttributeCreatorImpl) super.setVisible(visible);
  }

  @Override
  public AttributeCreatorImpl setVirtualValue(VirtualValue virtualValue) {
    return (AttributeCreatorImpl) super.setVirtualValue(virtualValue);
  }

  /**
   * When setting the source of an attribute, the virtual value of the attribute
   * is based on the path.
   */
  @Override
  void setSource(Path path, TransformKey key) {
    super.setSource(path, key);
    setVirtualValue(PathAdapter.valueAdapter(path));
  }
}

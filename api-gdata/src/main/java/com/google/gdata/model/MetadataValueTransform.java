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

import com.google.common.collect.Lists;
import com.google.gdata.model.Metadata.VirtualValue;
import com.google.gdata.util.ParseException;
import com.google.gdata.wireformats.ContentCreationException;

import java.util.List;

/**
 * This class represents a transformation of a value based on a list of keys
 * to use as the value for the element.  During generation this will check each
 * of the source keys for a value, using the first value found.  During parsing
 * it will place the incoming value into the first key in the list.
 *
 * 
 */
public class MetadataValueTransform implements VirtualValue {

  // A list of metadata sources for the value.
  private final List<MetadataKey<?>> sources;

  /**
   * Constructs a simple value transform using the given sources.
   *
   * @param inputSources the source keys to pull the values from.
   */
  public MetadataValueTransform(MetadataKey<?>... inputSources) {
    this.sources = Lists.newArrayList(inputSources);
  }

  /**
   * Runs this transformation on the given element.
   *
   * @param element the element to transform.
   * @param metadata the metadata of the element being transformed.
   * @return the String representation of the property value.
   */
  public Object generate(Element element, ElementMetadata<?, ?> metadata) {
    for (MetadataKey<?> source : sources) {
      if (source instanceof ElementKey<?, ?>) {
        ElementKey<?, ?> childKey = (ElementKey<?, ?>) source;
        Element child = element.getElement(childKey);
        if (child != null) {
        ElementMetadata<?, ?> childMeta = (metadata == null) ? null
            : metadata.bindElement(childKey);
          Object value = (childMeta == null) ? child.getTextValue()
              : childMeta.generateValue(child, childMeta);
          if (value != null) {
            return value;
          }
        }
      } else {
        AttributeKey<?> attKey = (AttributeKey<?>) source;
        AttributeMetadata<?> attMeta = (metadata == null) ? null
            : metadata.bindAttribute(attKey);
        Object value = (attMeta == null) ? element.getAttributeValue(attKey)
            : attMeta.generateValue(element, metadata);
        if (value != null) {
          return value;
        }
      }
    }
    return null;
  }

  /**
   * For parsing, we always parse directly into the first source.
   */
  public void parse(Element element, ElementMetadata<?, ?> metadata,
      Object value) throws ParseException {
    if (sources.isEmpty()) {
      return;
    }
    MetadataKey<?> source = sources.get(0);
    if (source instanceof ElementKey<?, ?>) {
      ElementKey<?, ?> childKey = (ElementKey<?, ?>) source;
      ElementMetadata<?, ?> childMeta = metadata.bindElement(childKey);
      Element child = element.getElement(childKey);
      if (child == null) {
        try {
          child = childMeta.createElement();
        } catch (ContentCreationException e) {
          throw new ParseException(e);
        }
        element.addElement(childKey, child);
      }
      childMeta.parseValue(child, childMeta, value);
    } else {
      AttributeKey<?> attKey = (AttributeKey<?>) source;
      AttributeMetadata<?> attMeta = metadata.bindAttribute(attKey);
      attMeta.parseValue(element, metadata, value);
    }
  }
}

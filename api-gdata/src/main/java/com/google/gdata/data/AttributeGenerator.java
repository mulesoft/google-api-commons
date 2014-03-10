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

import java.util.LinkedHashMap;

/**
 * Helps generate tag attributes, preserving the order of the attributes.
 * Attributes whose the value is {@code null} are ignored when generating XML.
 *
 * 
 */
public class AttributeGenerator extends LinkedHashMap<String, String> {

  /** element's text content or {@code null} for no text content */
  private String content = null;
  public String getContent() { return content; }
  public void setContent(String content) { this.content = content; }

  /**
   * Associates the specified long value with the specified key in this map. If
   * the map previously contained a mapping for this key, the old value is
   * replaced.
   *
   * @param key   key with which the specified value is to be associated
   * @param value long value to be associated with the specified key
   */
  public void put(String key, long value) {
    put(key, Long.toString(value));
  }

  /**
   * Associates the specified boolean value with the specified key in this map.
   * If the map previously contained a mapping for this key, the old value is
   * replaced.
   *
   * @param key   key with which the specified value is to be associated
   * @param value boolean value to be associated with the specified key
   */
  public void put(String key, boolean value) {
    put(key, Boolean.toString(value));
  }

  /**
   * Associates the specified float value with the specified key in this map. If
   * the map previously contained a mapping for this key, the old value is
   * replaced.
   *
   * @param key   key with which the specified value is to be associated
   * @param value float value to be associated with the specified key
   */
  public void put(String key, float value) {
    if (value == Float.POSITIVE_INFINITY) {
      put(key, "INF");
    } else if (value == Float.NEGATIVE_INFINITY) {
      put(key, "-INF");
    } else {
      put(key, Float.toString(value));
    }
  }

  /**
   * Associates the specified double value with the specified key in this map.
   * If the map previously contained a mapping for this key, the old value is
   * replaced.
   *
   * @param key   key with which the specified value is to be associated
   * @param value double value to be associated with the specified key
   */
  public void put(String key, double value) {
    if (value == Double.POSITIVE_INFINITY) {
      put(key, "INF");
    } else if (value == Double.NEGATIVE_INFINITY) {
      put(key, "-INF");
    } else {
      put(key, Double.toString(value));
    }
  }

  /**
   * Associates the specified Object's {@link #toString()} value with the
   * specified key in this map. If the map previously contained a mapping for
   * this key, the old value is replaced.
   *
   * @param key   key with which the specified value is to be associated
   * @param value Object whose {@link #toString()} value is to be associated
   *              with the specified key or <code>null</code>
   */
  public void put(String key, Object value) {    
    if (value == null) {
      super.put(key, null);
    } else if (value instanceof Float) {
      Float boxedFloat = (Float) value;
      put(key, boxedFloat.floatValue());
    } else if (value instanceof Double) {
      Double boxedDouble = (Double) value;
      put(key, boxedDouble.doubleValue());
    } else {
      put(key, value.toString());
    }
  }

  /**
   * Associates the specified enum value with the specified key in this map. If
   * the map previously contained a mapping for this key, the old value is
   * replaced.
   *
   * @param key                  key with which the specified value is to be
   *                             associated
   * @param value                enum value to be associated with the specified
   *                             key or <code>null</code>
   * @param enumToAttributeValue custom mapping of enum to attribute value
   */
  public <T extends Enum<T>> void put(String key, T value,
      AttributeHelper.EnumToAttributeValue<T> enumToAttributeValue) {
    put(key, value == null
        ? null : enumToAttributeValue.getAttributeValue(value));
  }
}

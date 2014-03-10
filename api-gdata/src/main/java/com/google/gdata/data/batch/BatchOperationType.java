/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.batch;

import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.Namespaces;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Defines a batch operation (query, update, insert, delete).
 *
 * This enum is the java equivalent of &lt;batch: operation type="..."/&gt.
 * 
 * 
 */
public enum BatchOperationType {

  /** Query for the entry by id. */
  QUERY("query", "GET"),
  
  /** Insert the current entry. */
  INSERT("insert", "POST"),

  /** Update the current entry identified by its id. */
  UPDATE("update", "PUT"),

  /** Delete the current entry identified by its id. */
  DELETE("delete", "DELETE");

  private static final Map<String, BatchOperationType> BY_NAME =
      new HashMap<String, BatchOperationType>();
  static {
    for (BatchOperationType op : BatchOperationType.values()) {
      BY_NAME.put(op.getName(), op);
    }
  }

  private final String name;
  private final String method;
  private BatchOperationType(String name, String method) {
    this.name = name;
    this.method = method;
  }

  /**
   * Gets the operation name as it appears in XML.
   * 
   * @return operation name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the operation name as an HTTP method name.
   * 
   * @return HTTP method name
   */
  public String getMethod() {
    return method;
  }

  @Override
  public String toString() {
    return name;
  }

  /**
   * Gets a BatchOperation by name (lowercase), as it appears in XML.
   * 
   * @param name
   * @return a BatchOperation or null
   */
  public static BatchOperationType forName(String name) {
    return BY_NAME.get(name);
  }

  /**
   * Generates a batch:operation element. 
   * 
   * @param w
   * @throws IOException
   */
  public void generateAtom(XmlWriter w) throws IOException {
    List<XmlWriter.Attribute> attrs = Collections
        .singletonList(new XmlWriter.Attribute("type", getName()));
    w.simpleElement(Namespaces.batchNs, "operation", attrs, null);
  }
}

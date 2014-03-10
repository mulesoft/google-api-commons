/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.extensions;

import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;

import org.xml.sax.Attributes;

import java.io.IOException;
import java.util.ArrayList;

/**
 * GData schema extension describing a geographic location.
 *
 * 
 * @deprecated Use {@link com.google.gdata.data.geo.impl} package.
 */
@Deprecated
public class GeoPt extends ExtensionPoint implements Extension {

  /** Label. */
  protected String label;
  public String getLabel() { return label; }
  public void setLabel(String v) { label = v; }

  /** Latitude. */
  protected Float lat;
  public Float getLat() { return lat; }
  public void setLat(Float v) { lat = v; }

  /** Longitude. */
  protected Float lon;
  public Float getLon() { return lon; }
  public void setLon(Float v) { lon = v; }

  /** Elevation. */
  protected Float elev;
  public Float getElev() { return elev; }
  public void setElev(Float v) { elev = v; }

  /** Time. */
  protected DateTime time;
  public DateTime getTime() { return time; }
  public void setTime(DateTime v) { time = v; }

  /**
   * Returns the suggested extension description with configurable
   * repeatability.
   */
  public static ExtensionDescription getDefaultDescription(boolean repeatable) {
    ExtensionDescription desc = new ExtensionDescription();
    desc.setExtensionClass(GeoPt.class);
    desc.setNamespace(Namespaces.gNs);
    desc.setLocalName("geoPt");
    desc.setRepeatable(repeatable);
    return desc;
  }

  /** Returns the suggested extension description and is repeatable. */
  public static ExtensionDescription getDefaultDescription() {
    return getDefaultDescription(true);
  }

  @Override
  public void generate(XmlWriter w, ExtensionProfile extProfile)
      throws IOException {

    ArrayList<XmlWriter.Attribute> attrs = new ArrayList<XmlWriter.Attribute>();

    if (label != null) {
      attrs.add(new XmlWriter.Attribute("label", label));
    }

    if (lat != null) {
      attrs.add(new XmlWriter.Attribute("lat", lat.toString()));
    }

    if (lon != null) {
      attrs.add(new XmlWriter.Attribute("lon", lon.toString()));
    }

    if (elev != null) {
      attrs.add(new XmlWriter.Attribute("elev", elev.toString()));
    }

    if (time != null) {
      attrs.add(new XmlWriter.Attribute("time", time.toString()));
    }

    generateStartElement(w, Namespaces.gNs, "geoPt", attrs, null);

    // Invoke ExtensionPoint.
    generateExtensions(w, extProfile);

    w.endElement(Namespaces.gNs, "geoPt");
  }


  @Override
  public XmlParser.ElementHandler getHandler(ExtensionProfile extProfile,
                                             String namespace,
                                             String localName,
                                             Attributes attrs) {
    return new Handler(extProfile);
  }

  /** <g:geoPt> parser. */
  private class Handler extends ExtensionPoint.ExtensionHandler {

    public Handler(ExtensionProfile extProfile) {
      super(extProfile, GeoPt.class);
    }

    @Override
    public void processAttribute(String namespace,
                                 String localName,
                                 String value)
        throws ParseException {

      if (namespace.equals("")) {

        if (localName.equals("label")) {

          label = value;

        } else if (localName.equals("lat")) {

          try {
            lat = Float.valueOf(value);
          } catch (NumberFormatException e) {
            throw new ParseException(
                CoreErrorDomain.ERR.invalidGeoPtLat, e);
          }

        } else if (localName.equals("lon")) {

          try {
            lon = Float.valueOf(value);
          } catch (NumberFormatException e) {
            throw new ParseException(
                CoreErrorDomain.ERR.invalidGeoPtLon, e);
          }

        } else if (localName.equals("elev")) {

          try {
            elev = Float.valueOf(value);
          } catch (NumberFormatException e) {
            throw new ParseException(
               CoreErrorDomain.ERR.invalidGeoPtElev, e);
          }

        } else if (localName.equals("time")) {

          try {
            time = DateTime.parseDateTime(value);
          } catch (NumberFormatException e) {
            throw new ParseException(
                CoreErrorDomain.ERR.invalidGeoPtTime);
          }
        }
      }
    }

    @Override
    public void processEndElement() throws ParseException {

      if (lat == null) {
        throw new ParseException(
            CoreErrorDomain.ERR.geoPtLatRequired);
      }

      if (lon == null) {
        throw new ParseException(
            CoreErrorDomain.ERR.geoPtLonRequired);
      }

      super.processEndElement();
    }
  }
}

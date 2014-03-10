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
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.ExtensionVisitor;
import com.google.gdata.data.Feed;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Link;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;

import org.xml.sax.Attributes;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The FeedLink class defines the object model for a link entity that refers to
 * a GData feed.   The feed content may be included inline via child elements of
 * the feed link or only included by reference.
 * 
 * @param <F>   Nested feed type.
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.gAlias,
    nsUri = Namespaces.g,
    localName = "feedLink")
public class FeedLink<F extends BaseFeed<?, ?>> extends Link {

  /**
   * Constructs a feed link that points to a {@link Feed}.
   */
  @SuppressWarnings("unchecked")
  public FeedLink() {
    this((Class<F>) Feed.class);
  }

  /**
   * Constructs a feed link that points to the given feed type.
   *
   * @param feedClass   Feed class.
   */
  public FeedLink(Class<F> feedClass) {
    this.feedClass = feedClass;
  }

  /** Read only flag. */
  protected boolean readOnly = false;
  public boolean getReadOnly() { return readOnly; }
  public void setReadOnly(boolean v) { readOnly = v; }

  /** Count hint. */
  protected Integer countHint;
  public Integer getCountHint() { return countHint; }
  public void setCountHint(Integer v) { countHint = v; }

  /** Nested feed (optional). */
  protected BaseFeed<?, ?> feed;
  @SuppressWarnings("unchecked")
  public F getFeed() { return (F) feed; }
  public void setFeed(F v) { feed = v; }

  /** Nested feed class. */
  protected final Class<F> feedClass;
  public Class<F> getFeedClass() { return feedClass; }

  /** Returns the suggested extension description. */
  public static ExtensionDescription getDefaultDescription() {
    return ExtensionDescription.getDefaultDescription(FeedLink.class);
  }
  
  @Override
  public String getType() {
    return ContentType.getAtomFeed().toString();
  }
  
  @Override
  protected void visitChildren(ExtensionVisitor ev)
      throws ExtensionVisitor.StoppedException {
    if (feed != null) {
      this.visitChild(ev, feed);
    }
    super.visitChildren(ev);
  }

  @Override
  public void generate(XmlWriter w, ExtensionProfile extProfile)
      throws IOException {

    ArrayList<XmlWriter.Attribute> attrs = new ArrayList<XmlWriter.Attribute>();

    if (rel != null) {
      attrs.add(new XmlWriter.Attribute("rel", rel));
    }

    if (href != null) {
      attrs.add(new XmlWriter.Attribute("href", href));
    }

    if (readOnly) {
      attrs.add(new XmlWriter.Attribute("readOnly", "true"));
    }

    if (countHint != null) {
      attrs.add(new XmlWriter.Attribute("countHint", countHint.toString()));
    }

    generateStartElement(w, Namespaces.gNs, "feedLink", attrs, null);

    if (feed != null) {
      ExtensionProfile nestedExtProfile = extProfile.getFeedLinkProfile();
      if (nestedExtProfile == null) {
        nestedExtProfile = extProfile;
      }
      feed.generateAtom(w, nestedExtProfile);
    }

    // Invoke ExtensionPoint.
    generateExtensions(w, extProfile);

    w.endElement(Namespaces.gNs, "feedLink");
  }

  @Override
  public ElementHandler getHandler(ExtensionProfile extProfile,
                                   String namespace,
                                   String localName,
                                   Attributes attrs) {
    return new Handler(extProfile);
  }

  /** <gd:feedLink> parser. */
  private class Handler extends Link.AtomHandler {

    public Handler(ExtensionProfile extProfile) {
      super(extProfile, FeedLink.class);
    }

    @Override
    public void processAttribute(String namespace,
                                 String localName,
                                 String value) throws ParseException {

      if (namespace.equals("")) {

        if (localName.equals("readOnly")) {
          readOnly = value.equals("true");
        } else if (localName.equals("countHint")) {
          try {
            countHint = Integer.valueOf(value);
          } catch (NumberFormatException e) {
            throw new ParseException(
                CoreErrorDomain.ERR.invalidCountHintAttribute, e);
          }
        } else {
          super.processAttribute(namespace, localName, value);
        }
      }
    }

    @Override
    public ElementHandler getChildHandler(String namespace,
                                          String localName,
                                          Attributes attrs)
        throws ParseException, IOException {

      if (namespace.equals(Namespaces.atom)) {
        if (localName.equals("feed")) {
          ExtensionProfile nestedExtProfile = extProfile.getFeedLinkProfile();
          if (nestedExtProfile == null) {
            nestedExtProfile = extProfile;
          }
          try {
            feed = feedClass.newInstance();
          } catch (IllegalAccessException iae) {
            throw new ParseException(
                CoreErrorDomain.ERR.cantCreateFeed, iae);
          } catch (InstantiationException ie) {
            throw new ParseException(
                CoreErrorDomain.ERR.cantCreateFeed, ie);
          }
          return feed.new FeedHandler(nestedExtProfile);
        }
      }

      return super.getChildHandler(namespace, localName, attrs);
    }
  }
}

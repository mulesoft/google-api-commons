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

import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Link;
import com.google.gdata.data.TextConstruct;
import com.google.gdata.data.media.MediaFeed;
import com.google.gdata.data.photos.impl.GphotoDataImpl;
import com.google.gdata.util.XmlParser.ElementHandler;

import org.xml.sax.Attributes;

import java.io.IOException;

/**
 * This class customizes the generic MediaFeed class to define a feed of
 * GphotoEntries. It also adds support for the GphotoData interface methods so
 * all subclasses have the base access methods available. In addition it
 * provides access to a consistent description field across both RSS and ATOM.
 *
 * 
 */
public class GphotoFeed<F extends GphotoFeed> extends MediaFeed<F, GphotoEntry>
    implements GphotoData, AtomData {

  // The delegating instance to deal with extensions.
  private final GphotoData delegate;

  /**
   * Construct a new {@code GphotoFeed} instance that is parameterized to
   * contain {@code GphotoEntry} instances.
   */
  public GphotoFeed() {
    this(GphotoEntry.class);
  }

  /**
   * Construct a new {@code GphotoFeed} instance parameterized to contain the
   * given {@code GphotoEntry} type. This should be used by subclasses to set up
   * subclassed entry types as needed.
   */
  protected GphotoFeed(Class<? extends GphotoEntry> entryClass) {
    super(entryClass);
    this.delegate = new GphotoDataImpl(this);
  }

  /**
   * Construct a new {@code GphotoFeed} instance parameterized to contain
   * {@code GphotoEntry} instances. The source data for the feed will be pulled
   * from the {@code BaseFeed} instance that was passed as source.
   */
  public GphotoFeed(BaseFeed<?, ?> sourceFeed) {
    this(GphotoEntry.class, sourceFeed);
  }

  /**
   * Construct a new {@code GphotoFeed} instance parameterized to contain the
   * given {@code GphotoEntry} subclass. The base state of the feed will be
   * drawn from the passed in {@code BaseFeed} instance. This constructor should
   * be used by subclasses to change the entry type supported by the feed.
   */
  protected GphotoFeed(Class<? extends GphotoEntry> entryClass,
      BaseFeed sourceFeed) {
    super(entryClass, sourceFeed);
    this.delegate = new GphotoDataImpl(this);
  }

  /*
   * Declare the extensions that are valid on every feed.
   */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    delegate.declareExtensions(extProfile);
    super.declareExtensions(extProfile);
  }

  /*
   * Override generating rss to add some extra atom fields into the rss output
   * that we want, in particular some links that are useful for api access.
   */
  @Override
  public void generateRss(XmlWriter w, ExtensionProfile extProfile)
      throws IOException {
    // Add atom:link elements for next and previous.
    Link prevLink = getLink(Link.Rel.PREVIOUS, Link.Type.ATOM);
    Link nextLink = getLink(Link.Rel.NEXT, Link.Type.ATOM);
    if (prevLink != null) {
      delegate.addRepeatingExtension(new RssLink(prevLink));
    }
    if (nextLink != null) {
      delegate.addRepeatingExtension(new RssLink(nextLink));
    }
    
    super.generateRss(w, extProfile);
  }
  
  /**
   * Wrapper around a regular link that will generate the atom:link for
   * rss feeds correctly.  Generate just calls to the
   * {@link Link#generateAtom(XmlWriter, ExtensionProfile)} method to generate
   * the output.
   */
  private static final class RssLink implements Extension {
    
    private final Link link;
    
    public RssLink(Link link) {
      this.link = link;
    }
    
    public void generate(XmlWriter w, ExtensionProfile extProfile)
        throws IOException {
      link.generateAtom(w, extProfile);
    }
    
    public ElementHandler getHandler(ExtensionProfile extProfile,
        String namespace, String localName, Attributes attrs) {
      return null;
    }
  }
  
  /**
   * Description on a feed is just the subtitle.
   */
  public TextConstruct getDescription() {
    return getSubtitle();
  }

  /**
   * Description on a feed is just the subtitle.
   */
  public void setDescription(TextConstruct description) {
    setSubtitle(description);
  }

  /**
   * Return the gphoto:id of this feed.
   */
  public String getGphotoId() {
    return delegate.getGphotoId();
  }

  /**
   * Set the gphoto:id of this feed as a long.
   */
  public void setGphotoId(Long id) {
    delegate.setGphotoId(id);
  }

  /**
   * Set the gphoto:id of this feed as a string.
   */
  public void setGphotoId(String id) {
    delegate.setGphotoId(id);
  }
}

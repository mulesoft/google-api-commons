/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.youtube;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Link;
import com.google.gdata.data.Kind;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.TextContent;

/**
 * A complaint.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_COMPLAINT)
public class ComplaintEntry extends BaseEntry<ComplaintEntry> {

  /**
   * Nonstandard categories that might be found in this entry.
   */
  public static final String[] CATEGORIES = {
    YouTubeNamespace.COMPLAINT_REASON_SCHEME
  };


  public ComplaintEntry() {
    EntryUtils.setKind(this, YouTubeNamespace.KIND_COMPLAINT);
  }

  public ComplaintEntry(BaseEntry<?> base) {
    super(base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_COMPLAINT);
  }
  
 /**
  * Adds a rel=related type=application/atom+xml link pointing to the
  * video.
  * 
  * @param url video url
  */
  public void addVideoUrl(String url) {
    Link link = new Link();
    link.setRel(Link.Rel.RELATED);
    link.setType(Link.Type.ATOM);
    link.setHref(url);
    getLinks().add(link);
  }

  /**
   * Gets the rel=related type=application/atom+xml link pointing to the video.
   * 
   * @return video url or null
   */
  public String getVideoUrl() {
    Link link = getLink(Link.Rel.RELATED, Link.Type.ATOM);
    return link == null ? null : link.getHref();
  }
  
  /**
   * Adds an optional comment to the complaint.
   * 
   * @param comment optional comment of the complaint
   */
  public void setComment(String comment) {
    setContent(comment == null ? null : new PlainTextConstruct(comment));
  }
  
  /**
   * Returns the comment of the complaint.
   * 
   * @return the comment of the complaint
   */
  public String getComment() {
    if (getContent() instanceof TextContent) {
      return ((TextContent) getContent()).getContent().getPlainText();
    }
    return null;
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    // Accept pretty much anything, so it's possible to post
    // videos to this feed to complain about them.
    extProfile.declareArbitraryXmlExtension(BaseEntry.class);
  }
}

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
import com.google.gdata.data.media.MediaEntry;
import com.google.gdata.data.Content;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.data.MediaContent;
import com.google.gdata.data.PubControl;
import com.google.gdata.data.Content.ChildHandlerInfo;
import com.google.gdata.util.ParseException;

import org.xml.sax.Attributes;

import java.io.IOException;

/**
 * A caption track.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_CAPTION_TRACK)
public class CaptionTrackEntry extends MediaEntry<CaptionTrackEntry> {


  public CaptionTrackEntry() {
    EntryUtils.setKind(this, YouTubeNamespace.KIND_CAPTION_TRACK);
  }

  public CaptionTrackEntry(BaseEntry<?> base) {
    super(base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_CAPTION_TRACK);
  }
  
  public String getLanguageCode() {
    Content content = getContent();
    return content == null ? null : content.getLang();
  }
  
  public void setPublicationState(YtPublicationState state) {
    PubControl control = getPubControl();
    if (state == null) {
      if (control == null) {
        return;
      } else {
        control.removeExtension(YtPublicationState.class);
        if (!control.isDraft() && control.getExtensions().isEmpty()) {
          setPubControl(null);
        }
      }
    } else {
      if (control == null) {
        control = new PubControl();
        setPubControl(control);
      }
      control.setExtension(state);
    }    
  }
  
  public YtPublicationState getPublicationState() {
    return getPubControl() == null ? null : 
      getPubControl().getExtension(YtPublicationState.class);
  }
  
  public void setDerived(YtDerived derived) {
    if (derived != null) {
      setExtension(derived);
    } else {
      removeExtension(YtDerived.class);
    }
  }
  
  public YtDerived getDerived() {
    return getExtension(YtDerived.class);
  }
  
  public void setFormatInfo(YtFormatInfo info) {
    if (info != null) {
      setExtension(info);
    } else {
      removeExtension(YtFormatInfo.class);
    }
  }
  
  public YtFormatInfo getFormatInfo() {
    return getExtension(YtFormatInfo.class);
  }
  
  public YtFormatInfo getOrCreateFormatInfo() {
    YtFormatInfo info = getFormatInfo();
    if (info == null) {
      info = new YtFormatInfo();
      setFormatInfo(info);
    }
    return getExtension(YtFormatInfo.class);
  }
  
  public boolean hasAutomaticSpeechRecognition() {
    YtDerived derived = getExtension(YtDerived.class);
    return derived!= null &&
      derived.getContent().equals(YtDerived.Value.SPEECH_RECOGNITION);
  }
  
  public void setAutomaticSpeechRecognition(boolean asr) {
    if (asr) {
      setExtension(new YtDerived(YtDerived.Value.SPEECH_RECOGNITION));
    } else {
      removeExtension(YtDerived.class);
    }    
  }

  @Override
  protected ChildHandlerInfo getContentHandlerInfo(ExtensionProfile extProfile, Attributes attrs)
      throws ParseException, IOException {
    return MediaContent.getChildHandler(extProfile, attrs);
  }
  
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    
    extProfile.declare(CaptionTrackEntry.class, YtDerived.class);
    extProfile.declare(CaptionTrackEntry.class, YtFormatInfo.class);
    
    extProfile.declareAdditionalNamespace(YouTubeNamespace.NS);
    extProfile.declare(PubControl.class, YtPublicationState.class);
    extProfile.declareArbitraryXmlExtension(CaptionTrackEntry.class);
  }
  
}

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
import com.google.gdata.data.Kind;

/**
 * An entry in the comment feed.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_COMMENT)
public class CommentEntry extends BaseEntry<CommentEntry> {

  public CommentEntry() {
    EntryUtils.setKind(this, YouTubeNamespace.KIND_COMMENT);
  }

  public CommentEntry(BaseEntry<?> base) {
    super(base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_COMMENT);
  }
  
  /**
   * Get the rating of the comment.
   * 
   * Some videos don't allow comment rating.
   * 
   * @return the rating of the comment. May be null.
   */
  public Integer getTotalRating() {
    YtCommentRating rating = getExtension(YtCommentRating.class);
    return rating == null ? null : rating.getTotal();
  }
  
  /**
   * Sets the rating of the comment.
   * 
   * @param rating the rating of the comment. Null will remove the rating.
   */
  public void setTotalRating(Integer rating) {
    if (rating == null) {
      removeExtension(YtCommentRating.class);
    } else {
      setExtension(new YtCommentRating(rating));
    }
  }
  
  /**
   * Check if the comment is marked as spam.
   * 
   * @return true if the comment is marked as spam
   */
  public boolean hasSpamHint() {
    return getExtension(YtSpam.class) != null ? true : false;
  }
  
  /**
   * Hint that the entry is spam.
   * 
   * @param spam if true the comment will be marked with the spam hint. 
   *     False will remove the hint.
   */
  public void setSpamHint(boolean spam) {
    if (spam) {
      setExtension(new YtSpam());
    } else { 
      removeExtension(YtSpam.class);
    }
  }
  
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);

    extProfile.declareAdditionalNamespace(YouTubeNamespace.NS);
    extProfile.declare(CommentEntry.class, YtSpam.class);
    extProfile.declare(CommentEntry.class, YtCommentRating.class);
    
    extProfile.declareArbitraryXmlExtension(CommentEntry.class);
  }
}

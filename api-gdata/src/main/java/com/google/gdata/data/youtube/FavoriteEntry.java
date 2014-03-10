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
 * A YouTube video favorite entry.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_FAVORITE)
public class FavoriteEntry extends VideoEntry {
  /** Create an empty favorite entry. */
  public FavoriteEntry() {
    super();
    EntryUtils.setKind(this, YouTubeNamespace.KIND_FAVORITE);
  }
  
  /** Creates a copy of another entry. */
  public FavoriteEntry(BaseEntry<?> original) {
    super(original);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_FAVORITE);
  }
  
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    super.declareExtensions(extProfile);
    
    extProfile.declareArbitraryXmlExtension(FavoriteEntry.class);
  }
}

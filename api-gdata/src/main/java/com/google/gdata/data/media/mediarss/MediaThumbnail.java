/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.media.mediarss;

import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.util.ParseException;


/**
 * {@code <media:thumbnail>}.
 *
 * See description on
 * <a href="http://search.yahoo.com/mrss">http://search.yahoo.com/mrss</a>.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = MediaRssNamespace.PREFIX,
    nsUri = MediaRssNamespace.URI,
    localName = "thumbnail",
    isRepeatable = true
)
public class MediaThumbnail extends AbstractMediaResource {

  private NormalPlayTime time;

  /** Describes the tag to an {@link com.google.gdata.data.ExtensionProfile}. */
  public static ExtensionDescription getDefaultDescription() {
    return ExtensionDescription.getDefaultDescription(MediaThumbnail.class);
  }


  public NormalPlayTime getTime() {
    return time;
  }

  public void setTime(NormalPlayTime time) {
    this.time = time;
  }

  @Override
  protected void putAttributes(AttributeGenerator generate) {
    super.putAttributes(generate);
    if (time != null) {
      generate.put("time", time.getNptHhmmssRepresentation());
    }
  }

  @Override
  protected void consumeAttributes(AttributeHelper attrsHelper)
      throws ParseException {
    super.consumeAttributes(attrsHelper);
    time = MediaAttributeHelper.consumeNormalPlayTime(attrsHelper, "time");
  }
}

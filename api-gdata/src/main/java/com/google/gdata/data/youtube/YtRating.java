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

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.util.ParseException;

/**
 * Object representation for the yt:rating tag.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = YouTubeNamespace.PREFIX,
    nsUri = YouTubeNamespace.URI,
    localName = "rating")
public class YtRating extends AbstractExtension {
  
  /** Value of this rating element. */
  public static final class Value {

    /** Dislike rating. */
    public static final String DISLIKE = "dislike";

    /** Like rating. */
    public static final String LIKE = "like";

    /** Array containing all available values. */
    private static final String[] ALL_VALUES = {
      DISLIKE,
      LIKE};

    /** Returns an array of all values defined in this class. */
    public static String[] values() {
      return ALL_VALUES;
    }

    private Value() {}
  }
  
  private static final String NUM_LIKES = "numLikes";
  private static final String NUM_DISLIKES = "numDislikes";
  private static final String VALUE = "value";
  
  private int numLikes;
  private int numDislikes;
  private String value;
  
  /** Creates an empty tag. */
  public YtRating() {
  }

  /**
   * Creates a rating tag with the given attributes.
   * 
   * @param numLikes number of like votes.
   * @param numDislikes number of dislike votes.
   */
  public YtRating(int numLikes, int numDislikes) {
    this.numLikes = numLikes;
    this.numDislikes = numDislikes;
  }
  
  /**
   * Creates a rating tag with the given value.
   * 
   * @param value rating value, one of {@link Value}.
   */
  public YtRating(String value) {
    this.value = value;
  }
  
  /**
   * @return the numLikes
   */
  public int getNumLikes() {
    return numLikes;
  }
  
  /**
   * @param numLikes the numLikes to set
   */
  public void setNumLikes(int numLikes) {
    this.numLikes = numLikes;
  }
  
  /**
   * @return the numDislikes
   */
  public int getNumDislikes() {
    return numDislikes;
  }
  
  /**
   * @param numDislikes the numDislikes to set
   */
  public void setNumDislikes(int numDislikes) {
    this.numDislikes = numDislikes;
  }
  
  /**
   * @return the value
   */
  public String getValue() {
    return value;
  }
  
  /**
   * @param value the value to set, one of {@link Value}.
   */
  public void setValue(String value) {
    this.value = value;
  }
  
  @Override
  protected void consumeAttributes(AttributeHelper helper) throws ParseException {
    super.consumeAttributes(helper);
    numLikes = helper.consumeInteger(NUM_LIKES, false);
    numDislikes = helper.consumeInteger(NUM_DISLIKES, false);
    value = helper.consume(VALUE, false);
  }
  
  @Override
  protected void putAttributes(AttributeGenerator generator) {
    super.putAttributes(generator);
    if (numLikes > 0) {
      generator.put(NUM_LIKES, numLikes);
    }
    
    if (numDislikes > 0) {
      generator.put(NUM_DISLIKES, numDislikes);
    }
    
    if (value != null) {
      generator.put(VALUE, value);
    }
  }
}

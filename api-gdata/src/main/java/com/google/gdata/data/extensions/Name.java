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

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.Namespaces;

/**
 * Name of a person in a structured form.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = Namespaces.gAlias,
    nsUri = Namespaces.g,
    localName = Name.XML_NAME)
public class Name extends ExtensionPoint {

  /** XML element name */
  static final String XML_NAME = "name";

  /**
   * Default mutable constructor.
   */
  public Name() {
    super();
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(Name.class)) {
      return;
    }
    extProfile.declare(Name.class, AdditionalName.class);
    extProfile.declare(Name.class, FamilyName.class);
    extProfile.declare(Name.class, FullName.class);
    extProfile.declare(Name.class, GivenName.class);
    extProfile.declare(Name.class, NamePrefix.class);
    extProfile.declare(Name.class, NameSuffix.class);
  }

  /**
   * Returns the additional name.
   *
   * @return additional name
   */
  public AdditionalName getAdditionalName() {
    return getExtension(AdditionalName.class);
  }

  /**
   * Sets the additional name.
   *
   * @param additionalName additional name or <code>null</code> to reset
   */
  public void setAdditionalName(AdditionalName additionalName) {
    if (additionalName == null) {
      removeExtension(AdditionalName.class);
    } else {
      setExtension(additionalName);
    }
  }

  /**
   * Returns whether it has the additional name.
   *
   * @return whether it has the additional name
   */
  public boolean hasAdditionalName() {
    return hasExtension(AdditionalName.class);
  }

  /**
   * Returns the family name.
   *
   * @return family name
   */
  public FamilyName getFamilyName() {
    return getExtension(FamilyName.class);
  }

  /**
   * Sets the family name.
   *
   * @param familyName family name or <code>null</code> to reset
   */
  public void setFamilyName(FamilyName familyName) {
    if (familyName == null) {
      removeExtension(FamilyName.class);
    } else {
      setExtension(familyName);
    }
  }

  /**
   * Returns whether it has the family name.
   *
   * @return whether it has the family name
   */
  public boolean hasFamilyName() {
    return hasExtension(FamilyName.class);
  }

  /**
   * Returns the full name.
   *
   * @return full name
   */
  public FullName getFullName() {
    return getExtension(FullName.class);
  }

  /**
   * Sets the full name.
   *
   * @param fullName full name or <code>null</code> to reset
   */
  public void setFullName(FullName fullName) {
    if (fullName == null) {
      removeExtension(FullName.class);
    } else {
      setExtension(fullName);
    }
  }

  /**
   * Returns whether it has the full name.
   *
   * @return whether it has the full name
   */
  public boolean hasFullName() {
    return hasExtension(FullName.class);
  }

  /**
   * Returns the given name.
   *
   * @return given name
   */
  public GivenName getGivenName() {
    return getExtension(GivenName.class);
  }

  /**
   * Sets the given name.
   *
   * @param givenName given name or <code>null</code> to reset
   */
  public void setGivenName(GivenName givenName) {
    if (givenName == null) {
      removeExtension(GivenName.class);
    } else {
      setExtension(givenName);
    }
  }

  /**
   * Returns whether it has the given name.
   *
   * @return whether it has the given name
   */
  public boolean hasGivenName() {
    return hasExtension(GivenName.class);
  }

  /**
   * Returns the name prefix.
   *
   * @return name prefix
   */
  public NamePrefix getNamePrefix() {
    return getExtension(NamePrefix.class);
  }

  /**
   * Sets the name prefix.
   *
   * @param namePrefix name prefix or <code>null</code> to reset
   */
  public void setNamePrefix(NamePrefix namePrefix) {
    if (namePrefix == null) {
      removeExtension(NamePrefix.class);
    } else {
      setExtension(namePrefix);
    }
  }

  /**
   * Returns whether it has the name prefix.
   *
   * @return whether it has the name prefix
   */
  public boolean hasNamePrefix() {
    return hasExtension(NamePrefix.class);
  }

  /**
   * Returns the name suffix.
   *
   * @return name suffix
   */
  public NameSuffix getNameSuffix() {
    return getExtension(NameSuffix.class);
  }

  /**
   * Sets the name suffix.
   *
   * @param nameSuffix name suffix or <code>null</code> to reset
   */
  public void setNameSuffix(NameSuffix nameSuffix) {
    if (nameSuffix == null) {
      removeExtension(NameSuffix.class);
    } else {
      setExtension(nameSuffix);
    }
  }

  /**
   * Returns whether it has the name suffix.
   *
   * @return whether it has the name suffix
   */
  public boolean hasNameSuffix() {
    return hasExtension(NameSuffix.class);
  }

  @Override
  protected void validate() {
  }

  /**
   * Returns the extension description, specifying whether it is required, and
   * whether it is repeatable.
   *
   * @param required   whether it is required
   * @param repeatable whether it is repeatable
   * @return extension description
   */
  public static ExtensionDescription getDefaultDescription(boolean required,
      boolean repeatable) {
    ExtensionDescription desc =
        ExtensionDescription.getDefaultDescription(Name.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{Name}";
  }

}

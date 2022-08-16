/*
 * Copyright (c) 2022 codbex or an codbex affiliate company and contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2022 codbex or an codbex affiliate company and contributors
 * SPDX-License-Identifier: EPL-2.0
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.11.26 at 10:54:28 AM EET 
//


package com.codbex.kronos.ndb.bimodeldimension;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import com.codbex.kronos.ndb.bimodeldatafoundation.LogicalObject;


/**
 * A dimension (aka attribute view) is a reusable entity to combine several physical table to a logical model
 * defining attributes and hierarchies on top.
 * Constraints: All key attributes must have the same table in the key mapping (see also df:DataFoundation)
 *
 *
 * Java class for Dimension complex type.
 *
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Dimension"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/BiModelDataFoundation.ecore}LogicalObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="hierarchies" type="{http://www.sap.com/ndb/BiModelDimension.ecore}Hierarchies" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="dimensionType" use="required" type="{http://www.sap.com/ndb/BiModelDimension.ecore}DimensionType" /&gt;
 *       &lt;attribute name="derived" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="defaultMember" type="{http://www.sap.com/ndb/BaseModelBase.ecore}DefaultMember" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dimension", propOrder = {
    "hierarchies"
})
@XmlSeeAlso({
    DerivedDimension.class
})
public class Dimension
    extends LogicalObject {

  /** The hierarchies. */
  protected Hierarchies hierarchies;
  
  /** The dimension type. */
  @XmlAttribute(name = "dimensionType", required = true)
  protected DimensionType dimensionType;
  
  /** The derived. */
  @XmlAttribute(name = "derived")
  protected Boolean derived;
  
  /** The default member. */
  @XmlAttribute(name = "defaultMember")
  protected String defaultMember;

  /**
   * Gets the value of the hierarchies property.
   *
   * @return possible object is
   * {@link Hierarchies }
   */
  public Hierarchies getHierarchies() {
    return hierarchies;
  }

  /**
   * Sets the value of the hierarchies property.
   *
   * @param value allowed object is
   *              {@link Hierarchies }
   */
  public void setHierarchies(Hierarchies value) {
    this.hierarchies = value;
  }

  /**
   * Gets the value of the dimensionType property.
   *
   * @return possible object is
   * {@link DimensionType }
   */
  public DimensionType getDimensionType() {
    return dimensionType;
  }

  /**
   * Sets the value of the dimensionType property.
   *
   * @param value allowed object is
   *              {@link DimensionType }
   */
  public void setDimensionType(DimensionType value) {
    this.dimensionType = value;
  }

  /**
   * Gets the value of the derived property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isDerived() {
    return derived;
  }

  /**
   * Sets the value of the derived property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setDerived(Boolean value) {
    this.derived = value;
  }

  /**
   * Gets the value of the defaultMember property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getDefaultMember() {
    return defaultMember;
  }

  /**
   * Sets the value of the defaultMember property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setDefaultMember(String value) {
    this.defaultMember = value;
  }

}

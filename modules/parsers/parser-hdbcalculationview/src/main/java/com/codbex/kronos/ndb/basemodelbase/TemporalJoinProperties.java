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


package com.codbex.kronos.ndb.basemodelbase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Additional (join) properties neded to specify a temporal join
 *
 *
 * Java class for TemporalJoinProperties complex type.
 *
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TemporalJoinProperties"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="temporalElementName" use="required" type="{http://www.sap.com/ndb/BaseModelBase.ecore}DbName" /&gt;
 *       &lt;attribute name="fromElementName" type="{http://www.sap.com/ndb/BaseModelBase.ecore}DbName" /&gt;
 *       &lt;attribute name="toElementName" type="{http://www.sap.com/ndb/BaseModelBase.ecore}DbName" /&gt;
 *       &lt;attribute name="temporalCondition" use="required" type="{http://www.sap.com/ndb/BaseModelBase.ecore}TemporalCondition" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemporalJoinProperties")
public class TemporalJoinProperties {

  /** The temporal element name. */
  @XmlAttribute(name = "temporalElementName", required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String temporalElementName;
  
  /** The from element name. */
  @XmlAttribute(name = "fromElementName")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String fromElementName;
  
  /** The to element name. */
  @XmlAttribute(name = "toElementName")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String toElementName;
  
  /** The temporal condition. */
  @XmlAttribute(name = "temporalCondition", required = true)
  protected TemporalCondition temporalCondition;

  /**
   * Gets the value of the temporalElementName property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getTemporalElementName() {
    return temporalElementName;
  }

  /**
   * Sets the value of the temporalElementName property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setTemporalElementName(String value) {
    this.temporalElementName = value;
  }

  /**
   * Gets the value of the fromElementName property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getFromElementName() {
    return fromElementName;
  }

  /**
   * Sets the value of the fromElementName property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setFromElementName(String value) {
    this.fromElementName = value;
  }

  /**
   * Gets the value of the toElementName property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getToElementName() {
    return toElementName;
  }

  /**
   * Sets the value of the toElementName property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setToElementName(String value) {
    this.toElementName = value;
  }

  /**
   * Gets the value of the temporalCondition property.
   *
   * @return possible object is
   * {@link TemporalCondition }
   */
  public TemporalCondition getTemporalCondition() {
    return temporalCondition;
  }

  /**
   * Sets the value of the temporalCondition property.
   *
   * @param value allowed object is
   *              {@link TemporalCondition }
   */
  public void setTemporalCondition(TemporalCondition value) {
    this.temporalCondition = value;
  }

}

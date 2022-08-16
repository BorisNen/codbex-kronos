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


package com.codbex.kronos.ndb.bimodelcalculation;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import com.codbex.kronos.ndb.datamodeltype.ExpressionLanguage;


/**
 * Base type for all calculation views/nodes. Models filters and the default view property
 *
 *
 * Java class for CalculationView complex type.
 *
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CalculationView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/BiModelCalculation.ecore}Node"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="input" type="{http://www.sap.com/ndb/BiModelCalculation.ecore}Input" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="filter" type="{http://www.sap.com/ndb/BiModelDataFoundation.ecore}Expression" minOccurs="0"/&gt;
 *         &lt;element name="fuzzySearchFilter" type="{http://www.sap.com/ndb/BiModelCalculation.ecore}ViewAttribute" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="defaultView" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="filterExpressionLanguage" type="{http://www.sap.com/ndb/DataModelType.ecore}ExpressionLanguage" /&gt;
 *       &lt;attribute name="ignoreMultipleOutputsForFilter" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalculationView", propOrder = {
    "input",
    "filter",
    "fuzzySearchFilter"
})
@XmlSeeAlso({
    ProjectionView.class,
    RankView.class,
    JoinView.class,
    UnionView.class,
    MinusView.class,
    IntersectView.class,
    AggregationView.class,
    TableFunctionView.class,
    NonEquiJoinView.class,
    HierarchyView.class,
    AnonymizeView.class
})
public class CalculationView
    extends Node {

  /** The input. */
  protected List<Input> input;
  
  /** The filter. */
  protected String filter;
  
  /** The fuzzy search filter. */
  protected List<ViewAttribute> fuzzySearchFilter;
  
  /** The default view. */
  @XmlAttribute(name = "defaultView")
  protected Boolean defaultView;
  
  /** The filter expression language. */
  @XmlAttribute(name = "filterExpressionLanguage")
  protected ExpressionLanguage filterExpressionLanguage;
  
  /** The ignore multiple outputs for filter. */
  @XmlAttribute(name = "ignoreMultipleOutputsForFilter")
  protected Boolean ignoreMultipleOutputsForFilter;

  /**
   * Gets the value of the input property.
   * 
   * 
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the input property.
   * 
   * 
   * For example, to add a new item, do as follows:
   * <pre>
   *    getInput().add(newItem);
   * </pre>
   * 
   * 
   * 
   * Objects of the following type(s) are allowed in the list
   * {@link Input }
   *
   * @return the input
   */
  public List<Input> getInput() {
    if (input == null) {
      input = new ArrayList<Input>();
    }
    return this.input;
  }

  /**
   * Gets the value of the filter property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getFilter() {
    return filter;
  }

  /**
   * Sets the value of the filter property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setFilter(String value) {
    this.filter = value;
  }

  /**
   * Gets the value of the fuzzySearchFilter property.
   * 
   * 
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the fuzzySearchFilter property.
   * 
   * 
   * For example, to add a new item, do as follows:
   * <pre>
   *    getFuzzySearchFilter().add(newItem);
   * </pre>
   * 
   * 
   * 
   * Objects of the following type(s) are allowed in the list
   * {@link ViewAttribute }
   *
   * @return the fuzzy search filter
   */
  public List<ViewAttribute> getFuzzySearchFilter() {
    if (fuzzySearchFilter == null) {
      fuzzySearchFilter = new ArrayList<ViewAttribute>();
    }
    return this.fuzzySearchFilter;
  }

  /**
   * Gets the value of the defaultView property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isDefaultView() {
    return defaultView;
  }

  /**
   * Sets the value of the defaultView property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setDefaultView(Boolean value) {
    this.defaultView = value;
  }

  /**
   * Gets the value of the filterExpressionLanguage property.
   *
   * @return possible object is
   * {@link ExpressionLanguage }
   */
  public ExpressionLanguage getFilterExpressionLanguage() {
    return filterExpressionLanguage;
  }

  /**
   * Sets the value of the filterExpressionLanguage property.
   *
   * @param value allowed object is
   *              {@link ExpressionLanguage }
   */
  public void setFilterExpressionLanguage(ExpressionLanguage value) {
    this.filterExpressionLanguage = value;
  }

  /**
   * Gets the value of the ignoreMultipleOutputsForFilter property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isIgnoreMultipleOutputsForFilter() {
    return ignoreMultipleOutputsForFilter;
  }

  /**
   * Sets the value of the ignoreMultipleOutputsForFilter property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setIgnoreMultipleOutputsForFilter(Boolean value) {
    this.ignoreMultipleOutputsForFilter = value;
  }

}

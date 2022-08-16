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


package com.codbex.kronos.ndb.datamodelhierarchy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * Java class for HierarchyFunction.
 *
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;simpleType name="HierarchyFunction"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="HIERARCHY"/&gt;
 *     &lt;enumeration value="HIERARCHY_LEVELED"/&gt;
 *     &lt;enumeration value="HIERARCHY_TEMPORAL"/&gt;
 *     &lt;enumeration value="HIERARCHY_SPANTREE"/&gt;
 *     &lt;enumeration value="HIERARCHY_DESCENDANTS"/&gt;
 *     &lt;enumeration value="HIERARCHY_ANCESTORS"/&gt;
 *     &lt;enumeration value="HIERARCHY_SIBLINGS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "HierarchyFunction")
@XmlEnum
public enum HierarchyFunction {

  /** The hierarchy. */
  HIERARCHY,
  
  /** The hierarchy leveled. */
  HIERARCHY_LEVELED,
  
  /** The hierarchy temporal. */
  HIERARCHY_TEMPORAL,
  
  /** The hierarchy spantree. */
  HIERARCHY_SPANTREE,
  
  /** The hierarchy descendants. */
  HIERARCHY_DESCENDANTS,
  
  /** The hierarchy ancestors. */
  HIERARCHY_ANCESTORS,
  
  /** The hierarchy siblings. */
  HIERARCHY_SIBLINGS;

  /**
   * From value.
   *
   * @param v the v
   * @return the hierarchy function
   */
  public static HierarchyFunction fromValue(String v) {
    return valueOf(v);
  }

  /**
   * Value.
   *
   * @return the string
   */
  public String value() {
    return name();
  }

}

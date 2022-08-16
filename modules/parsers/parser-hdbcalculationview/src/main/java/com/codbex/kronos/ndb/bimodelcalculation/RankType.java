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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * Java class for RankType.
 *
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;simpleType name="RankType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *     &lt;enumeration value="row_number"/&gt;
 *     &lt;enumeration value="row_number_percent"/&gt;
 *     &lt;enumeration value="rank"/&gt;
 *     &lt;enumeration value="rank_percent"/&gt;
 *     &lt;enumeration value="dense_rank"/&gt;
 *     &lt;enumeration value="dense_rank_percent"/&gt;
 *     &lt;enumeration value="sum"/&gt;
 *     &lt;enumeration value="sum_percent"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "RankType")
@XmlEnum
public enum RankType {

  /** The row number. */
  @XmlEnumValue("row_number")
  ROW_NUMBER("row_number"),
  
  /** The row number percent. */
  @XmlEnumValue("row_number_percent")
  ROW_NUMBER_PERCENT("row_number_percent"),
  
  /** The rank. */
  @XmlEnumValue("rank")
  RANK("rank"),
  
  /** The rank percent. */
  @XmlEnumValue("rank_percent")
  RANK_PERCENT("rank_percent"),
  
  /** The dense rank. */
  @XmlEnumValue("dense_rank")
  DENSE_RANK("dense_rank"),
  
  /** The dense rank percent. */
  @XmlEnumValue("dense_rank_percent")
  DENSE_RANK_PERCENT("dense_rank_percent"),
  
  /** The sum. */
  @XmlEnumValue("sum")
  SUM("sum"),
  
  /** The sum percent. */
  @XmlEnumValue("sum_percent")
  SUM_PERCENT("sum_percent");
  
  /** The value. */
  private final String value;

  /**
   * Instantiates a new rank type.
   *
   * @param v the v
   */
  RankType(String v) {
    value = v;
  }

  /**
   * From value.
   *
   * @param v the v
   * @return the rank type
   */
  public static RankType fromValue(String v) {
    for (RankType c : RankType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

  /**
   * Value.
   *
   * @return the string
   */
  public String value() {
    return value;
  }

}

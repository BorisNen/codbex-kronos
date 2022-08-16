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


package com.codbex.kronos.ndb.datamodeltype;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * Java class for PrimitiveType.
 *
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;simpleType name="PrimitiveType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CHAR"/&gt;
 *     &lt;enumeration value="VARCHAR"/&gt;
 *     &lt;enumeration value="NCHAR"/&gt;
 *     &lt;enumeration value="NVARCHAR"/&gt;
 *     &lt;enumeration value="TINYINT"/&gt;
 *     &lt;enumeration value="SMALLINT"/&gt;
 *     &lt;enumeration value="INTEGER"/&gt;
 *     &lt;enumeration value="BIGINT"/&gt;
 *     &lt;enumeration value="DECIMAL"/&gt;
 *     &lt;enumeration value="NUMERIC"/&gt;
 *     &lt;enumeration value="REAL"/&gt;
 *     &lt;enumeration value="FLOAT"/&gt;
 *     &lt;enumeration value="DOUBLE"/&gt;
 *     &lt;enumeration value="DATE"/&gt;
 *     &lt;enumeration value="TIME"/&gt;
 *     &lt;enumeration value="TIMESTAMP"/&gt;
 *     &lt;enumeration value="SECONDDATE"/&gt;
 *     &lt;enumeration value="BLOB"/&gt;
 *     &lt;enumeration value="CLOB"/&gt;
 *     &lt;enumeration value="NCLOB"/&gt;
 *     &lt;enumeration value="BINARY"/&gt;
 *     &lt;enumeration value="VARBINARY"/&gt;
 *     &lt;enumeration value="SMALLDECIMAL"/&gt;
 *     &lt;enumeration value="TEXT"/&gt;
 *     &lt;enumeration value="SHORTTEXT"/&gt;
 *     &lt;enumeration value="ST_POINT"/&gt;
 *     &lt;enumeration value="ST_GEOMETRY"/&gt;
 *     &lt;enumeration value="ALPHANUM"/&gt;
 *     &lt;enumeration value="BOOLEAN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "PrimitiveType")
@XmlEnum
public enum PrimitiveType {


  /**
   * The char.
   *
   * @deprecated - Deprecated SAP HANA type
   */
  CHAR,
  
  /** The varchar. */
  VARCHAR,

  /**
   * The nchar.
   *
   * @deprecated - Deprecated SAP HANA type
   */
  NCHAR,
  
  /** The nvarchar. */
  NVARCHAR,
  
  /** The tinyint. */
  TINYINT,
  
  /** The smallint. */
  SMALLINT,
  
  /** The integer. */
  INTEGER,
  
  /** The bigint. */
  BIGINT,
  
  /** The decimal. */
  DECIMAL,

  /**
   * The numeric.
   *
   * @deprecated - Deprecated SAP HANA type
   */
  NUMERIC,
  
  /** The real. */
  REAL,
  
  /** The float. */
  FLOAT,
  
  /** The double. */
  DOUBLE,
  
  /** The date. */
  DATE,
  
  /** The time. */
  TIME,
  
  /** The timestamp. */
  TIMESTAMP,
  
  /** The seconddate. */
  SECONDDATE,
  
  /** The blob. */
  BLOB,
  
  /** The clob. */
  CLOB,
  
  /** The nclob. */
  NCLOB,

  /**
   * The binary.
   *
   * @deprecated - Deprecated SAP HANA type
   */
  BINARY,
  
  /** The varbinary. */
  VARBINARY,
  
  /** The smalldecimal. */
  SMALLDECIMAL,
  
  /** The text. */
  TEXT,
  
  /** The shorttext. */
  SHORTTEXT,
  
  /** The st point. */
  ST_POINT,
  
  /** The st geometry. */
  ST_GEOMETRY,
  
  /** The alphanum. */
  ALPHANUM,
  
  /** The boolean. */
  BOOLEAN;

  /**
   * From value.
   *
   * @param v the v
   * @return the primitive type
   */
  public static PrimitiveType fromValue(String v) {
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

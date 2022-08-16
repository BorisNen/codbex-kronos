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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.codbex.kronos.ndb.datamodelentity.Entity;


/**
 * Structured data type containing several elements
 * Attention in the catalog this is referred to as TableType, but a TableType in CDS really means
 * several rows!)
 *
 *
 * Java class for StructureType complex type.
 *
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StructureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/DataModelType.ecore}DataType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="element" type="{http://www.sap.com/ndb/DataModelType.ecore}Element" maxOccurs="unbounded"/&gt;
 *         &lt;element name="keyElement" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}Identifier" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="displayFolder" type="{http://www.sap.com/ndb/DataModelType.ecore}DisplayFolder" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="catalogOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="physicalSchemaName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="authoringSchemaName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="physicalDatabaseName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="authoringDatabaseName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructureType", propOrder = {
    "element",
    "keyElement",
    "displayFolder"
})
@XmlSeeAlso({
    Entity.class
})
public class StructureType
    extends DataType {

  /** The element. */
  @XmlElement(required = true)
  protected List<Element> element;
  
  /** The key element. */
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected List<String> keyElement;
  
  /** The display folder. */
  protected List<DisplayFolder> displayFolder;
  
  /** The catalog only. */
  @XmlAttribute(name = "catalogOnly")
  protected Boolean catalogOnly;
  
  /** The physical schema name. */
  @XmlAttribute(name = "physicalSchemaName")
  protected String physicalSchemaName;
  
  /** The authoring schema name. */
  @XmlAttribute(name = "authoringSchemaName")
  protected String authoringSchemaName;
  
  /** The physical database name. */
  @XmlAttribute(name = "physicalDatabaseName")
  protected String physicalDatabaseName;
  
  /** The authoring database name. */
  @XmlAttribute(name = "authoringDatabaseName")
  protected String authoringDatabaseName;

  /**
   * Gets the value of the element property.
   * 
   * 
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the element property.
   * 
   * 
   * For example, to add a new item, do as follows:
   * <pre>
   *    getElement().add(newItem);
   * </pre>
   * 
   * 
   * 
   * Objects of the following type(s) are allowed in the list
   * {@link Element }
   *
   * @return the element
   */
  public List<Element> getElement() {
    if (element == null) {
      element = new ArrayList<Element>();
    }
    return this.element;
  }

  /**
   * Gets the value of the keyElement property.
   * 
   * 
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the keyElement property.
   * 
   * 
   * For example, to add a new item, do as follows:
   * <pre>
   *    getKeyElement().add(newItem);
   * </pre>
   * 
   * 
   * 
   * Objects of the following type(s) are allowed in the list
   * {@link String }
   *
   * @return the key element
   */
  public List<String> getKeyElement() {
    if (keyElement == null) {
      keyElement = new ArrayList<String>();
    }
    return this.keyElement;
  }

  /**
   * Gets the value of the displayFolder property.
   * 
   * 
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the displayFolder property.
   * 
   * 
   * For example, to add a new item, do as follows:
   * <pre>
   *    getDisplayFolder().add(newItem);
   * </pre>
   * 
   * 
   * 
   * Objects of the following type(s) are allowed in the list
   * {@link DisplayFolder }
   *
   * @return the display folder
   */
  public List<DisplayFolder> getDisplayFolder() {
    if (displayFolder == null) {
      displayFolder = new ArrayList<DisplayFolder>();
    }
    return this.displayFolder;
  }

  /**
   * Gets the value of the catalogOnly property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isCatalogOnly() {
    return catalogOnly;
  }

  /**
   * Sets the value of the catalogOnly property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setCatalogOnly(Boolean value) {
    this.catalogOnly = value;
  }

  /**
   * Gets the value of the physicalSchemaName property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getPhysicalSchemaName() {
    return physicalSchemaName;
  }

  /**
   * Sets the value of the physicalSchemaName property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setPhysicalSchemaName(String value) {
    this.physicalSchemaName = value;
  }

  /**
   * Gets the value of the authoringSchemaName property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getAuthoringSchemaName() {
    return authoringSchemaName;
  }

  /**
   * Sets the value of the authoringSchemaName property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setAuthoringSchemaName(String value) {
    this.authoringSchemaName = value;
  }

  /**
   * Gets the value of the physicalDatabaseName property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getPhysicalDatabaseName() {
    return physicalDatabaseName;
  }

  /**
   * Sets the value of the physicalDatabaseName property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setPhysicalDatabaseName(String value) {
    this.physicalDatabaseName = value;
  }

  /**
   * Gets the value of the authoringDatabaseName property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getAuthoringDatabaseName() {
    return authoringDatabaseName;
  }

  /**
   * Sets the value of the authoringDatabaseName property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setAuthoringDatabaseName(String value) {
    this.authoringDatabaseName = value;
  }

}

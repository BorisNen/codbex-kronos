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


package com.codbex.kronos.ndb.datamodelgraph;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Parameterization for the graph action GET_STRONGLY_CONNECTED_COMPONENTS
 * The action GET_STRONGLY_CONNECTED_COMPONENTS calculates strongly connected components in the given graph workspace.
 * Strongly connected components partition the given graph workspace into largest subgraphs where every vertex is reachable
 * from every other vertex.
 * The only output is a table containing the vertex key column and a "COMPONENT" column containing component numbers.
 * All vertices having the same component number belong to the same strongly connected component.
 *
 *
 * Java class for GetStronglyConnectedComponents complex type.
 *
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GetStronglyConnectedComponents"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/DataModelGraph.ecore}GraphActionParameterization"&gt;
 *       &lt;sequence&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetStronglyConnectedComponents")
public class GetStronglyConnectedComponents
    extends GraphActionParameterization {


}

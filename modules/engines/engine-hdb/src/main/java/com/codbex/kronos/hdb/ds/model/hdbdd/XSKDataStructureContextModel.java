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
package com.codbex.kronos.hdb.ds.model.hdbdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Data Structure Entities Context Model.
 */
public class XSKDataStructureContextModel {

  private String name;

  private Map<String, XSKDataStructureTypeDefinitionModel> types = new HashMap<String, XSKDataStructureTypeDefinitionModel>();

  private List<XSKDataStructureEntityModel> entities = new ArrayList<XSKDataStructureEntityModel>();


  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the types.
   *
   * @return the types
   */
  public Map<String, XSKDataStructureTypeDefinitionModel> getTypes() {
    return types;
  }

  /**
   * Gets the entities.
   *
   * @return the entities
   */
  public List<XSKDataStructureEntityModel> getЕntities() {
    return entities;
  }


}

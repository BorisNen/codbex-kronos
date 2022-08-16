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
package com.codbex.kronos.synchronizer.exceptions;

import org.junit.Test;

import com.codbex.kronos.exceptions.XSJSLibSynchronizerUnresolvedPathTypeException;

import static org.junit.Assert.assertEquals;

public class XSJSLibSynhronizerUnresolvedPathTypeExceptionTest {
  @Test
  public void unresolvedPathTypeExceptionTest() {
    XSJSLibSynchronizerUnresolvedPathTypeException exception = new XSJSLibSynchronizerUnresolvedPathTypeException("test");
    assertEquals("Unexpected exception message", "test", exception.getMessage());
  }
}

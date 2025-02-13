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
package com.codbex.kronos.hdb.ds.processors.synonym;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;

import org.apache.commons.io.IOUtils;
import org.eclipse.dirigible.api.v3.problems.ProblemsFacade;
import org.eclipse.dirigible.commons.config.Configuration;
import org.eclipse.dirigible.core.scheduler.api.ISynchronizerArtefactType.ArtefactState;
import org.eclipse.dirigible.core.test.AbstractDirigibleTest;
import org.eclipse.dirigible.database.persistence.utils.DatabaseMetadataUtil;
import org.eclipse.dirigible.database.sql.DatabaseArtifactTypes;
import org.eclipse.dirigible.database.sql.SqlFactory;
import org.eclipse.dirigible.database.sql.builders.CreateBranchingBuilder;
import org.eclipse.dirigible.database.sql.builders.DropBranchingBuilder;
import org.eclipse.dirigible.database.sql.builders.synonym.CreateSynonymBuilder;
import org.eclipse.dirigible.database.sql.builders.synonym.DropSynonymBuilder;
import org.eclipse.dirigible.database.sql.dialects.hana.HanaSqlDialect;
import org.eclipse.dirigible.database.sql.dialects.postgres.PostgresSqlDialect;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.codbex.kronos.hdb.ds.model.DataStructureModelFactory;
import com.codbex.kronos.hdb.ds.model.hdbsynonym.DataStructureHDBSynonymModel;

@RunWith(MockitoJUnitRunner.class)
public class SynonymProcessorTest extends AbstractDirigibleTest {

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private Connection mockConnection;

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private SqlFactory mockSqlFactory;

  @Mock
  private CreateBranchingBuilder create;

  @Mock
  private CreateSynonymBuilder mockCreateSynonymBuilder;

  @Mock
  private DropBranchingBuilder drop;

  @Mock
  private DropSynonymBuilder mockDropSynonymBuilder;

  @Before
  public void openMocks() {
    MockitoAnnotations.openMocks(this);
    Configuration.set(DatabaseMetadataUtil.DIRIGIBLE_DATABASE_NAMES_CASE_SENSITIVE, "true");
  }

  @Test
  public void executeCreateSynonymHANAv1Successfully() throws Exception {
    SynonymCreateProcessor processorSpy = spy(SynonymCreateProcessor.class);
    String hdbsynonymSample = IOUtils.toString(SynonymProcessorTest.class.getResourceAsStream("/MySynonym.hdbsynonym"),
        StandardCharsets.UTF_8);

    DataStructureHDBSynonymModel model = DataStructureModelFactory.parseSynonym("hdb_view/MySynonym.hdbsynonym", hdbsynonymSample);
    model.setName("\"MYSCHEMA\".\"hdb_view::MySynonym\"");
    String mockSQL = "testSQLScript";

    try (MockedStatic<SqlFactory> sqlFactory = Mockito.mockStatic(SqlFactory.class);
        MockedStatic<Configuration> configuration = Mockito.mockStatic(Configuration.class)) {
      sqlFactory.when(() -> SqlFactory.getNative(mockConnection)).thenReturn(mockSqlFactory);
      sqlFactory.when(() -> SqlFactory.deriveDialect(mockConnection)).thenReturn(new HanaSqlDialect());
      sqlFactory.when(() -> SqlFactory.getNative(mockConnection).create()).thenReturn(create);
      sqlFactory.when(() -> SqlFactory.getNative(mockConnection).create().synonym(any())).thenReturn(mockCreateSynonymBuilder);
      sqlFactory.when(() -> SqlFactory.getNative(mockConnection).create().synonym(any()).forSource(any()))
          .thenReturn(mockCreateSynonymBuilder);
      sqlFactory.when(() -> SqlFactory.getNative(mockConnection).create().synonym(any()).forSource(any()).build()).thenReturn(mockSQL);
      configuration.when(() -> Configuration.get(DatabaseMetadataUtil.DIRIGIBLE_DATABASE_NAMES_CASE_SENSITIVE, "false")).thenReturn("true");

      Mockito.doNothing().when(processorSpy).applyArtefactState(any(), any(), any(), any(), any());

      processorSpy.execute(mockConnection, model);
      verify(processorSpy, times(3)).executeSql(mockSQL, mockConnection);
      verify(processorSpy, times(3)).applyArtefactState(any(), any(), any(), eq(ArtefactState.SUCCESSFUL_CREATE), any());
    }
  }

  @Test(expected = IllegalStateException.class)
  public void executeCreateSynonymPostgresSQLFailed() throws Exception {
    SynonymCreateProcessor processorSpy = spy(SynonymCreateProcessor.class);
    String hdbsynonymSample = IOUtils.toString(SynonymProcessorTest.class.getResourceAsStream("/MySynonym.hdbsynonym"),
        StandardCharsets.UTF_8);

    DataStructureHDBSynonymModel model = DataStructureModelFactory.parseSynonym("hdb_view/MySynonym.hdbsynonym", hdbsynonymSample);
    model.setName("\"MYSCHEMA\".\"hdb_view::MySynonym\"");

    try (MockedStatic<SqlFactory> sqlFactory = Mockito.mockStatic(SqlFactory.class);
        MockedStatic<ProblemsFacade> problemsFacade = Mockito.mockStatic(ProblemsFacade.class)) {
      sqlFactory.when(() -> SqlFactory.getNative(mockConnection)).thenReturn(mockSqlFactory);
      sqlFactory.when(() -> SqlFactory.deriveDialect(mockConnection)).thenReturn(new PostgresSqlDialect());
      problemsFacade.when(() -> ProblemsFacade.save(any(), any(), any(), any(), any(), any(), any(), any(), any(), any()))
          .thenAnswer((Answer<Void>) invocation -> null);

      Mockito.doNothing().when(processorSpy).applyArtefactState(any(), any(), any(), any(), any());

      processorSpy.execute(mockConnection, model);
    }
  }

  @Test
  public void executeDropSynonymSuccessfully() throws Exception {
    SynonymDropProcessor processorSpy = spy(SynonymDropProcessor.class);
    String hdsynonymSample = IOUtils.toString(SynonymProcessorTest.class.getResourceAsStream("/MySynonym.hdbsynonym"),
        StandardCharsets.UTF_8);

    DataStructureHDBSynonymModel model = DataStructureModelFactory.parseSynonym("hdb_view/MySynonym.hdbsynonym", hdsynonymSample);
    model.setName("\"MYSCHEMA\".\"hdb_view::MySynonym\"");
    String mockSQL = "testSQLScript";

    try (MockedStatic<SqlFactory> sqlFactory = Mockito.mockStatic(SqlFactory.class);
        MockedStatic<Configuration> configuration = Mockito.mockStatic(Configuration.class)) {
      sqlFactory.when(() -> SqlFactory.getNative(mockConnection)).thenReturn(mockSqlFactory);
      sqlFactory.when(() -> SqlFactory.deriveDialect(mockConnection)).thenReturn(new HanaSqlDialect());
      sqlFactory.when(() -> SqlFactory.getNative(mockConnection).exists(mockConnection, "LL", "SY_DUMMY", DatabaseArtifactTypes.SYNONYM))
          .thenReturn(true);
      sqlFactory.when(
              () -> SqlFactory.getNative(mockConnection).exists(mockConnection, null, "PAL_TRIPLE_EXPSMOOTH", DatabaseArtifactTypes.SYNONYM))
          .thenReturn(true);
      sqlFactory.when(() -> SqlFactory.getNative(mockConnection).exists(mockConnection, null, "PROCEDURES", DatabaseArtifactTypes.SYNONYM))
          .thenReturn(true);
      sqlFactory.when(() -> SqlFactory.getNative(mockConnection).drop()).thenReturn(drop);
      sqlFactory.when(() -> SqlFactory.getNative(mockConnection).drop().synonym(any())).thenReturn(mockDropSynonymBuilder);
      sqlFactory.when(() -> SqlFactory.getNative(mockConnection).drop().synonym(any()).build()).thenReturn(mockSQL);
      configuration.when(() -> Configuration.get(DatabaseMetadataUtil.DIRIGIBLE_DATABASE_NAMES_CASE_SENSITIVE, "false")).thenReturn("true");

      Mockito.doNothing().when(processorSpy).applyArtefactState(any(), any(), any(), any(), any());

      processorSpy.execute(mockConnection, model);
      verify(processorSpy, times(3)).executeSql(mockSQL, mockConnection);
      verify(processorSpy, times(3)).applyArtefactState(any(), any(), any(), eq(ArtefactState.SUCCESSFUL_DELETE), any());
    }
  }

}

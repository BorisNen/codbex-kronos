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
package com.codbex.kronos.xsodata.ds.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.eclipse.dirigible.api.v3.problems.ProblemsFacade;
import org.eclipse.dirigible.core.test.AbstractDirigibleTest;
import org.eclipse.dirigible.database.persistence.model.PersistenceTableModel;
import org.eclipse.dirigible.database.sql.ISqlKeywords;
import org.eclipse.dirigible.engine.odata2.transformers.DBMetadataUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.codbex.kronos.exceptions.ArtifactParserException;
import com.codbex.kronos.parser.xsodata.model.HDBXSODataAggregationType;
import com.codbex.kronos.xsodata.ds.model.DBArtifactModel;
import com.codbex.kronos.xsodata.ds.model.ODataModel;

@RunWith(MockitoJUnitRunner.class)
public class ODataParserTest extends AbstractDirigibleTest {

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private Connection mockConnection;

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private DBMetadataUtil dbMetadataUtil;

	@Mock
	private PersistenceTableModel mockSynonymTargetObjectMetadata;

	@Mock
	private ResultSet mockResultSet;

	@Mock
	private ResultSet mockResultSetWhenSynonym;

	@Mock
	private ResultSet mockResultSetEntityExist;

	@Mock
	private DataSource mockDataSource;

	@Mock
	private DBArtifactModel artifactReturnType;

	@Mock
	private PreparedStatement mockPreparedStatement;

	@Spy
	@InjectMocks
	private final ODataParser parser = new ODataParser();

	@Before
	public void openMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void parseXsodataFileSuccessfully() throws Exception {
		mockGetTablesSuccessfully();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_all_set_of_navigations.xsodata"), StandardCharsets.UTF_8);
		ODataModel oDataModel = parser.parseODataArtifact("np/entity_with_all_set_of_navigations.xsodata", content);
		assertEquals("entity_with_all_set_of_navigations.xsodata", oDataModel.getName());
		assertEquals("np/entity_with_all_set_of_navigations.xsodata", oDataModel.getLocation());
		assertNotNull(oDataModel.getHash());
		assertEquals("guest", oDataModel.getCreatedBy());
		assertNotNull(oDataModel.getCreatedAt());
		assertNotNull(oDataModel.getService());

		// no need to check the service content the parser module unit tests cover it
	}

	@Test(expected = ArtifactParserException.class)
	public void testValidateEdmMultiplicity() throws Exception {
		mockGetTablesSuccessfully();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_wrong_syntax.xsodata"), StandardCharsets.UTF_8);
		parser.parseODataArtifact("np/entity_wrong_syntax.xsodata", content);
	}

	@Test
	public void testApplyEmptyNamespaceCondition() throws Exception {
		mockGetTablesSuccessfully();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_no_namespace.xsodata"), StandardCharsets.UTF_8);
		ODataModel oDataModel = parser.parseODataArtifact("/a_1/b-2/c/entity_with_no_namespace.xsodata", content);
		assertEquals("a_1.b-2.c.entity_with_no_namespace", oDataModel.getService().getNamespace());
	}

	@Test
	public void testApplyKeysConditionSuccessfully() throws Exception {
		mockGetTablesSuccessfully();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_keys.xsodata"), StandardCharsets.UTF_8);
		ODataModel model = parser.parseODataArtifact("/a_1/b-2/c/entity_with_no_namespace.xsodata", content);
		assertNotNull("ODataModel should not be null after parsing", model);
	}

	@Test
	public void testApplyKeysConditionSuccessfullyWhenSynonym() throws Exception {
		mockGetTablesSuccessfullyWhenSynonym();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_keys.xsodata"), StandardCharsets.UTF_8);
		ODataModel model = parser.parseODataArtifact("/a_1/b-2/c/entity_with_no_namespace.xsodata", content);
		assertNotNull("ODataModel should not be null after parsing", model);
	}

	@Test(expected = OData2TransformerException.class)
	public void testApplyKeysConditionFail() throws Exception {
		mockGetTablesFail();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_keys.xsodata"), StandardCharsets.UTF_8);
		parser.parseODataArtifact("/a_1/b-2/c/entity_with_no_namespace.xsodata", content);
	}

	@Test(expected = OData2TransformerException.class)
	public void testApplyKeysConditionFailWhenSynonym() throws Exception {
		mockGetTablesFailWhenSynonym();
		mockGetTable();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_keys.xsodata"), StandardCharsets.UTF_8);
		parser.parseODataArtifact("/a_1/b-2/c/entity_with_no_namespace.xsodata", content);
	}

	@Test
	public void testApplyEntitySetCondition() throws Exception {
		mockGetTablesSuccessfully();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_no_namespace.xsodata"), StandardCharsets.UTF_8);
		ODataModel oDataModel = parser.parseODataArtifact("/entity_with_no_namespace.xsodata", content);
		assertEquals(oDataModel.getService().getEntities().get(0).getAlias(), "MyView");
		assertEquals(oDataModel.getService().getEntities().get(1).getAlias(), "view");
		assertEquals(oDataModel.getService().getEntities().get(2).getAlias(), "view");
		assertEquals(oDataModel.getService().getEntities().get(3).getAlias(), "view");
	}

	@Test
	public void testApplyNavEntryFromEndConditionSuccessfully() throws Exception {
		mockGetTablesSuccessfully();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_navigation.xsodata"), StandardCharsets.UTF_8);
		ODataModel oDataModel = parser.parseODataArtifact("/entity_with_navigation.xsodata", content);
		assertEquals(2, oDataModel.getService().getEntities().size());
		assertEquals(1, oDataModel.getService().getAssociations().size());
	}

	@Test(expected = OData2TransformerException.class)
	public void testApplyNavEntryFromEndConditionFail() throws Exception {
		mockGetTablesSuccessfully();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_navigation_error.xsodata"), StandardCharsets.UTF_8);
		parser.parseODataArtifact("/entity_with_navigation_error.xsodata", content);
	}

	@Test(expected = OData2TransformerException.class)
	public void testApplyNumberOfJoinPropertiesConditionFail() throws Exception {
		mockGetTablesSuccessfully();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_wrong_join_prop.xsodata"), StandardCharsets.UTF_8);
		parser.parseODataArtifact("/entity_with_wrong_join_prop.xsodata", content);
	}

	@Test(expected = OData2TransformerException.class)
	public void testApplyOrderOfJoinPropertiesCondition() throws Exception {
		mockGetTablesSuccessfully();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_wrong_over_join_prop.xsodata"), StandardCharsets.UTF_8);
		parser.parseODataArtifact("/entity_with_wrong_over_join_prop.xsodata", content);
	}

	@Test
	public void testImplicitAggregation() throws Exception {
		mockGetTablesSuccessfully();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_implicit_aggregation.xsodata"), StandardCharsets.UTF_8);
		ODataModel oDataModel = parser.parseODataArtifact("/entity_with_implicit_aggregation.xsodata", content);
    assertEquals(0, oDataModel.getService().getEntities().get(0).getAggregations().size());
    assertEquals(HDBXSODataAggregationType.IMPLICIT, oDataModel.getService().getEntities().get(0).getAggregationType());
	}

	@Test
	public void testExplicitAggregation() throws Exception {
		mockGetTablesSuccessfully();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_explicit_aggregation.xsodata"), StandardCharsets.UTF_8);
    ODataModel oDataModel = parser.parseODataArtifact("/entity_with_explicit_aggregation.xsodata", content);
    assertEquals(3, oDataModel.getService().getEntities().get(0).getAggregations().size());
    assertEquals(HDBXSODataAggregationType.EXPLICIT, oDataModel.getService().getEntities().get(0).getAggregationType());
	}

	@Test(expected = OData2TransformerException.class)
	public void testApplyParametersToViewsCondition() throws Exception {
		mockGetTablesFail();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_params.xsodata"), StandardCharsets.UTF_8);
		parser.parseODataArtifact("/entity_with_params.xsodata", content);
	}

	@Test(expected = OData2TransformerException.class)
	public void testApplyParametersToViewsConditionWhenSynonym() throws Exception {
		mockGetTablesFailWhenSynonym();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_params.xsodata"), StandardCharsets.UTF_8);
		parser.parseODataArtifact("/entity_with_params.xsodata", content);
	}

	@Test
	public void testApplyOmittedParamResultCondition() throws Exception {
		mockGetTablesSuccessfully();
		String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_params.xsodata"), StandardCharsets.UTF_8);
		ODataModel oDataModel = parser.parseODataArtifact("/entity_with_params.xsodata", content);
		assertEquals("CalcViewParameters", oDataModel.getService().getEntities().get(0).getParameterEntitySet().getParameterEntitySetName());
		assertEquals("Results", oDataModel.getService().getEntities().get(0).getParameterEntitySet().getParameterResultsProperty());
	}

	private void mockGetTablesSuccessfully() throws Exception {
		mockGetTable();
		mockGetDBArtifactsByName();
		mockProblemsFacade();
		when(mockResultSet.next()).thenReturn(true);
	}

	private void mockGetTablesSuccessfullyWhenSynonym() throws Exception {
		mockGetTable();
		mockGetDBArtifactsByName();
		mockProblemsFacade();
	}

	private void mockGetTablesFail() throws Exception {
		mockGetTable();
		mockProblemsFacade();
		mockDBArtifactsByNameMissing();
	}

	private void mockGetTablesFailWhenSynonym() throws Exception {
		mockGetTable();
		mockProblemsFacade();
		mockDBArtifactsByNameMissing();
	}

	private void mockGetTable() throws Exception {
		when(mockDataSource.getConnection()).thenReturn(mockConnection);
		when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
		when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
	}

	private void mockDBArtifactsByNameMissing() throws SQLException {
		DBArtifactModel dbArtifactModelPlaceholder = new DBArtifactModel("PLACEHOLDER", "PLACEHOLDER", "PLACEHOLDER");
		doReturn(List.of(dbArtifactModelPlaceholder)).when(parser).getDBArtifactsByName(anyString());
	}

	private void mockGetDBArtifactsByName() throws SQLException {
		DBArtifactModel dbArtifactModelView = new DBArtifactModel(ISqlKeywords.METADATA_VIEW, ISqlKeywords.METADATA_VIEW, ISqlKeywords.METADATA_VIEW);
		DBArtifactModel dbArtifactModelCalcView = new DBArtifactModel(ISqlKeywords.METADATA_CALC_VIEW, ISqlKeywords.METADATA_CALC_VIEW, ISqlKeywords.METADATA_CALC_VIEW);
		DBArtifactModel dbArtifactModelSynonym = new DBArtifactModel(ISqlKeywords.METADATA_SYNONYM, ISqlKeywords.METADATA_SYNONYM, ISqlKeywords.METADATA_SYNONYM);
		doReturn(List.of(dbArtifactModelView, dbArtifactModelCalcView, dbArtifactModelSynonym)).when(parser).getDBArtifactsByName(anyString());
	}

	private void mockProblemsFacade() throws Exception {
		try (MockedStatic<ProblemsFacade> problemsFacade = Mockito.mockStatic(ProblemsFacade.class)) {
			problemsFacade.when(() -> ProblemsFacade.save(any(), any(), any(), any(), any(), any(), any(), any(), any(), any())).thenAnswer((Answer<Void>) invocation -> null);
		}
	}
}

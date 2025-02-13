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
// Generated from java-escape by ANTLR 4.11.1
package com.codbex.kronos.parser.hdbschema.core;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class HDBSchemaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, STRING=2, EQ=3, SEMICOLON=4, COMMA=5, WS=6, ESC=7, LINE_COMMENT=8, 
		COMMENT=9;
	public static final int
		RULE_hdbSchemaDefinition = 0, RULE_schemaNameProp = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"hdbSchemaDefinition", "schemaNameProp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'schema_name'", null, "'='", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "STRING", "EQ", "SEMICOLON", "COMMA", "WS", "ESC", "LINE_COMMENT", 
			"COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HDBSchemaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HdbSchemaDefinitionContext extends ParserRuleContext {
		public SchemaNamePropContext schemaNameProp() {
			return getRuleContext(SchemaNamePropContext.class,0);
		}
		public HdbSchemaDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hdbSchemaDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBSchemaListener ) ((HDBSchemaListener)listener).enterHdbSchemaDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBSchemaListener ) ((HDBSchemaListener)listener).exitHdbSchemaDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HDBSchemaVisitor ) return ((HDBSchemaVisitor<? extends T>)visitor).visitHdbSchemaDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HdbSchemaDefinitionContext hdbSchemaDefinition() throws RecognitionException {
		HdbSchemaDefinitionContext _localctx = new HdbSchemaDefinitionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_hdbSchemaDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			schemaNameProp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SchemaNamePropContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(HDBSchemaParser.EQ, 0); }
		public TerminalNode STRING() { return getToken(HDBSchemaParser.STRING, 0); }
		public TerminalNode SEMICOLON() { return getToken(HDBSchemaParser.SEMICOLON, 0); }
		public SchemaNamePropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schemaNameProp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HDBSchemaListener ) ((HDBSchemaListener)listener).enterSchemaNameProp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HDBSchemaListener ) ((HDBSchemaListener)listener).exitSchemaNameProp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HDBSchemaVisitor ) return ((HDBSchemaVisitor<? extends T>)visitor).visitSchemaNameProp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SchemaNamePropContext schemaNameProp() throws RecognitionException {
		SchemaNamePropContext _localctx = new SchemaNamePropContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_schemaNameProp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			match(T__0);
			setState(7);
			match(EQ);
			setState(8);
			match(STRING);
			setState(9);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\t\f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0000\u0000\u0002\u0000\u0002\u0000\u0000\t\u0000\u0004"+
		"\u0001\u0000\u0000\u0000\u0002\u0006\u0001\u0000\u0000\u0000\u0004\u0005"+
		"\u0003\u0002\u0001\u0000\u0005\u0001\u0001\u0000\u0000\u0000\u0006\u0007"+
		"\u0005\u0001\u0000\u0000\u0007\b\u0005\u0003\u0000\u0000\b\t\u0005\u0002"+
		"\u0000\u0000\t\n\u0005\u0004\u0000\u0000\n\u0003\u0001\u0000\u0000\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
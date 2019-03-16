// Generated from Feather.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FeatherParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		ATTRIBUTE_NAME=53, FEATURE_VAR=54, INTEGER_LITERAL=55, REAL_LITERAL=56, 
		STRING_LITERAL=57, WS=58;
	public static final int
		RULE_s = 0, RULE_declarations = 1, RULE_featureDeclarations = 2, RULE_rootFeature = 3, 
		RULE_featureDec = 4, RULE_decompRelDeclaration = 5, RULE_attributeDeclarations = 6, 
		RULE_attributeDec = 7, RULE_assignedValue = 8, RULE_crossTreeConstraintDeclarations = 9, 
		RULE_crossTreeConstraintDec = 10, RULE_commands = 11, RULE_aCommand = 12, 
		RULE_addFeature = 13, RULE_updateFeature = 14, RULE_updateMultipleFeatures = 15, 
		RULE_removeFeature = 16, RULE_removeMultipleFeatures = 17, RULE_addConstraint = 18, 
		RULE_updateConstraint = 19, RULE_updateMultipleConstraints = 20, RULE_removeConstraint = 21, 
		RULE_removeMultipleConstraints = 22, RULE_featureDescription = 23, RULE_featureNameDescription = 24, 
		RULE_constraintDescription = 25, RULE_whereClause = 26, RULE_attributeList = 27, 
		RULE_structuralAttributeAssignments = 28, RULE_settingLocation = 29, RULE_settingDecomposition = 30, 
		RULE_attributeAssignments = 31, RULE_attrAssign = 32, RULE_attributeValue = 33, 
		RULE_featureUpdates = 34, RULE_featUpdate = 35, RULE_settingName = 36, 
		RULE_limitedFeatureUpdates = 37, RULE_limitedFeatUpdate = 38, RULE_constraintUpdates = 39, 
		RULE_constUpdate = 40, RULE_limitedConstraintUpdates = 41, RULE_decompRelValue = 42, 
		RULE_basicCrossTreeConstraint = 43, RULE_arithmeticExpression = 44, RULE_arithmeticOperand = 45, 
		RULE_highArithOp = 46, RULE_lowArithOp = 47, RULE_booleanExpression = 48, 
		RULE_booleanOperand = 49, RULE_relOp = 50, RULE_stringEqualityCheck = 51, 
		RULE_stringOperand = 52, RULE_eqCheckOp = 53, RULE_decompRelTypeCheck = 54, 
		RULE_decompRelIDCheck = 55, RULE_booleanEqualityCheck = 56, RULE_boolEqOperand = 57, 
		RULE_featureName = 58, RULE_parentName = 59, RULE_attributeName = 60, 
		RULE_featureVar = 61, RULE_bool_literal = 62;
	public static final String[] ruleNames = {
		"s", "declarations", "featureDeclarations", "rootFeature", "featureDec", 
		"decompRelDeclaration", "attributeDeclarations", "attributeDec", "assignedValue", 
		"crossTreeConstraintDeclarations", "crossTreeConstraintDec", "commands", 
		"aCommand", "addFeature", "updateFeature", "updateMultipleFeatures", "removeFeature", 
		"removeMultipleFeatures", "addConstraint", "updateConstraint", "updateMultipleConstraints", 
		"removeConstraint", "removeMultipleConstraints", "featureDescription", 
		"featureNameDescription", "constraintDescription", "whereClause", "attributeList", 
		"structuralAttributeAssignments", "settingLocation", "settingDecomposition", 
		"attributeAssignments", "attrAssign", "attributeValue", "featureUpdates", 
		"featUpdate", "settingName", "limitedFeatureUpdates", "limitedFeatUpdate", 
		"constraintUpdates", "constUpdate", "limitedConstraintUpdates", "decompRelValue", 
		"basicCrossTreeConstraint", "arithmeticExpression", "arithmeticOperand", 
		"highArithOp", "lowArithOp", "booleanExpression", "booleanOperand", "relOp", 
		"stringEqualityCheck", "stringOperand", "eqCheckOp", "decompRelTypeCheck", 
		"decompRelIDCheck", "booleanEqualityCheck", "boolEqOperand", "featureName", 
		"parentName", "attributeName", "featureVar", "bool_literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'root'", "';'", "'feature'", "'mandatory'", "'optional'", "'alternative'", 
		"'to'", "'or'", "'attribute'", "'constraint'", "'add'", "'with'", "'attributes'", 
		"'update'", "'set'", "'updateall'", "'remove'", "'removeall'", "'.'", 
		"'_name'", "'where'", "'('", "')'", "','", "'_parent'", "'='", "'_decomp'", 
		"'inherited'", "':'", "'numeric'", "'boolean'", "'string'", "'leftfeature'", 
		"'constrainttype'", "'rightfeature'", "'requires'", "'excludes'", "'-'", 
		"'*'", "'/'", "'%'", "'+'", "'not'", "'and'", "'<'", "'<='", "'>'", "'>='", 
		"'<>'", "'_decompID'", "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "ATTRIBUTE_NAME", "FEATURE_VAR", "INTEGER_LITERAL", 
		"REAL_LITERAL", "STRING_LITERAL", "WS"
	};
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
	public String getGrammarFileName() { return "Feather.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FeatherParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SContext extends ParserRuleContext {
		public String ilcode;
		public DeclarationsContext declarations;
		public CommandsContext commands;
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public CommandsContext commands() {
			return getRuleContext(CommandsContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitS(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			((SContext)_localctx).declarations = declarations();
			setState(127);
			((SContext)_localctx).commands = commands();
			 ((SContext)_localctx).ilcode =  ((SContext)_localctx).declarations.ilcode + ((SContext)_localctx).commands.ilcode; 
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

	public static class DeclarationsContext extends ParserRuleContext {
		public String ilcode;
		public FeatureDeclarationsContext featureDeclarations;
		public CrossTreeConstraintDeclarationsContext crossTreeConstraintDeclarations;
		public FeatureDeclarationsContext featureDeclarations() {
			return getRuleContext(FeatureDeclarationsContext.class,0);
		}
		public CrossTreeConstraintDeclarationsContext crossTreeConstraintDeclarations() {
			return getRuleContext(CrossTreeConstraintDeclarationsContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitDeclarations(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			((DeclarationsContext)_localctx).featureDeclarations = featureDeclarations();
			setState(131);
			((DeclarationsContext)_localctx).crossTreeConstraintDeclarations = crossTreeConstraintDeclarations(((DeclarationsContext)_localctx).featureDeclarations.setOfFeatures);
			 ((DeclarationsContext)_localctx).ilcode =  ((DeclarationsContext)_localctx).featureDeclarations.ilcode + "\r\n" + ((DeclarationsContext)_localctx).crossTreeConstraintDeclarations.ilcode; 
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

	public static class FeatureDeclarationsContext extends ParserRuleContext {
		public String ilcode;
		public ArrayList setOfFeatures;
		public RootFeatureContext rootFeature;
		public FeatureDecContext featureDec;
		public List<FeatureDecContext> featdecs = new ArrayList<FeatureDecContext>();
		public RootFeatureContext rootFeature() {
			return getRuleContext(RootFeatureContext.class,0);
		}
		public List<FeatureDecContext> featureDec() {
			return getRuleContexts(FeatureDecContext.class);
		}
		public FeatureDecContext featureDec(int i) {
			return getRuleContext(FeatureDecContext.class,i);
		}
		public FeatureDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterFeatureDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitFeatureDeclarations(this);
		}
	}

	public final FeatureDeclarationsContext featureDeclarations() throws RecognitionException {
		FeatureDeclarationsContext _localctx = new FeatureDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_featureDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			((FeatureDeclarationsContext)_localctx).rootFeature = rootFeature();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(135);
				((FeatureDeclarationsContext)_localctx).featureDec = ((FeatureDeclarationsContext)_localctx).featureDec = featureDec(((FeatureDeclarationsContext)_localctx).rootFeature.setOfUsedNames);
				((FeatureDeclarationsContext)_localctx).featdecs.add(((FeatureDeclarationsContext)_localctx).featureDec);
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

						((FeatureDeclarationsContext)_localctx).ilcode =  ((FeatureDeclarationsContext)_localctx).rootFeature.ilcode;
						for ( FeatureDecContext fd : ((FeatureDeclarationsContext)_localctx).featdecs )
						   _localctx.ilcode += "\r\n" + fd.ilcode;

						try
						{
						  ((FeatureDeclarationsContext)_localctx).setOfFeatures =  ((FeatureDeclarationsContext)_localctx).featureDec.setOfUsedNames;
						}
						catch (Exception e)
						{
						  ((FeatureDeclarationsContext)_localctx).setOfFeatures =  ((FeatureDeclarationsContext)_localctx).rootFeature.setOfUsedNames;
						}
			          
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

	public static class RootFeatureContext extends ParserRuleContext {
		public String ilcode;
		public ArrayList setOfUsedNames;
		public FeatureNameContext featureName;
		public AttributeDeclarationsContext attributeDeclarations;
		public FeatureNameContext featureName() {
			return getRuleContext(FeatureNameContext.class,0);
		}
		public AttributeDeclarationsContext attributeDeclarations() {
			return getRuleContext(AttributeDeclarationsContext.class,0);
		}
		public RootFeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rootFeature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterRootFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitRootFeature(this);
		}
	}

	public final RootFeatureContext rootFeature() throws RecognitionException {
		RootFeatureContext _localctx = new RootFeatureContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rootFeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__0);
			setState(144);
			((RootFeatureContext)_localctx).featureName = featureName();
			setState(145);
			((RootFeatureContext)_localctx).attributeDeclarations = attributeDeclarations(new ArrayList());
			setState(146);
			match(T__1);

			            ((RootFeatureContext)_localctx).ilcode =  "1" + " " + (((RootFeatureContext)_localctx).featureName!=null?_input.getText(((RootFeatureContext)_localctx).featureName.start,((RootFeatureContext)_localctx).featureName.stop):null) + ((RootFeatureContext)_localctx).attributeDeclarations.ilcode + "\r\n" + "-1";

			            ((RootFeatureContext)_localctx).setOfUsedNames =  new ArrayList();
			            _localctx.setOfUsedNames.add((((RootFeatureContext)_localctx).featureName!=null?_input.getText(((RootFeatureContext)_localctx).featureName.start,((RootFeatureContext)_localctx).featureName.stop):null));
			          
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

	public static class FeatureDecContext extends ParserRuleContext {
		public ArrayList i_setOfUsedNames;
		public String ilcode;
		public ArrayList setOfUsedNames;
		public int i;
		public String existingName;
		public FeatureNameContext featureName;
		public ParentNameContext parentName;
		public DecompRelDeclarationContext decompRelDeclaration;
		public AttributeDeclarationsContext attributeDeclarations;
		public FeatureNameContext featureName() {
			return getRuleContext(FeatureNameContext.class,0);
		}
		public ParentNameContext parentName() {
			return getRuleContext(ParentNameContext.class,0);
		}
		public DecompRelDeclarationContext decompRelDeclaration() {
			return getRuleContext(DecompRelDeclarationContext.class,0);
		}
		public AttributeDeclarationsContext attributeDeclarations() {
			return getRuleContext(AttributeDeclarationsContext.class,0);
		}
		public FeatureDecContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FeatureDecContext(ParserRuleContext parent, int invokingState, ArrayList i_setOfUsedNames) {
			super(parent, invokingState);
			this.i_setOfUsedNames = i_setOfUsedNames;
		}
		@Override public int getRuleIndex() { return RULE_featureDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterFeatureDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitFeatureDec(this);
		}
	}

	public final FeatureDecContext featureDec(ArrayList i_setOfUsedNames) throws RecognitionException {
		FeatureDecContext _localctx = new FeatureDecContext(_ctx, getState(), i_setOfUsedNames);
		enterRule(_localctx, 8, RULE_featureDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__2);
			setState(150);
			((FeatureDecContext)_localctx).featureName = featureName();
			setState(151);
			((FeatureDecContext)_localctx).parentName = parentName();
			setState(152);
			((FeatureDecContext)_localctx).decompRelDeclaration = decompRelDeclaration();
			setState(153);
			((FeatureDecContext)_localctx).attributeDeclarations = attributeDeclarations(new ArrayList());
			setState(154);
			match(T__1);

			            for (((FeatureDecContext)_localctx).i = 0; _localctx.i < _localctx.i_setOfUsedNames.size(); _localctx.i++)
			            {
			              ((FeatureDecContext)_localctx).existingName =  (String) _localctx.i_setOfUsedNames.get(_localctx.i);
			              if ( (((FeatureDecContext)_localctx).featureName!=null?_input.getText(((FeatureDecContext)_localctx).featureName.start,((FeatureDecContext)_localctx).featureName.stop):null).equals(_localctx.existingName) )
			              {
			                 // This means that another feature with the same name already exists, take necessary actions
			                 notifyErrorListeners(((FeatureDecContext)_localctx).featureName.lineNo + ": a feature with the name " + (((FeatureDecContext)_localctx).featureName!=null?_input.getText(((FeatureDecContext)_localctx).featureName.start,((FeatureDecContext)_localctx).featureName.stop):null) + " has already been declared");
			              }
			            }

			            ((FeatureDecContext)_localctx).ilcode =  "2" + " " + (((FeatureDecContext)_localctx).featureName!=null?_input.getText(((FeatureDecContext)_localctx).featureName.start,((FeatureDecContext)_localctx).featureName.stop):null) + " " + (((FeatureDecContext)_localctx).parentName!=null?_input.getText(((FeatureDecContext)_localctx).parentName.start,((FeatureDecContext)_localctx).parentName.stop):null) + " " + ((FeatureDecContext)_localctx).decompRelDeclaration.ilcode + ((FeatureDecContext)_localctx).attributeDeclarations.ilcode + "\r\n" + "-2";

			            ((FeatureDecContext)_localctx).setOfUsedNames =  _localctx.i_setOfUsedNames;
			            _localctx.setOfUsedNames.add((((FeatureDecContext)_localctx).featureName!=null?_input.getText(((FeatureDecContext)_localctx).featureName.start,((FeatureDecContext)_localctx).featureName.stop):null));
			          
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

	public static class DecompRelDeclarationContext extends ParserRuleContext {
		public String ilcode;
		public FeatureNameContext featureName;
		public FeatureNameContext featureName() {
			return getRuleContext(FeatureNameContext.class,0);
		}
		public DecompRelDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decompRelDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterDecompRelDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitDecompRelDeclaration(this);
		}
	}

	public final DecompRelDeclarationContext decompRelDeclaration() throws RecognitionException {
		DecompRelDeclarationContext _localctx = new DecompRelDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decompRelDeclaration);
		try {
			setState(171);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(T__3);
				 ((DecompRelDeclarationContext)_localctx).ilcode =  "1"; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(T__4);
				 ((DecompRelDeclarationContext)_localctx).ilcode =  "2"; 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				match(T__5);
				setState(162);
				match(T__6);
				setState(163);
				((DecompRelDeclarationContext)_localctx).featureName = featureName();
				 ((DecompRelDeclarationContext)_localctx).ilcode =  "3" + " " + (((DecompRelDeclarationContext)_localctx).featureName!=null?_input.getText(((DecompRelDeclarationContext)_localctx).featureName.start,((DecompRelDeclarationContext)_localctx).featureName.stop):null); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(166);
				match(T__7);
				setState(167);
				match(T__6);
				setState(168);
				((DecompRelDeclarationContext)_localctx).featureName = featureName();
				 ((DecompRelDeclarationContext)_localctx).ilcode =  "4" + " " + (((DecompRelDeclarationContext)_localctx).featureName!=null?_input.getText(((DecompRelDeclarationContext)_localctx).featureName.start,((DecompRelDeclarationContext)_localctx).featureName.stop):null); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AttributeDeclarationsContext extends ParserRuleContext {
		public ArrayList i_setOfAttributes;
		public String ilcode;
		public AttributeDecContext attributeDec;
		public List<AttributeDecContext> attrs = new ArrayList<AttributeDecContext>();
		public List<AttributeDecContext> attributeDec() {
			return getRuleContexts(AttributeDecContext.class);
		}
		public AttributeDecContext attributeDec(int i) {
			return getRuleContext(AttributeDecContext.class,i);
		}
		public AttributeDeclarationsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AttributeDeclarationsContext(ParserRuleContext parent, int invokingState, ArrayList i_setOfAttributes) {
			super(parent, invokingState);
			this.i_setOfAttributes = i_setOfAttributes;
		}
		@Override public int getRuleIndex() { return RULE_attributeDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterAttributeDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitAttributeDeclarations(this);
		}
	}

	public final AttributeDeclarationsContext attributeDeclarations(ArrayList i_setOfAttributes) throws RecognitionException {
		AttributeDeclarationsContext _localctx = new AttributeDeclarationsContext(_ctx, getState(), i_setOfAttributes);
		enterRule(_localctx, 12, RULE_attributeDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(173);
				((AttributeDeclarationsContext)_localctx).attributeDec = attributeDec(_localctx.i_setOfAttributes);
				((AttributeDeclarationsContext)_localctx).attrs.add(((AttributeDeclarationsContext)_localctx).attributeDec);
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

					    ((AttributeDeclarationsContext)_localctx).ilcode =  "";
						for ( AttributeDecContext a : ((AttributeDeclarationsContext)_localctx).attrs )
						   _localctx.ilcode += "\r\n  " + a.ilcode;
					  
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

	public static class AttributeDecContext extends ParserRuleContext {
		public ArrayList i_setOfAttributes;
		public String ilcode;
		public ArrayList setOfAttributes;
		public int i;
		public String existingName;
		public AttributeNameContext attributeName;
		public AssignedValueContext assignedValue;
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public AssignedValueContext assignedValue() {
			return getRuleContext(AssignedValueContext.class,0);
		}
		public AttributeDecContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AttributeDecContext(ParserRuleContext parent, int invokingState, ArrayList i_setOfAttributes) {
			super(parent, invokingState);
			this.i_setOfAttributes = i_setOfAttributes;
		}
		@Override public int getRuleIndex() { return RULE_attributeDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterAttributeDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitAttributeDec(this);
		}
	}

	public final AttributeDecContext attributeDec(ArrayList i_setOfAttributes) throws RecognitionException {
		AttributeDecContext _localctx = new AttributeDecContext(_ctx, getState(), i_setOfAttributes);
		enterRule(_localctx, 14, RULE_attributeDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(T__8);
			setState(182);
			((AttributeDecContext)_localctx).attributeName = attributeName();
			setState(183);
			((AttributeDecContext)_localctx).assignedValue = assignedValue();

			            for (((AttributeDecContext)_localctx).i = 0; _localctx.i < _localctx.i_setOfAttributes.size(); _localctx.i++)
			            {
			              ((AttributeDecContext)_localctx).existingName =  (String) _localctx.i_setOfAttributes.get(_localctx.i);
			              if ( (((AttributeDecContext)_localctx).attributeName!=null?_input.getText(((AttributeDecContext)_localctx).attributeName.start,((AttributeDecContext)_localctx).attributeName.stop):null).equals(_localctx.existingName) )
			              {
			                 // This means that another attribute with the same name already exists, take necessary actions
			                 notifyErrorListeners(((AttributeDecContext)_localctx).attributeName.lineNo + ": an attribute with the name '" + (((AttributeDecContext)_localctx).attributeName!=null?_input.getText(((AttributeDecContext)_localctx).attributeName.start,((AttributeDecContext)_localctx).attributeName.stop):null) + "' has already been declared");
			              }
			            }

			            ((AttributeDecContext)_localctx).ilcode =  "5" + " " + (((AttributeDecContext)_localctx).attributeName!=null?_input.getText(((AttributeDecContext)_localctx).attributeName.start,((AttributeDecContext)_localctx).attributeName.stop):null) + " " + ((AttributeDecContext)_localctx).assignedValue.ilcode;

			            ((AttributeDecContext)_localctx).setOfAttributes =  _localctx.i_setOfAttributes;
			            _localctx.setOfAttributes.add((((AttributeDecContext)_localctx).attributeName!=null?_input.getText(((AttributeDecContext)_localctx).attributeName.start,((AttributeDecContext)_localctx).attributeName.stop):null));
			          
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

	public static class AssignedValueContext extends ParserRuleContext {
		public String ilcode;
		public Bool_literalContext bool_literal;
		public Token INTEGER_LITERAL;
		public Token REAL_LITERAL;
		public Token STRING_LITERAL;
		public Bool_literalContext bool_literal() {
			return getRuleContext(Bool_literalContext.class,0);
		}
		public TerminalNode INTEGER_LITERAL() { return getToken(FeatherParser.INTEGER_LITERAL, 0); }
		public TerminalNode REAL_LITERAL() { return getToken(FeatherParser.REAL_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FeatherParser.STRING_LITERAL, 0); }
		public AssignedValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignedValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterAssignedValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitAssignedValue(this);
		}
	}

	public final AssignedValueContext assignedValue() throws RecognitionException {
		AssignedValueContext _localctx = new AssignedValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignedValue);
		try {
			setState(195);
			switch (_input.LA(1)) {
			case T__50:
			case T__51:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				((AssignedValueContext)_localctx).bool_literal = bool_literal();
				 ((AssignedValueContext)_localctx).ilcode =  "3" + " " + ((AssignedValueContext)_localctx).bool_literal.ilcode; 
				}
				break;
			case INTEGER_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				((AssignedValueContext)_localctx).INTEGER_LITERAL = match(INTEGER_LITERAL);
				 ((AssignedValueContext)_localctx).ilcode =  "1" + " " + (((AssignedValueContext)_localctx).INTEGER_LITERAL!=null?((AssignedValueContext)_localctx).INTEGER_LITERAL.getText():null); 
				}
				break;
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				((AssignedValueContext)_localctx).REAL_LITERAL = match(REAL_LITERAL);
				 ((AssignedValueContext)_localctx).ilcode =  "2" + " " + (((AssignedValueContext)_localctx).REAL_LITERAL!=null?((AssignedValueContext)_localctx).REAL_LITERAL.getText():null); 
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				((AssignedValueContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
				 ((AssignedValueContext)_localctx).ilcode =  "4" + " " + (((AssignedValueContext)_localctx).STRING_LITERAL!=null?((AssignedValueContext)_localctx).STRING_LITERAL.getText():null); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class CrossTreeConstraintDeclarationsContext extends ParserRuleContext {
		public ArrayList i_setOfFeatures;
		public String ilcode;
		public CrossTreeConstraintDecContext crossTreeConstraintDec;
		public List<CrossTreeConstraintDecContext> constdecs = new ArrayList<CrossTreeConstraintDecContext>();
		public List<CrossTreeConstraintDecContext> crossTreeConstraintDec() {
			return getRuleContexts(CrossTreeConstraintDecContext.class);
		}
		public CrossTreeConstraintDecContext crossTreeConstraintDec(int i) {
			return getRuleContext(CrossTreeConstraintDecContext.class,i);
		}
		public CrossTreeConstraintDeclarationsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public CrossTreeConstraintDeclarationsContext(ParserRuleContext parent, int invokingState, ArrayList i_setOfFeatures) {
			super(parent, invokingState);
			this.i_setOfFeatures = i_setOfFeatures;
		}
		@Override public int getRuleIndex() { return RULE_crossTreeConstraintDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterCrossTreeConstraintDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitCrossTreeConstraintDeclarations(this);
		}
	}

	public final CrossTreeConstraintDeclarationsContext crossTreeConstraintDeclarations(ArrayList i_setOfFeatures) throws RecognitionException {
		CrossTreeConstraintDeclarationsContext _localctx = new CrossTreeConstraintDeclarationsContext(_ctx, getState(), i_setOfFeatures);
		enterRule(_localctx, 18, RULE_crossTreeConstraintDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(197);
				((CrossTreeConstraintDeclarationsContext)_localctx).crossTreeConstraintDec = crossTreeConstraintDec(i_setOfFeatures);
				((CrossTreeConstraintDeclarationsContext)_localctx).constdecs.add(((CrossTreeConstraintDeclarationsContext)_localctx).crossTreeConstraintDec);
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

						((CrossTreeConstraintDeclarationsContext)_localctx).ilcode =  "";
						for ( CrossTreeConstraintDecContext ctc : ((CrossTreeConstraintDeclarationsContext)_localctx).constdecs )
						   _localctx.ilcode += "\r\n" + ctc.ilcode;
						_localctx.ilcode += "\r\n";
					  
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

	public static class CrossTreeConstraintDecContext extends ParserRuleContext {
		public ArrayList i_setOfFeatures;
		public String ilcode;
		public int i;
		public String existingName;
		public boolean foundFirst;
		public boolean foundSecond;
		public FeatureNameContext lbl_left;
		public BasicCrossTreeConstraintContext basicCrossTreeConstraint;
		public FeatureNameContext lbl_right;
		public BasicCrossTreeConstraintContext basicCrossTreeConstraint() {
			return getRuleContext(BasicCrossTreeConstraintContext.class,0);
		}
		public List<FeatureNameContext> featureName() {
			return getRuleContexts(FeatureNameContext.class);
		}
		public FeatureNameContext featureName(int i) {
			return getRuleContext(FeatureNameContext.class,i);
		}
		public CrossTreeConstraintDecContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public CrossTreeConstraintDecContext(ParserRuleContext parent, int invokingState, ArrayList i_setOfFeatures) {
			super(parent, invokingState);
			this.i_setOfFeatures = i_setOfFeatures;
		}
		@Override public int getRuleIndex() { return RULE_crossTreeConstraintDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterCrossTreeConstraintDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitCrossTreeConstraintDec(this);
		}
	}

	public final CrossTreeConstraintDecContext crossTreeConstraintDec(ArrayList i_setOfFeatures) throws RecognitionException {
		CrossTreeConstraintDecContext _localctx = new CrossTreeConstraintDecContext(_ctx, getState(), i_setOfFeatures);
		enterRule(_localctx, 20, RULE_crossTreeConstraintDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__9);
			setState(206);
			((CrossTreeConstraintDecContext)_localctx).lbl_left = featureName();
			setState(207);
			((CrossTreeConstraintDecContext)_localctx).basicCrossTreeConstraint = basicCrossTreeConstraint();
			setState(208);
			((CrossTreeConstraintDecContext)_localctx).lbl_right = featureName();
			setState(209);
			match(T__1);

			            ((CrossTreeConstraintDecContext)_localctx).foundFirst =  _localctx.foundSecond = false;
			            for (((CrossTreeConstraintDecContext)_localctx).i = 0; _localctx.i < _localctx.i_setOfFeatures.size(); _localctx.i++)
			            {
			               ((CrossTreeConstraintDecContext)_localctx).existingName =  (String) i_setOfFeatures.get(_localctx.i);
			               if ( _localctx.existingName.equals((((CrossTreeConstraintDecContext)_localctx).lbl_left!=null?_input.getText(((CrossTreeConstraintDecContext)_localctx).lbl_left.start,((CrossTreeConstraintDecContext)_localctx).lbl_left.stop):null)) )
			                  ((CrossTreeConstraintDecContext)_localctx).foundFirst =  true;
			               if ( _localctx.existingName.equals((((CrossTreeConstraintDecContext)_localctx).lbl_right!=null?_input.getText(((CrossTreeConstraintDecContext)_localctx).lbl_right.start,((CrossTreeConstraintDecContext)_localctx).lbl_right.stop):null)) )
			                  ((CrossTreeConstraintDecContext)_localctx).foundSecond =  true;
			            }

			            if ( ! _localctx.foundFirst )
			            {
			               // This means the first feature has not been declared, take necessary actions
			               notifyErrorListeners(((CrossTreeConstraintDecContext)_localctx).lbl_left.lineNo + ": the feature " + (((CrossTreeConstraintDecContext)_localctx).lbl_left!=null?_input.getText(((CrossTreeConstraintDecContext)_localctx).lbl_left.start,((CrossTreeConstraintDecContext)_localctx).lbl_left.stop):null) + " is not declared");
			            }

			            if ( ! _localctx.foundSecond )
			            {
			               // This means the second feature has not been declared, take necessary actions
			               notifyErrorListeners(((CrossTreeConstraintDecContext)_localctx).lbl_left.lineNo + ": the feature " + (((CrossTreeConstraintDecContext)_localctx).lbl_right!=null?_input.getText(((CrossTreeConstraintDecContext)_localctx).lbl_right.start,((CrossTreeConstraintDecContext)_localctx).lbl_right.stop):null) + " is not declared");
			            }

			            ((CrossTreeConstraintDecContext)_localctx).ilcode =  "3" + " " + (((CrossTreeConstraintDecContext)_localctx).lbl_left!=null?_input.getText(((CrossTreeConstraintDecContext)_localctx).lbl_left.start,((CrossTreeConstraintDecContext)_localctx).lbl_left.stop):null) + " " + ((CrossTreeConstraintDecContext)_localctx).basicCrossTreeConstraint.ilcode + " " + (((CrossTreeConstraintDecContext)_localctx).lbl_right!=null?_input.getText(((CrossTreeConstraintDecContext)_localctx).lbl_right.start,((CrossTreeConstraintDecContext)_localctx).lbl_right.stop):null) + " " + "-3";
			          
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

	public static class CommandsContext extends ParserRuleContext {
		public String ilcode;
		public ACommandContext aCommand;
		public List<ACommandContext> cmnds = new ArrayList<ACommandContext>();
		public List<ACommandContext> aCommand() {
			return getRuleContexts(ACommandContext.class);
		}
		public ACommandContext aCommand(int i) {
			return getRuleContext(ACommandContext.class,i);
		}
		public CommandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commands; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterCommands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitCommands(this);
		}
	}

	public final CommandsContext commands() throws RecognitionException {
		CommandsContext _localctx = new CommandsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_commands);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(212);
				((CommandsContext)_localctx).aCommand = aCommand();
				((CommandsContext)_localctx).cmnds.add(((CommandsContext)_localctx).aCommand);
				}
				}
				setState(215); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__17))) != 0) );

						((CommandsContext)_localctx).ilcode =  "";
						for ( ACommandContext c : ((CommandsContext)_localctx).cmnds )
						   _localctx.ilcode += "\r\n" + c.ilcode + "\r\n";
					  
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

	public static class ACommandContext extends ParserRuleContext {
		public String ilcode;
		public AddFeatureContext addFeature;
		public UpdateFeatureContext updateFeature;
		public UpdateMultipleFeaturesContext updateMultipleFeatures;
		public RemoveFeatureContext removeFeature;
		public RemoveMultipleFeaturesContext removeMultipleFeatures;
		public AddConstraintContext addConstraint;
		public UpdateConstraintContext updateConstraint;
		public UpdateMultipleConstraintsContext updateMultipleConstraints;
		public RemoveConstraintContext removeConstraint;
		public RemoveMultipleConstraintsContext removeMultipleConstraints;
		public AddFeatureContext addFeature() {
			return getRuleContext(AddFeatureContext.class,0);
		}
		public UpdateFeatureContext updateFeature() {
			return getRuleContext(UpdateFeatureContext.class,0);
		}
		public UpdateMultipleFeaturesContext updateMultipleFeatures() {
			return getRuleContext(UpdateMultipleFeaturesContext.class,0);
		}
		public RemoveFeatureContext removeFeature() {
			return getRuleContext(RemoveFeatureContext.class,0);
		}
		public RemoveMultipleFeaturesContext removeMultipleFeatures() {
			return getRuleContext(RemoveMultipleFeaturesContext.class,0);
		}
		public AddConstraintContext addConstraint() {
			return getRuleContext(AddConstraintContext.class,0);
		}
		public UpdateConstraintContext updateConstraint() {
			return getRuleContext(UpdateConstraintContext.class,0);
		}
		public UpdateMultipleConstraintsContext updateMultipleConstraints() {
			return getRuleContext(UpdateMultipleConstraintsContext.class,0);
		}
		public RemoveConstraintContext removeConstraint() {
			return getRuleContext(RemoveConstraintContext.class,0);
		}
		public RemoveMultipleConstraintsContext removeMultipleConstraints() {
			return getRuleContext(RemoveMultipleConstraintsContext.class,0);
		}
		public ACommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterACommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitACommand(this);
		}
	}

	public final ACommandContext aCommand() throws RecognitionException {
		ACommandContext _localctx = new ACommandContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_aCommand);
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				((ACommandContext)_localctx).addFeature = addFeature();
				 ((ACommandContext)_localctx).ilcode =  ((ACommandContext)_localctx).addFeature.ilcode; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				((ACommandContext)_localctx).updateFeature = updateFeature();
				 ((ACommandContext)_localctx).ilcode =  ((ACommandContext)_localctx).updateFeature.ilcode; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				((ACommandContext)_localctx).updateMultipleFeatures = updateMultipleFeatures();
				 ((ACommandContext)_localctx).ilcode =  ((ACommandContext)_localctx).updateMultipleFeatures.ilcode; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				((ACommandContext)_localctx).removeFeature = removeFeature();
				 ((ACommandContext)_localctx).ilcode =  ((ACommandContext)_localctx).removeFeature.ilcode; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(231);
				((ACommandContext)_localctx).removeMultipleFeatures = removeMultipleFeatures();
				 ((ACommandContext)_localctx).ilcode =  ((ACommandContext)_localctx).removeMultipleFeatures.ilcode; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(234);
				((ACommandContext)_localctx).addConstraint = addConstraint();
				 ((ACommandContext)_localctx).ilcode =  ((ACommandContext)_localctx).addConstraint.ilcode; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(237);
				((ACommandContext)_localctx).updateConstraint = updateConstraint();
				 ((ACommandContext)_localctx).ilcode =  ((ACommandContext)_localctx).updateConstraint.ilcode; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(240);
				((ACommandContext)_localctx).updateMultipleConstraints = updateMultipleConstraints();
				 ((ACommandContext)_localctx).ilcode =  ((ACommandContext)_localctx).updateMultipleConstraints.ilcode; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(243);
				((ACommandContext)_localctx).removeConstraint = removeConstraint();
				 ((ACommandContext)_localctx).ilcode =  ((ACommandContext)_localctx).removeConstraint.ilcode; 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(246);
				((ACommandContext)_localctx).removeMultipleConstraints = removeMultipleConstraints();
				 ((ACommandContext)_localctx).ilcode =  ((ACommandContext)_localctx).removeMultipleConstraints.ilcode; 
				}
				break;
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

	public static class AddFeatureContext extends ParserRuleContext {
		public String ilcode;
		public FeatureNameContext featureName;
		public AttributeListContext attributeList;
		public WhereClauseContext whereClause;
		public FeatureNameContext featureName() {
			return getRuleContext(FeatureNameContext.class,0);
		}
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public AddFeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addFeature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterAddFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitAddFeature(this);
		}
	}

	public final AddFeatureContext addFeature() throws RecognitionException {
		AddFeatureContext _localctx = new AddFeatureContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_addFeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__10);
			setState(252);
			match(T__2);
			setState(253);
			((AddFeatureContext)_localctx).featureName = featureName();
			setState(254);
			match(T__11);
			setState(255);
			match(T__12);
			setState(256);
			((AddFeatureContext)_localctx).attributeList = attributeList();
			setState(257);
			((AddFeatureContext)_localctx).whereClause = whereClause();
			setState(258);
			match(T__1);

			            ((AddFeatureContext)_localctx).ilcode =   "10" + " " + (((AddFeatureContext)_localctx).featureName!=null?_input.getText(((AddFeatureContext)_localctx).featureName.start,((AddFeatureContext)_localctx).featureName.stop):null) +
			                           ((AddFeatureContext)_localctx).attributeList.ilcode +
			                           ((AddFeatureContext)_localctx).whereClause.ilcode +
			                      "-10";
			          
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

	public static class UpdateFeatureContext extends ParserRuleContext {
		public String ilcode;
		public FeatureDescriptionContext featureDescription;
		public FeatureUpdatesContext featureUpdates;
		public WhereClauseContext whereClause;
		public FeatureDescriptionContext featureDescription() {
			return getRuleContext(FeatureDescriptionContext.class,0);
		}
		public FeatureUpdatesContext featureUpdates() {
			return getRuleContext(FeatureUpdatesContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public UpdateFeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateFeature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterUpdateFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitUpdateFeature(this);
		}
	}

	public final UpdateFeatureContext updateFeature() throws RecognitionException {
		UpdateFeatureContext _localctx = new UpdateFeatureContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_updateFeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(T__13);
			setState(262);
			match(T__2);
			setState(263);
			((UpdateFeatureContext)_localctx).featureDescription = featureDescription();
			setState(264);
			match(T__14);
			setState(265);
			((UpdateFeatureContext)_localctx).featureUpdates = featureUpdates();
			setState(266);
			((UpdateFeatureContext)_localctx).whereClause = whereClause();
			setState(267);
			match(T__1);

			            ((UpdateFeatureContext)_localctx).ilcode =   "11" + " " + ((UpdateFeatureContext)_localctx).featureDescription.ilcode +
			                           ((UpdateFeatureContext)_localctx).featureUpdates.ilcode +
			                           ((UpdateFeatureContext)_localctx).whereClause.ilcode +
			                      "-11";
			          
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

	public static class UpdateMultipleFeaturesContext extends ParserRuleContext {
		public String ilcode;
		public FeatureVarContext featureVar;
		public LimitedFeatureUpdatesContext limitedFeatureUpdates;
		public WhereClauseContext whereClause;
		public FeatureVarContext featureVar() {
			return getRuleContext(FeatureVarContext.class,0);
		}
		public LimitedFeatureUpdatesContext limitedFeatureUpdates() {
			return getRuleContext(LimitedFeatureUpdatesContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public UpdateMultipleFeaturesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateMultipleFeatures; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterUpdateMultipleFeatures(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitUpdateMultipleFeatures(this);
		}
	}

	public final UpdateMultipleFeaturesContext updateMultipleFeatures() throws RecognitionException {
		UpdateMultipleFeaturesContext _localctx = new UpdateMultipleFeaturesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_updateMultipleFeatures);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(T__15);
			setState(271);
			match(T__2);
			setState(272);
			((UpdateMultipleFeaturesContext)_localctx).featureVar = featureVar();
			setState(273);
			match(T__14);
			setState(274);
			((UpdateMultipleFeaturesContext)_localctx).limitedFeatureUpdates = limitedFeatureUpdates();
			setState(275);
			((UpdateMultipleFeaturesContext)_localctx).whereClause = whereClause();
			setState(276);
			match(T__1);

			            ((UpdateMultipleFeaturesContext)_localctx).ilcode =   "12" + " " + (((UpdateMultipleFeaturesContext)_localctx).featureVar!=null?_input.getText(((UpdateMultipleFeaturesContext)_localctx).featureVar.start,((UpdateMultipleFeaturesContext)_localctx).featureVar.stop):null) +
			                           ((UpdateMultipleFeaturesContext)_localctx).limitedFeatureUpdates.ilcode +
			                           ((UpdateMultipleFeaturesContext)_localctx).whereClause.ilcode +
			                      "-12";
			          
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

	public static class RemoveFeatureContext extends ParserRuleContext {
		public String ilcode;
		public FeatureDescriptionContext featureDescription;
		public WhereClauseContext whereClause;
		public FeatureDescriptionContext featureDescription() {
			return getRuleContext(FeatureDescriptionContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public RemoveFeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_removeFeature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterRemoveFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitRemoveFeature(this);
		}
	}

	public final RemoveFeatureContext removeFeature() throws RecognitionException {
		RemoveFeatureContext _localctx = new RemoveFeatureContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_removeFeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(T__16);
			setState(280);
			match(T__2);
			setState(281);
			((RemoveFeatureContext)_localctx).featureDescription = featureDescription();
			setState(282);
			((RemoveFeatureContext)_localctx).whereClause = whereClause();
			setState(283);
			match(T__1);

			            ((RemoveFeatureContext)_localctx).ilcode =   "13" + " " + ((RemoveFeatureContext)_localctx).featureDescription.ilcode +
			                           ((RemoveFeatureContext)_localctx).whereClause.ilcode +
			                      "-13";
			          
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

	public static class RemoveMultipleFeaturesContext extends ParserRuleContext {
		public String ilcode;
		public FeatureVarContext featureVar;
		public WhereClauseContext whereClause;
		public FeatureVarContext featureVar() {
			return getRuleContext(FeatureVarContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public RemoveMultipleFeaturesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_removeMultipleFeatures; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterRemoveMultipleFeatures(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitRemoveMultipleFeatures(this);
		}
	}

	public final RemoveMultipleFeaturesContext removeMultipleFeatures() throws RecognitionException {
		RemoveMultipleFeaturesContext _localctx = new RemoveMultipleFeaturesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_removeMultipleFeatures);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(T__17);
			setState(287);
			match(T__2);
			setState(288);
			((RemoveMultipleFeaturesContext)_localctx).featureVar = featureVar();
			setState(289);
			((RemoveMultipleFeaturesContext)_localctx).whereClause = whereClause();
			setState(290);
			match(T__1);

			            ((RemoveMultipleFeaturesContext)_localctx).ilcode =   "14" + " " + (((RemoveMultipleFeaturesContext)_localctx).featureVar!=null?_input.getText(((RemoveMultipleFeaturesContext)_localctx).featureVar.start,((RemoveMultipleFeaturesContext)_localctx).featureVar.stop):null) +
			                           ((RemoveMultipleFeaturesContext)_localctx).whereClause.ilcode +
			                      "-14";
			          
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

	public static class AddConstraintContext extends ParserRuleContext {
		public String ilcode;
		public ConstraintDescriptionContext constraintDescription;
		public WhereClauseContext whereClause;
		public ConstraintDescriptionContext constraintDescription() {
			return getRuleContext(ConstraintDescriptionContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public AddConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterAddConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitAddConstraint(this);
		}
	}

	public final AddConstraintContext addConstraint() throws RecognitionException {
		AddConstraintContext _localctx = new AddConstraintContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_addConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(T__10);
			setState(294);
			match(T__9);
			setState(295);
			((AddConstraintContext)_localctx).constraintDescription = constraintDescription();
			setState(296);
			((AddConstraintContext)_localctx).whereClause = whereClause();
			setState(297);
			match(T__1);

			            ((AddConstraintContext)_localctx).ilcode =   "15" + " " + ((AddConstraintContext)_localctx).constraintDescription.ilcode +
			                           ((AddConstraintContext)_localctx).whereClause.ilcode +
			                      "-15";
			          
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

	public static class UpdateConstraintContext extends ParserRuleContext {
		public String ilcode;
		public ConstraintDescriptionContext constraintDescription;
		public ConstraintUpdatesContext constraintUpdates;
		public WhereClauseContext whereClause;
		public ConstraintDescriptionContext constraintDescription() {
			return getRuleContext(ConstraintDescriptionContext.class,0);
		}
		public ConstraintUpdatesContext constraintUpdates() {
			return getRuleContext(ConstraintUpdatesContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public UpdateConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterUpdateConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitUpdateConstraint(this);
		}
	}

	public final UpdateConstraintContext updateConstraint() throws RecognitionException {
		UpdateConstraintContext _localctx = new UpdateConstraintContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_updateConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(T__13);
			setState(301);
			match(T__9);
			setState(302);
			((UpdateConstraintContext)_localctx).constraintDescription = constraintDescription();
			setState(303);
			match(T__14);
			setState(304);
			((UpdateConstraintContext)_localctx).constraintUpdates = constraintUpdates();
			setState(305);
			((UpdateConstraintContext)_localctx).whereClause = whereClause();
			setState(306);
			match(T__1);

			            ((UpdateConstraintContext)_localctx).ilcode =   "16" + " " + ((UpdateConstraintContext)_localctx).constraintDescription.ilcode +
			                           ((UpdateConstraintContext)_localctx).constraintUpdates.ilcode +
			                           ((UpdateConstraintContext)_localctx).whereClause.ilcode +
			                      "-16";
			          
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

	public static class UpdateMultipleConstraintsContext extends ParserRuleContext {
		public String ilcode;
		public ConstraintDescriptionContext constraintDescription;
		public LimitedConstraintUpdatesContext limitedConstraintUpdates;
		public WhereClauseContext whereClause;
		public ConstraintDescriptionContext constraintDescription() {
			return getRuleContext(ConstraintDescriptionContext.class,0);
		}
		public LimitedConstraintUpdatesContext limitedConstraintUpdates() {
			return getRuleContext(LimitedConstraintUpdatesContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public UpdateMultipleConstraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateMultipleConstraints; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterUpdateMultipleConstraints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitUpdateMultipleConstraints(this);
		}
	}

	public final UpdateMultipleConstraintsContext updateMultipleConstraints() throws RecognitionException {
		UpdateMultipleConstraintsContext _localctx = new UpdateMultipleConstraintsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_updateMultipleConstraints);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(T__15);
			setState(310);
			match(T__9);
			setState(311);
			((UpdateMultipleConstraintsContext)_localctx).constraintDescription = constraintDescription();
			setState(312);
			match(T__14);
			setState(313);
			((UpdateMultipleConstraintsContext)_localctx).limitedConstraintUpdates = limitedConstraintUpdates();
			setState(314);
			((UpdateMultipleConstraintsContext)_localctx).whereClause = whereClause();
			setState(315);
			match(T__1);

			            ((UpdateMultipleConstraintsContext)_localctx).ilcode =   "17" + " " + ((UpdateMultipleConstraintsContext)_localctx).constraintDescription.ilcode +
			                           ((UpdateMultipleConstraintsContext)_localctx).limitedConstraintUpdates.ilcode +
			                           ((UpdateMultipleConstraintsContext)_localctx).whereClause.ilcode +
			                      "-17";
			          
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

	public static class RemoveConstraintContext extends ParserRuleContext {
		public String ilcode;
		public ConstraintDescriptionContext constraintDescription;
		public WhereClauseContext whereClause;
		public ConstraintDescriptionContext constraintDescription() {
			return getRuleContext(ConstraintDescriptionContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public RemoveConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_removeConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterRemoveConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitRemoveConstraint(this);
		}
	}

	public final RemoveConstraintContext removeConstraint() throws RecognitionException {
		RemoveConstraintContext _localctx = new RemoveConstraintContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_removeConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(T__16);
			setState(319);
			match(T__9);
			setState(320);
			((RemoveConstraintContext)_localctx).constraintDescription = constraintDescription();
			setState(321);
			((RemoveConstraintContext)_localctx).whereClause = whereClause();
			setState(322);
			match(T__1);

			            ((RemoveConstraintContext)_localctx).ilcode =   "18" + " " + ((RemoveConstraintContext)_localctx).constraintDescription.ilcode +
			                           ((RemoveConstraintContext)_localctx).whereClause.ilcode +
			                      "-18";
			          
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

	public static class RemoveMultipleConstraintsContext extends ParserRuleContext {
		public String ilcode;
		public ConstraintDescriptionContext constraintDescription;
		public WhereClauseContext whereClause;
		public ConstraintDescriptionContext constraintDescription() {
			return getRuleContext(ConstraintDescriptionContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public RemoveMultipleConstraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_removeMultipleConstraints; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterRemoveMultipleConstraints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitRemoveMultipleConstraints(this);
		}
	}

	public final RemoveMultipleConstraintsContext removeMultipleConstraints() throws RecognitionException {
		RemoveMultipleConstraintsContext _localctx = new RemoveMultipleConstraintsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_removeMultipleConstraints);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(T__17);
			setState(326);
			match(T__9);
			setState(327);
			((RemoveMultipleConstraintsContext)_localctx).constraintDescription = constraintDescription();
			setState(328);
			((RemoveMultipleConstraintsContext)_localctx).whereClause = whereClause();
			setState(329);
			match(T__1);

			            ((RemoveMultipleConstraintsContext)_localctx).ilcode =   "19" + " " + ((RemoveMultipleConstraintsContext)_localctx).constraintDescription.ilcode +
			                           ((RemoveMultipleConstraintsContext)_localctx).whereClause.ilcode +
			                      "-19";
			          
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

	public static class FeatureDescriptionContext extends ParserRuleContext {
		public String ilcode;
		public FeatureNameContext featureName;
		public FeatureVarContext featureVar;
		public FeatureNameContext featureName() {
			return getRuleContext(FeatureNameContext.class,0);
		}
		public FeatureVarContext featureVar() {
			return getRuleContext(FeatureVarContext.class,0);
		}
		public FeatureDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterFeatureDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitFeatureDescription(this);
		}
	}

	public final FeatureDescriptionContext featureDescription() throws RecognitionException {
		FeatureDescriptionContext _localctx = new FeatureDescriptionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_featureDescription);
		try {
			setState(338);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				((FeatureDescriptionContext)_localctx).featureName = featureName();
				 ((FeatureDescriptionContext)_localctx).ilcode =  "1" + " " + (((FeatureDescriptionContext)_localctx).featureName!=null?_input.getText(((FeatureDescriptionContext)_localctx).featureName.start,((FeatureDescriptionContext)_localctx).featureName.stop):null); 
				}
				break;
			case FEATURE_VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				((FeatureDescriptionContext)_localctx).featureVar = featureVar();
				 ((FeatureDescriptionContext)_localctx).ilcode =  "2" + " " + (((FeatureDescriptionContext)_localctx).featureVar!=null?_input.getText(((FeatureDescriptionContext)_localctx).featureVar.start,((FeatureDescriptionContext)_localctx).featureVar.stop):null);  
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FeatureNameDescriptionContext extends ParserRuleContext {
		public String ilcode;
		public FeatureNameContext featureName;
		public FeatureVarContext featureVar;
		public FeatureNameContext featureName() {
			return getRuleContext(FeatureNameContext.class,0);
		}
		public FeatureVarContext featureVar() {
			return getRuleContext(FeatureVarContext.class,0);
		}
		public FeatureNameDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureNameDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterFeatureNameDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitFeatureNameDescription(this);
		}
	}

	public final FeatureNameDescriptionContext featureNameDescription() throws RecognitionException {
		FeatureNameDescriptionContext _localctx = new FeatureNameDescriptionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_featureNameDescription);
		try {
			setState(348);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				((FeatureNameDescriptionContext)_localctx).featureName = featureName();
				 ((FeatureNameDescriptionContext)_localctx).ilcode =  "1" + " " + (((FeatureNameDescriptionContext)_localctx).featureName!=null?_input.getText(((FeatureNameDescriptionContext)_localctx).featureName.start,((FeatureNameDescriptionContext)_localctx).featureName.stop):null); 
				}
				break;
			case FEATURE_VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				((FeatureNameDescriptionContext)_localctx).featureVar = featureVar();
				setState(344);
				match(T__18);
				setState(345);
				match(T__19);
				 ((FeatureNameDescriptionContext)_localctx).ilcode =  "2" + " " + (((FeatureNameDescriptionContext)_localctx).featureVar!=null?_input.getText(((FeatureNameDescriptionContext)_localctx).featureVar.start,((FeatureNameDescriptionContext)_localctx).featureVar.stop):null);  
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ConstraintDescriptionContext extends ParserRuleContext {
		public String ilcode;
		public FeatureDescriptionContext lbl_fd1;
		public BasicCrossTreeConstraintContext basicCrossTreeConstraint;
		public FeatureDescriptionContext lbl_fd2;
		public BasicCrossTreeConstraintContext basicCrossTreeConstraint() {
			return getRuleContext(BasicCrossTreeConstraintContext.class,0);
		}
		public List<FeatureDescriptionContext> featureDescription() {
			return getRuleContexts(FeatureDescriptionContext.class);
		}
		public FeatureDescriptionContext featureDescription(int i) {
			return getRuleContext(FeatureDescriptionContext.class,i);
		}
		public ConstraintDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterConstraintDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitConstraintDescription(this);
		}
	}

	public final ConstraintDescriptionContext constraintDescription() throws RecognitionException {
		ConstraintDescriptionContext _localctx = new ConstraintDescriptionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_constraintDescription);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			((ConstraintDescriptionContext)_localctx).lbl_fd1 = featureDescription();
			setState(351);
			((ConstraintDescriptionContext)_localctx).basicCrossTreeConstraint = basicCrossTreeConstraint();
			setState(352);
			((ConstraintDescriptionContext)_localctx).lbl_fd2 = featureDescription();
			 ((ConstraintDescriptionContext)_localctx).ilcode =  ((ConstraintDescriptionContext)_localctx).lbl_fd1.ilcode + " " + ((ConstraintDescriptionContext)_localctx).basicCrossTreeConstraint.ilcode + " " + ((ConstraintDescriptionContext)_localctx).lbl_fd2.ilcode; 
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

	public static class WhereClauseContext extends ParserRuleContext {
		public String ilcode;
		public BooleanExpressionContext booleanExpression;
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_whereClause);
		try {
			setState(360);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(355);
				match(T__20);
				setState(356);
				((WhereClauseContext)_localctx).booleanExpression = booleanExpression(0);
				 ((WhereClauseContext)_localctx).ilcode =  "\r\n  " + "100" + " " + ((WhereClauseContext)_localctx).booleanExpression.ilcode + " -100\r\n"; 
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				 ((WhereClauseContext)_localctx).ilcode =  "\r\n"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AttributeListContext extends ParserRuleContext {
		public String ilcode;
		public StructuralAttributeAssignmentsContext structuralAttributeAssignments;
		public AttributeAssignmentsContext attributeAssignments;
		public StructuralAttributeAssignmentsContext structuralAttributeAssignments() {
			return getRuleContext(StructuralAttributeAssignmentsContext.class,0);
		}
		public AttributeAssignmentsContext attributeAssignments() {
			return getRuleContext(AttributeAssignmentsContext.class,0);
		}
		public AttributeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterAttributeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitAttributeList(this);
		}
	}

	public final AttributeListContext attributeList() throws RecognitionException {
		AttributeListContext _localctx = new AttributeListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_attributeList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(T__21);
			setState(363);
			((AttributeListContext)_localctx).structuralAttributeAssignments = structuralAttributeAssignments();
			setState(364);
			((AttributeListContext)_localctx).attributeAssignments = attributeAssignments(new ArrayList());
			setState(365);
			match(T__22);
			 ((AttributeListContext)_localctx).ilcode =  ((AttributeListContext)_localctx).structuralAttributeAssignments.ilcode + ((AttributeListContext)_localctx).attributeAssignments.ilcode; 
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

	public static class StructuralAttributeAssignmentsContext extends ParserRuleContext {
		public String ilcode;
		public SettingLocationContext settingLocation;
		public SettingDecompositionContext settingDecomposition;
		public SettingLocationContext settingLocation() {
			return getRuleContext(SettingLocationContext.class,0);
		}
		public SettingDecompositionContext settingDecomposition() {
			return getRuleContext(SettingDecompositionContext.class,0);
		}
		public StructuralAttributeAssignmentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structuralAttributeAssignments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterStructuralAttributeAssignments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitStructuralAttributeAssignments(this);
		}
	}

	public final StructuralAttributeAssignmentsContext structuralAttributeAssignments() throws RecognitionException {
		StructuralAttributeAssignmentsContext _localctx = new StructuralAttributeAssignmentsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_structuralAttributeAssignments);
		try {
			setState(378);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				((StructuralAttributeAssignmentsContext)_localctx).settingLocation = settingLocation();
				setState(369);
				match(T__23);
				setState(370);
				((StructuralAttributeAssignmentsContext)_localctx).settingDecomposition = settingDecomposition();
				 
				            ((StructuralAttributeAssignmentsContext)_localctx).ilcode =  "\r\n  " + ((StructuralAttributeAssignmentsContext)_localctx).settingLocation.ilcode +
				                      "\r\n  " + ((StructuralAttributeAssignmentsContext)_localctx).settingDecomposition.ilcode;
				          
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				((StructuralAttributeAssignmentsContext)_localctx).settingDecomposition = settingDecomposition();
				setState(374);
				match(T__23);
				setState(375);
				((StructuralAttributeAssignmentsContext)_localctx).settingLocation = settingLocation();
				 
				            ((StructuralAttributeAssignmentsContext)_localctx).ilcode =  "\r\n  " + ((StructuralAttributeAssignmentsContext)_localctx).settingLocation.ilcode +
				                      "\r\n  " + ((StructuralAttributeAssignmentsContext)_localctx).settingDecomposition.ilcode;
				          
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SettingLocationContext extends ParserRuleContext {
		public String ilcode;
		public int lineNo;
		public FeatureNameDescriptionContext featureNameDescription;
		public FeatureNameDescriptionContext featureNameDescription() {
			return getRuleContext(FeatureNameDescriptionContext.class,0);
		}
		public SettingLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_settingLocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterSettingLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitSettingLocation(this);
		}
	}

	public final SettingLocationContext settingLocation() throws RecognitionException {
		SettingLocationContext _localctx = new SettingLocationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_settingLocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(T__24);
			setState(381);
			match(T__25);
			setState(382);
			((SettingLocationContext)_localctx).featureNameDescription = featureNameDescription();
			 ((SettingLocationContext)_localctx).ilcode =  "2" + " " + ((SettingLocationContext)_localctx).featureNameDescription.ilcode; ((SettingLocationContext)_localctx).lineNo =  _localctx.start.getLine(); 
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

	public static class SettingDecompositionContext extends ParserRuleContext {
		public String ilcode;
		public int lineNo;
		public DecompRelValueContext decompRelValue;
		public FeatureDescriptionContext featureDescription;
		public DecompRelValueContext decompRelValue() {
			return getRuleContext(DecompRelValueContext.class,0);
		}
		public FeatureDescriptionContext featureDescription() {
			return getRuleContext(FeatureDescriptionContext.class,0);
		}
		public SettingDecompositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_settingDecomposition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterSettingDecomposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitSettingDecomposition(this);
		}
	}

	public final SettingDecompositionContext settingDecomposition() throws RecognitionException {
		SettingDecompositionContext _localctx = new SettingDecompositionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_settingDecomposition);
		try {
			setState(397);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(385);
				match(T__26);
				setState(386);
				match(T__25);
				setState(387);
				((SettingDecompositionContext)_localctx).decompRelValue = decompRelValue();

				            if ( ((SettingDecompositionContext)_localctx).decompRelValue.decRelType == 1 || ((SettingDecompositionContext)_localctx).decompRelValue.decRelType == 2 )
				               ((SettingDecompositionContext)_localctx).ilcode =  "3" + " " + ((SettingDecompositionContext)_localctx).decompRelValue.ilcode;
				            else
				               ((SettingDecompositionContext)_localctx).ilcode =  "3" + " " + ((SettingDecompositionContext)_localctx).decompRelValue.ilcode + " " + "0";

				            ((SettingDecompositionContext)_localctx).lineNo =  _localctx.start.getLine();
				          
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(390);
				match(T__26);
				setState(391);
				match(T__25);
				setState(392);
				((SettingDecompositionContext)_localctx).decompRelValue = decompRelValue();
				setState(393);
				match(T__6);
				setState(394);
				((SettingDecompositionContext)_localctx).featureDescription = featureDescription();

				            if ( ((SettingDecompositionContext)_localctx).decompRelValue.decRelType == 1 || ((SettingDecompositionContext)_localctx).decompRelValue.decRelType == 2 )
				            {
				               // This means that user tries to do 'mandatory/optional to something' which is not meaningful, take necessary actions
							   notifyErrorListeners(((SettingDecompositionContext)_localctx).decompRelValue.lineNo + ": '" + (((SettingDecompositionContext)_localctx).decompRelValue!=null?_input.getText(((SettingDecompositionContext)_localctx).decompRelValue.start,((SettingDecompositionContext)_localctx).decompRelValue.stop):null) + " to ...' is not a valid decomposition relation specification");
				            }

				            ((SettingDecompositionContext)_localctx).ilcode =  "3" + " " + ((SettingDecompositionContext)_localctx).decompRelValue.ilcode + " " + "1" + " " + ((SettingDecompositionContext)_localctx).featureDescription.ilcode;

				            ((SettingDecompositionContext)_localctx).lineNo =  _localctx.start.getLine();
				          
				}
				break;
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

	public static class AttributeAssignmentsContext extends ParserRuleContext {
		public ArrayList i_setOfAttributes;
		public String ilcode;
		public AttrAssignContext attrAssign;
		public List<AttrAssignContext> attrs = new ArrayList<AttrAssignContext>();
		public List<AttrAssignContext> attrAssign() {
			return getRuleContexts(AttrAssignContext.class);
		}
		public AttrAssignContext attrAssign(int i) {
			return getRuleContext(AttrAssignContext.class,i);
		}
		public AttributeAssignmentsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AttributeAssignmentsContext(ParserRuleContext parent, int invokingState, ArrayList i_setOfAttributes) {
			super(parent, invokingState);
			this.i_setOfAttributes = i_setOfAttributes;
		}
		@Override public int getRuleIndex() { return RULE_attributeAssignments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterAttributeAssignments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitAttributeAssignments(this);
		}
	}

	public final AttributeAssignmentsContext attributeAssignments(ArrayList i_setOfAttributes) throws RecognitionException {
		AttributeAssignmentsContext _localctx = new AttributeAssignmentsContext(_ctx, getState(), i_setOfAttributes);
		enterRule(_localctx, 62, RULE_attributeAssignments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(399);
				match(T__23);
				setState(400);
				((AttributeAssignmentsContext)_localctx).attrAssign = attrAssign(_localctx.i_setOfAttributes, 0);
				((AttributeAssignmentsContext)_localctx).attrs.add(((AttributeAssignmentsContext)_localctx).attrAssign);
				}
				}
				setState(405);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

						((AttributeAssignmentsContext)_localctx).ilcode =  "";
						for ( AttrAssignContext a : ((AttributeAssignmentsContext)_localctx).attrs )
						   _localctx.ilcode += "\r\n  " + a.ilcode;
					  
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

	public static class AttrAssignContext extends ParserRuleContext {
		public ArrayList i_setOfAttributes;
		public int usedIn;
		public String ilcode;
		public ArrayList setOfAttributes;
		public int i;
		public String existingName;
		public AttributeNameContext attributeName;
		public AttributeValueContext attributeValue;
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public AttributeValueContext attributeValue() {
			return getRuleContext(AttributeValueContext.class,0);
		}
		public AttrAssignContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AttrAssignContext(ParserRuleContext parent, int invokingState, ArrayList i_setOfAttributes, int usedIn) {
			super(parent, invokingState);
			this.i_setOfAttributes = i_setOfAttributes;
			this.usedIn = usedIn;
		}
		@Override public int getRuleIndex() { return RULE_attrAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterAttrAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitAttrAssign(this);
		}
	}

	public final AttrAssignContext attrAssign(ArrayList i_setOfAttributes,int usedIn) throws RecognitionException {
		AttrAssignContext _localctx = new AttrAssignContext(_ctx, getState(), i_setOfAttributes, usedIn);
		enterRule(_localctx, 64, RULE_attrAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			((AttrAssignContext)_localctx).attributeName = attributeName();
			setState(409);
			match(T__25);
			setState(410);
			((AttrAssignContext)_localctx).attributeValue = attributeValue();

			            for (((AttrAssignContext)_localctx).i = 0; _localctx.i < _localctx.i_setOfAttributes.size(); _localctx.i++)
			            {
			              ((AttrAssignContext)_localctx).existingName =  (String) _localctx.i_setOfAttributes.get(_localctx.i);
			              if ( (((AttrAssignContext)_localctx).attributeName!=null?_input.getText(((AttrAssignContext)_localctx).attributeName.start,((AttrAssignContext)_localctx).attributeName.stop):null).equals(_localctx.existingName) )
			              {
			                 if ( _localctx.usedIn == 0 )
			                 {
			                   // This means that another attribute with the same name already exists, take necessary actions
			                   notifyErrorListeners(((AttrAssignContext)_localctx).attributeName.lineNo + ": an attribute with the name '" + (((AttrAssignContext)_localctx).attributeName!=null?_input.getText(((AttrAssignContext)_localctx).attributeName.start,((AttrAssignContext)_localctx).attributeName.stop):null) + "' has already been declared");
			                 }
			                 else if ( _localctx.usedIn == 1 )
			                 {
			                   // This means that the attribute has already been updated, take necessary actions
			                   notifyErrorListeners(((AttrAssignContext)_localctx).attributeName.lineNo + ": the attribute '" + (((AttrAssignContext)_localctx).attributeName!=null?_input.getText(((AttrAssignContext)_localctx).attributeName.start,((AttrAssignContext)_localctx).attributeName.stop):null) + "' has already been updated");
			                 }
			              }
			            }

			            ((AttrAssignContext)_localctx).ilcode =  "5" + " " + (((AttrAssignContext)_localctx).attributeName!=null?_input.getText(((AttrAssignContext)_localctx).attributeName.start,((AttrAssignContext)_localctx).attributeName.stop):null) + " " + ((AttrAssignContext)_localctx).attributeValue.ilcode + " " + "-5";

			            ((AttrAssignContext)_localctx).setOfAttributes =  _localctx.i_setOfAttributes;
			            _localctx.setOfAttributes.add((((AttrAssignContext)_localctx).attributeName!=null?_input.getText(((AttrAssignContext)_localctx).attributeName.start,((AttrAssignContext)_localctx).attributeName.stop):null));
			          
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

	public static class AttributeValueContext extends ParserRuleContext {
		public String ilcode;
		public FeatureDescriptionContext featureDescription;
		public AttributeNameContext attributeName;
		public ArithmeticExpressionContext arithmeticExpression;
		public BooleanExpressionContext booleanExpression;
		public Token STRING_LITERAL;
		public FeatureDescriptionContext featureDescription() {
			return getRuleContext(FeatureDescriptionContext.class,0);
		}
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(FeatherParser.STRING_LITERAL, 0); }
		public AttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterAttributeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitAttributeValue(this);
		}
	}

	public final AttributeValueContext attributeValue() throws RecognitionException {
		AttributeValueContext _localctx = new AttributeValueContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_attributeValue);
		try {
			setState(434);
			switch (_input.LA(1)) {
			case T__27:
				enterOuterAlt(_localctx, 1);
				{
				setState(413);
				match(T__27);
				setState(414);
				match(T__28);
				setState(415);
				((AttributeValueContext)_localctx).featureDescription = featureDescription();
				setState(416);
				match(T__18);
				setState(417);
				((AttributeValueContext)_localctx).attributeName = attributeName();

				            ((AttributeValueContext)_localctx).ilcode =  "0" + " " + ((AttributeValueContext)_localctx).featureDescription.ilcode + " " + (((AttributeValueContext)_localctx).attributeName!=null?_input.getText(((AttributeValueContext)_localctx).attributeName.start,((AttributeValueContext)_localctx).attributeName.stop):null);
				          
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				match(T__29);
				setState(421);
				match(T__28);
				setState(422);
				((AttributeValueContext)_localctx).arithmeticExpression = arithmeticExpression(0);

				            ((AttributeValueContext)_localctx).ilcode =  "1" + " " + ((AttributeValueContext)_localctx).arithmeticExpression.ilcode;
				          
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 3);
				{
				setState(425);
				match(T__30);
				setState(426);
				match(T__28);
				setState(427);
				((AttributeValueContext)_localctx).booleanExpression = booleanExpression(0);

				            ((AttributeValueContext)_localctx).ilcode =  "3" + " " + ((AttributeValueContext)_localctx).booleanExpression.ilcode;
				          
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 4);
				{
				setState(430);
				match(T__31);
				setState(431);
				match(T__28);
				setState(432);
				((AttributeValueContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);

				            ((AttributeValueContext)_localctx).ilcode =  "4" + " " + (((AttributeValueContext)_localctx).STRING_LITERAL!=null?((AttributeValueContext)_localctx).STRING_LITERAL.getText():null);
				          
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FeatureUpdatesContext extends ParserRuleContext {
		public String ilcode;
		public FeatUpdateContext lbl_fu;
		public FeatUpdateContext featUpdate;
		public List<FeatUpdateContext> updates = new ArrayList<FeatUpdateContext>();
		public List<FeatUpdateContext> featUpdate() {
			return getRuleContexts(FeatUpdateContext.class);
		}
		public FeatUpdateContext featUpdate(int i) {
			return getRuleContext(FeatUpdateContext.class,i);
		}
		public FeatureUpdatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureUpdates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterFeatureUpdates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitFeatureUpdates(this);
		}
	}

	public final FeatureUpdatesContext featureUpdates() throws RecognitionException {
		FeatureUpdatesContext _localctx = new FeatureUpdatesContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_featureUpdates);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			((FeatureUpdatesContext)_localctx).lbl_fu = featUpdate(new ArrayList());
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(437);
				match(T__23);
				setState(438);
				((FeatureUpdatesContext)_localctx).featUpdate = featUpdate(((FeatureUpdatesContext)_localctx).lbl_fu.setOfAttributes);
				((FeatureUpdatesContext)_localctx).updates.add(((FeatureUpdatesContext)_localctx).featUpdate);
				}
				}
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 
			            ((FeatureUpdatesContext)_localctx).ilcode =  "\r\n  " + ((FeatureUpdatesContext)_localctx).lbl_fu.ilcode;
			            for ( FeatUpdateContext u : ((FeatureUpdatesContext)_localctx).updates )
						   _localctx.ilcode += "\r\n  " + u.ilcode;
			          
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

	public static class FeatUpdateContext extends ParserRuleContext {
		public ArrayList i_setOfAttributes;
		public String ilcode;
		public ArrayList setOfAttributes;
		public int i;
		public String existingName;
		public SettingNameContext settingName;
		public SettingLocationContext settingLocation;
		public SettingDecompositionContext settingDecomposition;
		public AttrAssignContext attrAssign;
		public SettingNameContext settingName() {
			return getRuleContext(SettingNameContext.class,0);
		}
		public SettingLocationContext settingLocation() {
			return getRuleContext(SettingLocationContext.class,0);
		}
		public SettingDecompositionContext settingDecomposition() {
			return getRuleContext(SettingDecompositionContext.class,0);
		}
		public AttrAssignContext attrAssign() {
			return getRuleContext(AttrAssignContext.class,0);
		}
		public FeatUpdateContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FeatUpdateContext(ParserRuleContext parent, int invokingState, ArrayList i_setOfAttributes) {
			super(parent, invokingState);
			this.i_setOfAttributes = i_setOfAttributes;
		}
		@Override public int getRuleIndex() { return RULE_featUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterFeatUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitFeatUpdate(this);
		}
	}

	public final FeatUpdateContext featUpdate(ArrayList i_setOfAttributes) throws RecognitionException {
		FeatUpdateContext _localctx = new FeatUpdateContext(_ctx, getState(), i_setOfAttributes);
		enterRule(_localctx, 70, RULE_featUpdate);
		try {
			setState(458);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(446);
				((FeatUpdateContext)_localctx).settingName = settingName();

				            for (((FeatUpdateContext)_localctx).i = 0; _localctx.i < _localctx.i_setOfAttributes.size(); _localctx.i++)
				            {
				              ((FeatUpdateContext)_localctx).existingName =  (String) _localctx.i_setOfAttributes.get(_localctx.i);
				              if ( _localctx.existingName.equals("_name") )
				              {
				                 // This means that name of the feature has already been updated, take necessary actions
				                 notifyErrorListeners(((FeatUpdateContext)_localctx).settingName.lineNo + ": name of the feature has already been updated");
				              }
				            }

				            ((FeatUpdateContext)_localctx).ilcode =  ((FeatUpdateContext)_localctx).settingName.ilcode;

				            ((FeatUpdateContext)_localctx).setOfAttributes =  _localctx.i_setOfAttributes;
				            _localctx.setOfAttributes.add("_name");
				          
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(449);
				((FeatUpdateContext)_localctx).settingLocation = settingLocation();

				            for (((FeatUpdateContext)_localctx).i = 0; _localctx.i < _localctx.i_setOfAttributes.size(); _localctx.i++)
				            {
				              ((FeatUpdateContext)_localctx).existingName =  (String) _localctx.i_setOfAttributes.get(_localctx.i);
				              if ( _localctx.existingName.equals("_parent") )
				              {
				                 // This means that location of the feature has already been updated, take necessary actions
				                 notifyErrorListeners(((FeatUpdateContext)_localctx).settingLocation.lineNo + ": location of the feature has already been updated");
				              }
				            }

				            ((FeatUpdateContext)_localctx).ilcode =  ((FeatUpdateContext)_localctx).settingLocation.ilcode;

				            ((FeatUpdateContext)_localctx).setOfAttributes =  _localctx.i_setOfAttributes;
				            _localctx.setOfAttributes.add("_parent");
				          
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 3);
				{
				setState(452);
				((FeatUpdateContext)_localctx).settingDecomposition = settingDecomposition();

				            for (((FeatUpdateContext)_localctx).i = 0; _localctx.i < _localctx.i_setOfAttributes.size(); _localctx.i++)
				            {
				              ((FeatUpdateContext)_localctx).existingName =  (String) _localctx.i_setOfAttributes.get(_localctx.i);
				              if ( _localctx.existingName.equals("_decomp") )
				              {
				                 // This means that decomposition relation of the feature has already been updated, take necessary actions
				                 notifyErrorListeners(((FeatUpdateContext)_localctx).settingDecomposition.lineNo + ": decomposition relation of the feature has already been updated");
				              }
				            }

				            ((FeatUpdateContext)_localctx).ilcode =  ((FeatUpdateContext)_localctx).settingDecomposition.ilcode;

				            ((FeatUpdateContext)_localctx).setOfAttributes =  _localctx.i_setOfAttributes;
				            _localctx.setOfAttributes.add("_decomp");
				          
				}
				break;
			case ATTRIBUTE_NAME:
				enterOuterAlt(_localctx, 4);
				{
				setState(455);
				((FeatUpdateContext)_localctx).attrAssign = attrAssign(i_setOfAttributes, 1);

				            ((FeatUpdateContext)_localctx).ilcode =  ((FeatUpdateContext)_localctx).attrAssign.ilcode;
				            ((FeatUpdateContext)_localctx).setOfAttributes =  ((FeatUpdateContext)_localctx).attrAssign.setOfAttributes;
				          
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SettingNameContext extends ParserRuleContext {
		public String ilcode;
		public int lineNo;
		public Token STRING_LITERAL;
		public TerminalNode STRING_LITERAL() { return getToken(FeatherParser.STRING_LITERAL, 0); }
		public SettingNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_settingName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterSettingName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitSettingName(this);
		}
	}

	public final SettingNameContext settingName() throws RecognitionException {
		SettingNameContext _localctx = new SettingNameContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_settingName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			match(T__19);
			setState(461);
			match(T__25);
			setState(462);
			((SettingNameContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
			 ((SettingNameContext)_localctx).ilcode =  "1" + " " + (((SettingNameContext)_localctx).STRING_LITERAL!=null?((SettingNameContext)_localctx).STRING_LITERAL.getText():null); ((SettingNameContext)_localctx).lineNo =  _localctx.start.getLine(); 
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

	public static class LimitedFeatureUpdatesContext extends ParserRuleContext {
		public String ilcode;
		public LimitedFeatUpdateContext lbl_lfu;
		public LimitedFeatUpdateContext limitedFeatUpdate;
		public List<LimitedFeatUpdateContext> updates = new ArrayList<LimitedFeatUpdateContext>();
		public List<LimitedFeatUpdateContext> limitedFeatUpdate() {
			return getRuleContexts(LimitedFeatUpdateContext.class);
		}
		public LimitedFeatUpdateContext limitedFeatUpdate(int i) {
			return getRuleContext(LimitedFeatUpdateContext.class,i);
		}
		public LimitedFeatureUpdatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitedFeatureUpdates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterLimitedFeatureUpdates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitLimitedFeatureUpdates(this);
		}
	}

	public final LimitedFeatureUpdatesContext limitedFeatureUpdates() throws RecognitionException {
		LimitedFeatureUpdatesContext _localctx = new LimitedFeatureUpdatesContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_limitedFeatureUpdates);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			((LimitedFeatureUpdatesContext)_localctx).lbl_lfu = limitedFeatUpdate(new ArrayList());
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(466);
				match(T__23);
				setState(467);
				((LimitedFeatureUpdatesContext)_localctx).limitedFeatUpdate = limitedFeatUpdate(((LimitedFeatureUpdatesContext)_localctx).lbl_lfu.setOfAttributes);
				((LimitedFeatureUpdatesContext)_localctx).updates.add(((LimitedFeatureUpdatesContext)_localctx).limitedFeatUpdate);
				}
				}
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 
			            ((LimitedFeatureUpdatesContext)_localctx).ilcode =  "\r\n  " + ((LimitedFeatureUpdatesContext)_localctx).lbl_lfu.ilcode;
			            for ( LimitedFeatUpdateContext u : ((LimitedFeatureUpdatesContext)_localctx).updates )
						   _localctx.ilcode += "\r\n  " + u.ilcode;
			          
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

	public static class LimitedFeatUpdateContext extends ParserRuleContext {
		public ArrayList i_setOfAttributes;
		public String ilcode;
		public ArrayList setOfAttributes;
		public int i;
		public String existingName;
		public SettingLocationContext settingLocation;
		public SettingDecompositionContext settingDecomposition;
		public AttrAssignContext attrAssign;
		public SettingLocationContext settingLocation() {
			return getRuleContext(SettingLocationContext.class,0);
		}
		public SettingDecompositionContext settingDecomposition() {
			return getRuleContext(SettingDecompositionContext.class,0);
		}
		public AttrAssignContext attrAssign() {
			return getRuleContext(AttrAssignContext.class,0);
		}
		public LimitedFeatUpdateContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public LimitedFeatUpdateContext(ParserRuleContext parent, int invokingState, ArrayList i_setOfAttributes) {
			super(parent, invokingState);
			this.i_setOfAttributes = i_setOfAttributes;
		}
		@Override public int getRuleIndex() { return RULE_limitedFeatUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterLimitedFeatUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitLimitedFeatUpdate(this);
		}
	}

	public final LimitedFeatUpdateContext limitedFeatUpdate(ArrayList i_setOfAttributes) throws RecognitionException {
		LimitedFeatUpdateContext _localctx = new LimitedFeatUpdateContext(_ctx, getState(), i_setOfAttributes);
		enterRule(_localctx, 76, RULE_limitedFeatUpdate);
		try {
			setState(484);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
				((LimitedFeatUpdateContext)_localctx).settingLocation = settingLocation();

				            for (((LimitedFeatUpdateContext)_localctx).i = 0; _localctx.i < _localctx.i_setOfAttributes.size(); _localctx.i++)
				            {
				              ((LimitedFeatUpdateContext)_localctx).existingName =  (String) _localctx.i_setOfAttributes.get(_localctx.i);
				              if ( _localctx.existingName.equals("_parent") )
				              {
				                 // This means that location of the feature has already been updated, take necessary actions
				                 notifyErrorListeners(((LimitedFeatUpdateContext)_localctx).settingLocation.lineNo + ": location of the feature has already been updated");
				              }
				            }

				            ((LimitedFeatUpdateContext)_localctx).ilcode =  ((LimitedFeatUpdateContext)_localctx).settingLocation.ilcode;

				            ((LimitedFeatUpdateContext)_localctx).setOfAttributes =  _localctx.i_setOfAttributes;
				            _localctx.setOfAttributes.add("_parent");
				          
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(478);
				((LimitedFeatUpdateContext)_localctx).settingDecomposition = settingDecomposition();

				            for (((LimitedFeatUpdateContext)_localctx).i = 0; _localctx.i < _localctx.i_setOfAttributes.size(); _localctx.i++)
				            {
				              ((LimitedFeatUpdateContext)_localctx).existingName =  (String) _localctx.i_setOfAttributes.get(_localctx.i);
				              if ( _localctx.existingName.equals("_decomp") )
				              {
				                 // This means that decomposition relation of the feature has already been updated, take necessary actions
				                 notifyErrorListeners(((LimitedFeatUpdateContext)_localctx).settingDecomposition.lineNo + ": decomposition relation of the feature has already been updated");
				              }
				            }

				            ((LimitedFeatUpdateContext)_localctx).ilcode =  ((LimitedFeatUpdateContext)_localctx).settingDecomposition.ilcode;

				            ((LimitedFeatUpdateContext)_localctx).setOfAttributes =  _localctx.i_setOfAttributes;
				            _localctx.setOfAttributes.add("_decomp");
				          
				}
				break;
			case ATTRIBUTE_NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(481);
				((LimitedFeatUpdateContext)_localctx).attrAssign = attrAssign(i_setOfAttributes, 1);

				            ((LimitedFeatUpdateContext)_localctx).ilcode =  ((LimitedFeatUpdateContext)_localctx).attrAssign.ilcode;
				            ((LimitedFeatUpdateContext)_localctx).setOfAttributes =  ((LimitedFeatUpdateContext)_localctx).attrAssign.setOfAttributes;
				          
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ConstraintUpdatesContext extends ParserRuleContext {
		public String ilcode;
		public ConstUpdateContext constUpdate;
		public ConstUpdateContext lbl_cu1;
		public ConstUpdateContext lbl_cu2;
		public ConstUpdateContext lbl_cu3;
		public List<ConstUpdateContext> constUpdate() {
			return getRuleContexts(ConstUpdateContext.class);
		}
		public ConstUpdateContext constUpdate(int i) {
			return getRuleContext(ConstUpdateContext.class,i);
		}
		public ConstraintUpdatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintUpdates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterConstraintUpdates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitConstraintUpdates(this);
		}
	}

	public final ConstraintUpdatesContext constraintUpdates() throws RecognitionException {
		ConstraintUpdatesContext _localctx = new ConstraintUpdatesContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_constraintUpdates);
		try {
			setState(501);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(486);
				((ConstraintUpdatesContext)_localctx).constUpdate = constUpdate();
				 ((ConstraintUpdatesContext)_localctx).ilcode =  "\r\n  " + ((ConstraintUpdatesContext)_localctx).constUpdate.ilcode; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(489);
				((ConstraintUpdatesContext)_localctx).lbl_cu1 = constUpdate();
				setState(490);
				match(T__23);
				setState(491);
				((ConstraintUpdatesContext)_localctx).lbl_cu2 = constUpdate();

				            if ( ((ConstraintUpdatesContext)_localctx).lbl_cu1.updateType == ((ConstraintUpdatesContext)_localctx).lbl_cu2.updateType )
				            {
				               // This means that user tries to update the same thing twice, take necessary actions
							   notifyErrorListeners(((ConstraintUpdatesContext)_localctx).lbl_cu2.lineNo + ": an entity cannot be updated more than once in a single command");
				            }

				            ((ConstraintUpdatesContext)_localctx).ilcode =  "\r\n  " + ((ConstraintUpdatesContext)_localctx).lbl_cu1.ilcode + "\r\n  " + ((ConstraintUpdatesContext)_localctx).lbl_cu2.ilcode;
				          
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(494);
				((ConstraintUpdatesContext)_localctx).lbl_cu1 = constUpdate();
				setState(495);
				match(T__23);
				setState(496);
				((ConstraintUpdatesContext)_localctx).lbl_cu2 = constUpdate();
				setState(497);
				match(T__23);
				setState(498);
				((ConstraintUpdatesContext)_localctx).lbl_cu3 = constUpdate();

							if ( ((ConstraintUpdatesContext)_localctx).lbl_cu1.updateType == ((ConstraintUpdatesContext)_localctx).lbl_cu2.updateType )
				            {
				               // This means that user tries to update the same thing twice, take necessary actions
							   notifyErrorListeners(((ConstraintUpdatesContext)_localctx).lbl_cu2.lineNo + ": a cross-tree constraint part cannot be updated more than once in a single command (1st-2nd updates)");
				            }
							if ( ((ConstraintUpdatesContext)_localctx).lbl_cu1.updateType == ((ConstraintUpdatesContext)_localctx).lbl_cu3.updateType )
				            {
				               // This means that user tries to update the same thing twice, take necessary actions
							   notifyErrorListeners(((ConstraintUpdatesContext)_localctx).lbl_cu3.lineNo + ": a cross-tree constraint part cannot be updated more than once in a single command (1st-3rd updates)");
				            }
							if ( ((ConstraintUpdatesContext)_localctx).lbl_cu2.updateType == ((ConstraintUpdatesContext)_localctx).lbl_cu3.updateType )
				            {
				               // This means that user tries to update the same thing twice, take necessary actions
							   notifyErrorListeners(((ConstraintUpdatesContext)_localctx).lbl_cu3.lineNo + ": a cross-tree constraint part cannot be updated more than once in a single command (2nd-3rd updates)");
				            }

				            ((ConstraintUpdatesContext)_localctx).ilcode =  "\r\n  " + ((ConstraintUpdatesContext)_localctx).lbl_cu1.ilcode + "\r\n  " + ((ConstraintUpdatesContext)_localctx).lbl_cu2.ilcode + "\r\n  " + ((ConstraintUpdatesContext)_localctx).lbl_cu3.ilcode;
				          
				}
				break;
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

	public static class ConstUpdateContext extends ParserRuleContext {
		public String ilcode;
		public int updateType;
		public int lineNo;
		public FeatureNameDescriptionContext featureNameDescription;
		public BasicCrossTreeConstraintContext basicCrossTreeConstraint;
		public FeatureNameDescriptionContext featureNameDescription() {
			return getRuleContext(FeatureNameDescriptionContext.class,0);
		}
		public BasicCrossTreeConstraintContext basicCrossTreeConstraint() {
			return getRuleContext(BasicCrossTreeConstraintContext.class,0);
		}
		public ConstUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterConstUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitConstUpdate(this);
		}
	}

	public final ConstUpdateContext constUpdate() throws RecognitionException {
		ConstUpdateContext _localctx = new ConstUpdateContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_constUpdate);
		try {
			setState(518);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(503);
				match(T__32);
				setState(504);
				match(T__25);
				setState(505);
				((ConstUpdateContext)_localctx).featureNameDescription = featureNameDescription();

				            ((ConstUpdateContext)_localctx).ilcode =  "1" + " " + ((ConstUpdateContext)_localctx).featureNameDescription.ilcode;

				            ((ConstUpdateContext)_localctx).updateType =  1;

							((ConstUpdateContext)_localctx).lineNo =  _localctx.start.getLine();
				          
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(508);
				match(T__33);
				setState(509);
				match(T__25);
				setState(510);
				((ConstUpdateContext)_localctx).basicCrossTreeConstraint = basicCrossTreeConstraint();

				            ((ConstUpdateContext)_localctx).ilcode =  "2" + " " + ((ConstUpdateContext)_localctx).basicCrossTreeConstraint.ilcode;

				            ((ConstUpdateContext)_localctx).updateType =  2;

							((ConstUpdateContext)_localctx).lineNo =  _localctx.start.getLine();
				          
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 3);
				{
				setState(513);
				match(T__34);
				setState(514);
				match(T__25);
				setState(515);
				((ConstUpdateContext)_localctx).featureNameDescription = featureNameDescription();

				            ((ConstUpdateContext)_localctx).ilcode =  "3" + " " + ((ConstUpdateContext)_localctx).featureNameDescription.ilcode;

				            ((ConstUpdateContext)_localctx).updateType =  3;

							((ConstUpdateContext)_localctx).lineNo =  _localctx.start.getLine();
				          
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LimitedConstraintUpdatesContext extends ParserRuleContext {
		public String ilcode;
		public ConstUpdateContext constUpdate;
		public ConstUpdateContext lbl_cu1;
		public ConstUpdateContext lbl_cu2;
		public List<ConstUpdateContext> constUpdate() {
			return getRuleContexts(ConstUpdateContext.class);
		}
		public ConstUpdateContext constUpdate(int i) {
			return getRuleContext(ConstUpdateContext.class,i);
		}
		public LimitedConstraintUpdatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitedConstraintUpdates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterLimitedConstraintUpdates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitLimitedConstraintUpdates(this);
		}
	}

	public final LimitedConstraintUpdatesContext limitedConstraintUpdates() throws RecognitionException {
		LimitedConstraintUpdatesContext _localctx = new LimitedConstraintUpdatesContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_limitedConstraintUpdates);
		try {
			setState(528);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(520);
				((LimitedConstraintUpdatesContext)_localctx).constUpdate = constUpdate();
				 ((LimitedConstraintUpdatesContext)_localctx).ilcode =  "\r\n  " + ((LimitedConstraintUpdatesContext)_localctx).constUpdate.ilcode; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(523);
				((LimitedConstraintUpdatesContext)_localctx).lbl_cu1 = constUpdate();
				setState(524);
				match(T__23);
				setState(525);
				((LimitedConstraintUpdatesContext)_localctx).lbl_cu2 = constUpdate();

				            if ( ((LimitedConstraintUpdatesContext)_localctx).lbl_cu1.updateType == ((LimitedConstraintUpdatesContext)_localctx).lbl_cu2.updateType )
				            {
				               // This means that user tries to update the same thing twice, take necessary actions
							   notifyErrorListeners(((LimitedConstraintUpdatesContext)_localctx).lbl_cu2.lineNo + ": a cross-tree constraint part cannot be updated more than once in a single command");
				            }

				            ((LimitedConstraintUpdatesContext)_localctx).ilcode =  "\r\n  " + ((LimitedConstraintUpdatesContext)_localctx).lbl_cu1.ilcode + "\r\n  " + ((LimitedConstraintUpdatesContext)_localctx).lbl_cu2.ilcode;
				          
				}
				break;
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

	public static class DecompRelValueContext extends ParserRuleContext {
		public String ilcode;
		public int decRelType;
		public int lineNo;
		public FeatureDescriptionContext featureDescription;
		public FeatureDescriptionContext featureDescription() {
			return getRuleContext(FeatureDescriptionContext.class,0);
		}
		public DecompRelValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decompRelValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterDecompRelValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitDecompRelValue(this);
		}
	}

	public final DecompRelValueContext decompRelValue() throws RecognitionException {
		DecompRelValueContext _localctx = new DecompRelValueContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_decompRelValue);
		try {
			setState(543);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(530);
				match(T__3);
				 ((DecompRelValueContext)_localctx).ilcode =  "1";                                    ((DecompRelValueContext)_localctx).decRelType =  1; ((DecompRelValueContext)_localctx).lineNo =  _localctx.start.getLine(); 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(532);
				match(T__4);
				 ((DecompRelValueContext)_localctx).ilcode =  "2";                                    ((DecompRelValueContext)_localctx).decRelType =  2; ((DecompRelValueContext)_localctx).lineNo =  _localctx.start.getLine(); 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(534);
				match(T__5);
				 ((DecompRelValueContext)_localctx).ilcode =  "3";                                    ((DecompRelValueContext)_localctx).decRelType =  3; ((DecompRelValueContext)_localctx).lineNo =  _localctx.start.getLine(); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(536);
				match(T__7);
				 ((DecompRelValueContext)_localctx).ilcode =  "4";                                    ((DecompRelValueContext)_localctx).decRelType =  4; ((DecompRelValueContext)_localctx).lineNo =  _localctx.start.getLine(); 
				}
				break;
			case FEATURE_VAR:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(538);
				((DecompRelValueContext)_localctx).featureDescription = featureDescription();
				setState(539);
				match(T__18);
				setState(540);
				match(T__26);
				 ((DecompRelValueContext)_localctx).ilcode =  "5" + " " + ((DecompRelValueContext)_localctx).featureDescription.ilcode; ((DecompRelValueContext)_localctx).decRelType =  5; ((DecompRelValueContext)_localctx).lineNo =  _localctx.start.getLine(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class BasicCrossTreeConstraintContext extends ParserRuleContext {
		public String ilcode;
		public BasicCrossTreeConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicCrossTreeConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterBasicCrossTreeConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitBasicCrossTreeConstraint(this);
		}
	}

	public final BasicCrossTreeConstraintContext basicCrossTreeConstraint() throws RecognitionException {
		BasicCrossTreeConstraintContext _localctx = new BasicCrossTreeConstraintContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_basicCrossTreeConstraint);
		try {
			setState(549);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(545);
				match(T__35);
				 ((BasicCrossTreeConstraintContext)_localctx).ilcode =  "1"; 
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(547);
				match(T__36);
				 ((BasicCrossTreeConstraintContext)_localctx).ilcode =  "2"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ArithmeticExpressionContext extends ParserRuleContext {
		public String ilcode;
		public ArithmeticExpressionContext lbl_ae1;
		public ArithmeticOperandContext arithmeticOperand;
		public ArithmeticExpressionContext lbl_ae;
		public HighArithOpContext highArithOp;
		public ArithmeticExpressionContext lbl_ae2;
		public LowArithOpContext lowArithOp;
		public ArithmeticOperandContext arithmeticOperand() {
			return getRuleContext(ArithmeticOperandContext.class,0);
		}
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public HighArithOpContext highArithOp() {
			return getRuleContext(HighArithOpContext.class,0);
		}
		public LowArithOpContext lowArithOp() {
			return getRuleContext(LowArithOpContext.class,0);
		}
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterArithmeticExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitArithmeticExpression(this);
		}
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		return arithmeticExpression(0);
	}

	private ArithmeticExpressionContext arithmeticExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, _parentState);
		ArithmeticExpressionContext _prevctx = _localctx;
		int _startState = 88;
		enterRecursionRule(_localctx, 88, RULE_arithmeticExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			switch (_input.LA(1)) {
			case FEATURE_VAR:
			case INTEGER_LITERAL:
			case REAL_LITERAL:
			case STRING_LITERAL:
				{
				setState(552);
				((ArithmeticExpressionContext)_localctx).arithmeticOperand = arithmeticOperand();
				 ((ArithmeticExpressionContext)_localctx).ilcode =  ((ArithmeticExpressionContext)_localctx).arithmeticOperand.ilcode; 
				}
				break;
			case T__21:
				{
				setState(555);
				match(T__21);
				setState(556);
				((ArithmeticExpressionContext)_localctx).lbl_ae = arithmeticExpression(0);
				setState(557);
				match(T__22);
				 ((ArithmeticExpressionContext)_localctx).ilcode =  ((ArithmeticExpressionContext)_localctx).lbl_ae.ilcode; 
				}
				break;
			case T__37:
				{
				setState(560);
				match(T__37);
				setState(561);
				((ArithmeticExpressionContext)_localctx).lbl_ae = arithmeticExpression(3);
				 ((ArithmeticExpressionContext)_localctx).ilcode =  ((ArithmeticExpressionContext)_localctx).lbl_ae.ilcode + " " + "0 16"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(578);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(576);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionContext(_parentctx, _parentState);
						_localctx.lbl_ae1 = _prevctx;
						_localctx.lbl_ae1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(566);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(567);
						((ArithmeticExpressionContext)_localctx).highArithOp = highArithOp();
						setState(568);
						((ArithmeticExpressionContext)_localctx).lbl_ae2 = arithmeticExpression(3);
						 ((ArithmeticExpressionContext)_localctx).ilcode =  ((ArithmeticExpressionContext)_localctx).lbl_ae1.ilcode + " " + ((ArithmeticExpressionContext)_localctx).lbl_ae2.ilcode + " " + ((ArithmeticExpressionContext)_localctx).highArithOp.ilcode; 
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionContext(_parentctx, _parentState);
						_localctx.lbl_ae1 = _prevctx;
						_localctx.lbl_ae1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(571);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(572);
						((ArithmeticExpressionContext)_localctx).lowArithOp = lowArithOp();
						setState(573);
						((ArithmeticExpressionContext)_localctx).lbl_ae2 = arithmeticExpression(2);
						 ((ArithmeticExpressionContext)_localctx).ilcode =  ((ArithmeticExpressionContext)_localctx).lbl_ae1.ilcode + " " + ((ArithmeticExpressionContext)_localctx).lbl_ae2.ilcode + " " + ((ArithmeticExpressionContext)_localctx).lowArithOp.ilcode; 
						}
						break;
					}
					} 
				}
				setState(580);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArithmeticOperandContext extends ParserRuleContext {
		public String ilcode;
		public Token INTEGER_LITERAL;
		public Token REAL_LITERAL;
		public FeatureDescriptionContext featureDescription;
		public AttributeNameContext attributeName;
		public TerminalNode INTEGER_LITERAL() { return getToken(FeatherParser.INTEGER_LITERAL, 0); }
		public TerminalNode REAL_LITERAL() { return getToken(FeatherParser.REAL_LITERAL, 0); }
		public FeatureDescriptionContext featureDescription() {
			return getRuleContext(FeatureDescriptionContext.class,0);
		}
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public ArithmeticOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticOperand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterArithmeticOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitArithmeticOperand(this);
		}
	}

	public final ArithmeticOperandContext arithmeticOperand() throws RecognitionException {
		ArithmeticOperandContext _localctx = new ArithmeticOperandContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_arithmeticOperand);
		try {
			setState(590);
			switch (_input.LA(1)) {
			case INTEGER_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(581);
				((ArithmeticOperandContext)_localctx).INTEGER_LITERAL = match(INTEGER_LITERAL);
				 ((ArithmeticOperandContext)_localctx).ilcode =  "1" + " " + (((ArithmeticOperandContext)_localctx).INTEGER_LITERAL!=null?((ArithmeticOperandContext)_localctx).INTEGER_LITERAL.getText():null); 
				}
				break;
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(583);
				((ArithmeticOperandContext)_localctx).REAL_LITERAL = match(REAL_LITERAL);
				 ((ArithmeticOperandContext)_localctx).ilcode =  "2" + " " + (((ArithmeticOperandContext)_localctx).REAL_LITERAL!=null?((ArithmeticOperandContext)_localctx).REAL_LITERAL.getText():null); 
				}
				break;
			case FEATURE_VAR:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(585);
				((ArithmeticOperandContext)_localctx).featureDescription = featureDescription();
				setState(586);
				match(T__18);
				setState(587);
				((ArithmeticOperandContext)_localctx).attributeName = attributeName();
				 ((ArithmeticOperandContext)_localctx).ilcode =  "5" + " " + ((ArithmeticOperandContext)_localctx).featureDescription.ilcode + " " + (((ArithmeticOperandContext)_localctx).attributeName!=null?_input.getText(((ArithmeticOperandContext)_localctx).attributeName.start,((ArithmeticOperandContext)_localctx).attributeName.stop):null); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class HighArithOpContext extends ParserRuleContext {
		public String ilcode;
		public HighArithOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_highArithOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterHighArithOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitHighArithOp(this);
		}
	}

	public final HighArithOpContext highArithOp() throws RecognitionException {
		HighArithOpContext _localctx = new HighArithOpContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_highArithOp);
		try {
			setState(598);
			switch (_input.LA(1)) {
			case T__38:
				enterOuterAlt(_localctx, 1);
				{
				setState(592);
				match(T__38);
				 ((HighArithOpContext)_localctx).ilcode =  "0 13"; 
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 2);
				{
				setState(594);
				match(T__39);
				 ((HighArithOpContext)_localctx).ilcode =  "0 14"; 
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 3);
				{
				setState(596);
				match(T__40);
				 ((HighArithOpContext)_localctx).ilcode =  "0 15"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LowArithOpContext extends ParserRuleContext {
		public String ilcode;
		public LowArithOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowArithOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterLowArithOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitLowArithOp(this);
		}
	}

	public final LowArithOpContext lowArithOp() throws RecognitionException {
		LowArithOpContext _localctx = new LowArithOpContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_lowArithOp);
		try {
			setState(604);
			switch (_input.LA(1)) {
			case T__41:
				enterOuterAlt(_localctx, 1);
				{
				setState(600);
				match(T__41);
				 ((LowArithOpContext)_localctx).ilcode =  "0 11"; 
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 2);
				{
				setState(602);
				match(T__37);
				 ((LowArithOpContext)_localctx).ilcode =  "0 12"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class BooleanExpressionContext extends ParserRuleContext {
		public String ilcode;
		public BooleanExpressionContext lbl_be1;
		public BooleanOperandContext booleanOperand;
		public BooleanExpressionContext lbl_be;
		public BooleanExpressionContext lbl_be2;
		public BooleanOperandContext booleanOperand() {
			return getRuleContext(BooleanOperandContext.class,0);
		}
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitBooleanExpression(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		return booleanExpression(0);
	}

	private BooleanExpressionContext booleanExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, _parentState);
		BooleanExpressionContext _prevctx = _localctx;
		int _startState = 96;
		enterRecursionRule(_localctx, 96, RULE_booleanExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(607);
				((BooleanExpressionContext)_localctx).booleanOperand = booleanOperand();
				 ((BooleanExpressionContext)_localctx).ilcode =  ((BooleanExpressionContext)_localctx).booleanOperand.ilcode; 
				}
				break;
			case 2:
				{
				setState(610);
				match(T__21);
				setState(611);
				((BooleanExpressionContext)_localctx).lbl_be = booleanExpression(0);
				setState(612);
				match(T__22);
				 ((BooleanExpressionContext)_localctx).ilcode =  ((BooleanExpressionContext)_localctx).lbl_be.ilcode; 
				}
				break;
			case 3:
				{
				setState(615);
				match(T__42);
				setState(616);
				((BooleanExpressionContext)_localctx).lbl_be = booleanExpression(3);
				 ((BooleanExpressionContext)_localctx).ilcode =  ((BooleanExpressionContext)_localctx).lbl_be.ilcode + " " + "0 33"; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(633);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(631);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new BooleanExpressionContext(_parentctx, _parentState);
						_localctx.lbl_be1 = _prevctx;
						_localctx.lbl_be1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(621);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(622);
						match(T__43);
						setState(623);
						((BooleanExpressionContext)_localctx).lbl_be2 = booleanExpression(3);
						 ((BooleanExpressionContext)_localctx).ilcode =  ((BooleanExpressionContext)_localctx).lbl_be1.ilcode + " " + ((BooleanExpressionContext)_localctx).lbl_be2.ilcode + " " + "0 31"; 
						}
						break;
					case 2:
						{
						_localctx = new BooleanExpressionContext(_parentctx, _parentState);
						_localctx.lbl_be1 = _prevctx;
						_localctx.lbl_be1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(626);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(627);
						match(T__7);
						setState(628);
						((BooleanExpressionContext)_localctx).lbl_be2 = booleanExpression(2);
						 ((BooleanExpressionContext)_localctx).ilcode =  ((BooleanExpressionContext)_localctx).lbl_be1.ilcode + " " + ((BooleanExpressionContext)_localctx).lbl_be2.ilcode + " " + "0 32"; 
						}
						break;
					}
					} 
				}
				setState(635);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BooleanOperandContext extends ParserRuleContext {
		public String ilcode;
		public Bool_literalContext bool_literal;
		public FeatureDescriptionContext featureDescription;
		public AttributeNameContext attributeName;
		public StringEqualityCheckContext stringEqualityCheck;
		public DecompRelTypeCheckContext decompRelTypeCheck;
		public DecompRelIDCheckContext decompRelIDCheck;
		public ArithmeticExpressionContext lbl_ae1;
		public RelOpContext relOp;
		public ArithmeticExpressionContext lbl_ae2;
		public BooleanEqualityCheckContext booleanEqualityCheck;
		public Bool_literalContext bool_literal() {
			return getRuleContext(Bool_literalContext.class,0);
		}
		public FeatureDescriptionContext featureDescription() {
			return getRuleContext(FeatureDescriptionContext.class,0);
		}
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public StringEqualityCheckContext stringEqualityCheck() {
			return getRuleContext(StringEqualityCheckContext.class,0);
		}
		public DecompRelTypeCheckContext decompRelTypeCheck() {
			return getRuleContext(DecompRelTypeCheckContext.class,0);
		}
		public DecompRelIDCheckContext decompRelIDCheck() {
			return getRuleContext(DecompRelIDCheckContext.class,0);
		}
		public RelOpContext relOp() {
			return getRuleContext(RelOpContext.class,0);
		}
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public BooleanEqualityCheckContext booleanEqualityCheck() {
			return getRuleContext(BooleanEqualityCheckContext.class,0);
		}
		public BooleanOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanOperand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterBooleanOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitBooleanOperand(this);
		}
	}

	public final BooleanOperandContext booleanOperand() throws RecognitionException {
		BooleanOperandContext _localctx = new BooleanOperandContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_booleanOperand);
		try {
			setState(661);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(636);
				((BooleanOperandContext)_localctx).bool_literal = bool_literal();
				 ((BooleanOperandContext)_localctx).ilcode =   "3" + " " + ((BooleanOperandContext)_localctx).bool_literal.ilcode; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(639);
				((BooleanOperandContext)_localctx).featureDescription = featureDescription();
				setState(640);
				match(T__18);
				setState(641);
				((BooleanOperandContext)_localctx).attributeName = attributeName();
				 ((BooleanOperandContext)_localctx).ilcode =   "5" + " " + ((BooleanOperandContext)_localctx).featureDescription.ilcode + " " + (((BooleanOperandContext)_localctx).attributeName!=null?_input.getText(((BooleanOperandContext)_localctx).attributeName.start,((BooleanOperandContext)_localctx).attributeName.stop):null); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(644);
				((BooleanOperandContext)_localctx).stringEqualityCheck = stringEqualityCheck();
				 ((BooleanOperandContext)_localctx).ilcode =   "6" + " " + ((BooleanOperandContext)_localctx).stringEqualityCheck.ilcode; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(647);
				((BooleanOperandContext)_localctx).decompRelTypeCheck = decompRelTypeCheck();
				 ((BooleanOperandContext)_localctx).ilcode =   "7" + " " + ((BooleanOperandContext)_localctx).decompRelTypeCheck.ilcode; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(650);
				((BooleanOperandContext)_localctx).decompRelIDCheck = decompRelIDCheck();
				 ((BooleanOperandContext)_localctx).ilcode =   "8" + " " + ((BooleanOperandContext)_localctx).decompRelIDCheck.ilcode; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(653);
				((BooleanOperandContext)_localctx).lbl_ae1 = arithmeticExpression(0);
				setState(654);
				((BooleanOperandContext)_localctx).relOp = relOp();
				setState(655);
				((BooleanOperandContext)_localctx).lbl_ae2 = arithmeticExpression(0);
				 ((BooleanOperandContext)_localctx).ilcode =   "9" + " " + ((BooleanOperandContext)_localctx).lbl_ae1.ilcode + " " + ((BooleanOperandContext)_localctx).lbl_ae2.ilcode + " " + ((BooleanOperandContext)_localctx).relOp.ilcode; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(658);
				((BooleanOperandContext)_localctx).booleanEqualityCheck = booleanEqualityCheck();
				 ((BooleanOperandContext)_localctx).ilcode =  "10" + " " + ((BooleanOperandContext)_localctx).booleanEqualityCheck.ilcode; 
				}
				break;
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

	public static class RelOpContext extends ParserRuleContext {
		public String ilcode;
		public RelOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterRelOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitRelOp(this);
		}
	}

	public final RelOpContext relOp() throws RecognitionException {
		RelOpContext _localctx = new RelOpContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_relOp);
		try {
			setState(675);
			switch (_input.LA(1)) {
			case T__44:
				enterOuterAlt(_localctx, 1);
				{
				setState(663);
				match(T__44);
				 ((RelOpContext)_localctx).ilcode =  "0 21"; 
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 2);
				{
				setState(665);
				match(T__45);
				 ((RelOpContext)_localctx).ilcode =  "0 22"; 
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 3);
				{
				setState(667);
				match(T__46);
				 ((RelOpContext)_localctx).ilcode =  "0 23"; 
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 4);
				{
				setState(669);
				match(T__47);
				 ((RelOpContext)_localctx).ilcode =  "0 24"; 
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 5);
				{
				setState(671);
				match(T__25);
				 ((RelOpContext)_localctx).ilcode =  "0 25"; 
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 6);
				{
				setState(673);
				match(T__48);
				 ((RelOpContext)_localctx).ilcode =  "0 26"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class StringEqualityCheckContext extends ParserRuleContext {
		public String ilcode;
		public StringOperandContext lbl_so1;
		public EqCheckOpContext eqCheckOp;
		public StringOperandContext lbl_so2;
		public EqCheckOpContext eqCheckOp() {
			return getRuleContext(EqCheckOpContext.class,0);
		}
		public List<StringOperandContext> stringOperand() {
			return getRuleContexts(StringOperandContext.class);
		}
		public StringOperandContext stringOperand(int i) {
			return getRuleContext(StringOperandContext.class,i);
		}
		public StringEqualityCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringEqualityCheck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterStringEqualityCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitStringEqualityCheck(this);
		}
	}

	public final StringEqualityCheckContext stringEqualityCheck() throws RecognitionException {
		StringEqualityCheckContext _localctx = new StringEqualityCheckContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_stringEqualityCheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
			((StringEqualityCheckContext)_localctx).lbl_so1 = stringOperand();
			setState(678);
			((StringEqualityCheckContext)_localctx).eqCheckOp = eqCheckOp();
			setState(679);
			((StringEqualityCheckContext)_localctx).lbl_so2 = stringOperand();
			 ((StringEqualityCheckContext)_localctx).ilcode =  ((StringEqualityCheckContext)_localctx).lbl_so1.ilcode + " " + ((StringEqualityCheckContext)_localctx).lbl_so2.ilcode + " " + ((StringEqualityCheckContext)_localctx).eqCheckOp.ilcode; 
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

	public static class StringOperandContext extends ParserRuleContext {
		public String ilcode;
		public Token STRING_LITERAL;
		public FeatureDescriptionContext featureDescription;
		public AttributeNameContext attributeName;
		public TerminalNode STRING_LITERAL() { return getToken(FeatherParser.STRING_LITERAL, 0); }
		public FeatureDescriptionContext featureDescription() {
			return getRuleContext(FeatureDescriptionContext.class,0);
		}
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public StringOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringOperand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterStringOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitStringOperand(this);
		}
	}

	public final StringOperandContext stringOperand() throws RecognitionException {
		StringOperandContext _localctx = new StringOperandContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_stringOperand);
		try {
			setState(699);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(682);
				((StringOperandContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
				 ((StringOperandContext)_localctx).ilcode =  "4" + " " + (((StringOperandContext)_localctx).STRING_LITERAL!=null?((StringOperandContext)_localctx).STRING_LITERAL.getText():null); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(684);
				((StringOperandContext)_localctx).featureDescription = featureDescription();
				setState(685);
				match(T__18);
				setState(686);
				match(T__19);
				 ((StringOperandContext)_localctx).ilcode =  "1" + " " + ((StringOperandContext)_localctx).featureDescription.ilcode; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(689);
				((StringOperandContext)_localctx).featureDescription = featureDescription();
				setState(690);
				match(T__18);
				setState(691);
				match(T__24);
				 ((StringOperandContext)_localctx).ilcode =  "2" + " " + ((StringOperandContext)_localctx).featureDescription.ilcode; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(694);
				((StringOperandContext)_localctx).featureDescription = featureDescription();
				setState(695);
				match(T__18);
				setState(696);
				((StringOperandContext)_localctx).attributeName = attributeName();
				 ((StringOperandContext)_localctx).ilcode =  "5" + " " + ((StringOperandContext)_localctx).featureDescription.ilcode + " " + (((StringOperandContext)_localctx).attributeName!=null?_input.getText(((StringOperandContext)_localctx).attributeName.start,((StringOperandContext)_localctx).attributeName.stop):null); 
				}
				break;
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

	public static class EqCheckOpContext extends ParserRuleContext {
		public String ilcode;
		public EqCheckOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqCheckOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterEqCheckOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitEqCheckOp(this);
		}
	}

	public final EqCheckOpContext eqCheckOp() throws RecognitionException {
		EqCheckOpContext _localctx = new EqCheckOpContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_eqCheckOp);
		try {
			setState(705);
			switch (_input.LA(1)) {
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(701);
				match(T__25);
				 ((EqCheckOpContext)_localctx).ilcode =  "0 25"; 
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 2);
				{
				setState(703);
				match(T__48);
				 ((EqCheckOpContext)_localctx).ilcode =  "0 26"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DecompRelTypeCheckContext extends ParserRuleContext {
		public String ilcode;
		public DecompRelValueContext lbl_drv1;
		public EqCheckOpContext eqCheckOp;
		public DecompRelValueContext lbl_drv2;
		public EqCheckOpContext eqCheckOp() {
			return getRuleContext(EqCheckOpContext.class,0);
		}
		public List<DecompRelValueContext> decompRelValue() {
			return getRuleContexts(DecompRelValueContext.class);
		}
		public DecompRelValueContext decompRelValue(int i) {
			return getRuleContext(DecompRelValueContext.class,i);
		}
		public DecompRelTypeCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decompRelTypeCheck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterDecompRelTypeCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitDecompRelTypeCheck(this);
		}
	}

	public final DecompRelTypeCheckContext decompRelTypeCheck() throws RecognitionException {
		DecompRelTypeCheckContext _localctx = new DecompRelTypeCheckContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_decompRelTypeCheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
			((DecompRelTypeCheckContext)_localctx).lbl_drv1 = decompRelValue();
			setState(708);
			((DecompRelTypeCheckContext)_localctx).eqCheckOp = eqCheckOp();
			setState(709);
			((DecompRelTypeCheckContext)_localctx).lbl_drv2 = decompRelValue();
			 ((DecompRelTypeCheckContext)_localctx).ilcode =  ((DecompRelTypeCheckContext)_localctx).lbl_drv1.ilcode + " " + ((DecompRelTypeCheckContext)_localctx).lbl_drv2.ilcode + " " + ((DecompRelTypeCheckContext)_localctx).eqCheckOp.ilcode; 
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

	public static class DecompRelIDCheckContext extends ParserRuleContext {
		public String ilcode;
		public FeatureDescriptionContext lbl_fd1;
		public EqCheckOpContext eqCheckOp;
		public FeatureDescriptionContext lbl_fd2;
		public EqCheckOpContext eqCheckOp() {
			return getRuleContext(EqCheckOpContext.class,0);
		}
		public List<FeatureDescriptionContext> featureDescription() {
			return getRuleContexts(FeatureDescriptionContext.class);
		}
		public FeatureDescriptionContext featureDescription(int i) {
			return getRuleContext(FeatureDescriptionContext.class,i);
		}
		public DecompRelIDCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decompRelIDCheck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterDecompRelIDCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitDecompRelIDCheck(this);
		}
	}

	public final DecompRelIDCheckContext decompRelIDCheck() throws RecognitionException {
		DecompRelIDCheckContext _localctx = new DecompRelIDCheckContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_decompRelIDCheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(712);
			((DecompRelIDCheckContext)_localctx).lbl_fd1 = featureDescription();
			setState(713);
			match(T__18);
			setState(714);
			match(T__49);
			setState(715);
			((DecompRelIDCheckContext)_localctx).eqCheckOp = eqCheckOp();
			setState(716);
			((DecompRelIDCheckContext)_localctx).lbl_fd2 = featureDescription();
			setState(717);
			match(T__18);
			setState(718);
			match(T__49);
			 ((DecompRelIDCheckContext)_localctx).ilcode =  ((DecompRelIDCheckContext)_localctx).lbl_fd1.ilcode + " " + ((DecompRelIDCheckContext)_localctx).lbl_fd2.ilcode + " " + ((DecompRelIDCheckContext)_localctx).eqCheckOp.ilcode; 
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

	public static class BooleanEqualityCheckContext extends ParserRuleContext {
		public String ilcode;
		public BoolEqOperandContext lbl_bo1;
		public EqCheckOpContext eqCheckOp;
		public BoolEqOperandContext lbl_bo2;
		public EqCheckOpContext eqCheckOp() {
			return getRuleContext(EqCheckOpContext.class,0);
		}
		public List<BoolEqOperandContext> boolEqOperand() {
			return getRuleContexts(BoolEqOperandContext.class);
		}
		public BoolEqOperandContext boolEqOperand(int i) {
			return getRuleContext(BoolEqOperandContext.class,i);
		}
		public BooleanEqualityCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanEqualityCheck; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterBooleanEqualityCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitBooleanEqualityCheck(this);
		}
	}

	public final BooleanEqualityCheckContext booleanEqualityCheck() throws RecognitionException {
		BooleanEqualityCheckContext _localctx = new BooleanEqualityCheckContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_booleanEqualityCheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
			((BooleanEqualityCheckContext)_localctx).lbl_bo1 = boolEqOperand();
			setState(722);
			((BooleanEqualityCheckContext)_localctx).eqCheckOp = eqCheckOp();
			setState(723);
			((BooleanEqualityCheckContext)_localctx).lbl_bo2 = boolEqOperand();
			 ((BooleanEqualityCheckContext)_localctx).ilcode =  ((BooleanEqualityCheckContext)_localctx).lbl_bo1.ilcode + " " + ((BooleanEqualityCheckContext)_localctx).lbl_bo2.ilcode + " " + ((BooleanEqualityCheckContext)_localctx).eqCheckOp.ilcode; 
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

	public static class BoolEqOperandContext extends ParserRuleContext {
		public String ilcode;
		public Bool_literalContext bool_literal;
		public FeatureDescriptionContext featureDescription;
		public AttributeNameContext attributeName;
		public Bool_literalContext bool_literal() {
			return getRuleContext(Bool_literalContext.class,0);
		}
		public FeatureDescriptionContext featureDescription() {
			return getRuleContext(FeatureDescriptionContext.class,0);
		}
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public BoolEqOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolEqOperand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterBoolEqOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitBoolEqOperand(this);
		}
	}

	public final BoolEqOperandContext boolEqOperand() throws RecognitionException {
		BoolEqOperandContext _localctx = new BoolEqOperandContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_boolEqOperand);
		try {
			setState(734);
			switch (_input.LA(1)) {
			case T__50:
			case T__51:
				enterOuterAlt(_localctx, 1);
				{
				setState(726);
				((BoolEqOperandContext)_localctx).bool_literal = bool_literal();
				 ((BoolEqOperandContext)_localctx).ilcode =  "3" + " " + ((BoolEqOperandContext)_localctx).bool_literal.ilcode; 
				}
				break;
			case FEATURE_VAR:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(729);
				((BoolEqOperandContext)_localctx).featureDescription = featureDescription();
				setState(730);
				match(T__18);
				setState(731);
				((BoolEqOperandContext)_localctx).attributeName = attributeName();
				 ((BoolEqOperandContext)_localctx).ilcode =  "5" + " " + ((BoolEqOperandContext)_localctx).featureDescription.ilcode + " " + (((BoolEqOperandContext)_localctx).attributeName!=null?_input.getText(((BoolEqOperandContext)_localctx).attributeName.start,((BoolEqOperandContext)_localctx).attributeName.stop):null); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FeatureNameContext extends ParserRuleContext {
		public int lineNo;
		public int posNo;
		public Token STRING_LITERAL;
		public TerminalNode STRING_LITERAL() { return getToken(FeatherParser.STRING_LITERAL, 0); }
		public FeatureNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterFeatureName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitFeatureName(this);
		}
	}

	public final FeatureNameContext featureName() throws RecognitionException {
		FeatureNameContext _localctx = new FeatureNameContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_featureName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(736);
			((FeatureNameContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
			 ((FeatureNameContext)_localctx).lineNo =  (((FeatureNameContext)_localctx).STRING_LITERAL!=null?((FeatureNameContext)_localctx).STRING_LITERAL.getLine():0); ((FeatureNameContext)_localctx).posNo =  (((FeatureNameContext)_localctx).STRING_LITERAL!=null?((FeatureNameContext)_localctx).STRING_LITERAL.getCharPositionInLine():0) + 1; 
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

	public static class ParentNameContext extends ParserRuleContext {
		public int lineNo;
		public int posNo;
		public Token STRING_LITERAL;
		public TerminalNode STRING_LITERAL() { return getToken(FeatherParser.STRING_LITERAL, 0); }
		public ParentNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterParentName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitParentName(this);
		}
	}

	public final ParentNameContext parentName() throws RecognitionException {
		ParentNameContext _localctx = new ParentNameContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_parentName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(739);
			((ParentNameContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
			 ((ParentNameContext)_localctx).lineNo =  (((ParentNameContext)_localctx).STRING_LITERAL!=null?((ParentNameContext)_localctx).STRING_LITERAL.getLine():0); ((ParentNameContext)_localctx).posNo =  (((ParentNameContext)_localctx).STRING_LITERAL!=null?((ParentNameContext)_localctx).STRING_LITERAL.getCharPositionInLine():0) + 1; 
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

	public static class AttributeNameContext extends ParserRuleContext {
		public int lineNo;
		public int posNo;
		public Token ATTRIBUTE_NAME;
		public TerminalNode ATTRIBUTE_NAME() { return getToken(FeatherParser.ATTRIBUTE_NAME, 0); }
		public AttributeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterAttributeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitAttributeName(this);
		}
	}

	public final AttributeNameContext attributeName() throws RecognitionException {
		AttributeNameContext _localctx = new AttributeNameContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_attributeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(742);
			((AttributeNameContext)_localctx).ATTRIBUTE_NAME = match(ATTRIBUTE_NAME);
			 ((AttributeNameContext)_localctx).lineNo =  (((AttributeNameContext)_localctx).ATTRIBUTE_NAME!=null?((AttributeNameContext)_localctx).ATTRIBUTE_NAME.getLine():0); ((AttributeNameContext)_localctx).posNo =  (((AttributeNameContext)_localctx).ATTRIBUTE_NAME!=null?((AttributeNameContext)_localctx).ATTRIBUTE_NAME.getCharPositionInLine():0) + 1; 
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

	public static class FeatureVarContext extends ParserRuleContext {
		public int lineNo;
		public int posNo;
		public Token FEATURE_VAR;
		public TerminalNode FEATURE_VAR() { return getToken(FeatherParser.FEATURE_VAR, 0); }
		public FeatureVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterFeatureVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitFeatureVar(this);
		}
	}

	public final FeatureVarContext featureVar() throws RecognitionException {
		FeatureVarContext _localctx = new FeatureVarContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_featureVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			((FeatureVarContext)_localctx).FEATURE_VAR = match(FEATURE_VAR);
			 ((FeatureVarContext)_localctx).lineNo =  (((FeatureVarContext)_localctx).FEATURE_VAR!=null?((FeatureVarContext)_localctx).FEATURE_VAR.getLine():0); ((FeatureVarContext)_localctx).posNo =  (((FeatureVarContext)_localctx).FEATURE_VAR!=null?((FeatureVarContext)_localctx).FEATURE_VAR.getCharPositionInLine():0) + 1; 
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

	public static class Bool_literalContext extends ParserRuleContext {
		public String ilcode;
		public Bool_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).enterBool_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FeatherListener ) ((FeatherListener)listener).exitBool_literal(this);
		}
	}

	public final Bool_literalContext bool_literal() throws RecognitionException {
		Bool_literalContext _localctx = new Bool_literalContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_bool_literal);
		try {
			setState(752);
			switch (_input.LA(1)) {
			case T__50:
				enterOuterAlt(_localctx, 1);
				{
				setState(748);
				match(T__50);
				 ((Bool_literalContext)_localctx).ilcode =  "1"; 
				}
				break;
			case T__51:
				enterOuterAlt(_localctx, 2);
				{
				setState(750);
				match(T__51);
				 ((Bool_literalContext)_localctx).ilcode =  "0"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 44:
			return arithmeticExpression_sempred((ArithmeticExpressionContext)_localctx, predIndex);
		case 48:
			return booleanExpression_sempred((BooleanExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithmeticExpression_sempred(ArithmeticExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean booleanExpression_sempred(BooleanExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u02f5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\7\4\u008b\n"+
		"\4\f\4\16\4\u008e\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\5\7\u00ae\n\7\3\b\7\b\u00b1\n\b\f\b\16\b\u00b4\13\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c6\n\n\3\13\7"+
		"\13\u00c9\n\13\f\13\16\13\u00cc\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\6\r\u00d8\n\r\r\r\16\r\u00d9\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00fc"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u0155\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\5\32\u015f\n\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u016b\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\5\36\u017d\n\36\3\37\3\37\3\37\3\37\3\37\3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0190\n \3!\3!\7!\u0194\n!\f!\16"+
		"!\u0197\13!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u01b5\n#\3$\3$\3$\7$\u01ba\n$\f$\16"+
		"$\u01bd\13$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u01cd\n%\3&\3"+
		"&\3&\3&\3&\3\'\3\'\3\'\7\'\u01d7\n\'\f\'\16\'\u01da\13\'\3\'\3\'\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\5(\u01e7\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\5)\u01f8\n)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5"+
		"*\u0209\n*\3+\3+\3+\3+\3+\3+\3+\3+\5+\u0213\n+\3,\3,\3,\3,\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\5,\u0222\n,\3-\3-\3-\3-\5-\u0228\n-\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\5.\u0237\n.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\7.\u0243"+
		"\n.\f.\16.\u0246\13.\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u0251\n/\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\5\60\u0259\n\60\3\61\3\61\3\61\3\61\5\61\u025f\n"+
		"\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5"+
		"\62\u026e\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62"+
		"\u027a\n\62\f\62\16\62\u027d\13\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\5\63\u0298\n\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\5\64\u02a6\n\64\3\65\3\65\3\65\3\65\3\65\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\5\66\u02be\n\66\3\67\3\67\3\67\3\67\5\67\u02c4\n\67\38\38\3"+
		"8\38\38\39\39\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3"+
		";\3;\5;\u02e1\n;\3<\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3?\3@\3@\3@\3@\5@\u02f3"+
		"\n@\3@\2\4ZbA\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\2\2\u0300\2\u0080\3\2\2\2\4\u0084"+
		"\3\2\2\2\6\u0088\3\2\2\2\b\u0091\3\2\2\2\n\u0097\3\2\2\2\f\u00ad\3\2\2"+
		"\2\16\u00b2\3\2\2\2\20\u00b7\3\2\2\2\22\u00c5\3\2\2\2\24\u00ca\3\2\2\2"+
		"\26\u00cf\3\2\2\2\30\u00d7\3\2\2\2\32\u00fb\3\2\2\2\34\u00fd\3\2\2\2\36"+
		"\u0107\3\2\2\2 \u0110\3\2\2\2\"\u0119\3\2\2\2$\u0120\3\2\2\2&\u0127\3"+
		"\2\2\2(\u012e\3\2\2\2*\u0137\3\2\2\2,\u0140\3\2\2\2.\u0147\3\2\2\2\60"+
		"\u0154\3\2\2\2\62\u015e\3\2\2\2\64\u0160\3\2\2\2\66\u016a\3\2\2\28\u016c"+
		"\3\2\2\2:\u017c\3\2\2\2<\u017e\3\2\2\2>\u018f\3\2\2\2@\u0195\3\2\2\2B"+
		"\u019a\3\2\2\2D\u01b4\3\2\2\2F\u01b6\3\2\2\2H\u01cc\3\2\2\2J\u01ce\3\2"+
		"\2\2L\u01d3\3\2\2\2N\u01e6\3\2\2\2P\u01f7\3\2\2\2R\u0208\3\2\2\2T\u0212"+
		"\3\2\2\2V\u0221\3\2\2\2X\u0227\3\2\2\2Z\u0236\3\2\2\2\\\u0250\3\2\2\2"+
		"^\u0258\3\2\2\2`\u025e\3\2\2\2b\u026d\3\2\2\2d\u0297\3\2\2\2f\u02a5\3"+
		"\2\2\2h\u02a7\3\2\2\2j\u02bd\3\2\2\2l\u02c3\3\2\2\2n\u02c5\3\2\2\2p\u02ca"+
		"\3\2\2\2r\u02d3\3\2\2\2t\u02e0\3\2\2\2v\u02e2\3\2\2\2x\u02e5\3\2\2\2z"+
		"\u02e8\3\2\2\2|\u02eb\3\2\2\2~\u02f2\3\2\2\2\u0080\u0081\5\4\3\2\u0081"+
		"\u0082\5\30\r\2\u0082\u0083\b\2\1\2\u0083\3\3\2\2\2\u0084\u0085\5\6\4"+
		"\2\u0085\u0086\5\24\13\2\u0086\u0087\b\3\1\2\u0087\5\3\2\2\2\u0088\u008c"+
		"\5\b\5\2\u0089\u008b\5\n\6\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008f\u0090\b\4\1\2\u0090\7\3\2\2\2\u0091\u0092\7\3\2\2\u0092\u0093"+
		"\5v<\2\u0093\u0094\5\16\b\2\u0094\u0095\7\4\2\2\u0095\u0096\b\5\1\2\u0096"+
		"\t\3\2\2\2\u0097\u0098\7\5\2\2\u0098\u0099\5v<\2\u0099\u009a\5x=\2\u009a"+
		"\u009b\5\f\7\2\u009b\u009c\5\16\b\2\u009c\u009d\7\4\2\2\u009d\u009e\b"+
		"\6\1\2\u009e\13\3\2\2\2\u009f\u00a0\7\6\2\2\u00a0\u00ae\b\7\1\2\u00a1"+
		"\u00a2\7\7\2\2\u00a2\u00ae\b\7\1\2\u00a3\u00a4\7\b\2\2\u00a4\u00a5\7\t"+
		"\2\2\u00a5\u00a6\5v<\2\u00a6\u00a7\b\7\1\2\u00a7\u00ae\3\2\2\2\u00a8\u00a9"+
		"\7\n\2\2\u00a9\u00aa\7\t\2\2\u00aa\u00ab\5v<\2\u00ab\u00ac\b\7\1\2\u00ac"+
		"\u00ae\3\2\2\2\u00ad\u009f\3\2\2\2\u00ad\u00a1\3\2\2\2\u00ad\u00a3\3\2"+
		"\2\2\u00ad\u00a8\3\2\2\2\u00ae\r\3\2\2\2\u00af\u00b1\5\20\t\2\u00b0\u00af"+
		"\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\b\b\1\2\u00b6\17\3\2\2"+
		"\2\u00b7\u00b8\7\13\2\2\u00b8\u00b9\5z>\2\u00b9\u00ba\5\22\n\2\u00ba\u00bb"+
		"\b\t\1\2\u00bb\21\3\2\2\2\u00bc\u00bd\5~@\2\u00bd\u00be\b\n\1\2\u00be"+
		"\u00c6\3\2\2\2\u00bf\u00c0\79\2\2\u00c0\u00c6\b\n\1\2\u00c1\u00c2\7:\2"+
		"\2\u00c2\u00c6\b\n\1\2\u00c3\u00c4\7;\2\2\u00c4\u00c6\b\n\1\2\u00c5\u00bc"+
		"\3\2\2\2\u00c5\u00bf\3\2\2\2\u00c5\u00c1\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\23\3\2\2\2\u00c7\u00c9\5\26\f\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2"+
		"\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca"+
		"\3\2\2\2\u00cd\u00ce\b\13\1\2\u00ce\25\3\2\2\2\u00cf\u00d0\7\f\2\2\u00d0"+
		"\u00d1\5v<\2\u00d1\u00d2\5X-\2\u00d2\u00d3\5v<\2\u00d3\u00d4\7\4\2\2\u00d4"+
		"\u00d5\b\f\1\2\u00d5\27\3\2\2\2\u00d6\u00d8\5\32\16\2\u00d7\u00d6\3\2"+
		"\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dc\b\r\1\2\u00dc\31\3\2\2\2\u00dd\u00de\5\34\17"+
		"\2\u00de\u00df\b\16\1\2\u00df\u00fc\3\2\2\2\u00e0\u00e1\5\36\20\2\u00e1"+
		"\u00e2\b\16\1\2\u00e2\u00fc\3\2\2\2\u00e3\u00e4\5 \21\2\u00e4\u00e5\b"+
		"\16\1\2\u00e5\u00fc\3\2\2\2\u00e6\u00e7\5\"\22\2\u00e7\u00e8\b\16\1\2"+
		"\u00e8\u00fc\3\2\2\2\u00e9\u00ea\5$\23\2\u00ea\u00eb\b\16\1\2\u00eb\u00fc"+
		"\3\2\2\2\u00ec\u00ed\5&\24\2\u00ed\u00ee\b\16\1\2\u00ee\u00fc\3\2\2\2"+
		"\u00ef\u00f0\5(\25\2\u00f0\u00f1\b\16\1\2\u00f1\u00fc\3\2\2\2\u00f2\u00f3"+
		"\5*\26\2\u00f3\u00f4\b\16\1\2\u00f4\u00fc\3\2\2\2\u00f5\u00f6\5,\27\2"+
		"\u00f6\u00f7\b\16\1\2\u00f7\u00fc\3\2\2\2\u00f8\u00f9\5.\30\2\u00f9\u00fa"+
		"\b\16\1\2\u00fa\u00fc\3\2\2\2\u00fb\u00dd\3\2\2\2\u00fb\u00e0\3\2\2\2"+
		"\u00fb\u00e3\3\2\2\2\u00fb\u00e6\3\2\2\2\u00fb\u00e9\3\2\2\2\u00fb\u00ec"+
		"\3\2\2\2\u00fb\u00ef\3\2\2\2\u00fb\u00f2\3\2\2\2\u00fb\u00f5\3\2\2\2\u00fb"+
		"\u00f8\3\2\2\2\u00fc\33\3\2\2\2\u00fd\u00fe\7\r\2\2\u00fe\u00ff\7\5\2"+
		"\2\u00ff\u0100\5v<\2\u0100\u0101\7\16\2\2\u0101\u0102\7\17\2\2\u0102\u0103"+
		"\58\35\2\u0103\u0104\5\66\34\2\u0104\u0105\7\4\2\2\u0105\u0106\b\17\1"+
		"\2\u0106\35\3\2\2\2\u0107\u0108\7\20\2\2\u0108\u0109\7\5\2\2\u0109\u010a"+
		"\5\60\31\2\u010a\u010b\7\21\2\2\u010b\u010c\5F$\2\u010c\u010d\5\66\34"+
		"\2\u010d\u010e\7\4\2\2\u010e\u010f\b\20\1\2\u010f\37\3\2\2\2\u0110\u0111"+
		"\7\22\2\2\u0111\u0112\7\5\2\2\u0112\u0113\5|?\2\u0113\u0114\7\21\2\2\u0114"+
		"\u0115\5L\'\2\u0115\u0116\5\66\34\2\u0116\u0117\7\4\2\2\u0117\u0118\b"+
		"\21\1\2\u0118!\3\2\2\2\u0119\u011a\7\23\2\2\u011a\u011b\7\5\2\2\u011b"+
		"\u011c\5\60\31\2\u011c\u011d\5\66\34\2\u011d\u011e\7\4\2\2\u011e\u011f"+
		"\b\22\1\2\u011f#\3\2\2\2\u0120\u0121\7\24\2\2\u0121\u0122\7\5\2\2\u0122"+
		"\u0123\5|?\2\u0123\u0124\5\66\34\2\u0124\u0125\7\4\2\2\u0125\u0126\b\23"+
		"\1\2\u0126%\3\2\2\2\u0127\u0128\7\r\2\2\u0128\u0129\7\f\2\2\u0129\u012a"+
		"\5\64\33\2\u012a\u012b\5\66\34\2\u012b\u012c\7\4\2\2\u012c\u012d\b\24"+
		"\1\2\u012d\'\3\2\2\2\u012e\u012f\7\20\2\2\u012f\u0130\7\f\2\2\u0130\u0131"+
		"\5\64\33\2\u0131\u0132\7\21\2\2\u0132\u0133\5P)\2\u0133\u0134\5\66\34"+
		"\2\u0134\u0135\7\4\2\2\u0135\u0136\b\25\1\2\u0136)\3\2\2\2\u0137\u0138"+
		"\7\22\2\2\u0138\u0139\7\f\2\2\u0139\u013a\5\64\33\2\u013a\u013b\7\21\2"+
		"\2\u013b\u013c\5T+\2\u013c\u013d\5\66\34\2\u013d\u013e\7\4\2\2\u013e\u013f"+
		"\b\26\1\2\u013f+\3\2\2\2\u0140\u0141\7\23\2\2\u0141\u0142\7\f\2\2\u0142"+
		"\u0143\5\64\33\2\u0143\u0144\5\66\34\2\u0144\u0145\7\4\2\2\u0145\u0146"+
		"\b\27\1\2\u0146-\3\2\2\2\u0147\u0148\7\24\2\2\u0148\u0149\7\f\2\2\u0149"+
		"\u014a\5\64\33\2\u014a\u014b\5\66\34\2\u014b\u014c\7\4\2\2\u014c\u014d"+
		"\b\30\1\2\u014d/\3\2\2\2\u014e\u014f\5v<\2\u014f\u0150\b\31\1\2\u0150"+
		"\u0155\3\2\2\2\u0151\u0152\5|?\2\u0152\u0153\b\31\1\2\u0153\u0155\3\2"+
		"\2\2\u0154\u014e\3\2\2\2\u0154\u0151\3\2\2\2\u0155\61\3\2\2\2\u0156\u0157"+
		"\5v<\2\u0157\u0158\b\32\1\2\u0158\u015f\3\2\2\2\u0159\u015a\5|?\2\u015a"+
		"\u015b\7\25\2\2\u015b\u015c\7\26\2\2\u015c\u015d\b\32\1\2\u015d\u015f"+
		"\3\2\2\2\u015e\u0156\3\2\2\2\u015e\u0159\3\2\2\2\u015f\63\3\2\2\2\u0160"+
		"\u0161\5\60\31\2\u0161\u0162\5X-\2\u0162\u0163\5\60\31\2\u0163\u0164\b"+
		"\33\1\2\u0164\65\3\2\2\2\u0165\u0166\7\27\2\2\u0166\u0167\5b\62\2\u0167"+
		"\u0168\b\34\1\2\u0168\u016b\3\2\2\2\u0169\u016b\b\34\1\2\u016a\u0165\3"+
		"\2\2\2\u016a\u0169\3\2\2\2\u016b\67\3\2\2\2\u016c\u016d\7\30\2\2\u016d"+
		"\u016e\5:\36\2\u016e\u016f\5@!\2\u016f\u0170\7\31\2\2\u0170\u0171\b\35"+
		"\1\2\u01719\3\2\2\2\u0172\u0173\5<\37\2\u0173\u0174\7\32\2\2\u0174\u0175"+
		"\5> \2\u0175\u0176\b\36\1\2\u0176\u017d\3\2\2\2\u0177\u0178\5> \2\u0178"+
		"\u0179\7\32\2\2\u0179\u017a\5<\37\2\u017a\u017b\b\36\1\2\u017b\u017d\3"+
		"\2\2\2\u017c\u0172\3\2\2\2\u017c\u0177\3\2\2\2\u017d;\3\2\2\2\u017e\u017f"+
		"\7\33\2\2\u017f\u0180\7\34\2\2\u0180\u0181\5\62\32\2\u0181\u0182\b\37"+
		"\1\2\u0182=\3\2\2\2\u0183\u0184\7\35\2\2\u0184\u0185\7\34\2\2\u0185\u0186"+
		"\5V,\2\u0186\u0187\b \1\2\u0187\u0190\3\2\2\2\u0188\u0189\7\35\2\2\u0189"+
		"\u018a\7\34\2\2\u018a\u018b\5V,\2\u018b\u018c\7\t\2\2\u018c\u018d\5\60"+
		"\31\2\u018d\u018e\b \1\2\u018e\u0190\3\2\2\2\u018f\u0183\3\2\2\2\u018f"+
		"\u0188\3\2\2\2\u0190?\3\2\2\2\u0191\u0192\7\32\2\2\u0192\u0194\5B\"\2"+
		"\u0193\u0191\3\2\2\2\u0194\u0197\3\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196"+
		"\3\2\2\2\u0196\u0198\3\2\2\2\u0197\u0195\3\2\2\2\u0198\u0199\b!\1\2\u0199"+
		"A\3\2\2\2\u019a\u019b\5z>\2\u019b\u019c\7\34\2\2\u019c\u019d\5D#\2\u019d"+
		"\u019e\b\"\1\2\u019eC\3\2\2\2\u019f\u01a0\7\36\2\2\u01a0\u01a1\7\37\2"+
		"\2\u01a1\u01a2\5\60\31\2\u01a2\u01a3\7\25\2\2\u01a3\u01a4\5z>\2\u01a4"+
		"\u01a5\b#\1\2\u01a5\u01b5\3\2\2\2\u01a6\u01a7\7 \2\2\u01a7\u01a8\7\37"+
		"\2\2\u01a8\u01a9\5Z.\2\u01a9\u01aa\b#\1\2\u01aa\u01b5\3\2\2\2\u01ab\u01ac"+
		"\7!\2\2\u01ac\u01ad\7\37\2\2\u01ad\u01ae\5b\62\2\u01ae\u01af\b#\1\2\u01af"+
		"\u01b5\3\2\2\2\u01b0\u01b1\7\"\2\2\u01b1\u01b2\7\37\2\2\u01b2\u01b3\7"+
		";\2\2\u01b3\u01b5\b#\1\2\u01b4\u019f\3\2\2\2\u01b4\u01a6\3\2\2\2\u01b4"+
		"\u01ab\3\2\2\2\u01b4\u01b0\3\2\2\2\u01b5E\3\2\2\2\u01b6\u01bb\5H%\2\u01b7"+
		"\u01b8\7\32\2\2\u01b8\u01ba\5H%\2\u01b9\u01b7\3\2\2\2\u01ba\u01bd\3\2"+
		"\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd"+
		"\u01bb\3\2\2\2\u01be\u01bf\b$\1\2\u01bfG\3\2\2\2\u01c0\u01c1\5J&\2\u01c1"+
		"\u01c2\b%\1\2\u01c2\u01cd\3\2\2\2\u01c3\u01c4\5<\37\2\u01c4\u01c5\b%\1"+
		"\2\u01c5\u01cd\3\2\2\2\u01c6\u01c7\5> \2\u01c7\u01c8\b%\1\2\u01c8\u01cd"+
		"\3\2\2\2\u01c9\u01ca\5B\"\2\u01ca\u01cb\b%\1\2\u01cb\u01cd\3\2\2\2\u01cc"+
		"\u01c0\3\2\2\2\u01cc\u01c3\3\2\2\2\u01cc\u01c6\3\2\2\2\u01cc\u01c9\3\2"+
		"\2\2\u01cdI\3\2\2\2\u01ce\u01cf\7\26\2\2\u01cf\u01d0\7\34\2\2\u01d0\u01d1"+
		"\7;\2\2\u01d1\u01d2\b&\1\2\u01d2K\3\2\2\2\u01d3\u01d8\5N(\2\u01d4\u01d5"+
		"\7\32\2\2\u01d5\u01d7\5N(\2\u01d6\u01d4\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8"+
		"\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01db\3\2\2\2\u01da\u01d8\3\2"+
		"\2\2\u01db\u01dc\b\'\1\2\u01dcM\3\2\2\2\u01dd\u01de\5<\37\2\u01de\u01df"+
		"\b(\1\2\u01df\u01e7\3\2\2\2\u01e0\u01e1\5> \2\u01e1\u01e2\b(\1\2\u01e2"+
		"\u01e7\3\2\2\2\u01e3\u01e4\5B\"\2\u01e4\u01e5\b(\1\2\u01e5\u01e7\3\2\2"+
		"\2\u01e6\u01dd\3\2\2\2\u01e6\u01e0\3\2\2\2\u01e6\u01e3\3\2\2\2\u01e7O"+
		"\3\2\2\2\u01e8\u01e9\5R*\2\u01e9\u01ea\b)\1\2\u01ea\u01f8\3\2\2\2\u01eb"+
		"\u01ec\5R*\2\u01ec\u01ed\7\32\2\2\u01ed\u01ee\5R*\2\u01ee\u01ef\b)\1\2"+
		"\u01ef\u01f8\3\2\2\2\u01f0\u01f1\5R*\2\u01f1\u01f2\7\32\2\2\u01f2\u01f3"+
		"\5R*\2\u01f3\u01f4\7\32\2\2\u01f4\u01f5\5R*\2\u01f5\u01f6\b)\1\2\u01f6"+
		"\u01f8\3\2\2\2\u01f7\u01e8\3\2\2\2\u01f7\u01eb\3\2\2\2\u01f7\u01f0\3\2"+
		"\2\2\u01f8Q\3\2\2\2\u01f9\u01fa\7#\2\2\u01fa\u01fb\7\34\2\2\u01fb\u01fc"+
		"\5\62\32\2\u01fc\u01fd\b*\1\2\u01fd\u0209\3\2\2\2\u01fe\u01ff\7$\2\2\u01ff"+
		"\u0200\7\34\2\2\u0200\u0201\5X-\2\u0201\u0202\b*\1\2\u0202\u0209\3\2\2"+
		"\2\u0203\u0204\7%\2\2\u0204\u0205\7\34\2\2\u0205\u0206\5\62\32\2\u0206"+
		"\u0207\b*\1\2\u0207\u0209\3\2\2\2\u0208\u01f9\3\2\2\2\u0208\u01fe\3\2"+
		"\2\2\u0208\u0203\3\2\2\2\u0209S\3\2\2\2\u020a\u020b\5R*\2\u020b\u020c"+
		"\b+\1\2\u020c\u0213\3\2\2\2\u020d\u020e\5R*\2\u020e\u020f\7\32\2\2\u020f"+
		"\u0210\5R*\2\u0210\u0211\b+\1\2\u0211\u0213\3\2\2\2\u0212\u020a\3\2\2"+
		"\2\u0212\u020d\3\2\2\2\u0213U\3\2\2\2\u0214\u0215\7\6\2\2\u0215\u0222"+
		"\b,\1\2\u0216\u0217\7\7\2\2\u0217\u0222\b,\1\2\u0218\u0219\7\b\2\2\u0219"+
		"\u0222\b,\1\2\u021a\u021b\7\n\2\2\u021b\u0222\b,\1\2\u021c\u021d\5\60"+
		"\31\2\u021d\u021e\7\25\2\2\u021e\u021f\7\35\2\2\u021f\u0220\b,\1\2\u0220"+
		"\u0222\3\2\2\2\u0221\u0214\3\2\2\2\u0221\u0216\3\2\2\2\u0221\u0218\3\2"+
		"\2\2\u0221\u021a\3\2\2\2\u0221\u021c\3\2\2\2\u0222W\3\2\2\2\u0223\u0224"+
		"\7&\2\2\u0224\u0228\b-\1\2\u0225\u0226\7\'\2\2\u0226\u0228\b-\1\2\u0227"+
		"\u0223\3\2\2\2\u0227\u0225\3\2\2\2\u0228Y\3\2\2\2\u0229\u022a\b.\1\2\u022a"+
		"\u022b\5\\/\2\u022b\u022c\b.\1\2\u022c\u0237\3\2\2\2\u022d\u022e\7\30"+
		"\2\2\u022e\u022f\5Z.\2\u022f\u0230\7\31\2\2\u0230\u0231\b.\1\2\u0231\u0237"+
		"\3\2\2\2\u0232\u0233\7(\2\2\u0233\u0234\5Z.\5\u0234\u0235\b.\1\2\u0235"+
		"\u0237\3\2\2\2\u0236\u0229\3\2\2\2\u0236\u022d\3\2\2\2\u0236\u0232\3\2"+
		"\2\2\u0237\u0244\3\2\2\2\u0238\u0239\f\4\2\2\u0239\u023a\5^\60\2\u023a"+
		"\u023b\5Z.\5\u023b\u023c\b.\1\2\u023c\u0243\3\2\2\2\u023d\u023e\f\3\2"+
		"\2\u023e\u023f\5`\61\2\u023f\u0240\5Z.\4\u0240\u0241\b.\1\2\u0241\u0243"+
		"\3\2\2\2\u0242\u0238\3\2\2\2\u0242\u023d\3\2\2\2\u0243\u0246\3\2\2\2\u0244"+
		"\u0242\3\2\2\2\u0244\u0245\3\2\2\2\u0245[\3\2\2\2\u0246\u0244\3\2\2\2"+
		"\u0247\u0248\79\2\2\u0248\u0251\b/\1\2\u0249\u024a\7:\2\2\u024a\u0251"+
		"\b/\1\2\u024b\u024c\5\60\31\2\u024c\u024d\7\25\2\2\u024d\u024e\5z>\2\u024e"+
		"\u024f\b/\1\2\u024f\u0251\3\2\2\2\u0250\u0247\3\2\2\2\u0250\u0249\3\2"+
		"\2\2\u0250\u024b\3\2\2\2\u0251]\3\2\2\2\u0252\u0253\7)\2\2\u0253\u0259"+
		"\b\60\1\2\u0254\u0255\7*\2\2\u0255\u0259\b\60\1\2\u0256\u0257\7+\2\2\u0257"+
		"\u0259\b\60\1\2\u0258\u0252\3\2\2\2\u0258\u0254\3\2\2\2\u0258\u0256\3"+
		"\2\2\2\u0259_\3\2\2\2\u025a\u025b\7,\2\2\u025b\u025f\b\61\1\2\u025c\u025d"+
		"\7(\2\2\u025d\u025f\b\61\1\2\u025e\u025a\3\2\2\2\u025e\u025c\3\2\2\2\u025f"+
		"a\3\2\2\2\u0260\u0261\b\62\1\2\u0261\u0262\5d\63\2\u0262\u0263\b\62\1"+
		"\2\u0263\u026e\3\2\2\2\u0264\u0265\7\30\2\2\u0265\u0266\5b\62\2\u0266"+
		"\u0267\7\31\2\2\u0267\u0268\b\62\1\2\u0268\u026e\3\2\2\2\u0269\u026a\7"+
		"-\2\2\u026a\u026b\5b\62\5\u026b\u026c\b\62\1\2\u026c\u026e\3\2\2\2\u026d"+
		"\u0260\3\2\2\2\u026d\u0264\3\2\2\2\u026d\u0269\3\2\2\2\u026e\u027b\3\2"+
		"\2\2\u026f\u0270\f\4\2\2\u0270\u0271\7.\2\2\u0271\u0272\5b\62\5\u0272"+
		"\u0273\b\62\1\2\u0273\u027a\3\2\2\2\u0274\u0275\f\3\2\2\u0275\u0276\7"+
		"\n\2\2\u0276\u0277\5b\62\4\u0277\u0278\b\62\1\2\u0278\u027a\3\2\2\2\u0279"+
		"\u026f\3\2\2\2\u0279\u0274\3\2\2\2\u027a\u027d\3\2\2\2\u027b\u0279\3\2"+
		"\2\2\u027b\u027c\3\2\2\2\u027cc\3\2\2\2\u027d\u027b\3\2\2\2\u027e\u027f"+
		"\5~@\2\u027f\u0280\b\63\1\2\u0280\u0298\3\2\2\2\u0281\u0282\5\60\31\2"+
		"\u0282\u0283\7\25\2\2\u0283\u0284\5z>\2\u0284\u0285\b\63\1\2\u0285\u0298"+
		"\3\2\2\2\u0286\u0287\5h\65\2\u0287\u0288\b\63\1\2\u0288\u0298\3\2\2\2"+
		"\u0289\u028a\5n8\2\u028a\u028b\b\63\1\2\u028b\u0298\3\2\2\2\u028c\u028d"+
		"\5p9\2\u028d\u028e\b\63\1\2\u028e\u0298\3\2\2\2\u028f\u0290\5Z.\2\u0290"+
		"\u0291\5f\64\2\u0291\u0292\5Z.\2\u0292\u0293\b\63\1\2\u0293\u0298\3\2"+
		"\2\2\u0294\u0295\5r:\2\u0295\u0296\b\63\1\2\u0296\u0298\3\2\2\2\u0297"+
		"\u027e\3\2\2\2\u0297\u0281\3\2\2\2\u0297\u0286\3\2\2\2\u0297\u0289\3\2"+
		"\2\2\u0297\u028c\3\2\2\2\u0297\u028f\3\2\2\2\u0297\u0294\3\2\2\2\u0298"+
		"e\3\2\2\2\u0299\u029a\7/\2\2\u029a\u02a6\b\64\1\2\u029b\u029c\7\60\2\2"+
		"\u029c\u02a6\b\64\1\2\u029d\u029e\7\61\2\2\u029e\u02a6\b\64\1\2\u029f"+
		"\u02a0\7\62\2\2\u02a0\u02a6\b\64\1\2\u02a1\u02a2\7\34\2\2\u02a2\u02a6"+
		"\b\64\1\2\u02a3\u02a4\7\63\2\2\u02a4\u02a6\b\64\1\2\u02a5\u0299\3\2\2"+
		"\2\u02a5\u029b\3\2\2\2\u02a5\u029d\3\2\2\2\u02a5\u029f\3\2\2\2\u02a5\u02a1"+
		"\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a6g\3\2\2\2\u02a7\u02a8\5j\66\2\u02a8"+
		"\u02a9\5l\67\2\u02a9\u02aa\5j\66\2\u02aa\u02ab\b\65\1\2\u02abi\3\2\2\2"+
		"\u02ac\u02ad\7;\2\2\u02ad\u02be\b\66\1\2\u02ae\u02af\5\60\31\2\u02af\u02b0"+
		"\7\25\2\2\u02b0\u02b1\7\26\2\2\u02b1\u02b2\b\66\1\2\u02b2\u02be\3\2\2"+
		"\2\u02b3\u02b4\5\60\31\2\u02b4\u02b5\7\25\2\2\u02b5\u02b6\7\33\2\2\u02b6"+
		"\u02b7\b\66\1\2\u02b7\u02be\3\2\2\2\u02b8\u02b9\5\60\31\2\u02b9\u02ba"+
		"\7\25\2\2\u02ba\u02bb\5z>\2\u02bb\u02bc\b\66\1\2\u02bc\u02be\3\2\2\2\u02bd"+
		"\u02ac\3\2\2\2\u02bd\u02ae\3\2\2\2\u02bd\u02b3\3\2\2\2\u02bd\u02b8\3\2"+
		"\2\2\u02bek\3\2\2\2\u02bf\u02c0\7\34\2\2\u02c0\u02c4\b\67\1\2\u02c1\u02c2"+
		"\7\63\2\2\u02c2\u02c4\b\67\1\2\u02c3\u02bf\3\2\2\2\u02c3\u02c1\3\2\2\2"+
		"\u02c4m\3\2\2\2\u02c5\u02c6\5V,\2\u02c6\u02c7\5l\67\2\u02c7\u02c8\5V,"+
		"\2\u02c8\u02c9\b8\1\2\u02c9o\3\2\2\2\u02ca\u02cb\5\60\31\2\u02cb\u02cc"+
		"\7\25\2\2\u02cc\u02cd\7\64\2\2\u02cd\u02ce\5l\67\2\u02ce\u02cf\5\60\31"+
		"\2\u02cf\u02d0\7\25\2\2\u02d0\u02d1\7\64\2\2\u02d1\u02d2\b9\1\2\u02d2"+
		"q\3\2\2\2\u02d3\u02d4\5t;\2\u02d4\u02d5\5l\67\2\u02d5\u02d6\5t;\2\u02d6"+
		"\u02d7\b:\1\2\u02d7s\3\2\2\2\u02d8\u02d9\5~@\2\u02d9\u02da\b;\1\2\u02da"+
		"\u02e1\3\2\2\2\u02db\u02dc\5\60\31\2\u02dc\u02dd\7\25\2\2\u02dd\u02de"+
		"\5z>\2\u02de\u02df\b;\1\2\u02df\u02e1\3\2\2\2\u02e0\u02d8\3\2\2\2\u02e0"+
		"\u02db\3\2\2\2\u02e1u\3\2\2\2\u02e2\u02e3\7;\2\2\u02e3\u02e4\b<\1\2\u02e4"+
		"w\3\2\2\2\u02e5\u02e6\7;\2\2\u02e6\u02e7\b=\1\2\u02e7y\3\2\2\2\u02e8\u02e9"+
		"\7\67\2\2\u02e9\u02ea\b>\1\2\u02ea{\3\2\2\2\u02eb\u02ec\78\2\2\u02ec\u02ed"+
		"\b?\1\2\u02ed}\3\2\2\2\u02ee\u02ef\7\65\2\2\u02ef\u02f3\b@\1\2\u02f0\u02f1"+
		"\7\66\2\2\u02f1\u02f3\b@\1\2\u02f2\u02ee\3\2\2\2\u02f2\u02f0\3\2\2\2\u02f3"+
		"\177\3\2\2\2(\u008c\u00ad\u00b2\u00c5\u00ca\u00d9\u00fb\u0154\u015e\u016a"+
		"\u017c\u018f\u0195\u01b4\u01bb\u01cc\u01d8\u01e6\u01f7\u0208\u0212\u0221"+
		"\u0227\u0236\u0242\u0244\u0250\u0258\u025e\u026d\u0279\u027b\u0297\u02a5"+
		"\u02bd\u02c3\u02e0\u02f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
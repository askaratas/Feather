// Generated from TVL.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TVLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, NAME=22, ATTR_NAME=23, INTEGER_LITERAL=24, 
		REAL_LITERAL=25, STRING_LITERAL=26, WS=27;
	public static final int
		RULE_s = 0, RULE_stringType = 1, RULE_stringList = 2, RULE_featureList = 3, 
		RULE_rootFeature = 4, RULE_otherFeatures = 5, RULE_feature = 6, RULE_featureBody = 7, 
		RULE_attributeList = 8, RULE_attribute = 9, RULE_children = 10, RULE_featureGroup = 11, 
		RULE_solitaryIDList = 12, RULE_optional = 13, RULE_pp_parentInformation = 14, 
		RULE_idList = 15, RULE_cardinality = 16, RULE_constraintList = 17, RULE_constraint = 18, 
		RULE_id = 19, RULE_attrID = 20, RULE_bool_literal = 21, RULE_string_literal = 22;
	public static final String[] ruleNames = {
		"s", "stringType", "stringList", "featureList", "rootFeature", "otherFeatures", 
		"feature", "featureBody", "attributeList", "attribute", "children", "featureGroup", 
		"solitaryIDList", "optional", "pp_parentInformation", "idList", "cardinality", 
		"constraintList", "constraint", "id", "attrID", "bool_literal", "string_literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'enum'", "'string'", "'in'", "'{'", "'}'", "';'", "','", "'root'", 
		"'int'", "'is'", "'real'", "'bool'", "'group'", "'allof'", "'opt'", "'oneof'", 
		"'someof'", "'requires'", "'excludes'", "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "NAME", "ATTR_NAME", 
		"INTEGER_LITERAL", "REAL_LITERAL", "STRING_LITERAL", "WS"
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
	public String getGrammarFileName() { return "TVL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TVLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SContext extends ParserRuleContext {
		public String featherCode;
		public StringTypeContext stringType;
		public FeatureListContext featureList;
		public StringTypeContext stringType() {
			return getRuleContext(StringTypeContext.class,0);
		}
		public FeatureListContext featureList() {
			return getRuleContext(FeatureListContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitS(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			((SContext)_localctx).stringType = stringType();
			setState(47);
			((SContext)_localctx).featureList = featureList(((SContext)_localctx).stringType.strEnumValues);

			            ((SContext)_localctx).featherCode =  ((SContext)_localctx).featureList.featherCode; 
			          
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

	public static class StringTypeContext extends ParserRuleContext {
		public ArrayList strEnumValues;
		public StringListContext stringList;
		public StringListContext stringList() {
			return getRuleContext(StringListContext.class,0);
		}
		public StringTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterStringType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitStringType(this);
		}
	}

	public final StringTypeContext stringType() throws RecognitionException {
		StringTypeContext _localctx = new StringTypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stringType);
		try {
			setState(60);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__0);
				setState(51);
				match(T__1);
				setState(52);
				match(T__2);
				setState(53);
				match(T__3);
				setState(54);
				((StringTypeContext)_localctx).stringList = stringList();
				setState(55);
				match(T__4);
				setState(56);
				match(T__5);
				 ((StringTypeContext)_localctx).strEnumValues =  ((StringTypeContext)_localctx).stringList.strEnumValues; 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				 ((StringTypeContext)_localctx).strEnumValues =  new ArrayList(); 
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

	public static class StringListContext extends ParserRuleContext {
		public ArrayList strEnumValues;
		public int i;
		public String existingValue;
		public String_literalContext string_literal;
		public StringListContext lbl_sl;
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public StringListContext stringList() {
			return getRuleContext(StringListContext.class,0);
		}
		public StringListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterStringList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitStringList(this);
		}
	}

	public final StringListContext stringList() throws RecognitionException {
		StringListContext _localctx = new StringListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stringList);
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				((StringListContext)_localctx).string_literal = string_literal();

				            ((StringListContext)_localctx).strEnumValues =  new ArrayList();
				            _localctx.strEnumValues.add((((StringListContext)_localctx).string_literal!=null?_input.getText(((StringListContext)_localctx).string_literal.start,((StringListContext)_localctx).string_literal.stop):null));  
				          
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				((StringListContext)_localctx).string_literal = string_literal();
				setState(66);
				match(T__6);
				setState(67);
				((StringListContext)_localctx).lbl_sl = stringList();

				            for (((StringListContext)_localctx).i = 0; _localctx.i < ((StringListContext)_localctx).lbl_sl.strEnumValues.size(); _localctx.i++)
				            {
				              ((StringListContext)_localctx).existingValue =  (String) ((StringListContext)_localctx).lbl_sl.strEnumValues.get(_localctx.i);
				              if ( (((StringListContext)_localctx).string_literal!=null?_input.getText(((StringListContext)_localctx).string_literal.start,((StringListContext)_localctx).string_literal.stop):null).equals(_localctx.existingValue) )
				              {
				                 // This means that the string value already exists, take necessary actions
				                 notifyErrorListeners(((StringListContext)_localctx).string_literal.lineNo + ": the string literal " + (((StringListContext)_localctx).string_literal!=null?_input.getText(((StringListContext)_localctx).string_literal.start,((StringListContext)_localctx).string_literal.stop):null) + " listed more than once");
				              }
				            }

				            ((StringListContext)_localctx).strEnumValues =  ((StringListContext)_localctx).lbl_sl.strEnumValues;
				            _localctx.strEnumValues.add((((StringListContext)_localctx).string_literal!=null?_input.getText(((StringListContext)_localctx).string_literal.start,((StringListContext)_localctx).string_literal.stop):null));
				          
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

	public static class FeatureListContext extends ParserRuleContext {
		public ArrayList i_strEnumValues;
		public String featherCode;
		public ArrayList featAttrs;
		public ArrayList parInfo;
		public ArrayList decInfo;
		public ArrayList relSibInfo;
		public ArrayList declaredFeats;
		public String featName;
		public String parName;
		public String decomp;
		public String relSibling;
		public ArrayList attributes;
		public String featureCode;
		public String attributeCode;
		public ArrayList consList;
		public ArrayList idCheckList;
		public String constraintCode;
		public int i;
		public int j;
		public int lineNo;
		public String decCode;
		public ArrayList tmpList;
		public boolean found;
		public String lf1;
		public String c1;
		public String rf1;
		public String lf2;
		public String c2;
		public String rf2;
		public RootFeatureContext rootFeature;
		public OtherFeaturesContext otherFeatures;
		public RootFeatureContext rootFeature() {
			return getRuleContext(RootFeatureContext.class,0);
		}
		public OtherFeaturesContext otherFeatures() {
			return getRuleContext(OtherFeaturesContext.class,0);
		}
		public FeatureListContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FeatureListContext(ParserRuleContext parent, int invokingState, ArrayList i_strEnumValues) {
			super(parent, invokingState);
			this.i_strEnumValues = i_strEnumValues;
		}
		@Override public int getRuleIndex() { return RULE_featureList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterFeatureList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitFeatureList(this);
		}
	}

	public final FeatureListContext featureList(ArrayList i_strEnumValues) throws RecognitionException {
		FeatureListContext _localctx = new FeatureListContext(_ctx, getState(), i_strEnumValues);
		enterRule(_localctx, 6, RULE_featureList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			((FeatureListContext)_localctx).rootFeature = rootFeature(i_strEnumValues);
			setState(73);
			((FeatureListContext)_localctx).otherFeatures = otherFeatures(i_strEnumValues, ((FeatureListContext)_localctx).rootFeature.declaredFeats, ((FeatureListContext)_localctx).rootFeature.parInfo);

			            ((FeatureListContext)_localctx).declaredFeats =  ((FeatureListContext)_localctx).otherFeatures.declaredFeats;
			            ((FeatureListContext)_localctx).featAttrs =  ((FeatureListContext)_localctx).otherFeatures.featAttrs;
			            ((FeatureListContext)_localctx).parInfo =  ((FeatureListContext)_localctx).otherFeatures.parInfo;
			            
			            ((FeatureListContext)_localctx).decInfo =  ((FeatureListContext)_localctx).otherFeatures.decInfo;
			            for (((FeatureListContext)_localctx).i = 0; _localctx.i < ((FeatureListContext)_localctx).rootFeature.decInfo.size(); _localctx.i++)
			            {
			              _localctx.decInfo.add(((FeatureListContext)_localctx).rootFeature.decInfo.get(_localctx.i));
			            }
			            
			            ((FeatureListContext)_localctx).relSibInfo =  ((FeatureListContext)_localctx).otherFeatures.relSibInfo;
			            for (((FeatureListContext)_localctx).i = 0; _localctx.i < ((FeatureListContext)_localctx).rootFeature.relSibInfo.size(); _localctx.i++)
			            {
			              _localctx.relSibInfo.add(((FeatureListContext)_localctx).rootFeature.relSibInfo.get(_localctx.i));
			            }
			            
			            // check if there are any undeclared features
			            for (((FeatureListContext)_localctx).i = 0; _localctx.i < _localctx.parInfo.size(); _localctx.i++)
			            {
			              ((FeatureListContext)_localctx).featName =  (String) ((ArrayList) _localctx.parInfo.get(_localctx.i)).get(0);
			              ((FeatureListContext)_localctx).parName =  (String) ((ArrayList) _localctx.parInfo.get(_localctx.i)).get(1);
			              
			              ((FeatureListContext)_localctx).found =  false;
			              for (((FeatureListContext)_localctx).j = 0; _localctx.j < _localctx.declaredFeats.size(); _localctx.j++ )
			              {
			                if ( _localctx.featName.equals((String) _localctx.declaredFeats.get(_localctx.j)) )
			                {
			                  ((FeatureListContext)_localctx).found =  true;
			                  break;
			                }
			              }
			              
			              if ( ! _localctx.found )
			              {
			                // This means that the feature a feature does not have a declaration, take necessary actions
			                notifyErrorListeners("The feature \"" + _localctx.featName + "\" (i.e., a child of \"" + _localctx.parName + "\") is undeclared.");
			              }
			            }
			            
			            ((FeatureListContext)_localctx).featureCode =  "";
			            for (((FeatureListContext)_localctx).i = 0; _localctx.i < _localctx.declaredFeats.size(); _localctx.i++)
			            {
			              ((FeatureListContext)_localctx).featName =  (String) _localctx.declaredFeats.get(_localctx.i);
			              
			              if ( _localctx.featName.equals(((FeatureListContext)_localctx).rootFeature.name) )
			              {
			                continue;
			              }
			              
			              ((FeatureListContext)_localctx).parName =  null;
			              for (((FeatureListContext)_localctx).j = 0; _localctx.j < _localctx.parInfo.size(); _localctx.j++)
			              {
			                if ( _localctx.featName.equals((String) ((ArrayList)_localctx.parInfo.get(_localctx.j)).get(0)) )
			                {
			                  ((FeatureListContext)_localctx).parName =  (String) ((ArrayList)_localctx.parInfo.get(_localctx.j)).get(1);
			                  break;
			                }
			              }
			              if ( _localctx.parName == null )
			              {
			                 // This means that the feature has no parent, take necessary actions
			                 notifyErrorListeners("The feature \"" + _localctx.featName + "\" is isolated, which violates the required tree-structure.");
			                 continue;
			              }
			              
			              ((FeatureListContext)_localctx).decomp =  null;
			              for (((FeatureListContext)_localctx).j = 0; _localctx.j < _localctx.decInfo.size(); _localctx.j++)
			              {
			                if ( _localctx.featName.equals((String) ((ArrayList)_localctx.decInfo.get(_localctx.j)).get(0)) )
			                {
			                  ((FeatureListContext)_localctx).decomp =  (String) ((ArrayList)_localctx.decInfo.get(_localctx.j)).get(1);
			                  break;
			                }
			              }
			              if ( _localctx.decomp == null )
			              {
			                 // This means that the feature has no parent, take necessary actions
			                 notifyErrorListeners("The feature \"" + _localctx.featName + "\" is isolated, which violates the required tree-structure.");
			                 continue;
			              }
			              
			              if ( _localctx.decomp.equals("alternative") || _localctx.decomp.equals("or") )
			              {
			                ((FeatureListContext)_localctx).relSibling =  "";
			                for (((FeatureListContext)_localctx).j = 0; _localctx.j < _localctx.relSibInfo.size(); _localctx.j++)
			                {
			                  if ( _localctx.featName.equals((String) ((ArrayList)_localctx.relSibInfo.get(_localctx.j)).get(0)) )
			                  {
			                    ((FeatureListContext)_localctx).relSibling =  (String) ((ArrayList)_localctx.relSibInfo.get(_localctx.j)).get(1);
			                    break;
			                  }
			                }
			                
			                // no relsibling means this feature is actually a mandatory feature
			                if ( _localctx.relSibling.equals("") )
			                {
			                  ((FeatureListContext)_localctx).decCode =  "mandatory";
			                }
			                else
			                {
			                  ((FeatureListContext)_localctx).decCode =  _localctx.decomp + " to \"" + _localctx.relSibling + "\"";
			                }
			              }
			              else
			              {
			                ((FeatureListContext)_localctx).decCode =  _localctx.decomp;
			              }
			              
			              ((FeatureListContext)_localctx).attributes =  null;
			              for (((FeatureListContext)_localctx).j = 0; _localctx.j < _localctx.featAttrs.size(); _localctx.j++)
			              {
			                if ( _localctx.featName.equals( (String)(((ArrayList)_localctx.featAttrs.get(_localctx.j)).get(0)) ) )
			                {
			                  ((FeatureListContext)_localctx).attributes =  (ArrayList) ((ArrayList)_localctx.featAttrs.get(_localctx.j)).get(1);
			                  break;
			                }
			              }
			              if ( _localctx.attributes == null )
			              {
			                 ((FeatureListContext)_localctx).attributes =  new ArrayList();
			              }
			              
			              ((FeatureListContext)_localctx).attributeCode =  "";
			              for (((FeatureListContext)_localctx).j = 0; _localctx.j < _localctx.attributes.size(); _localctx.j++)
			              {
			                _localctx.attributeCode += "  attribute " + ((ArrayList)_localctx.attributes.get(_localctx.j)).get(0) + " " + ((ArrayList)_localctx.attributes.get(_localctx.j)).get(1) + "\r\n";
			              }
			              
			              _localctx.featureCode += "feature \"" + _localctx.featName + "\" \"" + _localctx.parName + "\" " + _localctx.decCode + "\r\n" + _localctx.attributeCode + ";" + "\r\n";
			            }
			            
			            ((FeatureListContext)_localctx).consList =  ((FeatureListContext)_localctx).otherFeatures.consList;
			            for (((FeatureListContext)_localctx).i = 0; _localctx.i < ((FeatureListContext)_localctx).rootFeature.consList.size(); _localctx.i++)
			            {
			              _localctx.consList.add(((FeatureListContext)_localctx).rootFeature.consList.get(_localctx.i));
			            }
			            
			            ((FeatureListContext)_localctx).idCheckList =  ((FeatureListContext)_localctx).otherFeatures.idCheckList;
			            for (((FeatureListContext)_localctx).i = 0; _localctx.i < ((FeatureListContext)_localctx).rootFeature.idCheckList.size(); _localctx.i++)
			            {
			              _localctx.idCheckList.add(((FeatureListContext)_localctx).rootFeature.idCheckList.get(_localctx.i));
			            }
			            
			            // check if there are any undeclared features used in constraints
			            for (((FeatureListContext)_localctx).i = 0; _localctx.i < _localctx.idCheckList.size(); _localctx.i++)
			            {
			              ((FeatureListContext)_localctx).featName =  (String) ((ArrayList) _localctx.idCheckList.get(_localctx.i)).get(0);
			              ((FeatureListContext)_localctx).lineNo =  (int)    ((ArrayList) _localctx.idCheckList.get(_localctx.i)).get(1);
			              
			              ((FeatureListContext)_localctx).found =  false;
			              for (((FeatureListContext)_localctx).j = 0; _localctx.j < _localctx.declaredFeats.size(); _localctx.j++ )
			              {
			                if ( _localctx.featName.equals((String) _localctx.declaredFeats.get(_localctx.j)) )
			                {
			                  ((FeatureListContext)_localctx).found =  true;
			                  break;
			                }
			              }
			              
			              if ( ! _localctx.found )
			              {
			                // This means that the feature a feature does not have a declaration, take necessary actions
			                notifyErrorListeners("An undeclared feature (i.e., \"" + _localctx.featName + "\") is used in a constraint (line #" + _localctx.lineNo + ").");
			              }
			            }
			            
			            // eliminate duplicate constraints
			            
			            ((FeatureListContext)_localctx).tmpList =  new ArrayList();
			            for (((FeatureListContext)_localctx).i = 0; _localctx.i < _localctx.consList.size(); _localctx.i++)
			            {
			              ((FeatureListContext)_localctx).lf1 =  (String) ((ArrayList) _localctx.consList.get(_localctx.i)).get(0);
			              ((FeatureListContext)_localctx).c1 =  (String) ((ArrayList) _localctx.consList.get(_localctx.i)).get(1);
			              ((FeatureListContext)_localctx).rf1 =  (String) ((ArrayList) _localctx.consList.get(_localctx.i)).get(2);
			              
			              ((FeatureListContext)_localctx).found =  false;
			              for (((FeatureListContext)_localctx).j = 0; _localctx.j < _localctx.tmpList.size(); _localctx.j++)
			              {
			                ((FeatureListContext)_localctx).lf2 =  (String) ((ArrayList) _localctx.tmpList.get(_localctx.j)).get(0);
			                ((FeatureListContext)_localctx).c2 =  (String) ((ArrayList) _localctx.tmpList.get(_localctx.j)).get(1);
			                ((FeatureListContext)_localctx).rf2 =  (String) ((ArrayList) _localctx.tmpList.get(_localctx.j)).get(2);
			                
			                if ( _localctx.lf1.equals(_localctx.lf2) && _localctx.c1.equals(_localctx.c2) && _localctx.rf1.equals(_localctx.rf2) )
			                {
			                  ((FeatureListContext)_localctx).found =  true;
			                  break;
			                }
			                else if ( _localctx.c1.equals("excludes") && _localctx.c2.equals("excludes") )
			                {
			                  if ( _localctx.lf1.equals(_localctx.rf2) && _localctx.rf1.equals(_localctx.lf2) )
			                  {
			                    ((FeatureListContext)_localctx).found =  true;
			                    break;
			                  }
			                }
			              }
			              
			              if ( ! _localctx.found )
			              {
			                _localctx.tmpList.add((ArrayList) _localctx.consList.get(_localctx.i));
			              }
			            }
			            
			            ((FeatureListContext)_localctx).consList =  _localctx.tmpList;
			            
			            ((FeatureListContext)_localctx).constraintCode =  "";
			            for (((FeatureListContext)_localctx).i = 0; _localctx.i < _localctx.consList.size(); _localctx.i++)
			            {
			              ((FeatureListContext)_localctx).lf1 =  (String) ((ArrayList) _localctx.consList.get(_localctx.i)).get(0);
			              ((FeatureListContext)_localctx).c1 =  (String) ((ArrayList) _localctx.consList.get(_localctx.i)).get(1);
			              ((FeatureListContext)_localctx).rf1 =  (String) ((ArrayList) _localctx.consList.get(_localctx.i)).get(2);
			              
			              _localctx.constraintCode += "constraint \"" + _localctx.lf1 + "\" " + _localctx.c1 + " \"" + _localctx.rf1 + "\" ;\r\n";
			            }
			            
			            ((FeatureListContext)_localctx).featherCode =  ((FeatureListContext)_localctx).rootFeature.featherCode + "\r\n" + _localctx.featureCode + "\r\n" + _localctx.constraintCode;
			          
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
		public ArrayList i_strEnumValues;
		public String featherCode;
		public String name;
		public ArrayList declaredFeats;
		public ArrayList parInfo;
		public ArrayList decInfo;
		public ArrayList relSibInfo;
		public ArrayList consList;
		public ArrayList idCheckList;
		public int i;
		public ArrayList attributes;
		public String attrCode;
		public FeatureContext feature;
		public FeatureContext feature() {
			return getRuleContext(FeatureContext.class,0);
		}
		public RootFeatureContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RootFeatureContext(ParserRuleContext parent, int invokingState, ArrayList i_strEnumValues) {
			super(parent, invokingState);
			this.i_strEnumValues = i_strEnumValues;
		}
		@Override public int getRuleIndex() { return RULE_rootFeature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterRootFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitRootFeature(this);
		}
	}

	public final RootFeatureContext rootFeature(ArrayList i_strEnumValues) throws RecognitionException {
		RootFeatureContext _localctx = new RootFeatureContext(_ctx, getState(), i_strEnumValues);
		enterRule(_localctx, 8, RULE_rootFeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__7);
			setState(77);
			((RootFeatureContext)_localctx).feature = feature(i_strEnumValues, new ArrayList(), new ArrayList());

			            ((RootFeatureContext)_localctx).name =  ((RootFeatureContext)_localctx).feature.name;
			            ((RootFeatureContext)_localctx).declaredFeats =  ((RootFeatureContext)_localctx).feature.declaredFeats;
			            ((RootFeatureContext)_localctx).parInfo =  ((RootFeatureContext)_localctx).feature.parInfo;
			            ((RootFeatureContext)_localctx).decInfo =  ((RootFeatureContext)_localctx).feature.decInfo;
			            ((RootFeatureContext)_localctx).relSibInfo =  ((RootFeatureContext)_localctx).feature.relSibInfo;
			            ((RootFeatureContext)_localctx).consList =  ((RootFeatureContext)_localctx).feature.consList;
			            ((RootFeatureContext)_localctx).idCheckList =  ((RootFeatureContext)_localctx).feature.idCheckList;
			            
			            ((RootFeatureContext)_localctx).attributes =  (ArrayList) ((ArrayList) ((RootFeatureContext)_localctx).feature.featAttrs.get(0)).get(1);
			            ((RootFeatureContext)_localctx).attrCode =  "";
			            for (((RootFeatureContext)_localctx).i = 0; _localctx.i < _localctx.attributes.size(); _localctx.i++)
			            {
			              _localctx.attrCode += "  attribute " + ((ArrayList)_localctx.attributes.get(_localctx.i)).get(0) + " " + ((ArrayList)_localctx.attributes.get(_localctx.i)).get(1) + "\r\n";
			            }
			            
			            ((RootFeatureContext)_localctx).featherCode =  "root \"" + _localctx.name + "\"\r\n" + _localctx.attrCode + ";";
			          
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

	public static class OtherFeaturesContext extends ParserRuleContext {
		public ArrayList i_strEnumValues;
		public ArrayList i_declaredFeats;
		public ArrayList i_parInfo;
		public ArrayList declaredFeats;
		public ArrayList featAttrs;
		public ArrayList parInfo;
		public ArrayList decInfo;
		public ArrayList relSibInfo;
		public ArrayList consList;
		public ArrayList idCheckList;
		public int i;
		public String featName;
		public FeatureContext feature;
		public OtherFeaturesContext lbl_of;
		public FeatureContext feature() {
			return getRuleContext(FeatureContext.class,0);
		}
		public OtherFeaturesContext otherFeatures() {
			return getRuleContext(OtherFeaturesContext.class,0);
		}
		public OtherFeaturesContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public OtherFeaturesContext(ParserRuleContext parent, int invokingState, ArrayList i_strEnumValues, ArrayList i_declaredFeats, ArrayList i_parInfo) {
			super(parent, invokingState);
			this.i_strEnumValues = i_strEnumValues;
			this.i_declaredFeats = i_declaredFeats;
			this.i_parInfo = i_parInfo;
		}
		@Override public int getRuleIndex() { return RULE_otherFeatures; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterOtherFeatures(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitOtherFeatures(this);
		}
	}

	public final OtherFeaturesContext otherFeatures(ArrayList i_strEnumValues,ArrayList i_declaredFeats,ArrayList i_parInfo) throws RecognitionException {
		OtherFeaturesContext _localctx = new OtherFeaturesContext(_ctx, getState(), i_strEnumValues, i_declaredFeats, i_parInfo);
		enterRule(_localctx, 10, RULE_otherFeatures);
		try {
			setState(85);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				((OtherFeaturesContext)_localctx).feature = feature(i_strEnumValues, i_declaredFeats, i_parInfo);
				setState(81);
				((OtherFeaturesContext)_localctx).lbl_of = otherFeatures(i_strEnumValues, ((OtherFeaturesContext)_localctx).feature.declaredFeats, ((OtherFeaturesContext)_localctx).feature.parInfo);

				            ((OtherFeaturesContext)_localctx).declaredFeats =  ((OtherFeaturesContext)_localctx).lbl_of.declaredFeats;
				            
				            ((OtherFeaturesContext)_localctx).featAttrs =  ((OtherFeaturesContext)_localctx).lbl_of.featAttrs;
				            _localctx.featAttrs.add(((OtherFeaturesContext)_localctx).feature.featAttrs.get(0));
				            
				            ((OtherFeaturesContext)_localctx).parInfo =  ((OtherFeaturesContext)_localctx).lbl_of.parInfo;
				            
				            ((OtherFeaturesContext)_localctx).decInfo =  ((OtherFeaturesContext)_localctx).lbl_of.decInfo;
				            for (((OtherFeaturesContext)_localctx).i = 0; _localctx.i < ((OtherFeaturesContext)_localctx).feature.decInfo.size(); _localctx.i++)
				            {
				              _localctx.decInfo.add(((OtherFeaturesContext)_localctx).feature.decInfo.get(_localctx.i));
				            }
				            
				            ((OtherFeaturesContext)_localctx).relSibInfo =  ((OtherFeaturesContext)_localctx).lbl_of.relSibInfo;
				            for (((OtherFeaturesContext)_localctx).i = 0; _localctx.i < ((OtherFeaturesContext)_localctx).feature.relSibInfo.size(); _localctx.i++)
				            {
				              _localctx.relSibInfo.add(((OtherFeaturesContext)_localctx).feature.relSibInfo.get(_localctx.i));
				            }
				            
				            ((OtherFeaturesContext)_localctx).consList =  ((OtherFeaturesContext)_localctx).lbl_of.consList;
				            for (((OtherFeaturesContext)_localctx).i = 0; _localctx.i < ((OtherFeaturesContext)_localctx).feature.consList.size(); _localctx.i++)
				            {
				              _localctx.consList.add(((OtherFeaturesContext)_localctx).feature.consList.get(_localctx.i));
				            }
				            
				            ((OtherFeaturesContext)_localctx).idCheckList =  ((OtherFeaturesContext)_localctx).lbl_of.idCheckList;
				            for (((OtherFeaturesContext)_localctx).i = 0; _localctx.i < ((OtherFeaturesContext)_localctx).feature.idCheckList.size(); _localctx.i++)
				            {
				              _localctx.idCheckList.add(((OtherFeaturesContext)_localctx).feature.idCheckList.get(_localctx.i));
				            }
				          
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{

				            ((OtherFeaturesContext)_localctx).declaredFeats =  _localctx.i_declaredFeats;
				            ((OtherFeaturesContext)_localctx).featAttrs =  new ArrayList();
				            ((OtherFeaturesContext)_localctx).parInfo =  _localctx.i_parInfo;
				            ((OtherFeaturesContext)_localctx).decInfo =  new ArrayList();
				            ((OtherFeaturesContext)_localctx).relSibInfo =  new ArrayList();
				            ((OtherFeaturesContext)_localctx).consList =  new ArrayList();
				            ((OtherFeaturesContext)_localctx).idCheckList =  new ArrayList();
				          
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

	public static class FeatureContext extends ParserRuleContext {
		public ArrayList i_strEnumValues;
		public ArrayList i_declaredFeats;
		public ArrayList i_parInfo;
		public String name;
		public ArrayList declaredFeats;
		public ArrayList featAttrs;
		public ArrayList parInfo;
		public ArrayList decInfo;
		public ArrayList relSibInfo;
		public ArrayList consList;
		public ArrayList idCheckList;
		public int i;
		public String featName;
		public ArrayList atr;
		public IdContext id;
		public FeatureBodyContext featureBody;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public FeatureBodyContext featureBody() {
			return getRuleContext(FeatureBodyContext.class,0);
		}
		public FeatureContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FeatureContext(ParserRuleContext parent, int invokingState, ArrayList i_strEnumValues, ArrayList i_declaredFeats, ArrayList i_parInfo) {
			super(parent, invokingState);
			this.i_strEnumValues = i_strEnumValues;
			this.i_declaredFeats = i_declaredFeats;
			this.i_parInfo = i_parInfo;
		}
		@Override public int getRuleIndex() { return RULE_feature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitFeature(this);
		}
	}

	public final FeatureContext feature(ArrayList i_strEnumValues,ArrayList i_declaredFeats,ArrayList i_parInfo) throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState(), i_strEnumValues, i_declaredFeats, i_parInfo);
		enterRule(_localctx, 12, RULE_feature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			((FeatureContext)_localctx).id = id();
			setState(88);
			match(T__3);
			setState(89);
			((FeatureContext)_localctx).featureBody = featureBody(i_strEnumValues, i_parInfo, (((FeatureContext)_localctx).id!=null?_input.getText(((FeatureContext)_localctx).id.start,((FeatureContext)_localctx).id.stop):null));
			setState(90);
			match(T__4);

			            for (((FeatureContext)_localctx).i = 0; _localctx.i < _localctx.i_declaredFeats.size(); _localctx.i++)
			            {
			              ((FeatureContext)_localctx).featName =  (String) _localctx.i_declaredFeats.get(_localctx.i);
			              if ( (((FeatureContext)_localctx).id!=null?_input.getText(((FeatureContext)_localctx).id.start,((FeatureContext)_localctx).id.stop):null).equals(_localctx.featName) )
			              {
			                 // This means that the attribute id is already used, take necessary actions
			                 notifyErrorListeners(((FeatureContext)_localctx).id.lineNo + ": the feature \"" + (((FeatureContext)_localctx).id!=null?_input.getText(((FeatureContext)_localctx).id.start,((FeatureContext)_localctx).id.stop):null) + "\" is already declared");
			              }
			            }
			            
			            ((FeatureContext)_localctx).name =  (((FeatureContext)_localctx).id!=null?_input.getText(((FeatureContext)_localctx).id.start,((FeatureContext)_localctx).id.stop):null);
			            
			            ((FeatureContext)_localctx).declaredFeats =  _localctx.i_declaredFeats;
			            _localctx.declaredFeats.add((((FeatureContext)_localctx).id!=null?_input.getText(((FeatureContext)_localctx).id.start,((FeatureContext)_localctx).id.stop):null));
			            
			            ((FeatureContext)_localctx).atr =  new ArrayList();
			            _localctx.atr.add((((FeatureContext)_localctx).id!=null?_input.getText(((FeatureContext)_localctx).id.start,((FeatureContext)_localctx).id.stop):null));
			            _localctx.atr.add(((FeatureContext)_localctx).featureBody.attributes);
			            
			            ((FeatureContext)_localctx).featAttrs =  new ArrayList();
			            _localctx.featAttrs.add(_localctx.atr);
			            
			            ((FeatureContext)_localctx).parInfo =  ((FeatureContext)_localctx).featureBody.parInfo;
			            ((FeatureContext)_localctx).decInfo =  ((FeatureContext)_localctx).featureBody.decInfo;
			            ((FeatureContext)_localctx).relSibInfo =  ((FeatureContext)_localctx).featureBody.relSibInfo;
			            ((FeatureContext)_localctx).consList =  ((FeatureContext)_localctx).featureBody.consList;
			            ((FeatureContext)_localctx).idCheckList =  ((FeatureContext)_localctx).featureBody.idCheckList;
			          
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

	public static class FeatureBodyContext extends ParserRuleContext {
		public ArrayList i_strEnumValues;
		public ArrayList i_parInfo;
		public String i_parent;
		public ArrayList attributes;
		public ArrayList parInfo;
		public ArrayList decInfo;
		public ArrayList relSibInfo;
		public ArrayList consList;
		public ArrayList idCheckList;
		public AttributeListContext attributeList;
		public ChildrenContext children;
		public ConstraintListContext constraintList;
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public ChildrenContext children() {
			return getRuleContext(ChildrenContext.class,0);
		}
		public ConstraintListContext constraintList() {
			return getRuleContext(ConstraintListContext.class,0);
		}
		public FeatureBodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FeatureBodyContext(ParserRuleContext parent, int invokingState, ArrayList i_strEnumValues, ArrayList i_parInfo, String i_parent) {
			super(parent, invokingState);
			this.i_strEnumValues = i_strEnumValues;
			this.i_parInfo = i_parInfo;
			this.i_parent = i_parent;
		}
		@Override public int getRuleIndex() { return RULE_featureBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterFeatureBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitFeatureBody(this);
		}
	}

	public final FeatureBodyContext featureBody(ArrayList i_strEnumValues,ArrayList i_parInfo,String i_parent) throws RecognitionException {
		FeatureBodyContext _localctx = new FeatureBodyContext(_ctx, getState(), i_strEnumValues, i_parInfo, i_parent);
		enterRule(_localctx, 14, RULE_featureBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			((FeatureBodyContext)_localctx).attributeList = attributeList(i_strEnumValues, new ArrayList());
			setState(94);
			((FeatureBodyContext)_localctx).children = children(i_parInfo, i_parent);
			setState(95);
			((FeatureBodyContext)_localctx).constraintList = constraintList();

			            ((FeatureBodyContext)_localctx).attributes =  ((FeatureBodyContext)_localctx).attributeList.attributes;
			            
			            ((FeatureBodyContext)_localctx).parInfo =  ((FeatureBodyContext)_localctx).children.parInfo;
			            ((FeatureBodyContext)_localctx).decInfo =  ((FeatureBodyContext)_localctx).children.decInfo;
			            ((FeatureBodyContext)_localctx).relSibInfo =  ((FeatureBodyContext)_localctx).children.relSibInfo;
			            
			            ((FeatureBodyContext)_localctx).consList =  ((FeatureBodyContext)_localctx).constraintList.consList;
			            ((FeatureBodyContext)_localctx).idCheckList =  ((FeatureBodyContext)_localctx).constraintList.idCheckList;
			          
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
		public ArrayList i_strEnumValues;
		public ArrayList i_setOfAttrs;
		public ArrayList attributes;
		public AttributeContext attribute;
		public AttributeListContext lbl_al;
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public AttributeListContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AttributeListContext(ParserRuleContext parent, int invokingState, ArrayList i_strEnumValues, ArrayList i_setOfAttrs) {
			super(parent, invokingState);
			this.i_strEnumValues = i_strEnumValues;
			this.i_setOfAttrs = i_setOfAttrs;
		}
		@Override public int getRuleIndex() { return RULE_attributeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterAttributeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitAttributeList(this);
		}
	}

	public final AttributeListContext attributeList(ArrayList i_strEnumValues,ArrayList i_setOfAttrs) throws RecognitionException {
		AttributeListContext _localctx = new AttributeListContext(_ctx, getState(), i_strEnumValues, i_setOfAttrs);
		enterRule(_localctx, 16, RULE_attributeList);
		try {
			setState(103);
			switch (_input.LA(1)) {
			case T__1:
			case T__8:
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				((AttributeListContext)_localctx).attribute = attribute(i_strEnumValues, i_setOfAttrs);
				setState(99);
				((AttributeListContext)_localctx).lbl_al = attributeList(i_strEnumValues, ((AttributeListContext)_localctx).attribute.setOfAttrs);

				            ((AttributeListContext)_localctx).attributes =  ((AttributeListContext)_localctx).lbl_al.attributes;
				            _localctx.attributes.add(((AttributeListContext)_localctx).attribute.attributes.get(0));
				          
				}
				break;
			case T__4:
			case T__12:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				 ((AttributeListContext)_localctx).attributes =  new ArrayList(); 
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

	public static class AttributeContext extends ParserRuleContext {
		public ArrayList i_strEnumValues;
		public ArrayList i_setOfAttrs;
		public ArrayList attributes;
		public ArrayList setOfAttrs;
		public int i;
		public String existingValue;
		public ArrayList attrInfo;
		public boolean found;
		public AttrIDContext attrID;
		public Token INTEGER_LITERAL;
		public Token REAL_LITERAL;
		public Bool_literalContext bool_literal;
		public String_literalContext string_literal;
		public AttrIDContext attrID() {
			return getRuleContext(AttrIDContext.class,0);
		}
		public TerminalNode INTEGER_LITERAL() { return getToken(TVLParser.INTEGER_LITERAL, 0); }
		public TerminalNode REAL_LITERAL() { return getToken(TVLParser.REAL_LITERAL, 0); }
		public Bool_literalContext bool_literal() {
			return getRuleContext(Bool_literalContext.class,0);
		}
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AttributeContext(ParserRuleContext parent, int invokingState, ArrayList i_strEnumValues, ArrayList i_setOfAttrs) {
			super(parent, invokingState);
			this.i_strEnumValues = i_strEnumValues;
			this.i_setOfAttrs = i_setOfAttrs;
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute(ArrayList i_strEnumValues,ArrayList i_setOfAttrs) throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState(), i_strEnumValues, i_setOfAttrs);
		enterRule(_localctx, 18, RULE_attribute);
		try {
			setState(133);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(T__8);
				setState(106);
				((AttributeContext)_localctx).attrID = attrID();
				setState(107);
				match(T__9);
				setState(108);
				((AttributeContext)_localctx).INTEGER_LITERAL = match(INTEGER_LITERAL);
				setState(109);
				match(T__5);

				            for (((AttributeContext)_localctx).i = 0; _localctx.i < _localctx.i_setOfAttrs.size(); _localctx.i++)
				            {
				              ((AttributeContext)_localctx).existingValue =  (String) _localctx.i_setOfAttrs.get(_localctx.i);
				              if ( (((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null).equals(_localctx.existingValue) )
				              {
				                 // This means that the attribute id is already used, take necessary actions
				                 notifyErrorListeners(((AttributeContext)_localctx).attrID.lineNo + ": the attribute \"" + (((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null) + "\" is already declared");
				              }
				            }
				            
				            ((AttributeContext)_localctx).setOfAttrs =  _localctx.i_setOfAttrs;
				            _localctx.setOfAttrs.add((((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null));
				            
				            ((AttributeContext)_localctx).attrInfo =  new ArrayList();
				            _localctx.attrInfo.add((((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null));
				            _localctx.attrInfo.add((((AttributeContext)_localctx).INTEGER_LITERAL!=null?((AttributeContext)_localctx).INTEGER_LITERAL.getText():null));
				            
				            ((AttributeContext)_localctx).attributes =  new ArrayList();
				            _localctx.attributes.add(_localctx.attrInfo);
				          
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(T__10);
				setState(113);
				((AttributeContext)_localctx).attrID = attrID();
				setState(114);
				match(T__9);
				setState(115);
				((AttributeContext)_localctx).REAL_LITERAL = match(REAL_LITERAL);
				setState(116);
				match(T__5);

				            for (((AttributeContext)_localctx).i = 0; _localctx.i < _localctx.i_setOfAttrs.size(); _localctx.i++)
				            {
				              ((AttributeContext)_localctx).existingValue =  (String) _localctx.i_setOfAttrs.get(_localctx.i);
				              if ( (((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null).equals(_localctx.existingValue) )
				              {
				                 // This means that the attribute id is already used, take necessary actions
				                 notifyErrorListeners(((AttributeContext)_localctx).attrID.lineNo + ": the attribute \"" + (((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null) + "\" is already declared");
				              }
				            }
				            
				            
				            ((AttributeContext)_localctx).setOfAttrs =  _localctx.i_setOfAttrs;
				            _localctx.setOfAttrs.add((((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null));
				            
				            ((AttributeContext)_localctx).attrInfo =  new ArrayList();
				            _localctx.attrInfo.add((((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null));
				            _localctx.attrInfo.add((((AttributeContext)_localctx).REAL_LITERAL!=null?((AttributeContext)_localctx).REAL_LITERAL.getText():null));
				            
				            ((AttributeContext)_localctx).attributes =  new ArrayList();
				            _localctx.attributes.add(_localctx.attrInfo);
				          
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				match(T__11);
				setState(120);
				((AttributeContext)_localctx).attrID = attrID();
				setState(121);
				match(T__9);
				setState(122);
				((AttributeContext)_localctx).bool_literal = bool_literal();
				setState(123);
				match(T__5);

				            for (((AttributeContext)_localctx).i = 0; _localctx.i < _localctx.i_setOfAttrs.size(); _localctx.i++)
				            {
				              ((AttributeContext)_localctx).existingValue =  (String) _localctx.i_setOfAttrs.get(_localctx.i);
				              if ( (((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null).equals(_localctx.existingValue) )
				              {
				                 // This means that the attribute id is already used, take necessary actions
				                 notifyErrorListeners(((AttributeContext)_localctx).attrID.lineNo + ": the attribute \"" + (((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null) + "\" is already declared");
				              }
				            }
				            
				            
				            ((AttributeContext)_localctx).setOfAttrs =  _localctx.i_setOfAttrs;
				            _localctx.setOfAttrs.add((((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null));
				            
				            ((AttributeContext)_localctx).attrInfo =  new ArrayList();
				            _localctx.attrInfo.add((((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null));
				            _localctx.attrInfo.add((((AttributeContext)_localctx).bool_literal!=null?_input.getText(((AttributeContext)_localctx).bool_literal.start,((AttributeContext)_localctx).bool_literal.stop):null));
				            
				            ((AttributeContext)_localctx).attributes =  new ArrayList();
				            _localctx.attributes.add(_localctx.attrInfo);
				          
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				match(T__1);
				setState(127);
				((AttributeContext)_localctx).attrID = attrID();
				setState(128);
				match(T__9);
				setState(129);
				((AttributeContext)_localctx).string_literal = string_literal();
				setState(130);
				match(T__5);

				            for (((AttributeContext)_localctx).i = 0; _localctx.i < _localctx.i_setOfAttrs.size(); _localctx.i++)
				            {
				              ((AttributeContext)_localctx).existingValue =  (String) _localctx.i_setOfAttrs.get(_localctx.i);
				              if ( (((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null).equals(_localctx.existingValue) )
				              {
				                 // This means that the attribute id is already used, take necessary actions
				                 notifyErrorListeners(((AttributeContext)_localctx).attrID.lineNo + ": the attribute \"" + (((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null) + "\" is already declared");
				              }
				            }
				            
				            ((AttributeContext)_localctx).found =  false;
				            for (((AttributeContext)_localctx).i = 0; _localctx.i < _localctx.i_strEnumValues.size(); _localctx.i++)
				            {
				              ((AttributeContext)_localctx).existingValue =  (String) _localctx.i_strEnumValues.get(_localctx.i);
				              if ( (((AttributeContext)_localctx).string_literal!=null?_input.getText(((AttributeContext)_localctx).string_literal.start,((AttributeContext)_localctx).string_literal.stop):null).equals(_localctx.existingValue) )
				              {
				                ((AttributeContext)_localctx).found =  true;
				                break;
				              }
				            }
				            if ( ! _localctx.found )
				            {
				              // This means an undeclared string enumeration is used, take necessary actions
				                 notifyErrorListeners(((AttributeContext)_localctx).string_literal.lineNo + ": the string literal " + (((AttributeContext)_localctx).string_literal!=null?_input.getText(((AttributeContext)_localctx).string_literal.start,((AttributeContext)_localctx).string_literal.stop):null) + " is not declared");
				            }
				            
				            
				            ((AttributeContext)_localctx).setOfAttrs =  _localctx.i_setOfAttrs;
				            _localctx.setOfAttrs.add((((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null));
				            
				            ((AttributeContext)_localctx).attrInfo =  new ArrayList();
				            _localctx.attrInfo.add((((AttributeContext)_localctx).attrID!=null?_input.getText(((AttributeContext)_localctx).attrID.start,((AttributeContext)_localctx).attrID.stop):null));
				            _localctx.attrInfo.add((((AttributeContext)_localctx).string_literal!=null?_input.getText(((AttributeContext)_localctx).string_literal.start,((AttributeContext)_localctx).string_literal.stop):null));
				            
				            ((AttributeContext)_localctx).attributes =  new ArrayList();
				            _localctx.attributes.add(_localctx.attrInfo);
				          
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

	public static class ChildrenContext extends ParserRuleContext {
		public ArrayList i_parInfo;
		public String i_parent;
		public ArrayList parInfo;
		public ArrayList decInfo;
		public ArrayList relSibInfo;
		public int i;
		public FeatureGroupContext featureGroup;
		public ChildrenContext lbl_c;
		public FeatureGroupContext featureGroup() {
			return getRuleContext(FeatureGroupContext.class,0);
		}
		public ChildrenContext children() {
			return getRuleContext(ChildrenContext.class,0);
		}
		public ChildrenContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ChildrenContext(ParserRuleContext parent, int invokingState, ArrayList i_parInfo, String i_parent) {
			super(parent, invokingState);
			this.i_parInfo = i_parInfo;
			this.i_parent = i_parent;
		}
		@Override public int getRuleIndex() { return RULE_children; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterChildren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitChildren(this);
		}
	}

	public final ChildrenContext children(ArrayList i_parInfo,String i_parent) throws RecognitionException {
		ChildrenContext _localctx = new ChildrenContext(_ctx, getState(), i_parInfo, i_parent);
		enterRule(_localctx, 20, RULE_children);
		try {
			setState(140);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				((ChildrenContext)_localctx).featureGroup = featureGroup(i_parInfo, i_parent);
				setState(136);
				((ChildrenContext)_localctx).lbl_c = children(((ChildrenContext)_localctx).featureGroup.parInfo, i_parent);

				            ((ChildrenContext)_localctx).parInfo =  ((ChildrenContext)_localctx).lbl_c.parInfo;
				            
				            ((ChildrenContext)_localctx).decInfo =  ((ChildrenContext)_localctx).lbl_c.decInfo;
				            for (((ChildrenContext)_localctx).i = 0; _localctx.i < ((ChildrenContext)_localctx).featureGroup.decInfo.size(); _localctx.i++)
				            {
				              _localctx.decInfo.add(((ChildrenContext)_localctx).featureGroup.decInfo.get(_localctx.i));
				            }
				            
				            ((ChildrenContext)_localctx).relSibInfo =  ((ChildrenContext)_localctx).lbl_c.relSibInfo;
				            for (((ChildrenContext)_localctx).i = 0; _localctx.i < ((ChildrenContext)_localctx).featureGroup.relSibInfo.size(); _localctx.i++)
				            {
				              _localctx.relSibInfo.add(((ChildrenContext)_localctx).featureGroup.relSibInfo.get(_localctx.i));
				            }
				          
				}
				break;
			case T__4:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{

				            ((ChildrenContext)_localctx).parInfo =  _localctx.i_parInfo;
				            ((ChildrenContext)_localctx).decInfo =  new ArrayList();
				            ((ChildrenContext)_localctx).relSibInfo =  new ArrayList();
				          
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

	public static class FeatureGroupContext extends ParserRuleContext {
		public ArrayList i_parInfo;
		public String i_parent;
		public ArrayList parInfo;
		public ArrayList decInfo;
		public ArrayList relSibInfo;
		public SolitaryIDListContext solitaryIDList;
		public CardinalityContext cardinality;
		public IdListContext idList;
		public SolitaryIDListContext solitaryIDList() {
			return getRuleContext(SolitaryIDListContext.class,0);
		}
		public CardinalityContext cardinality() {
			return getRuleContext(CardinalityContext.class,0);
		}
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public FeatureGroupContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FeatureGroupContext(ParserRuleContext parent, int invokingState, ArrayList i_parInfo, String i_parent) {
			super(parent, invokingState);
			this.i_parInfo = i_parInfo;
			this.i_parent = i_parent;
		}
		@Override public int getRuleIndex() { return RULE_featureGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterFeatureGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitFeatureGroup(this);
		}
	}

	public final FeatureGroupContext featureGroup(ArrayList i_parInfo,String i_parent) throws RecognitionException {
		FeatureGroupContext _localctx = new FeatureGroupContext(_ctx, getState(), i_parInfo, i_parent);
		enterRule(_localctx, 22, RULE_featureGroup);
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(T__12);
				setState(143);
				match(T__13);
				setState(144);
				match(T__3);
				setState(145);
				((FeatureGroupContext)_localctx).solitaryIDList = solitaryIDList(i_parInfo, i_parent);
				setState(146);
				match(T__4);

				            ((FeatureGroupContext)_localctx).parInfo =  ((FeatureGroupContext)_localctx).solitaryIDList.parInfo;
				            ((FeatureGroupContext)_localctx).decInfo =  ((FeatureGroupContext)_localctx).solitaryIDList.decInfo;
				            ((FeatureGroupContext)_localctx).relSibInfo =  new ArrayList();
				          
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(T__12);
				setState(150);
				((FeatureGroupContext)_localctx).cardinality = cardinality();
				setState(151);
				match(T__3);
				setState(152);
				((FeatureGroupContext)_localctx).idList = idList(i_parInfo, i_parent, ((FeatureGroupContext)_localctx).cardinality.decomp, "");
				setState(153);
				match(T__4);

				            ((FeatureGroupContext)_localctx).parInfo =  ((FeatureGroupContext)_localctx).idList.parInfo;
				            ((FeatureGroupContext)_localctx).decInfo =  ((FeatureGroupContext)_localctx).idList.decInfo;
				            ((FeatureGroupContext)_localctx).relSibInfo =  ((FeatureGroupContext)_localctx).idList.relSibInfo;
				          
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

	public static class SolitaryIDListContext extends ParserRuleContext {
		public ArrayList i_parInfo;
		public String i_parent;
		public ArrayList parInfo;
		public ArrayList decInfo;
		public int i;
		public ArrayList dec;
		public ArrayList par;
		public OptionalContext optional;
		public IdContext id;
		public Pp_parentInformationContext pp_parentInformation;
		public SolitaryIDListContext lbl_sidl;
		public OptionalContext optional() {
			return getRuleContext(OptionalContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Pp_parentInformationContext pp_parentInformation() {
			return getRuleContext(Pp_parentInformationContext.class,0);
		}
		public SolitaryIDListContext solitaryIDList() {
			return getRuleContext(SolitaryIDListContext.class,0);
		}
		public SolitaryIDListContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SolitaryIDListContext(ParserRuleContext parent, int invokingState, ArrayList i_parInfo, String i_parent) {
			super(parent, invokingState);
			this.i_parInfo = i_parInfo;
			this.i_parent = i_parent;
		}
		@Override public int getRuleIndex() { return RULE_solitaryIDList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterSolitaryIDList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitSolitaryIDList(this);
		}
	}

	public final SolitaryIDListContext solitaryIDList(ArrayList i_parInfo,String i_parent) throws RecognitionException {
		SolitaryIDListContext _localctx = new SolitaryIDListContext(_ctx, getState(), i_parInfo, i_parent);
		enterRule(_localctx, 24, RULE_solitaryIDList);
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				((SolitaryIDListContext)_localctx).optional = optional();
				setState(159);
				((SolitaryIDListContext)_localctx).id = id();

				            ((SolitaryIDListContext)_localctx).dec =  new ArrayList();
				            _localctx.dec.add((((SolitaryIDListContext)_localctx).id!=null?_input.getText(((SolitaryIDListContext)_localctx).id.start,((SolitaryIDListContext)_localctx).id.stop):null));
				            _localctx.dec.add(((SolitaryIDListContext)_localctx).optional.decomp);
				            
				            ((SolitaryIDListContext)_localctx).decInfo =  new ArrayList();
				            _localctx.decInfo.add(_localctx.dec);
				            
				            for (((SolitaryIDListContext)_localctx).i = 0; _localctx.i < _localctx.i_parInfo.size(); _localctx.i++)
				            {
				              ((SolitaryIDListContext)_localctx).par =  (ArrayList) _localctx.i_parInfo.get(_localctx.i);
				              if ( ((String) _localctx.par.get(0)).equals((((SolitaryIDListContext)_localctx).id!=null?_input.getText(((SolitaryIDListContext)_localctx).id.start,((SolitaryIDListContext)_localctx).id.stop):null)) )
				              {
				                 // This means that this feature is already declared to be the child of a feature, take necessary actions
				                 notifyErrorListeners(((SolitaryIDListContext)_localctx).id.lineNo + ": the feature \"" + (((SolitaryIDListContext)_localctx).id!=null?_input.getText(((SolitaryIDListContext)_localctx).id.start,((SolitaryIDListContext)_localctx).id.stop):null) + "\" is already declared to be a child of a feature");
				              }
				            }
				            
				            ((SolitaryIDListContext)_localctx).par =  new ArrayList();
				            _localctx.par.add((((SolitaryIDListContext)_localctx).id!=null?_input.getText(((SolitaryIDListContext)_localctx).id.start,((SolitaryIDListContext)_localctx).id.stop):null));
				            _localctx.par.add(_localctx.i_parent);
				            
				            ((SolitaryIDListContext)_localctx).parInfo =  _localctx.i_parInfo;
				            _localctx.parInfo.add(_localctx.par);
				          
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				((SolitaryIDListContext)_localctx).optional = optional();
				setState(163);
				((SolitaryIDListContext)_localctx).id = id();
				setState(164);
				match(T__6);
				setState(165);
				((SolitaryIDListContext)_localctx).pp_parentInformation = pp_parentInformation((((SolitaryIDListContext)_localctx).id!=null?_input.getText(((SolitaryIDListContext)_localctx).id.start,((SolitaryIDListContext)_localctx).id.stop):null), i_parent, i_parInfo);
				setState(166);
				((SolitaryIDListContext)_localctx).lbl_sidl = solitaryIDList(((SolitaryIDListContext)_localctx).pp_parentInformation.parInfo, i_parent);

				            for (((SolitaryIDListContext)_localctx).i = 0; _localctx.i < _localctx.i_parInfo.size(); _localctx.i++)
				            {
				              ((SolitaryIDListContext)_localctx).par =  (ArrayList) _localctx.i_parInfo.get(_localctx.i);
				              if ( ((String) _localctx.par.get(0)).equals((((SolitaryIDListContext)_localctx).id!=null?_input.getText(((SolitaryIDListContext)_localctx).id.start,((SolitaryIDListContext)_localctx).id.stop):null)) )
				              {
				                 // This means that this feature is already declared to be the child of a feature, take necessary actions
				                 notifyErrorListeners(((SolitaryIDListContext)_localctx).id.lineNo + ": the feature \"" + (((SolitaryIDListContext)_localctx).id!=null?_input.getText(((SolitaryIDListContext)_localctx).id.start,((SolitaryIDListContext)_localctx).id.stop):null) + "\" is already declared to be a child of a feature");
				              }
				            }
				            
				            ((SolitaryIDListContext)_localctx).dec =  new ArrayList();
				            _localctx.dec.add((((SolitaryIDListContext)_localctx).id!=null?_input.getText(((SolitaryIDListContext)_localctx).id.start,((SolitaryIDListContext)_localctx).id.stop):null));
				            _localctx.dec.add(((SolitaryIDListContext)_localctx).optional.decomp);
				            
				            ((SolitaryIDListContext)_localctx).decInfo =  ((SolitaryIDListContext)_localctx).lbl_sidl.decInfo;
				            _localctx.decInfo.add(_localctx.dec);
				            
				            ((SolitaryIDListContext)_localctx).parInfo =  ((SolitaryIDListContext)_localctx).lbl_sidl.parInfo;
				          
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

	public static class OptionalContext extends ParserRuleContext {
		public String decomp;
		public OptionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterOptional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitOptional(this);
		}
	}

	public final OptionalContext optional() throws RecognitionException {
		OptionalContext _localctx = new OptionalContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_optional);
		try {
			setState(174);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(T__14);
				 ((OptionalContext)_localctx).decomp =  "optional"; 
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				 ((OptionalContext)_localctx).decomp =  "mandatory"; 
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

	public static class Pp_parentInformationContext extends ParserRuleContext {
		public String featName;
		public String parName;
		public ArrayList existingPars;
		public ArrayList parInfo;
		public int i;
		public ArrayList par;
		public Pp_parentInformationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Pp_parentInformationContext(ParserRuleContext parent, int invokingState, String featName, String parName, ArrayList existingPars) {
			super(parent, invokingState);
			this.featName = featName;
			this.parName = parName;
			this.existingPars = existingPars;
		}
		@Override public int getRuleIndex() { return RULE_pp_parentInformation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterPp_parentInformation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitPp_parentInformation(this);
		}
	}

	public final Pp_parentInformationContext pp_parentInformation(String featName,String parName,ArrayList existingPars) throws RecognitionException {
		Pp_parentInformationContext _localctx = new Pp_parentInformationContext(_ctx, getState(), featName, parName, existingPars);
		enterRule(_localctx, 28, RULE_pp_parentInformation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
			        ((Pp_parentInformationContext)_localctx).parInfo =  new ArrayList();
			        for (((Pp_parentInformationContext)_localctx).i = 0; _localctx.i < _localctx.existingPars.size(); _localctx.i++)
			        {
			          _localctx.parInfo.add(_localctx.existingPars.get(_localctx.i));
			        }
			        
			        ((Pp_parentInformationContext)_localctx).par =  new ArrayList();
			        _localctx.par.add(_localctx.featName);
			        _localctx.par.add(_localctx.parName);
			            
			        _localctx.parInfo.add(_localctx.par);
			      
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

	public static class IdListContext extends ParserRuleContext {
		public ArrayList i_parInfo;
		public String i_parent;
		public String i_decomp;
		public String i_relSibling;
		public ArrayList parInfo;
		public ArrayList decInfo;
		public ArrayList relSibInfo;
		public String relSibling;
		public int i;
		public ArrayList dec;
		public ArrayList par;
		public ArrayList rel;
		public IdContext id;
		public Pp_parentInformationContext pp_parentInformation;
		public IdListContext lbl_idl;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Pp_parentInformationContext pp_parentInformation() {
			return getRuleContext(Pp_parentInformationContext.class,0);
		}
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public IdListContext(ParserRuleContext parent, int invokingState, ArrayList i_parInfo, String i_parent, String i_decomp, String i_relSibling) {
			super(parent, invokingState);
			this.i_parInfo = i_parInfo;
			this.i_parent = i_parent;
			this.i_decomp = i_decomp;
			this.i_relSibling = i_relSibling;
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitIdList(this);
		}
	}

	public final IdListContext idList(ArrayList i_parInfo,String i_parent,String i_decomp,String i_relSibling) throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState(), i_parInfo, i_parent, i_decomp, i_relSibling);
		enterRule(_localctx, 30, RULE_idList);
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				((IdListContext)_localctx).id = id();

				            ((IdListContext)_localctx).dec =  new ArrayList();
				            _localctx.dec.add((((IdListContext)_localctx).id!=null?_input.getText(((IdListContext)_localctx).id.start,((IdListContext)_localctx).id.stop):null));
				            _localctx.dec.add(_localctx.i_decomp);
				            
				            ((IdListContext)_localctx).decInfo =  new ArrayList();
				            _localctx.decInfo.add(_localctx.dec);
				            
				            for (((IdListContext)_localctx).i = 0; _localctx.i < _localctx.i_parInfo.size(); _localctx.i++)
				            {
				              ((IdListContext)_localctx).par =  (ArrayList) _localctx.i_parInfo.get(_localctx.i);
				              if ( ((String) _localctx.par.get(0)).equals((((IdListContext)_localctx).id!=null?_input.getText(((IdListContext)_localctx).id.start,((IdListContext)_localctx).id.stop):null)) )
				              {
				                 // This means that this feature is already declared to be the child of a feature, take necessary actions
				                 notifyErrorListeners(((IdListContext)_localctx).id.lineNo + ": the feature \"" + (((IdListContext)_localctx).id!=null?_input.getText(((IdListContext)_localctx).id.start,((IdListContext)_localctx).id.stop):null) + "\" is already declared to be a child of a feature");
				              }
				            }
				            
				            ((IdListContext)_localctx).par =  new ArrayList();
				            _localctx.par.add((((IdListContext)_localctx).id!=null?_input.getText(((IdListContext)_localctx).id.start,((IdListContext)_localctx).id.stop):null));
				            _localctx.par.add(_localctx.i_parent);
				            
				            ((IdListContext)_localctx).parInfo =  _localctx.i_parInfo;
				            _localctx.parInfo.add(_localctx.par);
				            
				            ((IdListContext)_localctx).rel =  new ArrayList();
				            _localctx.rel.add((((IdListContext)_localctx).id!=null?_input.getText(((IdListContext)_localctx).id.start,((IdListContext)_localctx).id.stop):null));
				            _localctx.rel.add(_localctx.i_relSibling);
				            
				            ((IdListContext)_localctx).relSibInfo =  new ArrayList();
				            _localctx.relSibInfo.add(_localctx.rel);
				            
				            ((IdListContext)_localctx).relSibling =  (((IdListContext)_localctx).id!=null?_input.getText(((IdListContext)_localctx).id.start,((IdListContext)_localctx).id.stop):null);
				          
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				((IdListContext)_localctx).id = id();
				setState(182);
				match(T__6);
				setState(183);
				((IdListContext)_localctx).pp_parentInformation = pp_parentInformation((((IdListContext)_localctx).id!=null?_input.getText(((IdListContext)_localctx).id.start,((IdListContext)_localctx).id.stop):null), i_parent, i_parInfo);
				setState(184);
				((IdListContext)_localctx).lbl_idl = idList(((IdListContext)_localctx).pp_parentInformation.parInfo, i_parent, i_decomp, (((IdListContext)_localctx).id!=null?_input.getText(((IdListContext)_localctx).id.start,((IdListContext)_localctx).id.stop):null));

				            for (((IdListContext)_localctx).i = 0; _localctx.i < _localctx.i_parInfo.size(); _localctx.i++)
				            {
				              ((IdListContext)_localctx).par =  (ArrayList) _localctx.i_parInfo.get(_localctx.i);
				              if ( ((String) _localctx.par.get(0)).equals((((IdListContext)_localctx).id!=null?_input.getText(((IdListContext)_localctx).id.start,((IdListContext)_localctx).id.stop):null)) )
				              {
				                 // This means that this feature is already declared to be the child of a feature, take necessary actions
				                 notifyErrorListeners(((IdListContext)_localctx).id.lineNo + ": the feature \"" + (((IdListContext)_localctx).id!=null?_input.getText(((IdListContext)_localctx).id.start,((IdListContext)_localctx).id.stop):null) + "\" is already declared to be a child of a feature");
				              }
				            }
				            
				            ((IdListContext)_localctx).dec =  new ArrayList();
				            _localctx.dec.add((((IdListContext)_localctx).id!=null?_input.getText(((IdListContext)_localctx).id.start,((IdListContext)_localctx).id.stop):null));
				            _localctx.dec.add(_localctx.i_decomp);
				            
				            ((IdListContext)_localctx).decInfo =  ((IdListContext)_localctx).lbl_idl.decInfo;
				            _localctx.decInfo.add(_localctx.dec);
				            
				            ((IdListContext)_localctx).parInfo =  ((IdListContext)_localctx).lbl_idl.parInfo;
				            
				            ((IdListContext)_localctx).rel =  new ArrayList();
				            _localctx.rel.add((((IdListContext)_localctx).id!=null?_input.getText(((IdListContext)_localctx).id.start,((IdListContext)_localctx).id.stop):null));
				            _localctx.rel.add(((IdListContext)_localctx).lbl_idl.relSibling);
				            
				            ((IdListContext)_localctx).relSibInfo =  ((IdListContext)_localctx).lbl_idl.relSibInfo;
				            _localctx.relSibInfo.add(_localctx.rel);
				            
				            ((IdListContext)_localctx).relSibling =  ((IdListContext)_localctx).lbl_idl.relSibling;
				          
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

	public static class CardinalityContext extends ParserRuleContext {
		public String decomp;
		public CardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterCardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitCardinality(this);
		}
	}

	public final CardinalityContext cardinality() throws RecognitionException {
		CardinalityContext _localctx = new CardinalityContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cardinality);
		try {
			setState(193);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(T__15);
				 ((CardinalityContext)_localctx).decomp =  "alternative"; 
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				match(T__16);
				 ((CardinalityContext)_localctx).decomp =  "or"; 
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

	public static class ConstraintListContext extends ParserRuleContext {
		public ArrayList consList;
		public ArrayList idCheckList;
		public ConstraintContext constraint;
		public ConstraintListContext lbl_cl;
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public ConstraintListContext constraintList() {
			return getRuleContext(ConstraintListContext.class,0);
		}
		public ConstraintListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterConstraintList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitConstraintList(this);
		}
	}

	public final ConstraintListContext constraintList() throws RecognitionException {
		ConstraintListContext _localctx = new ConstraintListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_constraintList);
		try {
			setState(200);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				((ConstraintListContext)_localctx).constraint = constraint();
				setState(196);
				((ConstraintListContext)_localctx).lbl_cl = constraintList();

				            ((ConstraintListContext)_localctx).consList =  ((ConstraintListContext)_localctx).lbl_cl.consList;
				            _localctx.consList.add(((ConstraintListContext)_localctx).constraint.consList.get(0));

				            ((ConstraintListContext)_localctx).idCheckList =  ((ConstraintListContext)_localctx).lbl_cl.idCheckList;
				            _localctx.idCheckList.add(((ConstraintListContext)_localctx).constraint.idCheckList.get(0));
				            _localctx.idCheckList.add(((ConstraintListContext)_localctx).constraint.idCheckList.get(1));
				          
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{

				            ((ConstraintListContext)_localctx).consList =  new ArrayList();
				            ((ConstraintListContext)_localctx).idCheckList =  new ArrayList(); 
				          
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

	public static class ConstraintContext extends ParserRuleContext {
		public ArrayList consList;
		public ArrayList idCheckList;
		public ArrayList cons;
		public IdContext lbl_f1;
		public IdContext lbl_f2;
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitConstraint(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_constraint);
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				((ConstraintContext)_localctx).lbl_f1 = id();
				setState(203);
				match(T__17);
				setState(204);
				((ConstraintContext)_localctx).lbl_f2 = id();
				setState(205);
				match(T__5);

				            ((ConstraintContext)_localctx).consList =  new ArrayList();
				            ((ConstraintContext)_localctx).idCheckList =  new ArrayList();
				            
				            ((ConstraintContext)_localctx).cons =  new ArrayList();
				            _localctx.cons.add((((ConstraintContext)_localctx).lbl_f1!=null?_input.getText(((ConstraintContext)_localctx).lbl_f1.start,((ConstraintContext)_localctx).lbl_f1.stop):null));
				            _localctx.cons.add("requires");
				            _localctx.cons.add((((ConstraintContext)_localctx).lbl_f2!=null?_input.getText(((ConstraintContext)_localctx).lbl_f2.start,((ConstraintContext)_localctx).lbl_f2.stop):null));
				            _localctx.consList.add(_localctx.cons);
				            
				            ((ConstraintContext)_localctx).cons =  new ArrayList();
				            _localctx.cons.add((((ConstraintContext)_localctx).lbl_f1!=null?_input.getText(((ConstraintContext)_localctx).lbl_f1.start,((ConstraintContext)_localctx).lbl_f1.stop):null));
				            _localctx.cons.add(((ConstraintContext)_localctx).lbl_f1.lineNo);
				            _localctx.idCheckList.add(_localctx.cons);
				            
				            ((ConstraintContext)_localctx).cons =  new ArrayList();
				            _localctx.cons.add((((ConstraintContext)_localctx).lbl_f2!=null?_input.getText(((ConstraintContext)_localctx).lbl_f2.start,((ConstraintContext)_localctx).lbl_f2.stop):null));
				            _localctx.cons.add(((ConstraintContext)_localctx).lbl_f2.lineNo);
				            _localctx.idCheckList.add(_localctx.cons);
				          
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				((ConstraintContext)_localctx).lbl_f1 = id();
				setState(209);
				match(T__18);
				setState(210);
				((ConstraintContext)_localctx).lbl_f2 = id();
				setState(211);
				match(T__5);

				            ((ConstraintContext)_localctx).consList =  new ArrayList();
				            ((ConstraintContext)_localctx).idCheckList =  new ArrayList();
				            
				            ((ConstraintContext)_localctx).cons =  new ArrayList();
				            _localctx.cons.add((((ConstraintContext)_localctx).lbl_f1!=null?_input.getText(((ConstraintContext)_localctx).lbl_f1.start,((ConstraintContext)_localctx).lbl_f1.stop):null));
				            _localctx.cons.add("excludes");
				            _localctx.cons.add((((ConstraintContext)_localctx).lbl_f2!=null?_input.getText(((ConstraintContext)_localctx).lbl_f2.start,((ConstraintContext)_localctx).lbl_f2.stop):null));
				            _localctx.consList.add(_localctx.cons);
				            
				            ((ConstraintContext)_localctx).cons =  new ArrayList();
				            _localctx.cons.add((((ConstraintContext)_localctx).lbl_f1!=null?_input.getText(((ConstraintContext)_localctx).lbl_f1.start,((ConstraintContext)_localctx).lbl_f1.stop):null));
				            _localctx.cons.add(((ConstraintContext)_localctx).lbl_f1.lineNo);
				            _localctx.idCheckList.add(_localctx.cons);
				            
				            ((ConstraintContext)_localctx).cons =  new ArrayList();
				            _localctx.cons.add((((ConstraintContext)_localctx).lbl_f2!=null?_input.getText(((ConstraintContext)_localctx).lbl_f2.start,((ConstraintContext)_localctx).lbl_f2.stop):null));
				            _localctx.cons.add(((ConstraintContext)_localctx).lbl_f2.lineNo);
				            _localctx.idCheckList.add(_localctx.cons);
				          
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

	public static class IdContext extends ParserRuleContext {
		public int lineNo;
		public int posNo;
		public Token NAME;
		public TerminalNode NAME() { return getToken(TVLParser.NAME, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			((IdContext)_localctx).NAME = match(NAME);
			 ((IdContext)_localctx).lineNo =  (((IdContext)_localctx).NAME!=null?((IdContext)_localctx).NAME.getLine():0); ((IdContext)_localctx).posNo =  (((IdContext)_localctx).NAME!=null?((IdContext)_localctx).NAME.getCharPositionInLine():0) + 1; 
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

	public static class AttrIDContext extends ParserRuleContext {
		public int lineNo;
		public int posNo;
		public Token ATTR_NAME;
		public TerminalNode ATTR_NAME() { return getToken(TVLParser.ATTR_NAME, 0); }
		public AttrIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterAttrID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitAttrID(this);
		}
	}

	public final AttrIDContext attrID() throws RecognitionException {
		AttrIDContext _localctx = new AttrIDContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_attrID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			((AttrIDContext)_localctx).ATTR_NAME = match(ATTR_NAME);
			 ((AttrIDContext)_localctx).lineNo =  (((AttrIDContext)_localctx).ATTR_NAME!=null?((AttrIDContext)_localctx).ATTR_NAME.getLine():0); ((AttrIDContext)_localctx).posNo =  (((AttrIDContext)_localctx).ATTR_NAME!=null?((AttrIDContext)_localctx).ATTR_NAME.getCharPositionInLine():0) + 1; 
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
		public Bool_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterBool_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitBool_literal(this);
		}
	}

	public final Bool_literalContext bool_literal() throws RecognitionException {
		Bool_literalContext _localctx = new Bool_literalContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_bool_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			_la = _input.LA(1);
			if ( !(_la==T__19 || _la==T__20) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class String_literalContext extends ParserRuleContext {
		public int lineNo;
		public int posNo;
		public Token STRING_LITERAL;
		public TerminalNode STRING_LITERAL() { return getToken(TVLParser.STRING_LITERAL, 0); }
		public String_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).enterString_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVLListener ) ((TVLListener)listener).exitString_literal(this);
		}
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			((String_literalContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
			 ((String_literalContext)_localctx).lineNo =  (((String_literalContext)_localctx).STRING_LITERAL!=null?((String_literalContext)_localctx).STRING_LITERAL.getLine():0); ((String_literalContext)_localctx).posNo =  (((String_literalContext)_localctx).STRING_LITERAL!=null?((String_literalContext)_localctx).STRING_LITERAL.getCharPositionInLine():0) + 1; 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35\u00e6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3?\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4I\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\5\7X\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\5\nj\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13\u0088\n\13\3\f\3\f\3\f\3\f\3\f\5\f\u008f"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009f"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ac"+
		"\n\16\3\17\3\17\3\17\5\17\u00b1\n\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00be\n\21\3\22\3\22\3\22\3\22\5\22\u00c4\n"+
		"\22\3\23\3\23\3\23\3\23\3\23\5\23\u00cb\n\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00d9\n\24\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\2\2\31\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\2\3\3\2\26\27\u00dd\2\60\3\2\2\2\4>\3\2\2\2\6"+
		"H\3\2\2\2\bJ\3\2\2\2\nN\3\2\2\2\fW\3\2\2\2\16Y\3\2\2\2\20_\3\2\2\2\22"+
		"i\3\2\2\2\24\u0087\3\2\2\2\26\u008e\3\2\2\2\30\u009e\3\2\2\2\32\u00ab"+
		"\3\2\2\2\34\u00b0\3\2\2\2\36\u00b2\3\2\2\2 \u00bd\3\2\2\2\"\u00c3\3\2"+
		"\2\2$\u00ca\3\2\2\2&\u00d8\3\2\2\2(\u00da\3\2\2\2*\u00dd\3\2\2\2,\u00e0"+
		"\3\2\2\2.\u00e2\3\2\2\2\60\61\5\4\3\2\61\62\5\b\5\2\62\63\b\2\1\2\63\3"+
		"\3\2\2\2\64\65\7\3\2\2\65\66\7\4\2\2\66\67\7\5\2\2\678\7\6\2\289\5\6\4"+
		"\29:\7\7\2\2:;\7\b\2\2;<\b\3\1\2<?\3\2\2\2=?\b\3\1\2>\64\3\2\2\2>=\3\2"+
		"\2\2?\5\3\2\2\2@A\5.\30\2AB\b\4\1\2BI\3\2\2\2CD\5.\30\2DE\7\t\2\2EF\5"+
		"\6\4\2FG\b\4\1\2GI\3\2\2\2H@\3\2\2\2HC\3\2\2\2I\7\3\2\2\2JK\5\n\6\2KL"+
		"\5\f\7\2LM\b\5\1\2M\t\3\2\2\2NO\7\n\2\2OP\5\16\b\2PQ\b\6\1\2Q\13\3\2\2"+
		"\2RS\5\16\b\2ST\5\f\7\2TU\b\7\1\2UX\3\2\2\2VX\b\7\1\2WR\3\2\2\2WV\3\2"+
		"\2\2X\r\3\2\2\2YZ\5(\25\2Z[\7\6\2\2[\\\5\20\t\2\\]\7\7\2\2]^\b\b\1\2^"+
		"\17\3\2\2\2_`\5\22\n\2`a\5\26\f\2ab\5$\23\2bc\b\t\1\2c\21\3\2\2\2de\5"+
		"\24\13\2ef\5\22\n\2fg\b\n\1\2gj\3\2\2\2hj\b\n\1\2id\3\2\2\2ih\3\2\2\2"+
		"j\23\3\2\2\2kl\7\13\2\2lm\5*\26\2mn\7\f\2\2no\7\32\2\2op\7\b\2\2pq\b\13"+
		"\1\2q\u0088\3\2\2\2rs\7\r\2\2st\5*\26\2tu\7\f\2\2uv\7\33\2\2vw\7\b\2\2"+
		"wx\b\13\1\2x\u0088\3\2\2\2yz\7\16\2\2z{\5*\26\2{|\7\f\2\2|}\5,\27\2}~"+
		"\7\b\2\2~\177\b\13\1\2\177\u0088\3\2\2\2\u0080\u0081\7\4\2\2\u0081\u0082"+
		"\5*\26\2\u0082\u0083\7\f\2\2\u0083\u0084\5.\30\2\u0084\u0085\7\b\2\2\u0085"+
		"\u0086\b\13\1\2\u0086\u0088\3\2\2\2\u0087k\3\2\2\2\u0087r\3\2\2\2\u0087"+
		"y\3\2\2\2\u0087\u0080\3\2\2\2\u0088\25\3\2\2\2\u0089\u008a\5\30\r\2\u008a"+
		"\u008b\5\26\f\2\u008b\u008c\b\f\1\2\u008c\u008f\3\2\2\2\u008d\u008f\b"+
		"\f\1\2\u008e\u0089\3\2\2\2\u008e\u008d\3\2\2\2\u008f\27\3\2\2\2\u0090"+
		"\u0091\7\17\2\2\u0091\u0092\7\20\2\2\u0092\u0093\7\6\2\2\u0093\u0094\5"+
		"\32\16\2\u0094\u0095\7\7\2\2\u0095\u0096\b\r\1\2\u0096\u009f\3\2\2\2\u0097"+
		"\u0098\7\17\2\2\u0098\u0099\5\"\22\2\u0099\u009a\7\6\2\2\u009a\u009b\5"+
		" \21\2\u009b\u009c\7\7\2\2\u009c\u009d\b\r\1\2\u009d\u009f\3\2\2\2\u009e"+
		"\u0090\3\2\2\2\u009e\u0097\3\2\2\2\u009f\31\3\2\2\2\u00a0\u00a1\5\34\17"+
		"\2\u00a1\u00a2\5(\25\2\u00a2\u00a3\b\16\1\2\u00a3\u00ac\3\2\2\2\u00a4"+
		"\u00a5\5\34\17\2\u00a5\u00a6\5(\25\2\u00a6\u00a7\7\t\2\2\u00a7\u00a8\5"+
		"\36\20\2\u00a8\u00a9\5\32\16\2\u00a9\u00aa\b\16\1\2\u00aa\u00ac\3\2\2"+
		"\2\u00ab\u00a0\3\2\2\2\u00ab\u00a4\3\2\2\2\u00ac\33\3\2\2\2\u00ad\u00ae"+
		"\7\21\2\2\u00ae\u00b1\b\17\1\2\u00af\u00b1\b\17\1\2\u00b0\u00ad\3\2\2"+
		"\2\u00b0\u00af\3\2\2\2\u00b1\35\3\2\2\2\u00b2\u00b3\b\20\1\2\u00b3\37"+
		"\3\2\2\2\u00b4\u00b5\5(\25\2\u00b5\u00b6\b\21\1\2\u00b6\u00be\3\2\2\2"+
		"\u00b7\u00b8\5(\25\2\u00b8\u00b9\7\t\2\2\u00b9\u00ba\5\36\20\2\u00ba\u00bb"+
		"\5 \21\2\u00bb\u00bc\b\21\1\2\u00bc\u00be\3\2\2\2\u00bd\u00b4\3\2\2\2"+
		"\u00bd\u00b7\3\2\2\2\u00be!\3\2\2\2\u00bf\u00c0\7\22\2\2\u00c0\u00c4\b"+
		"\22\1\2\u00c1\u00c2\7\23\2\2\u00c2\u00c4\b\22\1\2\u00c3\u00bf\3\2\2\2"+
		"\u00c3\u00c1\3\2\2\2\u00c4#\3\2\2\2\u00c5\u00c6\5&\24\2\u00c6\u00c7\5"+
		"$\23\2\u00c7\u00c8\b\23\1\2\u00c8\u00cb\3\2\2\2\u00c9\u00cb\b\23\1\2\u00ca"+
		"\u00c5\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb%\3\2\2\2\u00cc\u00cd\5(\25\2"+
		"\u00cd\u00ce\7\24\2\2\u00ce\u00cf\5(\25\2\u00cf\u00d0\7\b\2\2\u00d0\u00d1"+
		"\b\24\1\2\u00d1\u00d9\3\2\2\2\u00d2\u00d3\5(\25\2\u00d3\u00d4\7\25\2\2"+
		"\u00d4\u00d5\5(\25\2\u00d5\u00d6\7\b\2\2\u00d6\u00d7\b\24\1\2\u00d7\u00d9"+
		"\3\2\2\2\u00d8\u00cc\3\2\2\2\u00d8\u00d2\3\2\2\2\u00d9\'\3\2\2\2\u00da"+
		"\u00db\7\30\2\2\u00db\u00dc\b\25\1\2\u00dc)\3\2\2\2\u00dd\u00de\7\31\2"+
		"\2\u00de\u00df\b\26\1\2\u00df+\3\2\2\2\u00e0\u00e1\t\2\2\2\u00e1-\3\2"+
		"\2\2\u00e2\u00e3\7\34\2\2\u00e3\u00e4\b\30\1\2\u00e4/\3\2\2\2\17>HWi\u0087"+
		"\u008e\u009e\u00ab\u00b0\u00bd\u00c3\u00ca\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from TVL.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TVLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, NAME=22, ATTR_NAME=23, INTEGER_LITERAL=24, 
		REAL_LITERAL=25, STRING_LITERAL=26, WS=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "NAME", "ATTR_NAME", "INTEGER_LITERAL", 
		"REAL_LITERAL", "STRING_LITERAL", "LETTER", "LOWERCASE", "UPPERCASE", 
		"DIGIT", "UNDERSCORE", "SIGN", "OTHERCHAR", "WS"
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


	public TVLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TVL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u00f5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\7\27\u00b3\n\27\f\27\16\27\u00b6\13\27\3\30"+
		"\3\30\3\30\3\30\7\30\u00bc\n\30\f\30\16\30\u00bf\13\30\3\31\3\31\6\31"+
		"\u00c3\n\31\r\31\16\31\u00c4\3\32\3\32\6\32\u00c9\n\32\r\32\16\32\u00ca"+
		"\3\32\3\32\6\32\u00cf\n\32\r\32\16\32\u00d0\3\33\3\33\3\33\3\33\6\33\u00d7"+
		"\n\33\r\33\16\33\u00d8\3\33\3\33\3\34\3\34\5\34\u00df\n\34\3\35\3\35\3"+
		"\36\3\36\3\37\3\37\3 \3 \3!\3!\5!\u00eb\n!\3\"\3\"\3#\6#\u00f0\n#\r#\16"+
		"#\u00f1\3#\3#\2\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\29\2;\2=\2?\2A\2C\2E\35\3\2\t\3\2c|\3\2C\\\3\2\62;\3\2aa\4\2"+
		"--//\b\2\"#%\61<=BB]a\u0080\u0080\5\2\13\f\17\17\"\"\u00fc\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5L\3\2\2\2\7S\3\2\2"+
		"\2\tV\3\2\2\2\13X\3\2\2\2\rZ\3\2\2\2\17\\\3\2\2\2\21^\3\2\2\2\23c\3\2"+
		"\2\2\25g\3\2\2\2\27j\3\2\2\2\31o\3\2\2\2\33t\3\2\2\2\35z\3\2\2\2\37\u0080"+
		"\3\2\2\2!\u0084\3\2\2\2#\u008a\3\2\2\2%\u0091\3\2\2\2\'\u009a\3\2\2\2"+
		")\u00a3\3\2\2\2+\u00a8\3\2\2\2-\u00ae\3\2\2\2/\u00b7\3\2\2\2\61\u00c0"+
		"\3\2\2\2\63\u00c6\3\2\2\2\65\u00d2\3\2\2\2\67\u00de\3\2\2\29\u00e0\3\2"+
		"\2\2;\u00e2\3\2\2\2=\u00e4\3\2\2\2?\u00e6\3\2\2\2A\u00ea\3\2\2\2C\u00ec"+
		"\3\2\2\2E\u00ef\3\2\2\2GH\7g\2\2HI\7p\2\2IJ\7w\2\2JK\7o\2\2K\4\3\2\2\2"+
		"LM\7u\2\2MN\7v\2\2NO\7t\2\2OP\7k\2\2PQ\7p\2\2QR\7i\2\2R\6\3\2\2\2ST\7"+
		"k\2\2TU\7p\2\2U\b\3\2\2\2VW\7}\2\2W\n\3\2\2\2XY\7\177\2\2Y\f\3\2\2\2Z"+
		"[\7=\2\2[\16\3\2\2\2\\]\7.\2\2]\20\3\2\2\2^_\7t\2\2_`\7q\2\2`a\7q\2\2"+
		"ab\7v\2\2b\22\3\2\2\2cd\7k\2\2de\7p\2\2ef\7v\2\2f\24\3\2\2\2gh\7k\2\2"+
		"hi\7u\2\2i\26\3\2\2\2jk\7t\2\2kl\7g\2\2lm\7c\2\2mn\7n\2\2n\30\3\2\2\2"+
		"op\7d\2\2pq\7q\2\2qr\7q\2\2rs\7n\2\2s\32\3\2\2\2tu\7i\2\2uv\7t\2\2vw\7"+
		"q\2\2wx\7w\2\2xy\7r\2\2y\34\3\2\2\2z{\7c\2\2{|\7n\2\2|}\7n\2\2}~\7q\2"+
		"\2~\177\7h\2\2\177\36\3\2\2\2\u0080\u0081\7q\2\2\u0081\u0082\7r\2\2\u0082"+
		"\u0083\7v\2\2\u0083 \3\2\2\2\u0084\u0085\7q\2\2\u0085\u0086\7p\2\2\u0086"+
		"\u0087\7g\2\2\u0087\u0088\7q\2\2\u0088\u0089\7h\2\2\u0089\"\3\2\2\2\u008a"+
		"\u008b\7u\2\2\u008b\u008c\7q\2\2\u008c\u008d\7o\2\2\u008d\u008e\7g\2\2"+
		"\u008e\u008f\7q\2\2\u008f\u0090\7h\2\2\u0090$\3\2\2\2\u0091\u0092\7t\2"+
		"\2\u0092\u0093\7g\2\2\u0093\u0094\7s\2\2\u0094\u0095\7w\2\2\u0095\u0096"+
		"\7k\2\2\u0096\u0097\7t\2\2\u0097\u0098\7g\2\2\u0098\u0099\7u\2\2\u0099"+
		"&\3\2\2\2\u009a\u009b\7g\2\2\u009b\u009c\7z\2\2\u009c\u009d\7e\2\2\u009d"+
		"\u009e\7n\2\2\u009e\u009f\7w\2\2\u009f\u00a0\7f\2\2\u00a0\u00a1\7g\2\2"+
		"\u00a1\u00a2\7u\2\2\u00a2(\3\2\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7t\2"+
		"\2\u00a5\u00a6\7w\2\2\u00a6\u00a7\7g\2\2\u00a7*\3\2\2\2\u00a8\u00a9\7"+
		"h\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7u\2\2\u00ac\u00ad"+
		"\7g\2\2\u00ad,\3\2\2\2\u00ae\u00b4\5;\36\2\u00af\u00b3\5\67\34\2\u00b0"+
		"\u00b3\5=\37\2\u00b1\u00b3\5? \2\u00b2\u00af\3\2\2\2\u00b2\u00b0\3\2\2"+
		"\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5"+
		"\3\2\2\2\u00b5.\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00bd\59\35\2\u00b8"+
		"\u00bc\5\67\34\2\u00b9\u00bc\5=\37\2\u00ba\u00bc\5? \2\u00bb\u00b8\3\2"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\60\3\2\2\2\u00bf\u00bd\3\2\2"+
		"\2\u00c0\u00c2\5A!\2\u00c1\u00c3\5=\37\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\62\3\2\2\2\u00c6"+
		"\u00c8\5A!\2\u00c7\u00c9\5=\37\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca\3\2\2"+
		"\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce"+
		"\7\60\2\2\u00cd\u00cf\5=\37\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2"+
		"\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\64\3\2\2\2\u00d2\u00d6"+
		"\7$\2\2\u00d3\u00d7\5\67\34\2\u00d4\u00d7\5=\37\2\u00d5\u00d7\5C\"\2\u00d6"+
		"\u00d3\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00db\7$\2\2\u00db\66\3\2\2\2\u00dc\u00df\59\35\2\u00dd\u00df\5;\36\2"+
		"\u00de\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df8\3\2\2\2\u00e0\u00e1\t"+
		"\2\2\2\u00e1:\3\2\2\2\u00e2\u00e3\t\3\2\2\u00e3<\3\2\2\2\u00e4\u00e5\t"+
		"\4\2\2\u00e5>\3\2\2\2\u00e6\u00e7\t\5\2\2\u00e7@\3\2\2\2\u00e8\u00eb\t"+
		"\6\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb"+
		"B\3\2\2\2\u00ec\u00ed\t\7\2\2\u00edD\3\2\2\2\u00ee\u00f0\t\b\2\2\u00ef"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\b#\2\2\u00f4F\3\2\2\2\17\2\u00b2"+
		"\u00b4\u00bb\u00bd\u00c4\u00ca\u00d0\u00d6\u00d8\u00de\u00ea\u00f1\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from Musileng.g4 by ANTLR 4.4
package tleng.tp2;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MusilengLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TEMPO=1, COMPAS=2, CONST=3, IGUAL=4, VOZ=5, LPAREN=6, RPAREN=7, LBRACE=8, 
		RBRACE=9, NUMERAL=10, COMA=11, PUNTOYCOMA=12, SLASH=13, REPETIR=14, SILENCIO=15, 
		NOTA=16, PUNTILLO=17, DURACION=18, ALTURA=19, NUM=20, NOMBRE=21, COMENTARIOS=22, 
		WS=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'"
	};
	public static final String[] ruleNames = {
		"TEMPO", "COMPAS", "CONST", "IGUAL", "VOZ", "LPAREN", "RPAREN", "LBRACE", 
		"RBRACE", "NUMERAL", "COMA", "PUNTOYCOMA", "SLASH", "REPETIR", "SILENCIO", 
		"NOTA", "PUNTILLO", "DURACION", "ALTURA", "NUM", "NOMBRE", "COMENTARIOS", 
		"WS"
	};


	public MusilengLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Musileng.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u0103\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00a3\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u00e0\n\24\3\25\3\25\7\25\u00e4\n\25\f\25\16\25\u00e7\13\25\3\26\3\26"+
		"\7\26\u00eb\n\26\f\26\16\26\u00ee\13\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\6\30\u00fe\n\30\r\30\16\30\u00ff"+
		"\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\3\2\6\3\2\62;\5"+
		"\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\u011f\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\67\3"+
		"\2\2\2\7>\3\2\2\2\tD\3\2\2\2\13F\3\2\2\2\rJ\3\2\2\2\17L\3\2\2\2\21N\3"+
		"\2\2\2\23P\3\2\2\2\25R\3\2\2\2\27T\3\2\2\2\31V\3\2\2\2\33X\3\2\2\2\35"+
		"Z\3\2\2\2\37b\3\2\2\2!k\3\2\2\2#p\3\2\2\2%\u00a2\3\2\2\2\'\u00df\3\2\2"+
		"\2)\u00e1\3\2\2\2+\u00e8\3\2\2\2-\u00ef\3\2\2\2/\u00fd\3\2\2\2\61\62\7"+
		"v\2\2\62\63\7g\2\2\63\64\7o\2\2\64\65\7r\2\2\65\66\7q\2\2\66\4\3\2\2\2"+
		"\678\7e\2\289\7q\2\29:\7o\2\2:;\7r\2\2;<\7c\2\2<=\7u\2\2=\6\3\2\2\2>?"+
		"\7e\2\2?@\7q\2\2@A\7p\2\2AB\7u\2\2BC\7v\2\2C\b\3\2\2\2DE\7?\2\2E\n\3\2"+
		"\2\2FG\7x\2\2GH\7q\2\2HI\7|\2\2I\f\3\2\2\2JK\7*\2\2K\16\3\2\2\2LM\7+\2"+
		"\2M\20\3\2\2\2NO\7}\2\2O\22\3\2\2\2PQ\7\177\2\2Q\24\3\2\2\2RS\7%\2\2S"+
		"\26\3\2\2\2TU\7.\2\2U\30\3\2\2\2VW\7=\2\2W\32\3\2\2\2XY\7\61\2\2Y\34\3"+
		"\2\2\2Z[\7t\2\2[\\\7g\2\2\\]\7r\2\2]^\7g\2\2^_\7v\2\2_`\7k\2\2`a\7t\2"+
		"\2a\36\3\2\2\2bc\7u\2\2cd\7k\2\2de\7n\2\2ef\7g\2\2fg\7p\2\2gh\7e\2\2h"+
		"i\7k\2\2ij\7q\2\2j \3\2\2\2kl\7p\2\2lm\7q\2\2mn\7v\2\2no\7c\2\2o\"\3\2"+
		"\2\2pq\7\60\2\2q$\3\2\2\2rs\7t\2\2st\7g\2\2tu\7f\2\2uv\7q\2\2vw\7p\2\2"+
		"wx\7f\2\2x\u00a3\7c\2\2yz\7d\2\2z{\7n\2\2{|\7c\2\2|}\7p\2\2}~\7e\2\2~"+
		"\u00a3\7c\2\2\177\u0080\7p\2\2\u0080\u0081\7g\2\2\u0081\u0082\7i\2\2\u0082"+
		"\u0083\7t\2\2\u0083\u00a3\7c\2\2\u0084\u0085\7e\2\2\u0085\u0086\7q\2\2"+
		"\u0086\u0087\7t\2\2\u0087\u0088\7e\2\2\u0088\u0089\7j\2\2\u0089\u008a"+
		"\7g\2\2\u008a\u00a3\7c\2\2\u008b\u008c\7u\2\2\u008c\u008d\7g\2\2\u008d"+
		"\u008e\7o\2\2\u008e\u008f\7k\2\2\u008f\u0090\7e\2\2\u0090\u0091\7q\2\2"+
		"\u0091\u0092\7t\2\2\u0092\u0093\7e\2\2\u0093\u0094\7j\2\2\u0094\u0095"+
		"\7g\2\2\u0095\u00a3\7c\2\2\u0096\u0097\7h\2\2\u0097\u0098\7w\2\2\u0098"+
		"\u0099\7u\2\2\u0099\u00a3\7c\2\2\u009a\u009b\7u\2\2\u009b\u009c\7g\2\2"+
		"\u009c\u009d\7o\2\2\u009d\u009e\7k\2\2\u009e\u009f\7h\2\2\u009f\u00a0"+
		"\7w\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a3\7c\2\2\u00a2r\3\2\2\2\u00a2y\3"+
		"\2\2\2\u00a2\177\3\2\2\2\u00a2\u0084\3\2\2\2\u00a2\u008b\3\2\2\2\u00a2"+
		"\u0096\3\2\2\2\u00a2\u009a\3\2\2\2\u00a3&\3\2\2\2\u00a4\u00a5\7f\2\2\u00a5"+
		"\u00e0\7q\2\2\u00a6\u00a7\7t\2\2\u00a7\u00e0\7g\2\2\u00a8\u00a9\7o\2\2"+
		"\u00a9\u00e0\7k\2\2\u00aa\u00ab\7h\2\2\u00ab\u00e0\7c\2\2\u00ac\u00ad"+
		"\7u\2\2\u00ad\u00ae\7q\2\2\u00ae\u00e0\7n\2\2\u00af\u00b0\7n\2\2\u00b0"+
		"\u00e0\7c\2\2\u00b1\u00b2\7u\2\2\u00b2\u00e0\7k\2\2\u00b3\u00b4\7f\2\2"+
		"\u00b4\u00b5\7q\2\2\u00b5\u00e0\7-\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8"+
		"\7g\2\2\u00b8\u00e0\7-\2\2\u00b9\u00ba\7o\2\2\u00ba\u00bb\7k\2\2\u00bb"+
		"\u00e0\7-\2\2\u00bc\u00bd\7h\2\2\u00bd\u00be\7c\2\2\u00be\u00e0\7-\2\2"+
		"\u00bf\u00c0\7u\2\2\u00c0\u00c1\7q\2\2\u00c1\u00c2\7n\2\2\u00c2\u00e0"+
		"\7-\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5\7c\2\2\u00c5\u00e0\7-\2\2\u00c6"+
		"\u00c7\7u\2\2\u00c7\u00c8\7k\2\2\u00c8\u00e0\7-\2\2\u00c9\u00ca\7f\2\2"+
		"\u00ca\u00cb\7q\2\2\u00cb\u00e0\7/\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce"+
		"\7g\2\2\u00ce\u00e0\7/\2\2\u00cf\u00d0\7o\2\2\u00d0\u00d1\7k\2\2\u00d1"+
		"\u00e0\7/\2\2\u00d2\u00d3\7h\2\2\u00d3\u00d4\7c\2\2\u00d4\u00e0\7/\2\2"+
		"\u00d5\u00d6\7u\2\2\u00d6\u00d7\7q\2\2\u00d7\u00d8\7n\2\2\u00d8\u00e0"+
		"\7/\2\2\u00d9\u00da\7n\2\2\u00da\u00db\7c\2\2\u00db\u00e0\7/\2\2\u00dc"+
		"\u00dd\7u\2\2\u00dd\u00de\7k\2\2\u00de\u00e0\7/\2\2\u00df\u00a4\3\2\2"+
		"\2\u00df\u00a6\3\2\2\2\u00df\u00a8\3\2\2\2\u00df\u00aa\3\2\2\2\u00df\u00ac"+
		"\3\2\2\2\u00df\u00af\3\2\2\2\u00df\u00b1\3\2\2\2\u00df\u00b3\3\2\2\2\u00df"+
		"\u00b6\3\2\2\2\u00df\u00b9\3\2\2\2\u00df\u00bc\3\2\2\2\u00df\u00bf\3\2"+
		"\2\2\u00df\u00c3\3\2\2\2\u00df\u00c6\3\2\2\2\u00df\u00c9\3\2\2\2\u00df"+
		"\u00cc\3\2\2\2\u00df\u00cf\3\2\2\2\u00df\u00d2\3\2\2\2\u00df\u00d5\3\2"+
		"\2\2\u00df\u00d9\3\2\2\2\u00df\u00dc\3\2\2\2\u00e0(\3\2\2\2\u00e1\u00e5"+
		"\t\2\2\2\u00e2\u00e4\t\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6*\3\2\2\2\u00e7\u00e5\3\2\2\2"+
		"\u00e8\u00ec\t\3\2\2\u00e9\u00eb\t\4\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee"+
		"\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed,\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ef\u00f0\7\61\2\2\u00f0\u00f1\7\61\2\2\u00f1\u00f2\7"+
		"*\2\2\u00f2\u00f3\7\60\2\2\u00f3\u00f4\7,\2\2\u00f4\u00f5\7A\2\2\u00f5"+
		"\u00f6\7+\2\2\u00f6\u00f7\7\17\2\2\u00f7\u00f8\7A\2\2\u00f8\u00f9\7\f"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\b\27\2\2\u00fb.\3\2\2\2\u00fc\u00fe"+
		"\t\5\2\2\u00fd\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\b\30\2\2\u0102\60\3\2\2"+
		"\2\b\2\u00a2\u00df\u00e5\u00ec\u00ff\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
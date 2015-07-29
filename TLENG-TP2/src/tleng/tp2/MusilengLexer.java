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
		NOTA=16, PUNTILLO=17, DURACION=18, ALTURA=19, NUM=20, NOMBRE=21, OCTAVA=22, 
		COMENTARIOS=23, WS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'"
	};
	public static final String[] ruleNames = {
		"TEMPO", "COMPAS", "CONST", "IGUAL", "VOZ", "LPAREN", "RPAREN", "LBRACE", 
		"RBRACE", "NUMERAL", "COMA", "PUNTOYCOMA", "SLASH", "REPETIR", "SILENCIO", 
		"NOTA", "PUNTILLO", "DURACION", "ALTURA", "NUM", "NOMBRE", "OCTAVA", "COMENTARIOS", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u0101\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00a5\n\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u00e2\n\24\3\25\6\25\u00e5\n\25\r\25\16\25\u00e6\3\26\6\26"+
		"\u00ea\n\26\r\26\16\26\u00eb\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u00f4"+
		"\n\30\f\30\16\30\u00f7\13\30\3\30\3\30\3\31\6\31\u00fc\n\31\r\31\16\31"+
		"\u00fd\3\31\3\31\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\3"+
		"\2\7\3\2\62;\5\2C\\aac|\3\2\63;\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u011e"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\3\63\3\2\2\2\59\3\2\2\2\7@\3\2\2\2\tF\3\2\2\2\13H\3\2"+
		"\2\2\rL\3\2\2\2\17N\3\2\2\2\21P\3\2\2\2\23R\3\2\2\2\25T\3\2\2\2\27V\3"+
		"\2\2\2\31X\3\2\2\2\33Z\3\2\2\2\35\\\3\2\2\2\37d\3\2\2\2!m\3\2\2\2#r\3"+
		"\2\2\2%\u00a4\3\2\2\2\'\u00e1\3\2\2\2)\u00e4\3\2\2\2+\u00e9\3\2\2\2-\u00ed"+
		"\3\2\2\2/\u00ef\3\2\2\2\61\u00fb\3\2\2\2\63\64\7v\2\2\64\65\7g\2\2\65"+
		"\66\7o\2\2\66\67\7r\2\2\678\7q\2\28\4\3\2\2\29:\7e\2\2:;\7q\2\2;<\7o\2"+
		"\2<=\7r\2\2=>\7c\2\2>?\7u\2\2?\6\3\2\2\2@A\7e\2\2AB\7q\2\2BC\7p\2\2CD"+
		"\7u\2\2DE\7v\2\2E\b\3\2\2\2FG\7?\2\2G\n\3\2\2\2HI\7x\2\2IJ\7q\2\2JK\7"+
		"|\2\2K\f\3\2\2\2LM\7*\2\2M\16\3\2\2\2NO\7+\2\2O\20\3\2\2\2PQ\7}\2\2Q\22"+
		"\3\2\2\2RS\7\177\2\2S\24\3\2\2\2TU\7%\2\2U\26\3\2\2\2VW\7.\2\2W\30\3\2"+
		"\2\2XY\7=\2\2Y\32\3\2\2\2Z[\7\61\2\2[\34\3\2\2\2\\]\7t\2\2]^\7g\2\2^_"+
		"\7r\2\2_`\7g\2\2`a\7v\2\2ab\7k\2\2bc\7t\2\2c\36\3\2\2\2de\7u\2\2ef\7k"+
		"\2\2fg\7n\2\2gh\7g\2\2hi\7p\2\2ij\7e\2\2jk\7k\2\2kl\7q\2\2l \3\2\2\2m"+
		"n\7p\2\2no\7q\2\2op\7v\2\2pq\7c\2\2q\"\3\2\2\2rs\7\60\2\2s$\3\2\2\2tu"+
		"\7t\2\2uv\7g\2\2vw\7f\2\2wx\7q\2\2xy\7p\2\2yz\7f\2\2z\u00a5\7c\2\2{|\7"+
		"d\2\2|}\7n\2\2}~\7c\2\2~\177\7p\2\2\177\u0080\7e\2\2\u0080\u00a5\7c\2"+
		"\2\u0081\u0082\7p\2\2\u0082\u0083\7g\2\2\u0083\u0084\7i\2\2\u0084\u0085"+
		"\7t\2\2\u0085\u00a5\7c\2\2\u0086\u0087\7e\2\2\u0087\u0088\7q\2\2\u0088"+
		"\u0089\7t\2\2\u0089\u008a\7e\2\2\u008a\u008b\7j\2\2\u008b\u008c\7g\2\2"+
		"\u008c\u00a5\7c\2\2\u008d\u008e\7u\2\2\u008e\u008f\7g\2\2\u008f\u0090"+
		"\7o\2\2\u0090\u0091\7k\2\2\u0091\u0092\7e\2\2\u0092\u0093\7q\2\2\u0093"+
		"\u0094\7t\2\2\u0094\u0095\7e\2\2\u0095\u0096\7j\2\2\u0096\u0097\7g\2\2"+
		"\u0097\u00a5\7c\2\2\u0098\u0099\7h\2\2\u0099\u009a\7w\2\2\u009a\u009b"+
		"\7u\2\2\u009b\u00a5\7c\2\2\u009c\u009d\7u\2\2\u009d\u009e\7g\2\2\u009e"+
		"\u009f\7o\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7h\2\2\u00a1\u00a2\7w\2\2"+
		"\u00a2\u00a3\7u\2\2\u00a3\u00a5\7c\2\2\u00a4t\3\2\2\2\u00a4{\3\2\2\2\u00a4"+
		"\u0081\3\2\2\2\u00a4\u0086\3\2\2\2\u00a4\u008d\3\2\2\2\u00a4\u0098\3\2"+
		"\2\2\u00a4\u009c\3\2\2\2\u00a5&\3\2\2\2\u00a6\u00a7\7f\2\2\u00a7\u00e2"+
		"\7q\2\2\u00a8\u00a9\7t\2\2\u00a9\u00e2\7g\2\2\u00aa\u00ab\7o\2\2\u00ab"+
		"\u00e2\7k\2\2\u00ac\u00ad\7h\2\2\u00ad\u00e2\7c\2\2\u00ae\u00af\7u\2\2"+
		"\u00af\u00b0\7q\2\2\u00b0\u00e2\7n\2\2\u00b1\u00b2\7n\2\2\u00b2\u00e2"+
		"\7c\2\2\u00b3\u00b4\7u\2\2\u00b4\u00e2\7k\2\2\u00b5\u00b6\7f\2\2\u00b6"+
		"\u00b7\7q\2\2\u00b7\u00e2\7-\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba\7g\2\2"+
		"\u00ba\u00e2\7-\2\2\u00bb\u00bc\7o\2\2\u00bc\u00bd\7k\2\2\u00bd\u00e2"+
		"\7-\2\2\u00be\u00bf\7h\2\2\u00bf\u00c0\7c\2\2\u00c0\u00e2\7-\2\2\u00c1"+
		"\u00c2\7u\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c4\7n\2\2\u00c4\u00e2\7-\2\2"+
		"\u00c5\u00c6\7n\2\2\u00c6\u00c7\7c\2\2\u00c7\u00e2\7-\2\2\u00c8\u00c9"+
		"\7u\2\2\u00c9\u00ca\7k\2\2\u00ca\u00e2\7-\2\2\u00cb\u00cc\7f\2\2\u00cc"+
		"\u00cd\7q\2\2\u00cd\u00e2\7/\2\2\u00ce\u00cf\7t\2\2\u00cf\u00d0\7g\2\2"+
		"\u00d0\u00e2\7/\2\2\u00d1\u00d2\7o\2\2\u00d2\u00d3\7k\2\2\u00d3\u00e2"+
		"\7/\2\2\u00d4\u00d5\7h\2\2\u00d5\u00d6\7c\2\2\u00d6\u00e2\7/\2\2\u00d7"+
		"\u00d8\7u\2\2\u00d8\u00d9\7q\2\2\u00d9\u00da\7n\2\2\u00da\u00e2\7/\2\2"+
		"\u00db\u00dc\7n\2\2\u00dc\u00dd\7c\2\2\u00dd\u00e2\7/\2\2\u00de\u00df"+
		"\7u\2\2\u00df\u00e0\7k\2\2\u00e0\u00e2\7/\2\2\u00e1\u00a6\3\2\2\2\u00e1"+
		"\u00a8\3\2\2\2\u00e1\u00aa\3\2\2\2\u00e1\u00ac\3\2\2\2\u00e1\u00ae\3\2"+
		"\2\2\u00e1\u00b1\3\2\2\2\u00e1\u00b3\3\2\2\2\u00e1\u00b5\3\2\2\2\u00e1"+
		"\u00b8\3\2\2\2\u00e1\u00bb\3\2\2\2\u00e1\u00be\3\2\2\2\u00e1\u00c1\3\2"+
		"\2\2\u00e1\u00c5\3\2\2\2\u00e1\u00c8\3\2\2\2\u00e1\u00cb\3\2\2\2\u00e1"+
		"\u00ce\3\2\2\2\u00e1\u00d1\3\2\2\2\u00e1\u00d4\3\2\2\2\u00e1\u00d7\3\2"+
		"\2\2\u00e1\u00db\3\2\2\2\u00e1\u00de\3\2\2\2\u00e2(\3\2\2\2\u00e3\u00e5"+
		"\t\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7*\3\2\2\2\u00e8\u00ea\t\3\2\2\u00e9\u00e8\3\2\2\2"+
		"\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec,\3"+
		"\2\2\2\u00ed\u00ee\t\4\2\2\u00ee.\3\2\2\2\u00ef\u00f0\7\61\2\2\u00f0\u00f1"+
		"\7\61\2\2\u00f1\u00f5\3\2\2\2\u00f2\u00f4\n\5\2\2\u00f3\u00f2\3\2\2\2"+
		"\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8"+
		"\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\b\30\2\2\u00f9\60\3\2\2\2\u00fa"+
		"\u00fc\t\6\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fb\3\2"+
		"\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\b\31\2\2\u0100"+
		"\62\3\2\2\2\t\2\u00a4\u00e1\u00e6\u00eb\u00f5\u00fd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
package tleng.tp2;
// Generated from Musileng.g4 by ANTLR 4.4

	import java.util.HashMap;
	import java.util.Map;
	import java.util.List;
	import java.util.ArrayList;

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
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		ALTERACION=17, PUNTILLO=18, DURACION=19, ALTURA=20, NUM=21, NOMBRE=22, 
		OCTAVA=23, WS=24;
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
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "ALTERACION", 
		"PUNTILLO", "DURACION", "ALTURA", "NUM", "NOMBRE", "OCTAVA", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00d3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\5\24\u00ae\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u00bf\n\25\3\26\6\26\u00c2\n\26\r\26\16"+
		"\26\u00c3\3\27\6\27\u00c7\n\27\r\27\16\27\u00c8\3\30\3\30\3\31\6\31\u00ce"+
		"\n\31\r\31\16\31\u00cf\3\31\3\31\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\3\2\7\4\2--//\3\2\62;\5\2C\\aac|\3\2\63;\5\2\13\f\17\17"+
		"\"\"\u00e1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5\65\3\2\2\2\7:\3\2\2\2\t@\3\2\2"+
		"\2\13H\3\2\2\2\rQ\3\2\2\2\17Y\3\2\2\2\21`\3\2\2\2\23b\3\2\2\2\25d\3\2"+
		"\2\2\27f\3\2\2\2\31j\3\2\2\2\33l\3\2\2\2\35s\3\2\2\2\37u\3\2\2\2!w\3\2"+
		"\2\2#y\3\2\2\2%{\3\2\2\2\'\u00ad\3\2\2\2)\u00be\3\2\2\2+\u00c1\3\2\2\2"+
		"-\u00c6\3\2\2\2/\u00ca\3\2\2\2\61\u00cd\3\2\2\2\63\64\7\61\2\2\64\4\3"+
		"\2\2\2\65\66\7p\2\2\66\67\7q\2\2\678\7v\2\289\7c\2\29\6\3\2\2\2:;\7e\2"+
		"\2;<\7q\2\2<=\7p\2\2=>\7u\2\2>?\7v\2\2?\b\3\2\2\2@A\7%\2\2AB\7e\2\2BC"+
		"\7q\2\2CD\7o\2\2DE\7r\2\2EF\7c\2\2FG\7u\2\2G\n\3\2\2\2HI\7u\2\2IJ\7k\2"+
		"\2JK\7n\2\2KL\7g\2\2LM\7p\2\2MN\7e\2\2NO\7k\2\2OP\7q\2\2P\f\3\2\2\2QR"+
		"\7t\2\2RS\7g\2\2ST\7r\2\2TU\7g\2\2UV\7v\2\2VW\7k\2\2WX\7t\2\2X\16\3\2"+
		"\2\2YZ\7%\2\2Z[\7v\2\2[\\\7g\2\2\\]\7o\2\2]^\7r\2\2^_\7q\2\2_\20\3\2\2"+
		"\2`a\7}\2\2a\22\3\2\2\2bc\7=\2\2c\24\3\2\2\2de\7\177\2\2e\26\3\2\2\2f"+
		"g\7x\2\2gh\7q\2\2hi\7|\2\2i\30\3\2\2\2jk\7?\2\2k\32\3\2\2\2lm\7e\2\2m"+
		"n\7q\2\2no\7o\2\2op\7r\2\2pq\7c\2\2qr\7u\2\2r\34\3\2\2\2st\7*\2\2t\36"+
		"\3\2\2\2uv\7+\2\2v \3\2\2\2wx\7.\2\2x\"\3\2\2\2yz\t\2\2\2z$\3\2\2\2{|"+
		"\7\60\2\2|&\3\2\2\2}~\7t\2\2~\177\7g\2\2\177\u0080\7f\2\2\u0080\u0081"+
		"\7q\2\2\u0081\u0082\7p\2\2\u0082\u0083\7f\2\2\u0083\u00ae\7c\2\2\u0084"+
		"\u0085\7d\2\2\u0085\u0086\7n\2\2\u0086\u0087\7c\2\2\u0087\u0088\7p\2\2"+
		"\u0088\u0089\7e\2\2\u0089\u00ae\7c\2\2\u008a\u008b\7p\2\2\u008b\u008c"+
		"\7g\2\2\u008c\u008d\7i\2\2\u008d\u008e\7t\2\2\u008e\u00ae\7c\2\2\u008f"+
		"\u0090\7e\2\2\u0090\u0091\7q\2\2\u0091\u0092\7t\2\2\u0092\u0093\7e\2\2"+
		"\u0093\u0094\7j\2\2\u0094\u0095\7g\2\2\u0095\u00ae\7c\2\2\u0096\u0097"+
		"\7u\2\2\u0097\u0098\7g\2\2\u0098\u0099\7o\2\2\u0099\u009a\7k\2\2\u009a"+
		"\u009b\7e\2\2\u009b\u009c\7q\2\2\u009c\u009d\7t\2\2\u009d\u009e\7e\2\2"+
		"\u009e\u009f\7j\2\2\u009f\u00a0\7g\2\2\u00a0\u00ae\7c\2\2\u00a1\u00a2"+
		"\7h\2\2\u00a2\u00a3\7w\2\2\u00a3\u00a4\7u\2\2\u00a4\u00ae\7c\2\2\u00a5"+
		"\u00a6\7u\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7o\2\2\u00a8\u00a9\7k\2\2"+
		"\u00a9\u00aa\7h\2\2\u00aa\u00ab\7w\2\2\u00ab\u00ac\7u\2\2\u00ac\u00ae"+
		"\7c\2\2\u00ad}\3\2\2\2\u00ad\u0084\3\2\2\2\u00ad\u008a\3\2\2\2\u00ad\u008f"+
		"\3\2\2\2\u00ad\u0096\3\2\2\2\u00ad\u00a1\3\2\2\2\u00ad\u00a5\3\2\2\2\u00ae"+
		"(\3\2\2\2\u00af\u00b0\7f\2\2\u00b0\u00bf\7q\2\2\u00b1\u00b2\7t\2\2\u00b2"+
		"\u00bf\7g\2\2\u00b3\u00b4\7o\2\2\u00b4\u00bf\7k\2\2\u00b5\u00b6\7h\2\2"+
		"\u00b6\u00bf\7c\2\2\u00b7\u00b8\7u\2\2\u00b8\u00b9\7q\2\2\u00b9\u00bf"+
		"\7n\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bf\7c\2\2\u00bc\u00bd\7u\2\2\u00bd"+
		"\u00bf\7k\2\2\u00be\u00af\3\2\2\2\u00be\u00b1\3\2\2\2\u00be\u00b3\3\2"+
		"\2\2\u00be\u00b5\3\2\2\2\u00be\u00b7\3\2\2\2\u00be\u00ba\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00bf*\3\2\2\2\u00c0\u00c2\t\3\2\2\u00c1\u00c0\3\2\2\2"+
		"\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4,\3"+
		"\2\2\2\u00c5\u00c7\t\4\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9.\3\2\2\2\u00ca\u00cb\t\5\2\2"+
		"\u00cb\60\3\2\2\2\u00cc\u00ce\t\6\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf"+
		"\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d2\b\31\2\2\u00d2\62\3\2\2\2\b\2\u00ad\u00be\u00c3\u00c8\u00cf\3\b"+
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
// Generated from lexerGrammar.g4 by ANTLR 4.4
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
public class lexerGrammar extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUNTILLO=1, DURACION=2, ALTURA=3, NUM=4, NOMBRE=5, OCTAVA=6, COMENTARIOS=7, 
		WS=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'"
	};
	public static final String[] ruleNames = {
		"PUNTILLO", "DURACION", "ALTURA", "NUM", "NOMBRE", "OCTAVA", "COMENTARIOS", 
		"WS"
	};


	public lexerGrammar(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lexerGrammar.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n\u00a3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3F\n\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4\u0084\n\4\3\5\6\5\u0087\n\5\r\5\16\5\u0088\3\6"+
		"\6\6\u008c\n\6\r\6\16\6\u008d\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u0096\n\b\f"+
		"\b\16\b\u0099\13\b\3\b\3\b\3\t\6\t\u009e\n\t\r\t\16\t\u009f\3\t\3\t\2"+
		"\2\n\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\3\2\7\3\2\62;\5\2C\\aac|\3\2\63"+
		";\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u00c1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\3\23\3\2\2\2\5E\3\2\2\2\7\u0083\3\2\2\2\t\u0086\3\2\2\2\13\u008b\3\2"+
		"\2\2\r\u008f\3\2\2\2\17\u0091\3\2\2\2\21\u009d\3\2\2\2\23\24\7\60\2\2"+
		"\24\4\3\2\2\2\25\26\7t\2\2\26\27\7g\2\2\27\30\7f\2\2\30\31\7q\2\2\31\32"+
		"\7p\2\2\32\33\7f\2\2\33F\7c\2\2\34\35\7d\2\2\35\36\7n\2\2\36\37\7c\2\2"+
		"\37 \7p\2\2 !\7e\2\2!F\7c\2\2\"#\7p\2\2#$\7g\2\2$%\7i\2\2%&\7t\2\2&F\7"+
		"c\2\2\'(\7e\2\2()\7q\2\2)*\7t\2\2*+\7e\2\2+,\7j\2\2,-\7g\2\2-F\7c\2\2"+
		"./\7u\2\2/\60\7g\2\2\60\61\7o\2\2\61\62\7k\2\2\62\63\7e\2\2\63\64\7q\2"+
		"\2\64\65\7t\2\2\65\66\7e\2\2\66\67\7j\2\2\678\7g\2\28F\7c\2\29:\7h\2\2"+
		":;\7w\2\2;<\7u\2\2<F\7c\2\2=>\7u\2\2>?\7g\2\2?@\7o\2\2@A\7k\2\2AB\7h\2"+
		"\2BC\7w\2\2CD\7u\2\2DF\7c\2\2E\25\3\2\2\2E\34\3\2\2\2E\"\3\2\2\2E\'\3"+
		"\2\2\2E.\3\2\2\2E9\3\2\2\2E=\3\2\2\2F\6\3\2\2\2GH\7f\2\2H\u0084\7q\2\2"+
		"IJ\7t\2\2J\u0084\7g\2\2KL\7o\2\2L\u0084\7k\2\2MN\7h\2\2N\u0084\7c\2\2"+
		"OP\7u\2\2PQ\7q\2\2Q\u0084\7n\2\2RS\7n\2\2S\u0084\7c\2\2TU\7u\2\2U\u0084"+
		"\7k\2\2VW\7f\2\2WX\7q\2\2X\u0084\7-\2\2YZ\7t\2\2Z[\7g\2\2[\u0084\7-\2"+
		"\2\\]\7o\2\2]^\7k\2\2^\u0084\7-\2\2_`\7h\2\2`a\7c\2\2a\u0084\7-\2\2bc"+
		"\7u\2\2cd\7q\2\2de\7n\2\2e\u0084\7-\2\2fg\7n\2\2gh\7c\2\2h\u0084\7-\2"+
		"\2ij\7u\2\2jk\7k\2\2k\u0084\7-\2\2lm\7f\2\2mn\7q\2\2n\u0084\7/\2\2op\7"+
		"t\2\2pq\7g\2\2q\u0084\7/\2\2rs\7o\2\2st\7k\2\2t\u0084\7/\2\2uv\7h\2\2"+
		"vw\7c\2\2w\u0084\7/\2\2xy\7u\2\2yz\7q\2\2z{\7n\2\2{\u0084\7/\2\2|}\7n"+
		"\2\2}~\7c\2\2~\u0084\7/\2\2\177\u0080\7u\2\2\u0080\u0081\7k\2\2\u0081"+
		"\u0084\7/\2\2\u0082\u0084\3\2\2\2\u0083G\3\2\2\2\u0083I\3\2\2\2\u0083"+
		"K\3\2\2\2\u0083M\3\2\2\2\u0083O\3\2\2\2\u0083R\3\2\2\2\u0083T\3\2\2\2"+
		"\u0083V\3\2\2\2\u0083Y\3\2\2\2\u0083\\\3\2\2\2\u0083_\3\2\2\2\u0083b\3"+
		"\2\2\2\u0083f\3\2\2\2\u0083i\3\2\2\2\u0083l\3\2\2\2\u0083o\3\2\2\2\u0083"+
		"r\3\2\2\2\u0083u\3\2\2\2\u0083x\3\2\2\2\u0083|\3\2\2\2\u0083\177\3\2\2"+
		"\2\u0083\u0082\3\2\2\2\u0084\b\3\2\2\2\u0085\u0087\t\2\2\2\u0086\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\n\3\2\2\2\u008a\u008c\t\3\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2"+
		"\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\f\3\2\2\2\u008f\u0090\t"+
		"\4\2\2\u0090\16\3\2\2\2\u0091\u0092\7\61\2\2\u0092\u0093\7\61\2\2\u0093"+
		"\u0097\3\2\2\2\u0094\u0096\n\5\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2"+
		"\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009b\b\b\2\2\u009b\20\3\2\2\2\u009c\u009e\t\6\2"+
		"\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\b\t\2\2\u00a2\22\3\2\2\2\t\2"+
		"E\u0083\u0088\u008d\u0097\u009f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
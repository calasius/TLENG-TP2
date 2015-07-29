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
		PUNTILLO=1, DURACION=2, ALTURA=3, NUM=4, NOMBRE=5, OCTAVA=6, WS=7, COMENTARIOS=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'"
	};
	public static final String[] ruleNames = {
		"PUNTILLO", "DURACION", "ALTURA", "NUM", "NOMBRE", "OCTAVA", "WS", "COMENTARIOS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n\u008f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3F\n\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4w\n\4\3\5\6\5z\n\5\r\5\16\5{\3"+
		"\6\6\6\177\n\6\r\6\16\6\u0080\3\7\3\7\3\b\6\b\u0086\n\b\r\b\16\b\u0087"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\2\2\n\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\3\2"+
		"\7\3\2\62;\5\2C\\aac|\3\2\63;\5\2\13\f\17\17\"\"\7\2\f\f\17\17*,\60\61"+
		"AA\u00a7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5E\3\2\2\2\7v\3\2"+
		"\2\2\ty\3\2\2\2\13~\3\2\2\2\r\u0082\3\2\2\2\17\u0085\3\2\2\2\21\u008b"+
		"\3\2\2\2\23\24\7\60\2\2\24\4\3\2\2\2\25\26\7t\2\2\26\27\7g\2\2\27\30\7"+
		"f\2\2\30\31\7q\2\2\31\32\7p\2\2\32\33\7f\2\2\33F\7c\2\2\34\35\7d\2\2\35"+
		"\36\7n\2\2\36\37\7c\2\2\37 \7p\2\2 !\7e\2\2!F\7c\2\2\"#\7p\2\2#$\7g\2"+
		"\2$%\7i\2\2%&\7t\2\2&F\7c\2\2\'(\7e\2\2()\7q\2\2)*\7t\2\2*+\7e\2\2+,\7"+
		"j\2\2,-\7g\2\2-F\7c\2\2./\7u\2\2/\60\7g\2\2\60\61\7o\2\2\61\62\7k\2\2"+
		"\62\63\7e\2\2\63\64\7q\2\2\64\65\7t\2\2\65\66\7e\2\2\66\67\7j\2\2\678"+
		"\7g\2\28F\7c\2\29:\7h\2\2:;\7w\2\2;<\7u\2\2<F\7c\2\2=>\7u\2\2>?\7g\2\2"+
		"?@\7o\2\2@A\7k\2\2AB\7h\2\2BC\7w\2\2CD\7u\2\2DF\7c\2\2E\25\3\2\2\2E\34"+
		"\3\2\2\2E\"\3\2\2\2E\'\3\2\2\2E.\3\2\2\2E9\3\2\2\2E=\3\2\2\2F\6\3\2\2"+
		"\2GH\7f\2\2Hw\7q\2\2IJ\7t\2\2Jw\7g\2\2KL\7o\2\2Lw\7k\2\2MN\7h\2\2Nw\7"+
		"c\2\2OP\7u\2\2PQ\7q\2\2Qw\7n\2\2RS\7n\2\2Sw\7c\2\2TU\7u\2\2Uw\7k\2\2V"+
		"W\7f\2\2WX\7q\2\2Xw\7-\2\2YZ\7t\2\2Z[\7g\2\2[w\7-\2\2\\]\7h\2\2]^\7c\2"+
		"\2^w\7-\2\2_`\7u\2\2`a\7q\2\2ab\7n\2\2bw\7-\2\2cd\7n\2\2de\7c\2\2ew\7"+
		"-\2\2fg\7t\2\2gh\7g\2\2hw\7/\2\2ij\7o\2\2jk\7k\2\2kw\7/\2\2lm\7u\2\2m"+
		"n\7q\2\2no\7n\2\2ow\7/\2\2pq\7n\2\2qr\7c\2\2rw\7/\2\2st\7u\2\2tu\7k\2"+
		"\2uw\7/\2\2vG\3\2\2\2vI\3\2\2\2vK\3\2\2\2vM\3\2\2\2vO\3\2\2\2vR\3\2\2"+
		"\2vT\3\2\2\2vV\3\2\2\2vY\3\2\2\2v\\\3\2\2\2v_\3\2\2\2vc\3\2\2\2vf\3\2"+
		"\2\2vi\3\2\2\2vl\3\2\2\2vp\3\2\2\2vs\3\2\2\2w\b\3\2\2\2xz\t\2\2\2yx\3"+
		"\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\n\3\2\2\2}\177\t\3\2\2~}\3\2\2\2"+
		"\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\f\3\2\2\2"+
		"\u0082\u0083\t\4\2\2\u0083\16\3\2\2\2\u0084\u0086\t\5\2\2\u0085\u0084"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u008a\b\b\2\2\u008a\20\3\2\2\2\u008b\u008c\t\6\2"+
		"\2\u008c\u008d\3\2\2\2\u008d\u008e\b\t\2\2\u008e\22\3\2\2\2\b\2Ev{\u0080"+
		"\u0087\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
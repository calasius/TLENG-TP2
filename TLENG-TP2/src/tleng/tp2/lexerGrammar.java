package tleng.tp2;
// Generated from lexerGrammar.g4 by ANTLR 4.4
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
		ALTERACION=1, PUNTILLO=2, DURACION=3, ALTURA=4, NUM=5, NOMBRE=6, OCTAVA=7, 
		WS=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'"
	};
	public static final String[] ruleNames = {
		"ALTERACION", "PUNTILLO", "DURACION", "ALTURA", "NUM", "NOMBRE", "OCTAVA", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\nm\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4H\n\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5Y\n\5\3\6\6\6"+
		"\\\n\6\r\6\16\6]\3\7\6\7a\n\7\r\7\16\7b\3\b\3\b\3\t\6\th\n\t\r\t\16\t"+
		"i\3\t\3\t\2\2\n\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\3\2\7\4\2--//\3\2\62"+
		";\5\2C\\aac|\3\2\63;\5\2\13\f\17\17\"\"{\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\3\23\3\2\2\2\5\25\3\2\2\2\7G\3\2\2\2\tX\3\2\2\2\13[\3\2\2\2\r`\3\2\2"+
		"\2\17d\3\2\2\2\21g\3\2\2\2\23\24\t\2\2\2\24\4\3\2\2\2\25\26\7\60\2\2\26"+
		"\6\3\2\2\2\27\30\7t\2\2\30\31\7g\2\2\31\32\7f\2\2\32\33\7q\2\2\33\34\7"+
		"p\2\2\34\35\7f\2\2\35H\7c\2\2\36\37\7d\2\2\37 \7n\2\2 !\7c\2\2!\"\7p\2"+
		"\2\"#\7e\2\2#H\7c\2\2$%\7p\2\2%&\7g\2\2&\'\7i\2\2\'(\7t\2\2(H\7c\2\2)"+
		"*\7e\2\2*+\7q\2\2+,\7t\2\2,-\7e\2\2-.\7j\2\2./\7g\2\2/H\7c\2\2\60\61\7"+
		"u\2\2\61\62\7g\2\2\62\63\7o\2\2\63\64\7k\2\2\64\65\7e\2\2\65\66\7q\2\2"+
		"\66\67\7t\2\2\678\7e\2\289\7j\2\29:\7g\2\2:H\7c\2\2;<\7h\2\2<=\7w\2\2"+
		"=>\7u\2\2>H\7c\2\2?@\7u\2\2@A\7g\2\2AB\7o\2\2BC\7k\2\2CD\7h\2\2DE\7w\2"+
		"\2EF\7u\2\2FH\7c\2\2G\27\3\2\2\2G\36\3\2\2\2G$\3\2\2\2G)\3\2\2\2G\60\3"+
		"\2\2\2G;\3\2\2\2G?\3\2\2\2H\b\3\2\2\2IJ\7f\2\2JY\7q\2\2KL\7t\2\2LY\7g"+
		"\2\2MN\7o\2\2NY\7k\2\2OP\7h\2\2PY\7c\2\2QR\7u\2\2RS\7q\2\2SY\7n\2\2TU"+
		"\7n\2\2UY\7c\2\2VW\7u\2\2WY\7k\2\2XI\3\2\2\2XK\3\2\2\2XM\3\2\2\2XO\3\2"+
		"\2\2XQ\3\2\2\2XT\3\2\2\2XV\3\2\2\2Y\n\3\2\2\2Z\\\t\3\2\2[Z\3\2\2\2\\]"+
		"\3\2\2\2][\3\2\2\2]^\3\2\2\2^\f\3\2\2\2_a\t\4\2\2`_\3\2\2\2ab\3\2\2\2"+
		"b`\3\2\2\2bc\3\2\2\2c\16\3\2\2\2de\t\5\2\2e\20\3\2\2\2fh\t\6\2\2gf\3\2"+
		"\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\b\t\2\2l\22\3\2\2\2\b\2"+
		"GX]bi\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
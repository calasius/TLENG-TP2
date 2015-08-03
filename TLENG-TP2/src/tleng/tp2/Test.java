package tleng.tp2;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import tleng.tp2.MusilengParser.Partitura;

public class Test {
	
	public static void main(String[] args) throws IOException {
		CharStream charStream = new ANTLRFileStream("compas_0_blanca.mus");
		MusilengLexer lexer = new MusilengLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		MusilengParser parser = new MusilengParser(tokenStream);
		Partitura partitura = parser.s().partitura;
	}

}

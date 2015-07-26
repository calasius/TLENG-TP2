import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;


public class Test {
	
	public static void main(String[] args) throws IOException {
		CharStream charStream = new ANTLRFileStream("example1.txt");
		MusilengLexer lexer = new MusilengLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		MusilengParser parser = new MusilengParser(tokenStream);
		parser.s();
	}

}

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

//import static MusilengParser.Partitura;


public class midicomp {

	private static final String USAGE = "Usage : ./midicomp -c entrada.txt salida.midi";

	public static void main(String[] args) throws IOException {

		if (args.length != 3) {
			System.out.println(USAGE);
		} else {
			if (!args[0].equals("-c")) {
				System.out.println(USAGE);
			} else {
				String inFile = args[1];
				String outFile = args[2];
				CharStream charStream = new ANTLRFileStream(inFile);
				MusilengLexer lexer = new MusilengLexer(charStream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				MusilengParser parser = new MusilengParser(tokenStream);
//				Partitura partitura = parser.s().partitura;
			}
		}
			
	}

}

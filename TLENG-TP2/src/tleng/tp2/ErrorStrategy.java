package tleng.tp2;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

public class ErrorStrategy extends DefaultErrorStrategy {

	@Override
	public void recover(Parser recognizer, RecognitionException e) {
		throw new RuntimeException(e.getMessage());
	}

	@Override
	public Token recoverInline(Parser recognizer) throws RecognitionException {
		// SINGLE TOKEN DELETION
		Token matchedSymbol = singleTokenDeletion(recognizer);
		if ( matchedSymbol!=null ) {
			// we have deleted the extra token.
			// now, move past ttype token as if all were ok
			recognizer.consume();
			return matchedSymbol;
		}

		// SINGLE TOKEN INSERTION
		if ( singleTokenInsertion(recognizer) ) {
			return getMissingSymbol(recognizer);
		}

		// even that didn't work; must throw the exception
		throw new InputMismatchException(recognizer);
	}

	@Override
	public void sync(Parser recognizer) throws RecognitionException {
		
	}

}
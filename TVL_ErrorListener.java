import java.util.*;

// import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;


public class TVL_ErrorListener extends BaseErrorListener
{
	public boolean error_exists = false;

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
							Object offendingSymbol,
							int line, int charPositionInLine,
							String msg,
							RecognitionException e)
	{
		List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
		Collections.reverse(stack);
		
		if ( msg == null || msg.length() == 0 )
			return;
		
		if ( !error_exists )
		{
			System.err.println();
			System.err.println();
		}
		
		System.err.println(msg);
		
		error_exists = true;
	}
}

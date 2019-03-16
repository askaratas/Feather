// import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;


public class Feather_Lexer extends FeatherLexer
{
	public Feather_Lexer(CharStream input)
	{
		super(input);
	}
	
	
	@Override
	public void notifyListeners(LexerNoViableAltException e) 
	{
		CharStream input = e.getInputStream();
		int index = e.getStartIndex();
		Interval intrvl = new Interval(index, index);

		String msg = getLine() + ": illegal character '" + input.getText(intrvl) + "' in token";
		System.err.println(msg);
	}
}

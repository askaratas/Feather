import java.io.*;

// import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;


public class TVL_Parser
{
	public static void main(String[] args) throws Exception 
	{
		System.out.println("*************************************************************************");
		System.out.println("TVL to Feather Translator");
		System.out.println("-------------------------");
		
		if ( args.length == 0 )
		{
			System.out.println("Error: No input code file provided.");
			System.out.println("Exiting...");
			throw new Exception();
		}

		File codefile;
		
		try
		{
			codefile = new File(args[0]);
		}
		catch (Exception e)
		{
			System.out.println("Error: Input code file could not be opened.");
			System.out.println("Exiting...");
			throw new Exception();
		}
		
		InputStream inpStr = new FileInputStream(codefile);
		
		// create a CharStream that reads from the specified file
		ANTLRInputStream input = new ANTLRInputStream(inpStr);
		
		// create a lexer that feeds off of input CharStream
		TVL_Lexer lexer = new TVL_Lexer(input);
		
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// create a parser that feeds off the tokens buffer
		TVLParser parser = new TVLParser(tokens);

		parser.removeErrorListeners(); // remove ConsoleErrorListener
	    TVL_ErrorListener myErrListener = new TVL_ErrorListener();
		parser.addErrorListener(myErrListener); // add ours

		parser.setErrorHandler(new TVL_ErrorStrategy());

		System.out.print("Parsing [" + args[0] + "]...");
		
		TVLParser.SContext sctx = null;
		try
		{
			sctx = parser.s();
		}
		catch (Exception e)
		{
			throw new Exception();
		}
		
		if ( myErrListener.error_exists )
		{
			System.out.println();
			System.out.print("...found errors, no output Feather declarations code generated.");
			throw new Exception();
		}
		
		System.out.println("OK");
		
		// create the output intermediate code file
		FileWriter ilfile;
		try
		{
			System.out.print("Generating Feather declarations file [" + args[0] + ".feat]...");
			ilfile = new FileWriter(args[0] + ".feat");
			ilfile.write(sctx.featherCode);
			ilfile.close();
			System.out.println("OK");
		}
		catch (Exception e)
		{
			System.out.println("Error: Could not create the output declarations file.");
			System.out.print("Exiting...");
			throw new Exception();
		}
		
		System.out.println("DONE!");
		System.out.println("*************************************************************************");
	}
}

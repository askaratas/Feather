import java.io.*;

// import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;


public class Feather_Parser
{
	public static void main(String[] args) throws Exception 
	{
		System.out.println("*************************************************************************");
		System.out.println("Feather 1.0 Parser");
		System.out.println("------------------");
		
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
			throw e;
		}
		
		if ( codefile.isFile() == false )
		{
			System.out.println("Error: Input code file could not be opened.");
			System.out.println("Exiting...");
			throw new Exception();
		}
		
		InputStream inpStr = new FileInputStream(codefile);
		
		// create a CharStream that reads from the specified file
		ANTLRInputStream input = new ANTLRInputStream(inpStr);
		
		// create a lexer that feeds off of input CharStream
		Feather_Lexer lexer = new Feather_Lexer(input);
		
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// create a parser that feeds off the tokens buffer
		FeatherParser parser = new FeatherParser(tokens);

		parser.removeErrorListeners(); // remove ConsoleErrorListener
	    Feather_ErrorListener myErrListener = new Feather_ErrorListener();
		parser.addErrorListener(myErrListener); // add ours

		parser.setErrorHandler(new Feather_ErrorStrategy());

		System.out.print("Parsing [" + args[0] + "]... ");
		
		FeatherParser.SContext sctx = null;
		try
		{
			sctx = parser.s();
		}
		catch (Exception e)
		{
			System.out.println("AN UNEXPECTED ERROR OCCURED!");
			System.out.println("Exiting...");
			throw e;
		}
		
		if ( myErrListener.error_exists )
		{
			System.out.println();
			System.out.print("...found errors, no output intermediate code generated.");
			throw new Exception();
		}
		
		System.out.println("OK");
		
		// create the output intermediate code file
		FileWriter ilfile;
		try
		{
			System.out.print("Generating intermediate language code file [" + args[0] + ".eil]... ");
			ilfile = new FileWriter(args[0] + ".eil");
			ilfile.write(sctx.ilcode);
			ilfile.close();
			System.out.println("OK");
		}
		catch (Exception e)
		{
			System.out.println("Error: Could not create the output intermediate language file.");
			System.out.print("Exiting...");
			throw e;
		}
		
		System.out.println("DONE!");
		System.out.println("*************************************************************************");
	}
}

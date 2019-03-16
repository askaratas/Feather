import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class feather
{
	public static void main(String args[])
	{
		try
		{
			run(args);
		}
		catch (Exception e)
		{
			System.out.println("");
			System.out.println("An unexpected error occured! Exiting...");
			System.out.println("");
		}
	}
	
	
	private static void run(String args[])
	{
		if ( args.length == 0 || args[0].equalsIgnoreCase("-h") )
		{
			System.out.println("  -i : Running Mode - Ignore all errors & warnings");
			System.out.println("  -e : Running Mode - Stop on first error (ignore warnings)");
			System.out.println("  -w : Running Mode - Stop on first warning");
			System.out.println("  -f  <feather-file>              : Input Feather file (declarations + commands)");
			System.out.println("  -d  <feather-declarations-file> : Input Feather declarations file");
			System.out.println("  -t  <tvl-declarations-file>     : Input TVL declarations file");
			System.out.println("  -c  <feather-commands-file>     : Input Feather commands file");
			System.out.println("  -o  <feather-declarations-file> : Output Feather declarations file");
			System.out.println("  -ot <tvl-declarations-file>     : Output TVL declarations file");
			System.out.println("  -h : Display this help message");
			
			return;
		}
		
		
		int i;
		int stopCode;
		
		stopCode = Codes.MODE_STOP_ON_ERRORS;
		for (i=0; i < args.length; i++)
		{
			if ( args[i].equalsIgnoreCase("-i") )
			{
				stopCode = Codes.MODE_IGNORE_ALL;
				break;
			}
			else if ( args[i].equalsIgnoreCase("-e") )
			{
				stopCode = Codes.MODE_STOP_ON_ERRORS;
				break;
			}
			else if ( args[i].equalsIgnoreCase("-w") )
			{
				stopCode = Codes.MODE_STOP_ON_WARNINGS;
				break;
			}
		}
		
		
		String featherFile, featherDecFile, tvlDecFile, commandFile, outFeatherFile, outTVLFile;
		boolean outFileSpecified, processOK;
		
		featherFile = featherDecFile = tvlDecFile = commandFile = outFeatherFile = outTVLFile = null;
		outFileSpecified = false;
		
		for (i=0; i < args.length; i++)
		{
			if ( args[i].equalsIgnoreCase("-f") )
			{
				try
				{
					featherFile = args[i+1];
					i++;
				}
				catch ( Exception e )
				{
					System.out.println("Missing input Feather file!");
					return;
				}
			}
			else if ( args[i].equalsIgnoreCase("-d") )
			{
				try
				{
					featherDecFile = args[i+1];
					i++;
				}
				catch ( Exception e )
				{
					System.out.println("Missing input Feather declarations file!");
					return;
				}
			}
			else if ( args[i].equalsIgnoreCase("-t") )
			{
				try
				{
					tvlDecFile = args[i+1];
					i++;
				}
				catch ( Exception e )
				{
					System.out.println("Missing input TVL declarations file!");
					return;
				}
			}
			else if ( args[i].equalsIgnoreCase("-c") )
			{
				try
				{
					commandFile = args[i+1];
					i++;
				}
				catch ( Exception e )
				{
					System.out.println("Missing input Feather commands file!");
					return;
				}
			}
			else if ( args[i].equalsIgnoreCase("-o") )
			{
				outFileSpecified = true;
				try
				{
					outFeatherFile = args[i+1];
					i++;
				}
				catch ( Exception e )
				{
					System.out.println("Missing output Feather declarations filename!");
					return;
				}
			}
			else if ( args[i].equalsIgnoreCase("-ot") )
			{
				outFileSpecified = true;
				try
				{
					outTVLFile = args[i+1];
					i++;
				}
				catch ( Exception e )
				{
					System.out.println("Missing output TVL declarations filename!");
					return;
				}
			}
			else if ( args[i].equalsIgnoreCase("-i") || args[i].equalsIgnoreCase("-e") || args[i].equalsIgnoreCase("-w") || args[i].equalsIgnoreCase("-h") )
			{
				// just skip
			}
			else
			{
				System.out.println("Unknown command line parameter: " + args[i] + "\r\n");
				
				System.out.println("  -i : Running Mode - Ignore all errors & warnings");
				System.out.println("  -e : Running Mode - Stop on first error (ignore warnings)");
				System.out.println("  -w : Running Mode - Stop on first warning");
				System.out.println("  -f  <feather-file>              : Input Feather file (declarations + commands)");
				System.out.println("  -d  <feather-declarations-file> : Input Feather declarations file");
				System.out.println("  -t  <tvl-declarations-file>     : Input TVL declarations file");
				System.out.println("  -c  <feather-commands-file>     : Input Feather commands file");
				System.out.println("  -o  <feather-declarations-file> : Output Feather declarations file");
				System.out.println("  -ot <tvl-declarations-file>     : Output TVL declarations file");
				System.out.println("  -h : Display this help message");
				
				return;
			}
		}
		
		String[] prsrArgs;
		
		String inputFile = null;
		if ( featherFile != null )
		{
			inputFile = featherFile;
		}
		else if ( commandFile == null )
		{
			System.out.println("No input command file specified!");
			return;
		}
		else if ( featherDecFile != null )
		{
			System.out.print("Generating the merged input Feather file... ");
			processOK = mergeFiles(featherDecFile, commandFile, "__tmpinput.feat");
			if ( ! processOK )
			{
				System.out.println("");
				return;
			}
			System.out.println("DONE!");
			
			inputFile = "__tmpinput.feat";
		}
		else if ( tvlDecFile != null )
		{
			prsrArgs = new String[1];
			prsrArgs[0] = tvlDecFile;
			
			try
			{
				TVL_Parser.main(prsrArgs);
			}
			catch ( Exception e)
			{
				return;
			}
			
			System.out.print("Generating the merged input Feather file... ");
			processOK = mergeFiles(tvlDecFile+".feat", commandFile, "__tmpinput.feat");
			if ( ! processOK )
			{
				System.out.println("");
				return;
			}
			System.out.println("DONE!");
			
			inputFile = "__tmpinput.feat";
		}
		else
		{
			System.out.println("No input declarations file specified, exiting...");
			return;
		}
		
		// try to parse the input file
		prsrArgs = new String[1];
		prsrArgs[0] = inputFile;
		try
		{
			Feather_Parser.main(prsrArgs);
		}
		catch ( Exception e )
		{
			return;
		}
		
		ArrayList<CommandExecutionError> errors = new ArrayList<CommandExecutionError>();
		CommandExecutionError err;
		
		System.out.print("Executing the commands... ");
		FeatureModel fm = Interpreter.run(inputFile+".eil", stopCode, errors);
		System.out.println("DONE!");
		
		if ( errors.size() > 0 )
		{
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("                            Errors & Warnings");
			System.out.println("                            =================");
			for (i=0; i < errors.size(); i++)
			{
				err = (CommandExecutionError) errors.get(i);
				System.out.println(err.explanation);
			}
			System.out.println("-------------------------------------------------------------------------");
		}
		
		System.out.print("Saving the transformed model... ");
		if ( outFileSpecified )
		{
			if ( outFeatherFile != null )
			{
				Feather_CodeGenerator.generateCode(fm.getFeatureDiagram(), fm.getFeatureList(), fm.getCrossTreeConstraintList(), outFeatherFile);
			}
			else if ( outTVLFile != null )
			{
				TVL_CodeGenerator.generateCode(fm.getFeatureDiagram(), fm.getFeatureList(), fm.getCrossTreeConstraintList(), outTVLFile);
			}
			else
			{
				Feather_CodeGenerator.generateCode(fm.getFeatureDiagram(), fm.getFeatureList(), fm.getCrossTreeConstraintList(), "__evolved.feat");
			}
		}
		else
		{
			Feather_CodeGenerator.generateCode(fm.getFeatureDiagram(), fm.getFeatureList(), fm.getCrossTreeConstraintList(), "__evolved.feat");
		}
		System.out.println("DONE!");
	}
	
	private static boolean mergeFiles(String declarationsFile, String commandsFile, String outFile)
	{
		File decFile, cmdFile;
		Scanner scn;
		
		try
		{
			decFile = new File(declarationsFile);
			scn = new Scanner(decFile);
			scn.useLocale(Locale.ENGLISH);
		}
		catch ( Exception e )
		{
			System.out.println("Could not open the input Feather declarations file!");
			return false;
		}
		
		String declarations = "";
		while ( scn.hasNextLine() )
		{
			declarations += scn.nextLine() + "\r\n";
		}
		scn.close();
		
		try
		{
			cmdFile = new File(commandsFile);
			scn = new Scanner(cmdFile);
			scn.useLocale(Locale.ENGLISH);
		}
		catch ( Exception e )
		{
			System.out.println("Could not open the input Feather commands file!");
			return false;
		}
		
		String commands = "";
		while ( scn.hasNextLine() )
		{
			commands += scn.nextLine() + "\r\n";
		}
		scn.close();
		
		String fileContent = declarations + "\r\n" + commands;
		
		FileWriter mergedFile;
		BufferedWriter bufWriter;
		try
		{
			mergedFile = new FileWriter(outFile);
			bufWriter = new BufferedWriter(mergedFile);
			bufWriter.write(fileContent);
			bufWriter.close();
		}
		catch (Exception e)
		{
			System.out.println("Could not create the temporary input Feather file!");
			return false;
		}
		
		return true;
	}
	
}



















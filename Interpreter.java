import java.util.ArrayList;

import se.sics.jasper.SICStus;


public class Interpreter
{
	public static FeatureModel run(String eilFile, int mode, ArrayList<CommandExecutionError> errors)
	{
		if ( eilFile == null || eilFile == "" )
		{
			System.out.println("No input EIL file specified! Exiting...");
			return null;
		}
		
		if ( errors == null )
		{
			errors = new ArrayList<CommandExecutionError>();
		}
		
		EILReader reader = new EILReader(eilFile);
		
		int result = reader.readEILFile();
		if ( result != ErrorCodes.NO_ERROR )
		{
			switch ( result )
			{
				case ErrorCodes.EIL_ERROR_IN_FILE:
					System.out.println("Could not open the evolution intermediate language code file! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_IN_ROOT_DECLARATION:
					System.out.println("Invalid root feature declaration! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_NO_COMMANDS:
					System.out.println("No commands found in the program! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_IN_FEATURE_DECLARATION:
					System.out.println("Invalid feature declaration! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_IN_CONSTRAINT_DECLARATION:
					System.out.println("Invalid cross-tree constraint declaration! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_IN_ADDFEATURE_CMD:
					System.out.println("Invalid add feature command! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_IN_UPDATEFEATURE_CMD:
					System.out.println("Invalid update a feature command! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_IN_UPDATEMULTFEATURES_CMD:
					System.out.println("Invalid update multiple features command! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_IN_REMOVEFEATURE_CMD:
					System.out.println("Invalid remove a feature command! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_IN_REMOVEMULTFEATURES_CMD:
					System.out.println("Invalid remove multiple features command! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_IN_ADDCONSTRAINT_CMD:
					System.out.println("Invalid add cross-tree constraint command! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_IN_UPDATECONSTRAINT_CMD:
					System.out.println("Invalid update a cross-tree constraint command! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_IN_UPDATEMULTCONSTRAINTS_CMD:
					System.out.println("Invalid update multiple cross-tree constraints command! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_IN_REMOVECONSTRAINT_CMD:
					System.out.println("Invalid remove a cross-tree constraint command! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_IN_REMOVEMULTCONSTRAINTS_CMD:
					System.out.println("Invalid remove multiple cross-tree constraints command! Exiting...");
					return null;
					
				case ErrorCodes.EIL_ERROR_INVALID_COMMAND:
					System.out.println("Invalid command! Exiting...");
					return null;
					
				default:
					System.out.println("(Reading EIL file) [Error Code: " + result + "] Exiting...");
					return null;
			}
		}
		
		FeatureModel fm = new FeatureModel();
		
		boolean processOK = fm.setRoot(reader.getRoot());
		if ( !processOK )
		{
			System.out.println("Could not set the root feature of the feature model! Exiting...");
			return fm;
		}
		
		DeclarationError de = fm.addFeaturesFromDeclarations(reader.getFeatureList());
		if ( de != null && de.errorCode != ErrorCodes.NO_ERROR )
		{
			switch ( de.errorCode )
			{
				case ErrorCodes.MISSING_INFO_IN_RAW_FEATURE:
					System.out.println("Missing information in the declaration of the feature \"" + de.erronousFeature._name + "\"! Exiting...");
					return fm;
					
				case ErrorCodes.NEW_ROOT_CANNOT_BE_ADDED:
					System.out.println("Missing parent information in the declaration of the feature \"" + de.erronousFeature._name + "\"! Exiting...");
					return fm;
					
				case ErrorCodes.FEATURE_NAME_IN_USE:
					System.out.println("Multiple features with the same name (i.e., \"" + de.erronousFeature._name + "\") cannot exist! Exiting...");
					return fm;
					
				case ErrorCodes.PARENT_NOT_FOUND:
					System.out.println("Invalid parent specification in the declaration of the feature \"" + de.erronousFeature._name + "\"! Exiting...");
					return fm;
					
				case ErrorCodes.SIBLING_NOT_FOUND:
					System.out.println("Invalid sibling specification in the declaration of the feature \"" + de.erronousFeature._name + "\"! Exiting...");
					return fm;
					
				case ErrorCodes.SIBLING_NOT_A_SIBLING:
					System.out.println("Feature specified as sibling in the declaration of the feature \"" + de.erronousFeature._name + "\" cannot be a sibling of this feature! Exiting...");
					return fm;
					
				case ErrorCodes.INCONSISTENT_DECOMP_TYPE:
					System.out.println("The feature \"" + de.erronousFeature._name + "\" and the feature specified as its sibling have inconsistent decomposition relation types! Exiting...");
					return fm;
					
				case ErrorCodes.CYCLE_IN_FEATURE_DECLARATIONS:
					System.out.println("Cycle detected in feature declarations! Exiting...");
					return fm;
					
				default:
					System.out.println("(Adding features to the model from the declarations) [Error Code: " + de.errorCode + "] Exiting...");
					return fm;
			}
		}
		
		de = fm.addConstraintsFromDeclarations(reader.getConstraintList());
		if ( de != null && de.errorCode != ErrorCodes.NO_ERROR )
		{
			switch ( de.errorCode )
			{
				case ErrorCodes.LEFT_FEATURE_NOT_FOUND:
				case ErrorCodes.RIGHT_FEATURE_NOT_FOUND:
					System.out.println("The feature \"" + de.erronousFeature._name + "\" specified in the cross-tree constraint does not exist! Exiting...");
					return fm;
					
				case ErrorCodes.INVALID_CONSTRAINT_TYPE:
					System.out.println("Invalid constraint type in cross-tree constraint declaration! Exiting...");
					return fm;
					
				default:
					System.out.println("(Adding cross-tree constraints to the model from the declarations) [Error Code: " + de.errorCode + "] Exiting...");
					return fm;
			}
		}

		int runningMode;
		switch ( mode )
		{
			case Codes.MODE_STOP_ON_WARNINGS:
				runningMode = Codes.MODE_STOP_ON_WARNINGS;
				break;
				
			case Codes.MODE_STOP_ON_ERRORS:
				runningMode = Codes.MODE_STOP_ON_ERRORS;
				break;
				
			case Codes.MODE_IGNORE_ALL:
				runningMode = Codes.MODE_IGNORE_ALL;
				break;
				
			default:
				runningMode = Codes.MODE_STOP_ON_ERRORS;
				break;
		}
		
		SICStus sp;
		try
		{
			sp = new SICStus(null, null);
		}
		catch (Exception e)
		{
			System.out.println("Could not initialize constraint solver engine! Exiting...");
			return fm;
		}
		
		int i;
		ArrayList<Command> commands = reader.getCommandList();
		Command cmd;
		CommandExecutionError cee;
		boolean stopExecution = false;
		String cmdType, cmdExp;
		for (i=0; i<commands.size(); i++)
		{
			cmd = commands.get(i);
			cee = InterpreterEngine.executeACommand(fm, cmd, sp);
			
			switch ( cmd.type )
			{
				case Codes.COMMAND_ADD_F      : cmdType = "addf"; break;
				case Codes.COMMAND_UPDATE_F   : cmdType = "upf";  break;
				case Codes.COMMAND_UPDATEALL_F: cmdType = "upmf"; break;
				case Codes.COMMAND_REMOVE_F   : cmdType = "rmf";  break;
				case Codes.COMMAND_REMOVEALL_F: cmdType = "rmmf"; break;
				case Codes.COMMAND_ADD_C      : cmdType = "addc"; break;
				case Codes.COMMAND_UPDATE_C   : cmdType = "upc";  break;
				case Codes.COMMAND_UPDATEALL_C: cmdType = "upmc"; break;
				case Codes.COMMAND_REMOVE_C   : cmdType = "rmc";  break;
				case Codes.COMMAND_REMOVEALL_C: cmdType = "rmmc"; break;
				default: cmdType = "";
			}
			
			cmdExp = "cmd #" + (i+1) + " (" + cmdType + ")";
			while ( cmdExp.length() < 15 )
			{
				cmdExp += " ";
			}
			cmdExp += ": ";
			
			if ( cee.errorCode != Codes._NO_VALUE_ )
			{
				cee.explanation = cmdExp + cee.explanation;
			}
			
			if ( runningMode == Codes.MODE_IGNORE_ALL )
			{
				if ( cee.errorCode != ErrorCodes.NO_ERROR )
				{
					errors.add(cee);
				}
				continue;
			}
			
			if ( cee.errorCode != ErrorCodes.NO_ERROR )
			{
				switch ( cee.errorCode )
				{
					case ErrorCodes.EXECUTION_NULL_MODEL:
					case ErrorCodes.EXECUTION_INVALID_COMMAND:
					case ErrorCodes.EXECUTION_MODULUS_TYPE:
					case ErrorCodes.EXECUTION_FEATURE_ATTR_TYPE:
					case ErrorCodes.EXECUTION_FEATURE_VAR_TYPE:
					case ErrorCodes.EXECUTION_CONSTRAINT_SOLVER:
					case ErrorCodes.EXECUTION_AMBIGUOUS_NEW_LEFT:
					case ErrorCodes.EXECUTION_AMBIGUOUS_NEW_RIGHT:
					case ErrorCodes.EXECUTION_AMBIGUOUS_NEW_PARENT:
					case ErrorCodes.EXECUTION_AMBIGUOUS_NEW_DECOMP_REL:
					case ErrorCodes.EXECUTION_AMBIGUOUS_NEW_DECOMP_ID:
					case ErrorCodes.EXECUTION_AMBIGUOUS_ATTR_ASSIGNMENT:
					case ErrorCodes.EXECUTION_ROOT_NOT_SET:
					case ErrorCodes.EXECUTION_ADDF_MISSING_INFO:
					case ErrorCodes.EXECUTION_ADDF_NEW_ROOT_CANNOT_BE_ADDED:
					case ErrorCodes.EXECUTION_ADDF_FEATURE_NAME_IN_USE:
					case ErrorCodes.EXECUTION_ADDF_PARENT_DOES_NOT_EXIST:
					case ErrorCodes.EXECUTION_ADDF_RELSIBLING_DOES_NOT_EXIST:
					case ErrorCodes.EXECUTION_ADDF_RELSIBLING_NOT_SIBLING:
					case ErrorCodes.EXECUTION_ADDF_INCONSISTENT_DECOMP_TYPE:
					case ErrorCodes.EXECUTION_UPF_FEATURE_DOES_NOT_EXIST:
					case ErrorCodes.EXECUTION_UPF_AMBIGUOUS_WHICH_FEATURE:
					case ErrorCodes.EXECUTION_UPF_NEW_NAME_IN_USE:
					case ErrorCodes.EXECUTION_UPF_DECOMP_ROOT_NO:
					case ErrorCodes.EXECUTION_UPF_RELSIBLING_DOES_NOT_EXIST:
					case ErrorCodes.EXECUTION_UPF_INCONSISTENT_DECOMP_TYPE:
					case ErrorCodes.EXECUTION_UPF_ROOT_CANNOT_BE_MOVED:
					case ErrorCodes.EXECUTION_UPF_DECOMP_REL_MUST_BE_UPDATED:
					case ErrorCodes.EXECUTION_UPF_UPDATE_CAUSES_CYCLE:
					case ErrorCodes.EXECUTION_UPF_NEW_PARENT_NOT_FOUND:
					case ErrorCodes.EXECUTION_UPF_NEW_DEC_SPEC_FEAT_NOT_FOUND:
					case ErrorCodes.EXECUTION_UPF_RELSIBLING_NOT_SIBLING:
					case ErrorCodes.EXECUTION_UPF_ATTRIBUTE_NOT_FOUND:
					case ErrorCodes.EXECUTION_UPALLF_NEW_PARENT_NOT_FOUND:
					case ErrorCodes.EXECUTION_UPALLF_RELSIBLING_DOES_NOT_EXIST:
					case ErrorCodes.EXECUTION_UPALLF_RELSIBLING_NOT_SIBLING:
					case ErrorCodes.EXECUTION_REMF_FEATURE_DOES_NOT_EXIST:
					case ErrorCodes.EXECUTION_REMF_AMBIGUOUS_WHICH_FEATURE:
					case ErrorCodes.EXECUTION_REMF_ROOT_CANNOT_BE_REMOVED:
					case ErrorCodes.EXECUTION_REMF_PARENT_NOT_FOUND:
					case ErrorCodes.EXECUTION_ADDC_LEFT_NOT_FOUND:
					case ErrorCodes.EXECUTION_ADDC_INVALID_CONSTRAINT:
					case ErrorCodes.EXECUTION_ADDC_RIGHT_NOT_FOUND:
					case ErrorCodes.EXECUTION_ADDC_NONEXISTING_FEATURE:
					case ErrorCodes.EXECUTION_UPC_INVALID_CONSTRAINT:
					case ErrorCodes.EXECUTION_UPC_AMBIGUOUS_WHICH_CONSTRAINT:
					case ErrorCodes.EXECUTION_UPC_CONSTRAINT_DOES_NOT_EXIST:
					case ErrorCodes.EXECUTION_UPC_LEFT_NOT_FOUND:
					case ErrorCodes.EXECUTION_UPC_RIGHT_NOT_FOUND:
					case ErrorCodes.EXECUTION_UPALLC_LEFT_NOT_FOUND:
					case ErrorCodes.EXECUTION_UPALLC_RIGHT_NOT_FOUND:
					case ErrorCodes.EXECUTION_REMC_CONST_DOES_NOT_EXIST:
					case ErrorCodes.EXECUTION_REMC_AMBIGUOUS_WHICH_CONSTRAINT:
					case ErrorCodes.EXECUTION_UNKNOWN:
						errors.add(cee);
						if ( runningMode == Codes.MODE_STOP_ON_ERRORS || runningMode == Codes.MODE_STOP_ON_WARNINGS )
						{
							stopExecution = true;
						}
						break;
						
					case ErrorCodes.EXECUTION_WHERE_FAILED:
					case ErrorCodes.EXECUTION_UPALLF_FEATURE_DOES_NOT_EXIST:
					case ErrorCodes.EXECUTION_UPALLF_DECOMP_ROOT_NO:
					case ErrorCodes.EXECUTION_UPALLF_INCONSISTENT_DECOMP_TYPE:
					case ErrorCodes.EXECUTION_UPALLF_ROOT_CANNOT_BE_MOVED:
					case ErrorCodes.EXECUTION_UPALLF_DECOMP_REL_MUST_BE_UPDATED:
					case ErrorCodes.EXECUTION_UPALLF_UPDATE_CAUSES_CYCLE:
					case ErrorCodes.EXECUTION_UPALLF_ATTRIBUTE_NOT_FOUND:
					case ErrorCodes.EXECUTION_REMALLF_FEATURE_DOES_NOT_EXIST:
					case ErrorCodes.EXECUTION_REMALLF_ROOT_CANNOT_BE_REMOVED:
					case ErrorCodes.EXECUTION_REMALLF_PARENT_NOT_FOUND:
					case ErrorCodes.EXECUTION_ADDC_ALREADY_EXISTS:
					case ErrorCodes.EXECUTION_UPALLC_INVALID_CONSTRAINT:
					case ErrorCodes.EXECUTION_UPALLC_CONST_DOES_NOT_EXIST:
					case ErrorCodes.EXECUTION_REMALLC_CONST_DOES_NOT_EXIST:
						errors.add(cee);
						if ( runningMode == Codes.MODE_STOP_ON_WARNINGS )
						{
							stopExecution = true;
						}
						break;
				}
			}
			
			if ( stopExecution )
			{
				return fm;
			}
		}
		
		return fm;
	}
}

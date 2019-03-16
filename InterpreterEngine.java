import java.util.ArrayList;

import se.sics.jasper.*;


/** *******************************************************************************************
 * InterpreterEngine
 * --------------------------------------------------------------------------------------------
 * @author Ahmet Serkan Karatas
 *
 ** ******************************************************************************************* */

class InterpreterEngine
{
	public static CommandExecutionError executeACommand(FeatureModel fm, Command cmd, SICStus sp)
	{
		CommandExecutionError cee = new CommandExecutionError();
		
		// before starting check the validity of the arguments
		
		cee = checkArguments(fm, cmd, sp);
		if ( cee.errorCode != ErrorCodes.NO_ERROR )
		{
			return cee;
		}
		
		ArrayList<Feature> featureList = fm.getFeatureList();
		ArrayList<CrossTreeConstraint> constraintList = fm.getCrossTreeConstraintList();
		
		// perform dynamic type checking
		
		ArrayList<FeatureVariable> assumptionList = createAssumptionList(cmd);
		TypeChecker tc = new TypeChecker(featureList, assumptionList);
		
		cee = performDynamicTypeChecking(tc, cmd);
		if ( cee.errorCode != ErrorCodes.NO_ERROR )
		{
			return cee;
		}
		
		// check if the where clause is satisfied
		//   - if it's satisfied find the features/constraints that will be affected
		
		AffectedEntities effects = new AffectedEntities();
		assumptionList = tc.getFeatureVariableAssumptions();
		if ( assumptionList.size() > 0 ) // constraint solving must be performed
		{
			ArrayList<MustBeCompatibleFVars> compatibilityList = tc.getCompatibilityList();
			
			cee = performConstraintSolving(sp, cmd, featureList, constraintList, assumptionList, compatibilityList, effects);
			if ( cee.errorCode != ErrorCodes.NO_ERROR )
			{
				return cee;
			}
			
			cee = checkAffectedEntities(cmd.type, effects);
			if ( cee.errorCode != ErrorCodes.NO_ERROR )
			{
				return cee;
			}
		}
		else // no resolution needed
		{
			ASTNode whereResult = evaluateExpression(cmd.whereClause, featureList);
			if ( whereResult.boolval == false )
			{
				cee.errorCode = ErrorCodes.EXECUTION_WHERE_FAILED;
				cee.explanation = "The boolean expression in the where clause failed";
				return cee;
			}
			
			// find the features/constraints that will be affected by the command
			switch ( cmd.type )
			{
				case Codes.COMMAND_UPDATE_F:
				case Codes.COMMAND_UPDATEALL_F:
				case Codes.COMMAND_REMOVE_F:
				case Codes.COMMAND_REMOVEALL_F:
					effects.Features = findTheFeaturesThatWillBeAffectedByTheCommand(cmd, null, featureList);
					break;
					
				case Codes.COMMAND_ADD_C:
					effects.Constraints = deriveTheCrossTreeConstraintsFromTheResolutions((AddAConstraintCmd)cmd, null, featureList);
					break;
					
				case Codes.COMMAND_UPDATE_C:
				case Codes.COMMAND_UPDATEALL_C:
				case Codes.COMMAND_REMOVE_C:
				case Codes.COMMAND_REMOVEALL_C:
					effects.Constraints = findTheCrossTreeConstraintsThatMatchTheResolutions(cmd, null, featureList, constraintList);
					break;
			}
			
			cee = checkAffectedEntities(cmd.type, effects);
			if ( cee.errorCode != ErrorCodes.NO_ERROR )
			{
				return cee;
			}
		}

		
		// if here, it means the command is ready (there are no type errors, and all the feature variables are resolved and replaced with features)
		// for execution
		
		switch ( cmd.type )
		{
			case Codes.COMMAND_ADD_F:
				return executeAddAFeatureCommand(fm, (AddAFeatureCmd) cmd, featureList);
				
			case Codes.COMMAND_UPDATE_F:
				return executeUpdateAFeatureCommand(fm, (UpdateAFeatureCmd) cmd, featureList, effects.Features.get(0));
				
			case Codes.COMMAND_UPDATEALL_F:
				return executeUpdateMultipleFeaturesCommand(fm, (UpdateMultipleFeaturesCmd) cmd, featureList, effects.Features);
				
			case Codes.COMMAND_REMOVE_F:
				return executeRemoveAFeatureCommand(fm, effects.Features.get(0));
				
			case Codes.COMMAND_REMOVEALL_F:
				return executeRemoveMultipleFeaturesCommand(fm, effects.Features);
				
			case Codes.COMMAND_ADD_C:
				return executeAddAConstraintCommand(fm, effects.Constraints);
				
			case Codes.COMMAND_UPDATE_C:
				return executeUpdateAConstraintCommand(fm, (UpdateAConstraintCmd) cmd, effects.Constraints.get(0));
				
			case Codes.COMMAND_UPDATEALL_C:
				return executeUpdateMultipleConstraintsCommand(fm, (UpdateMultipleConstraintsCmd) cmd, effects.Constraints);
				
			case Codes.COMMAND_REMOVE_C:
				return executeRemoveAConstraintCommand(fm, effects.Constraints.get(0));
				
			case Codes.COMMAND_REMOVEALL_C:
				return executeRemoveMultipleConstraintsCommand(fm, effects.Constraints);
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}

	
	private static CommandExecutionError checkArguments(FeatureModel fm, Command cmd, SICStus sp)
	{
		CommandExecutionError cee = new CommandExecutionError();
		
		if ( fm == null )
		{
			cee.errorCode = ErrorCodes.EXECUTION_NULL_MODEL;
			cee.explanation = "Empty feature model";
			return cee;
		}
		
		if ( cmd == null )
		{
			cee.errorCode = ErrorCodes.EXECUTION_INVALID_COMMAND;
			cee.explanation = "Empty command";
			return cee;
		}
		if ( cmd.type != Codes.COMMAND_ADD_F && cmd.type != Codes.COMMAND_UPDATE_F && cmd.type != Codes.COMMAND_UPDATEALL_F && cmd.type != Codes.COMMAND_REMOVE_F && cmd.type != Codes.COMMAND_REMOVEALL_F && 
			 cmd.type != Codes.COMMAND_ADD_C && cmd.type != Codes.COMMAND_UPDATE_C && cmd.type != Codes.COMMAND_UPDATEALL_C && cmd.type != Codes.COMMAND_REMOVE_C && cmd.type != Codes.COMMAND_REMOVEALL_C    )
		{
			cee.errorCode = ErrorCodes.EXECUTION_INVALID_COMMAND;
			cee.explanation = "Unknown command type";
			return cee;
		}
		
		if ( sp == null )
		{
			cee.errorCode = ErrorCodes.EXECUTION_CONSTRAINT_SOLVER;
			cee.explanation = "Could not initialize constraint solver engine";
			return cee;
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}
	
	private static CommandExecutionError performDynamicTypeChecking(TypeChecker tc, Command cmd)
	{
		int i;
		CommandExecutionError cee = new CommandExecutionError();
		
		
		ArrayList<ASTNode> typeCheckExpression;
		if ( cmd.type == Codes.COMMAND_ADD_F || cmd.type == Codes.COMMAND_UPDATE_F || cmd.type == Codes.COMMAND_UPDATEALL_F )
		{
			typeCheckExpression = createTypeCheckExpressionFromACommandWithAttributeAssignments(cmd);
		}
		else
		{
			typeCheckExpression = new ArrayList<ASTNode>();
			for (i=0; i<cmd.whereClause.size(); i++)
			{
				typeCheckExpression.add(cmd.whereClause.get(i));
			}
		}
		
		ASTNode problematicNode = tc.checkExpression(typeCheckExpression);
		if ( problematicNode != null )
		{
			if ( problematicNode.type == Codes.AST_TYPE_OPERATOR )
			{
				cee.errorCode = ErrorCodes.EXECUTION_MODULUS_TYPE;
				cee.explanation = "A modulus operation (%) has an invalid operand";
				return cee;
			}
			else if ( problematicNode.type == Codes.AST_TYPE_FEATURE )
			{
				cee.errorCode = ErrorCodes.EXECUTION_FEATURE_ATTR_TYPE;
				cee.explanation = "The feature attribute \"" + problematicNode.featureName + "." + problematicNode.attrName + "\" figures in an operation that is not compatible with its type";
				return cee;
			}
			else if ( problematicNode.type == Codes.AST_TYPE_FEATUREVAR )
			{
				cee.errorCode = ErrorCodes.EXECUTION_FEATURE_VAR_TYPE;
				cee.explanation = "The feature variable attribute \"" + problematicNode.featureVar + "." + problematicNode.attrName + "\" has ambiguous type";
				return cee;
			}
			
			cee.errorCode = ErrorCodes.EXECUTION_UNKNOWN;
			cee.explanation = "" + problematicNode.type;
			return cee;
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}
	
	private static CommandExecutionError performConstraintSolving(
			SICStus sp,
			Command cmd,
			ArrayList<Feature> featureList,
			ArrayList<CrossTreeConstraint> constraintList,
			ArrayList<FeatureVariable> assumptionList,
			ArrayList<MustBeCompatibleFVars> compatibilityList,
			AffectedEntities effects)
	{
		int i;
		CommandExecutionError cee = new CommandExecutionError();
		
		ArrayList<FeatureVarSolutionSet> solutionSet = null;
		ArrayList<Integer> ctcEliminationCriteria = createCTCEliminationCriteriaList(cmd);
		
		ArrayList<ASTNode> whereExpression = new ArrayList<ASTNode>();
		for (i=0; i<cmd.whereClause.size(); i++)
		{
			whereExpression.add(cmd.whereClause.get(i));
		}
		
		try
		{
			solutionSet = ConstraintSolver.resolveVariables(sp, assumptionList, featureList, whereExpression, ctcEliminationCriteria, constraintList);
		}
		catch ( ConstraintSolverException cse )
		{
			cee.errorCode = ErrorCodes.EXECUTION_CONSTRAINT_SOLVER;
			cee.explanation = cse.message;
			return cee;
		}
		
		eliminateIncompatibleResolutions(solutionSet, compatibilityList, featureList);
		
		if ( solutionSet == null || solutionSet.size() == 0 )
		{
			cee.errorCode = ErrorCodes.EXECUTION_WHERE_FAILED;
			cee.explanation = "No resolutions could be found to satisfy the where clause";
			return cee;
		}
		
		// find the features/constraints that will be affected by the command
		switch ( cmd.type )
		{
			case Codes.COMMAND_UPDATE_F:
			case Codes.COMMAND_UPDATEALL_F:
			case Codes.COMMAND_REMOVE_F:
			case Codes.COMMAND_REMOVEALL_F:
				effects.Features = findTheFeaturesThatWillBeAffectedByTheCommand(cmd, solutionSet, featureList);
				break;
				
			case Codes.COMMAND_ADD_C:
				effects.Constraints = deriveTheCrossTreeConstraintsFromTheResolutions((AddAConstraintCmd)cmd, solutionSet, featureList);
				break;
				
			case Codes.COMMAND_UPDATE_C:
			case Codes.COMMAND_UPDATEALL_C:
			case Codes.COMMAND_REMOVE_C:
			case Codes.COMMAND_REMOVEALL_C:
				effects.Constraints = findTheCrossTreeConstraintsThatMatchTheResolutions(cmd, solutionSet, featureList, constraintList);
				break;
		}
		
		// replace the feature variables in the commands with their resolutions (i.e., features)
		if ( cmd.type == Codes.COMMAND_ADD_F )
		{
			cee = replaceVariablesWithFeatures_AddF((AddAFeatureCmd) cmd, solutionSet, featureList);
		}
		else if ( cmd.type == Codes.COMMAND_UPDATE_F )
		{
			cee = replaceVariablesWithFeatures_UpF((UpdateAFeatureCmd) cmd, solutionSet, featureList);
		}
		else if ( cmd.type == Codes.COMMAND_UPDATEALL_F )
		{
			cee = replaceVariablesWithFeatures_UpAllF((UpdateMultipleFeaturesCmd) cmd, solutionSet, featureList);
		}
		else if ( cmd.type == Codes.COMMAND_UPDATE_C )
		{
			cee = replaceVariablesWithFeatures_UpC((UpdateAConstraintCmd) cmd, solutionSet, featureList);
		}
		else if ( cmd.type == Codes.COMMAND_UPDATEALL_C )
		{
			cee = replaceVariablesWithFeatures_UpAllC((UpdateMultipleConstraintsCmd) cmd, solutionSet, featureList);
		}
		else
		{
			cee.errorCode = ErrorCodes.NO_ERROR;
		}
		
		return cee;
	}
	
	private static CommandExecutionError checkAffectedEntities(int commandType, AffectedEntities entities)
	{
		int i;
		CommandExecutionError cee = new CommandExecutionError();
		RawCrossTreeConstraint rawctc;
		
		switch ( commandType )
		{
			case Codes.COMMAND_UPDATE_F:
				if ( entities.Features == null || entities.Features.size() == 0 )
				{
					cee.errorCode = ErrorCodes.EXECUTION_UPF_FEATURE_DOES_NOT_EXIST;
					cee.explanation = "Feature subject to the update command is not found in the model";
					return cee;
				}
				else if ( entities.Features.size() > 1 )
				{
					cee.errorCode = ErrorCodes.EXECUTION_UPF_AMBIGUOUS_WHICH_FEATURE;
					cee.explanation = "Command is ambiguous on which feature is to be updated (" + entities.Features.get(0);
					for (i=1; i<entities.Features.size(); i++)
					{
						cee.explanation += ", " + entities.Features.get(i);
					}
					cee.explanation += ")";
					return cee;
				}
				break;
				
			case Codes.COMMAND_UPDATEALL_F:
				if ( entities.Features == null || entities.Features.size() == 0 )
				{
					cee.errorCode = ErrorCodes.EXECUTION_UPALLF_FEATURE_DOES_NOT_EXIST;
					cee.explanation = "No features match the update all command";
					return cee;
				}
				break;
				
			case Codes.COMMAND_REMOVE_F:
				if ( entities.Features == null || entities.Features.size() == 0 )
				{
					cee.errorCode = ErrorCodes.EXECUTION_REMF_FEATURE_DOES_NOT_EXIST;
					cee.explanation = "Feature subject to the remove command is not found in the model";
					return cee;
				}
				else if ( entities.Features.size() > 1 )
				{
					cee.errorCode = ErrorCodes.EXECUTION_REMF_AMBIGUOUS_WHICH_FEATURE;
					cee.explanation = "Command is ambiguous on which feature is to be removed (" + entities.Features.get(0);
					for (i=1; i<entities.Features.size(); i++)
					{
						cee.explanation += ", " + entities.Features.get(i);
					}
					cee.explanation += ")";
					return cee;
				}
				break;
				
			case Codes.COMMAND_REMOVEALL_F:
				if ( entities.Features == null || entities.Features.size() == 0 )
				{
					cee.errorCode = ErrorCodes.EXECUTION_REMALLF_FEATURE_DOES_NOT_EXIST;
					cee.explanation = "No features match the remove all command";
					return cee;
				}
				break;
				
			case Codes.COMMAND_ADD_C:
				if ( entities.Constraints == null || entities.Constraints.size() == 0 )
				{
					cee.errorCode = ErrorCodes.EXECUTION_ADDC_NONEXISTING_FEATURE;
					cee.explanation = "A non-existing feature is used in the constraint description subject to the add command";
					return cee;
				}
				break;
				
			case Codes.COMMAND_UPDATE_C:
				if ( entities.Constraints == null || entities.Constraints.size() == 0 )
				{
					cee.errorCode = ErrorCodes.EXECUTION_UPC_CONSTRAINT_DOES_NOT_EXIST;
					cee.explanation = "Constraint subject to the update command is not found in the model";
					return cee;
				}
				else if ( entities.Constraints.size() > 1 )
				{
					cee.errorCode = ErrorCodes.EXECUTION_UPC_AMBIGUOUS_WHICH_CONSTRAINT;
					cee.explanation = "Command is ambiguous on which constraint is to be updated (";
					rawctc = entities.Constraints.get(0);
					cee.explanation += rawctc.leftFeature + (rawctc.constraintType == Codes.REQUIRES ? " requires " : " excludes ") + rawctc.rightFeature;
					for (i=1; i<entities.Constraints.size(); i++)
					{
						rawctc = entities.Constraints.get(i);
						cee.explanation += ", " + rawctc.leftFeature + (rawctc.constraintType == Codes.REQUIRES ? " requires " : " excludes ") + rawctc.rightFeature;
					}
					cee.explanation += ")";
					return cee;
				}
				break;
				
			case Codes.COMMAND_UPDATEALL_C:
				if ( entities.Constraints == null || entities.Constraints.size() == 0 )
				{
					cee.errorCode = ErrorCodes.EXECUTION_UPALLC_CONST_DOES_NOT_EXIST;
					cee.explanation = "No constraints match the update all command";
					return cee;
				}
				break;
				
			case Codes.COMMAND_REMOVE_C:
				if ( entities.Constraints == null || entities.Constraints.size() == 0 )
				{
					cee.errorCode = ErrorCodes.EXECUTION_REMC_CONST_DOES_NOT_EXIST;
					cee.explanation = "Constraint subject to the remove command is not found in the model";
					return cee;
				}
				else if ( entities.Constraints.size() > 1 )
				{
					cee.errorCode = ErrorCodes.EXECUTION_REMC_AMBIGUOUS_WHICH_CONSTRAINT;
					cee.explanation = "Command is ambiguous on which constraint is to be removed (";
					rawctc = entities.Constraints.get(0);
					cee.explanation += rawctc.leftFeature + (rawctc.constraintType == Codes.REQUIRES ? " requires " : " excludes ") + rawctc.rightFeature;
					for (i=1; i<entities.Constraints.size(); i++)
					{
						rawctc = entities.Constraints.get(i);
						cee.explanation += ", " + rawctc.leftFeature + (rawctc.constraintType == Codes.REQUIRES ? " requires " : " excludes ") + rawctc.rightFeature;
					}
					cee.explanation += ")";
					return cee;
				}
				break;
				
			case Codes.COMMAND_REMOVEALL_C:
				if ( entities.Constraints == null || entities.Constraints.size() == 0 )
				{
					cee.errorCode = ErrorCodes.EXECUTION_REMALLC_CONST_DOES_NOT_EXIST;
					cee.explanation = "No constraints match the remove all command";
					return cee;
				}
				break;
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}
	
	
	private static CommandExecutionError executeAddAFeatureCommand(FeatureModel fm, AddAFeatureCmd addf, ArrayList<Feature> featureList)
	{
		int i, j, result;
		Feature feat;
		Attribute attr, attr2;
		OtherAttribute oa;
		ASTNode expResult;
		CommandExecutionError cee = new CommandExecutionError();
		
		RawFeature rawF = new RawFeature();
		rawF._name = addf.featureName;
		rawF._parent = addf.settingLoc.featureName;
		
		if ( addf.settingDecomp.newDecompType == Codes.MANDATORY || addf.settingDecomp.newDecompType == Codes.OPTIONAL )
		{
			rawF._decomp = addf.settingDecomp.newDecompType;
		}
		else if ( addf.settingDecomp.newDecompType == Codes.ALTERNATIVE || addf.settingDecomp.newDecompType == Codes.OR )
		{
			rawF._decomp = addf.settingDecomp.newDecompType;
			rawF.relSibling = addf.settingDecomp.firstFeatureName;
		}
		else // means to be resolved
		{
			feat = findFeature(addf.settingDecomp.firstFeatureName, featureList);
			if ( feat == null ) // normally should not happen
			{
				cee.errorCode = ErrorCodes.EXECUTION_UNKNOWN;
				cee.explanation = "Add a Feature (Dec Rel - " + addf.settingDecomp.firstFeatureName + " - not found)";
				return cee;
			}
			
			rawF._decomp = feat._decomp;
			if ( rawF._decomp == Codes.ALTERNATIVE || rawF._decomp == Codes.OR )
			{
				rawF.relSibling = addf.settingDecomp.secondFeatureName;
			}
		}
		rawF.attributes = new ArrayList<Attribute>();
		for (i=0; i<addf.otherAttrs.size(); i++)
		{
			oa = addf.otherAttrs.get(i);
			
			attr = new Attribute();
			attr.name = oa.name;
			
			expResult = null;
			switch ( oa.type )
			{
				case Codes.ATTRVAL_ARITHEXP:
					expResult = evaluateExpression(oa.arithExp, featureList);
					if ( expResult.type == Codes.AST_TYPE_INT )
					{
						attr.type = Codes.TYPE_INT;
						attr.intval = expResult.intval;
					}
					else
					{
						attr.type = Codes.TYPE_REAL;
						attr.realval = expResult.realval;
					}
					break;
					
				case Codes.ATTRVAL_BOOLEXP:
					expResult = evaluateExpression(oa.boolExp, featureList);
					attr.type = Codes.TYPE_BOOL;
					attr.boolval = expResult.boolval;
					break;
					
				case Codes.ATTRVAL_INHERITED:
					feat = null;
					for (j=0; j<featureList.size(); j++)
					{
						feat = featureList.get(j);
						if ( oa.featDesc.featureName.equalsIgnoreCase(feat._name) )
						{
							break;
						}
					}
					attr2 = null;
					for (j=0; j<feat.attributes.size(); j++)
					{
						attr2 = feat.attributes.get(j);
						if ( oa.featAttrName.equals(attr2.name) )
						{
							break;
						}
					}
					attr.type = attr2.type;
					switch ( attr2.type )
					{
						case Codes.TYPE_INT   : attr.intval    = attr2.intval;    break;
						case Codes.TYPE_REAL  : attr.realval   = attr2.realval;   break;
						case Codes.TYPE_BOOL  : attr.boolval   = attr2.boolval;   break;
						case Codes.TYPE_STRING: attr.stringval = attr2.stringval; break;
					}
					break;
					
				case Codes.ATTRVAL_STRING:
					attr.type = Codes.TYPE_STRING;
					attr.stringval = oa.stringval;
					break;
			}
			
			rawF.attributes.add(attr);
		}
		
		result = fm.addAFeature(rawF);
		if ( result != ErrorCodes.NO_ERROR )
		{
			switch ( result )
			{
				case ErrorCodes.ROOT_NOT_SET:
					cee.errorCode = ErrorCodes.EXECUTION_ROOT_NOT_SET;
					cee.explanation = "Empty feature model";
					return cee;
				
				case ErrorCodes.MISSING_INFO_IN_RAW_FEATURE:
					cee.errorCode = ErrorCodes.EXECUTION_ADDF_MISSING_INFO;
					cee.explanation = "Missing info in feature addition";
					return cee;
					
				case ErrorCodes.NEW_ROOT_CANNOT_BE_ADDED:
					cee.errorCode = ErrorCodes.EXECUTION_ADDF_NEW_ROOT_CANNOT_BE_ADDED;
					cee.explanation = "Another root feature cannot be added";
					return cee;
					
				case ErrorCodes.FEATURE_NAME_IN_USE:
					cee.errorCode = ErrorCodes.EXECUTION_ADDF_FEATURE_NAME_IN_USE;
					cee.explanation = "Feature name \"" + addf.featureName + "\" is in use";
					return cee;
					
				case ErrorCodes.PARENT_NOT_FOUND:
					cee.errorCode = ErrorCodes.EXECUTION_ADDF_PARENT_DOES_NOT_EXIST;
					cee.explanation = "The specified parent (i.e., \"" + addf.settingLoc.featureName + "\") does not exist";
					return cee;
					
				case ErrorCodes.SIBLING_NOT_FOUND:
					cee.errorCode = ErrorCodes.EXECUTION_ADDF_RELSIBLING_DOES_NOT_EXIST;
					cee.explanation = "The specified relational sibling (i.e., \"" + rawF.relSibling + "\") does not exist";
					return cee;
					
				case ErrorCodes.SIBLING_NOT_A_SIBLING:
					cee.errorCode = ErrorCodes.EXECUTION_ADDF_RELSIBLING_NOT_SIBLING;
					cee.explanation = "The specified relational sibling (i.e., \"" + rawF.relSibling + "\") cannot be a sibling feature";
					return cee;
					
				case ErrorCodes.INCONSISTENT_DECOMP_TYPE:
					cee.errorCode = ErrorCodes.EXECUTION_ADDF_INCONSISTENT_DECOMP_TYPE;
					cee.explanation = "Decomposition relation type of the feature specified as relational sibling is not consistent with the decomposition type of the feature";
					return cee;
			}
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}
	
	private static CommandExecutionError executeUpdateAFeatureCommand(FeatureModel fm, UpdateAFeatureCmd upf, ArrayList<Feature> featureList, String featureName)
	{
		int i, j;
		UpdateFeatureError result;
		String newName, newParent, newRelSibling;
		int newDecompType;
		Feature feat;
		ArrayList<Attribute> newAttrValues;
		OtherAttribute oa;
		Attribute attr, attr2;
		ASTNode expResult;
		CommandExecutionError cee = new CommandExecutionError();
		
		newName = upf.settingName;
		
		newParent = null;
		if ( upf.settingLoc != null )
		{
			newParent = upf.settingLoc.featureName;
		}
		
		newDecompType = Codes._NO_VALUE_;
		newRelSibling = null;
		if ( upf.settingDecomp != null )
		{
			newDecompType = upf.settingDecomp.newDecompType;
			if ( newDecompType == Codes.MANDATORY || newDecompType == Codes.OPTIONAL )
			{
				// do nothing
			}
			else if ( newDecompType == Codes.ALTERNATIVE || newDecompType == Codes.OR )
			{
				newRelSibling = upf.settingDecomp.firstFeatureName;
			}
			else // means to be resolved
			{
				feat = findFeature(upf.settingDecomp.firstFeatureName, featureList);
				if ( feat == null )
				{
					cee.errorCode = ErrorCodes.EXECUTION_UPF_NEW_DEC_SPEC_FEAT_NOT_FOUND;
					cee.explanation = "Feature \"" + upf.settingDecomp.firstFeatureName + "\" does not exist";
					return cee;
				}
				
				newDecompType = feat._decomp;
				if ( newDecompType == Codes.ALTERNATIVE || newDecompType == Codes.OR )
				{
					newRelSibling = upf.settingDecomp.secondFeatureName;
				}
			}
		}
		
		newAttrValues = new ArrayList<Attribute>();
		for (i=0; i<upf.settingAttrs.size(); i++)
		{
			oa = upf.settingAttrs.get(i);
			
			attr = new Attribute();
			attr.name = oa.name;
			
			expResult = null;
			switch ( oa.type )
			{
				case Codes.ATTRVAL_ARITHEXP:
					expResult = evaluateExpression(oa.arithExp, featureList);
					if ( expResult.type == Codes.AST_TYPE_INT )
					{
						attr.type = Codes.TYPE_INT;
						attr.intval = expResult.intval;
					}
					else
					{
						attr.type = Codes.TYPE_REAL;
						attr.realval = expResult.realval;
					}
					break;
					
				case Codes.ATTRVAL_BOOLEXP:
					expResult = evaluateExpression(oa.boolExp, featureList);
					attr.type = Codes.TYPE_BOOL;
					attr.boolval = expResult.boolval;
					break;
					
				case Codes.ATTRVAL_INHERITED:
					feat = null;
					for (j=0; j<featureList.size(); j++)
					{
						feat = featureList.get(j);
						if ( oa.featDesc.featureName.equalsIgnoreCase(feat._name) )
						{
							break;
						}
					}
					attr2 = null;
					for (j=0; j<feat.attributes.size(); j++)
					{
						attr2 = feat.attributes.get(j);
						if ( oa.featAttrName.equals(attr2.name) )
						{
							break;
						}
					}
					attr.type = attr2.type;
					switch ( attr2.type )
					{
						case Codes.TYPE_INT   : attr.intval    = attr2.intval;    break;
						case Codes.TYPE_REAL  : attr.realval   = attr2.realval;   break;
						case Codes.TYPE_BOOL  : attr.boolval   = attr2.boolval;   break;
						case Codes.TYPE_STRING: attr.stringval = attr2.stringval; break;
					}
					break;
					
				case Codes.ATTRVAL_STRING:
					attr.type = Codes.TYPE_STRING;
					attr.stringval = oa.stringval;
					break;
			}
			
			newAttrValues.add(attr);
		}
		
		result = fm.updateAFeature(featureName, newName, newDecompType, newRelSibling, newParent, newAttrValues);
		if ( result.errorCode != ErrorCodes.NO_ERROR )
		{
			switch ( result.errorCode )
			{
				case ErrorCodes.ROOT_NOT_SET:
					cee.errorCode = ErrorCodes.EXECUTION_ROOT_NOT_SET;
					cee.explanation = "Empty feature model";
					return cee;
				
				case ErrorCodes.FEATURE_NOT_FOUND:
					cee.errorCode = ErrorCodes.EXECUTION_UPF_FEATURE_DOES_NOT_EXIST;
					cee.explanation = "Feature \"" + featureName + "\" does not exist";
					return cee;
					
				case ErrorCodes.FEATURE_NAME_IN_USE:
					cee.errorCode = ErrorCodes.EXECUTION_UPF_NEW_NAME_IN_USE;
					cee.explanation = "New feature name \"" + newName + "\" is in use";
					return cee;
					
				case ErrorCodes.DECOMP_TYPE_OF_ROOT_CANNOT_BE_UPDATED:
					cee.errorCode = ErrorCodes.EXECUTION_UPF_DECOMP_ROOT_NO;
					cee.explanation = "Decomposition relation type of the root feature cannot be updated";
					return cee;
					
				case ErrorCodes.SIBLING_NOT_FOUND:
					cee.errorCode = ErrorCodes.EXECUTION_UPF_RELSIBLING_DOES_NOT_EXIST;
					cee.explanation = "Feature specified as the relational sibling (i.e., \"" + newRelSibling + "\") does not exist";
					return cee;
					
				case ErrorCodes.SIBLING_NOT_A_SIBLING:
					cee.errorCode = ErrorCodes.EXECUTION_UPF_RELSIBLING_NOT_SIBLING;
					cee.explanation = "Feature specified as the relational sibling (i.e., \"" + newRelSibling + "\") is not a sibling";
					return cee;
					
				case ErrorCodes.INCONSISTENT_DECOMP_TYPE:
					cee.errorCode = ErrorCodes.EXECUTION_UPF_INCONSISTENT_DECOMP_TYPE;
					cee.explanation = "Decomposition relation type of the feature specified as relational sibling is not consistent with the decomposition type of the feature";
					return cee;
					
				case ErrorCodes.LOCATION_OF_ROOT_CANNOT_BE_UPDATED:
				case ErrorCodes.OLD_PARENT_NOT_FOUND:
					cee.errorCode = ErrorCodes.EXECUTION_UPF_ROOT_CANNOT_BE_MOVED;
					cee.explanation = "Root feature cannot be moved";
					return cee;
					
				case ErrorCodes.DECOMP_REL_MUST_ALSO_BE_UPDATED:
					cee.errorCode = ErrorCodes.EXECUTION_UPF_DECOMP_REL_MUST_BE_UPDATED;
					cee.explanation = "Decomposition relation type of the feature must also be updated for model integrity";
					return cee;
					
				case ErrorCodes.PARENT_CANNOT_BE_A_DESCENDANT:
					cee.errorCode = ErrorCodes.EXECUTION_UPF_UPDATE_CAUSES_CYCLE;
					cee.explanation = "Update cannot cause a cycle in the feature hierarchy";
					return cee;
					
				case ErrorCodes.NEW_PARENT_NOT_FOUND:
					cee.errorCode = ErrorCodes.EXECUTION_UPF_NEW_PARENT_NOT_FOUND;
					cee.explanation = "The new parent (i.e., \"" + newParent + "\") does not exist";
					return cee;
					
				case ErrorCodes.ATTRIBUTE_NOT_FOUND:
					cee.errorCode = ErrorCodes.EXECUTION_UPF_ATTRIBUTE_NOT_FOUND;
					cee.explanation = "The updated attribute (i.e., \"" + result.erronousAttribute + "\") does not exist";
					return cee;
			}
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}

	private static CommandExecutionError executeUpdateMultipleFeaturesCommand(FeatureModel fm, UpdateMultipleFeaturesCmd upallf, ArrayList<Feature> featureList, ArrayList<String> featureNames)
	{
		int i, j;
		UpdateFeatureError[] results;
		ArrayList<Integer> failedEntities;
		ArrayList<Integer> failedForAttributes;
		String newParent, newRelSibling;
		int newDecompType;
		Feature feat;
		ArrayList<Attribute> newAttrValues;
		OtherAttribute oa;
		Attribute attr, attr2;
		ASTNode expResult;
		CommandExecutionError cee = new CommandExecutionError();
		
		newParent = null;
		if ( upallf.settingLoc != null )
		{
			newParent = upallf.settingLoc.featureName;
		}
		
		newDecompType = Codes._NO_VALUE_;
		newRelSibling = null;
		if ( upallf.settingDecomp != null )
		{
			newDecompType = upallf.settingDecomp.newDecompType;
			if ( newDecompType == Codes.MANDATORY || newDecompType == Codes.OPTIONAL )
			{
				// do nothing
			}
			else if ( newDecompType == Codes.ALTERNATIVE || newDecompType == Codes.OR )
			{
				newRelSibling = upallf.settingDecomp.firstFeatureName;
			}
			else // means to be resolved
			{
				feat = findFeature(upallf.settingDecomp.firstFeatureName, featureList);
				if ( feat == null ) // normally should not happen
				{
					cee.errorCode = ErrorCodes.EXECUTION_UNKNOWN;
					cee.explanation = "Update Multiple Features (New Dec Rel - " + upallf.settingDecomp.firstFeatureName + " - not found)";
					return cee;
				}
				
				newDecompType = feat._decomp;
				if ( newDecompType == Codes.ALTERNATIVE || newDecompType == Codes.OR )
				{
					newRelSibling = upallf.settingDecomp.secondFeatureName;
				}
			}
		}
		
		newAttrValues = new ArrayList<Attribute>();
		for (i=0; i<upallf.settingAttrs.size(); i++)
		{
			oa = upallf.settingAttrs.get(i);
			
			attr = new Attribute();
			attr.name = oa.name;
			
			expResult = null;
			switch ( oa.type )
			{
				case Codes.ATTRVAL_ARITHEXP:
					expResult = evaluateExpression(oa.arithExp, featureList);
					if ( expResult.type == Codes.AST_TYPE_INT )
					{
						attr.type = Codes.TYPE_INT;
						attr.intval = expResult.intval;
					}
					else
					{
						attr.type = Codes.TYPE_REAL;
						attr.realval = expResult.realval;
					}
					break;
					
				case Codes.ATTRVAL_BOOLEXP:
					expResult = evaluateExpression(oa.boolExp, featureList);
					attr.type = Codes.TYPE_BOOL;
					attr.boolval = expResult.boolval;
					break;
					
				case Codes.ATTRVAL_INHERITED:
					feat = null;
					for (j=0; j<featureList.size(); j++)
					{
						feat = featureList.get(j);
						if ( oa.featDesc.featureName.equalsIgnoreCase(feat._name) )
						{
							break;
						}
					}
					attr2 = null;
					for (j=0; j<feat.attributes.size(); j++)
					{
						attr2 = feat.attributes.get(j);
						if ( oa.featAttrName.equals(attr2.name) )
						{
							break;
						}
					}
					attr.type = attr2.type;
					switch ( attr2.type )
					{
						case Codes.TYPE_INT   : attr.intval    = attr2.intval;    break;
						case Codes.TYPE_REAL  : attr.realval   = attr2.realval;   break;
						case Codes.TYPE_BOOL  : attr.boolval   = attr2.boolval;   break;
						case Codes.TYPE_STRING: attr.stringval = attr2.stringval; break;
					}
					break;
					
				case Codes.ATTRVAL_STRING:
					attr.type = Codes.TYPE_STRING;
					attr.stringval = oa.stringval;
					break;
			}
			
			newAttrValues.add(attr);
		}
		
		results = fm.updateMultipleFeatures(featureNames, newDecompType, newRelSibling, newParent, newAttrValues);
		failedEntities      = new ArrayList<Integer>();
		failedForAttributes = new ArrayList<Integer>();
		for (i=0; i<results.length; i++)
		{
			if ( results[i].errorCode != ErrorCodes.NO_ERROR )
			{
				switch ( results[i].errorCode )
				{
					case ErrorCodes.ROOT_NOT_SET:
						cee.errorCode = ErrorCodes.EXECUTION_ROOT_NOT_SET;
						cee.explanation = "Empty feature model";
						return cee;
					
					case ErrorCodes.FEATURE_NOT_FOUND:
						failedEntities.add(i);
						break;
						
					case ErrorCodes.ATTRIBUTE_NOT_FOUND:
						failedForAttributes.add(i);
						break;
						
					case ErrorCodes.DECOMP_TYPE_OF_ROOT_CANNOT_BE_UPDATED:
						cee.errorCode = ErrorCodes.EXECUTION_UPALLF_DECOMP_ROOT_NO;
						cee.explanation = "Decomposition relation type of the root feature cannot be updated";
						return cee;
						
					case ErrorCodes.SIBLING_NOT_FOUND:
						cee.errorCode = ErrorCodes.EXECUTION_UPALLF_RELSIBLING_DOES_NOT_EXIST;
						cee.explanation = "Feature specified as the relational sibling (i.e., \"" + newRelSibling + "\") does not exist";
						return cee;
						
					case ErrorCodes.SIBLING_NOT_A_SIBLING:
						cee.errorCode = ErrorCodes.EXECUTION_UPALLF_RELSIBLING_NOT_SIBLING;
						cee.explanation = "Feature specified as the relational sibling (i.e., \"" + newRelSibling + "\") is not a sibling";
						return cee;
						
					case ErrorCodes.INCONSISTENT_DECOMP_TYPE:
						cee.errorCode = ErrorCodes.EXECUTION_UPALLF_INCONSISTENT_DECOMP_TYPE;
						cee.explanation = "Decomposition relation type of the feature specified as relational sibling is not consistent with the decomposition type of the feature";
						return cee;
						
					case ErrorCodes.LOCATION_OF_ROOT_CANNOT_BE_UPDATED:
					case ErrorCodes.OLD_PARENT_NOT_FOUND:
						cee.errorCode = ErrorCodes.EXECUTION_UPALLF_ROOT_CANNOT_BE_MOVED;
						cee.explanation = "Root feature cannot be moved";
						return cee;
						
					case ErrorCodes.DECOMP_REL_MUST_ALSO_BE_UPDATED:
						cee.errorCode = ErrorCodes.EXECUTION_UPALLF_DECOMP_REL_MUST_BE_UPDATED;
						cee.explanation = "Decomposition relation type of the feature must also be updated for model integrity";
						return cee;
						
					case ErrorCodes.PARENT_CANNOT_BE_A_DESCENDANT:
						cee.errorCode = ErrorCodes.EXECUTION_UPALLF_UPDATE_CAUSES_CYCLE;
						cee.explanation = "Update cannot cause a cycle in the feature hierarchy";
						return cee;
						
					case ErrorCodes.NEW_PARENT_NOT_FOUND:
						cee.errorCode = ErrorCodes.EXECUTION_UPALLF_NEW_PARENT_NOT_FOUND;
						cee.explanation = "The new parent (i.e., \"" + newParent + "\") does not exist";
						return cee;
				}
			}
		}
		if ( failedEntities.size() > 0 )
		{
			cee.errorCode = ErrorCodes.EXECUTION_UPALLF_FEATURE_DOES_NOT_EXIST;
			cee.explanation = "Following Feature(s) do not exist: ";
			for (i=0; i<failedEntities.size(); i++)
			{
				if ( i > 0 )
				{
					cee.explanation += ", ";
				}
				cee.explanation += "\"" + featureNames.get(failedEntities.get(i)) + "\"";
			}
			return cee;
		}
		else if ( failedForAttributes.size() > 0 )
		{
			cee.errorCode = ErrorCodes.EXECUTION_UPALLF_ATTRIBUTE_NOT_FOUND;
			cee.explanation = "Following Feature(s) do not have the following updated attributes: ";
			for (i=0; i<failedForAttributes.size(); i++)
			{
				if ( i > 0 )
				{
					cee.explanation += ", ";
				}
				cee.explanation += "\"" + featureNames.get(failedEntities.get(i)) + "\"." + results[failedEntities.get(i)].erronousAttribute;
			}
			return cee;
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}
	
	private static CommandExecutionError executeRemoveAFeatureCommand(FeatureModel fm, String featureName)
	{
		int result;
		CommandExecutionError cee = new CommandExecutionError();
		
		result = fm.removeAFeature(featureName);
		if ( result != ErrorCodes.NO_ERROR )
		{
			switch ( result )
			{
				case ErrorCodes.ROOT_NOT_SET:
					cee.errorCode = ErrorCodes.EXECUTION_ROOT_NOT_SET;
					cee.explanation = "Empty feature model";
					return cee;
					
				case ErrorCodes.FEATURE_NOT_FOUND:
					cee.errorCode = ErrorCodes.EXECUTION_REMF_FEATURE_DOES_NOT_EXIST;
					cee.explanation = "Feature \"" + featureName + "\" does not exist";
					return cee;
					
				case ErrorCodes.ROOT_CANNOT_BE_REMOVED:
					cee.errorCode = ErrorCodes.EXECUTION_REMF_ROOT_CANNOT_BE_REMOVED;
					cee.explanation = "Root feature cannot be removed from the model";
					return cee;
					
				case ErrorCodes.PARENT_NOT_FOUND:
					cee.errorCode = ErrorCodes.EXECUTION_REMF_PARENT_NOT_FOUND;
					cee.explanation = "Remove a Feature (Parent not found)";
					return cee;
			}
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}
	
	private static CommandExecutionError executeRemoveMultipleFeaturesCommand(FeatureModel fm, ArrayList<String> featureNames)
	{
		int i;
		int[] results;
		ArrayList<Integer> failedEntities;
		CommandExecutionError cee = new CommandExecutionError();
		
		results = fm.removeMultipleFeatures(featureNames);
		failedEntities = new ArrayList<Integer>();
		for (i=0; i<results.length; i++)
		{
			if ( results[i] != ErrorCodes.NO_ERROR )
			{
				switch ( results[i] )
				{
					case ErrorCodes.ROOT_NOT_SET:
						cee.errorCode = ErrorCodes.EXECUTION_ROOT_NOT_SET;
						cee.explanation = "Empty feature model";
						return cee;
					
					case ErrorCodes.FEATURE_NOT_FOUND:
						failedEntities.add(i);
						break;
						
					case ErrorCodes.ROOT_CANNOT_BE_REMOVED:
						cee.errorCode = ErrorCodes.EXECUTION_REMALLF_ROOT_CANNOT_BE_REMOVED;
						cee.explanation = "Root feature cannot be removed from the model";
						return cee;
						
					case ErrorCodes.PARENT_NOT_FOUND:
						cee.errorCode = ErrorCodes.EXECUTION_REMALLF_PARENT_NOT_FOUND;
						cee.explanation = "Remove Multiple Features (Parent not found)";
						return cee;
				}
			}
		}
		if ( failedEntities.size() > 0 )
		{
			cee.errorCode = ErrorCodes.EXECUTION_REMALLF_FEATURE_DOES_NOT_EXIST;
			cee.explanation = "Following Feature(s) do not exist: ";
			for (i=0; i<failedEntities.size(); i++)
			{
				if ( i > 0 )
				{
					cee.explanation += ", ";
				}
				cee.explanation += "\"" + featureNames.get(failedEntities.get(i)) + "\"";
			}
			return cee;
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}
	
	private static CommandExecutionError executeAddAConstraintCommand(FeatureModel fm, ArrayList<RawCrossTreeConstraint> constraints)
	{
		int i, result;
		ArrayList<Integer> failedEntities;
		RawCrossTreeConstraint rawCtc;
		CommandExecutionError cee = new CommandExecutionError();
		
		failedEntities = new ArrayList<Integer>();
		for (i=0; i<constraints.size(); i++)
		{
			rawCtc = constraints.get(i);
			result = fm.addAConstraint(rawCtc);
			if ( result != ErrorCodes.NO_ERROR )
			{
				switch ( result )
				{
					case ErrorCodes.ROOT_NOT_SET:
						cee.errorCode = ErrorCodes.EXECUTION_ROOT_NOT_SET;
						cee.explanation = "Empty feature model";
						return cee;
					
					case ErrorCodes.LEFT_FEATURE_NOT_FOUND:
						cee.errorCode = ErrorCodes.EXECUTION_ADDC_LEFT_NOT_FOUND;
						cee.explanation = "The feature \"" + rawCtc.leftFeature + "\" does not exist in the feature model";
						return cee;
						
					case ErrorCodes.INVALID_CONSTRAINT_TYPE:
						cee.errorCode = ErrorCodes.EXECUTION_ADDC_INVALID_CONSTRAINT;
						cee.explanation = "Invalid constraint type";
						return cee;
						
					case ErrorCodes.RIGHT_FEATURE_NOT_FOUND:
						cee.errorCode = ErrorCodes.EXECUTION_ADDC_RIGHT_NOT_FOUND;
						cee.explanation = "The feature \"" + rawCtc.rightFeature + "\" does not exist in the feature model";
						return cee;
						
					case ErrorCodes.CONSTRAINT_ALREADY_EXISTS:
						failedEntities.add(i);
						break;
				}
			}
		}
		if ( failedEntities.size() > 0 )
		{
			cee.errorCode = ErrorCodes.EXECUTION_ADDC_ALREADY_EXISTS;
			cee.explanation = "Following Cross-tree Constraint(s) already exist:";
			for (i=0; i<failedEntities.size(); i++)
			{
				rawCtc = constraints.get(failedEntities.get(i));
				cee.explanation += " (" + rawCtc.leftFeature + (rawCtc.constraintType == Codes.REQUIRES ? " requires " : " excludes ") + rawCtc.rightFeature + ")";
			}
			return cee;
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}
	
	private static CommandExecutionError executeUpdateAConstraintCommand(FeatureModel fm, UpdateAConstraintCmd upc, RawCrossTreeConstraint rawCtc)
	{
		int result;
		String newLeft, newRight;
		int newConstraintType;
		CommandExecutionError cee = new CommandExecutionError();
		
		newLeft           = upc.leftUpdate != null ? upc.leftUpdate.featureName : null;
		newConstraintType = upc.typeUpdate;
		newRight          = upc.rightUpdate != null ? upc.rightUpdate.featureName : null;
		result = fm.updateAConstraint(rawCtc, newLeft, newConstraintType, newRight);
		if ( result != ErrorCodes.NO_ERROR )
		{
			switch ( result )
			{
				case ErrorCodes.ROOT_NOT_SET:
					cee.errorCode = ErrorCodes.EXECUTION_ROOT_NOT_SET;
					cee.explanation = "Empty feature model";
					return cee;
				
				case ErrorCodes.INVALID_CONSTRAINT_TYPE:
					cee.errorCode = ErrorCodes.EXECUTION_UPC_INVALID_CONSTRAINT;
					cee.explanation = "Invalid constraint type";
					return cee;
				
				case ErrorCodes.CONSTRAINT_DOES_NOT_EXIST:
					cee.errorCode = ErrorCodes.EXECUTION_UPC_CONSTRAINT_DOES_NOT_EXIST;
					cee.explanation = "Cross-tree Constraint \"" + rawCtc.leftFeature + (rawCtc.constraintType == Codes.REQUIRES ? " requires " : " excludes ") + rawCtc.rightFeature + "\" does not exist";
					return cee;
					
				case ErrorCodes.LEFT_FEATURE_NOT_FOUND:
					cee.errorCode = ErrorCodes.EXECUTION_UPC_LEFT_NOT_FOUND;
					cee.explanation = "The feature \"" + newLeft + "\" does not exist in the feature model";
					return cee;
					
				case ErrorCodes.RIGHT_FEATURE_NOT_FOUND:
					cee.errorCode = ErrorCodes.EXECUTION_UPC_RIGHT_NOT_FOUND;
					cee.explanation = "The feature \"" + newRight + "\" does not exist in the feature model";
					return cee;
			}
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}
	
	private static CommandExecutionError executeUpdateMultipleConstraintsCommand(FeatureModel fm, UpdateMultipleConstraintsCmd upallc, ArrayList<RawCrossTreeConstraint> constraints)
	{
		int i;
		int[] results;
		ArrayList<Integer> failedEntities;
		RawCrossTreeConstraint rawCtc;
		String newLeft, newRight;
		int newConstraintType;
		CommandExecutionError cee = new CommandExecutionError();
		
		newLeft           = upallc.leftUpdate != null ? upallc.leftUpdate.featureName : null;
		newConstraintType = upallc.typeUpdate;
		newRight          = upallc.rightUpdate != null ? upallc.rightUpdate.featureName : null;
		results = fm.updateMultipleConstraints(constraints, newLeft, newConstraintType, newRight);
		failedEntities = new ArrayList<Integer>();
		for (i=0; i<results.length; i++)
		{
			if ( results[i] != ErrorCodes.NO_ERROR )
			{
				rawCtc = constraints.get(i);
				switch ( results[i] )
				{
					case ErrorCodes.ROOT_NOT_SET:
						cee.errorCode = ErrorCodes.EXECUTION_ROOT_NOT_SET;
						cee.explanation = "Empty feature model";
						return cee;
						
					case ErrorCodes.INVALID_CONSTRAINT_TYPE:
						cee.errorCode = ErrorCodes.EXECUTION_UPALLC_INVALID_CONSTRAINT;
						cee.explanation = "Invalid constraint type";
						return cee;
					
					case ErrorCodes.CONSTRAINT_DOES_NOT_EXIST:
						failedEntities.add(i);
						break;
						
					case ErrorCodes.LEFT_FEATURE_NOT_FOUND:
						cee.errorCode = ErrorCodes.EXECUTION_UPALLC_LEFT_NOT_FOUND;
						cee.explanation = "The feature \"" + newLeft + "\" does not exist in the feature model";
						return cee;
						
					case ErrorCodes.RIGHT_FEATURE_NOT_FOUND:
						cee.errorCode = ErrorCodes.EXECUTION_UPALLC_RIGHT_NOT_FOUND;
						cee.explanation = "The feature \"" + newRight + "\" does not exist in the feature model";
						return cee;
				}
			}
		}
		if ( failedEntities.size() > 0 )
		{
			cee.errorCode = ErrorCodes.EXECUTION_UPALLC_CONST_DOES_NOT_EXIST;
			cee.explanation = "Following Cross-tree Constraint(s) do not exist:";
			for (i=0; i<failedEntities.size(); i++)
			{
				rawCtc = constraints.get(failedEntities.get(i));
				cee.explanation += " (" + rawCtc.leftFeature + (rawCtc.constraintType == Codes.REQUIRES ? " requires " : " excludes ") + rawCtc.rightFeature + ")";
			}
			return cee;
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}
	
	private static CommandExecutionError executeRemoveAConstraintCommand(FeatureModel fm, RawCrossTreeConstraint rawCtc)
	{
		int result;
		CommandExecutionError cee = new CommandExecutionError();
		
		result = fm.removeAConstraint(rawCtc);
		if ( result != ErrorCodes.NO_ERROR )
		{
			switch ( result )
			{
				case ErrorCodes.ROOT_NOT_SET:
					cee.errorCode = ErrorCodes.EXECUTION_ROOT_NOT_SET;
					cee.explanation = "Empty feature model";
					return cee;
				
				case ErrorCodes.CONSTRAINT_DOES_NOT_EXIST:
					cee.errorCode = ErrorCodes.EXECUTION_REMC_CONST_DOES_NOT_EXIST;
					cee.explanation = "Cross-tree Constraint \"" + rawCtc.leftFeature + (rawCtc.constraintType == Codes.REQUIRES ? " requires " : " excludes ") + rawCtc.rightFeature + "\" does not exist";
					return cee;
			}
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}
	
	private static CommandExecutionError executeRemoveMultipleConstraintsCommand(FeatureModel fm, ArrayList<RawCrossTreeConstraint> constraints)
	{
		int i;
		int[] results;
		ArrayList<Integer> failedEntities;
		RawCrossTreeConstraint rawCtc;
		CommandExecutionError cee = new CommandExecutionError();
		
		results = fm.removeMultipleConstraints(constraints);
		failedEntities = new ArrayList<Integer>();
		for (i=0; i<results.length; i++)
		{
			if ( results[i] != ErrorCodes.NO_ERROR )
			{
				if ( results[i] == ErrorCodes.ROOT_NOT_SET )
				{
					cee.errorCode = ErrorCodes.EXECUTION_ROOT_NOT_SET;
					cee.explanation = "Empty feature model";
					return cee;
				}
				
				failedEntities.add(i);
			}
		}
		if ( failedEntities.size() > 0 )
		{
			cee.errorCode = ErrorCodes.EXECUTION_REMALLC_CONST_DOES_NOT_EXIST;
			cee.explanation = "Following Cross-tree Constraint(s) do not exist:";
			for (i=0; i<failedEntities.size(); i++)
			{
				rawCtc = constraints.get(failedEntities.get(i));
				cee.explanation += " (" + rawCtc.leftFeature + (rawCtc.constraintType == Codes.REQUIRES ? " requires " : " excludes ") + rawCtc.rightFeature + ")";
			}
			return cee;
		}
		
		cee.errorCode = ErrorCodes.NO_ERROR;
		return cee;
	}
	
	
	private static ArrayList<FeatureVariable> createAssumptionList(Command cmd)
	{
		int i, j, k;
		boolean found;
		ArrayList<FeatureVariable> result;
		FeatureVariable fv, fvr=null;
		VariableAttribute va;
		ArrayList<FeatureVariable> list1, list2, listWithAttrs;
		AddAFeatureCmd addf;
		UpdateAFeatureCmd updatef;
		UpdateMultipleFeaturesCmd updatemf;
		RemoveAFeatureCmd rmf;
		RemoveMultipleFeaturesCmd rmmf;
		AddAConstraintCmd addc;
		UpdateAConstraintCmd updatec;
		UpdateMultipleConstraintsCmd updatemc;
		RemoveAConstraintCmd rmc;
		RemoveMultipleConstraintsCmd rmmc;
		
		list1 = new ArrayList<FeatureVariable>();
		list2 = new ArrayList<FeatureVariable>();
		listWithAttrs = new ArrayList<FeatureVariable>();
		
		if ( cmd == null )
		{
			return new ArrayList<FeatureVariable>();
		}
		
		switch ( cmd.type )
		{
			case Codes.COMMAND_ADD_F:
				addf = (AddAFeatureCmd) cmd;
				list1 = extractFeatureVariables_locDec(addf.settingLoc, addf.settingDecomp);
				listWithAttrs = extractFeatureVariables_attrs(addf.otherAttrs);
				break;
				
			case Codes.COMMAND_UPDATE_F:
				updatef = (UpdateAFeatureCmd) cmd;
				list1 = extractFeatureVariables_feat(updatef.featDesc, null);
				list2 = extractFeatureVariables_locDec(updatef.settingLoc, updatef.settingDecomp);
				listWithAttrs = extractFeatureVariables_attrs(updatef.settingAttrs);
				break;
				
			case Codes.COMMAND_UPDATEALL_F:
				updatemf = (UpdateMultipleFeaturesCmd) cmd;
				fv = new FeatureVariable();
				fv.name = updatemf.featureVar;
				list1.add(fv);
				list2 = extractFeatureVariables_locDec(updatemf.settingLoc, updatemf.settingDecomp);
				listWithAttrs = extractFeatureVariables_attrs(updatemf.settingAttrs);
				break;
				
			case Codes.COMMAND_REMOVE_F:
				rmf = (RemoveAFeatureCmd) cmd;
				list1 = extractFeatureVariables_feat(rmf.featDesc, null);
				break;
				
			case Codes.COMMAND_REMOVEALL_F:
				rmmf = (RemoveMultipleFeaturesCmd) cmd;
				fv = new FeatureVariable();
				fv.name = rmmf.featureVar;
				list1.add(fv);
				break;
				
			case Codes.COMMAND_ADD_C:
				addc = (AddAConstraintCmd) cmd;
				list1 = extractFeatureVariables_const(addc.constDesc);
				break;
				
			case Codes.COMMAND_UPDATE_C:
				updatec = (UpdateAConstraintCmd) cmd;
				list1 = extractFeatureVariables_const(updatec.constDesc);
				list2 = extractFeatureVariables_feat(updatec.leftUpdate, updatec.rightUpdate);
				break;
				
			case Codes.COMMAND_UPDATEALL_C:
				updatemc = (UpdateMultipleConstraintsCmd) cmd;
				list1 = extractFeatureVariables_const(updatemc.constDesc);
				list2 = extractFeatureVariables_feat(updatemc.leftUpdate, updatemc.rightUpdate);
				break;
				
			case Codes.COMMAND_REMOVE_C:
				rmc = (RemoveAConstraintCmd) cmd;
				list1 = extractFeatureVariables_const(rmc.constDesc);
				break;
				
			case Codes.COMMAND_REMOVEALL_C:
				rmmc = (RemoveMultipleConstraintsCmd) cmd;
				list1 = extractFeatureVariables_const(rmmc.constDesc);
				break;
				
			default:
				return new ArrayList<FeatureVariable>();
		}
		
		result = new ArrayList<FeatureVariable>();
		
		if ( listWithAttrs.size() > 0 )
		{
			result.add(listWithAttrs.get(0));
			
			for (i=1; i<listWithAttrs.size(); i++)
			{
				fv = listWithAttrs.get(i);
				found = false;
				for (j=0; j<result.size(); j++)
				{
					fvr = result.get(j);
					if ( fv.name.equals(fvr.name) )
					{
						found = true;
						break;
					}
				}
				
				if ( !found )
				{
					result.add(fv);
				}
				else // this means the feature variable is found, check attributes
				{
					for (j=0; j<fv.otherAttributes.size(); j++)
					{
						va = fv.otherAttributes.get(j);
						found = false;
						for(k=0; k<fvr.otherAttributes.size(); k++)
						{
							if ( va.name.equals(fvr.otherAttributes.get(k).name) )
							{
								found = true;
								break;
							}
						}
						
						if ( !found )
						{
							fvr.otherAttributes.add(va);
						}
					}
				}
			}
		}
		
		for (i=0; i<list1.size(); i++)
		{
			fv = list1.get(i);
			found = false;
			for (j=0; j<result.size(); j++)
			{
				if ( fv.name.equals(result.get(j).name) )
				{
					found = true;
					break;
				}
			}
			
			if ( !found )
			{
				result.add(fv);
			}
		}
		for (i=0; i<list2.size(); i++)
		{
			fv = list2.get(i);
			found = false;
			for (j=0; j<result.size(); j++)
			{
				if ( fv.name.equals(result.get(j).name) )
				{
					found = true;
					break;
				}
			}
			
			if ( !found )
			{
				result.add(fv);
			}
		}
		
		return result;
	}

	private static ArrayList<FeatureVariable> extractFeatureVariables_locDec(SettingLocation loc, SettingDecomposition dec)
	{
		ArrayList<FeatureVariable> assumptions = new ArrayList<FeatureVariable>();
		FeatureVariable fv;
		
		if ( loc != null )
		{
			if ( loc.varUsed )
			{
				fv = new FeatureVariable();
				fv.name = loc.featureVar;
				assumptions.add(fv);
			}
		}
		
		if ( dec != null )
		{
			if ( dec.newDecompType == Codes.ALTERNATIVE || dec.newDecompType == Codes.OR || dec.newDecompType == Codes.TOBERESOLVED )
			{
				if ( dec.firstFeatDescExists && dec.firstVarUsed )
				{
					fv = new FeatureVariable();
					fv.name = dec.firstFeatureVar;
					assumptions.add(fv);
				}
			}

			if ( dec.newDecompType == Codes.TOBERESOLVED )
			{
				if ( dec.secondFeatDescExists && dec.secondVarUsed )
				{
					fv = new FeatureVariable();
					fv.name = dec.secondFeatureVar;
					assumptions.add(fv);
				}
			}
		}
		
		return assumptions;
	}
	
	private static ArrayList<FeatureVariable> extractFeatureVariables_attrs(ArrayList<OtherAttribute> attributes)
	{
		int i;
		ArrayList<FeatureVariable> assumptions = new ArrayList<FeatureVariable>();
		FeatureVariable fv;
		VariableAttribute va;
		
		if ( attributes == null )
		{
			return assumptions;
		}
		
		
		OtherAttribute oa;
		for (i=0; i<attributes.size(); i++)
		{
			oa = attributes.get(i);
			if ( oa.type == Codes.ATTRVAL_INHERITED && oa.featDesc.varUsed )
			{
				fv = new FeatureVariable();
				fv.name = oa.featDesc.featureVar;
				assumptions.add(fv);
				
				if ( oa.featAttrName.equals("_name") || oa.featAttrName.equals("_parent") || oa.featAttrName.equals("_decomp") || oa.featAttrName.equals("_decompID") )
				{
					continue;
				}
				
				va = new VariableAttribute();
				va.name = oa.featAttrName;
				va.assumedType = Codes._NO_VALUE_;
				fv.otherAttributes.add(va);
			}
		}
			
		return assumptions;
	}
	
	private static ArrayList<FeatureVariable> extractFeatureVariables_const(ConstraintDescription desc)
	{
		ArrayList<FeatureVariable> assumptions = new ArrayList<FeatureVariable>();
		FeatureVariable fv;
		
		if ( desc == null )
		{
			return assumptions;
		}
		
		if ( desc.leftIsVar )
		{
			fv = new FeatureVariable();
			fv.name = desc.leftFeatureVar;
			assumptions.add(fv);
		}
		
		if ( desc.rightIsVar )
		{
			fv = new FeatureVariable();
			fv.name = desc.rightFeatureVar;
			assumptions.add(fv);
		}
			
		return assumptions;
	}
	
	private static ArrayList<FeatureVariable> extractFeatureVariables_feat(FeatureDescription desc1, FeatureDescription desc2)
	{
		ArrayList<FeatureVariable> assumptions = new ArrayList<FeatureVariable>();
		FeatureVariable fv;
		
		if ( desc1 != null )
		{
			if ( desc1.varUsed )
			{
				fv = new FeatureVariable();
				fv.name = desc1.featureVar;
				assumptions.add(fv);
			}
		}
		
		if ( desc2 != null )
		{
			if ( desc2.varUsed )
			{
				fv = new FeatureVariable();
				fv.name = desc2.featureVar;
				assumptions.add(fv);
			}
		}
			
		return assumptions;
	}
	
	
	private static ArrayList<ASTNode> createTypeCheckExpressionFromACommandWithAttributeAssignments(Command cmd)
	{
		int i, j;
		boolean addAnd;
		ArrayList<OtherAttribute> attrAssignments;
		ASTNode node;
		OtherAttribute oa;
		
		addAnd = false;
		ArrayList<ASTNode> combined = new ArrayList<ASTNode>();
		for (i=0; i<cmd.whereClause.size(); i++)
		{
			combined.add(cmd.whereClause.get(i));
			addAnd = true;
		}
		
		if ( cmd.type == Codes.COMMAND_ADD_F )
		{
			attrAssignments = ((AddAFeatureCmd) cmd).otherAttrs;
		}
		else if ( cmd.type == Codes.COMMAND_UPDATE_F )
		{
			attrAssignments = ((UpdateAFeatureCmd) cmd).settingAttrs;
		}
		else if ( cmd.type == Codes.COMMAND_UPDATEALL_F )
		{
			attrAssignments = ((UpdateMultipleFeaturesCmd) cmd).settingAttrs;
		}
		else
		{
			attrAssignments = new ArrayList<OtherAttribute>();
		}
		
		for (i=0; i<attrAssignments.size(); i++)
		{
			oa = attrAssignments.get(i);
			
			switch ( oa.type )
			{
				case Codes.ATTRVAL_ARITHEXP:
					for (j=0; j<oa.arithExp.size(); j++)
					{
						combined.add(oa.arithExp.get(j));
					}
					node = new ASTNode();
					node.type = Codes.AST_TYPE_INT;
					node.intval = 0;
					combined.add(node);
					node = new ASTNode();
					node.type = Codes.AST_TYPE_OPERATOR;
					node.opcode = Codes.OP_GT;
					combined.add(node);
					if ( addAnd )
					{
						node = new ASTNode();
						node.type = Codes.AST_TYPE_OPERATOR;
						node.opcode = Codes.OP_AND;
						combined.add(node);
					}
					else
					{
						addAnd = true;
					}
					break;
					
				case Codes.ATTRVAL_BOOLEXP:
					for (j=0; j<oa.boolExp.size(); j++)
					{
						combined.add(oa.boolExp.get(j));
					}
					if ( addAnd )
					{
						node = new ASTNode();
						node.type = Codes.AST_TYPE_OPERATOR;
						node.opcode = Codes.OP_AND;
						combined.add(node);
					}
					else
					{
						addAnd = true;
					}
					break;
			}
		}
		
		return combined;
	}
	

	private static ArrayList<Integer> createCTCEliminationCriteriaList(Command cmd)
	{
		ArrayList<Integer> ctcEliminations;
		UpdateAConstraintCmd updatec;
		UpdateMultipleConstraintsCmd updatemc;
		RemoveAConstraintCmd rmc;
		RemoveMultipleConstraintsCmd rmmc;
		
		switch ( cmd.type )
		{
			case Codes.COMMAND_ADD_F:
			case Codes.COMMAND_UPDATE_F:
			case Codes.COMMAND_UPDATEALL_F:
			case Codes.COMMAND_REMOVE_F:
			case Codes.COMMAND_REMOVEALL_F:
				ctcEliminations = new ArrayList<Integer>();
				break;
				
			case Codes.COMMAND_ADD_C:
				ctcEliminations = new ArrayList<Integer>();
				break;
				
			case Codes.COMMAND_UPDATE_C:
				updatec = (UpdateAConstraintCmd) cmd;
				ctcEliminations = extractCTCEliminationCriteria(updatec.constDesc);
				break;
				
			case Codes.COMMAND_UPDATEALL_C:
				updatemc = (UpdateMultipleConstraintsCmd) cmd;
				ctcEliminations = extractCTCEliminationCriteria(updatemc.constDesc);
				break;
				
			case Codes.COMMAND_REMOVE_C:
				rmc = (RemoveAConstraintCmd) cmd;
				ctcEliminations = extractCTCEliminationCriteria(rmc.constDesc);
				break;
				
			case Codes.COMMAND_REMOVEALL_C:
				rmmc = (RemoveMultipleConstraintsCmd) cmd;
				ctcEliminations = extractCTCEliminationCriteria(rmmc.constDesc);
				break;
				
			default:
				return new ArrayList<Integer>();
		}
		
		return ctcEliminations;
	}
	
	private static ArrayList<Integer> extractCTCEliminationCriteria(ConstraintDescription desc)
	{
		ArrayList<Integer> criteria = new ArrayList<Integer>();
		
		if ( desc == null )
		{
			return criteria;
		}
		
		if ( desc.leftIsVar )
		{
			if ( desc.constraint == Codes.REQUIRES )
			{
				criteria.add(Codes.FEATURE_IN_REQUIRES_LEFT);
			}
			else
			{
				criteria.add(Codes.FEATURE_IN_EXCLUDES);
			}
		}
		
		if ( desc.rightIsVar )
		{
			if ( desc.constraint == Codes.REQUIRES )
			{
				criteria.add(Codes.FEATURE_IN_REQUIRES_RIGHT);
			}
			else
			{
				criteria.add(Codes.FEATURE_IN_EXCLUDES);
			}
		}
			
		return criteria;
	}
	
	private static void eliminateIncompatibleResolutions(ArrayList<FeatureVarSolutionSet> sset, ArrayList<MustBeCompatibleFVars> comList, ArrayList<Feature> featList)
	{
		if ( sset == null || sset.size() == 0 || comList == null || comList.size() == 0 )
		{
			return;
		}
		
		int i, j, k, res1idNo, res2idNo;
		boolean eliminate;
		FeatureVarSolutionSet fvss;
		MustBeCompatibleFVars comInfo;
		String fvar;
		Feature feature, feat1, feat2;
		Attribute attribute, attr1, attr2;
		
		
		for (i=0; i<sset.size(); i++)
		{
			fvss = sset.get(i);
			
			eliminate = false;
			for (j=0; j<comList.size(); j++)
			{
				comInfo = comList.get(j);
				
				res1idNo = res2idNo = Codes._NO_VALUE_;
				for (k=0; k<fvss.resolutions.size(); k++)
				{
					fvar = fvss.resolutions.get(k).featureVar;
					if ( comInfo.FVar1.equals(fvar) )
					{
						res1idNo = fvss.resolutions.get(k).featureIDNo;
					}
					if ( comInfo.FVar2.equals(fvar) )
					{
						res2idNo = fvss.resolutions.get(k).featureIDNo;
					}
				}
				if ( res2idNo == Codes._NO_VALUE_ || res2idNo == Codes._NO_VALUE_ )
				{
					eliminate = true;
					break;
				}
				
				feat1 = feat2 = null;
				for (k=0; k<featList.size(); k++)
				{
					feature = featList.get(k);
					if ( res1idNo == feature.idNo )
					{
						feat1 = feature;
					}
					if ( res2idNo == feature.idNo )
					{
						feat2 = feature;
					}
				}
				if ( feat1 == null || feat2 == null )
				{
					eliminate = true;
					break;
				}
				
				attr1 = attr2 = null;
				for (k=0; k<feat1.attributes.size(); k++)
				{
					attribute = feat1.attributes.get(k);
					if ( comInfo.VarAttr1.equals(attribute.name) )
					{
						attr1 = attribute;
						break;
					}
				}
				for (k=0; k<feat2.attributes.size(); k++)
				{
					attribute = feat2.attributes.get(k);
					if ( comInfo.VarAttr2.equals(attribute.name) )
					{
						attr2 = attribute;
						break;
					}
				}
				if ( attr1 == null || attr2 == null )
				{
					eliminate = true;
					break;
				}
				
				if ( attr1.type == attr2.type )
				{
					continue;
				}
				else if ( attr1.type == Codes.TYPE_INT || attr1.type == Codes.TYPE_REAL )
				{
					if ( attr2.type == Codes.TYPE_INT || attr2.type == Codes.TYPE_REAL )
					{
						continue;
					}
				}
				
				eliminate = true;
				break;
			}
			
			if ( eliminate )
			{
				sset.remove(i);
				i--;
			}
		}
	}
	
	
	private static ArrayList<String> findTheFeaturesThatWillBeAffectedByTheCommand(Command cmd, ArrayList<FeatureVarSolutionSet> solutionSet, ArrayList<Feature> flist)
	{
		ArrayList<String> fNames=null;
		Feature f;
		
		switch ( cmd.type )
		{
			case Codes.COMMAND_UPDATE_F:
				UpdateAFeatureCmd upf = (UpdateAFeatureCmd) cmd;
				if ( upf.featDesc.varUsed )
				{
					fNames = findTheFeaturesThatMatchTheResolutions(upf.featDesc.featureVar, solutionSet, flist);
				}
				else
				{
					f = findFeature(upf.featDesc.featureName, flist);
					if ( f == null )
					{
						return new ArrayList<String>();
					}
					
					fNames = new ArrayList<String>();
					fNames.add(upf.featDesc.featureName);
				}
				break;
				
			case Codes.COMMAND_UPDATEALL_F:
				UpdateMultipleFeaturesCmd upmf = (UpdateMultipleFeaturesCmd) cmd;
				fNames = findTheFeaturesThatMatchTheResolutions(upmf.featureVar, solutionSet, flist);
				break;
				
			case Codes.COMMAND_REMOVE_F:
				RemoveAFeatureCmd rmf = (RemoveAFeatureCmd) cmd;
				if ( rmf.featDesc.varUsed )
				{
					fNames = findTheFeaturesThatMatchTheResolutions(rmf.featDesc.featureVar, solutionSet, flist);
				}
				else
				{
					f = findFeature(rmf.featDesc.featureName, flist);
					if ( f == null )
					{
						return new ArrayList<String>();
					}
					
					fNames = new ArrayList<String>();
					fNames.add(rmf.featDesc.featureName);
				}
				break;
				
			case Codes.COMMAND_REMOVEALL_F:
				RemoveMultipleFeaturesCmd rmmf = (RemoveMultipleFeaturesCmd) cmd;
				fNames = findTheFeaturesThatMatchTheResolutions(rmmf.featureVar, solutionSet, flist);
				break;
		
			default:
				return new ArrayList<String>();
		}
		
		return fNames;
	}
	
	private static ArrayList<String> findTheFeaturesThatMatchTheResolutions(
			String featureVar,
			ArrayList<FeatureVarSolutionSet> solutionSet,
			ArrayList<Feature> flist)
	{
		int i, j, k, idno;
		boolean found;
		FeatureVarSolutionSet sset;
		FeatureVariableResolution fvr;
		ArrayList<Integer> idnos = new ArrayList<Integer>();
		ArrayList<String> result = new ArrayList<String>();
		
		
		if ( solutionSet == null || solutionSet.size() == 0 || flist == null || flist.size() == 0 )
		{
			return result;
		}
		
		for (i=0; i<solutionSet.size(); i++)
		{
			sset = solutionSet.get(i);
			for (j=0; j<sset.resolutions.size(); j++)
			{
				fvr = sset.resolutions.get(j);
				if ( featureVar.equals(fvr.featureVar) )
				{
					found = false;
					for (k=0; k<idnos.size(); k++)
					{
						if ( fvr.featureIDNo == idnos.get(k) )
						{
							found = true;
							break;
						}
					}
					
					if ( !found )
					{
						idnos.add(fvr.featureIDNo);
					}
				}
			}
		}
		
		for (i=0; i<idnos.size(); i++)
		{
			idno = idnos.get(i);
			for (j=0; j<flist.size(); j++)
			{
				if ( idno == flist.get(j).idNo )
				{
					result.add(flist.get(j)._name);
					break;
				}
			}
		}
		
		return result;
	}
	
	private static ArrayList<RawCrossTreeConstraint> deriveTheCrossTreeConstraintsFromTheResolutions(
			AddAConstraintCmd cmd,
			ArrayList<FeatureVarSolutionSet> solutionSet,
			ArrayList<Feature> flist)
	{
		ConstraintDescription desc;
		String leftFeature, rightFeature;
		String leftVar, rightVar;
		int i, j, candidateLNo, candidateRNo;
		boolean found;
		Feature feat;
		FeatureVarSolutionSet sset;
		FeatureVariableResolution fvr;
		ArrayList<RawCrossTreeConstraint> results = new ArrayList<RawCrossTreeConstraint>();
		RawCrossTreeConstraint rawctc;
		
		
		if ( flist == null || flist.size() == 0 )
		{
			return new ArrayList<RawCrossTreeConstraint>();
		}
		
		if ( solutionSet == null )
		{
			solutionSet = new ArrayList<FeatureVarSolutionSet>();
		}
		
		
		desc = cmd.constDesc;
		
		leftFeature = rightFeature = leftVar = rightVar = null;
		
		if ( desc.leftIsVar )
		{
			leftVar = desc.leftFeatureVar;
		}
		else
		{
			leftFeature = desc.leftFeatureName;
		}
		
		if ( desc.rightIsVar )
		{
			rightVar = desc.rightFeatureVar;
		}
		else
		{
			rightFeature = desc.rightFeatureName;
		}
		
		if ( leftFeature != null && rightFeature != null )
		{
			rawctc = new RawCrossTreeConstraint();
			rawctc.constraintType = desc.constraint;
			rawctc.leftFeature  = leftFeature;
			rawctc.rightFeature = rightFeature;
			results.add(rawctc);
			
			return results;
		}
		
		for (i=0; i<solutionSet.size(); i++)
		{
			sset = solutionSet.get(i);
			candidateLNo = candidateRNo = Codes._NO_VALUE_;
			for (j=0; j<sset.resolutions.size(); j++)
			{
				fvr = sset.resolutions.get(j);
				if ( leftFeature == null && leftVar.equals(fvr.featureVar) )
				{
					candidateLNo = fvr.featureIDNo;
				}
				if ( rightFeature == null && rightVar.equals(fvr.featureVar) )
				{
					candidateRNo = fvr.featureIDNo;
				}
			}
			
			rawctc = new RawCrossTreeConstraint();
			rawctc.constraintType = desc.constraint;
			
			if ( leftFeature != null )
			{
				rawctc.leftFeature = leftFeature;
			}
			else
			{
				found = false;
				for (j=0; j<flist.size(); j++)
				{
					feat = flist.get(j);
					if ( candidateLNo == feat.idNo )
					{
						rawctc.leftFeature = feat._name;
						found = true;
						break;
					}
				}
				if ( !found )
				{
					return null;
				}
			}
			
			if ( rightFeature != null )
			{
				rawctc.rightFeature = rightFeature;
			}
			else
			{
				found = false;
				for (j=0; j<flist.size(); j++)
				{
					feat = flist.get(j);
					if ( candidateRNo == feat.idNo )
					{
						rawctc.rightFeature = feat._name;
						found = true;
						break;
					}
				}
				if ( !found )
				{
					return null;
				}
			}
			
			results.add(rawctc);
		}
		
		return results;
	}

	private static ArrayList<RawCrossTreeConstraint> findTheCrossTreeConstraintsThatMatchTheResolutions(
			Command cmd, 
			ArrayList<FeatureVarSolutionSet> solutionSet,
			ArrayList<Feature> flist,
			ArrayList<CrossTreeConstraint> clist)
	{
		ConstraintDescription desc;
		String leftFeature, rightFeature;
		String leftVar, rightVar;
		int i, j, leftIDNo, rightIDNo, candidateLNo, candidateRNo;
		boolean found;
		Feature feat;
		FeatureVarSolutionSet sset;
		FeatureVariableResolution fvr;
		ArrayList<CrossTreeConstraint> possibles = new ArrayList<CrossTreeConstraint>();
		CrossTreeConstraint ctc, ctc2;
		ArrayList<RawCrossTreeConstraint> tmpresults = new ArrayList<RawCrossTreeConstraint>();
		ArrayList<RawCrossTreeConstraint> results = new ArrayList<RawCrossTreeConstraint>();
		RawCrossTreeConstraint rawctc, rawctc2;
		
		
		if ( cmd == null || clist == null || clist.size() == 0 || flist == null || flist.size() == 0 )
		{
			return new ArrayList<RawCrossTreeConstraint>();
		}
		
		if ( solutionSet == null )
		{
			solutionSet = new ArrayList<FeatureVarSolutionSet>();
		}
		
		
		if ( cmd.type == Codes.COMMAND_ADD_C )
		{
			desc = ((AddAConstraintCmd) cmd).constDesc;
		}
		else if ( cmd.type == Codes.COMMAND_UPDATE_C )
		{
			desc = ((UpdateAConstraintCmd) cmd).constDesc;
		}
		else if ( cmd.type == Codes.COMMAND_UPDATEALL_C )
		{
			desc = ((UpdateMultipleConstraintsCmd) cmd).constDesc;
		}
		else if ( cmd.type == Codes.COMMAND_REMOVE_C )
		{
			desc = ((RemoveAConstraintCmd) cmd).constDesc;
		}
		else if ( cmd.type == Codes.COMMAND_REMOVEALL_C )
		{
			desc = ((RemoveMultipleConstraintsCmd) cmd).constDesc;
		}
		else
		{
			return results;
		}
		
		leftFeature = rightFeature = leftVar = rightVar = null;
		leftIDNo = rightIDNo = Codes._NO_VALUE_;
		
		if ( desc.leftIsVar )
		{
			leftVar = desc.leftFeatureVar;
		}
		else
		{
			leftFeature = desc.leftFeatureName;
			feat = findFeature(leftFeature, flist);
			if ( feat == null )
			{
				return results;
			}
			leftIDNo = feat.idNo;
		}
		
		if ( desc.rightIsVar )
		{
			rightVar = desc.rightFeatureVar;
		}
		else
		{
			rightFeature = desc.rightFeatureName;
			feat = findFeature(rightFeature, flist);
			if ( feat == null )
			{
				return results;
			}
			rightIDNo = feat.idNo;
		}
		
		if ( leftIDNo != Codes._NO_VALUE_ && rightIDNo != Codes._NO_VALUE_ )
		{
			ctc = new CrossTreeConstraint();
			ctc.constraintType = desc.constraint;
			ctc.leftIDNo  = leftIDNo;
			ctc.rightIDNo = rightIDNo;
			possibles.add(ctc);
			
			if ( desc.constraint == Codes.EXCLUDES )
			{
				ctc = new CrossTreeConstraint();
				ctc.constraintType = desc.constraint;
				ctc.rightIDNo = leftIDNo;
				ctc.leftIDNo  = rightIDNo;
				possibles.add(ctc);
			}
		}
		else
		{
			for (i=0; i<solutionSet.size(); i++)
			{
				sset = solutionSet.get(i);
				candidateLNo = leftIDNo;
				candidateRNo = rightIDNo;
				for (j=0; j<sset.resolutions.size(); j++)
				{
					fvr = sset.resolutions.get(j);
					if ( leftIDNo == Codes._NO_VALUE_ && leftVar.equals(fvr.featureVar) )
					{
						candidateLNo = fvr.featureIDNo;
					}
					if ( rightIDNo == Codes._NO_VALUE_ && rightVar.equals(fvr.featureVar) )
					{
						candidateRNo = fvr.featureIDNo;
					}
				}
				
				ctc = new CrossTreeConstraint();
				ctc.constraintType = desc.constraint;
				ctc.leftIDNo  = candidateLNo;
				ctc.rightIDNo = candidateRNo;
				possibles.add(ctc);
				
				if ( desc.constraint == Codes.EXCLUDES )
				{
					ctc2 = new CrossTreeConstraint();
					ctc2.constraintType = ctc.constraintType;
					ctc2.leftIDNo  = ctc.rightIDNo;
					ctc2.rightIDNo = ctc.leftIDNo;
					possibles.add(ctc2);
				}
			}
		}
			
		for (i=0; i<possibles.size(); i++)
		{
			ctc = possibles.get(i);
			for (j=0; j<clist.size(); j++)
			{
				ctc2 = clist.get(j);
				
				if ( ctc.leftIDNo == ctc2.leftIDNo && ctc.constraintType == ctc2.constraintType && ctc.rightIDNo == ctc2.rightIDNo )
				{
					rawctc = new RawCrossTreeConstraint();
					rawctc.constraintType = ctc.constraintType;
					rawctc.leftFeature    = ctc2.leftFeature;
					rawctc.rightFeature   = ctc2.rightFeature;
					tmpresults.add(rawctc);
					
					break;
				}
			}
		}
		
		// eliminate possible duplicates
		if ( tmpresults.size() > 0 )
		{
			results.add(tmpresults.get(0));
		}
		for (i=1; i<tmpresults.size(); i++)
		{
			rawctc = tmpresults.get(i);
			found = false;
			for (j=0; j<results.size(); j++)
			{
				rawctc2 = results.get(j);
				if ( rawctc.leftFeature.equalsIgnoreCase(rawctc2.leftFeature) && rawctc.rightFeature.equalsIgnoreCase(rawctc2.rightFeature) )
				{
					found = true;
					break;
				}
			}
			if ( !found )
			{
				results.add(rawctc);
			}
		}
		
		return results;
	}
	
	
	private static CommandExecutionError replaceVariablesWithFeatures_AddF(AddAFeatureCmd addf, ArrayList<FeatureVarSolutionSet> solutionSet, ArrayList<Feature> featList)
	{
		CommandExecutionError cee;
		
		if ( addf == null )
		{
			cee = new CommandExecutionError();
			cee.errorCode = ErrorCodes.EXECUTION_INVALID_COMMAND;
			cee.explanation = "Internal Error (Invalid Add a Feature Command)";
			return cee;
		}
		
		cee = replaceVariablesWithFeaturesInTheLocationSetting(addf.settingLoc, solutionSet, featList);
		if ( cee.errorCode != ErrorCodes.NO_ERROR )
		{
			return cee;
		}
		
		cee = replaceVariablesWithFeaturesInTheDecompositionSetting(addf.settingDecomp, solutionSet, featList);
		if ( cee.errorCode != ErrorCodes.NO_ERROR )
		{
			return cee;
		}

		if ( addf.otherAttrs != null && addf.otherAttrs.size() > 0 )
		{
			int i;
			OtherAttribute oa;
			ArrayList<ASTNode> exp;
			ASTNode node;
			
			for (i=0; i<addf.otherAttrs.size(); i++)
			{
				oa = addf.otherAttrs.get(i);
				
				if ( oa.type == Codes.ATTRVAL_STRING )
				{
					continue;
				}
				
				if ( oa.type == Codes.ATTRVAL_ARITHEXP )
				{
					exp = oa.arithExp;
				}
				else if ( oa.type == Codes.ATTRVAL_BOOLEXP )
				{
					exp = oa.boolExp;
				}
				else
				{
					if ( oa.featDesc.varUsed == false )
					{
						continue;
					}
					
					node = new ASTNode();
					node.type = Codes.AST_TYPE_FEATUREVAR;
					node.featureVar = oa.featDesc.featureVar;
					node.attrName   = oa.featAttrName;
					
					exp = new ArrayList<ASTNode>();
					exp.add(node);
				}
				
				cee = replaceVariablesWithFeaturesInTheAttributeAssignment(oa.name, exp, solutionSet, featList);
				if ( cee.errorCode != ErrorCodes.NO_ERROR )
				{
					return cee;
				}
				
				if ( oa.type == Codes.ATTRVAL_INHERITED )
				{
					oa.featDesc.varUsed = false;
					oa.featDesc.featureName = exp.get(0).featureName;
				}
			}
		}
		
		return cee;
	}
	
	private static CommandExecutionError replaceVariablesWithFeatures_UpF(UpdateAFeatureCmd upf, ArrayList<FeatureVarSolutionSet> solutionSet, ArrayList<Feature> featList)
	{
		CommandExecutionError cee;
		
		if ( upf == null )
		{
			cee = new CommandExecutionError();
			cee.errorCode = ErrorCodes.EXECUTION_INVALID_COMMAND;
			cee.explanation = "Internal Error (Invalid Update a Feature Command)";
			return cee;
		}
		
		cee = replaceVariablesWithFeaturesInTheLocationSetting(upf.settingLoc, solutionSet, featList);
		if ( cee.errorCode != ErrorCodes.NO_ERROR )
		{
			return cee;
		}
		
		cee = replaceVariablesWithFeaturesInTheDecompositionSetting(upf.settingDecomp, solutionSet, featList);
		if ( cee.errorCode != ErrorCodes.NO_ERROR )
		{
			return cee;
		}
		
		if ( upf.settingAttrs != null && upf.settingAttrs.size() > 0 )
		{
			int i;
			OtherAttribute oa;
			ArrayList<ASTNode> exp;
			ASTNode node;
			
			for (i=0; i<upf.settingAttrs.size(); i++)
			{
				oa = upf.settingAttrs.get(i);
				
				if ( oa.type == Codes.ATTRVAL_STRING )
				{
					continue;
				}
				
				if ( oa.type == Codes.ATTRVAL_ARITHEXP )
				{
					exp = oa.arithExp;
				}
				else if ( oa.type == Codes.ATTRVAL_BOOLEXP )
				{
					exp = oa.boolExp;
				}
				else
				{
					if ( oa.featDesc.varUsed == false )
					{
						continue;
					}
					
					node = new ASTNode();
					node.type = Codes.AST_TYPE_FEATUREVAR;
					node.featureVar = oa.featDesc.featureVar;
					node.attrName   = oa.featAttrName;
					
					exp = new ArrayList<ASTNode>();
					exp.add(node);
				}
				
				cee = replaceVariablesWithFeaturesInTheAttributeAssignment(oa.name, exp, solutionSet, featList);
				if ( cee.errorCode != ErrorCodes.NO_ERROR )
				{
					return cee;
				}
				
				if ( oa.type == Codes.ATTRVAL_INHERITED )
				{
					oa.featDesc.varUsed = false;
					oa.featDesc.featureName = exp.get(0).featureName;
				}
			}
		}
		
		return cee;
	}
	
	private static CommandExecutionError replaceVariablesWithFeatures_UpAllF(UpdateMultipleFeaturesCmd upallf, ArrayList<FeatureVarSolutionSet> solutionSet, ArrayList<Feature> featList)
	{
		CommandExecutionError cee;
		
		if ( upallf == null )
		{
			cee = new CommandExecutionError();
			cee.errorCode = ErrorCodes.EXECUTION_INVALID_COMMAND;
			cee.explanation = "Internal Error (Invalid Update Multiple Features Command)";
			return cee;
		}
		
		cee = replaceVariablesWithFeaturesInTheLocationSetting(upallf.settingLoc, solutionSet, featList);
		if ( cee.errorCode != ErrorCodes.NO_ERROR )
		{
			return cee;
		}
		
		cee = replaceVariablesWithFeaturesInTheDecompositionSetting(upallf.settingDecomp, solutionSet, featList);
		if ( cee.errorCode != ErrorCodes.NO_ERROR )
		{
			return cee;
		}
		
		if ( upallf.settingAttrs != null && upallf.settingAttrs.size() > 0 )
		{
			int i;
			OtherAttribute oa;
			ArrayList<ASTNode> exp;
			ASTNode node;
			
			for (i=0; i<upallf.settingAttrs.size(); i++)
			{
				oa = upallf.settingAttrs.get(i);
				
				if ( oa.type == Codes.ATTRVAL_STRING )
				{
					continue;
				}
				
				if ( oa.type == Codes.ATTRVAL_ARITHEXP )
				{
					exp = oa.arithExp;
				}
				else if ( oa.type == Codes.ATTRVAL_BOOLEXP )
				{
					exp = oa.boolExp;
				}
				else
				{
					if ( oa.featDesc.varUsed == false )
					{
						continue;
					}
					
					node = new ASTNode();
					node.type = Codes.AST_TYPE_FEATUREVAR;
					node.featureVar = oa.featDesc.featureVar;
					node.attrName   = oa.featAttrName;
					
					exp = new ArrayList<ASTNode>();
					exp.add(node);
				}
				
				cee = replaceVariablesWithFeaturesInTheAttributeAssignment(oa.name, exp, solutionSet, featList);
				if ( cee.errorCode != ErrorCodes.NO_ERROR )
				{
					return cee;
				}
				
				if ( oa.type == Codes.ATTRVAL_INHERITED )
				{
					oa.featDesc.varUsed = false;
					oa.featDesc.featureName = exp.get(0).featureName;
				}
			}
		}
		
		return cee;

	}
	
	private static CommandExecutionError replaceVariablesWithFeatures_UpC(UpdateAConstraintCmd upc, ArrayList<FeatureVarSolutionSet> solutionSet, ArrayList<Feature> featList)
	{
		if ( upc == null )
		{
			CommandExecutionError cee = new CommandExecutionError();
			cee.errorCode = ErrorCodes.EXECUTION_INVALID_COMMAND;
			cee.explanation = "Internal Error (Invalid Update a Constraint Command)";
			return cee;
		}
		
		return replaceVariablesWithFeaturesInTheConstraintUpdate(upc.leftUpdate, upc.rightUpdate, solutionSet, featList);
	}
	
	private static CommandExecutionError replaceVariablesWithFeatures_UpAllC(UpdateMultipleConstraintsCmd upallc, ArrayList<FeatureVarSolutionSet> solutionSet, ArrayList<Feature> featList)
	{
		if ( upallc == null )
		{
			CommandExecutionError cee = new CommandExecutionError();
			cee.errorCode = ErrorCodes.EXECUTION_INVALID_COMMAND;
			cee.explanation = "Internal Error (Invalid Update Multiple Constraints Command)";
			return cee;
		}
		
		return replaceVariablesWithFeaturesInTheConstraintUpdate(upallc.leftUpdate, upallc.rightUpdate, solutionSet, featList);
	}
	
	private static CommandExecutionError replaceVariablesWithFeaturesInTheLocationSetting(SettingLocation info, ArrayList<FeatureVarSolutionSet> solutionSet, ArrayList<Feature> featList)
	{
		CommandExecutionError cee = new CommandExecutionError();
		cee.errorCode = ErrorCodes.NO_ERROR;
		cee.explanation = "";
		
		int i;
		ArrayList<String> matchingNames;
		
		if ( info != null && info.varUsed )
		{
			matchingNames = findTheFeaturesThatMatchTheResolutions(info.featureVar, solutionSet, featList);
			if ( matchingNames == null || matchingNames.size() == 0 )
			{
				cee.errorCode = ErrorCodes.EXECUTION_UNKNOWN;
				cee.explanation = "Unknown Error - No resolution could be found for " + info.featureVar;
				return cee;
			}
			
			if ( matchingNames.size() > 1 )
			{
				cee.errorCode = ErrorCodes.EXECUTION_AMBIGUOUS_NEW_PARENT;
				cee.explanation = "Command is ambiguous on what the new parent feature will be (" + matchingNames.get(0);
				for (i=1; i<matchingNames.size(); i++)
				{
					cee.explanation += ", " + matchingNames.get(i);
				}
				cee.explanation += ")";
				return cee;
			}
			
			info.varUsed = false;
			info.featureName = matchingNames.get(0);
		}
		
		return cee;
	}
	
	private static CommandExecutionError replaceVariablesWithFeaturesInTheDecompositionSetting(SettingDecomposition info, ArrayList<FeatureVarSolutionSet> solutionSet, ArrayList<Feature> featList)
	{
		CommandExecutionError cee = new CommandExecutionError();
		cee.errorCode = ErrorCodes.NO_ERROR;
		cee.explanation = "";
		
		int i, val;
		ArrayList<String> matchingNames;
		Feature f;
		ArrayList<Integer> candidateValues;
		
		
		if ( info != null )
		{
			if ( info.newDecompType == Codes.ALTERNATIVE || info.newDecompType == Codes.OR || info.newDecompType == Codes.TOBERESOLVED )
			{
				if ( info.firstFeatDescExists && info.firstVarUsed )
				{
					matchingNames = findTheFeaturesThatMatchTheResolutions(info.firstFeatureVar, solutionSet, featList);
					if ( matchingNames == null || matchingNames.size() == 0 )
					{
						cee.errorCode = ErrorCodes.EXECUTION_UNKNOWN;
						cee.explanation = "Unknown Error - No resolution could be found for " + info.firstFeatureVar;
						return cee;
					}
					else if ( matchingNames.size() > 1 )
					{
						if ( info.newDecompType == Codes.TOBERESOLVED ) // we're looking for a new decomposition relation type
						{
							candidateValues = new ArrayList<Integer>();
							for (i=0; i<matchingNames.size(); i++)
							{
								f = findFeature(matchingNames.get(i), featList);
								if ( f != null )
								{
									candidateValues.add(f._decomp);
								}
							}
							
							val = candidateValues.get(0);
							for (i=1; i<candidateValues.size(); i++)
							{
								if ( val != candidateValues.get(i) )
								{
									cee.errorCode = ErrorCodes.EXECUTION_AMBIGUOUS_NEW_DECOMP_REL;
									cee.explanation = "Command is ambiguous on what the new decomposition relation will be";
									return cee;
								}
							}
						}
						else // we're looking for a new relational sibling
						{
							candidateValues = new ArrayList<Integer>();
							for (i=0; i<matchingNames.size(); i++)
							{
								f = findFeature(matchingNames.get(i), featList);
								if ( f != null )
								{
									candidateValues.add(f._decompID);
								}
							}
							
							val = candidateValues.get(0);
							for (i=1; i<candidateValues.size(); i++)
							{
								if ( val != candidateValues.get(i) )
								{
									cee.errorCode = ErrorCodes.EXECUTION_AMBIGUOUS_NEW_DECOMP_ID;
									cee.explanation = "Command is ambiguous on what the new relational sibling will be";
									return cee;
								}
							}
						}
					}
					
					info.firstVarUsed = false;
					info.firstFeatureName = matchingNames.get(0);
				}
			}
			
			if ( info.newDecompType == Codes.TOBERESOLVED )
			{
				// if the first feature variable resolved to mandatory or optional, then this info must simply be ignored
				f = findFeature(info.firstFeatureName, featList);
				
				if ( info.secondFeatDescExists && info.secondVarUsed && (f._decomp == Codes.ALTERNATIVE || f._decomp == Codes.OR) )
				{
					matchingNames = findTheFeaturesThatMatchTheResolutions(info.secondFeatureVar, solutionSet, featList);
					if ( matchingNames == null || matchingNames.size() == 0 )
					{
						cee.errorCode = ErrorCodes.EXECUTION_UNKNOWN;
						cee.explanation = "Unknown Error - No resolution could be found for " + info.secondFeatureVar;
						return cee;
					}
					else if ( matchingNames.size() > 1 )
					{
						candidateValues = new ArrayList<Integer>();
						for (i=0; i<matchingNames.size(); i++)
						{
							f = findFeature(matchingNames.get(i), featList);
							if ( f != null )
							{
								candidateValues.add(f._decompID);
							}
						}
						
						val = candidateValues.get(0);
						for (i=1; i<candidateValues.size(); i++)
						{
							if ( val != candidateValues.get(i) )
							{
								cee.errorCode = ErrorCodes.EXECUTION_AMBIGUOUS_NEW_DECOMP_ID;
								cee.explanation = "Command is ambiguous on what the new relational sibling will be";
								return cee;
							}
						}
					}
						
					info.secondVarUsed = false;
					info.secondFeatureName = matchingNames.get(0);
				}
			}
		}
		
		return cee;
	}

	private static CommandExecutionError replaceVariablesWithFeaturesInTheAttributeAssignment(String attrName, ArrayList<ASTNode> expression, ArrayList<FeatureVarSolutionSet> solutionSet, ArrayList<Feature> featList)
	{
		CommandExecutionError cee = new CommandExecutionError();
		cee.errorCode = ErrorCodes.NO_ERROR;
		cee.explanation = "";
		
		if ( expression == null || expression.size() == 0 || solutionSet == null || solutionSet.size() == 0 || featList == null || featList.size() == 0 )
		{
			return cee;
		}
		
		int i, j, k, fidno;
		boolean skipResolution;
		ArrayList<ASTNode> expCopy, evaluationResults, replaced=null;
		ASTNode node, nodechk;
		FeatureVarSolutionSet fvss;
		FeatureVariableResolution fvr;
		
		
		// first find results for all possible resolutions
		
		evaluationResults = new ArrayList<ASTNode>();
		for (i=0; i<solutionSet.size(); i++)
		{
			expCopy = createACopyOfTheExpression(expression);
			fvss = solutionSet.get(i);
			
			skipResolution = false;
			for (j=0; j<expCopy.size(); j++)
			{
				node = expCopy.get(j);
				if ( node.type != Codes.AST_TYPE_FEATUREVAR )
				{
					continue;
				}
				
				// find the feature for this feature variable in this resolution set
				fidno = Codes._NO_VALUE_;
				for (k=0; k<fvss.resolutions.size(); k++)
				{
					fvr = fvss.resolutions.get(k);
					if ( node.featureVar.equals(fvr.featureVar) )
					{
						fidno = fvr.featureIDNo;
						break;
					}
				}
				if ( fidno == Codes._NO_VALUE_ )
				{
					skipResolution = true;
					break;
				}
				
				node.featureName = null;
				for (k=0; k<featList.size(); k++)
				{
					if ( fidno == featList.get(k).idNo )
					{
						node.type = Codes.AST_TYPE_FEATURE;
						node.featureName = featList.get(k)._name;
						break;
					}
				}
				if ( node.featureName == null )
				{
					skipResolution = true;
					break;
				}
			}
			
			if ( skipResolution )
			{
				continue;
			}
			
			node = evaluateExpression(expCopy, featList);
			if ( node == null ) // normally shouldn't happen
			{
				continue;
			}
			evaluationResults.add(node);
			
			// record one of the replaced ones to return if everything is OK
			if ( replaced == null )
			{
				replaced = expCopy;
			}
		}
		
		// then compare the results
		
		if ( evaluationResults.size() == 0 ) // normally shouldn't happen
		{
			cee.errorCode = ErrorCodes.EXECUTION_UNKNOWN;
			cee.explanation = "Unknown Error (No resolution matched the attribute assignment value)";
			return cee;
		}
		
		nodechk = evaluationResults.get(0);
		if ( nodechk.type == Codes.AST_TYPE_INT ) // to prevent int-real mismatch
		{
			nodechk.type = Codes.AST_TYPE_REAL;
			nodechk.realval = nodechk.intval;
		}
		for (i=1; i<evaluationResults.size(); i++)
		{
			node = evaluationResults.get(i);
			if ( node.type == Codes.AST_TYPE_INT ) // to prevent int-real mismatch
			{
				node.type = Codes.AST_TYPE_REAL;
				node.realval = node.intval;
			}
			
			if ( nodechk.type != node.type )
			{
				cee.errorCode = ErrorCodes.EXECUTION_AMBIGUOUS_ATTR_ASSIGNMENT;
				cee.explanation = "Command is ambiguous on what the value of the attribute will be (" + attrName + ")";
				return cee;
			}
			
			switch ( nodechk.type )
			{
				case Codes.AST_TYPE_BOOL:
					if ( nodechk.boolval == node.boolval )
					{
						continue;
					}
					break;
					
				case Codes.AST_TYPE_REAL:
					if ( nodechk.realval == node.realval )
					{
						continue;
					}
					break;
					
				case Codes.AST_TYPE_STRING:
					if ( nodechk.stringval.equals(node.stringval) )
					{
						continue;
					}
					break;
			}
			
			// if here the evaluation results are different
			cee.errorCode = ErrorCodes.EXECUTION_AMBIGUOUS_ATTR_ASSIGNMENT;
			cee.explanation = "Command is ambiguous on what the value of the attribute will be (" + attrName + ")";
			return cee;
		}
		
		// if here all the resolutions are consistent, replace with one of them
		for (i=0; i<expression.size(); i++)
		{
			node = expression.get(i);
			
			if ( node.type != Codes.AST_TYPE_FEATUREVAR )
			{
				continue;
			}
			
			nodechk = replaced.get(i);
			
			node.type = Codes.AST_TYPE_FEATURE;
			node.featureName = nodechk.featureName;
		}
		
		return cee;
	}
	
	private static CommandExecutionError replaceVariablesWithFeaturesInTheConstraintUpdate(FeatureDescription left, FeatureDescription right, ArrayList<FeatureVarSolutionSet> solutionSet, ArrayList<Feature> featList)
	{
		CommandExecutionError cee = new CommandExecutionError();
		cee.errorCode = ErrorCodes.NO_ERROR;
		cee.explanation = "";
		
		int i;
		ArrayList<String> matchingNames;
		
		if ( left != null && left.varUsed )
		{
			matchingNames = findTheFeaturesThatMatchTheResolutions(left.featureVar, solutionSet, featList);
			
			if ( matchingNames == null || matchingNames.size() == 0 )
			{
				cee.errorCode = ErrorCodes.EXECUTION_UNKNOWN;
				cee.explanation = "Unknown Error - No resolution could be found for " + left.featureVar;
				return cee;
			}
			
			if ( matchingNames.size() > 1 )
			{
				cee.errorCode = ErrorCodes.EXECUTION_AMBIGUOUS_NEW_LEFT;
				cee.explanation = "Command is ambiguous on what the new left-feature will be (" + matchingNames.get(0);
				for (i=1; i<matchingNames.size(); i++)
				{
					cee.explanation += ", " + matchingNames.get(i);
				}
				cee.explanation += ")";
				return cee;
			}
			
			left.varUsed = false;
			left.featureName = matchingNames.get(0);
		}
		
		
		if ( right != null && right.varUsed )
		{
			matchingNames = findTheFeaturesThatMatchTheResolutions(right.featureVar, solutionSet, featList);
			
			if ( matchingNames == null || matchingNames.size() == 0 )
			{
				cee.errorCode = ErrorCodes.EXECUTION_UNKNOWN;
				cee.explanation = "Unknown Error - No resolution could be found for " + right.featureVar;
				return cee;
			}
			
			if ( matchingNames.size() > 1 )
			{
				cee.errorCode = ErrorCodes.EXECUTION_AMBIGUOUS_NEW_RIGHT;
				cee.explanation = "Command is ambiguous on what the new right-feature will be (" + matchingNames.get(0);
				for (i=1; i<matchingNames.size(); i++)
				{
					cee.explanation += ", " + matchingNames.get(i);
				}
				cee.explanation += ")";
				return cee;
			}
			
			right.varUsed = false;
			right.featureName = matchingNames.get(0);
		}
		
		return cee;
	}
	
	
	private static ASTNode evaluateExpression(ArrayList<ASTNode> exp, ArrayList<Feature> featlist)
	{
		int i;
		ASTNode n, n_exp, n_left, n_right;
		ArrayList<ASTNode> expCopy;
		
		if ( exp == null || exp.size() == 0 )
		{
			n = new ASTNode();
			n.boolval = true;
			return n;
		}
		
		expCopy = new ArrayList<ASTNode>();
		for (i=0; i<exp.size(); i++)
		{
			n_exp = exp.get(i);
			
			n = new ASTNode();
			n.attrName      = n_exp.attrName;
			n.boolval       = n_exp.boolval;
			n.decRelTypeVal = n_exp.decRelTypeVal;
			n.featureName   = n_exp.featureName;
			n.featureVar    = n_exp.featureVar;
			n.intval        = n_exp.intval;
			n.opcode        = n_exp.opcode;
			n.realval       = n_exp.realval;
			n.stringval     = n_exp.stringval;
			n.type          = n_exp.type;
			expCopy.add(n);
		}
		
		eliminateFeatureAttributes(expCopy, featlist);
		
		for (i=0; i<expCopy.size(); i++)
		{
			n = expCopy.get(i);
			if ( n.type != Codes.AST_TYPE_OPERATOR )
			{
				continue;
			}
			
			switch ( n.opcode )
			{
				case Codes.OP_UNMINUS:
					n_right = expCopy.get(i-1);
					if ( n_right.type == Codes.AST_TYPE_INT )
					{
						n_right.intval = -n_right.intval;
					}
					else if ( n_right.type == Codes.AST_TYPE_REAL )
					{
						n_right.realval = -n_right.realval;
					}
					
					expCopy.remove(i);
					i--;
					
					break;
				
				case Codes.OP_ADD:
				case Codes.OP_SUBTRACT:
				case Codes.OP_MULTIPLY:
				case Codes.OP_DIVIDE:
					n_left  = expCopy.get(i-2);
					n_right = expCopy.get(i-1);
					
					if ( n_left.type == Codes.AST_TYPE_REAL && n_right.type == Codes.AST_TYPE_REAL )
					{
						switch ( n.opcode )
						{
							case Codes.OP_ADD     : n_left.realval += n_right.realval; break;
							case Codes.OP_SUBTRACT: n_left.realval -= n_right.realval; break;
							case Codes.OP_MULTIPLY: n_left.realval *= n_right.realval; break;
							case Codes.OP_DIVIDE  : n_left.realval /= n_right.realval; break;
						}
					}
					else if ( n_left.type == Codes.AST_TYPE_REAL && n_right.type == Codes.AST_TYPE_INT )
					{
						switch ( n.opcode )
						{
							case Codes.OP_ADD     : n_left.realval += n_right.intval; break;
							case Codes.OP_SUBTRACT: n_left.realval -= n_right.intval; break;
							case Codes.OP_MULTIPLY: n_left.realval *= n_right.intval; break;
							case Codes.OP_DIVIDE  : n_left.realval /= n_right.intval; break;
						}
					}
					else if ( n_left.type == Codes.AST_TYPE_INT && n_right.type == Codes.AST_TYPE_REAL )
					{
						n_left.type = Codes.AST_TYPE_REAL;
						switch ( n.opcode )
						{
							case Codes.OP_ADD     : n_left.realval = n_left.intval + n_right.realval; break;
							case Codes.OP_SUBTRACT: n_left.realval = n_left.intval - n_right.realval; break;
							case Codes.OP_MULTIPLY: n_left.realval = n_left.intval * n_right.realval; break;
							case Codes.OP_DIVIDE  : n_left.realval = n_left.intval / n_right.realval; break;
						}
					}
					else
					{
						switch ( n.opcode )
						{
							case Codes.OP_ADD     : n_left.intval += n_right.intval; break;
							case Codes.OP_SUBTRACT: n_left.intval -= n_right.intval; break;
							case Codes.OP_MULTIPLY: n_left.intval *= n_right.intval; break;
							case Codes.OP_DIVIDE  : n_left.type = Codes.AST_TYPE_REAL; n_left.realval = n_left.intval / (double) n_right.intval; break;
						}
					}
					
					expCopy.remove(i);
					expCopy.remove(i-1);
					i -= 2;
					break;
					
				case Codes.OP_MODULUS:
					n_left  = expCopy.get(i-2);
					n_right = expCopy.get(i-1);
					
					n_left.intval %= n_right.intval;
					
					expCopy.remove(i);
					expCopy.remove(i-1);
					i -= 2;
					
					break;
					
				case Codes.OP_NOT:
					n_right = expCopy.get(i-1);
					
					n_right.boolval = ! n_right.boolval;
					
					expCopy.remove(i);
					i--;
					
					break;
					
				case Codes.OP_AND:
				case Codes.OP_OR:
					n_left  = expCopy.get(i-2);
					n_right = expCopy.get(i-1);
					
					switch ( n.opcode )
					{
						case Codes.OP_AND: n_left.boolval = n_left.boolval && n_right.boolval; break;
						case Codes.OP_OR : n_left.boolval = n_left.boolval || n_right.boolval; break;
					}
					
					expCopy.remove(i);
					expCopy.remove(i-1);
					i -= 2;
					
					break;
					
				case Codes.OP_LT:
				case Codes.OP_LTE:
				case Codes.OP_GT:
				case Codes.OP_GTE:
					n_left  = expCopy.get(i-2);
					n_right = expCopy.get(i-1);
					
					if ( n_left.type == Codes.AST_TYPE_REAL && n_right.type == Codes.AST_TYPE_REAL )
					{
						n_left.type = Codes.AST_TYPE_BOOL;
						switch ( n.opcode )
						{
							case Codes.OP_LT : n_left.boolval = n_left.realval <  n_right.realval; break;
							case Codes.OP_LTE: n_left.boolval = n_left.realval <= n_right.realval; break;
							case Codes.OP_GT : n_left.boolval = n_left.realval >  n_right.realval; break;
							case Codes.OP_GTE: n_left.boolval = n_left.realval >= n_right.realval; break;
						}
					}
					else if ( n_left.type == Codes.AST_TYPE_REAL && n_right.type == Codes.AST_TYPE_INT )
					{
						n_left.type = Codes.AST_TYPE_BOOL;
						switch ( n.opcode )
						{
							case Codes.OP_LT : n_left.boolval = n_left.realval <  n_right.intval; break;
							case Codes.OP_LTE: n_left.boolval = n_left.realval <= n_right.intval; break;
							case Codes.OP_GT : n_left.boolval = n_left.realval >  n_right.intval; break;
							case Codes.OP_GTE: n_left.boolval = n_left.realval >= n_right.intval; break;
						}
					}
					else if ( n_left.type == Codes.AST_TYPE_INT && n_right.type == Codes.AST_TYPE_REAL )
					{
						n_left.type = Codes.AST_TYPE_BOOL;
						switch ( n.opcode )
						{
							case Codes.OP_LT : n_left.boolval = n_left.intval <  n_right.realval; break;
							case Codes.OP_LTE: n_left.boolval = n_left.intval <= n_right.realval; break;
							case Codes.OP_GT : n_left.boolval = n_left.intval >  n_right.realval; break;
							case Codes.OP_GTE: n_left.boolval = n_left.intval >= n_right.realval; break;
						}
					}
					else
					{
						n_left.type = Codes.AST_TYPE_BOOL;
						switch ( n.opcode )
						{
							case Codes.OP_LT : n_left.boolval = n_left.intval <  n_right.intval; break;
							case Codes.OP_LTE: n_left.boolval = n_left.intval <= n_right.intval; break;
							case Codes.OP_GT : n_left.boolval = n_left.intval >  n_right.intval; break;
							case Codes.OP_GTE: n_left.boolval = n_left.intval >= n_right.intval; break;
						}
					}
					
					expCopy.remove(i);
					expCopy.remove(i-1);
					i -= 2;
					
					break;
					
				case Codes.OP_EQ:
				case Codes.OP_NEQ:
					n_left  = expCopy.get(i-2);
					n_right = expCopy.get(i-1);
					
					if ( n_left.type == Codes.AST_TYPE_REAL && n_right.type == Codes.AST_TYPE_REAL )
					{
						n_left.type = Codes.AST_TYPE_BOOL;
						switch ( n.opcode )
						{
							case Codes.OP_EQ : n_left.boolval = n_left.realval == n_right.realval; break;
							case Codes.OP_NEQ: n_left.boolval = n_left.realval != n_right.realval; break;
						}
					}
					else if ( n_left.type == Codes.AST_TYPE_REAL && n_right.type == Codes.AST_TYPE_INT )
					{
						n_left.type = Codes.AST_TYPE_BOOL;
						switch ( n.opcode )
						{
							case Codes.OP_EQ : n_left.boolval = n_left.realval == n_right.intval; break;
							case Codes.OP_NEQ: n_left.boolval = n_left.realval != n_right.intval; break;
						}
					}
					else if ( n_left.type == Codes.AST_TYPE_INT && n_right.type == Codes.AST_TYPE_REAL )
					{
						n_left.type = Codes.AST_TYPE_BOOL;
						switch ( n.opcode )
						{
							case Codes.OP_EQ : n_left.boolval = n_left.intval == n_right.realval; break;
							case Codes.OP_NEQ: n_left.boolval = n_left.intval != n_right.realval; break;
						}
					}
					else if ( n_left.type == Codes.AST_TYPE_INT && n_right.type == Codes.AST_TYPE_INT )
					{
						n_left.type = Codes.AST_TYPE_BOOL;
						switch ( n.opcode )
						{
							case Codes.OP_EQ : n_left.boolval = n_left.intval == n_right.intval; break;
							case Codes.OP_NEQ: n_left.boolval = n_left.intval != n_right.intval; break;
						}
					}
					else if ( n_left.type == Codes.AST_TYPE_STRING && n_right.type == Codes.AST_TYPE_STRING )
					{
						n_left.type = Codes.AST_TYPE_BOOL;
						switch ( n.opcode )
						{
							case Codes.OP_EQ : n_left.boolval = n_left.stringval.equals(n_right.stringval);   break;
							case Codes.OP_NEQ: n_left.boolval = ! n_left.stringval.equals(n_right.stringval); break;
						}
					}
					else if ( n_left.type == Codes.AST_TYPE_DECRELTYPE && n_right.type == Codes.AST_TYPE_DECRELTYPE )
					{
						n_left.type = Codes.AST_TYPE_BOOL;
						switch ( n.opcode )
						{
							case Codes.OP_EQ : n_left.boolval = n_left.decRelTypeVal == n_right.decRelTypeVal; break;
							case Codes.OP_NEQ: n_left.boolval = n_left.decRelTypeVal != n_right.decRelTypeVal; break;
						}
					}
					else if ( n_left.type == Codes.AST_TYPE_DECRELID && n_right.type == Codes.AST_TYPE_DECRELID )
					{
						n_left.type = Codes.AST_TYPE_BOOL;
						switch ( n.opcode )
						{
							case Codes.OP_EQ : n_left.boolval = n_left.intval == n_right.intval; break;
							case Codes.OP_NEQ: n_left.boolval = n_left.intval != n_right.intval; break;
						}
					}
					
					expCopy.remove(i);
					expCopy.remove(i-1);
					i -= 2;
					
					break;
			}
		}
		
		return expCopy.get(0);
	}

	private static ArrayList<ASTNode> eliminateFeatureAttributes(ArrayList<ASTNode> exp, ArrayList<Feature> featlist)
	{
		int i, j;
		boolean found;
		ASTNode n;
		Feature f=null, p=null;
		Attribute a=null;
		
		
		if ( exp == null || featlist == null )
		{
			return null;
		}
		
		for (i=0; i<exp.size(); i++)
		{
			n = exp.get(i);
			
			if ( n.type != Codes.AST_TYPE_FEATURE )
			{
				continue;
			}
			
			for (found=false, j=0; j<featlist.size(); j++)
			{
				f = featlist.get(j);
				if ( n.featureName.equals(f._name) )
				{
					found = true;
					break;
				}
			}
			if ( !found )
			{
				return null;
			}

			if ( n.attrName.equals("_name") )
			{
				n.type = Codes.AST_TYPE_STRING;
				n.stringval = f._name;
			}
			else if ( n.attrName.equals("_parent") )
			{
				n.type = Codes.AST_TYPE_STRING;
				for (found=false, j=0; j<featlist.size(); j++)
				{
					p = featlist.get(j);
					if ( f._parentIDNo == p.idNo )
					{
						found = true;
						break;
					}
				}
				if ( !found )
				{
					return null;
				}
				
				n.stringval = p._name;
			}
			else if ( n.attrName.equals("_decomp") )
			{
				n.type = Codes.AST_TYPE_DECRELTYPE;
				n.decRelTypeVal = f._decomp;
			}
			else if ( n.attrName.equals("_decompID") )
			{
				n.type = Codes.AST_TYPE_DECRELID;
				n.intval = f._decompID;
			}
			else
			{
				for (found=false, j=0; j<f.attributes.size(); j++)
				{
					a = f.attributes.get(j);
					if ( n.attrName.equals(a.name) )
					{
						found = true;
						break;
					}
				}
				if ( !found )
				{
					return null;
				}
				
				switch ( a.type )
				{
					case Codes.TYPE_INT:
						n.type = Codes.AST_TYPE_INT;
						n.intval = a.intval;
						break;
						
					case Codes.TYPE_REAL:
						n.type = Codes.AST_TYPE_REAL;
						n.realval = a.realval;
						break;
						
					case Codes.TYPE_BOOL:
						n.type = Codes.AST_TYPE_BOOL;
						n.boolval = a.boolval;
						break;
						
					case Codes.TYPE_STRING:
						n.type = Codes.AST_TYPE_STRING;
						n.stringval = a.stringval;
						break;
				}
			}
		}
		
		return exp;
	}

	
	private static Feature findFeature(String fname, ArrayList<Feature> flist)
	{
		if ( fname == null )
		{
			return null;
		}
		
		Feature f;
		for (int i=0; i<flist.size(); i++)
		{
			f = flist.get(i);
			if ( fname.equalsIgnoreCase(f._name) )
			{
				return f;
			}
		}
		
		return null;
	}

	private static ArrayList<ASTNode> createACopyOfTheExpression(ArrayList<ASTNode> expression)
	{
		if ( expression == null )
		{
			return null;
		}
		if ( expression.size() == 0 )
		{
			return new ArrayList<ASTNode>();
		}
		
		int i;
		ArrayList<ASTNode> copy = new ArrayList<ASTNode>();
		ASTNode node, cp;
		
		for (i=0; i<expression.size(); i++)
		{
			node = expression.get(i);
			
			cp = new ASTNode();
			cp.attrName      = node.attrName;
			cp.boolval       = node.boolval;
			cp.decRelTypeVal = node.decRelTypeVal;
			cp.featureName   = node.featureName;
			cp.featureVar    = node.featureVar;
			cp.intval        = node.intval;
			cp.opcode        = node.opcode;
			cp.realval       = node.realval;
			cp.stringval     = node.stringval;
			cp.type          = node.type;
			copy.add(cp);
		}
		
		return copy;
	}


	private static class AffectedEntities
	{
		private ArrayList<String> Features;
		private ArrayList<RawCrossTreeConstraint> Constraints;
		
		private AffectedEntities()
		{
			Features = null;
			Constraints = null;
		}
	}

}

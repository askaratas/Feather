import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;


/** *******************************************************************************************
 * EILReader
 * --------------------------------------------------------------------------------------------
 * @author Ahmet Serkan Karatas
 *
 ** ******************************************************************************************* */
class EILReader
{
	private String m_fileName;
	private RawFeature m_root;
	private ArrayList<RawFeature> m_featureList;
	private ArrayList<RawCrossTreeConstraint> m_constraintList;
	private ArrayList<Command> m_commandList;
	
	public RawFeature getRoot()
	{
		return m_root;
	}
	
	public ArrayList<RawFeature> getFeatureList()
	{
		return m_featureList;
	}
	
	public ArrayList<RawCrossTreeConstraint> getConstraintList()
	{
		return m_constraintList;
	}
	
	public ArrayList<Command> getCommandList()
	{
		return m_commandList;
	}
	
	
	public EILReader(String fileName)
	{
		m_fileName = fileName;
		
		m_root = new RawFeature();
		m_featureList = new ArrayList<RawFeature>();
		m_constraintList = new ArrayList<RawCrossTreeConstraint>();
		m_commandList = new ArrayList<Command>();
	}
	

	public int readEILFile()
	{
		File eilFile = null;
		Scanner efs = null;
		try
		{
			eilFile = new File(m_fileName);
			efs = new Scanner(eilFile);
			efs.useLocale(Locale.ENGLISH);
		}
		catch (Exception e)
		{
			efs.close();
			return ErrorCodes.EIL_ERROR_IN_FILE;
		}
		
		int code;
		RawFeature feature;
		RawCrossTreeConstraint constraint;
		Command cmd;
		
		// first read the root declaration
		try
		{
			code = efs.nextInt();
			if ( code != Codes.DECLARATION_ROOT )
			{
				efs.close();
				return ErrorCodes.EIL_ERROR_IN_ROOT_DECLARATION;
			}
			
			m_root = readRootFeatureDeclaration(efs);
		}
		catch (Exception e)
		{
			efs.close();
			return ErrorCodes.EIL_ERROR_IN_ROOT_DECLARATION;
		}
		
		// then read the other feature declarations (if there are any)
		if ( efs.hasNextInt() == false )
		{
			efs.close();
			return ErrorCodes.EIL_ERROR_NO_COMMANDS;
		}
		code = efs.nextInt();
		
		while ( code == Codes.DECLARATION_FEATURE )
		{
			try
			{
				feature = readFeatureDeclaration(efs);
			}
			catch (Exception e)
			{
				efs.close();
				return ErrorCodes.EIL_ERROR_IN_FEATURE_DECLARATION;
			}
			
			m_featureList.add(feature);
			
			if ( efs.hasNextInt() == false )
			{
				efs.close();
				return ErrorCodes.EIL_ERROR_NO_COMMANDS;
			}
			code = efs.nextInt();
		}
		
		// then read the constraint declarations (if there are any)
		while ( code == Codes.DECLARATION_CONSTRAINT )
		{
			try
			{
				constraint = readCrossTreeConstraintDeclaration(efs);
			}
			catch (Exception e)
			{
				efs.close();
				return ErrorCodes.EIL_ERROR_IN_CONSTRAINT_DECLARATION;
			}

			m_constraintList.add(constraint);
			
			if ( efs.hasNextInt() == false )
			{
				efs.close();
				return ErrorCodes.EIL_ERROR_NO_COMMANDS;
			}
			code = efs.nextInt();
		}
		
		// finally read the commands
		while ( true )
		{
			switch ( code )
			{
				case Codes.COMMAND_ADD_F:
					try
					{
						cmd = readAddAFeatureCmd(efs);
					}
					catch (Exception e)
					{
						efs.close();
						return ErrorCodes.EIL_ERROR_IN_ADDFEATURE_CMD;
					}
					break;
					
				case Codes.COMMAND_UPDATE_F:
					try
					{
						cmd = readUpdateAFeatureCmd(efs);
					}
					catch (Exception e)
					{
						efs.close();
						return ErrorCodes.EIL_ERROR_IN_UPDATEFEATURE_CMD;
					}
					break;
					
				case Codes.COMMAND_UPDATEALL_F:
					try
					{
						cmd = readUpdateMultipleFeaturesCmd(efs);
					}
					catch (Exception e)
					{
						efs.close();
						return ErrorCodes.EIL_ERROR_IN_UPDATEMULTFEATURES_CMD;
					}
					break;
					
				case Codes.COMMAND_REMOVE_F:
					try
					{
						cmd = readRemoveAFeatureCmd(efs);
					}
					catch (Exception e)
					{
						efs.close();
						return ErrorCodes.EIL_ERROR_IN_REMOVEFEATURE_CMD;
					}
					break;
					
				case Codes.COMMAND_REMOVEALL_F:
					try
					{
						cmd = readRemoveMultipleFeaturesCmd(efs);
					}
					catch (Exception e)
					{
						efs.close();
						return ErrorCodes.EIL_ERROR_IN_REMOVEMULTFEATURES_CMD;
					}
					break;
					
				case Codes.COMMAND_ADD_C:
					try
					{
						cmd = readAddAConstraintCmd(efs);
					}
					catch (Exception e)
					{
						efs.close();
						return ErrorCodes.EIL_ERROR_IN_ADDCONSTRAINT_CMD;
					}
					break;
					
				case Codes.COMMAND_UPDATE_C:
					try
					{
						cmd = readUpdateAConstraintCmd(efs);
					}
					catch (Exception e)
					{
						efs.close();
						return ErrorCodes.EIL_ERROR_IN_UPDATECONSTRAINT_CMD;
					}
					break;
					
				case Codes.COMMAND_UPDATEALL_C:
					try
					{
						cmd = readUpdateMultipleConstraintsCmd(efs);
					}
					catch (Exception e)
					{
						efs.close();
						return ErrorCodes.EIL_ERROR_IN_UPDATEMULTCONSTRAINTS_CMD;
					}
					break;
					
				case Codes.COMMAND_REMOVE_C:
					try
					{
						cmd = readRemoveAConstraintCmd(efs);
					}
					catch (Exception e)
					{
						efs.close();
						return ErrorCodes.EIL_ERROR_IN_REMOVECONSTRAINT_CMD;
					}
					break;
					
				case Codes.COMMAND_REMOVEALL_C:
					try
					{
						cmd = readRemoveMultipleConstraintsCmd(efs);
					}
					catch (Exception e)
					{
						efs.close();
						return ErrorCodes.EIL_ERROR_IN_REMOVEMULTCONSTRAINTS_CMD;
					}
					break;
					
				default:
					efs.close();
					return ErrorCodes.EIL_ERROR_INVALID_COMMAND;
			}

			m_commandList.add(cmd);
			
			if ( efs.hasNextInt() == false )
			{
				break;
			}
			
			code = efs.nextInt();
		}
		
		
		efs.close();
		return ErrorCodes.NO_ERROR;
	}

	
 	private RawFeature readRootFeatureDeclaration(Scanner efs)
	{
		RawFeature feature = new RawFeature();

		feature._name = readAString(efs);
			
		feature.attributes = new ArrayList<Attribute>();
		Attribute attr;
		int code = efs.nextInt();
		while ( code == 5 )
		{
			attr = new Attribute();
			attr.name = efs.next();
			attr.type = efs.nextInt();
			switch ( attr.type )
			{
				case Codes.TYPE_INT: 
					attr.intval = efs.nextInt();
					break;
				
				case Codes.TYPE_REAL: 
					attr.realval = efs.nextDouble();
					break;
				
				case Codes.TYPE_BOOL: 
					int blval = efs.nextInt();
					attr.boolval = blval == Codes.TRUE ? true : false;
					break;
					
				case Codes.TYPE_STRING: 
					attr.stringval = readAString(efs);
					break;
			}
			
			feature.attributes.add(attr);
			code = efs.nextInt();
		}
		
		return feature;
	}
	
	private RawFeature readFeatureDeclaration(Scanner efs)
	{
		RawFeature feature = new RawFeature();

		feature._name = readAString(efs);
		
		feature._parent = readAString(efs);
		
		feature._decomp = efs.nextInt();
		if ( feature._decomp == Codes.ALTERNATIVE || feature._decomp == Codes.OR )
		{
			feature.relSibling = readAString(efs);
		}
		
		feature.attributes = new ArrayList<Attribute>();
		Attribute attr;
		int code = efs.nextInt();
		while ( code == 5 )
		{
			attr = new Attribute();
			attr.name = efs.next();
			attr.type = efs.nextInt();
			switch ( attr.type )
			{
				case Codes.TYPE_INT: 
					attr.intval = efs.nextInt();
					break;
				
				case Codes.TYPE_REAL: 
					attr.realval = efs.nextDouble();
					break;
				
				case Codes.TYPE_BOOL: 
					int blval = efs.nextInt();
					attr.boolval = blval == Codes.TRUE ? true : false;
					break;
					
				case Codes.TYPE_STRING: 
					attr.stringval = readAString(efs);
					break;
			}
			
			feature.attributes.add(attr);
			code = efs.nextInt();
		}
		
		return feature;
	}
	
	private RawCrossTreeConstraint readCrossTreeConstraintDeclaration(Scanner efs)
	{
		RawCrossTreeConstraint constraint = new RawCrossTreeConstraint();
		
		constraint.leftFeature = readAString(efs);
		constraint.constraintType = efs.nextInt();
		constraint.rightFeature = readAString(efs);
		
		efs.nextInt();
		
		return constraint;
	}

	
	private AddAFeatureCmd readAddAFeatureCmd(Scanner efs)
	{
		AddAFeatureCmd cmd = new AddAFeatureCmd();
		
		cmd.type = Codes.COMMAND_ADD_F;
		
		cmd.featureName = readAString(efs);

		cmd.settingLoc    = null;
		cmd.settingDecomp = null;
		
		int tmp;
		int code = efs.nextInt();
		while ( code == Codes.UPDATE_LOCATION || code == Codes.UPDATE_DECOMPOSITION )
		{
			switch ( code )
			{
				case Codes.UPDATE_LOCATION:
					cmd.settingLoc = new SettingLocation();
					tmp = efs.nextInt();
					if ( tmp == Codes.FEATDESC_FEATURE )
					{
						cmd.settingLoc.varUsed = false;
						cmd.settingLoc.featureName = readAString(efs);
						
					}
					else
					{
						cmd.settingLoc.varUsed = true;
						cmd.settingLoc.featureVar = efs.next();
					}
					break;
					
				case Codes.UPDATE_DECOMPOSITION:
					cmd.settingDecomp = new SettingDecomposition();
					cmd.settingDecomp.newDecompType = efs.nextInt();
					if ( cmd.settingDecomp.newDecompType == Codes.ALTERNATIVE || 
						 cmd.settingDecomp.newDecompType == Codes.OR             )
					{
						tmp = efs.nextInt();
						if ( tmp == Codes.DECOMPRELTOEXISTS )
						{
							cmd.settingDecomp.firstFeatDescExists = true;
							tmp = efs.nextInt();
							if ( tmp == Codes.FEATDESC_FEATURE )
							{
								cmd.settingDecomp.firstVarUsed = false;
								cmd.settingDecomp.firstFeatureName = readAString(efs);
								
							}
							else
							{
								cmd.settingDecomp.firstVarUsed = true;
								cmd.settingDecomp.firstFeatureVar = efs.next();
							}
						}
						else
						{
							cmd.settingDecomp.firstFeatDescExists = false;
						}
					}
					else if ( cmd.settingDecomp.newDecompType == Codes.TOBERESOLVED )
					{
						cmd.settingDecomp.firstFeatDescExists = true;
						tmp = efs.nextInt();
						if ( tmp == Codes.FEATDESC_FEATURE )
						{
							cmd.settingDecomp.firstVarUsed = false;
							cmd.settingDecomp.firstFeatureName = readAString(efs);
							
						}
						else
						{
							cmd.settingDecomp.firstVarUsed = true;
							cmd.settingDecomp.firstFeatureVar = efs.next();
						}
						
						tmp = efs.nextInt();
						if ( tmp == Codes.DECOMPRELTOEXISTS )
						{
							cmd.settingDecomp.secondFeatDescExists = true;
							tmp = efs.nextInt();
							if ( tmp == Codes.FEATDESC_FEATURE )
							{
								cmd.settingDecomp.secondVarUsed = false;
								cmd.settingDecomp.secondFeatureName = readAString(efs);
								
							}
							else
							{
								cmd.settingDecomp.secondVarUsed = true;
								cmd.settingDecomp.secondFeatureVar = efs.next();
							}
						}
						else
						{
							cmd.settingDecomp.secondFeatDescExists = false;
						}
					}
					break;
			}
			
			code = efs.nextInt();
		}
		
		cmd.otherAttrs = new ArrayList<OtherAttribute>();
		OtherAttribute oa;
		while ( code == Codes.OTHERATTR )
		{
			oa = new OtherAttribute();
			oa.name = efs.next();
			oa.type = efs.nextInt();
			
			switch ( oa.type )
			{
				case Codes.ATTRVAL_INHERITED:
					oa.featDesc = new FeatureDescription();
					tmp = efs.nextInt();
					if ( tmp == Codes.FEATDESC_FEATURE )
					{
						oa.featDesc.varUsed = false;
						oa.featDesc.featureName = readAString(efs);
						
					}
					else
					{
						oa.featDesc.varUsed = true;
						oa.featDesc.featureVar = efs.next();
					}
					oa.featAttrName = efs.next();
					efs.nextInt(); // consume -5
					break;
					
				case Codes.ATTRVAL_ARITHEXP:
					oa.arithExp = readAnExpression(efs, Codes.END_OTHERATTR);
					break;
					
				case Codes.ATTRVAL_BOOLEXP:
					oa.boolExp = readAnExpression(efs, Codes.END_OTHERATTR);
					break;
					
				case Codes.ATTRVAL_STRING:
					oa.stringval = readAString(efs);
					efs.nextInt(); // consume -5
					break;
			}
			
			cmd.otherAttrs.add(oa);
			
			code = efs.nextInt();
		}
		
		
		if ( code == Codes.WHERE_CLAUSE )
		{
			cmd.whereClause = readAnExpression(efs, Codes.END_WHERECLAUSE);
			efs.nextInt();
		}
		else
		{
			cmd.whereClause = new ArrayList<ASTNode>();
		}
		
		return cmd;
	}
	
	private UpdateAFeatureCmd readUpdateAFeatureCmd(Scanner efs)
	{
		UpdateAFeatureCmd cmd = new UpdateAFeatureCmd();
		
		cmd.type = Codes.COMMAND_UPDATE_F;
		
		cmd.featDesc = new FeatureDescription();
		int code = efs.nextInt();
		if ( code == Codes.FEATDESC_FEATURE )
		{
			cmd.featDesc.varUsed = false;
			cmd.featDesc.featureName = readAString(efs);
		}
		else
		{
			cmd.featDesc.varUsed = true;
			cmd.featDesc.featureVar = efs.next();
		}
		
		cmd.settingName   = null;
		cmd.settingLoc    = null;
		cmd.settingDecomp = null;
		
		cmd.settingAttrs = new ArrayList<OtherAttribute>();
		
		int tmp;
		OtherAttribute oa;
		code = efs.nextInt();
		while ( code == Codes.UPDATE_NAME || code == Codes.UPDATE_LOCATION || code == Codes.UPDATE_DECOMPOSITION || code == Codes.OTHERATTR )
		{
			switch ( code )
			{
				case Codes.UPDATE_NAME:
					cmd.settingName = readAString(efs);
					break;
					
				case Codes.UPDATE_LOCATION:
					cmd.settingLoc = new SettingLocation();
					tmp = efs.nextInt();
					if ( tmp == Codes.FEATDESC_FEATURE )
					{
						cmd.settingLoc.varUsed = false;
						cmd.settingLoc.featureName = readAString(efs);
					}
					else
					{
						cmd.settingLoc.varUsed = true;
						cmd.settingLoc.featureVar = efs.next();
					}
					break;
					
				case Codes.UPDATE_DECOMPOSITION:
					cmd.settingDecomp = new SettingDecomposition();
					cmd.settingDecomp.newDecompType = efs.nextInt();
					if ( cmd.settingDecomp.newDecompType == Codes.ALTERNATIVE || 
						 cmd.settingDecomp.newDecompType == Codes.OR             )
					{
						tmp = efs.nextInt();
						if ( tmp == Codes.DECOMPRELTOEXISTS )
						{
							cmd.settingDecomp.firstFeatDescExists = true;
							tmp = efs.nextInt();
							if ( tmp == Codes.FEATDESC_FEATURE )
							{
								cmd.settingDecomp.firstVarUsed = false;
								cmd.settingDecomp.firstFeatureName = readAString(efs);
							}
							else
							{
								cmd.settingDecomp.firstVarUsed = true;
								cmd.settingDecomp.firstFeatureVar = efs.next();
							}
						}
						else
						{
							cmd.settingDecomp.firstFeatDescExists = false;
						}
					}
					else if ( cmd.settingDecomp.newDecompType == Codes.TOBERESOLVED )
					{
						cmd.settingDecomp.firstFeatDescExists = true;
						tmp = efs.nextInt();
						if ( tmp == Codes.FEATDESC_FEATURE )
						{
							cmd.settingDecomp.firstVarUsed = false;
							cmd.settingDecomp.firstFeatureName = readAString(efs);
						}
						else
						{
							cmd.settingDecomp.firstVarUsed = true;
							cmd.settingDecomp.firstFeatureVar = efs.next();
						}
						
						tmp = efs.nextInt();
						if ( tmp == Codes.DECOMPRELTOEXISTS )
						{
							cmd.settingDecomp.secondFeatDescExists = true;
							tmp = efs.nextInt();
							if ( tmp == Codes.FEATDESC_FEATURE )
							{
								cmd.settingDecomp.secondVarUsed = false;
								cmd.settingDecomp.secondFeatureName = readAString(efs);
							}
							else
							{
								cmd.settingDecomp.secondVarUsed = true;
								cmd.settingDecomp.secondFeatureVar = efs.next();
							}
						}
						else
						{
							cmd.settingDecomp.secondFeatDescExists = false;
						}
					}
					break;
					
				case Codes.OTHERATTR:
					oa = new OtherAttribute();
					oa.name = efs.next();
					oa.type = efs.nextInt();
					
					switch ( oa.type )
					{
						case Codes.ATTRVAL_INHERITED:
							oa.featDesc = new FeatureDescription();
							tmp = efs.nextInt();
							if ( tmp == Codes.FEATDESC_FEATURE )
							{
								oa.featDesc.varUsed = false;
								oa.featDesc.featureName = readAString(efs);
								
							}
							else
							{
								oa.featDesc.varUsed = true;
								oa.featDesc.featureVar = efs.next();
							}
							oa.featAttrName = efs.next();
							efs.nextInt(); // consume -5
							break;
							
						case Codes.ATTRVAL_ARITHEXP:
							oa.arithExp = readAnExpression(efs, Codes.END_OTHERATTR);
							break;
							
						case Codes.ATTRVAL_BOOLEXP:
							oa.boolExp = readAnExpression(efs, Codes.END_OTHERATTR);
							break;
							
						case Codes.ATTRVAL_STRING:
							oa.stringval = readAString(efs);
							efs.nextInt(); // consume -5
							break;
					}
					
					cmd.settingAttrs.add(oa);
					break;
			}
			
			code = efs.nextInt();
		}
		
		
		if ( code == Codes.WHERE_CLAUSE )
		{
			cmd.whereClause = readAnExpression(efs, Codes.END_WHERECLAUSE);
			efs.nextInt();
		}
		else
		{
			cmd.whereClause = new ArrayList<ASTNode>();
		}
		
		return cmd;
	}
	
	private UpdateMultipleFeaturesCmd readUpdateMultipleFeaturesCmd(Scanner efs)
	{
		UpdateMultipleFeaturesCmd cmd = new UpdateMultipleFeaturesCmd();
		
		cmd.type = Codes.COMMAND_UPDATEALL_F;
		
		cmd.featureVar = efs.next();
		
		cmd.settingLoc    = null;
		cmd.settingDecomp = null;
		
		cmd.settingAttrs = new ArrayList<OtherAttribute>();
		
		int tmp;
		int code = efs.nextInt();
		OtherAttribute oa;
		while ( code == Codes.UPDATE_LOCATION || code == Codes.UPDATE_DECOMPOSITION || code == Codes.OTHERATTR )
		{
			switch ( code )
			{
				case Codes.UPDATE_LOCATION:
					cmd.settingLoc = new SettingLocation();
					tmp = efs.nextInt();
					if ( tmp == Codes.FEATDESC_FEATURE )
					{
						cmd.settingLoc.varUsed = false;
						cmd.settingLoc.featureName = readAString(efs);
					}
					else
					{
						cmd.settingLoc.varUsed = true;
						cmd.settingLoc.featureVar = efs.next();
					}
					break;
					
				case Codes.UPDATE_DECOMPOSITION:
					cmd.settingDecomp = new SettingDecomposition();
					cmd.settingDecomp.newDecompType = efs.nextInt();
					if ( cmd.settingDecomp.newDecompType == Codes.ALTERNATIVE || 
						 cmd.settingDecomp.newDecompType == Codes.OR             )
					{
						tmp = efs.nextInt();
						if ( tmp == Codes.DECOMPRELTOEXISTS )
						{
							cmd.settingDecomp.firstFeatDescExists = true;
							tmp = efs.nextInt();
							if ( tmp == Codes.FEATDESC_FEATURE )
							{
								cmd.settingDecomp.firstVarUsed = false;
								cmd.settingDecomp.firstFeatureName = readAString(efs);
							}
							else
							{
								cmd.settingDecomp.firstVarUsed = true;
								cmd.settingDecomp.firstFeatureVar = efs.next();
							}
						}
						else
						{
							cmd.settingDecomp.firstFeatDescExists = false;
						}
					}
					else if ( cmd.settingDecomp.newDecompType == Codes.TOBERESOLVED )
					{
						cmd.settingDecomp.firstFeatDescExists = true;
						tmp = efs.nextInt();
						if ( tmp == Codes.FEATDESC_FEATURE )
						{
							cmd.settingDecomp.firstVarUsed = false;
							cmd.settingDecomp.firstFeatureName = readAString(efs);
						}
						else
						{
							cmd.settingDecomp.firstVarUsed = true;
							cmd.settingDecomp.firstFeatureVar = efs.next();
						}
						
						tmp = efs.nextInt();
						if ( tmp == Codes.DECOMPRELTOEXISTS )
						{
							cmd.settingDecomp.secondFeatDescExists = true;
							tmp = efs.nextInt();
							if ( tmp == Codes.FEATDESC_FEATURE )
							{
								cmd.settingDecomp.secondVarUsed = false;
								cmd.settingDecomp.secondFeatureName = readAString(efs);
							}
							else
							{
								cmd.settingDecomp.secondVarUsed = true;
								cmd.settingDecomp.secondFeatureVar = efs.next();
							}
						}
						else
						{
							cmd.settingDecomp.secondFeatDescExists = false;
						}
					}
					break;
					
				case Codes.OTHERATTR:
					oa = new OtherAttribute();
					oa.name = efs.next();
					oa.type = efs.nextInt();
					
					switch ( oa.type )
					{
						case Codes.ATTRVAL_INHERITED:
							oa.featDesc = new FeatureDescription();
							tmp = efs.nextInt();
							if ( tmp == Codes.FEATDESC_FEATURE )
							{
								oa.featDesc.varUsed = false;
								oa.featDesc.featureName = readAString(efs);
								
							}
							else
							{
								oa.featDesc.varUsed = true;
								oa.featDesc.featureVar = efs.next();
							}
							oa.featAttrName = efs.next();
							efs.nextInt(); // consume -5
							break;
							
						case Codes.ATTRVAL_ARITHEXP:
							oa.arithExp = readAnExpression(efs, Codes.END_OTHERATTR);
							break;
							
						case Codes.ATTRVAL_BOOLEXP:
							oa.boolExp = readAnExpression(efs, Codes.END_OTHERATTR);
							break;
							
						case Codes.ATTRVAL_STRING:
							oa.stringval = readAString(efs);
							efs.nextInt(); // consume -5
							break;
					}
					
					cmd.settingAttrs.add(oa);
					break;
			}
			
			code = efs.nextInt();
		}
		
		
		if ( code == Codes.WHERE_CLAUSE )
		{
			cmd.whereClause = readAnExpression(efs, Codes.END_WHERECLAUSE);
			efs.nextInt();
		}
		else
		{
			cmd.whereClause = new ArrayList<ASTNode>();
		}
		
		return cmd;
	}

	private RemoveAFeatureCmd readRemoveAFeatureCmd(Scanner efs)
	{
		RemoveAFeatureCmd cmd = new RemoveAFeatureCmd();
		
		cmd.type = Codes.COMMAND_REMOVE_F;
		
		cmd.featDesc = new FeatureDescription();
		int code = efs.nextInt();
		if ( code == Codes.FEATDESC_FEATURE )
		{
			cmd.featDesc.varUsed = false;
			cmd.featDesc.featureName = readAString(efs);
		}
		else
		{
			cmd.featDesc.varUsed = true;
			cmd.featDesc.featureVar = efs.next();
		}
		
		code = efs.nextInt();
		if ( code == Codes.WHERE_CLAUSE )
		{
			cmd.whereClause = readAnExpression(efs, Codes.END_WHERECLAUSE);
			efs.nextInt();
		}
		else
		{
			cmd.whereClause = new ArrayList<ASTNode>();
		}
		
		return cmd;
	}
	
	private RemoveMultipleFeaturesCmd readRemoveMultipleFeaturesCmd(Scanner efs)
	{
		RemoveMultipleFeaturesCmd cmd = new RemoveMultipleFeaturesCmd();
		
		cmd.type = Codes.COMMAND_REMOVEALL_F;
		cmd.featureVar = efs.next();
		
		int code = efs.nextInt();
		if ( code == Codes.WHERE_CLAUSE )
		{
			cmd.whereClause = readAnExpression(efs, Codes.END_WHERECLAUSE);
			efs.nextInt();
		}
		else
		{
			cmd.whereClause = new ArrayList<ASTNode>();
		}
		
		return cmd;
	}
	
	private AddAConstraintCmd readAddAConstraintCmd(Scanner efs)
	{
		AddAConstraintCmd cmd = new AddAConstraintCmd();
		cmd.constDesc = new ConstraintDescription();
		
		cmd.type = Codes.COMMAND_ADD_C;
		
		int code = efs.nextInt();
		if ( code == Codes.FEATDESC_FEATURE )
		{
			cmd.constDesc.leftIsVar = false;
			cmd.constDesc.leftFeatureName = readAString(efs);
		}
		else
		{
			cmd.constDesc.leftIsVar = true;
			cmd.constDesc.leftFeatureVar = efs.next();
		}
		
		cmd.constDesc.constraint = efs.nextInt();
		
		code = efs.nextInt();
		if ( code == Codes.FEATDESC_FEATURE )
		{
			cmd.constDesc.rightIsVar = false;
			cmd.constDesc.rightFeatureName = readAString(efs);
		}
		else
		{
			cmd.constDesc.rightIsVar = true;
			cmd.constDesc.rightFeatureVar = efs.next();
		}
		
		code = efs.nextInt();
		if ( code == Codes.WHERE_CLAUSE )
		{
			cmd.whereClause = readAnExpression(efs, Codes.END_WHERECLAUSE);
			efs.nextInt();
		}
		else
		{
			cmd.whereClause = new ArrayList<ASTNode>();
		}
		
		return cmd;
	}
	
	private UpdateAConstraintCmd readUpdateAConstraintCmd(Scanner efs)
	{
		UpdateAConstraintCmd cmd = new UpdateAConstraintCmd();
		cmd.constDesc = new ConstraintDescription();
		
		cmd.type = Codes.COMMAND_UPDATE_C;
		
		int code = efs.nextInt();
		if ( code == Codes.FEATDESC_FEATURE )
		{
			cmd.constDesc.leftIsVar = false;
			cmd.constDesc.leftFeatureName = readAString(efs);
		}
		else
		{
			cmd.constDesc.leftIsVar = true;
			cmd.constDesc.leftFeatureVar = efs.next();
		}
		
		cmd.constDesc.constraint = efs.nextInt();
		
		code = efs.nextInt();
		if ( code == Codes.FEATDESC_FEATURE )
		{
			cmd.constDesc.rightIsVar = false;
			cmd.constDesc.rightFeatureName = readAString(efs);
		}
		else
		{
			cmd.constDesc.rightIsVar = true;
			cmd.constDesc.rightFeatureVar = efs.next();
		}
		
		cmd.leftUpdate  = null;
		cmd.typeUpdate  = Codes._NO_VALUE_;
		cmd.rightUpdate = null;
		code = efs.nextInt();
		int tmp;
		while ( code == Codes.UPDATE_LEFTF || code == Codes.UPDATE_CTYPE || code == Codes.UPDATE_RIGHTF )
		{
			switch ( code )
			{
				case Codes.UPDATE_LEFTF:
					cmd.leftUpdate = new FeatureDescription();
					tmp = efs.nextInt();
					if ( tmp == Codes.FEATDESC_FEATURE )
					{
						cmd.leftUpdate.varUsed = false;
						cmd.leftUpdate.featureName = readAString(efs);
					}
					else
					{
						cmd.leftUpdate.varUsed = true;
						cmd.leftUpdate.featureVar = efs.next();
					}
					break;
				
				case Codes.UPDATE_CTYPE:
					cmd.typeUpdate = efs.nextInt();
					break;
					
				case Codes.UPDATE_RIGHTF:
					cmd.rightUpdate = new FeatureDescription();
					tmp = efs.nextInt();
					if ( tmp == Codes.FEATDESC_FEATURE )
					{
						cmd.rightUpdate.varUsed = false;
						cmd.rightUpdate.featureName = readAString(efs);
					}
					else
					{
						cmd.rightUpdate.varUsed = true;
						cmd.rightUpdate.featureVar = efs.next();
					}
					break;
			}
			
			code = efs.nextInt();
		}
		
		if ( code == Codes.WHERE_CLAUSE )
		{
			cmd.whereClause = readAnExpression(efs, Codes.END_WHERECLAUSE);
			efs.nextInt();
		}
		else
		{
			cmd.whereClause = new ArrayList<ASTNode>();
		}
		
		return cmd;
	}
	
	private UpdateMultipleConstraintsCmd readUpdateMultipleConstraintsCmd(Scanner efs)
	{
		UpdateMultipleConstraintsCmd cmd = new UpdateMultipleConstraintsCmd();
		cmd.constDesc = new ConstraintDescription();
		
		cmd.type = Codes.COMMAND_UPDATEALL_C;
		
		int code = efs.nextInt();
		if ( code == Codes.FEATDESC_FEATURE )
		{
			cmd.constDesc.leftIsVar = false;
			cmd.constDesc.leftFeatureName = readAString(efs);
		}
		else
		{
			cmd.constDesc.leftIsVar = true;
			cmd.constDesc.leftFeatureVar = efs.next();
		}
		
		cmd.constDesc.constraint = efs.nextInt();
		
		code = efs.nextInt();
		if ( code == Codes.FEATDESC_FEATURE )
		{
			cmd.constDesc.rightIsVar = false;
			cmd.constDesc.rightFeatureName = readAString(efs);
		}
		else
		{
			cmd.constDesc.rightIsVar = true;
			cmd.constDesc.rightFeatureVar = efs.next();
		}
		
		cmd.leftUpdate  = null;
		cmd.typeUpdate  = Codes._NO_VALUE_;
		cmd.rightUpdate = null;
		code = efs.nextInt();
		int tmp;
		while ( code == Codes.UPDATE_LEFTF || code == Codes.UPDATE_CTYPE || code == Codes.UPDATE_RIGHTF )
		{
			switch ( code )
			{
				case Codes.UPDATE_LEFTF:
					cmd.leftUpdate = new FeatureDescription();
					tmp = efs.nextInt();
					if ( tmp == Codes.FEATDESC_FEATURE )
					{
						cmd.leftUpdate.varUsed = false;
						cmd.leftUpdate.featureName = readAString(efs);
					}
					else
					{
						cmd.leftUpdate.varUsed = true;
						cmd.leftUpdate.featureVar = efs.next();
					}
					break;
				
				case Codes.UPDATE_CTYPE:
					cmd.typeUpdate = efs.nextInt();
					break;
					
				case Codes.UPDATE_RIGHTF:
					cmd.rightUpdate = new FeatureDescription();
					tmp = efs.nextInt();
					if ( tmp == Codes.FEATDESC_FEATURE )
					{
						cmd.rightUpdate.varUsed = false;
						cmd.rightUpdate.featureName = readAString(efs);
					}
					else
					{
						cmd.rightUpdate.varUsed = true;
						cmd.rightUpdate.featureVar = efs.next();
					}
					break;
			}
			
			code = efs.nextInt();
		}
		
		if ( code == Codes.WHERE_CLAUSE )
		{
			cmd.whereClause = readAnExpression(efs, Codes.END_WHERECLAUSE);
			efs.nextInt();
		}
		else
		{
			cmd.whereClause = new ArrayList<ASTNode>();
		}
		
		return cmd;
	}
	
	private RemoveAConstraintCmd readRemoveAConstraintCmd(Scanner efs)
	{
		RemoveAConstraintCmd cmd = new RemoveAConstraintCmd();
		cmd.constDesc = new ConstraintDescription();
		
		cmd.type = Codes.COMMAND_REMOVE_C;
		
		int code = efs.nextInt();
		if ( code == Codes.FEATDESC_FEATURE )
		{
			cmd.constDesc.leftIsVar = false;
			cmd.constDesc.leftFeatureName = readAString(efs);
		}
		else
		{
			cmd.constDesc.leftIsVar = true;
			cmd.constDesc.leftFeatureVar = efs.next();
		}
		
		cmd.constDesc.constraint = efs.nextInt();
		
		code = efs.nextInt();
		if ( code == Codes.FEATDESC_FEATURE )
		{
			cmd.constDesc.rightIsVar = false;
			cmd.constDesc.rightFeatureName = readAString(efs);
		}
		else
		{
			cmd.constDesc.rightIsVar = true;
			cmd.constDesc.rightFeatureVar = efs.next();
		}
		
		code = efs.nextInt();
		if ( code == Codes.WHERE_CLAUSE )
		{
			cmd.whereClause = readAnExpression(efs, Codes.END_WHERECLAUSE);
			efs.nextInt();
		}
		else
		{
			cmd.whereClause = new ArrayList<ASTNode>();
		}
		
		return cmd;
	}
	
	private RemoveMultipleConstraintsCmd readRemoveMultipleConstraintsCmd(Scanner efs)
	{
		RemoveMultipleConstraintsCmd cmd = new RemoveMultipleConstraintsCmd();
		cmd.constDesc = new ConstraintDescription();
		
		cmd.type = Codes.COMMAND_REMOVEALL_C;
		
		int code = efs.nextInt();
		if ( code == Codes.FEATDESC_FEATURE )
		{
			cmd.constDesc.leftIsVar = false;
			cmd.constDesc.leftFeatureName = readAString(efs);
		}
		else
		{
			cmd.constDesc.leftIsVar = true;
			cmd.constDesc.leftFeatureVar = efs.next();
		}
		
		cmd.constDesc.constraint = efs.nextInt();
		
		code = efs.nextInt();
		if ( code == Codes.FEATDESC_FEATURE )
		{
			cmd.constDesc.rightIsVar = false;
			cmd.constDesc.rightFeatureName = readAString(efs);
		}
		else
		{
			cmd.constDesc.rightIsVar = true;
			cmd.constDesc.rightFeatureVar = efs.next();
		}
		
		code = efs.nextInt();
		if ( code == Codes.WHERE_CLAUSE )
		{
			cmd.whereClause = readAnExpression(efs, Codes.END_WHERECLAUSE);
			efs.nextInt();
		}
		else
		{
			cmd.whereClause = new ArrayList<ASTNode>();
		}
		
		return cmd;
	}
	
	
	private ArrayList<ASTNode> readAnExpression(Scanner efs, int endMarker)
	{
		ArrayList<ASTNode> astList = new ArrayList<ASTNode>();
		ASTNode node;
		int code, tmp, i;
		
		while ( efs.hasNextInt() )
		{
			code = efs.nextInt();
			if ( code == endMarker )
			{
				break;
			}
			
			switch ( code )
			{
				case 0: // operator
					node = new ASTNode();
					node.type   = Codes.AST_TYPE_OPERATOR;
					node.opcode = efs.nextInt();
					astList.add(node);
					break;
				
				case 1: // integer literal
					node = new ASTNode();
					node.type   = Codes.AST_TYPE_INT;
					node.intval = efs.nextInt();
					astList.add(node);
					break;
					
				case 2: // real literal
					node = new ASTNode();
					node.type    = Codes.AST_TYPE_REAL;
					node.realval = efs.nextDouble();
					astList.add(node);
					break;
					
				case 3: // bool literal
					node = new ASTNode();
					node.type = Codes.AST_TYPE_BOOL;
					tmp = efs.nextInt();
					node.boolval = ( tmp == Codes.TRUE ? true : false );
					astList.add(node);
					break;
					
				case 5: // feature description . attribute name
					node = new ASTNode();
					tmp = efs.nextInt();
					if ( tmp == Codes.FEATDESC_FEATURE )
					{
						node.type = Codes.AST_TYPE_FEATURE;
						node.featureName = readAString(efs);
						node.attrName = efs.next();
						astList.add(node);
					}
					else
					{
						node.type = Codes.AST_TYPE_FEATUREVAR;
						node.featureVar = efs.next();
						node.attrName = efs.next();
						astList.add(node);
					}
					break;
					
				case 6: // string equality check
					for (i=1; i<=2; i++)
					{
						node = new ASTNode();
						tmp = efs.nextInt();
						switch ( tmp )
						{
							case Codes.STRINGOP_LITERAL:
								node.type = Codes.AST_TYPE_STRING;
								node.stringval = readAString(efs);
								astList.add(node);
								break;
								
							case Codes.STRINGOP_FNAME:
								tmp = efs.nextInt();
								if ( tmp == Codes.FEATDESC_FEATURE )
								{
									node.type = Codes.AST_TYPE_FEATURE;
									node.featureName = readAString(efs);
									node.attrName = "_name";
									astList.add(node);
								}
								else
								{
									node.type = Codes.AST_TYPE_FEATUREVAR;
									node.featureVar = efs.next();
									node.attrName = "_name";
									astList.add(node);
								}
								break;
								
							case Codes.STRINGOP_FPARENT:
								tmp = efs.nextInt();
								if ( tmp == Codes.FEATDESC_FEATURE )
								{
									node.type = Codes.AST_TYPE_FEATURE;
									node.featureName = readAString(efs);
									node.attrName = "_parent";
									astList.add(node);
								}
								else
								{
									node.type = Codes.AST_TYPE_FEATUREVAR;
									node.featureVar = efs.next();
									node.attrName = "_parent";
									astList.add(node);
								}
								break;
								
							case Codes.FEATUREDESCRIPTION:
								tmp = efs.nextInt();
								if ( tmp == Codes.FEATDESC_FEATURE )
								{
									node.type = Codes.AST_TYPE_FEATURE;
									node.featureName = readAString(efs);
									node.attrName = efs.next();
									astList.add(node);
								}
								else
								{
									node.type = Codes.AST_TYPE_FEATUREVAR;
									node.featureVar = efs.next();
									node.attrName = efs.next();
									astList.add(node);
								}
								break;
						}
					}
					break;
					
				case 7: // decomp rel type check
					for (i=1; i<=2; i++)
					{
						node = new ASTNode();
						tmp = efs.nextInt();
						switch ( tmp )
						{
							case Codes.MANDATORY:
							case Codes.OPTIONAL:
							case Codes.ALTERNATIVE:
							case Codes.OR:
								node.type = Codes.AST_TYPE_DECRELTYPE;
								node.decRelTypeVal = tmp;
								astList.add(node);
								break;
								
							case Codes.FEATUREDESCRIPTION:
								tmp = efs.nextInt();
								if ( tmp == Codes.FEATDESC_FEATURE )
								{
									node.type = Codes.AST_TYPE_FEATURE;
									node.featureName = readAString(efs);
									node.attrName = "_decomp";
									astList.add(node);
								}
								else
								{
									node.type = Codes.AST_TYPE_FEATUREVAR;
									node.featureVar = efs.next();
									node.attrName = "_decomp";
									astList.add(node);
								}
								break;
						}
					}
					break;
					
				case 8: // decomp rel id check
					for (i=1; i<=2; i++)
					{
						node = new ASTNode();
						tmp = efs.nextInt();
						if ( tmp == Codes.FEATDESC_FEATURE )
						{
							node.type = Codes.AST_TYPE_FEATURE;
							node.featureName = readAString(efs);
							node.attrName = "_decompID";
							astList.add(node);
						}
						else
						{
							node.type = Codes.AST_TYPE_FEATUREVAR;
							node.featureVar = efs.next();
							node.attrName = "_decompID";
							astList.add(node);
						}
					}
					break;
					
				case 9: // arith exp arith exp operator
					// Do nothing, it will handle on the next iteration...
					break;
					
				case 10: // boolean equality check
					for (i=1; i<=2; i++)
					{
						node = new ASTNode();
						tmp = efs.nextInt();
						switch ( tmp )
						{
							case Codes.BOOLEQOP_LITERAL:
								node.type = Codes.AST_TYPE_BOOL;
								tmp = efs.nextInt();
								node.boolval = ( tmp == Codes.TRUE ? true : false );
								astList.add(node);
								break;
								
							case Codes.FEATUREDESCRIPTION:
								tmp = efs.nextInt();
								if ( tmp == Codes.FEATDESC_FEATURE )
								{
									node.type = Codes.AST_TYPE_FEATURE;
									node.featureName = readAString(efs);
									node.attrName = efs.next();
									astList.add(node);
								}
								else
								{
									node.type = Codes.AST_TYPE_FEATUREVAR;
									node.featureVar = efs.next();
									node.attrName = efs.next();
									astList.add(node);
								}
								break;
						}
					}
					break;
			}
		}
		
		return astList;
	}

	private String readAString(Scanner efs)
	{
		String ch, value;
		
		Pattern original = efs.delimiter();
		efs.useDelimiter("");
		
		do {
			ch = efs.next();
		} while ( !ch.equals("\"") );
		value = "";
		
		ch = efs.next();
		while ( !ch.equals("\"") )
		{
			value += ch;
			ch = efs.next();
		}
		
		efs.useDelimiter(original);
		return value;
	}
}

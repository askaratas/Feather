import java.util.ArrayList;


/** *******************************************************************************************
 * DATA TYPES
 * --------------------------------------------------------------------------------------------
 * @author Ahmet Serkan Karatas
 *
 ** ******************************************************************************************* */

class Command
{
	public int type;
	public ArrayList<ASTNode> whereClause;
}


class AddAFeatureCmd extends Command
{
	public String featureName;
	
	public SettingLocation settingLoc;
	public SettingDecomposition settingDecomp;
	
	public ArrayList<OtherAttribute> otherAttrs;
}


class UpdateAFeatureCmd extends Command
{
	public FeatureDescription featDesc;
	
	public String settingName;
	public SettingLocation settingLoc;
	public SettingDecomposition settingDecomp;
	
	public ArrayList<OtherAttribute> settingAttrs;
}


class UpdateMultipleFeaturesCmd extends Command
{
	public String featureVar;
	
	public SettingLocation settingLoc;
	public SettingDecomposition settingDecomp;
	
	public ArrayList<OtherAttribute> settingAttrs;
}


class RemoveAFeatureCmd extends Command
{
	public FeatureDescription featDesc;
}


class RemoveMultipleFeaturesCmd extends Command
{
	public String featureVar;
}


class AddAConstraintCmd extends Command
{
	public ConstraintDescription constDesc;
}


class UpdateAConstraintCmd extends Command
{
	public ConstraintDescription constDesc;
	
	public FeatureDescription leftUpdate;
	public int typeUpdate;
	public FeatureDescription rightUpdate;
}


class UpdateMultipleConstraintsCmd extends Command
{
	public ConstraintDescription constDesc;
	
	public FeatureDescription leftUpdate;
	public int typeUpdate;
	public FeatureDescription rightUpdate;
}


class RemoveAConstraintCmd extends Command
{
	public ConstraintDescription constDesc;
}


class RemoveMultipleConstraintsCmd extends Command
{
	public ConstraintDescription constDesc;
}


class CommandExecutionError
{
	public int errorCode;
	public String explanation;
}


class ASTNode
{
	public int type;
	public int opcode;
	public int intval;
	public double realval;
	public boolean boolval;
	public String stringval;
	public String featureName;
	public String featureVar;
	public String attrName;
	public int decRelTypeVal;
}


class FeatureDescription
{
	public boolean varUsed;
	public String featureVar;
	public String featureName;
}


class SettingLocation
{
	public boolean varUsed;
	public String featureVar;
	public String featureName;
}


class SettingDecomposition
{
	public int newDecompType;
	public boolean firstFeatDescExists;
	public boolean firstVarUsed;
	public String firstFeatureVar;
	public String firstFeatureName;
	public boolean secondFeatDescExists;
	public boolean secondVarUsed;
	public String secondFeatureVar;
	public String secondFeatureName;
}


class OtherAttribute
{
	public String name;
	public int type;
	
	public FeatureDescription featDesc;
	public String featAttrName;
	
	public ArrayList<ASTNode> arithExp;
	
	public ArrayList<ASTNode> boolExp;
	
	public String stringval;
}


class ConstraintDescription
{
	public boolean leftIsVar;
	public String leftFeatureVar;
	public String leftFeatureName;
	public int constraint;
	public boolean rightIsVar;
	public String rightFeatureVar;
	public String rightFeatureName;
}

class Feature
{
	public int idNo; 
	public String _name;
	public int _parentIDNo;
	public int _decomp;
	public int _decompID;
	public ArrayList<Attribute> attributes;
	public ArrayList<Feature> children;
	
	public Feature()
	{
		attributes = new ArrayList<Attribute>();
		children   = new ArrayList<Feature>();
	}
}


class Attribute
{
	public String name;
	public int type;
	public int intval;
	public double realval;
	public boolean boolval;
	public String stringval;
	
	@Override
	public Attribute clone()
	{
		Attribute tmp = new Attribute();
		tmp.name = name;
		tmp.type = type;
		tmp.intval = intval;
		tmp.realval = realval;
		tmp.boolval = boolval;
		tmp.stringval = stringval;
		return tmp;
	}
}


class CrossTreeConstraint
{
	public int leftIDNo;
	public String leftFeature;
	public int rightIDNo;
	public String rightFeature;
	public int constraintType;
	
	@Override
	public CrossTreeConstraint clone()
	{
		CrossTreeConstraint tmp = new CrossTreeConstraint();
		tmp.leftIDNo = leftIDNo;
		tmp.leftFeature = leftFeature;
		tmp.rightIDNo = rightIDNo;
		tmp.rightFeature = rightFeature;
		tmp.constraintType = constraintType;
		return tmp;
	}
}


class RawFeature
{
	public String _name;
	public String _parent;
	public int _decomp;
	public String relSibling;
	public ArrayList<Attribute> attributes;
}


class RawCrossTreeConstraint
{
	public String leftFeature;
	public String rightFeature;
	public int constraintType;
}


class DeclarationError
{
	public int errorCode;
	public RawFeature erronousFeature;
}

class UpdateFeatureError
{
	public int errorCode;
	public String erronousAttribute;
}

class FeatureVariable
{
	public String name;
	public ArrayList<VariableAttribute> otherAttributes;
	
	public FeatureVariable()
	{
		otherAttributes = new ArrayList<VariableAttribute>();
	}
}


class VariableAttribute
{
	public String name;
	public int assumedType;
}


class FeatureVarSolutionSet
{
	ArrayList<FeatureVariableResolution> resolutions;
	
	public FeatureVarSolutionSet()
	{
		resolutions = new ArrayList<FeatureVariableResolution>();
	}
}


class FeatureVariableResolution
{
	public String featureVar;
	public int featureIDNo;
}


class MustBeCompatibleFVars
{
	public String FVar1;
	public String VarAttr1;
	public String FVar2;
	public String VarAttr2;
}


class StringEnum
{
	public int no;
	public String strval;
}


class ConstraintSolverException extends Exception
{
	private static final long serialVersionUID = 2581167122424503923L;
	public int exceptionCode;
	public String message;
	
	public ConstraintSolverException(int code, String msg)
	{
		exceptionCode = code;
		message = msg;
	}
}


/** *******************************************************************************************
 * CONSTANTS
 * --------------------------------------------------------------------------------------------
 * @author Ahmet Serkan Karatas
 *
 ** ******************************************************************************************* */

class Codes
{
	public static final int _NO_VALUE_ = -1;
	
	public static final int DECLARATION_ROOT       = 1;
	public static final int DECLARATION_FEATURE    = 2;
	public static final int DECLARATION_CONSTRAINT = 3;
	
	public static final int COMMAND_ADD_F       = 10;
	public static final int COMMAND_UPDATE_F    = 11;
	public static final int COMMAND_UPDATEALL_F = 12;
	public static final int COMMAND_REMOVE_F    = 13;
	public static final int COMMAND_REMOVEALL_F = 14;
	public static final int COMMAND_ADD_C       = 15;
	public static final int COMMAND_UPDATE_C    = 16;
	public static final int COMMAND_UPDATEALL_C = 17;
	public static final int COMMAND_REMOVE_C    = 18;
	public static final int COMMAND_REMOVEALL_C = 19;
	
	public static final int WHERE_CLAUSE = 100;
	
	public static final int MANDATORY    = 1;
	public static final int OPTIONAL     = 2;
	public static final int ALTERNATIVE  = 3;
	public static final int OR           = 4;
	public static final int TOBERESOLVED = 5;
	
	public static final int TYPE_INT     = 1;
	public static final int TYPE_REAL    = 2;
	public static final int TYPE_BOOL    = 3;
	public static final int TYPE_STRING  = 4;
	
	
	public static final int AST_TYPE_OPERATOR   = 0;
	public static final int AST_TYPE_INT        = 1;
	public static final int AST_TYPE_REAL       = 2;
	public static final int AST_TYPE_BOOL       = 3;
	public static final int AST_TYPE_STRING     = 4;
	public static final int AST_TYPE_FEATURE    = 5;
	public static final int AST_TYPE_FEATUREVAR = 6;
	public static final int AST_TYPE_DECRELTYPE = 7;
	public static final int AST_TYPE_DECRELID   = 8;
	public static final int AST_TYPE_NUMERIC    = 12;
	public static final int AST_TYPE_MAPPED     = -999;
	
	public static final int ATTRVAL_INHERITED = 0;
	public static final int ATTRVAL_ARITHEXP  = 1;
	public static final int ATTRVAL_BOOLEXP   = 3;
	public static final int ATTRVAL_STRING    = 4;
	
	public static final int FALSE = 0;
	public static final int TRUE  = 1;
	
	public static final int REQUIRES = 1;
	public static final int EXCLUDES = 2;
	
	public static final int OP_ADD      = 11;
	public static final int OP_SUBTRACT = 12;
	public static final int OP_MULTIPLY = 13;
	public static final int OP_DIVIDE   = 14;
	public static final int OP_MODULUS  = 15;
	public static final int OP_UNMINUS  = 16;
	
	public static final int OP_LT  = 21;
	public static final int OP_LTE = 22;
	public static final int OP_GT  = 23;
	public static final int OP_GTE = 24;
	public static final int OP_EQ  = 25;
	public static final int OP_NEQ = 26;
	
	public static final int OP_AND = 31;
	public static final int OP_OR  = 32;
	public static final int OP_NOT = 33;
	
	public static final int FEATDESC_FEATURE  = 1;
	public static final int FEATDESC_VARIABLE = 2;
	
	public static final int STRINGOP_LITERAL  = 4;
	public static final int STRINGOP_FNAME    = 1;
	public static final int STRINGOP_FPARENT  = 2;
	
	public static final int BOOLEQOP_LITERAL  = 3;
	
	public static final int FEATUREDESCRIPTION = 5;
	
	public static final int UPDATE_NAME          = 1;
	public static final int UPDATE_LOCATION      = 2;
	public static final int UPDATE_DECOMPOSITION = 3;
	
	public static final int OTHERATTR = 5;
	
	public static final int UPDATE_LEFTF  = 1;
	public static final int UPDATE_CTYPE  = 2;
	public static final int UPDATE_RIGHTF = 3;
	
	public static final int DECOMPRELTOEXISTS  = 1;
	
	public static final int END_WHERECLAUSE = -100;
	public static final int END_OTHERATTR   = -5;
	
	public static final int FEATURE_IN_REQUIRES_LEFT  = 1;
	public static final int FEATURE_IN_REQUIRES_RIGHT = 2;
	public static final int FEATURE_IN_EXCLUDES       = 3;
	
	public static final int MODE_STOP_ON_WARNINGS = 1;
	public static final int MODE_STOP_ON_ERRORS   = 2;
	public static final int MODE_IGNORE_ALL       = 3;
}


class ErrorCodes
{
	public static final int NO_ERROR  = 0;
	
	public static final int EIL_ERROR_IN_FILE                      = -100;
	public static final int EIL_ERROR_NO_COMMANDS                  = -101;
	public static final int EIL_ERROR_INVALID_COMMAND              = -102;
	public static final int EIL_ERROR_IN_ROOT_DECLARATION          = -1;
	public static final int EIL_ERROR_IN_FEATURE_DECLARATION       = -2;
	public static final int EIL_ERROR_IN_CONSTRAINT_DECLARATION    = -3;
	public static final int EIL_ERROR_IN_ADDFEATURE_CMD            = -10;
	public static final int EIL_ERROR_IN_UPDATEFEATURE_CMD         = -11;
	public static final int EIL_ERROR_IN_UPDATEMULTFEATURES_CMD    = -12;
	public static final int EIL_ERROR_IN_REMOVEFEATURE_CMD         = -13;
	public static final int EIL_ERROR_IN_REMOVEMULTFEATURES_CMD    = -14;
	public static final int EIL_ERROR_IN_ADDCONSTRAINT_CMD         = -15;
	public static final int EIL_ERROR_IN_UPDATECONSTRAINT_CMD      = -16;
	public static final int EIL_ERROR_IN_UPDATEMULTCONSTRAINTS_CMD = -17;
	public static final int EIL_ERROR_IN_REMOVECONSTRAINT_CMD      = -18;
	public static final int EIL_ERROR_IN_REMOVEMULTCONSTRAINTS_CMD = -19;
	
	public static final int ROOT_NOT_SET                          = -1;
	public static final int MISSING_INFO_IN_RAW_FEATURE           = -2;
	public static final int NEW_ROOT_CANNOT_BE_ADDED              = -3;
	public static final int FEATURE_NAME_IN_USE                   = -4;
	public static final int PARENT_NOT_FOUND                      = -5;
	public static final int SIBLING_NOT_FOUND                     = -6;
	public static final int SIBLING_NOT_A_SIBLING                 = -7;
	public static final int INCONSISTENT_DECOMP_TYPE              = -8;
	public static final int FEATURE_NOT_FOUND                     = -9;
	public static final int DECOMP_TYPE_OF_ROOT_CANNOT_BE_UPDATED = -10;
	public static final int LOCATION_OF_ROOT_CANNOT_BE_UPDATED    = -11;
	public static final int DECOMP_REL_MUST_ALSO_BE_UPDATED       = -12;
	public static final int OLD_PARENT_NOT_FOUND                  = -13;
	public static final int NEW_PARENT_NOT_FOUND                  = -14;
	public static final int ROOT_CANNOT_BE_REMOVED                = -15;
	public static final int PARENT_CANNOT_BE_A_DESCENDANT         = -16;
	public static final int CYCLE_IN_FEATURE_DECLARATIONS         = -17;
	public static final int ATTRIBUTE_NOT_FOUND                   = -18;
	
	public static final int LEFT_FEATURE_NOT_FOUND    = -21;
	public static final int INVALID_CONSTRAINT_TYPE   = -22;
	public static final int RIGHT_FEATURE_NOT_FOUND   = -23;
	public static final int CONSTRAINT_ALREADY_EXISTS = -24;
	public static final int CONSTRAINT_DOES_NOT_EXIST = -25;
	
	public static final int STRING_NOT_ENUMERATED = -1;
	
	public static final int EXECUTION_NULL_MODEL                        = -1;
	public static final int EXECUTION_INVALID_COMMAND                   = -2;
	public static final int EXECUTION_CONSTRAINT_SOLVER                 = -3;
	public static final int EXECUTION_MODULUS_TYPE                      = -4;
	public static final int EXECUTION_FEATURE_ATTR_TYPE                 = -5;
	public static final int EXECUTION_FEATURE_VAR_TYPE                  = -6;
	public static final int EXECUTION_WHERE_FAILED                      = -7;
	public static final int EXECUTION_ROOT_NOT_SET                      = -8;
	
	public static final int EXECUTION_AMBIGUOUS_NEW_LEFT                = -10;
	public static final int EXECUTION_AMBIGUOUS_NEW_RIGHT               = -11;
	public static final int EXECUTION_AMBIGUOUS_NEW_PARENT              = -12;
	public static final int EXECUTION_AMBIGUOUS_NEW_DECOMP_REL          = -13;
	public static final int EXECUTION_AMBIGUOUS_NEW_DECOMP_ID           = -14;
	public static final int EXECUTION_AMBIGUOUS_ATTR_ASSIGNMENT         = -15;
	
	public static final int EXECUTION_ADDF_MISSING_INFO                 = -1000;
	public static final int EXECUTION_ADDF_NEW_ROOT_CANNOT_BE_ADDED     = -1001;
	public static final int EXECUTION_ADDF_FEATURE_NAME_IN_USE          = -1002;
	public static final int EXECUTION_ADDF_PARENT_DOES_NOT_EXIST        = -1003;
	public static final int EXECUTION_ADDF_RELSIBLING_DOES_NOT_EXIST    = -1004;
	public static final int EXECUTION_ADDF_RELSIBLING_NOT_SIBLING       = -1005;
	public static final int EXECUTION_ADDF_INCONSISTENT_DECOMP_TYPE     = -1006;
	
	public static final int EXECUTION_UPF_FEATURE_DOES_NOT_EXIST        = -1100;
	public static final int EXECUTION_UPF_AMBIGUOUS_WHICH_FEATURE       = -1101;
	public static final int EXECUTION_UPF_NEW_NAME_IN_USE               = -1102;
	public static final int EXECUTION_UPF_DECOMP_ROOT_NO                = -1103;
	public static final int EXECUTION_UPF_RELSIBLING_DOES_NOT_EXIST     = -1104;
	public static final int EXECUTION_UPF_INCONSISTENT_DECOMP_TYPE      = -1105;
	public static final int EXECUTION_UPF_ROOT_CANNOT_BE_MOVED          = -1106;
	public static final int EXECUTION_UPF_DECOMP_REL_MUST_BE_UPDATED    = -1107;
	public static final int EXECUTION_UPF_UPDATE_CAUSES_CYCLE           = -1108;
	public static final int EXECUTION_UPF_NEW_PARENT_NOT_FOUND          = -1109;
	public static final int EXECUTION_UPF_NEW_DEC_SPEC_FEAT_NOT_FOUND   = -1110;
	public static final int EXECUTION_UPF_RELSIBLING_NOT_SIBLING        = -1111;
	public static final int EXECUTION_UPF_ATTRIBUTE_NOT_FOUND           = -1112;
	
	public static final int EXECUTION_UPALLF_FEATURE_DOES_NOT_EXIST     = -1200;
	public static final int EXECUTION_UPALLF_DECOMP_ROOT_NO             = -1201;
	public static final int EXECUTION_UPALLF_RELSIBLING_DOES_NOT_EXIST  = -1202;
	public static final int EXECUTION_UPALLF_INCONSISTENT_DECOMP_TYPE   = -1203;
	public static final int EXECUTION_UPALLF_ROOT_CANNOT_BE_MOVED       = -1204;
	public static final int EXECUTION_UPALLF_DECOMP_REL_MUST_BE_UPDATED = -1205;
	public static final int EXECUTION_UPALLF_UPDATE_CAUSES_CYCLE        = -1206;
	public static final int EXECUTION_UPALLF_NEW_PARENT_NOT_FOUND       = -1207;
	public static final int EXECUTION_UPALLF_RELSIBLING_NOT_SIBLING     = -1208;
	public static final int EXECUTION_UPALLF_ATTRIBUTE_NOT_FOUND        = -1209;
	
	public static final int EXECUTION_REMF_FEATURE_DOES_NOT_EXIST       = -1300;
	public static final int EXECUTION_REMF_AMBIGUOUS_WHICH_FEATURE      = -1301;
	public static final int EXECUTION_REMF_ROOT_CANNOT_BE_REMOVED       = -1302;
	public static final int EXECUTION_REMF_PARENT_NOT_FOUND             = -1303;
	
	public static final int EXECUTION_REMALLF_FEATURE_DOES_NOT_EXIST    = -1400;
	public static final int EXECUTION_REMALLF_ROOT_CANNOT_BE_REMOVED    = -1401;
	public static final int EXECUTION_REMALLF_PARENT_NOT_FOUND          = -1402;
	
	public static final int EXECUTION_ADDC_LEFT_NOT_FOUND               = -1500;
	public static final int EXECUTION_ADDC_INVALID_CONSTRAINT           = -1501;
	public static final int EXECUTION_ADDC_RIGHT_NOT_FOUND              = -1502;
	public static final int EXECUTION_ADDC_ALREADY_EXISTS               = -1503;
	public static final int EXECUTION_ADDC_NONEXISTING_FEATURE          = -1504;
	
	public static final int EXECUTION_UPC_CONSTRAINT_DOES_NOT_EXIST     = -1600;
	public static final int EXECUTION_UPC_AMBIGUOUS_WHICH_CONSTRAINT    = -1601;
	public static final int EXECUTION_UPC_INVALID_CONSTRAINT            = -1602;
	public static final int EXECUTION_UPC_LEFT_NOT_FOUND                = -1603;
	public static final int EXECUTION_UPC_RIGHT_NOT_FOUND               = -1604;
	
	public static final int EXECUTION_UPALLC_CONST_DOES_NOT_EXIST       = -1700;
	public static final int EXECUTION_UPALLC_INVALID_CONSTRAINT         = -1701;
	public static final int EXECUTION_UPALLC_LEFT_NOT_FOUND             = -1702;
	public static final int EXECUTION_UPALLC_RIGHT_NOT_FOUND            = -1703;
	
	public static final int EXECUTION_REMC_CONST_DOES_NOT_EXIST         = -1800;
	public static final int EXECUTION_REMC_AMBIGUOUS_WHICH_CONSTRAINT   = -1801;
	
	public static final int EXECUTION_REMALLC_CONST_DOES_NOT_EXIST      = -1900;
	
	public static final int EXECUTION_UNKNOWN                           = -9999;
}

class ExceptionCodes
{
	public static final int CONSTRAINT_SOLVER_PROLOG_FILE_COULD_NOT_BE_CREATED   = 1;
	public static final int CONSTRAINT_SOLVER_PROLOG_QUERY_COULD_NOT_BE_EXECUTED = 2;
}

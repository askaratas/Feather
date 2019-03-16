// import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;


public class TVL_ErrorStrategy extends DefaultErrorStrategy
{
	@Override
	protected void reportNoViableAlternative(Parser parser, NoViableAltException e)
	{
		String errorInRule = e.getCtx().toStringTree(parser);
		Token seen = e.getOffendingToken();

		String errMsg = seen.getLine() + ": unexpected input '" + seen.getText() + "'" + getRuleExplanationInFeather(errorInRule);
		
		parser.notifyErrorListeners(errMsg);
	}
	
	
	@Override
    public void reportMissingToken(Parser parser)
	{
        String missing = getExpectedTokens(parser).toString(parser.getVocabulary());
		Token seen = parser.getCurrentToken();
		
		String errMsg = seen.getLine() + ": missing " + getTokenExplanationInFeather(missing, parser) + " before '" + seen.getText() + "'";
		parser.notifyErrorListeners(errMsg);
    }
	
	
	@Override
    public void reportUnwantedToken(Parser parser)
	{
        String expecting = getExpectedTokens(parser).toString(parser.getVocabulary());
		Token seen = parser.getCurrentToken();
		
		String errMsg = seen.getLine() + ": extranous input '" + seen.getText() + "', expecting " + getTokenExplanationInFeather(expecting, parser);
		
		parser.notifyErrorListeners(errMsg);
    }
	
	
	@Override
    public void reportInputMismatch(Parser parser, InputMismatchException e)
	{
		String errorInRule = e.getCtx().toStringTree(parser);
		Token seen = parser.getCurrentToken();
		
		String errMsg = seen.getLine() + ": unexpected input '" + seen.getText() + "'" + getRuleExplanationInFeather(errorInRule);
		
		parser.notifyErrorListeners(errMsg);
    }
	
	
	
	private String getTokenExplanationInFeather(String token, Parser parser)
	{
		if ( token == null )
			return "";
		
		if ( token.equals("ATTRIBUTE_NAME") )
		{
			return "attribute name";
		}
		else if ( token.equals("FEATURE_VAR") )
		{
			return "feature variable";
		}
		else if ( token.equals("INTEGER_LITERAL") )
		{
			return "integer value";
		}
		else if ( token.equals("REAL_LITERAL") )
		{
			return "real value";
		}
		else if ( token.equals("STRING_LITERAL") )
		{
			String sCtx = parser.getContext().toString(parser);
			sCtx = sCtx.replace("[", "");
			sCtx = sCtx.replace("]", "");
			String[] derivation = sCtx.split(" ");
			if ( derivation == null || derivation.length == 0 )
				return "";
			
			if ( derivation[0].equals("assignedValue")  ||
				 derivation[0].equals("attributeValue") ||
				 derivation[0].equals("stringOperand")     )
			{
				return "string value";
			}
			else if ( derivation[0].equals("settingName") )
			{
				return "new feature name";
			}
			else if ( derivation[0].equals("featureName") )
			{
				return "feature name";
			}
			else if ( derivation[0].equals("parentName") )
			{
				return "parent feature's name";
			}
		}
		
		return token;
	}
	
	
	private String getRuleExplanationInFeather(String rule)
	{
		if ( rule == null )
			return "";
		
		if ( rule.equals("declarations") )
		{
			return " in the declarations section";
		}
		else if ( rule.equals("featureDeclarations") )
		{
			return " in the feature declarations section";
		}
		else if ( rule.equals("rootFeature") )
		{
			return " in the root feature declaration";
		}
		else if ( rule.equals("featureDec") )
		{
			return " in the feature declaration";
		}
		else if ( rule.equals("decompRelDeclaration") )
		{
			return ", expecting a decomposition relation specification";
		}
		else if ( rule.equals("attributeDeclarations") )
		{
			return " in the attribute declarations section";
		}
		else if ( rule.equals("attributeDec") )
		{
			return " in the attribute declaration";
		}
		else if ( rule.equals("assignedValue") )
		{
			return ", expecting a value to be assigned to the attribute";
		}
		else if ( rule.equals("crossTreeConstraintDeclarations") )
		{
			return " in the cross-tree constraint declarations section";
		}
		else if ( rule.equals("crossTreeConstraintDec") )
		{
			return " in the cross-tree constraint declaration";
		}
		else if ( rule.equals("commands") )
		{
			return " in the commands section";
		}
		else if ( rule.equals("aCommand") )
		{
			return " in the command";
		}
		else if ( rule.equals("addFeature") )
		{
			return " in the feature addition command";
		}
		else if ( rule.equals("updateFeature") )
		{
			return " in the feature update command";
		}
		else if ( rule.equals("updateMultipleFeatures") )
		{
			return " in the multiple features update command";
		}
		else if ( rule.equals("removeFeature") )
		{
			return " in the feature removal command";
		}
		else if ( rule.equals("removeMultipleFeatures") )
		{
			return " in the multiple features removal command";
		}
		else if ( rule.equals("addConstraint") )
		{
			return " in the cross-tree constraint addition command";
		}
		else if ( rule.equals("updateConstraint") )
		{
			return " in the cross-tree constraint update command";
		}
		else if ( rule.equals("updateMultipleConstraints") )
		{
			return " in the multiple cross-tree constraints update command";
		}
		else if ( rule.equals("removeConstraint") )
		{
			return " in the cross-tree constraint removal command";
		}
		else if ( rule.equals("removeMultipleConstraints") )
		{
			return " in the multiple cross-tree constraints removal command";
		}
		else if ( rule.equals("featureDescription") )
		{
			return ", expecting a feature description";
		}
		else if ( rule.equals("featureNameDescription") )
		{
			return ", expecting a feature name description";
		}
		else if ( rule.equals("constraintDescription") )
		{
			return " in the cross-tree constraint description";
		}
		else if ( rule.equals("whereClause") )
		{
			return " in the where clause";
		}
		else if ( rule.equals("attributeList") )
		{
			return " in the attribute list section";
		}
		else if ( rule.equals("implicitAttributeAssignments") )
		{
			return " in the implicit attribute assignments section";
		}
		else if ( rule.equals("settingLocation") )
		{
			return ", expecting a feature location setting";
		}
		else if ( rule.equals("settingDecomposition") )
		{
			return ", expecting a feature decomposition relation setting";
		}
		else if ( rule.equals("otherAttributeDeclarations") )
		{
			return " in the attribute declarations section";
		}
		else if ( rule.equals("otherAttrDec") )
		{
			return " in the attribute declaration";
		}
		else if ( rule.equals("attributeValue") )
		{
			return ", expecting a value to be assigned to the attribute";
		}
		else if ( rule.equals("featureUpdates") )
		{
			return " in the update information section";
		}
		else if ( rule.equals("featUpdate") )
		{
			return ", expecting a feture property update";
		}
		else if ( rule.equals("settingName") )
		{
			return ", expecting a feature name setting";
		}
		else if ( rule.equals("limitedFeatureUpdates") )
		{
			return " in the update information section";
		}
		else if ( rule.equals("limitedFeatUpdate") )
		{
			return ", expecting a feture property update";
		}
		else if ( rule.equals("constraintUpdates") )
		{
			return " in the update information section";
		}
		else if ( rule.equals("constUpdate") )
		{
			return ", expecting a cross-tree constraint property update";
		}
		else if ( rule.equals("limitedConstraintUpdates") )
		{
			return " in the update information section";
		}
		else if ( rule.equals("decompRelValue") )
		{
			return ", expecting a decomposition relation value";
		}
		else if ( rule.equals("basicCrossTreeConstraint") )
		{
			return ", expecting a basic cross-tree constraint type";
		}
		else if ( rule.equals("arithmeticExpression") )
		{
			return ", expecting an arithmetic expression";
		}
		else if ( rule.equals("arithmeticOperand") )
		{
			return ", expecting an arithmetic expression operand";
		}
		else if ( rule.equals("highArithOp") )
		{
			return ", expecting an arithmetic operator";
		}
		else if ( rule.equals("lowArithOp") )
		{
			return ", expecting an arithmetic operator";
		}
		else if ( rule.equals("booleanExpression") )
		{
			return ", expecting a boolean expression";
		}
		else if ( rule.equals("booleanOperand") )
		{
			return ", expecting a boolean expression operand";
		}
		else if ( rule.equals("relOp") )
		{
			return ", expecting a relational operator";
		}
		else if ( rule.equals("stringEqualityCheck") )
		{
			return ", expecting a string equality check operation";
		}
		else if ( rule.equals("stringOperand") )
		{
			return ", expecting a string operand";
		}
		else if ( rule.equals("eqCheckOp") )
		{
			return ", expecting an equality check operator";
		}
		else if ( rule.equals("decompRelTypeCheck") )
		{
			return ", expecting a decomposition relation type equality check";
		}
		else if ( rule.equals("decompRelIDCheck") )
		{
			return ", expecting a decomposition relation ID equality check";
		}
		else if ( rule.equals("featureName") )
		{
			return ", expecting a feature name";
		}
		else if ( rule.equals("parentName") )
		{
			return ", expecting the parent feature's name";
		}
		else if ( rule.equals("attributeName") )
		{
			return ", expecting an attribute name";
		}
		else if ( rule.equals("featureVar") )
		{
			return ", expecting a feature variable";
		}
		else if ( rule.equals("bool_literal") )
		{
			return ", expecting a boolean literal";
		}
		
		return rule;
	}
	
}

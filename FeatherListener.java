// Generated from Feather.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FeatherParser}.
 */
public interface FeatherListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FeatherParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(FeatherParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(FeatherParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(FeatherParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(FeatherParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#featureDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterFeatureDeclarations(FeatherParser.FeatureDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#featureDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitFeatureDeclarations(FeatherParser.FeatureDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#rootFeature}.
	 * @param ctx the parse tree
	 */
	void enterRootFeature(FeatherParser.RootFeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#rootFeature}.
	 * @param ctx the parse tree
	 */
	void exitRootFeature(FeatherParser.RootFeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#featureDec}.
	 * @param ctx the parse tree
	 */
	void enterFeatureDec(FeatherParser.FeatureDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#featureDec}.
	 * @param ctx the parse tree
	 */
	void exitFeatureDec(FeatherParser.FeatureDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#decompRelDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterDecompRelDeclaration(FeatherParser.DecompRelDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#decompRelDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitDecompRelDeclaration(FeatherParser.DecompRelDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#attributeDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterAttributeDeclarations(FeatherParser.AttributeDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#attributeDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitAttributeDeclarations(FeatherParser.AttributeDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#attributeDec}.
	 * @param ctx the parse tree
	 */
	void enterAttributeDec(FeatherParser.AttributeDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#attributeDec}.
	 * @param ctx the parse tree
	 */
	void exitAttributeDec(FeatherParser.AttributeDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#assignedValue}.
	 * @param ctx the parse tree
	 */
	void enterAssignedValue(FeatherParser.AssignedValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#assignedValue}.
	 * @param ctx the parse tree
	 */
	void exitAssignedValue(FeatherParser.AssignedValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#crossTreeConstraintDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterCrossTreeConstraintDeclarations(FeatherParser.CrossTreeConstraintDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#crossTreeConstraintDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitCrossTreeConstraintDeclarations(FeatherParser.CrossTreeConstraintDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#crossTreeConstraintDec}.
	 * @param ctx the parse tree
	 */
	void enterCrossTreeConstraintDec(FeatherParser.CrossTreeConstraintDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#crossTreeConstraintDec}.
	 * @param ctx the parse tree
	 */
	void exitCrossTreeConstraintDec(FeatherParser.CrossTreeConstraintDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#commands}.
	 * @param ctx the parse tree
	 */
	void enterCommands(FeatherParser.CommandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#commands}.
	 * @param ctx the parse tree
	 */
	void exitCommands(FeatherParser.CommandsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#aCommand}.
	 * @param ctx the parse tree
	 */
	void enterACommand(FeatherParser.ACommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#aCommand}.
	 * @param ctx the parse tree
	 */
	void exitACommand(FeatherParser.ACommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#addFeature}.
	 * @param ctx the parse tree
	 */
	void enterAddFeature(FeatherParser.AddFeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#addFeature}.
	 * @param ctx the parse tree
	 */
	void exitAddFeature(FeatherParser.AddFeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#updateFeature}.
	 * @param ctx the parse tree
	 */
	void enterUpdateFeature(FeatherParser.UpdateFeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#updateFeature}.
	 * @param ctx the parse tree
	 */
	void exitUpdateFeature(FeatherParser.UpdateFeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#updateMultipleFeatures}.
	 * @param ctx the parse tree
	 */
	void enterUpdateMultipleFeatures(FeatherParser.UpdateMultipleFeaturesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#updateMultipleFeatures}.
	 * @param ctx the parse tree
	 */
	void exitUpdateMultipleFeatures(FeatherParser.UpdateMultipleFeaturesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#removeFeature}.
	 * @param ctx the parse tree
	 */
	void enterRemoveFeature(FeatherParser.RemoveFeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#removeFeature}.
	 * @param ctx the parse tree
	 */
	void exitRemoveFeature(FeatherParser.RemoveFeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#removeMultipleFeatures}.
	 * @param ctx the parse tree
	 */
	void enterRemoveMultipleFeatures(FeatherParser.RemoveMultipleFeaturesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#removeMultipleFeatures}.
	 * @param ctx the parse tree
	 */
	void exitRemoveMultipleFeatures(FeatherParser.RemoveMultipleFeaturesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#addConstraint}.
	 * @param ctx the parse tree
	 */
	void enterAddConstraint(FeatherParser.AddConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#addConstraint}.
	 * @param ctx the parse tree
	 */
	void exitAddConstraint(FeatherParser.AddConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#updateConstraint}.
	 * @param ctx the parse tree
	 */
	void enterUpdateConstraint(FeatherParser.UpdateConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#updateConstraint}.
	 * @param ctx the parse tree
	 */
	void exitUpdateConstraint(FeatherParser.UpdateConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#updateMultipleConstraints}.
	 * @param ctx the parse tree
	 */
	void enterUpdateMultipleConstraints(FeatherParser.UpdateMultipleConstraintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#updateMultipleConstraints}.
	 * @param ctx the parse tree
	 */
	void exitUpdateMultipleConstraints(FeatherParser.UpdateMultipleConstraintsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#removeConstraint}.
	 * @param ctx the parse tree
	 */
	void enterRemoveConstraint(FeatherParser.RemoveConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#removeConstraint}.
	 * @param ctx the parse tree
	 */
	void exitRemoveConstraint(FeatherParser.RemoveConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#removeMultipleConstraints}.
	 * @param ctx the parse tree
	 */
	void enterRemoveMultipleConstraints(FeatherParser.RemoveMultipleConstraintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#removeMultipleConstraints}.
	 * @param ctx the parse tree
	 */
	void exitRemoveMultipleConstraints(FeatherParser.RemoveMultipleConstraintsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#featureDescription}.
	 * @param ctx the parse tree
	 */
	void enterFeatureDescription(FeatherParser.FeatureDescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#featureDescription}.
	 * @param ctx the parse tree
	 */
	void exitFeatureDescription(FeatherParser.FeatureDescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#featureNameDescription}.
	 * @param ctx the parse tree
	 */
	void enterFeatureNameDescription(FeatherParser.FeatureNameDescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#featureNameDescription}.
	 * @param ctx the parse tree
	 */
	void exitFeatureNameDescription(FeatherParser.FeatureNameDescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#constraintDescription}.
	 * @param ctx the parse tree
	 */
	void enterConstraintDescription(FeatherParser.ConstraintDescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#constraintDescription}.
	 * @param ctx the parse tree
	 */
	void exitConstraintDescription(FeatherParser.ConstraintDescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(FeatherParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(FeatherParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void enterAttributeList(FeatherParser.AttributeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void exitAttributeList(FeatherParser.AttributeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#structuralAttributeAssignments}.
	 * @param ctx the parse tree
	 */
	void enterStructuralAttributeAssignments(FeatherParser.StructuralAttributeAssignmentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#structuralAttributeAssignments}.
	 * @param ctx the parse tree
	 */
	void exitStructuralAttributeAssignments(FeatherParser.StructuralAttributeAssignmentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#settingLocation}.
	 * @param ctx the parse tree
	 */
	void enterSettingLocation(FeatherParser.SettingLocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#settingLocation}.
	 * @param ctx the parse tree
	 */
	void exitSettingLocation(FeatherParser.SettingLocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#settingDecomposition}.
	 * @param ctx the parse tree
	 */
	void enterSettingDecomposition(FeatherParser.SettingDecompositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#settingDecomposition}.
	 * @param ctx the parse tree
	 */
	void exitSettingDecomposition(FeatherParser.SettingDecompositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#attributeAssignments}.
	 * @param ctx the parse tree
	 */
	void enterAttributeAssignments(FeatherParser.AttributeAssignmentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#attributeAssignments}.
	 * @param ctx the parse tree
	 */
	void exitAttributeAssignments(FeatherParser.AttributeAssignmentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#attrAssign}.
	 * @param ctx the parse tree
	 */
	void enterAttrAssign(FeatherParser.AttrAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#attrAssign}.
	 * @param ctx the parse tree
	 */
	void exitAttrAssign(FeatherParser.AttrAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttributeValue(FeatherParser.AttributeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttributeValue(FeatherParser.AttributeValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#featureUpdates}.
	 * @param ctx the parse tree
	 */
	void enterFeatureUpdates(FeatherParser.FeatureUpdatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#featureUpdates}.
	 * @param ctx the parse tree
	 */
	void exitFeatureUpdates(FeatherParser.FeatureUpdatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#featUpdate}.
	 * @param ctx the parse tree
	 */
	void enterFeatUpdate(FeatherParser.FeatUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#featUpdate}.
	 * @param ctx the parse tree
	 */
	void exitFeatUpdate(FeatherParser.FeatUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#settingName}.
	 * @param ctx the parse tree
	 */
	void enterSettingName(FeatherParser.SettingNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#settingName}.
	 * @param ctx the parse tree
	 */
	void exitSettingName(FeatherParser.SettingNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#limitedFeatureUpdates}.
	 * @param ctx the parse tree
	 */
	void enterLimitedFeatureUpdates(FeatherParser.LimitedFeatureUpdatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#limitedFeatureUpdates}.
	 * @param ctx the parse tree
	 */
	void exitLimitedFeatureUpdates(FeatherParser.LimitedFeatureUpdatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#limitedFeatUpdate}.
	 * @param ctx the parse tree
	 */
	void enterLimitedFeatUpdate(FeatherParser.LimitedFeatUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#limitedFeatUpdate}.
	 * @param ctx the parse tree
	 */
	void exitLimitedFeatUpdate(FeatherParser.LimitedFeatUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#constraintUpdates}.
	 * @param ctx the parse tree
	 */
	void enterConstraintUpdates(FeatherParser.ConstraintUpdatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#constraintUpdates}.
	 * @param ctx the parse tree
	 */
	void exitConstraintUpdates(FeatherParser.ConstraintUpdatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#constUpdate}.
	 * @param ctx the parse tree
	 */
	void enterConstUpdate(FeatherParser.ConstUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#constUpdate}.
	 * @param ctx the parse tree
	 */
	void exitConstUpdate(FeatherParser.ConstUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#limitedConstraintUpdates}.
	 * @param ctx the parse tree
	 */
	void enterLimitedConstraintUpdates(FeatherParser.LimitedConstraintUpdatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#limitedConstraintUpdates}.
	 * @param ctx the parse tree
	 */
	void exitLimitedConstraintUpdates(FeatherParser.LimitedConstraintUpdatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#decompRelValue}.
	 * @param ctx the parse tree
	 */
	void enterDecompRelValue(FeatherParser.DecompRelValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#decompRelValue}.
	 * @param ctx the parse tree
	 */
	void exitDecompRelValue(FeatherParser.DecompRelValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#basicCrossTreeConstraint}.
	 * @param ctx the parse tree
	 */
	void enterBasicCrossTreeConstraint(FeatherParser.BasicCrossTreeConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#basicCrossTreeConstraint}.
	 * @param ctx the parse tree
	 */
	void exitBasicCrossTreeConstraint(FeatherParser.BasicCrossTreeConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpression(FeatherParser.ArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpression(FeatherParser.ArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#arithmeticOperand}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOperand(FeatherParser.ArithmeticOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#arithmeticOperand}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOperand(FeatherParser.ArithmeticOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#highArithOp}.
	 * @param ctx the parse tree
	 */
	void enterHighArithOp(FeatherParser.HighArithOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#highArithOp}.
	 * @param ctx the parse tree
	 */
	void exitHighArithOp(FeatherParser.HighArithOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#lowArithOp}.
	 * @param ctx the parse tree
	 */
	void enterLowArithOp(FeatherParser.LowArithOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#lowArithOp}.
	 * @param ctx the parse tree
	 */
	void exitLowArithOp(FeatherParser.LowArithOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(FeatherParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(FeatherParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#booleanOperand}.
	 * @param ctx the parse tree
	 */
	void enterBooleanOperand(FeatherParser.BooleanOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#booleanOperand}.
	 * @param ctx the parse tree
	 */
	void exitBooleanOperand(FeatherParser.BooleanOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#relOp}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(FeatherParser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#relOp}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(FeatherParser.RelOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#stringEqualityCheck}.
	 * @param ctx the parse tree
	 */
	void enterStringEqualityCheck(FeatherParser.StringEqualityCheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#stringEqualityCheck}.
	 * @param ctx the parse tree
	 */
	void exitStringEqualityCheck(FeatherParser.StringEqualityCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#stringOperand}.
	 * @param ctx the parse tree
	 */
	void enterStringOperand(FeatherParser.StringOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#stringOperand}.
	 * @param ctx the parse tree
	 */
	void exitStringOperand(FeatherParser.StringOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#eqCheckOp}.
	 * @param ctx the parse tree
	 */
	void enterEqCheckOp(FeatherParser.EqCheckOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#eqCheckOp}.
	 * @param ctx the parse tree
	 */
	void exitEqCheckOp(FeatherParser.EqCheckOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#decompRelTypeCheck}.
	 * @param ctx the parse tree
	 */
	void enterDecompRelTypeCheck(FeatherParser.DecompRelTypeCheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#decompRelTypeCheck}.
	 * @param ctx the parse tree
	 */
	void exitDecompRelTypeCheck(FeatherParser.DecompRelTypeCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#decompRelIDCheck}.
	 * @param ctx the parse tree
	 */
	void enterDecompRelIDCheck(FeatherParser.DecompRelIDCheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#decompRelIDCheck}.
	 * @param ctx the parse tree
	 */
	void exitDecompRelIDCheck(FeatherParser.DecompRelIDCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#booleanEqualityCheck}.
	 * @param ctx the parse tree
	 */
	void enterBooleanEqualityCheck(FeatherParser.BooleanEqualityCheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#booleanEqualityCheck}.
	 * @param ctx the parse tree
	 */
	void exitBooleanEqualityCheck(FeatherParser.BooleanEqualityCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#boolEqOperand}.
	 * @param ctx the parse tree
	 */
	void enterBoolEqOperand(FeatherParser.BoolEqOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#boolEqOperand}.
	 * @param ctx the parse tree
	 */
	void exitBoolEqOperand(FeatherParser.BoolEqOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#featureName}.
	 * @param ctx the parse tree
	 */
	void enterFeatureName(FeatherParser.FeatureNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#featureName}.
	 * @param ctx the parse tree
	 */
	void exitFeatureName(FeatherParser.FeatureNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#parentName}.
	 * @param ctx the parse tree
	 */
	void enterParentName(FeatherParser.ParentNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#parentName}.
	 * @param ctx the parse tree
	 */
	void exitParentName(FeatherParser.ParentNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#attributeName}.
	 * @param ctx the parse tree
	 */
	void enterAttributeName(FeatherParser.AttributeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#attributeName}.
	 * @param ctx the parse tree
	 */
	void exitAttributeName(FeatherParser.AttributeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#featureVar}.
	 * @param ctx the parse tree
	 */
	void enterFeatureVar(FeatherParser.FeatureVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#featureVar}.
	 * @param ctx the parse tree
	 */
	void exitFeatureVar(FeatherParser.FeatureVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link FeatherParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void enterBool_literal(FeatherParser.Bool_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link FeatherParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void exitBool_literal(FeatherParser.Bool_literalContext ctx);
}
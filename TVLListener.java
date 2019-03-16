// Generated from TVL.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TVLParser}.
 */
public interface TVLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TVLParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(TVLParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(TVLParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#stringType}.
	 * @param ctx the parse tree
	 */
	void enterStringType(TVLParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#stringType}.
	 * @param ctx the parse tree
	 */
	void exitStringType(TVLParser.StringTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#stringList}.
	 * @param ctx the parse tree
	 */
	void enterStringList(TVLParser.StringListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#stringList}.
	 * @param ctx the parse tree
	 */
	void exitStringList(TVLParser.StringListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#featureList}.
	 * @param ctx the parse tree
	 */
	void enterFeatureList(TVLParser.FeatureListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#featureList}.
	 * @param ctx the parse tree
	 */
	void exitFeatureList(TVLParser.FeatureListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#rootFeature}.
	 * @param ctx the parse tree
	 */
	void enterRootFeature(TVLParser.RootFeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#rootFeature}.
	 * @param ctx the parse tree
	 */
	void exitRootFeature(TVLParser.RootFeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#otherFeatures}.
	 * @param ctx the parse tree
	 */
	void enterOtherFeatures(TVLParser.OtherFeaturesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#otherFeatures}.
	 * @param ctx the parse tree
	 */
	void exitOtherFeatures(TVLParser.OtherFeaturesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeature(TVLParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeature(TVLParser.FeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#featureBody}.
	 * @param ctx the parse tree
	 */
	void enterFeatureBody(TVLParser.FeatureBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#featureBody}.
	 * @param ctx the parse tree
	 */
	void exitFeatureBody(TVLParser.FeatureBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void enterAttributeList(TVLParser.AttributeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void exitAttributeList(TVLParser.AttributeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(TVLParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(TVLParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#children}.
	 * @param ctx the parse tree
	 */
	void enterChildren(TVLParser.ChildrenContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#children}.
	 * @param ctx the parse tree
	 */
	void exitChildren(TVLParser.ChildrenContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#featureGroup}.
	 * @param ctx the parse tree
	 */
	void enterFeatureGroup(TVLParser.FeatureGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#featureGroup}.
	 * @param ctx the parse tree
	 */
	void exitFeatureGroup(TVLParser.FeatureGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#solitaryIDList}.
	 * @param ctx the parse tree
	 */
	void enterSolitaryIDList(TVLParser.SolitaryIDListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#solitaryIDList}.
	 * @param ctx the parse tree
	 */
	void exitSolitaryIDList(TVLParser.SolitaryIDListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#optional}.
	 * @param ctx the parse tree
	 */
	void enterOptional(TVLParser.OptionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#optional}.
	 * @param ctx the parse tree
	 */
	void exitOptional(TVLParser.OptionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#pp_parentInformation}.
	 * @param ctx the parse tree
	 */
	void enterPp_parentInformation(TVLParser.Pp_parentInformationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#pp_parentInformation}.
	 * @param ctx the parse tree
	 */
	void exitPp_parentInformation(TVLParser.Pp_parentInformationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(TVLParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(TVLParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void enterCardinality(TVLParser.CardinalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void exitCardinality(TVLParser.CardinalityContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#constraintList}.
	 * @param ctx the parse tree
	 */
	void enterConstraintList(TVLParser.ConstraintListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#constraintList}.
	 * @param ctx the parse tree
	 */
	void exitConstraintList(TVLParser.ConstraintListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(TVLParser.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(TVLParser.ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(TVLParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(TVLParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#attrID}.
	 * @param ctx the parse tree
	 */
	void enterAttrID(TVLParser.AttrIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#attrID}.
	 * @param ctx the parse tree
	 */
	void exitAttrID(TVLParser.AttrIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void enterBool_literal(TVLParser.Bool_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void exitBool_literal(TVLParser.Bool_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVLParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(TVLParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVLParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(TVLParser.String_literalContext ctx);
}
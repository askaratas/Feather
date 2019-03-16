import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.nio.file.*;

import se.sics.jasper.*;


/** *******************************************************************************************
 * ConstraintSolver
 * --------------------------------------------------------------------------------------------
 * @author Ahmet Serkan Karatas
 *
 ** ******************************************************************************************* */
class ConstraintSolver
{
	public static ArrayList<FeatureVarSolutionSet> resolveVariables(
			SICStus sp,
			ArrayList<FeatureVariable> varAssumptions,
			ArrayList<Feature> featList,
			ArrayList<ASTNode> whereClause,
			ArrayList<Integer> ctcEliminations,
			ArrayList<CrossTreeConstraint> constraintList)
		throws ConstraintSolverException
	{
		if ( varAssumptions == null || featList == null || whereClause == null )
		{
			return null;
		}
		
		if ( varAssumptions.size() == 0 || featList.size() == 0 || whereClause.size() == 0 )
		{
			return new ArrayList<FeatureVarSolutionSet>();
		}
		
		int i, j;
		
		if ( ctcEliminations == null )
		{
			ctcEliminations = new ArrayList<Integer>();
		}
		
		if ( constraintList == null )
		{
			constraintList = new ArrayList<CrossTreeConstraint>();
		}
		
		ArrayList<FeatureVariable> varList = findFeatureVariablesThatWillBeMapped(whereClause);
		
		if ( ctcEliminations.size() < varAssumptions.size() )
		{
			for (i=ctcEliminations.size(); i<varAssumptions.size(); i++)
			{
				ctcEliminations.add(Codes._NO_VALUE_);
			}
		}
		
		String prologPrgm = "findResolution(";
		
		prologPrgm += varList.get(0).name + "_idno";
		for (i=1; i<varList.size(); i++)
			prologPrgm += ", " + varList.get(i).name + "_idno";
		prologPrgm += ") :- ";
		
		ArrayList<StringEnum> strEnumList = enumerateStrings(featList, whereClause);
		
		int ctcElimCode;
		FeatureVariable var, varAssump;
		ArrayList<Feature> compatibleList;
		ArrayList<Feature> candFeatList;
		String prologPrgmVars = "";
		for (i=0; i<varList.size(); i++)
		{
			var = varList.get(i);
			
			varAssump = new FeatureVariable();
			ctcElimCode = Codes._NO_VALUE_;
			for (j=0; j<varAssumptions.size(); j++)
			{
				if ( var.name.equals(varAssumptions.get(j).name) )
				{
					varAssump = varAssumptions.get(j);
					ctcElimCode = ctcEliminations.get(j);
					break;
				}
			}
			
			if ( ctcElimCode != Codes._NO_VALUE_ )
			{
				candFeatList = findCandidateFeatures(featList, constraintList, ctcElimCode);
			}
			else
			{
				candFeatList = featList;
			}
			if ( candFeatList == null || candFeatList.size() == 0 )
			{
				return new ArrayList<FeatureVarSolutionSet>();
			}
			
			compatibleList = findCompatibleFeatures(var, varAssump, candFeatList);
			if ( compatibleList == null || compatibleList.size() == 0 )
			{
				return new ArrayList<FeatureVarSolutionSet>();
			}
			
			prologPrgmVars += mapFeatureVariable(var, compatibleList, strEnumList, featList);
		}
		
		prologPrgm += prologPrgmVars;
		prologPrgm += mapWhereClause(whereClause, strEnumList, featList);
		
		FileWriter tmpPrologFile;
		BufferedWriter bufferedWriter;
		try
		{
			tmpPrologFile = new FileWriter("__solvecnstr.pl");
			bufferedWriter = new BufferedWriter(tmpPrologFile);
			bufferedWriter.write(prologPrgm);
			bufferedWriter.close();
		}
		catch (Exception e)
		{
			throw new ConstraintSolverException(ExceptionCodes.CONSTRAINT_SOLVER_PROLOG_FILE_COULD_NOT_BE_CREATED, e.getMessage());
		}
		
		Query query;
		HashMap<String, Integer> resolutions = new HashMap<String, Integer>();
		ArrayList<FeatureVarSolutionSet> solutionSet = new ArrayList<FeatureVarSolutionSet>();
		FeatureVarSolutionSet oneSet;
		FeatureVariableResolution fvr;
		try 
		{
			sp.load("__solvecnstr.pl");
			String queryCode = "findResolution(" + varList.get(0).name ;
			for (i=1; i<varList.size(); i++)
				queryCode += ", " + varList.get(i).name;
			queryCode += ").";
			
			query = sp.openPrologQuery(queryCode, resolutions);
			try 
			{
				while (query.nextSolution())
				{
					oneSet = new FeatureVarSolutionSet();
					
					for ( String key : resolutions.keySet() ) 
					{
						fvr = new FeatureVariableResolution();
						
						fvr.featureVar = key;
						fvr.featureIDNo = Integer.parseInt(resolutions.get(key)+"");
						
						oneSet.resolutions.add(fvr);
					}
					
					solutionSet.add(oneSet);
				}
			}
			finally 
			{
				query.close();
			}
		}
		catch ( Exception e )
		{
			throw new ConstraintSolverException(ExceptionCodes.CONSTRAINT_SOLVER_PROLOG_QUERY_COULD_NOT_BE_EXECUTED, e.getMessage());
		}
		
		try
		{
			Path path = FileSystems.getDefault().getPath(".", "__solvecnstr.pl");
			Files.deleteIfExists(path);
		}
		catch (Exception e)
		{
		}
		
		return solutionSet;
	}
	
	
	private static String mapFeatureVariable(FeatureVariable fvar, ArrayList<Feature> compatibleFeatures, ArrayList<StringEnum> strEnumList, ArrayList<Feature> allFeatures)
	{
		if ( fvar.otherAttributes == null || fvar.otherAttributes.size() == 0 )
		{
			return "";
		}
		
		if ( compatibleFeatures == null || compatibleFeatures.size() == 0 )
		{
			return "";
		}
		
		int i, j, k;
		
		String prologMapping = "(" + fvar.name +  "_idno = " + compatibleFeatures.get(0).idNo;
		for (i=1; i<compatibleFeatures.size(); i++)
		{
			prologMapping += " ; " + fvar.name +  "_idno = " + compatibleFeatures.get(i).idNo;
		}
		prologMapping += "), ";
		
		String varName;
		int strEnumNo;
		Feature feat, parent;
		boolean found;
		Attribute attr;
		
		prologMapping += "(";
		for (i=0; i<compatibleFeatures.size(); i++)
		{
			feat = compatibleFeatures.get(i);
			
			if ( i > 0 )
			{
				prologMapping += " ; ";
			}
			
			prologMapping += "( (" + fvar.name + "_idno =:= " + feat.idNo + ") -> (";
			
			for (j=0; j<fvar.otherAttributes.size(); j++)
			{
				if ( j > 0 )
				{
					prologMapping += ", ";
				}
				
				varName = fvar.otherAttributes.get(j).name;
				
				if ( varName.equals("_name") )
				{
					strEnumNo = findStrEnumNo(feat._name, strEnumList);
					if ( strEnumNo == ErrorCodes.STRING_NOT_ENUMERATED )
					{
						return null;
					}
					
					prologMapping += fvar.name + "_name = " + strEnumNo;
				}
				else if ( varName.equals("_parent") )
				{
					parent = findFeature(feat._parentIDNo, allFeatures);
					if ( parent == null )
					{
						return null;
					}
					strEnumNo = findStrEnumNo(parent._name, strEnumList);
					if ( strEnumNo == ErrorCodes.STRING_NOT_ENUMERATED )
					{
						return null;
					}
					
					prologMapping += fvar.name + "_parent = " + strEnumNo;
				}
				else if ( varName.equals("_decomp") )
				{
					prologMapping += fvar.name + "_decomp = " + feat._decomp;
				}
				else if ( varName.equals("_decompID") )
				{
					prologMapping += fvar.name + "_decompID = " + feat._decompID;
				}
				else
				{
					found = false;
					attr = null;
					for (k=0; k<feat.attributes.size(); k++)
					{
						attr = feat.attributes.get(k);
						if ( varName.equals(attr.name) )
						{
							found = true;
							break;
						}
					}
					if ( !found )
					{
						return null;
					}
					
					switch ( attr.type )
					{
						case Codes.TYPE_INT    : prologMapping += fvar.name + varName + " = " + attr.intval;  break;
						case Codes.TYPE_REAL   : prologMapping += fvar.name + varName + " = " + attr.realval; break;
						case Codes.TYPE_BOOL   : prologMapping += fvar.name + varName + " = " + (attr.boolval ? Codes.TRUE : Codes.FALSE); break;
						case Codes.TYPE_STRING : 
							strEnumNo = findStrEnumNo(attr.stringval, strEnumList);
							if ( strEnumNo == ErrorCodes.STRING_NOT_ENUMERATED )
							{
								return null;
							}
							prologMapping += fvar.name + varName + " = " + strEnumNo; 
							break;
					}
				}
			}
			prologMapping += ") ) ";
		}
		prologMapping += "), ";
		
		return prologMapping;
	}
	
	private static String mapWhereClause(ArrayList<ASTNode> clause, ArrayList<StringEnum> strEnumList, ArrayList<Feature> featList)
	{
		if ( clause == null || clause.size() == 0 )
		{
			return "";
		}
		
		int i;
		ASTNode n, n1, n2, tmp;
		String left, op, right;
		
		if ( clause.size() == 1 )
		{
			return astNodeMapping(clause.get(0), strEnumList, featList) + " =:= " + Codes.TRUE + " .";
		}
		
		while ( clause.size() > 1 )
		{
			for (i=0; i<clause.size(); i++)
			{
				n = clause.get(i);
				if ( n.type != Codes.AST_TYPE_OPERATOR )
				{
					continue;
				}
				
				if ( n.opcode == Codes.OP_UNMINUS || n.opcode == Codes.OP_NOT )
				{
					n1 = clause.get(i-1);
					
					op = astNodeMapping(n, strEnumList, featList);
					
					if ( n1.type == Codes.AST_TYPE_MAPPED )
					{
						right = n1.stringval;
					}
					else if ( n.opcode == Codes.OP_NOT && (n1.type == Codes.AST_TYPE_BOOL || n1.type == Codes.AST_TYPE_FEATURE || n1.type == Codes.AST_TYPE_FEATUREVAR) )
					{
						right = "(" + astNodeMapping(n1, strEnumList, featList) + " =:= " + Codes.TRUE + ")";
					}
					else
					{
						right = astNodeMapping(n1, strEnumList, featList);
					}

					tmp = new ASTNode();
					tmp.type = Codes.AST_TYPE_MAPPED;
					tmp.stringval = "(" + op + " " + right + ")";
					
					clause.add(i+1, tmp);
					
					clause.remove(i);
					clause.remove(i-1);
				}
				else
				{
					n1 = clause.get(i-1);
					n2 = clause.get(i-2);
					
					if ( n2.type == Codes.AST_TYPE_MAPPED )
					{
						left = n2.stringval;
					}
					else if ( (n.opcode == Codes.OP_AND || n.opcode == Codes.OP_OR)                                                         && 
							  (n2.type == Codes.AST_TYPE_BOOL || n2.type == Codes.AST_TYPE_FEATURE || n2.type == Codes.AST_TYPE_FEATUREVAR)    )
					{
						left = "(" + astNodeMapping(n2, strEnumList, featList) + " =:= " + Codes.TRUE + ")";
					}
					else
					{
						left = astNodeMapping(n2, strEnumList, featList);
					}
					
					op = astNodeMapping(n, strEnumList, featList);
					
					if ( n1.type == Codes.AST_TYPE_MAPPED )
					{
						right = n1.stringval;
					}
					else if ( (n.opcode == Codes.OP_AND || n.opcode == Codes.OP_OR)                                                         && 
							  (n1.type == Codes.AST_TYPE_BOOL || n1.type == Codes.AST_TYPE_FEATURE || n1.type == Codes.AST_TYPE_FEATUREVAR)    )
					{
						right = "(" + astNodeMapping(n1, strEnumList, featList) + " =:= " + Codes.TRUE + ")";
					}
					else
					{
						right = astNodeMapping(n1, strEnumList, featList);
					}

					tmp = new ASTNode();
					tmp.type = Codes.AST_TYPE_MAPPED;
					tmp.stringval = "(" + left + " " + op + " " + right + ")";
					
					clause.add(i+1, tmp);
					
					clause.remove(i);
					clause.remove(i-1);
					clause.remove(i-2);
				}
				
				break;
			}
		}
		
		return clause.get(0).stringval + " .";
	}
	
	
	private static ArrayList<FeatureVariable> findFeatureVariablesThatWillBeMapped(ArrayList<ASTNode> whereClause)
	{
		ArrayList<FeatureVariable> varList = new ArrayList<FeatureVariable>();
		
		if ( whereClause == null || whereClause.size() == 0 )
		{
			return varList;
		}
		
		int i, j;
		boolean found;
		ASTNode node;
		FeatureVariable fv = null;
		VariableAttribute va;
		
		for (i=0; i<whereClause.size(); i++)
		{
			node = whereClause.get(i);
			if ( node.type != Codes.AST_TYPE_FEATUREVAR )
			{
				continue;
			}
			
			found = false;
			for (j=0; j<varList.size(); j++)
			{
				fv = varList.get(j);
				if ( node.featureVar.equals(fv.name) )
				{
					found = true;
					break;
				}
			}
			if ( !found )
			{
				fv = new FeatureVariable();
				fv.name = node.featureVar;
				
				va = new VariableAttribute();
				va.name = node.attrName;
				fv.otherAttributes.add(va);
				
				varList.add(fv);
				
				continue;
			}
			
			found = false;
			for (j=0; j<fv.otherAttributes.size(); j++)
			{
				if ( node.attrName.equals(fv.otherAttributes.get(j).name) )
				{
					found = true;
					break;
				}
			}
			if ( !found )
			{
				va = new VariableAttribute();
				va.name = node.attrName;
				fv.otherAttributes.add(va);
			}
		}
		
		return varList;
	}
		
	
	private static ArrayList<StringEnum> enumerateStrings(ArrayList<Feature> featlist, ArrayList<ASTNode> constNodes)
	{
		if ( featlist == null )
		{
			return null;
		}
		
		int i, j, k, nextNo=1;
		ArrayList<StringEnum> strEnums = new ArrayList<StringEnum>();
		StringEnum enumEl;
		Feature feat;
		Attribute attr;
		boolean found;
		
		for (i=0; i<featlist.size(); i++)
		{
			feat = featlist.get(i);
			enumEl = new StringEnum();
			enumEl.no     = nextNo++;
			enumEl.strval = feat._name;
			strEnums.add(enumEl);
			
			for (j=0; j<feat.attributes.size(); j++)
			{
				attr = feat.attributes.get(j);
				if ( attr.type == Codes.TYPE_STRING )
				{
					found = false;
					for (k=0; k<strEnums.size(); k++)
					{
						if ( attr.stringval.equalsIgnoreCase(strEnums.get(k).strval) )
						{
							found = true;
							break;
						}
					}
					if ( !found )
					{
						enumEl = new StringEnum();
						enumEl.no     = nextNo++;
						enumEl.strval = attr.stringval;
						strEnums.add(enumEl);
					}
				}
			}
		}
		
		if ( constNodes == null )
		{
			return strEnums;
		}
		
		ASTNode node;
		for (i=0; i<constNodes.size(); i++)
		{
			node = constNodes.get(i);
			if ( node.type == Codes.AST_TYPE_STRING )
			{
				found = false;
				for (k=0; k<strEnums.size(); k++)
				{
					if ( node.stringval.equalsIgnoreCase(strEnums.get(k).strval) )
					{
						found = true;
						break;
					}
				}
				if ( !found )
				{
					enumEl = new StringEnum();
					enumEl.no     = nextNo++;
					enumEl.strval = node.stringval;
					strEnums.add(enumEl);
				}
			}
		}
		
		return strEnums;
	}
	
	private static int findStrEnumNo(String val, ArrayList<StringEnum> enumList)
	{
		if ( val == null || enumList == null || enumList.size() == 0 )
		{
			return ErrorCodes.STRING_NOT_ENUMERATED;
		}
		
		int i;
		StringEnum se;
		
		for (i=0; i<enumList.size(); i++)
		{
			se = enumList.get(i);
			if ( val.equalsIgnoreCase(se.strval) )
			{
				return se.no;
			}
		}
		
		return ErrorCodes.STRING_NOT_ENUMERATED;
	}
	
	
	private static ArrayList<Feature> findCandidateFeatures(ArrayList<Feature> featList, ArrayList<CrossTreeConstraint> constList, int eliminationCriteria)
	{
		if ( featList == null )
		{
			return null;
		}
		
		if ( featList.size() == 0 || constList == null || constList.size() == 0 )
		{
			return new ArrayList<Feature>();
		}
		
		ArrayList<Integer> featsInConstraints = findFeaturesInConstraints(constList, eliminationCriteria);
		
		int i, j;
		boolean found;
		Feature feat;
		ArrayList<Feature> candList = new ArrayList<Feature>();
		
		for (i=0; i<featList.size(); i++)
		{
			feat = featList.get(i);
			
			found = false;
			for (j=0; j<featsInConstraints.size(); j++)
			{
				if ( feat.idNo == featsInConstraints.get(j) )
				{
					found = true;
					break;
				}
			}
			
			if ( found )
			{
				candList.add(feat);
			}
		}
		
		return candList;
	}
	
	private static ArrayList<Integer> findFeaturesInConstraints(ArrayList<CrossTreeConstraint> constList, int eliminationCriteria)
	{
		if ( constList == null )
		{
			return null;
		}
		
		if ( constList.size() == 0 )
		{
			return new ArrayList<Integer>();
		}
		
		int i;
		CrossTreeConstraint ctc;
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		
		
		if ( eliminationCriteria == Codes.FEATURE_IN_REQUIRES_LEFT || eliminationCriteria == Codes.FEATURE_IN_REQUIRES_RIGHT )
		{
			for (i=0; i<constList.size(); i++)
			{
				ctc = constList.get(i);
				
				if ( ctc.constraintType == Codes.EXCLUDES )
				{
					continue;
				}
				
				if ( eliminationCriteria == Codes.FEATURE_IN_REQUIRES_LEFT )
				{
					resultList.add(ctc.leftIDNo);
				}
				else
				{
					resultList.add(ctc.rightIDNo);
				}
			}
		}
		else if ( eliminationCriteria == Codes.FEATURE_IN_EXCLUDES )
		{
			for (i=0; i<constList.size(); i++)
			{
				ctc = constList.get(i);
				
				if ( ctc.constraintType == Codes.REQUIRES )
				{
					continue;
				}
				
				resultList.add(ctc.leftIDNo);
				resultList.add(ctc.rightIDNo);
			}
		}
		
		return resultList;
	}
	
	private static ArrayList<Feature> findCompatibleFeatures(FeatureVariable var, FeatureVariable assumptions, ArrayList<Feature> flist)
	{
		if ( flist == null )
		{
			return null;
		}
		
		if ( flist.size() == 0 )
		{
			return new ArrayList<Feature>();
		}
		
		int i, j, k;
		Feature feat;
		Attribute attr;
		VariableAttribute varAttr;
		boolean notCompatible, attrNotFound;
		
		// initially assume all features are compatible
		ArrayList<Feature> compatibleList = new ArrayList<Feature>();
		for (i=0; i<flist.size(); i++)
		{
			compatibleList.add(flist.get(i));
		}
		
		// then, first eliminate by the non-existence of feature attributes
		for (i=0; i<var.otherAttributes.size(); i++)
		{
			varAttr = var.otherAttributes.get(i);
			if ( varAttr.name.equals("_decomp") || varAttr.name.equals("_decompID") || varAttr.name.equals("_parent") )
			{
				for (j=0; j<compatibleList.size(); j++)
				{
					feat = compatibleList.get(j);
					
					if ( feat.idNo == 1 )
					{
						compatibleList.remove(j);
						break;
					}
				}
			}
			else if ( varAttr.name.equals("_name") )
			{
				continue;
			}
			else
			{
				for (j=0; j<compatibleList.size(); j++)
				{
					feat = compatibleList.get(j);
					
					attrNotFound = true;
					for (k=0; k<feat.attributes.size(); k++)
					{
						attr = feat.attributes.get(k);
						if ( varAttr.name.equals(attr.name) )
						{
							attrNotFound = false;
							break;
						}
					}
					if ( attrNotFound )
					{
						compatibleList.remove(j);
						j--;
					}
				}
			}
		}
		
		// last, eliminate with incompatibility with the type assumptions
		for (i=0; i<compatibleList.size(); i++)
		{
			feat = compatibleList.get(i);
			
			notCompatible = false;
			for (j=0; j<assumptions.otherAttributes.size(); j++)
			{
				varAttr = assumptions.otherAttributes.get(j);
				
				attrNotFound = true;
				for (k=0; k<feat.attributes.size(); k++)
				{
					attr = feat.attributes.get(k);
					
					if ( varAttr.name.equals(attr.name) )
					{
						if ( varAttr.assumedType == Codes._NO_VALUE_ )
						{
							attrNotFound = false;
							break;
						}
						
						if ( (varAttr.assumedType == Codes.AST_TYPE_BOOL   && attr.type == Codes.TYPE_BOOL )   ||
							 (varAttr.assumedType == Codes.AST_TYPE_INT    && attr.type == Codes.TYPE_INT )    || 
							 (varAttr.assumedType == Codes.AST_TYPE_REAL   && attr.type == Codes.TYPE_REAL )   || 
							 (varAttr.assumedType == Codes.AST_TYPE_STRING && attr.type == Codes.TYPE_STRING )    )
						{
							attrNotFound = false;
							break;
						}
						
						if ( varAttr.assumedType == Codes.AST_TYPE_NUMERIC || varAttr.assumedType == Codes.TYPE_REAL )
						{
							if ( attr.type == Codes.TYPE_INT || attr.type == Codes.TYPE_REAL )
							{
								attrNotFound = false;
								break;
							}
						}
						
						break;
					}
				}
				
				if ( attrNotFound )
				{
					notCompatible = true;
					break; // at least one attribute is not found, obviously incompatible, no need to look the rest
				}
			}
			
			if ( notCompatible )
			{
				compatibleList.remove(i);
				i--;
			}
		}
		
		return compatibleList;
	}

	
	private static String astNodeMapping(ASTNode node, ArrayList<StringEnum> enumList, ArrayList<Feature> featList)
	{
		int strEnumNo;
		
		switch ( node.type )
		{
			case Codes.AST_TYPE_INT:
				return "" + node.intval;
			
			case Codes.AST_TYPE_REAL:
				return "" + node.realval;
				
			case Codes.AST_TYPE_BOOL:
				return (node.boolval ? ""+Codes.TRUE : ""+Codes.FALSE);
				
			case Codes.AST_TYPE_STRING:
				strEnumNo = findStrEnumNo(node.stringval, enumList);
				if ( strEnumNo == ErrorCodes.STRING_NOT_ENUMERATED )
				{
					return null;
				}
				return "" + strEnumNo;
				
			case Codes.AST_TYPE_FEATURE:
				Feature feat = findFeature(node.featureName, featList);
				if ( feat == null )
				{
					return null;
				}
				
				if ( node.attrName.equals("_name") )
				{
					strEnumNo = findStrEnumNo(feat._name, enumList);
					if ( strEnumNo == ErrorCodes.STRING_NOT_ENUMERATED )
					{
						return null;
					}
					return "" + strEnumNo;
				}
				else if ( node.attrName.equals("_parent") )
				{
					if ( feat._parentIDNo == Codes._NO_VALUE_ ) // root
					{
						return "" + Codes._NO_VALUE_;
					}
					
					Feature parent = findFeature(feat._parentIDNo, featList);
					if ( parent == null )
					{
						return null;
					}
					strEnumNo = findStrEnumNo(parent._name, enumList);
					if ( strEnumNo == ErrorCodes.STRING_NOT_ENUMERATED )
					{
						return null;
					}
					return "" + strEnumNo;
				}
				else if ( node.attrName.equals("_decomp") )
				{
					return "" + feat._decomp;
				}
				else if ( node.attrName.equals("_decompID") )
				{
					return "" + feat._decompID;
				}
				else
				{
					int i;
					boolean found = false;
					Attribute attr = null;
					for (i=0; i<feat.attributes.size(); i++)
					{
						attr = feat.attributes.get(i);
						if ( node.attrName.equals(attr.name) )
						{
							found = true;
							break;
						}
					}
					if ( !found )
					{
						return null;
					}
						
					switch ( attr.type )
					{
						case Codes.TYPE_INT    : return ""+attr.intval;
						case Codes.TYPE_REAL   : return ""+attr.realval;
						case Codes.TYPE_BOOL   : return ""+(attr.boolval ? Codes.TRUE : Codes.FALSE);
						case Codes.TYPE_STRING : 
							strEnumNo = findStrEnumNo(attr.stringval, enumList);
							if ( strEnumNo == ErrorCodes.STRING_NOT_ENUMERATED )
							{
								return null;
							}
							return ""+strEnumNo; 
					}
					
					return null;
				}
				
			case Codes.AST_TYPE_FEATUREVAR:
				return node.featureVar + node.attrName;
				
			case Codes.AST_TYPE_OPERATOR:
				switch ( node.opcode )
				{
					case Codes.OP_ADD:      return "+";
					case Codes.OP_SUBTRACT: return "-";
					case Codes.OP_MULTIPLY: return "*";
					case Codes.OP_DIVIDE:   return "/";
					case Codes.OP_MODULUS:  return "mod";
					case Codes.OP_UNMINUS:  return "-";
					case Codes.OP_LT:       return "<";
					case Codes.OP_LTE:      return "=<";
					case Codes.OP_GT:       return ">";
					case Codes.OP_GTE:      return ">=";
					case Codes.OP_EQ:       return "=:=";
					case Codes.OP_NEQ:      return "=\\=";
					case Codes.OP_AND:      return ",";
					case Codes.OP_OR:       return ";";
					case Codes.OP_NOT:      return "\\+";
					
				}
				break;
				
			case Codes.AST_TYPE_DECRELTYPE:
				switch ( node.decRelTypeVal )
				{
					case Codes.MANDATORY:   return "" + Codes.MANDATORY;
					case Codes.OPTIONAL:    return "" + Codes.OPTIONAL;
					case Codes.ALTERNATIVE: return "" + Codes.ALTERNATIVE;
					case Codes.OR:          return "" + Codes.OR;
				}
				break;
		}
		
		return "";
	}
	
	private static Feature findFeature(String name, ArrayList<Feature> featList)
	{
		if ( featList == null || featList.size() == 0 || name == null || name == "" )
		{
			return null;
		}
		
		int i;
		Feature feat;
		for (i=0; i<featList.size(); i++)
		{
			feat = featList.get(i);
			if ( name.equalsIgnoreCase(feat._name) )
			{
				return feat;
			}
		}
		
		return null;
	}

	private static Feature findFeature(int idNo, ArrayList<Feature> featList)
	{
		if ( featList == null || featList.size() == 0 )
		{
			return null;
		}
		
		int i;
		Feature feat;
		for (i=0; i<featList.size(); i++)
		{
			feat = featList.get(i);
			if ( idNo == feat.idNo )
			{
				return feat;
			}
		}
		
		return null;
	}
	
}

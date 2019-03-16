import java.util.ArrayList;


/** *******************************************************************************************
 * TypeChecker
 * --------------------------------------------------------------------------------------------
 * @author Ahmet Serkan Karatas
 *
 ** ******************************************************************************************* */
class TypeChecker
{
	private ArrayList<FeatureVariable> m_fVarAssumptions;
	private ArrayList<Feature> m_featureList;
	private ArrayList<MustBeCompatibleFVars> m_compatibleVars;
	
	public ArrayList<FeatureVariable> getFeatureVariableAssumptions()
	{
		ArrayList<FeatureVariable> tmpList;
		FeatureVariable fv, tmpFV;
		VariableAttribute va, tmpVA;
		int i, j;
		
		tmpList = new ArrayList<FeatureVariable>();
		for (i=0; i<m_fVarAssumptions.size(); i++)
		{
			fv = m_fVarAssumptions.get(i);
			
			tmpFV = new FeatureVariable();
			tmpFV.name = fv.name;
			
			for (j=0; j<fv.otherAttributes.size(); j++)
			{
				va = fv.otherAttributes.get(j);
				
				tmpVA = new VariableAttribute();
				tmpVA.name = va.name;
				tmpVA.assumedType = va.assumedType;
				
				tmpFV.otherAttributes.add(tmpVA);
			}
			
			tmpList.add(tmpFV);
		}
		
		return tmpList;
	}
	
	public ArrayList<MustBeCompatibleFVars> getCompatibilityList()
	{
		int i;
		MustBeCompatibleFVars info, cp;
		ArrayList<MustBeCompatibleFVars> listCopy = new ArrayList<MustBeCompatibleFVars>();

		for (i=0; i<m_compatibleVars.size(); i++)
		{
			info = m_compatibleVars.get(i);
			
			cp = new MustBeCompatibleFVars();
			cp.FVar1 = info.FVar1;
			cp.FVar2 = info.FVar2;
			cp.VarAttr1 = info.VarAttr1;
			cp.VarAttr2 = info.VarAttr2;
			listCopy.add(cp);
		}
		
		return listCopy;
	}
	
	
	public TypeChecker(ArrayList<Feature> featList, ArrayList<FeatureVariable> assumptionList)
	{
		if ( featList != null )
		{
			m_featureList = featList;
		}
		else
		{
			m_featureList = new ArrayList<Feature>();
		}
		
		if ( assumptionList != null )
		{
			m_fVarAssumptions = assumptionList;
		}
		else
		{
			m_fVarAssumptions = new ArrayList<FeatureVariable>();
		}
		
		m_compatibleVars = new ArrayList<MustBeCompatibleFVars>();
	}
	
	
	public ASTNode checkExpression(ArrayList<ASTNode> expression)
	{
		if ( expression == null || expression.size() <= 1 )
		{
			return null;
		}
		
		int i, type1, type2;
		boolean operandOK;
		ASTNode n, n1, n2, replacement;
		
		ArrayList<ASTNode> expCopy = new ArrayList<ASTNode>();
		for (i=0; i<expression.size(); i++)
		{
			n = expression.get(i);
			expCopy.add(n);
		}
		
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
					n1 = expCopy.get(i-1);
					operandOK = nodeHasTheExpectedType(n1, Codes.AST_TYPE_NUMERIC);
					if ( !operandOK )
					{
						return n1;
					}
					
					if ( nodeHasAStaticType(n1) )
					{
						type1 = findStaticNodeType(n1);
					}
					else
					{
						type1 = findAssumedFeatureVarAttributeType(n1.featureVar, n1.attrName);
					}
					
					replacement = new ASTNode();
					replacement.type = type1;
					
					expCopy.remove(i);
					expCopy.remove(i-1);
					expCopy.add(i-1, replacement);
					
					i = 0;
					
					break;
					
				case Codes.OP_ADD:
				case Codes.OP_SUBTRACT:
				case Codes.OP_MULTIPLY:
				case Codes.OP_DIVIDE:
					n2 = expCopy.get(i-2);
					operandOK = nodeHasTheExpectedType(n2, Codes.AST_TYPE_NUMERIC);
					if ( !operandOK )
					{
						return n2;
					}
					n1 = expCopy.get(i-1);
					operandOK = nodeHasTheExpectedType(n1, Codes.AST_TYPE_NUMERIC);
					if ( !operandOK )
					{
						return n1;
					}
					
					if ( nodeHasAStaticType(n1) )
					{
						type1 = findStaticNodeType(n1);
					}
					else
					{
						type1 = findAssumedFeatureVarAttributeType(n1.featureVar, n1.attrName);
					}
					if ( nodeHasAStaticType(n2) )
					{
						type2 = findStaticNodeType(n2);
					}
					else
					{
						type2 = findAssumedFeatureVarAttributeType(n2.featureVar, n2.attrName);
					}
					
					replacement = new ASTNode();
					if ( type1 == Codes.AST_TYPE_REAL || type2 == Codes.AST_TYPE_REAL )
					{
						replacement.type = Codes.AST_TYPE_REAL;
					}
					else if ( type1 == Codes.AST_TYPE_NUMERIC || type2 == Codes.AST_TYPE_NUMERIC )
					{
						replacement.type = Codes.AST_TYPE_NUMERIC;
					}
					else
					{
						replacement.type = Codes.AST_TYPE_INT;
					}
					
					expCopy.remove(i);
					expCopy.remove(i-1);
					expCopy.remove(i-2);
					expCopy.add(i-2, replacement);
					
					i = 0;
					
					break;
					
				case Codes.OP_MODULUS:
					n2 = expCopy.get(i-2);
					operandOK = nodeHasTheExpectedType(n2, Codes.AST_TYPE_INT);
					if ( !operandOK )
					{
						return n;
					}
					n1 = expCopy.get(i-1);
					operandOK = nodeHasTheExpectedType(n1, Codes.AST_TYPE_INT);
					if ( !operandOK )
					{
						return n;
					}
					
					replacement = new ASTNode();
					replacement.type = Codes.AST_TYPE_INT;
					
					expCopy.remove(i);
					expCopy.remove(i-1);
					expCopy.remove(i-2);
					expCopy.add(i-2, replacement);
					
					i = 0;
					
					break;
					
				case Codes.OP_NOT:
					n1 = expCopy.get(i-1);
					operandOK = nodeHasTheExpectedType(n1, Codes.AST_TYPE_BOOL);
					if ( !operandOK )
					{
						return n1;
					}
					
					replacement = new ASTNode();
					replacement.type = Codes.AST_TYPE_BOOL;
					
					expCopy.remove(i);
					expCopy.remove(i-1);
					expCopy.add(i-1, replacement);
					
					i = 0;
					
					break;
					
				case Codes.OP_AND:
				case Codes.OP_OR:
					n2 = expCopy.get(i-2);
					operandOK = nodeHasTheExpectedType(n2, Codes.AST_TYPE_BOOL);
					if ( !operandOK )
					{
						return n2;
					}
					n1 = expCopy.get(i-1);
					operandOK = nodeHasTheExpectedType(n1, Codes.AST_TYPE_BOOL);
					if ( !operandOK )
					{
						return n1;
					}
					
					replacement = new ASTNode();
					replacement.type = Codes.AST_TYPE_BOOL;
					
					expCopy.remove(i);
					expCopy.remove(i-1);
					expCopy.remove(i-2);
					expCopy.add(i-2, replacement);
					
					i = 0;
					
					break;
					
				case Codes.OP_LT:
				case Codes.OP_LTE:
				case Codes.OP_GT:
				case Codes.OP_GTE:
					n2 = expCopy.get(i-2);
					operandOK = nodeHasTheExpectedType(n2, Codes.AST_TYPE_NUMERIC);
					if ( !operandOK )
					{
						return n2;
					}
					n1 = expCopy.get(i-1);
					operandOK = nodeHasTheExpectedType(n1, Codes.AST_TYPE_NUMERIC);
					if ( !operandOK )
					{
						return n1;
					}
					
					replacement = new ASTNode();
					replacement.type = Codes.AST_TYPE_BOOL;
					
					expCopy.remove(i);
					expCopy.remove(i-1);
					expCopy.remove(i-2);
					expCopy.add(i-2, replacement);
					
					i = 0;
					
					break;
					
				case Codes.OP_EQ:
				case Codes.OP_NEQ:
					n2 = expCopy.get(i-2);
					n1 = expCopy.get(i-1);
					operandOK = equivalenceCheckOperandsAreCompatible(n1, n2);
					if ( !operandOK )
					{
						if ( n1.type == Codes.AST_TYPE_FEATUREVAR )
						{
							return n1;
						}
						else
						{
							return n2;
						}
					}
					
					replacement = new ASTNode();
					replacement.type = Codes.AST_TYPE_BOOL;
					
					expCopy.remove(i);
					expCopy.remove(i-1);
					expCopy.remove(i-2);
					expCopy.add(i-2, replacement);
					
					i = 0;
					
					break;
			}
		}
		
		return null;
	}
	
	
	private boolean nodeHasTheExpectedType(ASTNode node, int expectedType)
	{
		if ( node == null )
		{
			return false;
		}
		
		int type;
		boolean itIsStatic = nodeHasAStaticType(node);
		
		if ( itIsStatic )
		{
			type = findStaticNodeType(node);
			
			if ( type == expectedType )
			{
				return true;
			}
			else if ( expectedType == Codes.AST_TYPE_NUMERIC || expectedType == Codes.AST_TYPE_REAL )
			{
				if ( type == Codes.AST_TYPE_INT || type == Codes.AST_TYPE_REAL )
				{
					return true;
				}
			}
		}
		else
		{
			type = findAssumedFeatureVarAttributeType(node.featureVar, node.attrName);
			
			if ( type == Codes._NO_VALUE_ )
			{
				addFeatureVarAttributeTypeAssumption(node.featureVar, node.attrName, expectedType);
				return true;
			}
			else if ( type == expectedType )
			{
				return true;
			}
			else if ( expectedType == Codes.AST_TYPE_NUMERIC )
			{
				if ( type == Codes.AST_TYPE_INT || type == Codes.AST_TYPE_REAL )
				{
					return true;
				}
			}
			else if ( expectedType == Codes.AST_TYPE_REAL )
			{
				if ( type == Codes.AST_TYPE_INT )
				{
					return true;
				}
				else if ( type == Codes.AST_TYPE_NUMERIC )
				{
					addFeatureVarAttributeTypeAssumption(node.featureVar, node.attrName, expectedType);
					return true;
				}
			}
			else if ( expectedType == Codes.AST_TYPE_INT )
			{
				if ( type == Codes.AST_TYPE_NUMERIC )
				{
					addFeatureVarAttributeTypeAssumption(node.featureVar, node.attrName, expectedType);
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean equivalenceCheckOperandsAreCompatible(ASTNode op1, ASTNode op2)
	{
		int typeS1, typeS2, typeA1, typeA2;
		boolean type1static, type2static;
		
		type1static = nodeHasAStaticType(op1);
		type2static = nodeHasAStaticType(op2);
		
		if ( type1static && type2static )
		{
			typeS1 = findStaticNodeType(op1);
			typeS2 = findStaticNodeType(op2);
			
			if ( typeS1 == Codes._NO_VALUE_ || typeS2 == Codes._NO_VALUE_ )
			{
				return false;
			}
			
			if ( typeS1 == typeS2 )
			{
				return true;
			}
			if ( typeS1 == Codes.AST_TYPE_REAL || typeS1 == Codes.AST_TYPE_INT || typeS1 == Codes.AST_TYPE_NUMERIC )
			{
				if ( typeS2 == Codes.AST_TYPE_REAL || typeS2 == Codes.AST_TYPE_INT || typeS2 == Codes.AST_TYPE_NUMERIC )
				{
					return true;
				}
			}
			
			return false;
		}
		else if ( type1static )
		{
			typeS1 = findStaticNodeType(op1);
			typeA2 = findAssumedFeatureVarAttributeType(op2.featureVar, op2.attrName);
			
			if ( typeS1 == Codes._NO_VALUE_ )
			{
				return false;
			}
			
			if ( typeA2 == Codes._NO_VALUE_ )
			{
				if ( typeS1 == Codes.AST_TYPE_INT || typeS1 == Codes.AST_TYPE_REAL || typeS1 == Codes.AST_TYPE_NUMERIC )
				{
					addFeatureVarAttributeTypeAssumption(op2.featureVar, op2.attrName, Codes.AST_TYPE_NUMERIC);
				}
				else
				{
					addFeatureVarAttributeTypeAssumption(op2.featureVar, op2.attrName, typeS1);
				}
				
				return true;
			}
			
			if ( typeS1 == typeA2 )
			{
				return true;
			}
			
			if ( typeS1 == Codes.AST_TYPE_INT || typeS1 == Codes.AST_TYPE_REAL || typeS1 == Codes.AST_TYPE_NUMERIC )
			{
				if ( typeA2 == Codes.AST_TYPE_INT || typeA2 == Codes.AST_TYPE_REAL || typeA2 == Codes.AST_TYPE_NUMERIC )
				{
					return true;
				}
			}
			
			return false;
		}
		else if ( type2static )
		{
			typeA1 = findAssumedFeatureVarAttributeType(op1.featureVar, op1.attrName);
			typeS2 = findStaticNodeType(op2);
			
			if ( typeS2 == Codes._NO_VALUE_ )
			{
				return false;
			}
			
			if ( typeA1 == Codes._NO_VALUE_ )
			{
				if ( typeS2 == Codes.AST_TYPE_INT || typeS2 == Codes.AST_TYPE_REAL || typeS2 == Codes.AST_TYPE_NUMERIC )
				{
					addFeatureVarAttributeTypeAssumption(op1.featureVar, op1.attrName, Codes.AST_TYPE_NUMERIC);
				}
				else
				{
					addFeatureVarAttributeTypeAssumption(op1.featureVar, op1.attrName, typeS2);
				}
				
				return true;
			}
			
			if ( typeA1 == typeS2 )
			{
				return true;
			}
			
			if ( typeS2 == Codes.AST_TYPE_INT || typeS2 == Codes.AST_TYPE_REAL || typeS2 == Codes.AST_TYPE_NUMERIC )
			{
				if ( typeA1 == Codes.AST_TYPE_INT || typeA1 == Codes.AST_TYPE_REAL || typeA1 == Codes.AST_TYPE_NUMERIC )
				{
					return true;
				}
			}
			
			return false;
		}
		else
		{
			typeA1 = findAssumedFeatureVarAttributeType(op1.featureVar, op1.attrName);
			typeA2 = findAssumedFeatureVarAttributeType(op2.featureVar, op2.attrName);
			
			if ( typeA1 == Codes._NO_VALUE_ && typeA2 == Codes._NO_VALUE_ )
			{
				MustBeCompatibleFVars compatInfo = new MustBeCompatibleFVars();
				compatInfo.FVar1 = op1.featureVar;
				compatInfo.VarAttr1 = op1.attrName;
				compatInfo.FVar2 = op2.featureVar;
				compatInfo.VarAttr2 = op2.attrName;
				m_compatibleVars.add(compatInfo);
				return true;
			}
			else if ( typeA1 == Codes._NO_VALUE_ )
			{
				if ( typeA2 == Codes.AST_TYPE_INT || typeA2 == Codes.AST_TYPE_REAL || typeA2 == Codes.AST_TYPE_NUMERIC )
				{
					addFeatureVarAttributeTypeAssumption(op1.featureVar, op1.attrName, Codes.AST_TYPE_NUMERIC);
				}
				else
				{
					addFeatureVarAttributeTypeAssumption(op1.featureVar, op1.attrName, typeA2);
				}
				
				return true;
			}
			else if ( typeA2 == Codes._NO_VALUE_ )
			{
				if ( typeA1 == Codes.AST_TYPE_INT || typeA1 == Codes.AST_TYPE_REAL || typeA1 == Codes.AST_TYPE_NUMERIC )
				{
					addFeatureVarAttributeTypeAssumption(op2.featureVar, op2.attrName, Codes.AST_TYPE_NUMERIC);
				}
				else
				{
					addFeatureVarAttributeTypeAssumption(op2.featureVar, op2.attrName, typeA1);
				}
				
				return true;
			}
			else
			{
				if ( typeA1 == typeA2)
				{
					return true;
				}
				else if ( typeA1 == Codes.AST_TYPE_INT || typeA1 == Codes.AST_TYPE_REAL || typeA1 == Codes.AST_TYPE_NUMERIC )
				{
					if ( typeA2 == Codes.AST_TYPE_INT || typeA2 == Codes.AST_TYPE_REAL || typeA2 == Codes.AST_TYPE_NUMERIC )
					{
						return true;
					}
				}
				
				return false;
			}
		}
	}
	
	
	private boolean nodeHasAStaticType(ASTNode node)
	{
		if ( node.type == Codes.AST_TYPE_FEATUREVAR )
		{
			if ( node.attrName.equals("_name") || node.attrName.equals("_parent") || node.attrName.equals("_decomp") || node.attrName.equals("_decompID") )
			{
				return true;
			}
			
			return false;
		}
		
		return true;
	}
	
	private int findStaticNodeType(ASTNode node)
	{
		if ( node == null )
		{
			return Codes._NO_VALUE_;
		}
		
		if ( node.type == Codes.AST_TYPE_FEATURE )
		{
			if ( node.attrName.equals("_name") || node.attrName.equals("_parent") )
			{
				return Codes.AST_TYPE_STRING;
			}
			else if ( node.attrName.equals("_decomp") )
			{
				return Codes.AST_TYPE_DECRELTYPE;
			}
			else if ( node.attrName.equals("_decompID") )
			{
				return Codes.AST_TYPE_DECRELID;
			}
			
			return findFeatureAttributeType(node.featureName, node.attrName);
		}
		else if ( node.type == Codes.AST_TYPE_FEATUREVAR )
		{
			if ( node.attrName.equals("_name") || node.attrName.equals("_parent") )
			{
				return Codes.AST_TYPE_STRING;
			}
			else if ( node.attrName.equals("_decomp") )
			{
				return Codes.AST_TYPE_DECRELTYPE;
			}
			else if ( node.attrName.equals("_decompID") )
			{
				return Codes.AST_TYPE_DECRELID;
			}
			
			return Codes._NO_VALUE_;
		}
		
		return node.type;
	}
	

	private int findFeatureAttributeType(String featName, String attrName)
	{
		if ( featName == null || featName == "" || attrName == null || attrName == "" )
		{
			return Codes._NO_VALUE_;
		}
		
		if ( m_featureList == null || m_featureList.size() == 0 )
		{
			return Codes._NO_VALUE_;
		}
		
		int i, j;
		Feature feat;
		Attribute attr;
		
		for (i=0; i<m_featureList.size(); i++)
		{
			feat = m_featureList.get(i);
			if ( featName.equalsIgnoreCase(feat._name) )
			{
				if ( attrName.equals("_name") || attrName.equals("_parent") )
				{
					return Codes.AST_TYPE_STRING;
				}
				else if ( attrName.equals("_decomp") )
				{
					return Codes.AST_TYPE_DECRELTYPE;
				}
				else if ( attrName.equals("_decompID") )
				{
					return Codes.AST_TYPE_DECRELID;
				}
				
				if ( feat.attributes == null || feat.attributes.size() == 0 )
					return Codes._NO_VALUE_;
				
				for (j=0; j<feat.attributes.size(); j++)
				{
					attr = feat.attributes.get(j);
					if ( attrName.equals(attr.name) )
					{
						switch ( attr.type )
						{
							case Codes.TYPE_INT   : return Codes.AST_TYPE_INT;
							case Codes.TYPE_REAL  : return Codes.AST_TYPE_REAL;
							case Codes.TYPE_BOOL  : return Codes.AST_TYPE_BOOL;
							case Codes.TYPE_STRING: return Codes.AST_TYPE_STRING;
							default               : return Codes._NO_VALUE_;
						}
					}
				}
				
				return Codes._NO_VALUE_;
			}
		}
		
		return Codes._NO_VALUE_;
	}
	
	private int findAssumedFeatureVarAttributeType(String fvar, String attr)
	{
		if ( fvar == null || fvar == "" || attr == null || attr == "" )
		{
			return Codes._NO_VALUE_;
		}
		
		int i, j;
		FeatureVariable tmpFV;
		VariableAttribute tmpVA;
		
		for (i=0; i<m_fVarAssumptions.size(); i++)
		{
			tmpFV = m_fVarAssumptions.get(i);
			if ( fvar.equals(tmpFV.name) )
			{
				if ( tmpFV.otherAttributes == null || tmpFV.otherAttributes.size() == 0 )
					return Codes._NO_VALUE_;
				
				for (j=0; j<tmpFV.otherAttributes.size(); j++)
				{
					tmpVA = tmpFV.otherAttributes.get(j);
					if ( attr.equals(tmpVA.name) )
					{
						return tmpVA.assumedType;
					}
				}
				
				return Codes._NO_VALUE_;
			}
		}
		
		return Codes._NO_VALUE_;
	}
	
	private void addFeatureVarAttributeTypeAssumption(String fvar, String attr, int type)
	{
		if ( fvar == null || fvar == "" || attr == null || attr == "" )
		{
			return;
		}
		if ( type != Codes.AST_TYPE_INT && type != Codes.AST_TYPE_REAL && type != Codes.AST_TYPE_NUMERIC && type != Codes.AST_TYPE_BOOL && type != Codes.AST_TYPE_STRING )
		{
			return;
		}
		
		// before starting, find all compatibility info for this feature variable attribute
		ArrayList<String> compatFVarList = new ArrayList<String>();
		ArrayList<String> compatAttrList = new ArrayList<String>();
		MustBeCompatibleFVars info;
		
		compatFVarList.add(fvar);
		compatAttrList.add(attr);
		
		int i, counter=0;
		String fVarToCheck, attrToCheck;
		
		while ( counter < compatFVarList.size() )
		{
			fVarToCheck = compatFVarList.get(counter);
			attrToCheck = compatAttrList.get(counter);
			
			for (i=0; i<m_compatibleVars.size(); i++)
			{
				info = m_compatibleVars.get(i);
				
				if ( fVarToCheck.equals(info.FVar1) && attrToCheck.equals(info.VarAttr1) )
				{
					compatFVarList.add(info.FVar2);
					compatAttrList.add(info.VarAttr2);
					
					m_compatibleVars.remove(info);
					i--;
				}
				else if ( fVarToCheck.equals(info.FVar2) && attrToCheck.equals(info.VarAttr2) )
				{
					compatFVarList.add(info.FVar1);
					compatAttrList.add(info.VarAttr1);
					
					m_compatibleVars.remove(info);
					i--;
				}
			}
			
			counter++;
		}
		
		// then add assumption info for all these feature variable attributes
		for (i=0; i<compatFVarList.size(); i++)
		{
			addAssumption(compatFVarList.get(i), compatAttrList.get(i), type);
		}
	}
	
	private void addAssumption(String fvar, String attr, int type)
	{
		if ( fvar == null || fvar == "" || attr == null || attr == "" )
		{
			return;
		}
		if ( type != Codes.AST_TYPE_INT && type != Codes.AST_TYPE_REAL && type != Codes.AST_TYPE_NUMERIC && type != Codes.AST_TYPE_BOOL && type != Codes.AST_TYPE_STRING )
		{
			return;
		}
		
		int i, j;
		FeatureVariable tmpFV;
		VariableAttribute tmpVA;
		
		// first add this feature attribute's assumption
		for (i=0; i<m_fVarAssumptions.size(); i++)
		{
			tmpFV = m_fVarAssumptions.get(i);
			if ( fvar.equals(tmpFV.name) )  // the feature variable that has the attribute
			{
				if ( tmpFV.otherAttributes == null || tmpFV.otherAttributes.size() == 0 ) // if the feature variable has no assumptions recorded yet
				{
					tmpFV.otherAttributes = new ArrayList<VariableAttribute>();
					tmpVA = new VariableAttribute();
					tmpVA.name = attr;
					tmpVA.assumedType = type;
					tmpFV.otherAttributes.add(tmpVA);
					return;
				}
				
				for (j=0; j<tmpFV.otherAttributes.size(); j++) // if there's an assumption for this attribute already
				{
					tmpVA = tmpFV.otherAttributes.get(j);
					if ( attr.equals(tmpVA.name) )
					{
						tmpVA.assumedType = type;
						return;
					}
				}
				
				tmpVA = new VariableAttribute(); // if the feature variable has an assumption, but the attribute does not yet
				tmpVA.name = attr;
				tmpVA.assumedType = type;
				tmpFV.otherAttributes.add(tmpVA);
				return;
			}
		}
		
		tmpFV = new FeatureVariable(); // if the feature variable does not have an assumption yet
		tmpFV.name = fvar;
		tmpFV.otherAttributes = new ArrayList<VariableAttribute>();
		tmpVA = new VariableAttribute();
		tmpVA.name = attr;
		tmpVA.assumedType = type;
		tmpFV.otherAttributes.add(tmpVA);
		m_fVarAssumptions.add(tmpFV);
	}
}

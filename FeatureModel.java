import java.util.ArrayList;


/** *******************************************************************************************
 * FeatureModel
 * --------------------------------------------------------------------------------------------
 * @author Ahmet Serkan Karatas
 *
 ** ******************************************************************************************* */
class FeatureModel
{
	private Feature tree;
	private ArrayList<Feature> featureList;
	private ArrayList<CrossTreeConstraint> constraintList;
	private int m_nextIDNo;
	private int m_nextRelID;

	
	public FeatureModel()
	{
		tree           = null;
		featureList    = new ArrayList<Feature>();
		constraintList = new ArrayList<CrossTreeConstraint>();
		
		m_nextIDNo  = 2;
		m_nextRelID = 1;
	}
	
	
	public Feature getFeatureDiagram()
	{
		int i, j, k, idNo;
		ArrayList<Feature> listCopy = new ArrayList<Feature>();
		Feature feat, cp, cp2;
		
		for (i=0; i<featureList.size(); i++)
		{
			feat = featureList.get(i);
			
			cp = new Feature();
			cp.idNo        = feat.idNo;
			cp._name       = feat._name;
			cp._parentIDNo = feat._parentIDNo;
			cp._decomp     = feat._decomp;
			cp._decompID   = feat._decompID;
			for (j=0; j<feat.attributes.size(); j++)
			{
				cp.attributes.add(feat.attributes.get(j).clone());
			}
			
			listCopy.add(cp);
		}
		
		for (i=0; i<listCopy.size(); i++)
		{
			feat = featureList.get(i);
			cp   = listCopy.get(i);
			
			for (j=0; j<feat.children.size(); j++)
			{
				idNo = feat.children.get(j).idNo;
				for (k=0; k<listCopy.size(); k++)
				{
					cp2 = listCopy.get(k);
					if ( idNo == cp2.idNo )
					{
						cp.children.add(cp2);
						break;
					}
				}
			}
		}
		
		return listCopy.get(0);
	}
	
	public ArrayList<Feature> getFeatureList()
	{
		int i, j;
		ArrayList<Feature> listCopy = new ArrayList<Feature>();
		Feature feat, cp;
		
		for (i=0; i<featureList.size(); i++)
		{
			feat = featureList.get(i);
			
			cp = new Feature();
			cp.idNo        = feat.idNo;
			cp._name       = feat._name;
			cp._parentIDNo = feat._parentIDNo;
			cp._decomp     = feat._decomp;
			cp._decompID   = feat._decompID;
			for (j=0; j<feat.attributes.size(); j++)
			{
				cp.attributes.add(feat.attributes.get(j).clone());
			}
			
			listCopy.add(cp);
		}
		
		return listCopy;
	}
	
	public ArrayList<CrossTreeConstraint> getCrossTreeConstraintList()
	{
		CrossTreeConstraint ctc;
		ArrayList<CrossTreeConstraint> tmp = new ArrayList<CrossTreeConstraint>();
		
		for (int i=0; i<constraintList.size(); i++)
		{
			ctc = constraintList.get(i).clone();
			tmp.add(ctc);
		}
		
		return tmp;
	}
	

	public boolean setRoot(RawFeature root)
	{
		if ( root == null )
		{
			return false;
		}
		if ( root._name == null || root._name == "" )
		{
			return false;
		}
		
		tree = new Feature();
		tree.idNo        = 1;
		tree._name       = root._name;
		tree._parentIDNo = Codes._NO_VALUE_;
		tree._decomp     = Codes._NO_VALUE_;
		tree._decompID   = Codes._NO_VALUE_;
		tree.children    = new ArrayList<Feature>();
		
		if ( root.attributes == null )
		{
			tree.attributes = new ArrayList<Attribute>();
		}
		else
		{
			tree.attributes  = root.attributes;
		}
		
		featureList.add(tree);
		
		return true;
	}
	
	public DeclarationError addFeaturesFromDeclarations(ArrayList<RawFeature> rawFList)
	{
		DeclarationError result = new DeclarationError();
		result.errorCode       = ErrorCodes.NO_ERROR;
		result.erronousFeature = null;
		
		if ( tree == null )
		{
			result.errorCode = ErrorCodes.ROOT_NOT_SET;
			return result;
		}
		
		if ( rawFList == null || rawFList.size() == 0 )
		{
			return result;
		}
		
		ArrayList<RawFeature> listForRelIDs = new ArrayList<RawFeature>(rawFList);
		RawFeature rf;
		Feature parent, newFeature;
		int i = 0, j;
		
		while ( i < rawFList.size() )
		{
			rf = rawFList.get(i);
			if ( rf == null )
			{
				rawFList.remove(i);
				continue;
			}
			if ( rf.attributes == null )
			{
				rf.attributes = new ArrayList<Attribute>();
			}
			
			if ( rf._parent == null || rf._parent == "" )
			{
				result.errorCode = ErrorCodes.PARENT_NOT_FOUND;
				result.erronousFeature = rawFList.get(i);
				return result;
			}
			
			parent = findFeature(rf._parent);
			if ( parent != null )
			{
				if ( rf._name == null || rf._name == "" )
				{
					result.errorCode       = ErrorCodes.MISSING_INFO_IN_RAW_FEATURE;
					result.erronousFeature = rf;
					return result;
				}
				
				if ( rf._decomp != Codes.MANDATORY && rf._decomp != Codes.OPTIONAL && rf._decomp != Codes.ALTERNATIVE && rf._decomp != Codes.OR )
				{
					result.errorCode       = ErrorCodes.MISSING_INFO_IN_RAW_FEATURE;
					result.erronousFeature = rf;
					return result;
				}
				
				if ( rf._parent == null || rf._parent == "" )
				{
					result.errorCode       = ErrorCodes.NEW_ROOT_CANNOT_BE_ADDED;
					result.erronousFeature = rf;
					return result;
				}
				
				if ( featureNameInUse(rf._name) )
				{
					result.errorCode       = ErrorCodes.FEATURE_NAME_IN_USE;
					result.erronousFeature = rf;
					return result;
				}
				
				newFeature = new Feature();
				newFeature.idNo        = m_nextIDNo++;
				newFeature._name       = rf._name;
				newFeature._parentIDNo = parent.idNo;
				newFeature._decomp     = rf._decomp;
				newFeature._decompID   = Codes._NO_VALUE_;
				newFeature.attributes  = rf.attributes;
				newFeature.children    = new ArrayList<Feature>();
				
				parent.children.add(newFeature);
				
				featureList.add(newFeature);
				
				rawFList.remove(i);
				i = 0;
			}
			else
			{
				i++;
			}
		}
		
		if ( rawFList.size() > 0 )
		{
			for (i=0; i<rawFList.size(); i++)
			{
				rf = rawFList.get(i);
				
				for (j=0; j<rawFList.size(); j++)
				{
					if ( rf._parent.equalsIgnoreCase(rawFList.get(j)._name) )
					{
						result.errorCode = ErrorCodes.CYCLE_IN_FEATURE_DECLARATIONS;
						result.erronousFeature = new RawFeature();
						return result;
					}
				}
			}
			
			result.errorCode       = ErrorCodes.PARENT_NOT_FOUND;
			result.erronousFeature = rawFList.get(0);
			return result;
		}

		Feature feature, sibling;
		for (i=0; i<listForRelIDs.size(); i++)
		{
			rf = listForRelIDs.get(i);
			if ( rf == null )
			{
				listForRelIDs.remove(i);
				i--;
				continue;
			}
			
			if ( rf._decomp == Codes.MANDATORY || rf._decomp == Codes.OPTIONAL )
			{
				continue;
			}
			
			feature = findFeature(rf._name);
			if ( feature == null ) // normally should never happen
			{
				continue;
			}
			
			sibling = findFeature(rf.relSibling);
			
			if ( feature._decompID == Codes._NO_VALUE_ )
			{
				if ( sibling == null )
				{
					result.errorCode       = ErrorCodes.SIBLING_NOT_FOUND;
					result.erronousFeature = rf;
					return result;
				}
				
				if ( feature._parentIDNo != sibling._parentIDNo )
				{
					result.errorCode       = ErrorCodes.SIBLING_NOT_A_SIBLING;
					result.erronousFeature = rf;
					return result;
				}
				
				if ( feature._decomp != sibling._decomp )
				{
					result.errorCode       = ErrorCodes.INCONSISTENT_DECOMP_TYPE;
					result.erronousFeature = rf;
					return result;
				}
				
				if ( sibling._decompID == Codes._NO_VALUE_ )
				{
					feature._decompID = sibling._decompID = m_nextRelID++;
				}
				else
				{
					feature._decompID = sibling._decompID;
				}
			}
			else
			{
				if ( sibling != null )
				{
					if ( feature._decomp != sibling._decomp )
					{
						result.errorCode       = ErrorCodes.INCONSISTENT_DECOMP_TYPE;
						result.erronousFeature = rf;
						return result;
					}
					
					if ( feature._parentIDNo != sibling._parentIDNo )
					{
						result.errorCode       = ErrorCodes.SIBLING_NOT_A_SIBLING;
						result.erronousFeature = rf;
						return result;
					}
					
					sibling._decompID = feature._decompID;
				}
				else
				{
					result.errorCode       = ErrorCodes.SIBLING_NOT_FOUND;
					result.erronousFeature = rf;
					return result;
				}
			}
		}
		
		return result;
	}
	
	public DeclarationError addConstraintsFromDeclarations(ArrayList<RawCrossTreeConstraint> rawCList)
	{
		DeclarationError result = new DeclarationError();
		result.errorCode       = ErrorCodes.NO_ERROR;
		result.erronousFeature = null;
		boolean duplicate;
		
		if ( tree == null )
		{
			result.errorCode = ErrorCodes.ROOT_NOT_SET;
			return result;
		}
		
		if ( rawCList == null || rawCList.size() == 0)
		{
			return result;
		}
		
		int i, j, fListSize;
		CrossTreeConstraint ctc, tmp;
		RawCrossTreeConstraint raw;
		Feature feat;
		fListSize = featureList.size();
		for (i=0; i<rawCList.size(); i++)
		{
			raw = rawCList.get(i);
			if ( raw == null )
			{
				rawCList.remove(i);
				i--;
				continue;
			}
			
			if ( raw.constraintType != Codes.REQUIRES && raw.constraintType != Codes.EXCLUDES )
			{
				result.errorCode = ErrorCodes.INVALID_CONSTRAINT_TYPE;
				return result;
			}
			if ( raw.leftFeature == null || raw.leftFeature == "" )
			{
				result.errorCode = ErrorCodes.LEFT_FEATURE_NOT_FOUND;
				result.erronousFeature = new RawFeature();
				result.erronousFeature._name = raw.leftFeature;
				return result;
			}
			if ( raw.rightFeature == null || raw.rightFeature == "" )
			{
				result.errorCode = ErrorCodes.RIGHT_FEATURE_NOT_FOUND;
				result.erronousFeature = new RawFeature();
				result.erronousFeature._name = raw.rightFeature;
				return result;
			}
			
			ctc = new CrossTreeConstraint();
			ctc.leftFeature    = raw.leftFeature;
			ctc.rightFeature   = raw.rightFeature;
			ctc.constraintType = raw.constraintType;
			
			for (j=0; j<fListSize; j++)
			{
				feat = featureList.get(j);
				if ( ctc.leftFeature.equalsIgnoreCase(feat._name) )
				{
					ctc.leftIDNo = feat.idNo;
					break;
				}
			}
			if ( j == fListSize )
			{
				result.errorCode = ErrorCodes.LEFT_FEATURE_NOT_FOUND;
				result.erronousFeature = new RawFeature();
				result.erronousFeature._name = ctc.leftFeature;
				
				return result;
			}
			
			for (j=0; j<fListSize; j++)
			{
				feat = featureList.get(j);
				if ( ctc.rightFeature.equalsIgnoreCase(feat._name) )
				{
					ctc.rightIDNo = feat.idNo;
					break;
				}
			}
			if ( j == fListSize )
			{
				result.errorCode = ErrorCodes.RIGHT_FEATURE_NOT_FOUND;
				result.erronousFeature = new RawFeature();
				result.erronousFeature._name = ctc.rightFeature;
				
				return result;
			}
			
			duplicate = false;
			for (j=0; j<constraintList.size(); j++)
			{
				tmp = constraintList.get(j);
				if ( ctc.leftIDNo == tmp.leftIDNo && ctc.constraintType == tmp.constraintType && ctc.rightIDNo == tmp.rightIDNo )
				{
					duplicate = true;
					break;
				}
				if ( ctc.constraintType == Codes.EXCLUDES && tmp.constraintType == Codes.EXCLUDES )
				{
					if ( ctc.leftIDNo == tmp.rightIDNo && ctc.rightIDNo == tmp.leftIDNo )
					{
						duplicate = true;
						break;
					}
				}
			}
			
			if ( duplicate )
			{
				continue;
			}
			
			constraintList.add(ctc);
		}
		
		return result;
	}
	
	
	public int addAFeature(RawFeature rf)
	{
		if ( tree == null )
		{
			return ErrorCodes.ROOT_NOT_SET;
		}
		
		if ( rf == null )
		{
			return ErrorCodes.NO_ERROR;
		}
		if ( rf.attributes == null )
		{
			rf.attributes = new ArrayList<Attribute>();
		}
		
		if ( rf._name == null || rf._name == "" )
		{
			return ErrorCodes.MISSING_INFO_IN_RAW_FEATURE;
		}
		
		if ( rf._decomp != Codes.MANDATORY && rf._decomp != Codes.OPTIONAL && rf._decomp != Codes.ALTERNATIVE && rf._decomp != Codes.OR )
		{
			return ErrorCodes.MISSING_INFO_IN_RAW_FEATURE;
		}
		
		if ( rf._parent == null || rf._parent == "" )
		{
			return ErrorCodes.NEW_ROOT_CANNOT_BE_ADDED;
		}
		
		if ( featureNameInUse(rf._name) )
		{
			return ErrorCodes.FEATURE_NAME_IN_USE;
		}
		
		Feature parent, feat;
		
		parent = findFeature(rf._parent);
		if ( parent == null )
		{
			return ErrorCodes.PARENT_NOT_FOUND;
		}
		
		feat = new Feature();
		feat._name       = rf._name;
		feat._parentIDNo = parent.idNo;
		feat._decomp     = rf._decomp;
		feat.attributes  = rf.attributes;
		feat.children    = new ArrayList<>();
		
		feat._decompID = Codes._NO_VALUE_;
		if ( feat._decomp == Codes.ALTERNATIVE || feat._decomp == Codes.OR )
		{
			if ( rf.relSibling == null || rf.relSibling == "" )
			{
				feat._decompID = m_nextRelID++;
			}
			else
			{
				Feature sibling = findFeature(rf.relSibling);
				if ( sibling == null )
				{
					return ErrorCodes.SIBLING_NOT_FOUND;
				}
				
				if ( feat._parentIDNo != sibling._parentIDNo )
				{
					return ErrorCodes.SIBLING_NOT_A_SIBLING;
				}
				else if ( feat._decomp != sibling._decomp )
				{
					return ErrorCodes.INCONSISTENT_DECOMP_TYPE;
				}
				feat._decompID = sibling._decompID;
			}
		}
		
		feat.idNo = m_nextIDNo++;
		
		parent.children.add(feat);
		
		featureList.add(feat);
		
		return ErrorCodes.NO_ERROR;
	}
	
	public UpdateFeatureError updateAFeature(String featureToBeUpdated, String newName, int newDecompType, String newRelSibling, String newParent, ArrayList<Attribute> newAttrValues)
	{
		UpdateFeatureError err = new UpdateFeatureError();

		if ( tree == null )
		{
			err.errorCode = ErrorCodes.ROOT_NOT_SET;
			return err;
		}
		
		Feature feature = findFeature(featureToBeUpdated);
		if ( feature == null )
		{
			err.errorCode = ErrorCodes.FEATURE_NOT_FOUND;
			return err;
		}
		
		// before anything else, check if there's a problem in the updates
		// (done first, in order to avoid the need for rollback)
		
		if ( newName != null && newName != "" )
		{
			if ( featureNameInUse(newName) )
			{
				err.errorCode = ErrorCodes.FEATURE_NAME_IN_USE;
				return err;
			}
		}
		
		boolean rootToBeUpdated = tree._name.equalsIgnoreCase(featureToBeUpdated);
		if ( newDecompType == Codes.MANDATORY || newDecompType == Codes.OPTIONAL || newDecompType == Codes.OR || newDecompType == Codes.ALTERNATIVE )
		{
			if ( rootToBeUpdated )
			{
				err.errorCode = ErrorCodes.DECOMP_TYPE_OF_ROOT_CANNOT_BE_UPDATED;
				return err;
			}
			if ( newDecompType == Codes.OR || newDecompType == Codes.ALTERNATIVE )
			{
				if ( newRelSibling != null && newRelSibling != "" )
				{
					Feature relSibling = findFeature(newRelSibling);
					if ( relSibling == null )
					{
						err.errorCode = ErrorCodes.SIBLING_NOT_FOUND;
						return err;
					}
					if ( newParent == null && feature._parentIDNo != relSibling._parentIDNo )
					{
						err.errorCode = ErrorCodes.SIBLING_NOT_A_SIBLING;
						return err;
					}
					else if ( newParent != null )
					{
						Feature pnew = findFeature(newParent);
						if ( pnew.idNo != relSibling._parentIDNo )
						{
							err.errorCode = ErrorCodes.SIBLING_NOT_A_SIBLING;
							return err;
						}
					}
					if ( newDecompType != relSibling._decomp )
					{
						err.errorCode = ErrorCodes.INCONSISTENT_DECOMP_TYPE;
						return err;
					}
				}
			}
		}
		
		if ( newParent != null && newParent != "" )
		{
			if ( rootToBeUpdated )
			{
				err.errorCode = ErrorCodes.LOCATION_OF_ROOT_CANNOT_BE_UPDATED;
				return err;
			}
			if ( featureIsADescendant(feature, newParent) )
			{
				err.errorCode = ErrorCodes.PARENT_CANNOT_BE_A_DESCENDANT;
				return err;
			}
			Feature parent_old, parent_new;
			parent_old = findParent(feature._name);
			if ( parent_old == null )
			{
				err.errorCode = ErrorCodes.OLD_PARENT_NOT_FOUND;
				return err;
			}
			parent_new = findFeature(newParent);
			if ( parent_new == null )
			{
				err.errorCode = ErrorCodes.NEW_PARENT_NOT_FOUND;
				return err;
			}
		}
		
		int i, j;
		Attribute attr, attrWithNewVal;
		
		if ( newAttrValues != null && newAttrValues.size() > 0 )
		{
			boolean found;
			for (i=0; i < newAttrValues.size(); i++)
			{
				attrWithNewVal = newAttrValues.get(i);
				found = false;
				for (j=0; j < feature.attributes.size(); j++)
				{
					attr = feature.attributes.get(j);
					if ( attr.name.equalsIgnoreCase(attrWithNewVal.name) )
					{
						found = true;
						break;
					}
				}
				if ( !found )
				{
					err.errorCode = ErrorCodes.ATTRIBUTE_NOT_FOUND;
					err.erronousAttribute = attrWithNewVal.name;
					return err;
				}
			}
		}
		
		// at this point command is verified and can be applied
		
		int originalDecompType = feature._decomp;
		
		// if name of the feature is updated
		if ( newName != null && newName != "" )
		{
			feature._name = newName;
			
			CrossTreeConstraint ctc;
			for (i=0; i<constraintList.size(); i++)
			{
				ctc = constraintList.get(i);
				
				if ( feature.idNo == ctc.leftIDNo )
				{
					ctc.leftFeature = feature._name;
				}
				if ( feature.idNo == ctc.rightIDNo )
				{
					ctc.rightFeature = feature._name;
				}
			}
		}
		
		// if decomposition relation of the feature is updated
		if ( newDecompType == Codes.MANDATORY || newDecompType == Codes.OPTIONAL || newDecompType == Codes.OR || newDecompType == Codes.ALTERNATIVE )
		{
			feature._decomp = newDecompType;
			
			if ( newDecompType == Codes.OR || newDecompType == Codes.ALTERNATIVE )
			{
				if ( newRelSibling != null && newRelSibling != "" )
				{
					Feature relSibling = findFeature(newRelSibling);
					feature._decompID = relSibling._decompID;
				}
				else
				{
					feature._decompID = m_nextRelID++;
				}
			}
			else
			{
				feature._decompID = Codes._NO_VALUE_;
			}
		}
		
		// if location of the feature is updated
		if ( newParent != null && newParent != "" )
		{
			if ( (originalDecompType == Codes.ALTERNATIVE || originalDecompType == Codes.OR) && newDecompType == Codes._NO_VALUE_ )
			{
				feature._decompID = m_nextRelID++;
			}
			
			Feature parent_old, parent_new;
			parent_old = findParent(feature._name);
			parent_new = findFeature(newParent);
			
			feature._parentIDNo = parent_new.idNo;
			
			parent_new.children.add(feature);
			parent_old.children.remove(feature);
		}
		
		// if one or more attributes of the feature is updated
		if ( newAttrValues != null && newAttrValues.size() > 0 )
		{
			for (i=0; i < newAttrValues.size(); i++)
			{
				attrWithNewVal = newAttrValues.get(i);
				for (j=0; j < feature.attributes.size(); j++)
				{
					attr = feature.attributes.get(j);
					if ( attr.name.equalsIgnoreCase(attrWithNewVal.name) )
					{
						feature.attributes.remove(attr);
						feature.attributes.add(attrWithNewVal.clone());
						break;
					}
				}
			}
		}
		
		err.errorCode = ErrorCodes.NO_ERROR;
		return err;
	}
	
	public UpdateFeatureError[] updateMultipleFeatures(ArrayList<String> featList, int newDecompType, String newRelSibling, String newParent, ArrayList<Attribute> newAttrValues)
	{
		if ( featList == null || featList.size() == 0 )
		{
			return null;
		}
		
		UpdateFeatureError[] results = new UpdateFeatureError[featList.size()];
		String featName;
		for (int i=0; i<featList.size(); i++)
		{
			featName = featList.get(i);
			results[i] = updateAFeature(featName, null, newDecompType, newRelSibling, newParent, newAttrValues);
		}
			
		return results;
	}

	public int removeAFeature(String featureToBeRemoved)
	{
		if ( tree == null )
		{
			return ErrorCodes.ROOT_NOT_SET;
		}
		
		if ( featureToBeRemoved == null || featureToBeRemoved == "" )
		{
			return ErrorCodes.NO_ERROR;
		}
		
		Feature feature = findFeature(featureToBeRemoved);
		if ( feature == null )
		{
			return ErrorCodes.FEATURE_NOT_FOUND;
		}
		if ( feature.idNo == 1 )
		{
			return ErrorCodes.ROOT_CANNOT_BE_REMOVED;
		}
		
		Feature parent = findParent(featureToBeRemoved);
		if ( parent == null ) // normally should not happen
		{
			return ErrorCodes.PARENT_NOT_FOUND;
		}
		
		removeSubTree(feature);
		parent.children.remove(feature);
		
		return ErrorCodes.NO_ERROR;
	}
	
	public int[] removeMultipleFeatures(ArrayList<String> featList)
	{
		if ( featList == null || featList.size() == 0 )
		{
			return null;
		}
		
		int[] results = new int[featList.size()];
		String featName;
		for (int i=0; i<featList.size(); i++)
		{
			featName = featList.get(i);
			results[i] = removeAFeature(featName);
		}
			
		return results;
	}
	
	
	public int addAConstraint(RawCrossTreeConstraint rawCtc)
	{
		int i;
		CrossTreeConstraint ctc;
		Feature feature;
		
		
		if ( tree == null || featureList == null )
		{
			return ErrorCodes.ROOT_NOT_SET;
		}
		
		if ( rawCtc == null )
		{
			return ErrorCodes.NO_ERROR;
		}
		
		if ( rawCtc.leftFeature == null || rawCtc.leftFeature == "" )
		{
			return ErrorCodes.LEFT_FEATURE_NOT_FOUND;
		}
		if ( rawCtc.rightFeature == null || rawCtc.rightFeature == "" )
		{
			return ErrorCodes.RIGHT_FEATURE_NOT_FOUND;
		}
		if ( rawCtc.constraintType != Codes.REQUIRES && rawCtc.constraintType != Codes.EXCLUDES )
		{
			return ErrorCodes.INVALID_CONSTRAINT_TYPE;
		}
		
		ctc = new CrossTreeConstraint();
		ctc.constraintType = rawCtc.constraintType;

		feature = findFeature(rawCtc.leftFeature);
		if ( feature == null )
		{
			return ErrorCodes.LEFT_FEATURE_NOT_FOUND;
		}
		ctc.leftFeature = feature._name;
		ctc.leftIDNo    = feature.idNo;
		
		feature = findFeature(rawCtc.rightFeature);
		if ( feature == null )
		{
			return ErrorCodes.RIGHT_FEATURE_NOT_FOUND;
		}
		ctc.rightFeature = feature._name;
		ctc.rightIDNo    = feature.idNo;
		
		CrossTreeConstraint tmp;
		for (i=0; i<constraintList.size(); i++)
		{
			tmp = constraintList.get(i);
			if ( ctc.constraintType == tmp.constraintType )
			{
				if ( ctc.constraintType == Codes.REQUIRES )
				{
					if ( ctc.leftIDNo == tmp.leftIDNo && ctc.rightIDNo == tmp.rightIDNo )
					{
						return ErrorCodes.CONSTRAINT_ALREADY_EXISTS;
					}
				}
				else
				{
					if ( (ctc.leftIDNo == tmp.leftIDNo  && ctc.rightIDNo == tmp.rightIDNo) || 
						 (ctc.leftIDNo == tmp.rightIDNo && ctc.rightIDNo == tmp.leftIDNo)     )
					{
						return ErrorCodes.CONSTRAINT_ALREADY_EXISTS;
					}
				}
			}
		}
		
		constraintList.add(ctc);
		
		return ErrorCodes.NO_ERROR;
	}
	
	public int updateAConstraint(RawCrossTreeConstraint oldCtc, String newLeft, int newType, String newRight)
	{
		int i;
		CrossTreeConstraint ctc = null;
		
		
		if ( tree == null || featureList == null )
		{
			return ErrorCodes.ROOT_NOT_SET;
		}
		
		if ( oldCtc == null )
		{
			return ErrorCodes.NO_ERROR;
		}
		if ( oldCtc.leftFeature == null || oldCtc.leftFeature == "" || oldCtc.rightFeature == null || oldCtc.rightFeature == "" )
		{
			return ErrorCodes.CONSTRAINT_DOES_NOT_EXIST;
		}
		if ( oldCtc.constraintType != Codes.REQUIRES && oldCtc.constraintType != Codes.EXCLUDES )
		{
			return ErrorCodes.CONSTRAINT_DOES_NOT_EXIST;
		}
		
		if ( newType != Codes._NO_VALUE_ && newType != Codes.REQUIRES && newType != Codes.EXCLUDES )
		{
			return ErrorCodes.INVALID_CONSTRAINT_TYPE;
		}
		
		// first find the constraint to be updated
		int ctcIndex = -1;
		for (i=0; i<constraintList.size(); i++)
		{
			ctc = constraintList.get(i);
			if ( oldCtc.leftFeature.equals(ctc.leftFeature) && oldCtc.constraintType == ctc.constraintType && oldCtc.rightFeature.equals(ctc.rightFeature) )
			{
				ctcIndex = i;
				break;
			}
		}
		
		if ( i == constraintList.size() )
		{
			return ErrorCodes.CONSTRAINT_DOES_NOT_EXIST;
		}
		
		Feature left=null, right=null;
		
		if ( newLeft != null && newLeft != "" ) // this means left is to be updated
		{
			left = findFeature(newLeft);
			if ( left == null )
			{
				return ErrorCodes.LEFT_FEATURE_NOT_FOUND;
			}
		}
		
		if ( newRight != null && newRight != "" ) // this means right is to be updated
		{
			right = findFeature(newRight);
			if ( right == null )
			{
				return ErrorCodes.RIGHT_FEATURE_NOT_FOUND;
			}
		}
		
		// here everything is OK
		if ( newLeft != null && newLeft != "" )
		{
			ctc.leftFeature = newLeft;
			ctc.leftIDNo = left.idNo;
		}
		if ( newType != Codes._NO_VALUE_ )
		{
			ctc.constraintType = newType;
		}
		if ( newRight != null && newRight != "" )
		{
			ctc.rightFeature = newRight;
			ctc.rightIDNo = right.idNo;
		}
		
		// if this caused a duplicate, remove the redundant one
		CrossTreeConstraint tmp;
		for (i=0; i<constraintList.size(); i++)
		{
			if ( ctcIndex == i )
			{
				continue;
			}
			
			tmp = constraintList.get(i);
			if ( ctc.leftIDNo == tmp.leftIDNo && ctc.constraintType == tmp.constraintType && ctc.rightIDNo == tmp.rightIDNo )
			{
				constraintList.remove(i);
				break;
			}
			else if ( ctc.constraintType == Codes.EXCLUDES )
			{
				if ( ctc.leftIDNo == tmp.rightIDNo && ctc.rightIDNo == tmp.leftIDNo )
				{
					constraintList.remove(i);
					break;
				}
			}
		}
		
		return ErrorCodes.NO_ERROR;
	}
	
	public int[] updateMultipleConstraints(ArrayList<RawCrossTreeConstraint> ctcList, String newLeft, int newType, String newRight)
	{
		if ( ctcList == null || ctcList.size() == 0 )
		{
			return null;
		}
		
		int[] results = new int[ctcList.size()];
		RawCrossTreeConstraint ctc;
		for (int i=0; i<ctcList.size(); i++)
		{
			ctc = ctcList.get(i);
			results[i] = updateAConstraint(ctc, newLeft, newType, newRight);
		}
			
		return results;
	}
	
	public int removeAConstraint(RawCrossTreeConstraint rawCtc)
	{
		if ( tree == null || featureList == null )
		{
			return ErrorCodes.ROOT_NOT_SET;
		}
		
		if ( rawCtc == null )
		{
			return ErrorCodes.CONSTRAINT_DOES_NOT_EXIST;
		}
		if ( rawCtc.leftFeature == null || rawCtc.leftFeature == "" || rawCtc.rightFeature == null || rawCtc.rightFeature == "" )
		{
			return ErrorCodes.CONSTRAINT_DOES_NOT_EXIST;
		}
		if ( rawCtc.constraintType != Codes.REQUIRES && rawCtc.constraintType != Codes.EXCLUDES )
		{
			return ErrorCodes.CONSTRAINT_DOES_NOT_EXIST;
		}
		
		CrossTreeConstraint ctc;
		for (int i=0; i<constraintList.size(); i++)
		{
			ctc = constraintList.get(i);
			if ( rawCtc.constraintType == ctc.constraintType )
			{
				if ( rawCtc.constraintType == Codes.REQUIRES )
				{
					if ( rawCtc.leftFeature.equalsIgnoreCase(ctc.leftFeature) && rawCtc.rightFeature.equalsIgnoreCase(ctc.rightFeature) )
					{
						constraintList.remove(i);
						return ErrorCodes.NO_ERROR;
					}
				}
				else
				{
					if ( (rawCtc.leftFeature.equalsIgnoreCase(ctc.leftFeature)  && rawCtc.rightFeature.equalsIgnoreCase(ctc.rightFeature)) || 
						 (rawCtc.leftFeature.equalsIgnoreCase(ctc.rightFeature) && rawCtc.rightFeature.equalsIgnoreCase(ctc.leftFeature))     )
					{
						constraintList.remove(i);
						return ErrorCodes.NO_ERROR;
					}
				}
			}
		}
		
		return ErrorCodes.CONSTRAINT_DOES_NOT_EXIST;
	}
	
	public int[] removeMultipleConstraints(ArrayList<RawCrossTreeConstraint> rawList)
	{
		if ( rawList == null || rawList.size() == 0 )
		{
			return null;
		}
		
		int[] results = new int[rawList.size()];
		RawCrossTreeConstraint ctc;
		for (int i=0; i<rawList.size(); i++)
		{
			ctc = rawList.get(i);
			results[i] = removeAConstraint(ctc);
		}
		
		return results;
	}
	
	
	
	private Feature findFeature(String fname)
	{
		if ( fname == null || fname == "" || featureList == null || featureList.size() == 0 )
		{
			return null;
		}
		
		Feature f;
		for (int i=0; i<featureList.size(); i++)
		{
			f = featureList.get(i);
			if ( fname.equalsIgnoreCase(f._name) )
			{
				return f;
			}
		}
		
		return null;
	}

	private Feature findParent(String fname)
	{
		if ( fname == null || fname == "" || featureList == null || featureList.size() == 0 )
		{
			return null;
		}
		
		int i, j;
		Feature parent, child;
		for (i=0; i<featureList.size(); i++)
		{
			parent = featureList.get(i);
			for (j=0; j<parent.children.size(); j++)
			{
				child = parent.children.get(j);
				if ( fname.equalsIgnoreCase(child._name) )
				{
					return parent;
				}
			}
		}
		
		return null;
	}

	private boolean featureNameInUse(String fname)
	{
		if ( fname == null || fname.equals("") )
		{
			return true;
		}
		
		if ( featureList == null || featureList.size() == 0 )
		{
			return false;
		}
		
		Feature f;
		for (int i=0; i<featureList.size(); i++)
		{
			f = featureList.get(i);
			if ( fname.equalsIgnoreCase(f._name) )
			{
				return true;
			}
		}
		
		return false;
	}
	
	private boolean featureIsADescendant(Feature subRoot, String fname)
	{
		if ( subRoot == null || fname == null || fname == "" )
		{
			return false;
		}
		
		if ( subRoot._name.equalsIgnoreCase(fname) )
		{
			return true;
		}
		
		if ( subRoot.children == null || subRoot.children.size() == 0 )
		{
			return false;
		}
		
		for (int i=0; i<subRoot.children.size(); i++)
		{
			if ( featureIsADescendant(subRoot.children.get(i), fname) )
			{
				return true;
			}
		}
		
		return false;
	}
	
	private void removeSubTree(Feature subRoot)
	{
		if ( subRoot == null )
		{
			return;
		}
		
		autoRemoveCtcs(subRoot.idNo);
		
		if ( featureList == null )
		{
			return;
		}
		
		int i, j, idNo=subRoot.idNo;
		for (i=0; i<featureList.size(); i++)
		{
			if ( subRoot._name.equalsIgnoreCase(featureList.get(i)._name) )
			{
				idNo = featureList.get(i).idNo;
				featureList.remove(i);
				break;
			}
		}
		
		if ( tree != null && tree.idNo == idNo )
		{
			tree = null;
		}
		
		Feature f;
		for (i=0; i<featureList.size(); i++)
		{
			f = featureList.get(i);
			for (j=0; j<f.children.size(); j++)
			{
				if ( idNo == f.children.get(j).idNo )
				{
					f.children.remove(j);
					break;
				}
			}
		}
		
		if ( subRoot.children == null )
		{
			return;
		}
		
		for (i=0; i<subRoot.children.size(); i++)
		{
			removeSubTree(subRoot.children.get(i));
		}
	}
	
	private void autoRemoveCtcs(int fIDNo)
	{
		if ( constraintList == null || constraintList.size() == 0 )
		{
			return;
		}
		
		CrossTreeConstraint ctc;
		for (int i=0; i<constraintList.size(); i++)
		{
			ctc = constraintList.get(i);
			
			if ( fIDNo == ctc.leftIDNo || fIDNo == ctc.rightIDNo )
			{
				constraintList.remove(i);
				i--;
			}
		}
	}
	
}
